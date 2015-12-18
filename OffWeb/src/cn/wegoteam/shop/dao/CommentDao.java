package cn.wegoteam.shop.dao;

import org.springframework.stereotype.Repository;

import cn.crap.base.BaseDao;
import cn.wegoteam.shop.inter.CommentDaoInter;
import cn.wegoteam.shop.po.Comment;
@Repository("commentDao")
public class CommentDao extends BaseDao<Comment> implements CommentDaoInter {

}
