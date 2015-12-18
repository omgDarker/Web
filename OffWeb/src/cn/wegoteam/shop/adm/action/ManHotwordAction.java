package cn.wegoteam.shop.adm.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.crap.base.DataUtils;
import cn.wegoteam.shop.action.BaseAction;
import cn.wegoteam.shop.inter.HotwordServiceInter;
import cn.wegoteam.shop.po.Hotword;

@ParentPackage("manage")
@Namespace("/")
@Controller
public class ManHotwordAction  extends BaseAction<Hotword>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4217382037630135548L;
	@Autowired
	HotwordServiceInter hotwordService;
	
	@Action(value = "manageHotwordList", results = {@Result(name = SUCCESS, location = MANAGE+"list.jsp")})
	public String manageHotwordList(){
		request.setAttribute("flag",getParameter("flag","0"));
		return SUCCESS;
	}
	
	@Action(value = "manageLoadHotwordList")
	public void loadHotwordList(){
		int pageBeanSize=getIntParameter("pagesize");
		int currentPage=getIntParameter("page");
		pageBean.setSize(pageBeanSize==0?defaultSize:pageBeanSize);
		pageBean.setCurrentPage(currentPage==0?1:currentPage);
		pageBean.setTotalPage(getIntParameter("totalPage"));
		String order="";
		order+= getParameter("sortname", "").equals("")?"searchTimes":getParameter("sortname", "");
		order+= getParameter("sortorder", "").equals("")?" desc":" "+getParameter("sortorder", "");
		writeStringToResponse(hotwordService.getJsonList(pageBean,DataUtils.getMap("flag",getIntParameter("flag")),null,request));
	}      
	@Action(value = "manageFindHotwordById", results = {@Result(name = SUCCESS, location = MANAGE+"addHotword.jsp")})
	public String findHotwordById(){
		model = hotwordService.get(model);
		return SUCCESS;
	}
	@Action(value = "manageAddHotword")
	public String addHotword(){
			hotwordService.saveOrUpdate(model);
			return SUCCESS;
	}
	@Action(value = "manageDeleteHotword")
	public void deleteHotword(){
		writeStringToResponse(hotwordService.delete(model)+"");
	}
	
	
	/******************************************************get() and set()***********************************/
	
}
