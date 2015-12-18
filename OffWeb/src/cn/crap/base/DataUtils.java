package cn.crap.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class DataUtils {
	/*
	 *查询为null的字段，则使用_NULL代替,空用_BLANK代替
	 */
	public static String getHql(Map<String, Object> map) {
		StringBuffer hql = new StringBuffer();
		if (map == null||map.size()==0) {
			return " where 1=1 ";
		}
		if (map.size() > 0) {
			hql.append(" where ");
		}
		List<String> removes = new ArrayList<String>(); 
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value == null || value.toString().trim().equals("")||value.toString().trim().equals("null")) {
				removes.add(key);
				continue;
			}
			if (key.indexOf("|") > 0) {
				String[] keys = key.split("\\|");
				if (keys[1].equals("in")) {
					hql.append(keys[0] + " in (" + value.toString() + ") and ");
					removes.add(key);
				} 
				else if (keys[1].equals(Const.NULL)) {
					hql.append(keys[0] + " =null and ");
					removes.add(key);
				} 
				else if (keys[1].equals(Const.BLANK)) {
					hql.append(keys[0] + " ='' and ");
					removes.add(key);
				} 
				else if (keys[1].equals("like")) {
					if (!MyString.isEmpty(value.toString()))
						hql.append(keys[0] + " like '%" + value.toString() + "%' and ");
					removes.add(key);
				}else{
					hql.append(keys[0] +" "+ keys[1]+":" + keys[0].replaceAll("\\.", "_") + " and ");//替换. ，占位符包含.时会报错
				}
			}
			else
				hql.append(key + "=:" + key.replaceAll("\\.", "_") + " and ");
		}
		if (map.size() > 0) {
			hql.replace(hql.lastIndexOf("and"), hql.length(), "");
		}
		for (String remove : removes)
			map.remove(remove);
		return hql.toString();
	}

	/*
	 */
	public static Map<String, Object> getMap(Object... params) {
		if (params.length == 0 || params.length % 2 != 0) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < params.length; i = i + 2) {
			if (params[i + 1] != null&& !params[i + 1].toString().trim().equals("")&& !params[i + 1].toString().trim().equals("null"))
				map.put(params[i].toString(), params[i + 1]);
		}
		return map;

	}
//
//	/*
//	 */
//	public static String md5(String str) {
//		try {
//			StringBuffer sb = new StringBuffer();
//			char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//					'A', 'B', 'C', 'D', 'E', 'F' };
//			byte[] bytes = str.getBytes();
//			MessageDigest messd = MessageDigest.getInstance("MD5");
//			byte[] bt = messd.digest(bytes);
//			for (byte b : bt) {
//				sb.append(chars[(b >> 4) & 0x0F]);
//				sb.append(chars[b & 0x0F]);
//			}
//			return sb.toString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/*
	 * 获取当前系统时间的毫秒数
	 */
	public final static String currentTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		calendar.getInstance(Locale.CHINESE);
		return dateFormat.format(calendar.getTime()).toString();
	}

	public static void main(String[] args) {
		System.out.println(DataUtils.currentTime());
	}
}
