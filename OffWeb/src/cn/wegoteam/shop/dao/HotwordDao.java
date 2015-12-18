package cn.wegoteam.shop.dao;

import org.springframework.stereotype.Repository;

import cn.crap.base.BaseDao;
import cn.wegoteam.shop.inter.HotwordDaoInter;
import cn.wegoteam.shop.po.Hotword;

@Repository("hotwordDao")
public class HotwordDao extends BaseDao<Hotword> implements HotwordDaoInter {
   
}
