package cn.wegoteam.shop.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.crap.base.BaseDaoInter;
import cn.crap.base.BaseService;
import cn.wegoteam.shop.inter.NewsServiceInter;
import cn.wegoteam.shop.po.News;

@Service
public class NewsService extends BaseService<News> implements
		NewsServiceInter {
	
	@Resource(name="newsDao")
	public void setBaseDao(BaseDaoInter<News> baseDao) {
		super.setBaseDao(baseDao);
	}
}
