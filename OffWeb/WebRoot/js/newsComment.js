/** *****新闻评论js**** */
function showReplyForm(div) {
	var div = $("#" + div);
	div.focus();
}
/***********ajax提交评论
 * event点击事件对象
 * message  发表评论的内容文本框的id
 * user_id   用户Id
 * news_id  新闻Id
 * cId   评论id,如果值不是undefined，则代表是回复评论
 * comRepDivId  某条评论下关于该评论的所有回复的总的div的id
 * replayId  提交回复的包裹回复form表单的div的Id
 * */
function subComment(event,message,cId,comRepDivId,replayId){
	var message=$("#"+message).val();
	var news_id=$("#news_id").val();
	var user_id=$("#user_id").val();
	lookUp('lookUp',event,100,350,0);
	if(user_id==''){
		$("#lookUpContent").html(err1+"&nbsp; 您未登陆！请登录后再评论"+err2);
		showMessage('lookUp','false',false,3);
		return false;
	}
	if(message==''){
		$("#lookUpContent").html(err1+"&nbsp; 评论内容不能为空"+err2);
		showMessage('lookUp','false',false,3);
		return false;
	}
	if(cId==undefined){
		callAjax('addNewsComment','',true,'100','PROPUP','','&u_id='+user_id+'&n_id='+news_id+'&content='+message,addCommentCallBack);
	}else{
		callAjax('addNewsComment','',true,'100','PROPUP','','&u_id='+user_id+'&n_id='+news_id+'&content='+message+'&c_id='+cId,addReplyCallBack,comRepDivId+"|"+replayId);
	}
}
/*******************提交评论后的回调****************/
function addCommentCallBack(data){
	$("#commentFormId form")[0].reset();//清空表单内容
	if(data.indexOf('[ERRORPAGE]')<0&&data.indexOf('[ERROR]')<0){
		$("#news_com").html(data+$("#news_com").html());
		$("#commentNum").html(parseInt($("#commentNum").html())+1);
	}else{
		$("#lookUpContent").html(err1+"&nbsp; 操作失败"+err2);
	}
	showMessage('lookUp','false',false,0);
}
/***************提交回复后的回调*************/
function addReplyCallBack(data,comRepDivId_replayId){
	var comRepDivId=comRepDivId_replayId.split("|")[0];
	var replayId=comRepDivId_replayId.split("|")[1];
	$("#"+replayId+" form")[0].reset();
	if(data.indexOf('[ERRORPAGE]')<0&&data.indexOf('[ERROR]')<0){
		$("#"+comRepDivId).html(data+$("#"+comRepDivId).html());
	}else{
		$("#lookUpContent").html(err1+"&nbsp; 操作失败"+err2);
	}
	showMessage('lookUp','false',false,0);
}
/********************赞评论或者赞回复*****************************/
function praiseComment(cId,event){
	var params="praiseNum_"+cId+",praise_"+cId+","+event+"";
	callAjax('praiseComment','',true,'100','&nbsp;&nbsp;<img src=\"images/loading.gif\" />请稍后...','praise_'+cId,'&id='+cId,praiseCallBack,params);
}
function praiseCallBack(message,params){
	var paramsArr=params.split(",");
	if(message.indexOf('[OK]')>=0){
		lookUp('lookUp',paramsArr[2],100,350,0);
		$("#"+paramsArr[0]).html(parseInt($("#"+paramsArr[0]).html())+1);
		$("#"+paramsArr[1]).html("<i class='iconfont mt-5 B2' title='取消赞'>&#xe62c;</i>");
	}else{
		lookUp('lookUp',paramsArr[2],100,350,0);
		$("#"+paramsArr[0]).html(parseInt($("#"+paramsArr[0]).html())-1);
		$("#"+paramsArr[1]).html("<i class='iconfont mt-5' title='赞'>&#xe62c;</i>");
	}
}