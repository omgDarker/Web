package cn.wegoteam.shop.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.crap.base.BaseDaoInter;
import cn.crap.base.BaseService;
import cn.wegoteam.shop.inter.CommentServiceInter;
import cn.wegoteam.shop.po.Comment;
@Service("commentService")
public class CommentService extends BaseService<Comment> implements
		CommentServiceInter {
    @Resource(name="commentDao")
    public void setBaseDao(BaseDaoInter<Comment> baseDao) {
    	// TODO Auto-generated method stub
    	super.setBaseDao(baseDao);
    }
}
