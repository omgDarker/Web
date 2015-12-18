package cn.wegoteam.shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.crap.base.BaseDaoInter;
import cn.crap.base.BaseService;
import cn.crap.base.DataUtils;
import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.enu.FlagType5;
import cn.wegoteam.shop.enu.UserType;
import cn.wegoteam.shop.inter.UserDaoInter;
import cn.wegoteam.shop.inter.UserServiceInter;
import cn.wegoteam.shop.po.User;
import cn.wegoteam.shop.util.Aes;
import cn.wegoteam.shop.util.AuthImg;
import cn.wegoteam.shop.util.Const;
import cn.wegoteam.shop.util.Email;
import cn.wegoteam.shop.util.MD5;
import cn.wegoteam.shop.util.MyString;
import cn.wegoteam.shop.util.PostAndGetRequset;
import cn.wegoteam.shop.util.Tools;
import cn.wegoteam.shop.util.ZfmBase64;

@Service
public class UserService extends BaseService<User> implements UserServiceInter {
	@Resource(name = "userDao")
	private UserDaoInter userDao;

	@Resource(name = "userDao")
	public void setBaseDao(BaseDaoInter<User> baseDao) {
		super.setBaseDao(baseDao);
	}

	public int updateBySql(User u) {
		if (u.getId() == null)
			return 0;
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuilder sql = new StringBuilder("UPDATE user SET id=id ");
		if (!MyString.isEmpty(u.getName())) {
			sql.append(",name=:name");
			map.put("name", u.getName());
		}
		if (u.getBounds() != null) {
			sql.append(",bounds=:bounds");
			map.put("bounds", u.getBounds());
		}
		if (!MyString.isEmpty(u.getEmail())) {
			sql.append(",email=:email");
			map.put("email", u.getEmail());
		}
		if (u.getFlag() != null) {
			sql.append(",flag=:flag");
			map.put("flag", u.getFlag());
		}
		if (u.getGrade() != null) {
			sql.append(",grade=:grade");
			map.put("grade", u.getGrade());
		}
		if (!MyString.isEmpty(u.getPassword())) {
			sql.append(",password=:password");
			map.put("password", MD5.encrytMD5(u.getPassword()));
		}
		if (!MyString.isEmpty(u.getPhone())) {
			sql.append(",phone=:phone");
			map.put("phone", u.getPhone());
		}
		if (!MyString.isEmpty(u.getQq())) {
			sql.append(",qq=:qq");
			map.put("qq", u.getQq());
		}
		if (u.getSex() != null) {
			sql.append(",sex=:sex");
			map.put("sex", u.getSex().name());
		}
		if (u.getType() != null) {
			sql.append(",type=:type");
			map.put("type", u.getType().name());
		}
		if (u.getAuthority() != null) {
			sql.append(",authority=:authority");
			map.put("authority", u.getAuthority());
		}
		if (u.getRole() != null) {
			sql.append(",role=:role");
			map.put("role", u.getRole());
		}

		sql.append(" where id=" + u.getId());
		return super.executeBySql(sql.toString(), map);
	}

	/*
	 * 判断用户错误的登陆次数
	 * 
	 * @see cn.wegoteam.shop.inter.UserServiceInter#errorTimes(java.util.Map)
	 */
	public int errorTimes(Map<String, Object> session) {
		Object o = session.get("errortimes");
		if (o != null) {
			String times = session.get("errortimes").toString();
			if (times == null || times.trim().equals("")) {
				session.put("errortimes", 0);
				return 0;
			} else {
				return Integer.parseInt(times);
			}
		} else {
			session.put("errortimes", 0);
			return 0;
		}

	}

	// 判断用户登陆
	@Transactional(propagation = Propagation.SUPPORTS)
	public String login(Map<String, Object> session, String randomImageStr,
			User model) {
		model.setName(ZfmBase64.unescape(ZfmBase64.decode(model.getName())));
		Object randomImg = session.get(Const.SESS_RANDOM_IMG);
		if (randomImg==null||randomImageStr == null
				|| !randomImageStr.equals(MD5.encrytMD5(randomImg.toString()))) {
			return "验证码有误...";
		}
		List<User> us = new ArrayList<User>();
		try {
			us = findByHql(
					"from User u where u.email=:email or u.phone=:phone",
					DataUtils.getMap("email", model.getName(), "phone",
							model.getName()));
			if (us.size() == 1) {
				if (!model.getPassword().equals(us.get(0).getPassword())) {
					return "登录超时或密码有误...";
				} else {
					session.put(Const.SESS_USER, us.get(0));
					return "true";
				}
			} else {
				return "用户名不存在";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "登陆失败";
		}
	}

	/**
	 * 向邮箱发送验证码 params值为ONLY时表示在向邮箱发送验证码之前得想验证邮箱是否存在 如果存在不向邮箱发送验证邮件 否则发送
	 * 
	 * **/
	@Transactional(propagation = Propagation.SUPPORTS)
	public String sendEmail(String email, String content, String params) {
		List<User> us = null;
		if (params.equals("ONLY")) {
			us = userDao.findByHql("from User where email=:email",
					DataUtils.getMap("email", email), null, null);
			if (!Tools.isValid(us)) {
				if (Email.sendEmail(email, "倍力康商城的验证码", content)) {
					return "[OK]";
				} else {
					return "[ERROR]发送失败";
				}
			} else {
				return "[ERROR]邮箱已存在";
			}
		} else {
			if (Email.sendEmail(email, "倍力康商城的验证码", content)) {
				return "[OK]";
			} else {
				return "[ERROR]发送失败";
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String findPassword(String email, String emailRandom, String newPwd,
			HttpServletRequest request, Map<String, Object> session) {
		if (emailRandom.equals("")
				|| !emailRandom.equals(session.get(Const.SECURITY_CODE))) {
			return "验证码有误";
		} else if (Tools.isEmail(email)) {
			List<User> us = findByHql("from User u where u.email=:email",
					DataUtils.getMap("email", email));
			if (us != null && us.size() != 1) {
				return "邮箱输入有误，系统中不存在此账号";
			}
			User user = us.get(0);
			User u = new User();
			u.setId(user.getId());
			u.setPassword(newPwd);
			updateBySql(u);
			String u_code = ZfmBase64.encode(user.getId().toString());
			System.out.println("u_code加密发送的为" + u_code);
			String p_code = ZfmBase64.encode(System.currentTimeMillis() + "");
			System.out.println("p_code加密后发送过来的为" + p_code);
			String baseUrl = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
			String url = baseUrl + "preResetPass?id=" + user.getId()
					+ "&u_code=" + u_code + "&p_code=" + p_code;
			String content = "<a href='" + url
					+ "' target='_blank' style='color:#6cf;'>'" + url + "'</a>";
			Email.sendEmail(user.getEmail(), "找回密码", "尊敬的用户您好,您在倍力康商城的密码已重置为:"
					+ newPwd + "</br>您也可以点击此链接直接修改密码:" + content
					+ "</br>如果不是您本人所发请忽略此信息");
			return Const.TRUE;
		} else {
			return "抱歉，找回密码失败，请输入正确的邮箱";
		}
	}

	public boolean isLegal(String str) {
		return str.matches("[0-9|a-z|A-Z|_|#|@|.|+|-|*|/|\u2E80-\u9FFF]*");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String register(Map<String, Object> session,
			HttpServletRequest request, String randomStr, User model) {
		String sessRandomStr = session.get(Const.SESS_RANDOM_IMG).toString()
				.trim();
		if (randomStr == null
				|| !randomStr.equals(MD5.encrytMD5(sessRandomStr))) {
			return "验证码不正确";
		}
		if (model.getPassword().length() < 6
				|| model.getPassword().length() > 20) {
			return "密码的长度有误";
		}
		if (!Tools.isEmail(model.getEmail().toString().trim())) {
			return "邮箱的格式不正确";
		} else {
			List<User> us = getList(null,
					DataUtils.getMap("email", model.getEmail()));
			if (us.size() >= 1) {
				return "邮箱已注册,请直接使用此邮箱登陆";
			} else {
				model.setPassword(MD5.encrytMD5(model.getPassword()));
				// 设置默认用户名
				model.setName(model.getEmail());
				userDao.save(model);
				String p_code = ZfmBase64.encode(model.getEmail());
				String baseUrl = request.getScheme() + "://"
						+ request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/";
				String url = baseUrl + "activate_user?p_code=" + p_code;
				String cont = "<a href='" + url
						+ "' target=\"_blank\" style=\"color:#6cf;\">" + url
						+ "</a>";
				boolean flag = Email.sendEmail(model.getEmail(), "激活账户",
						"尊敬的用户您好,请点击此链接激活你的账户:</br>" + cont
								+ "</br>如果不是您本人所发请忽略此信息");
				if (flag == true) {
					return Const.TRUE;
				} else {
					return "激活邮件发送失败";
				}

			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String register(Map<String, Object> session, String securityCode,
			User model, String randomStr) {
		String sessRandomStr = session.get(Const.SESS_RANDOM_IMG).toString()
				.trim();
		if (randomStr == null
				|| !randomStr.equals(MD5.encrytMD5(sessRandomStr))) {
			return "图形验证码不正确";
		}
		if (!isLegal(model.getPhone())) {
			return "手机号格式不对";
		}
		if (session.get(Const.SECURITY_CODE) == null) {
			return "手机验证码不正确";
		}
		if (!securityCode.equals("0")
				&& securityCode.equals(session.get(Const.SECURITY_CODE)
						.toString())) {
			List<User> us = getList(null,
					DataUtils.getMap("phone", model.getPhone()));
			if (us.size() >= 1) {
				return "该手机号已注册,请直接用该手机号登陆";
			} else {
				model.setPassword(MD5.encrytMD5(model.getPassword()));
				model.setName(model.getPhone());
				model.setFlag(Integer.parseInt(FlagType5.可用.getName()));
				userDao.save(model);
				return Const.TRUE;
			}
		} else {
			return "手机验证码有误";
		}
	}

	public String isValidateEmail(User model) {
		if (Tools.isEmail(model.getEmail())) {
			List<User> us = getList(null,
					DataUtils.getMap("email", model.getEmail()));
			if (!Tools.isValid(us)) {
				return "[OK]";
			}
		}
		return "[ERROR]";
	}

	public String isValidatePhone(User model) {
		if (isLegal(model.getPhone())) {
			List<User> us = getList(null,
					DataUtils.getMap("phone", model.getPhone()));
			if (!Tools.isValid(us)) {
				return "[OK]";
			}
		}
		return "[ERROR]";
	}

	// 用户修改绑定邮箱
	public String modifyEmail(User model, String securityCode,
			Map<String, Object> session, User user) {
		List<User> us = null;
		if (!securityCode.equals(session.get(Const.SECURITY_CODE))) {
			return "[ERROR]验证码不正确";
		} else {
			// 验证修改的输入的邮箱是否已经绑定过
			if (Tools.isEmail(model.getEmail())) {
				us = userDao
						.findByHql("from User where email=:email",
								DataUtils.getMap("email", model.getEmail()),
								null, null);
			}
			if (us.size() >= 1) {
				return "[ERROR]邮箱已存在";
			} else {
				// 绑定邮箱或者修改邮箱的用户，都是激活状态
				int i = userDao.executeByHql(
						"update User set email=:email,flag=:flag where id=:id",
						DataUtils.getMap("email", model.getEmail(), "id",
								user.getId(), "flag",
								Integer.parseInt(FlagType5.验证成功.getName())));
				if (i > 0) {
					return "[OK]";
				} else {
					return "[ERROR]修改邮箱失败";
				}
			}
		}
	}

	// 用户修改或者绑定邮箱
	public String modifyPhone(User model, String securityCode,
			Map<String, Object> session, User user) {
		List<User> us = null;
		if (!securityCode.equals(session.get(Const.SECURITY_CODE))) {
			return "[ERROR]验证码不正确";
		} else {
			us = userDao.findByHql("from User where phone=:phone",
					DataUtils.getMap("phone", model.getPhone()), null, null);
			if (us.size() >= 1) {
				return "[ERROR]手机已存在";
			} else {
				int i = userDao.executeByHql(
						"update User set phone=" + model.getPhone()
								+ " where id=" + user.getId() + "", null);
				if (i > 0) {
					return "[OK]";
				} else {
					return "[ERROR]修改手机失败";
				}
			}
		}
	}

	public String isValidateEmailExist(User model) {
		User user = userDao.findUniqueByHql("from User where email=:email",
				DataUtils.getMap("email", model.getEmail()));
		if (user == null) {
			return "[ERROR]";
		} else {
			return "[OK]";
		}
	}

	public String isValidatePhoneExist(User model) {
		User user = userDao.findUniqueByHql("from User where phone=:phone",
				DataUtils.getMap("phone", model.getPhone()));
		if (user == null) {
			return "[ERROR]";
		} else {
			return "[OK]";
		}
	}

	@Override
	public String findPasswordByPhone(String phone, String phoneRandom,
			String newPwd, HttpServletRequest request,
			Map<String, Object> session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendPhone(String parameter, Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}
}
