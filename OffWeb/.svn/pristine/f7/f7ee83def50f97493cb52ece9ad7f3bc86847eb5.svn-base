package cn.wegoteam.shop.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.crap.base.DataUtils;
import cn.crap.base.PageBean;
import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.cache.StaticDataCache;
import cn.wegoteam.shop.inter.HotwordServiceInter;
import cn.wegoteam.shop.inter.NewsServiceInter;
import cn.wegoteam.shop.inter.SettingServiceInter;
import cn.wegoteam.shop.inter.StaticdataServiceInter;
import cn.wegoteam.shop.po.News;
import cn.wegoteam.shop.po.Setting;
import cn.wegoteam.shop.po.Staticdata;

public class ContextListener implements ServletContextListener {
	private WebApplicationContext springContext;

	public void contextDestroyed(ServletContextEvent context) {
	}

	public void contextInitialized(ServletContextEvent context) {
		StaticdataServiceInter staticdataService;
		SettingServiceInter settingService;
		NewsServiceInter newsService;
		HotwordServiceInter hotwordService;
		springContext = WebApplicationContextUtils
				.getWebApplicationContext(context.getServletContext());
		if (springContext != null) {
			staticdataService = (StaticdataServiceInter) springContext
					.getBean("staticdataService");
			settingService = (SettingServiceInter) springContext
					.getBean("settingService");
			newsService = (NewsServiceInter) springContext
					.getBean("newsService");
			hotwordService = (HotwordServiceInter) springContext
					.getBean("hotwordService");
		} else {
			return;
		}
		/********* 将staticdata添加至内存 ************/
		List<Staticdata> sds = staticdataService.findByHql("from Staticdata where flag>0", null,null,"pcode,order desc");
		for (Staticdata sd : sds)
			StaticDataCache.setStaticdata(sd);
				
		/********* 将setting添加至application ************/
		List<Setting> sets = settingService.findByHql(
				"from Setting", null);
		Cache.setSetting(sets, context.getServletContext());
				
		List<News> news = newsService.findByHql(
						"from News where type=:type", DataUtils.getMap("type","PAGE"));
		Cache.setNews(news);
		PageBean page = new PageBean();
		page.setSize(6);
		Cache.hotWordList = hotwordService.findByHql("from Hotword where flag>0 ", null , page,"searchTimes desc");
	}

}
