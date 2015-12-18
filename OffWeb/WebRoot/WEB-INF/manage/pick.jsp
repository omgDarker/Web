<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/manage/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="<%=basePath%>lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>addPageInit.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="<%=basePath%>lib/kediter/themes/default/default.css" />
<link href="<%=basePath%>lib/ligerUI/skins/Gray/css/all.css"
	rel="stylesheet" type="text/css" />
<script src="<%=basePath%>lib/jquery/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>lib/ligerUI/js/ligerui.all.js"
	type="text/javascript"></script>
<script src="<%=basePath%>lib/jquery-validation/jquery.validate.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>lib/jquery-validation/jquery.metadata.js"
	type="text/javascript"></script>
<script src="<%=basePath%>lib/jquery-validation/messages_cn.js"
	type="text/javascript"></script>
<script charset="utf-8" src="<%=basePath%>lib/kediter/kindeditor-min.js"></script>
<script charset="utf-8" src="<%=basePath%>lib/kediter/lang/zh_CN.js"></script>
<script
	src="<%=basePath%>addPageInit.js?<%=System.currentTimeMillis()%>"
	type="text/javascript"></script>
</head>

<body
	style="padding:15px;padding-top:0px; margin-bottom: 10px; line-height:20px;">
	<script type="text/javascript">
		function pickCheck(id) {
			id = "#" + id;
			if ($(id).attr("checked")) {
				$(id).attr("checked", false);
			} else {
				$(id).attr("checked", true);
			}
		}
		function pickMouseOver(id) {
			id = "#" + id;
			$(id).css("background-color", "#DDD");
		}
		function pickMouseOut(id) {
			id = "#" + id;
			$(id).css("background-color", "transparent");
		}
		function setPick() {
			var tagId = document.getElementById('tag').value;
			var radio = document.getElementById('radio').value;
			var length = document.getElementsByName('cid').length;
			var checkBox = "";
			for ( var i = 0; i < length; i++) {
				if (radio == 'true') {
					if (document.getElementsByName('cid')[i].checked == true) {
						window.parent.document.getElementById(tagId).value = document
								.getElementsByName('cid')[i].value;
						break;
					}
				} else {
					if (document.getElementsByName('cid')[i].checked == true) {
						checkBox = checkBox
								+ document.getElementsByName('cid')[i].value
								+ ',';
					}
				}
			}
			if (radio == 'false')
				window.parent.document.getElementById(tagId).value = checkBox;
			//回调函数
			var iCallBack='${iCallBack}';
			var iCallBackParam='${iCallBackParam}';
			if(iCallBack!=''&iCallBack!='undefined'){
				if (iCallBackParam!=''&&iCallBackParam!='undefined') {
					iCallBack(iCallBackParam)
				} else {
					eval(iCallBack)()
				}
			}
			window.parent.dialog.close();
		}
		document.onkeydown = function() {
			if (event.keyCode == 13) {
				setPick();
			}
		}
	</script>
	选择后回车即可快速确认
	<br>
	<br>
	<s:if test="radio.equals('true')">
		<s:iterator value="picks">
			<div style="padding:5px;" id="d_${id}" onclick="pickCheck('${id}');"
				onmouseout="pickMouseOut('d_${id}');"
				onmouseover="pickMouseOver('d_${id}');">
				<input id="${id}" type="radio" <s:if test="def.equals(id)">checked</s:if> name="cid" value="${id}">&nbsp;&nbsp;${name}
			</div>
		</s:iterator>
	</s:if>
	<s:else>
		<s:iterator value="picks">
			<div style="padding:5px;" id="d_${id}" onclick="pickCheck('${id}');"
				onmouseout="pickMouseOut('d_${id}');"
				onmouseover="pickMouseOver('d_${id}');">
				<input id="${id}" type="checkbox" name="cid"
					<s:if test="def.contains(id)">checked</s:if> value="${id}">&nbsp;&nbsp;${name}<br>
			</div>
		</s:iterator>
	</s:else>

	<div
		style="float:right;width:100%; border-top:1px dotted #999;margin-left:10px; text-align:right; padding:10 0 10 0;">
		<input type="hidden" id="radio" value="${radio}" /> <input
			type="hidden" id="tag" value="${tag}" /> <input type="submit"
			value="选择" id="Button1" class="l-button l-button-submit"
			onclick="setPick()" />
	</div>


</body>
</html>