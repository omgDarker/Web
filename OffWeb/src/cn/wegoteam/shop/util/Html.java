package cn.wegoteam.shop.util;

import cn.wegoteam.shop.cache.Cache;


public class Html {
	private static final String defaultImg="images/default1000_500.jpg";
	private static final String sdefaultImg="images/default700.jpg";
//	public static String img(String imgs, String height) {
//		return img(imgs, height, false);
//	}
//	public static String img(String imgs, String height,boolean sm) {
//		if(!MyString.isEmpty(height))
//			height="height=\""+ height + "\"";
//		String aliyunImg="";
//		try {
//			aliyunImg=Cache.getSetting(Const.ALIYUNOSSURL).toString();
//			String url=(imgs!=null&&imgs.indexOf(",")>0)?imgs.split(",")[0]:imgs;
//			if(MyString.isEmpty(url))
//				url=aliyunImg+(sm?sdefaultImg:defaultImg);
//			else
//				url=aliyunImg+url;
//			return "<img src=\""+url+"\" "+height+"/>";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "<img src=\""+aliyunImg+(sm?sdefaultImg:defaultImg)+"\" "
//					+ height + "/>";
//		}
//	}
//	public static String imgSrc(String imgs) 
//	{
//		return imgSrc(imgs,false);
//	}
//	public static String imgSrc(String imgs,boolean sm) {
//		String aliyunImg="";
//		try {
//			aliyunImg= Cache.getSetting(Const.ALIYUNOSSURL).getValue();
//			String url=(imgs!=null&&imgs.indexOf(",")>0)?imgs.split(",")[0]:imgs;
//			if(MyString.isEmpty(url))
//				return aliyunImg+(sm?sdefaultImg:defaultImg);
//			else
//				return aliyunImg+url;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return aliyunImg+imgs;
//			//return aliyunImg+(sm?sdefaultImg:defaultImg);
//		}
//	}
}