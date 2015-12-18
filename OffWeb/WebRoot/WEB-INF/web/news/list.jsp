<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@include file="../../subPages/css.jsp"%>
<body class="small-width">
   <%@include file="../../subPages/top.jsp"%>
 <%@include file="../../subPages/nav.jsp"%>
	<div class="container mb30">
		<div class="row shadow bg-white mt10 p15 pt0 min-h400">
			<s:iterator value="models">
				<div class="news-list col-sm-12 m0">
					<div class="col-xs-12 col-sm-8"><a href="newsDetail?id=${id}">${title}</a></div>
					<div class="col-xs-12 col-sm-4 tr news-date f12 fm">
						<s:property value="@Static@getStatic('L_CLICK').lang"/>:${click}&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="@Static@getStatic('L_TIME').lang"/>:${date}
					</div>	
					<div class="cb"></div>	
				</div>
							
			</s:iterator>
			<pt:pageTag  page="${pageBean}" path="newsList" style="NUM,SMALL" paramMap="${paramMap}"/>
		</div>
		
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!--包含底部的页面  -->
	<%@include file="../../subPages/footer.jsp"%>
</body>


