/** **************显示修改邮箱的模态框***************** */
function showModalEmail(flag) {
	console.info(flag);
	clearInterval(InterValObj);// 停止计时器
	callAjax('toModifyEmailPage', '', true, '100', 'PROPUP', '', '&p_flag='
			+ flag, showModalEmailCallBack, flag);
}
function showModalEmailCallBack(data, flag) {
	$("#modal-body").html(data);
	if (flag == "MODIFY")
		$(".modal-title").html("修改邮箱");
	else
		$(".modal-title").html("绑定邮箱");
	$("#modal-dialog").css({
		width : "450px"
	});
	showMessage("lookUp", "false", false, 0);
	$("#myModal").modal("show");
}
/** *************用户输入注册时的邮箱，同时验证该邮箱是否是该用户的******************** */
function verifyEmail(email, warnEmailMessage, securityCode) {
	callAjax('verifyEmail', '', true, '100', 'false', '', '&email='
			+ $("#" + email).val() + '&securityCode='
			+ $("#" + securityCode).val(), checkVerifySecurityCode,
			warnEmailMessage);
}
function checkVerifySecurityCode(message, warnEmailMessage) {
	clearInterval(InterValObj);// 停止计时器
	if (message.indexOf('[ERROR]') >= 0) {
		showMessage(warnEmailMessage, message.replace("[ERROR]", ""), true, 3);
	} else {
		callAjax('toModifyEmailPage', '', true, '4', 'false', 'modal-body',
				'&p_flag=UPDATE');
	}
}
/** **************未绑定的邮箱的用户，绑定邮箱*************************** */
function modifyOrBindingEmail(email, warnEmailMessage, securityCode) {
	if (!iEmail(email, '')) {
		showMessage(warnEmailMessage, '邮箱的格式输入有误', true, 3);
		return false;
	}
	callAjax('modifyOrBindingEmail', '', true, '100', 'false', '', '&email='
			+ $("#" + email).val() + '&securityCode='
			+ $("#" + securityCode).val(), checkSecurityCode, warnEmailMessage);
}
/**
 * 验证用户注册时的邮箱的回调函数 验证用户输入的验证码是否是正确的，不正确提示
 */
function checkSecurityCode(message, warnEmailMessage) {
	if (message.indexOf('[ERROR]') >= 0) {
		showMessage(warnEmailMessage, message.replace("[ERROR]", ""), true, 3);
	} else {
		location.href = "personCenter";
	}
}
/** ***********显示修改电话的模态框*********** */
function showModalPhone(flag) {
	clearInterval(InterValObj);// 停止计时器
	callAjax("toModifyPhonePage", '', true, '100', 'PROPUP', '', '&p_flag='
			+ flag, showModalPhoneCallBack, flag);
}
function showModalPhoneCallBack(data, flag) {
	$("#modal-body").html(data);
	if (flag == "MODIFY")
		$(".modal-title").html("更换号码");
	else
		$(".modal-title").html("绑定手机");
	$("#modal-dialog").css({
		width : "450px"
	});
	showMessage("lookUp", "false", false, 0);
	$("#myModal").modal("show");
}
function verifyPhone(phone, warnPhoneMessage, securityCode) {
	callAjax('verifyPhone', '', true, '100', 'false', '', '&phone='
			+ $("#" + phone).val() + '&securityCode='
			+ $("#" + securityCode).val(), checkVerifyPhoneSecurityCode,
			warnPhoneMessage);
}
function checkVerifyPhoneSecurityCode(message, warnPhoneMessage) {
	clearInterval(InterValObj);// 停止计时器
	if (message.indexOf('[ERROR]') >= 0) {
		showMessage(warnPhoneMessage, message.replace("[ERROR]", ""), true, 3);
	} else {
		callAjax('toModifyPhonePage', '', true, '4', 'false', 'modal-body',
				'&p_flag=UPDATE');
	}
}
function modifyOrBindingPhone(phone, warnPhoneMessage, securityCode) {
	if (!iPhone(phone, '')) {
		showMessage(warnPhoneMessage, '手机格式输入有误', true, 3);
		return false;
	}
	callAjax('modifyOrBindingPhone', '', true, '100', 'false', '', '&phone='
			+ $("#" + phone).val() + '&securityCode='
			+ $("#" + securityCode).val(), checkPhoneSecurityCode,
			warnPhoneMessage);
}
function checkPhoneSecurityCode(message, warnPhoneMessage) {
	if (message.indexOf('[ERROR]') >= 0) {
		showMessage(warnPhoneMessage, message.replace("[ERROR]", ""), true, 3);
	} else {
		location.href = "personCenter";
	}
}
/** **********用户修改个人信息********** */
function modifyUserInfo() {
	if ($("#manClass").hasClass("active")) {
		callAjax('modifyUserInfo', '', true, '100', 'false', '', '&name='
				+ $("#name").val() + '&p_sex=' + $("#mSex").val() + '&qq='
				+ $("#qq").val(), modifyUserCallBack);
	} else {
		callAjax('modifyUserInfo', '', true, '100', 'false', '', '&name='
				+ $("#name").val() + '&p_sex=' + $("#fSex").val() + '&qq='
				+ $("#qq").val(), modifyUserCallBack)
	}
}
function modifyUserCallBack(message) {
	if (message.indexOf("[OK]") >= 0) {
		location.href = "personCenter";
	} else {
		showMessage("warnMessage", "修改失败", true, 3);
	}
}
/** ***************申请成为代理商************** */
/** ***************申请成为代理商************** */
function chanageTitle(name1, name2) {
		$("#title-name").html(name1);
		$("#title-img").html(name2);
}
function callBack(msg, imageUrl) {
	var image=$("#image");
	var imgDiv=$("#imgDiv");
	if (msg.indexOf("[OK]") >= 0) {
		$("#image").show();
		$("#image").attr("src", $("#aliyun").val() + imageUrl + "");
		$('#select-file').html("<span class='text-success'><i class=\"iconfont\">&#xe60b;</i>&nbsp;&nbsp;上传成功</div>");
		showMessage('lookUp', 'false', false, 3);
	}else {
		$("#lookUpContent").html(err1 + "&nbsp; " + msg + "" + err2);
		showMessage('lookUp', 'false', false, 3);
	}
	if (imageUrl != undefined) {
		$("#imgUrl").val(imageUrl);
	}
}
function subAgentInfo(event) {
	$("#agent_form").removeAttr('action');
	$("#agent_form").removeAttr('target');
	var imgUrl = $("#imgUrl").val();
	if ($("#name").val()=="") {
		showMessage("warnMessage", "姓名或公司名不能为空", true, 3);
		return false;
	}
	if (imgUrl == "") {
		showMessage("warnMessage", "请上传指定格式的照片", true, 3);
		return false;
	}
	if (!iEmail("aEmail", "")) {
		showMessage("warnMessage", "邮箱格式不正确", true, 3);
		return false;
	}
	if (!iPhone("aPhone", "")) {
		showMessage("warnMessage", "电话号码的格式不正确", true, 3);
		return false;
	}
	callAjax('saveAgent', 'agent_form', true, '100', 'false', '', '',saveAgentCallBack, event);
}
function uploadAgentImg(event){
	lookUp('lookUp',event,100,350,0); 
	$("#lookUpContent").html("上传中，请稍后...");
	showMessage('lookUp', 'false', false, -1);
}
function saveAgentCallBack(data, event) {
	lookUp('lookUp', event, 100, 350, 0)
	$("#agent_form")[0].reset();
	$("#imgUrl").val('');
	if (data.indexOf('[OK]') >= 0) {
		$("#image0").hide();
		$("#image1").hide();
		$("#select-file").html('');
		$("#select-file1").html('');
		$("#lookUpContent").html(succ1 + "&nbsp; 信息提交成功,感谢你的加盟!验证通过后，我们会通知您" + succ2);
		showMessage('lookUp', 'false', false, -1);
		
	}
}
/******************鼠标移动到图片上，图片放大效果***************/
function moveOver(event,imgId){
	var cont =" <div>"+"<img src=\"" + document.getElementById(imgId).src + "\" />"+"</div>";
	 $(".modal-title").html("查看大图");
	 $(".modal-body").html(cont);
	 $("#myModal").modal("show");
}