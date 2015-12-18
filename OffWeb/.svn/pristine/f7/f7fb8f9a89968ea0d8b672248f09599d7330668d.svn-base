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
				<h2 class="text-success fb"> <s:property value="#request.pageTitle!=null&&!#request.pageTitle.trim().equals('')?#request.pageTitle:'操作成功'" /></h2>
				<p>${pageMessage}</p>
			</div>
			<div class="cb"></div>
			<hr/>
			<div class="col-xs-12 mt20">
				<h3>
					<span>${tipMessage}</span>
				</h3>
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
