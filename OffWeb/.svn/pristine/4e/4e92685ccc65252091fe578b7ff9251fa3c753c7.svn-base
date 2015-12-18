package cn.wegoteam.shop.util;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import cn.wegoteam.shop.po.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@SuppressWarnings("serial")
public class UserInteceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation invocation){
		 Map<String, Object> session = ActionContext.getContext().getSession();
		 HttpServletRequest request = ServletActionContext.getRequest();
	     if(session.get(Const.SESS_USER)!=null){
	    	 	User user=(User) session.get(Const.SESS_USER);
	    	 	if(user.getId()==null)
	    	 		return Action.LOGIN;
		    	String result;
				try {
					result = invocation.invoke();
					session.remove(Const.SESS_RETURNURL);
					return result;
				} catch (Exception e) {
					e.printStackTrace();
					return "500"; 
				}
	     }else{
	    	 request.setAttribute("tipMessage","未登陆，请先登陆！");
	    	 //跳转至拦截页面
//	    	 if(!request.getRequestURI().toLowerCase().contains("login"))
//	    		 session.put(Const.SESS_RETURNURL, getReturnUrl(request));
	    	 return Action.LOGIN;  
		}
		
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
