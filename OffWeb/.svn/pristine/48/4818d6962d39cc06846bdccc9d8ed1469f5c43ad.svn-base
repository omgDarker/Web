package cn.wegoteam.shop.adm.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.crap.base.DataUtils;
import cn.wegoteam.shop.action.BaseAction;
import cn.wegoteam.shop.cache.StaticDataCache;
import cn.wegoteam.shop.inter.StaticdataServiceInter;
import cn.wegoteam.shop.po.Staticdata;
import cn.wegoteam.shop.util.Const;

@ParentPackage("manage")
@Namespace("/")
@Controller
public class ManStaticAction extends BaseAction<Staticdata>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7214652284224332303L;
	@Autowired
	private StaticdataServiceInter staticdataService;

	@Action(value = "manageStaticdataList", results = { @Result(name = SUCCESS, location = MANAGE
			+ "list.jsp") })
	public String manageStaticdataList() {
		request.setAttribute("spcode", getParameter("spcode", ""));
		return SUCCESS;
	}

	@Action(value = "manageLoadStaticdataList")
	public void loadStaticdataList() {
		int pageSize = getIntParameter("pagesize");
		int currentPage = getIntParameter("page");
		pageBean.setSize(pageSize == 0 ? defaultSize : pageSize);
		pageBean.setCurrentPage(currentPage == 0 ? 1 : currentPage);
		pageBean.setTotalPage(getIntParameter("totalPage"));
		writeStringToResponse(staticdataService.getJsonList(pageBean,getParameter("spcode", "TOP").equals("ALL")?null:DataUtils.getMap("pcode", getParameter("spcode", "TOP")),null,request));
	}

	@Action(value = "manageFindStaticdataById", results = { @Result(name = SUCCESS, location = MANAGE
			+ "addStaticdata.jsp") })
	public String findStaticdataById() {
		if (model.getId() != null)
			model = staticdataService.get(model.getId());
		return SUCCESS;
	}

	@Action(value = "manageAddStaticdata")
	public String addStaticdata() {
			tipMessage = "不允许添加相同Key值的Staticdata！或存在关联的外键";// 错误提示，操作成功时不会显示
			model.setPcode(model.getPcode().trim());
			model.setCode(model.getCode().trim());
			model.setType(model.getType().trim());
			staticdataService.saveOrUpdate(model);
			StaticDataCache.setStaticdata(model);
			return SUCCESS;
	}

	@Action(value = "manageDeleteStaticdata")
	public void deleteStaticdata() {
		model = staticdataService.get(model.getId());
		map.put("pcode", model.getCode());
		
	}

	/****************************************************** get() and set() ***********************************/


}
