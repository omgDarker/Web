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

    <form name="form1" method="post" action="manageAddStaticdata" id="form1">
<div>
</div>
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
        	 <tr>
        	 	<td align="left" class="l-table-edit-td">id:</td>
                <td align="left" class="l-table-edit-td">
                		${model.id}
                </td>
               <td></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">PCode:</td>
                <td align="left" class="l-table-edit-td">
                 <input name="pcode" type="text" value="${model.pcode}" /></td>
                  <td></td>
            </tr>
             <tr>
                <td align="left" class="l-table-edit-td">排序:</td>
                <td align="left" class="l-table-edit-td">
                 <input name="order" type="text" value="${model.order}" /></td>
                  <td></td>
            </tr>
             <tr>
                <td align="left" class="l-table-edit-td">Code:</td>
                <td align="left" class="l-table-edit-td">
                 <input name="code" type="text" value="${model.code}" /></td>
                  <td></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">类型:</td>
                <td align="left" class="l-table-edit-td">
               	<input name="type" type="text" value="${model.type}" />
                 </td><td></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">链接</td>
                <td align="left" class="l-table-edit-td">
                 <textarea name="link" rows="10" cols="10" style="width:100%;text-align:left; height:80px;"><s:property value="model.link"/></textarea>
                 </td><td></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">名称:</td>
                <td align="left" class="l-table-edit-td">
                 <input name="name" type="text" value="${model.name}" /></td>
                  <td></td>
            </tr> 
            <tr>
                <td align="left" class="l-table-edit-td">英文名称:</td>
                <td align="left" class="l-table-edit-td">
                 <input name="enName" type="text" value="${model.enName}" /></td>
                  <td></td>
            </tr> 
            <s:if test="model.type.equals('SUBNAV')">
            	<tr>
                <td align="left" class="l-table-edit-td">商品属性:</td>
                <td align="left" class="l-table-edit-td">
                <input name="value" id="value" value="${model.value}" type="text" 
                	onclick="loadPick(event,360,240,'false','value','STATICDATA','','${model.value}','&p_code=ATTR&p_type=NO');"/>
                </td>
                 <td></td>
            </tr>
            </s:if>
            <s:elseif test="model.pcode.equals('ROLE')">
            	<tr>
                <td align="left" class="l-table-edit-td">选择权限:</td>
                <td align="left" class="l-table-edit-td">
                <input name="value" id="value" value="${model.value}" type="text" 
                	onclick="loadPick(event,360,240,'false','value','STATICDATA','','${model.value}','&p_code=AUTHORITY&p_type=NO');"/>
                </td>
                 <td></td>
            </tr>
            </s:elseif>
            <s:else>
            	<tr>
                <td align="left" class="l-table-edit-td">值:</td>
                <td align="left" class="l-table-edit-td">
                 <textarea name="value" rows="10" cols="10" style="width:100%;text-align:left; height:80px;">${model.value}</textarea>
                </td>
                 <td></td>
            	</tr>
            </s:else>
            <tr>
                <td align="left" class="l-table-edit-td" valign="top">标识:</td>
                <td align="left" class="l-table-edit-td">
                 <s:select name="flag" list="@cn.wegoteam.shop.enu.FlagType3@values()" listKey="name"
								listValue="name()" value="model.flag"/>
				</td>
                <td align="left"></td>
            </tr> 
             <tr>
                <td align="left" class="l-table-edit-td">描述:</td>
                <td align="left" class="l-table-edit-td" colspan="3">
                <textarea name="description" rows="10" cols="10" style="width:100%;text-align:left; height:80px;">${model.description}</textarea></td>
                <td></td>
            </tr>
        </table>
 <br />
 <input name="id" type="hidden" value="${model.id}" />
<div style="width:150px; margin:0px auto;">
<input type="submit" value="提交" id="Button1" class="l-button l-button-submit"  /> 
</div>
 </form>

    
</body>
</html>