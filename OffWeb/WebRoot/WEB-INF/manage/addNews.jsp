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
	<script src="<%= basePath%>addPageInit.js?999" type="text/javascript"></script>
</head>

<body style="padding:10px; margin-bottom: 10px;">

 <form name="form1" method="post" action="manageAddNews" id="form1" class="liger-form">
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td align="left" class="l-table-edit-td">标题:</td>
                <td align="left" class="l-table-edit-td">
                	<input name="cntitle" value="${model.cntitle}" type="text" id="txtName"  ltype="text"  validate="{required:true,minlength:2}" /></td>
                <td align="left"></td>
            </tr>
             <tr>
                <td align="left" class="l-table-edit-td">英文标题:</td>
                <td align="left" class="l-table-edit-td">
                	<input name="entitle" value="${model.entitle}" type="text" id="txtName"  ltype="text"/></td>
                <td align="left"></td>
            </tr>
           
            <tr>
                <td align="left" class="l-table-edit-td" valign="top">类型:</td>
                <td align="left" class="l-table-edit-td"> 
                <s:select name="type" list="@cn.wegoteam.shop.enu.NewsType@values()" listKey="name()"
								listValue="name" value="model.type.name()"/>
                <td align="left"></td>
            </tr>  
              <tr>
               <td align="left" class="l-table-edit-td">评论:</td>
			   <td align="left" class="l-table-edit-td"> 是否可以评论：<input type="radio" name="canComment"  <s:if test="model.canComment">checked</s:if> value="true">是
			   <input type="radio" name="canComment" <s:if test="!model.canComment">checked</s:if> value="false">否</td>
			   <td align="left"></td>
            </tr>
             <tr>
                <td align="left" class="l-table-edit-td" valign="top">标签（联系我们、帮助...）:</td>
                <td align="left" class="l-table-edit-td"> <input name="tag" type="text" value="${model.tag}" /></td>
                <td align="left"></td>
            </tr>   
              
             <tr>
                <td align="left" class="l-table-edit-td" valign="top">点击量:</td>
                <td align="left" class="l-table-edit-td">
                	${model.click}<input name="click" type="hidden" value="${model.click}" /></td>
                <td align="left"></td>
            </tr>   
            <tr>
                <td align="left" class="l-table-edit-td" valign="top">标识:</td>
                <td align="left" class="l-table-edit-td">
                 <s:select name="flag" list="@cn.wegoteam.shop.enu.FlagType3@values()" listKey="name"
								listValue="name()" value="model.flag"/>
				</td>
                <td align="left"></td>
            </tr> 
              <tr>
                <td align="left" class="l-table-edit-td" valign="top">图片:</td>
                <td align="left" class="l-table-edit-td"> <input name="imgUrl" type="text" value="${model.imgUrl}" /></td>
                <td align="left"></td>
            </tr>   
                   
            <tr>
                <td align="left" class="l-table-edit-td">发布日期:</td>
                <td align="left" class="l-table-edit-td">
                    <input name="date" value="${model.date}" type="text" id="txtDate" ltype="date" validate="{required:true}" />
                </td><td align="left"></td>
            </tr>
             <tr>
                <td align="left" class="l-table-edit-td">新闻内容(中/英文):</td>
            </tr>
        </table>
        <div style="width:100%">
			<textarea id="elm1" name="cncontent" rows="15" cols="20" style="width: 100%; height:200px;">
			${model.cncontent}
			</textarea>
        </div>
        <div style="width:100%; margin-top:50px;">
			<textarea id="elm2" name="encontent" rows="15" cols="20" style="width: 100%; height:200px;">
			${model.encontent}
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