package cn.wegoteam.shop.util;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;

public class Email {
	static Integer i = 0;
	public final static String MAILSERVERHOST = "smtp.mxhichina.com";
	/**
	 * 
	 * @param email
	 * @param subject
	 * @param content
	 * @param htmlStyle 是否添加html样式
	 * @return
	 */
	public static boolean sendEmail(String email, String subject, String content,boolean htmlStyle) {
		if (!Tools.isEmail(email)) {
			return false;
		}
		if(subject.length()>30)
			subject = subject.substring(0,30);
		content = emailSubject(subject, content,htmlStyle);
		try {
			MailSenderInfo mailInfo = new MailSenderInfo();
			String temp = "error@ytworld.cn";
			mailInfo.setMailServerHost(MAILSERVERHOST);
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			mailInfo.setUserName(temp);
			mailInfo.setPassword("Yt2015-#");// 您的邮箱密码
			mailInfo.setFromAddress(temp);
			mailInfo.setToAddress(email);
			mailInfo.setSubject(subject);
			mailInfo.setContent(content);
			SimpleMailSender sms = new SimpleMailSender();
			MailcapCommandMap mc = (MailcapCommandMap) CommandMap
					.getDefaultCommandMap();
			mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
			mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
			mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
			mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
			CommandMap.setDefaultCommandMap(mc);
			@SuppressWarnings("static-access")
			boolean b = sms.sendHtmlMail(mailInfo);// 发送html格式
			return b;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public static boolean sendEmail(String email, String subject, String content) {
		return sendEmail(email,subject,content,true);
	}

	private static String getEmail() {
		if (i < 10)
			i++;
		if (i >= 10)
			i = 0;
		return i + "";
	}
	private static String emailSubject(String title, String content,boolean htmlStyle) {
		if(!htmlStyle){
			return title+"<br>"+content;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<div style=\"position:relative;width:500px;margin:0 auto; background:#444;color:#FFF; font-size:14px;line-height:36px;\">");
		sb.append("<div style=\"height:60px; border-bottom:2px solid #609700;padding:10px;\" >");
		sb.append("<div style=\"float:left;margin-left:10px; line-height:60px;font-size:20px;font-weight:bold;color:#6cf;width:360px;height:60px;overflow:hidden;text-align:left;\">");
		sb.append("<a style=\"color:#6cf;\" href=\"http://lejiezu.com?sj="
				+ System.currentTimeMillis() + "\">" + title + "</a>");
		sb.append("</div></div><div style=\"padding:20px;min-height:200px;\">");
		sb.append(content);
		sb.append("</div><div style=\"padding:20px;text-align:right;\">");
		sb.append("本邮件由倍力康网上商城&nbsp;系统发送，请勿回复,<br>如果你不是预期的接收者，请忽略此邮件。<br>");
		sb.append("如有打扰，深感抱歉，谢谢！<br></div></div>");
		return sb.toString();
	}

	public static void main(String[] arg) {
	System.out.println(Email.sendEmail("2390619002@qq.com", "订单通知及验证码", "你在倍力康商城的验证码为：559080"));	

	}
}
