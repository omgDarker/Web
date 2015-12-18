package cn.wegoteam.shop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 根据输入的字符串，日期，日期格式返回相应的日期字符串
 * @author TT
 *
 */
public class DateFormartUtil {
	//yyyyMMddHHmmSS
	//周末
	public static boolean isWeekend(String date){
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate1=null;
		try {
			myDate1 = dateFormat1.parse(date);
		} catch (ParseException e) {
			return false;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(myDate1);
		if(Calendar.FRIDAY == c.get(Calendar.DAY_OF_WEEK)||Calendar.SATURDAY == c.get(Calendar.DAY_OF_WEEK)){
			return true;
		}else
			return false;
		
	}

	public static int xingqu(String date){
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate1 = null;
		try {
			myDate1 = dateFormat1.parse(date);
		} catch (ParseException e) {
			return -1;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(myDate1);

		if (Calendar.MONDAY == c.get(Calendar.DAY_OF_WEEK)) {
			return 1;
		}
		if (Calendar.TUESDAY == c.get(Calendar.DAY_OF_WEEK)) {
			return 2;
		}
		if (Calendar.WEDNESDAY == c.get(Calendar.DAY_OF_WEEK)) {
			return 3;
		}
		if (Calendar.THURSDAY == c.get(Calendar.DAY_OF_WEEK)) {
			return 4;
		}
		if (Calendar.FRIDAY == c.get(Calendar.DAY_OF_WEEK)) {
			return 5;
		}
		if (Calendar.SATURDAY == c.get(Calendar.DAY_OF_WEEK)) {
			return 6;
		}
		if (Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK)) {
			return 0;
		}
		return 0;

	}
	public static String getDateByFormat()
	{
		return getDateByFormat(new Date(),"yyyy-MM-dd");
	}
	public static String getDateByFormatAddOneHour()
	{
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 1);
		return getDateByFormat(c.getTime(),"ddHH");
	}
	public static String getDateByFormatAddOneDay(String date)
	{
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate1=null;
		try {
			myDate1 = dateFormat1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(myDate1);
		c.add(Calendar.DAY_OF_MONTH, 1);
		return getDateByFormat(c.getTime(),"yyyy-MM-dd");
	}
	public static long getCurrentTimeMillis(String date,String format)
	{
		SimpleDateFormat dateFormat1 = new SimpleDateFormat(format);
		Date myDate1=null;
		try {
			myDate1 = dateFormat1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(myDate1);
		
		return c.getTimeInMillis();
	}
	public static long getCurrentTimeMillis(String date)
	{
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		Date myDate1=null;
		try {
			myDate1 = dateFormat1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(myDate1);
		
		return c.getTimeInMillis();
	}
	public static String getDateByFormat(String date,String fromat)
	{
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		Date myDate1=null;
		try {
			myDate1 = dateFormat1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getDateByFormat(myDate1,fromat);
	}
	public static String getDateByFormatDecOneDay(String date)
	{
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate1=null;
		try {
			myDate1 = dateFormat1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(myDate1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		return getDateByFormat(c.getTime(),"yyyy-MM-dd");
	}
	public static String getChinaDate(String date){
		date=date.substring(5,date.length());
		date=date.replace("-", "月");
		date=date+"日";
		return date;
	}
	public static String getEstablishDate(String str){
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	      Long time=Long.valueOf(str);
	      String d = format.format(time);
	      return d;
	}
	public static String getDateByFormat(String daf){
		return getDateByFormat(new Date(),daf);
	}
	public static String getDateByFormat(SimpleDateFormat daf){
		return   getDateByFormat(new Date(),daf);
	}
	public static String getDateByFormat(Date date,String daf){
		SimpleDateFormat dafe=new SimpleDateFormat(daf);
		return getDateByFormat(date,dafe);
	}
	public static String getDateByFormat(Date date,SimpleDateFormat daf){
		String dateStr=daf.format(date);
		return  dateStr;
	}
	public static void main(String avg[]){
       String date="2015-04-08 21:07:56";	
       System.out.println(date.substring(0,date.lastIndexOf(" ")).trim());
	}
}
