package cn.wegoteam.shop.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.crap.base.BaseDaoInter;
import cn.crap.base.BaseService;
import cn.wegoteam.shop.inter.StaticdataServiceInter;
import cn.wegoteam.shop.po.Staticdata;

@Service
public class StaticdataService extends BaseService<Staticdata> implements
		StaticdataServiceInter {
	@Resource(name="staticdataDao")
	public void setBaseDao(BaseDaoInter<Staticdata> baseDao) {
		super.setBaseDao(baseDao);
	}
}
