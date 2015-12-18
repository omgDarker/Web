package cn.wegoteam.shop.adm.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.crap.base.DataUtils;
import cn.wegoteam.shop.action.BaseAction;
import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.inter.SettingServiceInter;
import cn.wegoteam.shop.po.Setting;
@ParentPackage("manage")
@Namespace("/")
@Controller
public class ManSettingAction extends BaseAction<Setting>{
	private static final long serialVersionUID = -1709989379813828965L;
	@Autowired
	SettingServiceInter settingService;
	
	@Action(value = "manageSettingList", results = {@Result(name = SUCCESS, location = MANAGE+"list.jsp")})
	public String manageSettingList(){
		return SUCCESS;
	}
	
	@Action(value = "manageLoadSettingList")
	public void loadSettingList(){
		int pagesize=getIntParameter("pagesize");
		int currentPage=getIntParameter("page");
		pageBean.setSize(pagesize==0?defaultSize:pagesize);
		pageBean.setCurrentPage(currentPage==0?1:currentPage);
		pageBean.setTotalPage(getIntParameter("totalPage"));
		writeStringToResponse(settingService.getJsonList(pageBean,DataUtils.getMap(),null,request));
	}      
	@Action(value = "manageFindSettingById", results = {@Result(name = SUCCESS, location = MANAGE+"addSetting.jsp")})
	public String findSettingById(){
		model = settingService.get(model);
		return SUCCESS;
	}
	@Action(value = "manageAddSetting")
	public String addSetting(){
			settingService.saveOrUpdate(model);
			Cache.setSetting(model);
			return SUCCESS;
	}
	@Action(value = "manageDeleteSetting")
	public void deleteSetting(){
		writeStringToResponse(settingService.delete(model)+"");
	}
	
	
	/******************************************************get() and set()***********************************/
	

}
