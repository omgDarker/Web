<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/manage/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><title>
</title>
    <link href="<%= basePath%>lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="<%= basePath%>addPageInit.css" rel="stylesheet" type="text/css" /> 
    <link rel="stylesheet" href="<%= basePath%>lib/kediter/themes/default/default.css" />
    <link href="<%= basePath%>lib/ligerUI/skins/Gray/css/all.css" rel="stylesheet" type="text/css" /> 
    <script src="<%= basePath%>lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
    <script src="<%= basePath%>lib/jquery-validation/jquery.validate.min.js" type="text/javascript"></script> 
    <script src="<%= basePath%>lib/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
    <script src="<%= basePath%>lib/jquery-validation/messages_cn.js" type="text/javascript"></script>
	<script charset="utf-8" src="<%= basePath%>lib/kediter/kindeditor-min.js"></script>
	<script charset="utf-8" src="<%= basePath%>lib/kediter/lang/zh_CN.js"></script>
	<script src="<%= basePath%>addPageInit.js" type="text/javascript"></script>
</head>

<body style="padding:10px; margin-bottom: 10px;">
 <form name="form1" method="post" action="manageAddComment" id="form1" class="liger-form">
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td align="left" class="l-table-edit-td">新闻标题:</td>
                <td align="left" class="l-table-edit-td">
                	<input name="news.title" value="${model.news.title}" type="text" id="txtName" readonly="readonly" ltype="text" /></td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td" valign="top">评论人:</td>
                <td align="left" class="l-table-edit-td"> 
                     <input name="user.name" value="${model.user.name}" type="text" id="txtName"  readonly="readonly" ltype="text" /></td>
                </td>
                <td align="left"></td>
             </tr>  
             <tr>
                <td align="left" class="l-table-edit-td" valign="top">总赞数:</td>
                <td align="left" class="l-table-edit-td"> 
                     <input name="praise" value="${model.praise}" type="text" id="txtName" readonly="readonly" ltype="text" /></td>
                </td>
                <td align="left"></td>
             </tr> 
             <tr>
                <td align="left" class="l-table-edit-td">评论内容:</td>
            </tr>
        </table>
        <div style="width:100%">
			<textarea id="elm1" name="content" rows="15" cols="20" style="width: 100%; height:200px;">
			${model.content}
			</textarea>
        </div>
 	<br />
 	<input name="id" type="hidden" value="${model.id}" />
	<div style="width:150px; margin:0px auto;">
	   <input type="submit" value="提交" id="Button1" class="l-button l-button-submit"  /> 
	</div>
 </form>
</body>
</html>