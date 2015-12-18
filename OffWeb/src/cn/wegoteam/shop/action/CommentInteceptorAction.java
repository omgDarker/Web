package cn.wegoteam.shop.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import cn.crap.base.DataUtils;
import cn.wegoteam.shop.inter.CommentServiceInter;
import cn.wegoteam.shop.po.Comment;
import cn.wegoteam.shop.po.News;
import cn.wegoteam.shop.po.User;
import cn.wegoteam.shop.util.Const;
import cn.wegoteam.shop.util.GetReqRes;
@ParentPackage("users")
@Namespace("/")
@Controller
public class CommentInteceptorAction extends BaseAction<Comment> {
    @Resource
    private CommentServiceInter commentService;
    private List<Comment> commentLists=new ArrayList<Comment>();;
    @Action(value="addNewsComment",results={@Result(name=SUCCESS,location=NEWS+"comment.jsp"),@Result(name="reply",location=NEWS+"replyComment.jsp")})
    public String addNewsComment(){
    	News news=new News();
    	news.setId(getIntParameter("n_id"));
    	model.setUser(getSessionUser());
    	model.setNews(news);
    	if(getParameter("c_id", "1").equals("1")){
    		commentService.save(model);
    		commentLists.add(commentService.get(model));
    		return SUCCESS;
    	}else{
    		Comment com=new Comment();
    		com.setId(getIntParameter("c_id"));
    		model.setComment(com);
    		commentService.save(model);
    		request.setAttribute("rCom", commentService.get(model));
    		return "reply";
    	}
    }
    @Action(value="getNewsComment",results={@Result(name=SUCCESS,location=NEWS+"comments.jsp")})
    public String getNewsComment(){
    	pageBean.setSize(3);
    	paramMap.put("newsId", getIntParameter("newsId")+"");
    	request.setAttribute("commentPraise", GetReqRes.getCookie(Const.COMMENT_PRAISE));
    	map.clear();
    	map.put("news.id", getIntParameter("newsId"));
    	map.put("comment.id|"+Const.NULL,Const.NULL);
    	commentLists= commentService.getList(pageBean, map, "insertTime desc");
    	return SUCCESS;
    }
    @Action(value="praiseComment")
    public void praiseComment(){
    	if(!GetReqRes.getCookie(Const.COMMENT_PRAISE).contains("_"+model.getId()+"_")){
    		GetReqRes.addCookie(Const.COMMENT_PRAISE,GetReqRes.getCookie(Const.COMMENT_PRAISE)+"_"+model.getId()+"_,");
    		commentService.executeByHql("update Comment set praise=praise+1 where id=:id", DataUtils.getMap("id",model.getId()));
    		writeStringToResponse("[OK]");
    	}else{
    		GetReqRes.addCookie(Const.COMMENT_PRAISE,GetReqRes.getCookie(Const.COMMENT_PRAISE).replace("_"+model.getId()+"_,", ""));
    		commentService.executeByHql("update Comment set praise=praise-1 where id=:id", DataUtils.getMap("id",model.getId()));
    		writeStringToResponse("[ERROR]");
    	}
    }
	public List<Comment> getCommentLists() {
		return commentLists;
	}
	public void setCommentLists(List<Comment> commentLists) {
		this.commentLists = commentLists;
	}
}
