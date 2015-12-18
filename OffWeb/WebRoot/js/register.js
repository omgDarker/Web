/**************用户用邮箱注册时提交请求前对邮箱，密码，验证码格式的验证*******************/
function iEmailRegister(){
	if(!iEmail("email","")){
		showMessage('warnMessage',"请输入有效的邮箱",true,3);
		return false;
	}
	if(!iLength("password",6,20,"")){
		showMessage("warnMessage","密码长度有误(6-20)",true,3);
		return false;
	}
	if($("#randomImageStr").length>=0){
		if(!iLength("randomImageStr",4,4,"")){
			showMessage("warnMessage","验证码的长度有误",true,3);
			return false;
		}
	}
	$("#Md5randomImageStr").val($.md5($("#randomImageStr").val().toLowerCase()));
	return true;
}
/*****************用户用手机注册提交请求前对密码格式的验证*******************************/
function iPhoneRegister(){
	if(!iPhone("phone","")){
		showMessage('warnMessage',"请输入有效的手机号",true,3);
		return false;
	}
	if(!iLength("phonePassword",6,20,"")){
		showMessage("warnMessage","密码长度有误(6-20)",true,3);
		return false;
	}
	if($("#randomPhoneImageStr").length>=0){
		if(!iLength("randomPhoneImageStr",4,4,"")){
			showMessage("warnMessage","验证码的长度有误",true,3);
			return false;
		}
	}
	$("#Md5randomPhoneImageStr").val($.md5($("#randomPhoneImageStr").val().toLowerCase()));
	return true;
}
/******************判断用户是否同意了服务条款，只有同意了，注册提交按钮才能生效*********************/
function setChanage(check,submitBtn){
	if(!$("#"+check).is(':checked')){
		$("#"+submitBtn).attr("disabled",true);
	}else{
		$("#"+submitBtn).removeAttr("disabled");
	}
}
/********************用户采用邮箱注册账号时验证输入的邮箱是否已经被注册过了**********************************/
function iValidateEmail(){
	if(iEmail("email","")){
		callAjax('validateEmailExist','',true,'100','false','','&email='+$("#email").val(),changeRegInput);
	}else{
		showMessage("warnMessage","邮箱的格式有误",true,3);
		$("#regEmail-input").addClass('has-error');
		$("#subBtn").attr("disabled",true);
	}
}
function changeRegInput(message){
	console.info(message);
	if(message.indexOf('[ERROR]')>=0){
		$("#regEmail-input").removeClass('has-error').addClass('has-success');
		$("#subBtn").removeAttr("disabled");
	}else{
		showMessage("warnMessage","邮箱已存在",true,3);
		$("#regEmail-input").addClass('has-error');
		$("#subBtn").attr("disabled",true);
		
	}
}
function iValidatePhone(){
	if(iPhone("phone","")){
		callAjax('validatePhoneExist','',true,'100','false','','&phone='+$("#phone").val(),validatePhoneCallBack);
	}else{
		showMessage("warnMessage","手机格式输入有误",true,3);
		$("#regPhone-input").addClass('has-error');
		$("#phoneBtnBySMS").attr("disabled",true);
		$("#phoneBtnByVoice").attr("disabled",true);
		$("#phoneSubBtn").attr("disabled",true);
	}
}
function validatePhoneCallBack(message){
	if(message.indexOf('[ERROR]')>=0){
		$("#regPhone-input").removeClass('has-error').addClass('has-success');
		$("#phoneBtnBySMS").removeAttr("disabled");
		$("#phoneBtnByVoice").removeAttr("disabled");
		$("#phoneSubBtn").removeAttr("disabled");
	}else{
		showMessage("warnMessage","手机号已存在",true,3);
		$("#regPhone-input").addClass('has-error');
		$("#phoneBtnBySMS").attr("disabled",true);
		$("#phoneBtnByVoice").attr("disabled",true);
		$("#phoneSubBtn").attr("disabled",true);
	}
}