package cn.wegoteam.shop.inter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.crap.base.BaseServiceInter;
import cn.wegoteam.shop.po.User;

public interface UserServiceInter extends BaseServiceInter<User> {
    //更新一个用户的信息
	public int updateBySql(User model);

	public int errorTimes(Map<String, Object> session);
    //判断用户登陆的
	public String login(Map<String, Object> session, String parameter,
			User model);
    //发送邮件验证
	public String sendEmail(String email,String str,String parameter);
	//着急密码
	public String findPassword(String email, String parameter, String char1,
			HttpServletRequest request, Map<String, Object> session);
    //用户注册
	public String register(Map<String, Object> session,
			HttpServletRequest request, String parameter, User model);
	public String register(Map<String, Object> session,String securityCode,User model,String paramter);
    //验证用户注册的邮箱是否已被注册过
	public String isValidateEmail(User model);
	//验证用户注册时输入的手机号码是否注册过了
	public String isValidatePhone(User model);
    //用户修改绑定邮箱
	public String modifyEmail(User model, String parameter,
			Map<String, Object> session,User user); 
	//用户修改或者绑定手机
	public String modifyPhone(User model, String parameter,
			Map<String, Object> session, User sessionUser);
    //验证邮箱是否存在
	public String isValidateEmailExist(User model);
    //验证手机是否存在
	public String isValidatePhoneExist(User model);

	public String findPasswordByPhone(String phone, String phoneRandom,
			String newPwd, HttpServletRequest request,
			Map<String, Object> session);

	public String sendPhone(String parameter, Map<String, String> params);
    
	
}
