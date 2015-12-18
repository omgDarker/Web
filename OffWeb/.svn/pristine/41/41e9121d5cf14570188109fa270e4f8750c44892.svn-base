package cn.wegoteam.shop.adm.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.crap.base.DataUtils;
import cn.crap.base.PageBean;
import cn.wegoteam.shop.action.BaseAction;
import cn.wegoteam.shop.inter.UserServiceInter;
import cn.wegoteam.shop.po.User;
import cn.wegoteam.shop.util.MD5;

@ParentPackage("manage")
@Namespace("/")
@Controller
public class ManUserAction extends BaseAction<User> {
  @Autowired
  private UserServiceInter userService;
  @Action(value="manageUserList",results={@Result(name="success",location=MANAGE+"list.jsp")})
  public String manageUserList(){
	  request.setAttribute("type", getParameter("p_type"));
	  return "success";
  }
  //按照查询的条件查询用户的列表加载用户到前台显示
  @Action(value="manageLoadUserList")
  public void manageLoadUser(){
	  int pageSize=getIntParameter("pageSize");
	  int currentPage=getIntParameter("page");
	  pageBean=new PageBean();
	  pageBean.setSize(pageSize==0?defaultSize:pageSize);
	  pageBean.setCurrentPage(currentPage==0?1:currentPage);
	  pageBean.setTotalPage(getIntParameter("totalPage"));
	  writeStringToResponse(userService.getJsonList(pageBean,DataUtils.getMap("type",getParameter("p_type")),null,request));
  }
  //添加或者更新一个用户
  @Action(value="manageAddUser")
  public String addUser(){
	  try {
		if(model.getId()==null){
			//添加一个用户
			model.setPassword(MD5.encrytMD5(model.getPassword()));
			userService.save(model);
		}else{
			//修改一个用户
			userService.updateBySql(model);
		}
		return SUCCESS;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return ERROR;
	}
  }
  //添加或者修改一个用户对象
  @Action(value="manageFindUserById",results={@Result(name=SUCCESS,location=MANAGE+"addUser.jsp")})
  public String manageFindUserById(){
	  if(model.getId()!=null){
		  model=userService.get(model.getId());
	  }
	  return SUCCESS;
  }
  //删除一个用户
  @Action(value="manageDeleteUser")
  public void manageDeleteUser(){
	  model=userService.get(model.getId());
	  writeStringToResponse(userService.delete(model)+"");
  }
}
