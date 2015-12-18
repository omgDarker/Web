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

    <form name="form1" method="post" action="manageAddUser" id="form1">
<div>
</div>
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
            <tr>
                <td align="left" class="l-table-edit-td">用户名:</td>
                <td align="left" class="l-table-edit-td">
                	 <input name="name" type="text" value="${model.name}" />
                </td>
                <td align="left"></td>
            </tr>
            <tr>
               <td align="left" class="l-table-edit-td">性别:</td>
			   <td align="left" class="l-table-edit-td"><s:select
						name="sex"
						list="@cn.wegoteam.shop.enu.SexType@values()"
						listKey="name()" listValue="name" value="model.sex.name()"></s:select>
				</td>
				<td align="left"></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">密码:</td>
                <td align="left" class="l-table-edit-td">
                <input name="password" type="text" value="" />
                </td>
                <td align="left"></td>
            </tr>
             <tr>
                <td align="left" class="l-table-edit-td">邮箱:</td>
                <td align="left" class="l-table-edit-td">
                <input name="email" type="text" value="${model.email}" />
                </td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">手机:</td>
                <td align="left" class="l-table-edit-td">
                <input name="phone" type="text" value="${model.phone}" />
                </td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">QQ:</td>
                <td align="left" class="l-table-edit-td">
                <input name="qq" type="text" value="${model.qq}" />
                </td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">用户积分:</td>
                <td align="left" class="l-table-edit-td">
                <input name="bounds" type="text" value="${model.bounds}"  />
                </td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td">用户等级:</td>
                <td align="left" class="l-table-edit-td">
                <input name="grade" type="text" value="${model.grade}"  />
                </td>
                <td align="left"></td>
            </tr>
            <tr>
                <td align="left" class="l-table-edit-td" valign="top">标识:</td>
                <td align="left" class="l-table-edit-td"> 
                <s:select name="flag" list="@cn.wegoteam.shop.enu.FlagType5@values()" listKey="name"
								listValue="name()" value="model.flag"/>
                <td align="left"></td>
           		</tr> 
               <tr>
                <td align="left" class="l-table-edit-td" valign="top">类型:</td>
                <td align="left" class="l-table-edit-td"> 
                <s:select name="type" list="@cn.wegoteam.shop.enu.UserType@values()" listKey="name()"
								listValue="name" value="model.type.name()"/>
                <td align="left"></td>
           		</tr> 
           		
           		<tr>
                <td align="left" class="l-table-edit-td">选择权限:</td>
                <td align="left" class="l-table-edit-td">
                <input name="authority" id="authority" value="${model.authority}" type="text" 
                	onclick="loadPick(event,360,240,'false','authority','STATICDATA','','${model.authority}','&p_code=AUTHORITY&p_type=NO');"/>
                </td>
                 <td></td>
            </tr>
            
            <tr>
                <td align="left" class="l-table-edit-td">选择角色:</td>
                <td align="left" class="l-table-edit-td">
                <input name="role" id="role" value="${model.role}" type="text" 
                	onclick="loadPick(event,360,240,'false','role','STATICDATA','','${model.role}','&p_code=ROLE&p_type=NO');"/>
                </td>
                 <td></td>
            </tr>
           		
        </table>
        <div style="width:100%">
        </div>
 <br />
<input name="id" type="hidden" value="${model.id}" />
<div style="width:150px; margin:0px auto;">
<input type="submit" value="提交" id="Button1" class="l-button l-button-submit"  /> 
</div>
 </form>
<script type="text/javascript">
  console.info($("#id").val());
</script>
</body>
</html>