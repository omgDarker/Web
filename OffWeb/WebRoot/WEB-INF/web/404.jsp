<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="renderer" content="webkit">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="" />
<meta name="description" content="" />
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/base-min.css" rel="stylesheet" type="text/css" />
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/pageCss.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.primary-color{color:${PRIMARY_COLOR}}
	.second-color{color:${SECOND_COLOR}}
	.match-color{color:${MATCH_COLOR}}
	.link-color{color:${LINK_COLOR}}
	
	.primary-bg{background:${PRIMARY_COLOR}}
	.second-bg{background:${SECOND_COLOR}}
	.match-bg{background:${MATCH_COLOR}}
	.a a{color:${LINK_COLOR}!important}
	.a a:hover{color:${HOVER_COLOR}!important}
	.border-left-color{border-left-color:${MATCH_COLOR}}
	.border-top-color{border-top-color:${MATCH_COLOR}}
</style>
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
 <![endif]-->
<title>404</title>
</head>
<meta http-equiv="refresh" content="5; url=index"/>
 <body class="small-width" style="background:url(${ALIYUNOSSURL}${IMG};">
	<input type="hidden" value="[ERROR][ERRORPAGE]"/><!-- 区别是返回jason还是返回jsp页面 -->
	<div class="container">
		<div class="row mt30 mb100 min-h400 shadow bg-white p30">
			<div class="col-xs-12 pb20 f14">
				<h2 class="B2 fb"> 错误404</h2>
				<p class="pt20 f18">找不到资源</p>
			</div>
			<div class="cb"></div>
			<hr/>
			<div class="col-xs-12 mt20">
				<h4 class="pt30"><span class="B2">错误详情:</span>你请求的页面不存在！</h4>
				<p class="C999 pt30">
					您将在5秒内回到<a href="index"> 首页</a>
				</p>
			</div>
		</div>
	</div>
	<%@include file="../subPages/footer.jsp"%>
</body>
</html>
