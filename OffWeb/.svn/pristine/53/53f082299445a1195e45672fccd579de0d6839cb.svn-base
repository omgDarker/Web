package cn.wegoteam.shop.action;

import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
import cn.wegoteam.shop.enu.SexType;
import cn.wegoteam.shop.inter.UserServiceInter;
import cn.wegoteam.shop.po.User;
import cn.wegoteam.shop.util.Const;
import cn.wegoteam.shop.util.MD5;

@ParentPackage("users")
@Namespace("/")
@Controller
public class UserInteceptorAction extends BaseAction<User> {
	@Resource
	private UserServiceInter userService;
	private String p_id;
    private Integer unpayNum;
	private Integer deliberNum;
    private Integer successNum;
	// 到达用户个人中心页面
	@Action(value = "personCenter", results = { @Result(name = SUCCESS, location = WEB
			+ "personInfo.jsp") })
	public String personCenter() {
		request.setAttribute("action", getParameter("p_action", "personInfo"));
		return SUCCESS;
	}

	// 加载修改密码的页面action
	@Action(value = "modifyPass", results = { @Result(name = SUCCESS, location = SUBPAGES
			+ "modifyPass.jsp") })
	public String modifyPass() {
		return SUCCESS;
	}
    //检查用户输入的原密码是否有误
	@Action(value="checkPassword")
	public void checkPassword(){
		if(!getSessionUser().getPassword().equals(MD5.encrytMD5(model.getPassword()))){
			writeStringToResponse("[ERROR]");
		}
	}
	
	// 执行用户修改密码操作
	@Action(value = "doModifyPass", results = { @Result(name = SUCCESS, type = "chain", location = "personCenter") })
	public String doModifyPass() {
			User user = new User();
			user.setId(getSessionUser().getId());
			user.setPassword(model.getPassword());
			userService.updateBySql(user);
		request.setAttribute("p_action", "personInfo");
		return SUCCESS;
	}


    //到达个人中心界面
	@Action(value = "personInfo", results = { @Result(name = SUCCESS, location = SUBPAGES
			+ "person.jsp") })
	public String personInfo() {
		model=getSessionUser();
		return SUCCESS;
	}
	/***********到达修改邮箱的界面*/
	@Action(value="toModifyEmailPage",results={@Result(name=SUCCESS,location=SUBPAGES+"modifyEmail.jsp")})
	public String toModifyEmailPage(){
		if(getParameter("p_flag").equals("MODIFY")){
			request.setAttribute("p_email", getSessionUser().getEmail());
			request.setAttribute("p_flag", "MODIFY");
		}else if(getParameter("p_flag").equals("BINGDING")){
			request.setAttribute("p_flag", "BINGDING");
		}else{
			request.setAttribute("p_flag", "UPDATE");
		}
		return SUCCESS;
	}
	@Action(value="verifyEmail")
	public void verifyEmail(){
		if(!getParameter(Const.SECURITY_CODE).equals(session.get(Const.SECURITY_CODE))){
		    writeStringToResponse("[ERROR]验证码不正确");
		}else{
			writeStringToResponse("[OK]");
		}
	}
	/**
	 * 修改或者绑定邮箱
	 */
	@Action(value="modifyOrBindingEmail")
    public void modifyOrBindingEmail(){
    	String message=userService.modifyEmail(model,getParameter(Const.SECURITY_CODE, "0"),session,getSessionUser());
    	putSessionUser(userService.get(getSessionUser()));
    	writeStringToResponse(message);
    }
	/**
	 * 到达更换手机号和绑定手机页面
	 * @Param
	 * @Return
	 */
	@Action(value="toModifyPhonePage",results={@Result(name=SUCCESS,location=SUBPAGES+"modifyPhone.jsp")})
	public String toModifyPhonePage(){
		if(getParameter("p_flag").equals("MODIFY")){
			request.setAttribute("p_phone", getSessionUser().getPhone());
			request.setAttribute("p_flag","MODIFY");
		}else if(getParameter("p_flag").equals("BINDING")){
			request.setAttribute("p_flag", "BINDING");
		}else{
			request.setAttribute("p_flag", "UPDATE");
		}
		return SUCCESS;
	}
	@Action(value="modifyOrBindingPhone")
	public void modifyOrBindingPhone(){
		String message=userService.modifyPhone(model,getParameter(Const.SECURITY_CODE,"0"),session,getSessionUser());
		putSessionUser(userService.get(getSessionUser()));
		writeStringToResponse(message);
	}
	@Action(value="verifyPhone")
	public void verifyPhone(){
	    if(!getParameter(Const.SECURITY_CODE).equals(session.get(Const.SECURITY_CODE))){
		    writeStringToResponse("[ERROR]验证码不正确");
		}else{
			writeStringToResponse("[OK]");
		}
	}
	/**
	 * 修改用户个人的部分信息
	 * @Param
	 * @Return
	 */
	@Action(value="modifyUserInfo")
	public void modifyUserInfo(){
		  User user=new User();
		  user.setId(getSessionUser().getId());
		  user.setName(model.getName());
		  user.setQq(model.getQq());
		  if(getParameter("p_sex").equals("MALE")){
			  user.setSex(SexType.MALE);
		  }else{
			  user.setSex(SexType.FEMALE);
		  }
          int i=userService.updateBySql(user);
          if(i>0){
        	  putSessionUser(userService.get(getSessionUser()));
        	  writeStringToResponse("[OK]");
          }else{
        	  writeStringToResponse("[ERROR]");
          }
	}
	/**
	 * 
	 * 代理加盟
	 * @Param
	 * @Return  代理加盟界面用户填写的基本信息
	 */
	@Action(value="toAgentJoin",results={@Result(name=SUCCESS,location=SUBPAGES+"agentJoin.jsp")})
	public String agentJoin(){
		return SUCCESS;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public Integer getUnpayNum() {
		return unpayNum;
	}

	public void setUnpayNum(Integer unpayNum) {
		this.unpayNum = unpayNum;
	}

	public Integer getDeliberNum() {
		return deliberNum;
	}

	public void setDeliberNum(Integer deliberNum) {
		this.deliberNum = deliberNum;
	}

	public Integer getSuccessNum() {
		return successNum;
	}

	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}
}
