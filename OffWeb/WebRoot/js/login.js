function iLogin(){
	if(!iLength("userName",2,20,"")){
		showMessage("warnMessage","用户名长度有误（2-20）",true,3);
		return false;
	}
	if(!iUserName("userName","")&&!iEmail("userName","")&&!iPhone("userName","")){
		showMessage("warnMessage","用户名中含有非法字符...",true,3);
		return false;
	}
	if(!iLength("userPassword","6","20","")){
		showMessage("warnMessage","密码长度有误...",true,3);
		return false;
	}
	if(!iLength("userPassword",5,20,"")){
		showMessage("warnMessage","密码长度有误（5-20）",true,3);
		return false;
	}
	if(!iPwd("userPassword","")){
		showMessage('warnMessage',"密码中含有非法的字符...",true,3);
		return false;
	}
	if($("#randomImageStr").length>0){
		if(!iLength('randomImageStr','4','4','')){
			showMessage('warnMessage',"验证码长度不正确...",true,3);
			return false;
		}
	}
	var password="";
	if($("#userPassword").val()=="remberPwd"&&$("#Md5password").val()!="")
		password=$("#Md5password").val();
	else
		password=$.md5($("#userPassword").val());
	//var temppassword=$.md5(parseInt((new Date()).valueOf()/1000000)+password+$("#randomImageStr").val().toLowerCase());
	$("#Md5randomImageStr").val($.md5($("#randomImageStr").val().toLowerCase()));
	$("#Md5password").val(password);
	$("#Base64userName").val($.base64.encode(escape($("#userName").val())));
	return true;
}