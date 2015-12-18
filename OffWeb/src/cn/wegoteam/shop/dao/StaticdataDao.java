package cn.wegoteam.shop.dao;

import org.springframework.stereotype.Repository;

import cn.crap.base.BaseDao;
import cn.wegoteam.shop.inter.StaticdataDaoInter;
import cn.wegoteam.shop.po.Staticdata;

@Repository("staticdataDao")
public class StaticdataDao extends BaseDao<Staticdata> implements StaticdataDaoInter {
   
}
