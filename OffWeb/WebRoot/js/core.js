var succ1 = '<div class=\"text-success tc pt10\"><i class="iconfont">&#xe60b;</i>&nbsp;&nbsp;';
var succ2 = '</div>';
var err1 = '<div class=\"text-danger tc pt10\"><i class="iconfont">&#xe627;</i>&nbsp;&nbsp;';
var err2 = '</div>';
var loadText = "<div class='tc pt10'><img src=\"images/loading.gif\" />&nbsp;&nbsp;努力加载中，请稍后...</div>";

/*******************************************************************************
 *callAjax传递函数时直接写函数名即可，不需要加引号
 ******************************************************************************/

/**
 * 
 * @param iurl
 *            地址
 * @param iFormId
 *            表单id
 * @param iPost
 *            发送方式
 * @param ishowMethod
 *            返回数据显示方式:(1).更新input文本域中的值 (2).更新div中的html，带图标
 *            (3).更新div中的html，不带图标 (4).返回html页面 (5).替换div (6).删除div (100).调用自定义回调函数刷新数据
 * @param iLoading
 *            加载提示文字,false表示不显示提示，包含PROPUP表示弹出提示
 * @param iTarget
 *            刷新数据的div
 * @param iparams
 *            传递的参数
 * @param iCallBack
 *            回调函数
 * @param iCallBackParam
 *            回调函数参数，用于刷新数据
 *        	 
 */
// ----------------------------------//
function callAjax(iUrl, iFormId, iPost, isHowMethod, iLoading, iTarget,
		iParams, iCallBack, iCallBackParam) {

	var aPost = (iPost) ? 'POST' : 'GET'

	// 获取参数
	var xParams = getParams(iFormId);

	// 显示提示语句
	showTip(iTarget,iLoading);

	xParams = xParams + '&CPTS=' + new Date().getTime();
			$.ajax({
				type : aPost,
				url : iUrl,
				data : xParams + iParams,
				complete : function(data) {
					data = data.responseText;
					/*************未登录或发生未知错误********************/
					if(data.indexOf('[ERRORPAGE]') >= 0){
						data = "[ERROR]抱歉，系统繁忙，请稍后再试！";
					}
					if(data.indexOf('[LOGINPAGE]') >= 0){
						data = "[ERROR]尚未登录，请登录后再试！";
					}
					//当返回失败页面时需将data替换成提示语句
					if (isHowMethod == '1') {
						$("#"+iTarget).val(data.replace('[OK]', '').replace('[ERROR]', ''));
					} else if (isHowMethod == '2') {
						if (data.indexOf('[OK]') >= 0)
							$("#"+iTarget).html(succ1+ data.replace('[OK]', '')+ succ2);
						else
							$("#"+iTarget).html(err1+ data.replace('[ERROR]', '') + err2);
					} else if (isHowMethod == '3') {
						$("#"+iTarget).html(data.replace('[OK]', '').replace('[ERROR]', ''));
					} else if (isHowMethod == '4') {
						if (data.indexOf('[ERROR]') < 0){
							if(data.trim().length==0)
								$("#"+iTarget).html("<div class='tc pt10'>没有数据！</div>");
							else
								$("#"+iTarget).html(data);
						}else{
							$("#"+iTarget).html(err1+data.replace('[ERROR]', '')+ err2);
						}
					} else if (isHowMethod == '5') {
						if (data.indexOf('[ERROR]') < 0)
							$("#"+iTarget).replaceWith(data);
					} else if (isHowMethod == '6') {
						if (data.indexOf('[ERROR]') < 0)
							$("#"+iTarget).fadeOut(300);
					}
					else if (isHowMethod == '100') {
						if (iCallBack) {
							if (iCallBackParam) {
								iCallBack(data,iCallBackParam)
							} else {
								iCallBack(data);
							}
						}
					}
					//100需自行处理提示信息
					if (isHowMethod != '100')
						closeTip(data,iLoading,iFormId);
				}
			});
}
function showTip(iTarget,iLoading) {
	if(iLoading.toUpperCase().indexOf('PROPUP') >= 0){
		iLoading = iLoading.replace('PROPUP', '');
		if(iLoading==""){
			iLoading = "努力加载中，请稍后...";
		}
		$("#lookUpContent").html(loadText.replace("努力加载中，请稍后...", iLoading));
		lookUp('lookUp','',100,300,3);
		showMessage('lookUp','false',false,-1);
		return;
	}
	if(iTarget==null||iTarget==''||!iTarget)
		return;
	if (document.getElementById(iTarget)&&document.getElementById(iTarget).tagName != "INPUT") {
		if (iLoading.toUpperCase() != "FALSE"){
			//传递的参数含有图片，表示不以div的形式显示提示内容
			if(iLoading.indexOf("<img")>=0){
				$("#"+iTarget).html(iLoading);
			}else{
				if(iLoading=="")
					iLoading = "努力加载中，请稍后...";
				$("#"+iTarget).html(loadText.replace("努力加载中，请稍后...", iLoading));
			}
		}
	}
}
function closeTip(data,iLoading,iFormId){
	if(iLoading.toUpperCase().indexOf('PROPUP') >= 0){
		if (data.indexOf('[ERROR]') < 0)
			$("#lookUpContent").html(succ1+"&nbsp; 操作成功！2秒后自动关闭"+succ2);
		else{
			$("#lookUpContent").html(err1+data.replace('[ERROR]', '')+"2秒后自动关闭"+err2);
		}
		//pageForm表示分页
		if(iFormId=='pageForm'){
			$("#lookUp").hide();
		}
		else
			showMessage('lookUp','false',false,2);
	}
}
function getParams(form_id) {
	var params = "none=none";
	if (form_id == null || form_id == "")
		return params;
	// 获取所有文本框
	var texts = $("form[id='" + form_id + "'] :input[type='text']");
	$.each(texts, function(i, val) {
		try {
			if (val.name != '')
				params = params + '&' + val.name + '=' + val.value;
		} catch (ex) {
			alert(ex)
		}
	});
	// 获取所有密码
	var passwords = $("form[id='" + form_id + "'] :input[type='password']");
	$.each(passwords, function(i, val) {
		try {
			if (val.name != '')
				params = params + '&' + val.name + '=' + val.value;
		} catch (ex) {
			alert(ex)
		}
	});
	// 获取所有隐藏域
	var hiddens = $("form[id='" + form_id + "'] :input[type='hidden']");
	$.each(hiddens, function(i, val) {
		try {
			if (val.name != '')
				params = params + '&' + val.name + '=' + val.value;
		} catch (ex) {
			alert(ex)
		}
	});
	// 获取所有textarea
	var textareas = $("form[id='" + form_id + "'] textarea");
	$.each(textareas, function(i, val) {
		try {
			if (val.name != '')
				params = params + '&' + val.name + '=' + val.value;
		} catch (ex) {
			alert(ex)
		}
	});
	// 获取所有多选
	var checkboxs = $("form[id='" + form_id
			+ "'] :input[type='checkbox']:checked");
	$.each(checkboxs, function(i, val) {
		try {
			if (val.name != '')
				params = params + '&' + val.name + '=' + val.value;
		} catch (ex) {
			alert(ex)
		}
	});
	// 获取所有单选
	var radios = $("form[id='" + form_id + "'] :input[type='radio']:checked");
	$.each(radios, function(i, val) {
		try {
			if (val.name != '')
				params = params + '&' + val.name + '=' + val.value;
		} catch (ex) {
			alert(ex)
		}
	});
	// 获取所有下拉框
	var selects = $("form[id='" + form_id + "'] select");
	$.each(selects, function(i, val) {
		try {
			if (val.name != '')
				params = params + '&' + val.name + '=' + val.value;
		} catch (ex) {
			alert(ex)
		}
	});
	return params;
}
