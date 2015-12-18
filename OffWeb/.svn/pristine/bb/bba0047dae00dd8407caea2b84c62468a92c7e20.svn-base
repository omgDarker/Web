
/**
 * 调用 core.js 之前的验证代码
 */

/**
 * 
 * @param id 需要验证的文本域id
 * @param min 最小长度，-1表示不限
 * @param max 最大长度，-1表示不限
 * @param message 不为空时验证失败会调用alert提示
 * @returns {Boolean}
 */
function iLength(id,min,max,message){
	var length=$("#"+id).val().length;
	if((min!=-1&&length<min)||(max!=-1&&length>max)){
		$("#"+id).focus();
		if(message!='')
			alert(message);
		return false;
	}
	return true;
}

/**
 * 当传入的值为空时，返回true
 * @param id
 * @param message 不为空时验证失败会提调用alert提示
 * @returns {Boolean}
 */
function iShuzi(id,message){
	if($("#"+id).val().length==0)
		return true;
	if(isNaN($('#'+id).val())){
		$("#"+id).focus();
		if(message!='')
			alert(message);
		return false;
	}
	return true;
}
var patternUsername=/^[a-zA-Z0-9_\u2E80-\u9FFF]{2,20}$/;
var patternEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
var patternPassword=/^[a-zA-Z0-9_@#\+\-\*\/]{5,20}$/;
var patternPhone=/^((13[0-9])|(15[0-3,5-9])|(17[0,6-8])|(18[0-9]))\d{8}$/;
/**
var patternCard=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
function iCard(id,message){
	var value=$("#"+id).val();
	if(patternCard.test(value)==false){
		$("#"+id).focus();
		if(message!='')
			alert(message);
		return false;
	}else{
		return true;
	}
}**/
function iUserName(id,message){
	var value=$("#"+id).val();
	if(patternUsername.test(value)==false){
		$("#"+id).focus();
		if(message!='')
			alert(message);
		return false;
	}else{
		return true;
	}
}
function iEmail(id,message){
	var value=$("#"+id).val();
	if(patternEmail.test(value)==false){
		$("#"+id).focus();
		if(message!='')
			alert(message);
		return false;
	}else{
		return true;
	}
}

function iPhone(id,message){
	var value=$("#"+id).val();
	if(patternPhone.test(value)==false){
		$("#"+id).focus();
		if(message!='')
			alert(message);
		return false;
	}else{
		return true;
	}
}

function iPwd(id,message){
	var value=$("#"+id).val();
	if(patternPassword.test(value)==false){
		$("#"+id).focus();
		if(message!='')
			alert(message);
		return false;
	}else{
		return true;
	}
}
function equals(str1,str2){
	if(str1==str2){
		return true;
	}else{
		return false;
	}
}
/*非空判断 */
this.isNull = function(str){
	if(str==""){
		return true;
	}
	var regu = /^[\s'　']*$/;
	var re = new RegExp(regu);
	return re.test(str);
};
/**
 * 调用 core.js 之后的刷新代码
 */

