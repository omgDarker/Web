<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="box-heading mt10 mr20 ml20">
	<i class="iconfont f18 B2">&#xe62e;</i> 已有&nbsp; <span class="B2 fb f16" id="commentNum">${pageBean.allRow}</span> &nbsp;条评论
</div>
<div class="f12 p5"  id="commentFormId">
	<div class="mb10  C999 tr pr20">还可以输入<span id="messageNum">200</span>个字</div>
	<form class="mt10" method="post">
		<div class="col-sm-12 mb10">
			<textarea class="form-control no-radius no-resize" id="message1" onfocus="textareaHeight('message1',4)"
				placeholder="有什么感想，你也来说说吧！" rows="2" onkeyup="remainNum('message1','messageNum')"></textarea>
		</div>
		<div class="col-sm-8">
			<s:if test="#session.session_user==null">
				<span class="error">您还没有登录!</span>请&nbsp;<a href="preLogin">登录</a>&nbsp;或&nbsp;<a
					href="preRegister">注册</a>
			</s:if>
			<s:else>
				<span class="B2"><s:property value="#session.session_user.name" /></span>
				<span class="note-grey">&nbsp;欢迎你!</span>
			</s:else>
		</div>
		<div class="col-sm-4 tr">
			<input type="hidden" id="user_id"
				value="<s:property value="#session.session_user.id"/>" /> <input
				type="hidden" id="news_id" value="${model.id}" />
			<button class="btn no-radius btn-sm btn-info"
				onclick="subComment(event,'message1');"
				type="button">发表评论</button>
		</div>
		<div class="cb"></div>
	</form>
	<div class="cb"></div>
</div>