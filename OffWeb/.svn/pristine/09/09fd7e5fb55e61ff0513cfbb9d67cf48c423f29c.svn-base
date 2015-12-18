<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@include file="../../subPages/css.jsp"%>
<body class="small-width">
	<%@include file="../../subPages/top.jsp"%>
	<%@include file="../../subPages/nav.jsp"%>
	<div class="container mb30">
		<s:if test="model.type.name().equals('INFOR')">
			<div class="news-detail row shadow bg-white mt10 p50 lh26 min-h400">
				<div class="tc">
					<h4 class="pb10 roman">${model.title}</h4>
					<hr>
					<span class="C999 fm f12 lh30">
						<s:property value="@Static@getStatic('L_CLICK').lang"/>:${model.click}
						&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="@Static@getStatic('L_TIME').lang"/>:${model.date}
					</span>
				</div>
				${model.content}
			</div>
		</s:if>
		<s:else>
		<div class="news-detail row shadow bg-white mt0 p0 min-h400 p20 lh26">
			<div class="news-detail-title mb20 roman border-left-color">${model.title}</div>
			${model.content}
		</div>
		</s:else>
		<!-- 新闻标识为3表示新闻不可评论 
		<s:if test="model.canComment">
			<div class="row shadow bg-white">
			     <div class="col-xs-12 box-block blog-single">
			         <%@include file="../../web/news/addComment.jsp"%>
			         <div class="box-content clearfix m10 p10" id="commentLists">
			         	 <span id="news_com">
				        	 <%@include file="../../web/news/comments.jsp"%>
				         </span>
			         </div>
			     </div>
			</div>
		</s:if>-->
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!--包含底部的页面  -->
	<%@include file="../../subPages/footer.jsp"%>
	<script type="text/javascript" src="js/newsComment.js"></script>
</body>


