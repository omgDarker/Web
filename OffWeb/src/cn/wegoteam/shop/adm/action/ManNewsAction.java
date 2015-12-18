package cn.wegoteam.shop.adm.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.crap.base.DataUtils;
import cn.wegoteam.shop.action.BaseAction;
import cn.wegoteam.shop.inter.NewsServiceInter;
import cn.wegoteam.shop.po.News;

@ParentPackage("manage")
@Namespace("/")
@Controller
public class ManNewsAction extends BaseAction<News>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8354033033772698795L;
	@Autowired
	NewsServiceInter newsService;
	
	@Action(value = "manageNewsList", results = {@Result(name = SUCCESS, location = MANAGE+"list.jsp")})
	public String manageNewsList(){
		request.setAttribute("type",getParameter("type",""));
		request.setAttribute("flag",getParameter("flag",""));
		return SUCCESS;
	}
	
	@Action(value = "manageLoadNewsList")
	public void loadNewsList(){
		try{
		int pageBeanSize=getIntParameter("pageBeansize");
		int currentpageBean=getIntParameter("pageBean");
		pageBean.setSize(pageBeanSize==0?defaultSize:pageBeanSize);
		pageBean.setCurrentPage(currentpageBean==0?1:currentpageBean);
		pageBean.setTotalPage(getIntParameter("totalpageBean"));
		writeStringToResponse(newsService.getJsonList(pageBean,DataUtils.getMap("type",getParameter("type"),"flag",getParameter("flag")),null,request));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Action(value = "manageFindNewsById", results = {@Result(name = SUCCESS, location = MANAGE+"addNews.jsp")})
	public String findNewsById(){
		if(model.getId()!=null)			
			model = newsService.get(model);
		return SUCCESS;
	}
	@Action(value = "manageAddNews")
	public String addNews(){
			newsService.saveOrUpdate(model);
			return SUCCESS;
	}
	@Action(value = "manageDeleteNews")
	public void deleteNews(){
			 writeStringToResponse(newsService.delete(model)+"");
	}
	
	
	/******************************************************get() and set()***********************************/

}
