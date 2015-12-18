package cn.wegoteam.shop.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.crap.base.BaseDao;
import cn.wegoteam.shop.inter.UserDaoInter;
import cn.wegoteam.shop.po.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements UserDaoInter {
   
}
