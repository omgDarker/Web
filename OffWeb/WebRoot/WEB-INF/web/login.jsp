<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../subPages/css.jsp"%>
<!-- 跳转 -->
<%
    if(session.getAttribute("returnUrl")!= null&&request.getAttribute("redirect")!=null&&
    	request.getAttribute("redirect").equals("true")){
         response.sendRedirect(session.getAttribute("returnUrl")+"");
    }
%>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<body class="small-width" style="background:url(${ALIYUNOSSURL}${LOGINIMG};">
	<%@include file="../subPages/top.jsp"%>
	<div class="container">
		<div class="row p0 m0 mt30 user-register">
			<div class="visible-lg-block col-lg-8"></div>
			<div class="col-sm-12 col-lg-4 p30 shadow panel panel-default ">
					<input type="hidden" value="[ERROR][LOGINPAGE]"/>
					<div id="warnMessage" class="col-sm-12 text-error mb15"></div>
					<form class="form-horizontal p15" role="form" method="post" action="login" onsubmit="return iLogin();" id="login_form">
						<div class="form-group">
								<label  class="sr-only">账号</label>
							    <input type="text" class="form-control" id="userName" value="${model.name }" placeholder="手机号/邮箱/用户名">
							    <input type="hidden" id="Base64userName" name="name" value=""/>	
						</div>
						<div class="form-group">
								<label  class="sr-only">密码</label>
								<input type="password" class="form-control" id="userPassword" value="<s:if test="#request.remberPwd.equals('true')">remberPwd</s:if>" placeholder="密码（6-20个字符）">
							    <input type="hidden" id="Md5password" name="password" value="${model.password }"/>
						</div>
						<div class="form-group">
								<label  class="sr-only">验证码</label>
								<input type="text" class="form-control" id="randomImageStr" placeholder="请输入验证码，不区分大小写"/>
								<input type="hidden" value="" id="Md5randomImageStr" name="randomImageStr"/>
						</div>
						<div class="form-group">
								<label  class="sr-only">验证码</label>
								<img src="authImg.img" id="image" onclick="changeimg('image','randomImageStr');"/>
								<a class="dis-in-blo ml10" title="忘记密码？ " href="javascript:void(0)"  onclick="changeimg('image','randomImageStr');">看不清？ </a>
						</div>
						<div class="form-group">
									<input type="checkbox" name="remberPwd" id="remberPwd" <s:if test="#request.remberPwd.equals('true')">checked</s:if> value="true">
									记住密码
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-block btn-success">登入<i class='iconfont'>&#xe60e;</i></button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
	<!-- 可选: 包含 jQuery 库 -->
	<%@include file="../subPages/footer.jsp"%>
	<script type="text/javascript" src="js/jquery.base64.js"></script>
	<script type="text/javascript" src="js/jQuery.md5.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <script type="text/javascript">
        callAjax('refreshRandomImageStr','login_form',true,'1','','randomImageStr');
	    showMessage('warnMessage','${tipMessage}',true,3);
	</script>
		 
</body>
</html>
