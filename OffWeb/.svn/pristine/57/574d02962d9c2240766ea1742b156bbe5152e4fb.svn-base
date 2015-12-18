<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
	<!-- 评论 -->
	<s:iterator value="commentLists" var="com">
		<!-- 如果父id为空表示是评论 -->
			<!--  查询父id为该评论的评论集合，如果该集合为空，则表示该评论没有回复，否则表示该评论有回复-->
		      <div class="user-info border mb20">
					 <div class="border-b p15" style="background:#F9F9F9;">
					 	 <div class="f14">${com.user.anonymousName}<div class="C999 f12 pb10">${com.formatStrTime}</div>${com.content}</div>
					 	 
					 	 <div class="fr C999">
						 	<span onclick="showReplyForm('message_${com.id}')" title="回复"><i class="iconfont">&#xe62e;</i></span>&nbsp;&nbsp;
							 	<span class="f12" onclick="praiseComment('${com.id}',event)" id="praise_${com.id}">
							 		<i class="iconfont mt-5 <s:if test="#request.commentPraise.contains('_'+#com.id+'_')">B2" title="取消赞"</s:if><s:else>" title="赞"</s:else>>&#xe62c;</i>
							 	</span>
							 	<span id="praiseNum_${com.id}">${com.praise	}</span> 
					 	</div>
					    <div class="cb"></div>
					 </div>
					 <!-- end评论 -->
			
					<!-- 回复 -->
					<span id="reply_${com.id}">
						<s:iterator value="#com.comments" var="rCom">
							<%@include file="../news/replyComment.jsp"%>
						</s:iterator>
						<div class="cb"></div>
					</span>
					<!-- End:回复 -->
					
					
					
			<div class="mb10" id="${com.id}_comment_reply">
				<form class="mt10" method="post">
					<div class="col-sm-12 mb10">
						<textarea name="content" class="form-control no-radius no-resize" id="message_${com.id}" onfocus="textareaHeight('message_${com.id}',4)"
							placeholder="有什么感想，你也来说说吧！" rows="1" onkeyup="remainNum('message_${com.id }','messageNum_${com.id }')"></textarea>
					</div>
					<div class="col-xs-12 tr C999 f12">
						<span class="mt10 pr15">还可以输入<p class="text-muted" style="display: inline-block;" id="messageNum_${com.id }">200</p>个字</span>
						<button class="btn btn-xs btn-info no-radius" type="button" onclick="subComment(event,'message_${com.id }','${com.id}','reply_${com.id}','${com.id}_comment_reply')">回复</button>
					</div>
				</form>
				<div class="cb"></div>
			</div>
			</div>
	</s:iterator>
    
