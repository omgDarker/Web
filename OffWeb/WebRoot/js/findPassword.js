//用与验证根据邮箱找回密码时邮箱和验证码的格式是否输入的正确
function findPassByEmial(email,randomNum){
	if(!iEmail(email,"邮箱输入有误")){
		return false;
	}
	if(!iShuzi(randomNum,"只能为数字")){
		return false;
	}
	if(!iLength(randomNum,6,6,"验证码只能为6位数字")){
		return false;
	}
	return true;
}
//用与验证根据手机找回密码时手机号和验证码是否输入的正确
function findPassByPhone(phone,randomNum){
	if(!iPhone(phone,"手机号的格式输入有误")){
		return false;
	}
	if(!iShuzi(randomNum,"只能为数字")){
		return false;
	}
	if(!iLength(randomNum,6,6,"验证码只能为6位数字")){
		return false;
	}
	return true;
}
function resetPass(){
	var password=$("#password").val();
	if(!iLength('password',5,20,"密码长度有误")){
		return false;
	}
	if(!iPwd('password',"密码的格式有误")){
		return false;
	}
	var rpassword=$("#rpassword").val();
	if(!equals(password,rpassword)){
		alert("两次输入的密码不同");
		return false;
	}
	$("#Md5password").val(password);
	return true;
}

function ivalidateEmailAndGetRandom(emailBtn,email,warnMessage,flag,subEmailBtn){
	if(!iEmail(email,'')){
		showMessage(warnMessage,'邮箱格式有误',true,3);
		return false;
	}
	var params=""+emailBtn+"_"+email+"_"+warnMessage+"_"+flag+"_"+subEmailBtn;
	callAjax("validateEmailExist",'',true,'100','false','','&email='+$("#"+email).val(),iEARCallBack,params);
}
function iEARCallBack(message,params){
	var paramArr=params.split("_");
	if(message.indexOf('[OK]')>=0){
		$("#"+paramArr[4]).removeAttr("disabled");
		iSendEmailOrPhoneRomdon(paramArr[0],paramArr[1],paramArr[2],paramArr[3]);
	}else{
		showMessage(paramArr[2],"邮箱不存在",true,3);
		$("#"+paramArr[4]).attr("disabled",true);
	}
}
function ivalidatePhoneAndGetRandom(phoneBtn,phone,warnMessage,flag,subPhoneBtn){
	if(!iPhone(phone,'')){
		showMessage(warnMessage,'手机号格式有误',true,3);
		return false;
	}
	var params=""+phoneBtn+"_"+phone+"_"+warnMessage+"_"+flag+"_"+subPhoneBtn;
	callAjax("validatePhoneExist",'',true,'100','false','','&phone='+$("#"+phone).val(),iPARCallBack,params);
}
function iPARCallBack(message,params){
	var paramArr=params.split("_");
	if(message.indexOf('[OK]')>=0){
		$("#"+paramArr[4]).removeAttr("disabled");
		iSendEmailOrPhoneRomdon(paramArr[0],paramArr[1],paramArr[2],paramArr[3]);
	}else{
		showMessage(paramArr[2],"手机号不存在",true,3);
		$("#"+paramArr[4]).attr("disabled",true);
	}
}