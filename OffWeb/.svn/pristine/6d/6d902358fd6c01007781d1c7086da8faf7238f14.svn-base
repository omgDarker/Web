package cn.wegoteam.shop.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

public class GetReqRes {
	public static String getReturnUrl(){
		Map<String, String[]> map=GetReqRes.getRequest().getParameterMap();
		StringBuffer temp=new StringBuffer(GetReqRes.getRequest().getRequestURI()+"?");
		Iterator<Entry<String, String[]>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
		   Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) iter.next();
		   for(String val:entry.getValue()){
			   temp.append(entry.getKey()+"="+val+"&");
		   }
		}
		String value=temp.toString();
		if(value.endsWith("&")){
			value=value.substring(0, value.length()-1);
		}
		return temp.toString();
		
	}
	public static PrintWriter getAjaxPrintWriter(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType( "text/html" );
		response.setCharacterEncoding( "UTF-8" );
//		response.setHeader("pragma","no-cache");
//		response.setHeader("cache-control","no-cache");
//		response.setHeader("expires","0");
		PrintWriter out =null;
		try {
			out = response.getWriter();
			return out;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static HttpServletResponse getResponse(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType( "text/html" );
		response.setCharacterEncoding( "UTF-8" );
		return response;
	}
	public static HttpServletRequest getRequest(){
		HttpServletRequest request=ServletActionContext.getRequest();
		return request;
	}
	public static ServletContext getServletContext(){
		return ServletActionContext.getServletContext();
	}
	public static Map<String, Object> getSession(){
		ActionContext actionContext = ActionContext.getContext();
		return actionContext.getSession();
	}
	public static void deleteCookie(String key){
		HttpServletRequest request=GetReqRes.getRequest();
		Cookie allCookie[]= request.getCookies();
		
		if(allCookie!=null&&allCookie.length!=0)
		 {
		     for(int i=0;i<allCookie.length;i++)
		     {
		          String keyname= allCookie[i].getName();
		          if(key.equals(keyname))
		          {
		        	  HttpServletResponse response=GetReqRes.getResponse();
		        	  allCookie[i].setValue(null);
		        	  allCookie[i].setMaxAge(0);
		        	  response.addCookie(allCookie[i]);
		          }
		         
		      }
		 }
	}
	public static void addCookie(String key,String value){
		addCookie(key,value,false);
	}
	public static void addCookie(String key,String value,boolean jiami){
		if(jiami) 
			value = Aes.encrypt(value);
		else
			value =ZfmBase64.encode(value);
		Cookie myCookie=new Cookie(key,value);
		myCookie.setMaxAge(60*60*24*7);
		HttpServletResponse response=GetReqRes.getResponse();
		response.addCookie(myCookie);
	}
	public static String getCookie(String key){
		return getCookie(key,false);
	}
	public static String getCookie(String key,boolean jiami){
		HttpServletRequest request=GetReqRes.getRequest();
		Cookie allCookie[]= request.getCookies();

		if(allCookie!=null&&allCookie.length!=0)
		 {
		     for(int i=0;i<allCookie.length;i++)
		     {
		          String keyname= allCookie[i].getName();
		          if((key).equals(keyname))
		          {
					  if(allCookie[i].getValue()==null)
						  return "";
					  else if(jiami)
						 return Aes.desEncrypt(allCookie[i].getValue());
					  else
						 return ZfmBase64.decode(allCookie[i].getValue());
		          }
		         
		      }
		 }
		return "";
	}
}
