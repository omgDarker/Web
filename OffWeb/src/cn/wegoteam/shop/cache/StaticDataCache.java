package cn.wegoteam.shop.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.crap.base.DataUtils;
import cn.wegoteam.shop.inter.StaticdataServiceInter;
import cn.wegoteam.shop.po.Staticdata;
import cn.wegoteam.shop.util.GetReqRes;


public class StaticDataCache {
	@Autowired
	private static StaticdataServiceInter staticdataService;
	//存储所有staticdata的hashmap
	private static Map<String,Staticdata> staticdatas=new HashMap<String,Staticdata>();
	//存储 fcode+type 的所有 code
	private static Map<String,ArrayList<String>> fcodeTypes=new HashMap<String,ArrayList<String>>();
	//获取所有的staticdata的arraylist
	public void getSpringContext(){
		WebApplicationContext springContext;
		springContext = WebApplicationContextUtils
				.getWebApplicationContext(GetReqRes.getServletContext());
		if (springContext != null) {
			staticdataService = (StaticdataServiceInter) springContext
					.getBean("staticdataService");
		}
	}
		
	public static boolean clear(){
		staticdatas.clear();
		fcodeTypes.clear();
		return true;
	}
	public static ArrayList<Staticdata> getStaticdatas(String[] codes) {
		ArrayList<Staticdata> al=new ArrayList<Staticdata>();
		if(codes==null)
			return al;
		for(String code:codes){
			if(staticdatas.containsKey(code))
				al.add(staticdatas.get(code));
		}
		return al;
	}
	//根据指定的code获取单个staticdata
	public static Staticdata getStaticdata(String Code) {
		Staticdata sd=staticdatas.get(Code);
		//若缓存中没有，则需要从数据库查找，避免空指针异常
		if(sd == null){
			if(staticdataService==null){
				StaticDataCache sdc = new StaticDataCache();
				sdc.getSpringContext();
			}
			sd = staticdataService.findUniqueByHql("from Staticdata where code=:code", DataUtils.getMap("code",Code));
		}
		return sd==null?new Staticdata():sd;
	}
	
	//根据指定的code获取父staticdata
	public static Staticdata getPStaticdata(String Code) {
		try{
			return staticdatas.get(staticdatas.get(Code).getPcode());
		}catch(Exception e){
			System.out.println("根据指定的code获取父staticdata失败:StaticdataCache"+Code);
			return new Staticdata();
		}
	}
	//获取所有的fcodefcodeTypes，hashmap
	public static Map<String,ArrayList<String>> getStaticfcodeTypes() {
		return fcodeTypes;
	}
	//根据fcode+type 获取arrayList,当fcode为空时，直接根据type查询
	public static ArrayList<Staticdata> getStaticdatas(String fcode,String Type) {
		if(fcode.equals("")){
			return getStaticdatas(Type);
		}
		ArrayList<Staticdata> al=new ArrayList<Staticdata>();
		if(!fcodeTypes.containsKey(fcode+"_"+Type))
			return al;
		try{
			for(String code:fcodeTypes.get(fcode+"_"+Type)){
				al.add(staticdatas.get(code));
			}
		}catch(Exception e)
		{
			System.out.println(fcode+"_"+Type);
			e.printStackTrace();}
		return al;
	}
	//根据type 获取arrayList
		public static ArrayList<Staticdata> getStaticdatas(String Type) {
			ArrayList<Staticdata> al=new ArrayList<Staticdata>();
			try{
			for(Staticdata sd:staticdatas.values())
				if(sd.getType().equals(Type))
					al.add(sd);
			}catch(Exception e)
			{}
			return al;
		}
		
	//根据 fcode+type 获得 string a,b,c...
	public static String getStaticdataValues(String fcode, String Type) {
		StringBuilder sb=new StringBuilder();
		try{
			for(String code:fcodeTypes.get(fcode+"_"+Type))
				sb.append("'"+staticdatas.get(code).getValue()+"',");
			}
		catch(Exception e)
		{e.printStackTrace();}
		if(sb.length()>0)
			return sb.substring(0, sb.length()-1);
		return sb.toString();
	}
	//根据 fcode+type 获得子菜单的Code string a,b,c...
		public static String getStaticdataCodes(String fcode, String Type) {
			StringBuilder sb=new StringBuilder();
			try{
				for(String code:fcodeTypes.get(fcode+"_"+Type))
					sb.append("'"+staticdatas.get(code).getCode()+"',");
				}
			catch(Exception e)
			{
				return "'NO'";
			}
			if(sb.length()>0)
				return sb.substring(0, sb.length()-1);
			return sb.toString();
		}
	public static void removeStaticdata(Staticdata staticdata) {
		//移除hashmap中的staticdata
		staticdatas.remove(staticdata.getCode());
		//移除fcodeTypes中的code
		ArrayList<String> al=fcodeTypes.get(staticdata.getPcode()+"_"+staticdata.getType());
		for(int i=0;i<al.size();i++ )
		{
			if(al.get(i).equals(staticdata.getCode()))
			{
				al.remove(i);
				break;
			}
		}
		fcodeTypes.put(staticdata.getPcode()+"_"+staticdata.getType(), al);
	}
	
	
	public static void setStaticdata(Staticdata staticdata) {
		StaticDataCache.staticdatas.put(staticdata.getCode(), staticdata);
		if(fcodeTypes.get(staticdata.getPcode()+"_"+staticdata.getType())==null)
		{
			ArrayList<String> al=new ArrayList<String>();
			al.add(staticdata.getCode());
			fcodeTypes.put(staticdata.getPcode()+"_"+staticdata.getType(), al);
		}
		else
		{
			ArrayList<String> al=fcodeTypes.get(staticdata.getPcode()+"_"+staticdata.getType());
			for(int i=0;i<al.size();i++ )
			{
				if(al.get(i).equals(staticdata.getCode()))
				{
					al.remove(i);
					break;
				}
			}
			al.add(staticdata.getCode());
			fcodeTypes.put(staticdata.getPcode()+"_"+staticdata.getType(), al);
		}
	}
}
