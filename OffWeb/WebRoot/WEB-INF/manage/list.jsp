<%@ page language="java" import="java.util.*,com.opensymphony.xwork2.ActionContext" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/manage/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>
</title>
    <link href="<%= basePath%>lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <link href="<%= basePath%>lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>   
    <script src="<%=basePath%>lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>
    <script src="<%=basePath%>listInit.js?99955" type="text/javascript"></script> 
   
    <s:if test="clazz.equals('News')">
    	<script type="text/javascript">
       		var p_type="${type}";
       		var p_flag="${flag}";
    	</script>
    	<script src="<%= basePath%>news.js?8988" type="text/javascript"></script>
    </s:if>
    <s:elseif test="clazz.equals('User')">
    	<script type="text/javascript">
       		var p_type="${type}";
    	</script>
    	<script src="<%= basePath%>user.js?999" type="text/javascript"></script>
    </s:elseif>
    <s:elseif test="clazz.equals('Staticdata')">
    	<script type="text/javascript">
       		var p_pcode="${spcode}";
    	</script>
    	<script src="<%= basePath%>staticdata.js?99d9" type="text/javascript"></script>
    </s:elseif>
    
    <s:elseif test="clazz.equals('Hotword')">
    	<script type="text/javascript">
       		var p_flag="${flag}";
    	</script>
    	<script src="<%= basePath%>hotword.js?888df" type="text/javascript"></script>
    </s:elseif>
    <s:elseif test="clazz.equals('Setting')">
    	<script src="<%= basePath%>setting.js?999" type="text/javascript"></script>
    </s:elseif>
    <s:elseif test="clazz.equals('Comment')">
        <script type="text/javascript">
           var cId="${cId}";
        </script>
        <script src="<%=basePath%>comment.js" type="text/javascript"></script>
    </s:elseif>
</head>
<body  style="padding:10px">
 <div class="l-clear"></div>
 	<button class="l-button" style="width:120px;line-height:15px;" onclick="addNewRow('${clazz}')">添加${clazz}</button>
    <div id="maingrid" style="margin-top:20px"></div> <br />
</body>
</html>
