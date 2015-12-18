package cn.wegoteam.shop.util;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.cache.StaticDataCache;
import cn.wegoteam.shop.enu.UserType;
import cn.wegoteam.shop.po.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@SuppressWarnings("serial")
public class AdminInteceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation invocation){
		 Map<String, Object> session = ActionContext.getContext().getSession();
		 HttpServletRequest request = ServletActionContext.getRequest();
	     if(session.get(Const.SESS_USER)!=null){
	    	 try {
		    	 	User user=(User) session.get(Const.SESS_USER);
		    	 	if(user.getId()==null||!user.getType().equals(UserType.ADMINUSER)){
		    	 		return Action.LOGIN;
		    	 	}
		    	 	if(user.getId().toString().equals(Cache.getSetting(Const.SUPERADINID).getValue())){
		    	 		return invocation.invoke();
		    	 	}
		    	 	if(MyString.isEmpty(user.getAuthority())&&MyString.isEmpty(user.getRole())){
		    	 		request.setAttribute("tipMessage","抱歉，权限不够！");
		    	 		return Action.ERROR;
		    	 	}
		    	 	
		    	 	String url=request.getRequestURI();
					String action =url.substring(url.lastIndexOf("/")+1);
					//判断是否含有权限
		    	 	if(hasAuth(invocation, user.getAuthority(), action))
		    	 		return invocation.invoke();
		    	 	//判断所在角色是否含有权限
		    	 	if(!MyString.isEmpty(user.getRole()))
		    	 		for(String role:user.getRole().split(",")){
		    	 			if(hasAuth(invocation, StaticDataCache.getStaticdata(role).getValue(), action))
				    	 		return invocation.invoke();
		    	 		}
		    	 	request.setAttribute("tipMessage","抱歉，权限不够！");
	    	 		return Action.ERROR;
				} catch (Exception e) {
					e.printStackTrace();
					return "500"; 
				}
	     }else{
	    	 request.setAttribute("tipMessage","未登陆，请先登陆！");
	    	 //跳转至拦截页面
	    	 if(!request.getRequestURI().contains("login"))
	    		 session.put("returnUrl", getReturnUrl(request));
	    	 return Action.LOGIN;  
		}
		
	}
	private boolean hasAuth(ActionInvocation invocation, String authority, String action){
		if(!MyString.isEmpty(authority)){
			for(String auth:authority.split(","))
				try{
					if(StaticDataCache.getStaticdata(auth).getValue().equals(action))
						return true;
				}catch(Exception e){
					e.printStackTrace();
					continue;
				}
		}
		return false;
	}
	private String getReturnUrl(HttpServletRequest request){
		Map<String, String[]> map=request.getParameterMap();
		StringBuffer temp=new StringBuffer(request.getRequestURI()+"?");
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

}
