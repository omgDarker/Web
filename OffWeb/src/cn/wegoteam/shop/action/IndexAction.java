package cn.wegoteam.shop.action;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.inter.HotwordServiceInter;
import cn.wegoteam.shop.inter.NewsServiceInter;
import cn.wegoteam.shop.inter.SettingServiceInter;
import cn.wegoteam.shop.inter.StaticdataServiceInter;
import cn.wegoteam.shop.po.Hotword;
import cn.wegoteam.shop.po.User;
import cn.wegoteam.shop.util.Const;
import cn.wegoteam.shop.util.Email;
import cn.wegoteam.shop.util.GetReqRes;
import cn.wegoteam.shop.util.MyString;
import cn.wegoteam.shop.util.Tools;

@Controller
@ParentPackage("default")
@Namespace("/")
public class IndexAction extends BaseAction<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8254207059949911885L;
	@Autowired
	private StaticdataServiceInter staticdataService;
	@Autowired
	private SettingServiceInter settingService;
	@Autowired
	private NewsServiceInter newsService;
	@Autowired
	HotwordServiceInter hotwordService;
	// 调转到主页action
	@Action(value = "index", results = { @Result(name = "success", location = WEB
			+ "index.jsp") })
	public String index() {
			// 添加购物车数量至session
			pageBean.setSize(6);
			Cache.updateCache( staticdataService,
					settingService,newsService,hotwordService, pageBean);
			return SUCCESS;
	}
	// 调转到主页action
	@Action(value = "searchHotword")
	public void searchHotword() {
		StringBuilder sb=new StringBuilder();
		for(Hotword h:Cache.hotWordList){
			sb.append("<li><a href=\"search?p_keyWord="+h.getName()+"\">"+h.getName()+"</a></li>");
		}
		if(Cache.hotWordList.size()>0){
			writeStringToResponse("[OK]<div class=\"B2 fb pl15\">热门搜索：</div><ul>"+sb.toString()+"</ul>");
		}else{
			writeStringToResponse("[OK]没有数据！");
		}
	}
	// 异步加载百度分享、QQ等
	@Action(value = "asynLoad", results = {
			@Result(name = "baiduShare", location = SUBPAGES+ "baiduShare.jsp"),
			@Result(name = "QQ", location = SUBPAGES+ "QQ.jsp") })
	public String asynLoad() {
		String type=getParameter("p_type", "error");
		if(type.equals("baiduShare")){
			request.setAttribute("basePath", request.getAttribute("basePath"));
			return type;
		}
		return type;
	}
	
	/**
	 * 异常处理Action
	 * 打印异常，并发送邮件
	 * @return
	 */
	@Action(value = "exception", results = { @Result(name = "success", location = WEB
			+ "error.jsp") })
	public String error() {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			Exception ex = (Exception) ActionContext.getContext()
					.getValueStack().findValue("exception");
			sw = new StringWriter();
			pw = new PrintWriter(sw, true);
			ex.printStackTrace(pw);
			String url = GetReqRes.getReturnUrl();
			if(Cache.getSetting(Const.PRINTEXCEPTION).getValue().equals("YES")){
				System.out.println(url+"\r\n");
				System.out.println(sw.toString());
			}
			String emails = Cache.getSetting(Const.EXEPTIONEMAILS).getValue();
			if(!MyString.isEmpty(emails)){
				for(String email:emails.split(","))
					Email.sendEmail(email, "倍力康商城异常信息", request.getLocalName()+url+"<br>"+sw.toString(),false);
			}
		} catch (Exception e) {
			Email.sendEmail("516452267@qq.com", "倍力康商城error Action异常", 
					request.getLocalName()+GetReqRes.getReturnUrl()+"<br>"+e.getMessage(),false);
			e.printStackTrace();
		} finally {
			try {
				if (sw != null)
					sw.close();
			} catch (Exception e) {
			}
			try {
				if (pw != null)
					pw.close();
			} catch (Exception e) {
			}
		}
		return SUCCESS;
	}

//	@Action(value = "slide", results = {
//			@Result(name = "1", location = SLIDE + "slide_1.jsp"),
//			@Result(name = "2", location = SLIDE + "slide_2.jsp"),
//			@Result(name = "3", location = SLIDE + "slide_3.jsp") })
//	public String slide() {
//		request.setAttribute("height", getParameter("height", 500));
//		request.setAttribute("width", getParameter("width", 600));
//		if (!Tools.JudgeIsMoblie())
//			request.setAttribute("orientation", "orientation: 'vertical',");
//		return getParameter("num", "1");
//	}
}
