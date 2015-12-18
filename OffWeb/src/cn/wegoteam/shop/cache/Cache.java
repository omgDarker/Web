package cn.wegoteam.shop.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import cn.crap.base.DataUtils;
import cn.crap.base.PageBean;
import cn.wegoteam.shop.inter.HotwordServiceInter;
import cn.wegoteam.shop.inter.NewsServiceInter;
import cn.wegoteam.shop.inter.SettingServiceInter;
import cn.wegoteam.shop.inter.StaticdataServiceInter;
import cn.wegoteam.shop.po.Hotword;
import cn.wegoteam.shop.po.News;
import cn.wegoteam.shop.po.Setting;
import cn.wegoteam.shop.po.Staticdata;
import cn.wegoteam.shop.util.Const;
import cn.wegoteam.shop.util.GetReqRes;

public class Cache {
	private static long lastUpdatedTime = 0;
	private static boolean forceRefresh = true;
	public static List<Hotword> hotWordList = new ArrayList<Hotword>();
	
	/************将setting添加至内存及application范围内*****************/
	private static Map<String,Setting> settingList=new HashMap<String,Setting>();
	public static Setting getSetting(String key){
		return settingList.get(key);
	}
	public static void setSetting(List<Setting> setting,ServletContext sc){
		for(Setting s:setting){
			setSetting(s,sc);
		}
	}
	public static void setSetting(Setting setting){
		setSetting(setting,GetReqRes.getServletContext());
	}
	public static void setSetting(Setting setting, ServletContext sc){
		if(settingList.containsKey(setting.getKey()))
			settingList.remove(setting.getKey());
		settingList.put(setting.getKey(), setting);
		sc.setAttribute(setting.getKey(), setting.getValue());
	}
	/****************************************************************/
	private static Map<String,News> newsList=new HashMap<String,News>();
	public static void setNews(List<News> news){
		for(News s:news){
			newsList.put(s.getTag(), s);
		}
	}
	public static News getNews(String tag){
		if(newsList.containsKey(tag))
			return newsList.get(tag);
		return null;
	}
	
	//首页产品，产品存application范围内
	public synchronized static void updateCache(StaticdataServiceInter staticdataService,SettingServiceInter settingService,
			NewsServiceInter newsService,HotwordServiceInter hotwordService,PageBean page) {
		long currentTime = System.currentTimeMillis();
		if (currentTime - lastUpdatedTime >= 30 * 60 * 1000) {// 30分钟钟更新一次
			lastUpdatedTime = currentTime;
			
			//in 条件不能用占位符？
			//定时更新首页显示的产品
			page.setSize(6);
			hotWordList = hotwordService.findByHql("from Hotword where flag>0 ", null , page,"searchTimes desc");
			/*热销商品，推荐商品*/
			//page.setSize(10);
			//GetReqRes.getServletContext().setAttribute(Const.APP_HOT_PRODUCTS,productService.findByHql("from Product where flag>0 ", null , page,"sellNum desc"));
			//GetReqRes.getServletContext().setAttribute(Const.APP_RECOMMEND_PRODUCTS,productService.findByHql("from Product where flag>0 ", null , page,"flag desc"));
			
			//强制更新系统设置，更新静态数据
			if (forceRefresh) {
				/********* 将staticdata添加至内存 ************/
				StaticDataCache.clear();
				List<Staticdata> sds = staticdataService.findByHql(
						"from Staticdata where flag>0 order by pcode,order desc", null);
				for (Staticdata sd : sds)
					StaticDataCache.setStaticdata(sd);
						
				/********* 将setting添加至application ************/
				List<Setting> sets = settingService.findByHql(
						"from Setting", null);
				Cache.setSetting(sets, GetReqRes.getServletContext());
				
				/********* 将网站页面添加至内存********************/
				List<News> news = newsService.findByHql(
						"from News where type=:type", DataUtils.getMap("type","PAGE"));
				Cache.setNews(news);
				
				forceRefresh = false;
			}
		}
	}
	public static void clear() {
		lastUpdatedTime = 0;
		forceRefresh = true;
	}

	public static long getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public static void setLastUpdatedTime(long lastUpdatedTime) {
		Cache.lastUpdatedTime = lastUpdatedTime;
	}
}
