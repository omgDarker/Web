package cn.wegoteam.shop.adm.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import cn.crap.base.PageBean;
import cn.wegoteam.shop.action.BaseAction;
import cn.wegoteam.shop.inter.CommentServiceInter;
import cn.wegoteam.shop.po.Comment;
import cn.wegoteam.shop.util.Const;

@ParentPackage("manage")
@Namespace("/")
@Controller
public class ManCommentAction extends BaseAction<Comment> {
	@Resource
	private CommentServiceInter commentService;
	private List<Comment> listComments;
	private int rowCount;
	@Action(value = "manageCommentList", results = { @Result(name = SUCCESS, location = MANAGE+ "list.jsp") })
	public String manageCommentList() {
	    request.setAttribute("cId", getParameter("cId", ""));
		return SUCCESS;
	}
    /**
     * 加载评论
     * @Param
     * @Return
     */
	@Action(value = "manageLoadCommentList")
	public void manageLoadCommentList() {
		int pageSize = getIntParameter("pageSize");
		int currentPage = getIntParameter("page");
		pageBean = new PageBean();
		pageBean.setSize(pageSize == 0 ? defaultSize : pageSize);
		pageBean.setCurrentPage(currentPage == 0 ? 1 : currentPage);
		pageBean.setTotalPage(getIntParameter("totalPage"));
		if(getParameter("cId")!=null&&!getParameter("cId").equals("")){
			map.clear();
			map.put("comment.id", getIntParameter("cId"));
			writeStringToResponse(commentService.getJsonList(pageBean, map, "insertTime desc"));
		}else{
			map.clear();
			map.put("comment.id|"+Const.NULL,Const.NULL);
			writeStringToResponse(commentService.getJsonList(pageBean, map, "insertTime desc"));
		}
	}
	/**
	 * 添加或者修改一个评论
	 * @Param
	 * @Return
	 */
	@Action(value="manageAddComment")
	public String manageAddComment(){
		if(model.getId()!=null&&!model.getId().equals("")){
			map.put("content", model.getContent());
			map.put("id",model.getId());
			commentService.executeByHql("update Comment set content=:content where id=:id", map);
		}
		return SUCCESS;
	}
	/**
	 * 根据id查询一个评论
	 * @Param
	 * @Return
	 */
	@Action(value = "manageFindCommentById",results={@Result(name=SUCCESS,location=MANAGE+"addComment.jsp")})
	public String manageFindCommentById() {
        if(model.getId()!=null){
			model=commentService.get(model.getId());
		}
		return SUCCESS;
	}
	/**
	 * 删除评论
	 * @Param
	 * @Return
	 */
	@Action(value = "manageDeleteComment")
	public void manageDeleteComment() {
       model=commentService.get(model.getId());
       writeStringToResponse(commentService.delete(model)+"");
	}
}
