<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../subPages/css.jsp"%>
<!-- <meta http-equiv="refresh"
	content="5; url=<s:property value="#request.returnPage!=null&&!#request.returnPage.trim().equals('')?#request.returnPage:'index'"/>" />
 -->
 <body class="small-width" style="background:url(${ALIYUNOSSURL}${IMG};">
	<input type="hidden" value="[ERROR][ERRORPAGE]"/><!-- 区别是返回jason还是返回jsp页面 -->
	<%@include file="../subPages/top.jsp"%>
	<div class="container">
		<div class="row mt30 mb100 min-h400 shadow bg-white p30">
			<div class="col-xs-12 pb20 f14">
				<h2 class="B2 fb"> <s:property value="#request.pageName!=null&&!#request.pageName.trim().equals('')?#request.pageName:'操作失败'" /></h2>
				<p>${pageMessage}</p>
			</div>
			<div class="cb"></div>
			<hr/>
			<div class="col-xs-12 mt20">
				<h3>
					<span>系统繁忙，请稍后再试！</span>
				</h3>
				<h4 class="pt30"><span class="B2">错误详情:</span>【${tipMessage}】</h4>
				<p class="C999 pt30">
					您将在5秒内回到<a href="<s:property value="#request.returnPage!=null&&!#request.returnPage.trim().equals('')?#request.returnPage:'index'"/>"> <s:property
							value="#request.returnName!=null&&!#request.returnName.trim().equals('')?#request.returnName:'首页'" />
					</a>
				</p>
			</div>
		</div>
	</div>
	<%@include file="../subPages/footer.jsp"%>
</body>
</html>
