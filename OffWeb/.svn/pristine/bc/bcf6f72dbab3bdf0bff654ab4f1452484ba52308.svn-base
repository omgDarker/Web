package cn.wegoteam.shop.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import cn.crap.base.DataUtils;
import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.enu.FlagType5;
import cn.wegoteam.shop.inter.UserServiceInter;
import cn.wegoteam.shop.po.User;
import cn.wegoteam.shop.util.AuthImg;
import cn.wegoteam.shop.util.Const;
import cn.wegoteam.shop.util.GetReqRes;
import cn.wegoteam.shop.util.MyString;
import cn.wegoteam.shop.util.PostAndGetRequset;
import cn.wegoteam.shop.util.ZfmBase64;

/**
 * default 表示没有添加拦截器 user 表示只有用户登录才能访问
 * 
 * @author Torry
 * 
 */
@ParentPackage("default")
@Namespace("/")
@Controller
public class UserAction extends BaseAction<User> {
	@Resource
	private UserServiceInter userService;
	private String succMess;

	@Action(value = "preLogin", results = { @Result(name = SUCCESS, location = WEB
			+ "login.jsp") })
	public String preLogin() {
		if (model == null) {
			model = new User();
		}
		model.setName(GetReqRes.getCookie(Const.USER_NAME));
		model.setPassword(GetReqRes.getCookie(Const.USER_PWD, true));
		request.setAttribute(Const.REMBER_PWD,GetReqRes.getCookie(Const.REMBER_PWD));
		return SUCCESS;
	}

	@Action(value = "login", results = {
			@Result(name = SUCCESS, type = "chain", location = "manageIndex"),
			@Result(name = ERROR, location = WEB + "login.jsp") })
	public String login() {
		try {
			tipMessage = userService.login(session,request.getParameter(Const.SESS_RANDOM_IMG), model);
			System.out.println("操作信息"+tipMessage);
			log.debug("-------" + succMess);
			log.debug("是否勾选了记住密码====="+ getParameter(Const.REMBER_PWD, Const.FALSE));
			if (tipMessage.equals(Const.TRUE)) {
				if (getParameter(Const.REMBER_PWD, Const.FALSE).equals(Const.TRUE)) {
					GetReqRes.addCookie(Const.USER_NAME, model.getName());
					GetReqRes.addCookie(Const.USER_PWD, model.getPassword(),true);
				}
				GetReqRes.addCookie(Const.REMBER_PWD,getParameter(Const.REMBER_PWD, Const.FALSE));
				/**
				 * 跳转至登录拦截前的页面
				 */
//				if(session.get(Const.SESS_RETURNURL)!=null&&!MyString.isEmpty(session.get(Const.SESS_RETURNURL).toString())){
//					request.setAttribute("redirect", "true");
//					return ERROR;
//				}
				return SUCCESS;
			} else {
				request.setAttribute(Const.REMBER_PWD,getParameter(Const.REMBER_PWD, Const.FALSE));
				model.setPassword(GetReqRes.getCookie(Const.USER_PWD, true));
				return ERROR;
			}
		} catch (Exception e) {
			log.debug("-------" + e);
			e.printStackTrace();
			return ERROR;
		}
	}

	// 刷新验证码图片，判断是否勾选了记住密码按钮
	@Action(value = "refreshRandomImageStr")
	public void refreshRandomImageStr() {
		try {
			if (GetReqRes.getCookie(Const.REMBER_PWD).equals(Const.TRUE)) {
				writeStringToResponse(session.get(Const.SESS_RANDOM_IMG)
						.toString());
			} else {
				writeStringToResponse("");
			}
		} catch (Exception e) {
			// TODO: handle exception
			writeStringToResponse("");
		}
	}
	// 调转到找回密码页面
	@Action(value = "preFindPassword", results = { @Result(name = "success", location = WEB
			+ "findPassword.jsp") })
	public String preFindPassword() {
		return SUCCESS;
	}
	// 自动发送邮件
	@Action(value = "sendEmailRandom")
	public void sendEmailRandom() {
		String ZQS = AuthImg.getNumber(6);
		session.put(Const.SECURITY_CODE, ZQS);
		System.out.println(getParameter("p_flag"));
	    succMess= userService.sendEmail(model.getEmail(), "您在倍力康商城上的验证码为" + ZQS,getParameter("p_flag"));
		writeStringToResponse(succMess);
	}
    //自动获取手机的验证码
	@Action(value="sendPhoneRandom")
	public void sendPhoneRandom() throws Exception{
		String ZqsPhoneNum=AuthImg.getNumber(6);
		session.put(Const.SECURITY_CODE, ZqsPhoneNum);
		Map<String,String> params=new HashMap<String, String>();
		params.put("phoneNumber", model.getPhone());
		params.put("securityCode", ZqsPhoneNum);
		params.put("pType", getParameter("p_type"));
		succMess=userService.sendPhone(getParameter("p_flag"),params);
		System.out.println("=============="+succMess);
		writeStringToResponse(succMess);
		
	}
	/**
	 * 使用邮箱找回密码
	 * 
	 * **/
	@Action(value = "findPasswordByEmail",results={@Result(name=ERROR,location=WEB+ "findPassword.jsp")})
	public String findPassword() {
		succMess = userService.findPassword(model.getEmail(),getParameter(Const.SECURITY_CODE), AuthImg.getChar(8), request,session);
		if (succMess.equals(Const.TRUE)) {
			if (model.getEmail().endsWith("@qq.com")) {
				initPage("找回密码", "密码找回成功","恭喜,新密码已经发送你的QQ邮箱，请注意查收!请注意邮件是否被拦截至垃圾箱，登录后您可在“安全设置页面”修改密码。");
			} else {
				initPage("找回密码", "密码找回成功","恭喜，新密码已发送到你的邮箱，请注意查收!登录后您可在“安全设置页面”修改密码。");
			}
			setReturnPage("index", "首页");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	/**
	 * 使用手机号找回密码
	 */
	@Action(value="findPasswordByPhone",results={@Result(name=ERROR,location=WEB+"findPassword.jsp")})
	public String findPasswordByPhone(){
		succMess=userService.findPasswordByPhone(model.getPhone(),getParameter(Const.SECURITY_CODE),AuthImg.getChar(8),request,session);
		if(succMess.equals(Const.TRUE)){
			initPage("找回密码","密码找回成功","恭喜，新密码已经发送到你的手机，登陆后你可以到个人中心修改密码");
			setReturnPage("index", "首页");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	/**
	 * 到达重置密码页面
	 * */
	@Action(value = "preResetPass", results = { @Result(name = "success", location = WEB
			+ "resetPass.jsp") })
	public String preResetPass() {
		String u_code = ZfmBase64.decode(request.getParameter("u_code"));
		String p_code=ZfmBase64.decode(request.getParameter("p_code"));
		long nowTime = System.currentTimeMillis();
		long temp = nowTime - Long.parseLong(p_code);
		if (temp<1000*60*30l&&model.getId().toString().trim().equals(u_code.trim())) {
			initPage("找回密码", "重置密码");
			return SUCCESS;
		} else {
			initPage("找回密码", "找回密码失败", "该链接已失效");
			return ERROR;
		}
	}

	@Action(value = "resetPass")
	public String resetPass() {
//		if (!isLegal(model.getPassword())) {
//			return ERROR;
//		}
		User u = new User();
		u.setId(model.getId());
		u.setPassword(model.getPassword());
		userService.updateBySql(u);
		initPage("找回密码", "重置密码，密码修改成功", "密码修改成功，请用新的密码登陆");
		return SUCCESS;
	}
	@Action(value="preRegister",results={@Result(name=SUCCESS,location=WEB+"reg.jsp")})
	public String preRegister(){
		return SUCCESS;
	}
    @Action(value="register",results={@Result(name=SUCCESS,location=WEB+"success.jsp"),@Result(name=ERROR,location=WEB+"reg.jsp")})
    public String register(){
    	succMess=userService.register(session,request,request.getParameter(Const.SESS_RANDOM_IMG),model);
    	if(succMess.equals(Const.TRUE)){
    		succMess="请登录你注册的邮箱，点击链接激活你的帐号";
    		initPage("注册用户","用户注册成功",succMess);
    		return SUCCESS;
    	}else{
    		return ERROR;
    	}
    }
    @Action(value="registerByPhone",results={@Result(name=SUCCESS,location=WEB+"success.jsp"),@Result(name=ERROR,location=WEB+"reg.jsp")})
    public String registerByPhone(){
    	succMess=userService.register(session,getParameter("securityCode","0"), model,getParameter(Const.SESS_RANDOM_IMG));
    	if(succMess.equals(Const.TRUE)){
    		succMess="恭喜您";
    		initPage("注册用户","注册用户成功",succMess);
    		return SUCCESS;
    	}else{
    		request.setAttribute("changeFlag", "phone");
    		return ERROR;
    	}
    }
    /**
     * 手机注册用户时，先验证输入的图形验证码是否正确
     * @Param
     * @Return
     */
    @Action(value="verifyCode")
    public void verifyCode(){
    	String randomImg=session.get(Const.SESS_RANDOM_IMG).toString();
    	if(randomImg.equals(getParameter("verifyCode", ""))){
    		writeStringToResponse("[OK]");
    	}else{
    		writeStringToResponse("[ERROR]");
    	}
    }
    /**
     * 用户注册时验证用户输入的邮箱是否已注册过
     * @Param
     * @Return
     */
    @Action(value="isValidateEmail")
    public void isValidateEmail(){
    	succMess=userService.isValidateEmail(model);
    	writeStringToResponse(succMess);
    }
    /**
     *验证邮箱是否存在
     */
    @Action(value="validateEmailExist")
    public void validateEmailExist(){
    	succMess=userService.isValidateEmailExist(model);
    	writeStringToResponse(succMess);
    }
    /**
     * 验证手机是否存在
     * @Param
     * @Return
     */
    @Action(value="validatePhoneExist")
    public void validatePhoneExist(){
    	succMess=userService.isValidatePhoneExist(model);
    	writeStringToResponse(succMess);
    }
    /**
     * 激活用户
     * @Param
     * @Return
     */
    @Action(value="activate_user")
    public String activateUser(){
    	String email=null;
    	String key=request.getParameter("p_code");
    	if(key!=null){
    		email=ZfmBase64.decode(key);
    	}
    	int flag=userService.executeBySql("UPDATE User u set u.flag=:flag where u.email=:email", DataUtils.getMap("flag",Integer.parseInt(FlagType5.验证成功.getName()),"email",email));
    	if(flag>0){
    		initPage("账户激活","账户激活成功","恭喜!你的账户已成功激活");
    		return SUCCESS;
    	}else{
    		initPage("账户激活","账户激活失败");
    		return ERROR;
    	}
    }
    @Action(value="logOut",results={@Result(name=SUCCESS,type="redirect",location="index")})
    public String logOut(){
    	session.clear();
    	return SUCCESS;
    }
	public String getSuccMess() {
		return succMess;
	}

	public void setSuccMess(String succMess) {
		this.succMess = succMess;
	}
}
