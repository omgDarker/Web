package cn.wegoteam.shop.util;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class Tools {
	public static boolean JudgeIsMoblie() {
		HttpServletRequest request = ServletActionContext.getRequest();
		boolean isMoblie = false;
		if (request.getHeader("User-Agent") != null) {
			for (String mobileAgent : mobileAgents) {
				if (request.getHeader("User-Agent").toLowerCase()
						.indexOf(mobileAgent) >= 0) {
					isMoblie = true;
					break;
				}
			}
		}
		return isMoblie;
	}

	public static boolean isEmail(String email) {
		if (null == email || "".equals(email))
			return false;
		// Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //绠?崟鍖归厤
		Pattern p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 澶嶆潅鍖归厤
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isValid(Collection col) {
		if (col == null || col.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	private static final String[] mobileAgents = { "iphone", "android",
			"phone", "mobile", "wap", "netfront", "java", "opera mobi",
			"opera mini", "ucweb", "windows ce", "symbian", "series", "webos",
			"sony", "blackberry", "dopod", "nokia", "samsung", "palmsource",
			"xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
			"docomo", "up.browser", "up.link", "blazer", "helio", "hosin",
			"huawei", "novarra", "coolpad", "webos", "techfaith", "palmsource",
			"alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips",
			"sagem", "wellcom", "bunjalloo", "maui", "smartphone", "iemobile",
			"spice", "bird", "zte-", "longcos", "pantech", "gionee",
			"portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct",
			"320x320", "240x320", "176x220", "w3c ", "acs-", "alav", "alca",
			"amoi", "audi", "avan", "benq", "bird", "blac", "blaz", "brew",
			"cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno",
			"ipaq", "java", "jigs", "kddi", "keji", "leno", "lg-c", "lg-d",
			"lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
			"mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm",
			"pana", "pant", "phil", "play", "port", "prox", "qwap", "sage",
			"sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar",
			"sie-", "siem", "smal", "smar", "sony", "sph-", "symb", "t-mo",
			"teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda",
			"wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw",
			"xda", "xda-", "Googlebot-Mobile" };
}
