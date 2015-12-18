$().ready(function(){
	$("#saveBtn").click(function(){
		var password=$("#password").val();
		var rpassword=$("#rpassword").val();
		if(!iLength('password',5,20,'')){
			showMessage('warnMessage','新密码的长度有误',true,2);
		}else if(!iPwd('password','')){
			showMessage('warnMessage','密码的格式有误',true,2);
		}else if(!equals(password,rpassword)){
			showMessage('warnMessage','两次输入的密码不一样',true,2);
		}else{
			$("#modifyPass_form").attr({'action':'doModifyPass'}).submit();
		}
	});
});
function checkPassWord(param){
	$.ajax({
		url:'checkPassword',
		type:'post',
		data:"password="+$("#"+param).val(),
		success:function(data){
			if(data.indexOf('[ERROR]')>=0){
			   showMessage('warnMessage','原密码输入有误',true,2);
			}
		}
	});
}