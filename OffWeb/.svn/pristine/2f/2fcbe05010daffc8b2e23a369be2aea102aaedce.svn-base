package cn.wegoteam.shop.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.wegoteam.shop.cache.Cache;
import cn.wegoteam.shop.enu.NewsType;
import cn.wegoteam.shop.inter.CommentServiceInter;
import cn.wegoteam.shop.inter.NewsServiceInter;
import cn.wegoteam.shop.po.Comment;
import cn.wegoteam.shop.po.News;
import cn.wegoteam.shop.util.Const;
import cn.wegoteam.shop.util.GetReqRes;

@ParentPackage("default")
@Namespace("/")
@Controller
public class NewsAction extends BaseAction<News> {

	private static final long serialVersionUID = -7214652284224332303L;
	@Autowired
	private NewsServiceInter newsService;
	@Autowired
	private CommentServiceInter commentService;
	private List<Comment> commentLists;

	@Action(value = "newsList", results = { @Result(name = "success", location = NEWS
			+ "list.jsp") })
	public String newsList() {
		pageBean.setSize(10);
		map.put("type", getParameter("p_type", NewsType.INFOR.name()));
		map.put("flag|>", 0);
		models = newsService.getList(pageBean, map, "flag desc");
		return SUCCESS;
	}

	@Action(value = "newsDetail", results = { @Result(name = "success", location = NEWS
			+ "detail.jsp") })
	public String newsDetail() {
		if (model.getId() == null) {
			model = Cache.getNews(getParameter("p_tag", ""));
			if (model == null) {
				map.put("tag", getParameter("p_tag", ""));
				model = newsService.getList(null, map).get(0);
			}
		} else {
			model = newsService.get(model);
		}
		request.setAttribute(
				"content",
				model.getContent().replaceAll(
						"/attached/images/",
						Cache.getSetting(Const.ALIYUNOSSURL).getValue()
								+ "/attached/images/"));
		map.clear();
		map.put("id", model.getId());
		newsService.executeByHql("update News set click=click+1 where id=:id",
				map);
		pageBean.setSize(3);
		paramMap.put("newsId", model.getId()+"");
		map.clear();
		map.put("news.id", model.getId());
		map.put("comment.id|"+Const.NULL,Const.NULL);
		if(model.isCanComment()){
			commentLists= commentService.getList(pageBean, map, "insertTime desc");
			request.setAttribute("commentPraise", GetReqRes.getCookie(Const.COMMENT_PRAISE));
		}
		return SUCCESS;
	}
	/**************************************/
	public List<Comment> getCommentLists() {
		return commentLists;
	}

	public void setCommentLists(List<Comment> commentLists) {
		this.commentLists = commentLists;
	}

}
