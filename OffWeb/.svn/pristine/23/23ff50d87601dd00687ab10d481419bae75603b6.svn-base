<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="comment-box reply p5 pl15 pr15">
	<div class="f12">
		 <div><span class="text-primary">${rCom.user.anonymousName}</span>：${rCom.content}
		 	<div class="C999 f12">
		 		${rCom.formatStrTime}&nbsp;&nbsp;
						 	<span class="f12" onclick="praiseComment('${rCom.id}',event)" id="praise_${rCom.id}">
						 		<i class="iconfont mt-5 <s:if test="#request.commentPraise.contains('_'+#rCom.id+'_')">B2" title="取消赞"</s:if><s:else>" title="赞"</s:else>>&#xe62c;</i>
						 	</span> 
						 	<span id="praiseNum_${rCom.id}">${rCom.praise}</span>
				
		 	</div>
		 </div>
					 	 
	</div>
    <div class="cb"></div>
</div>

