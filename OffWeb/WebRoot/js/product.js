function addToCart(event,params){
	$("#lookUpContent").html(loadText);
	lookUp('lookUp',event,100,300,1);
	showMessage('lookUp','false',false,3);
	callAjax('addToCart','form_buy',true,'100','false','goods_num',params,addToCartCallBack,event)
}
function addToCartCallBack(message,event){
	if (message.indexOf('[BUYNOW]') >= 0){
		$("#lookUpContent").html(succ1+"&nbsp; 正在提交订单，请稍后！"+succ2);
		var id=message.replace('[BUYNOW]', '');
		location.href = "confirmOrder?p_id="+id+"&p_num_"+id+"="+$("#p_num").val();
	}
	else if (message.indexOf('[OK]') >= 0){
		$("#goods_num").html(parseInt($("#goods_num").html())+parseInt(message.replace('[OK]', '')));
		$("#lookUpContent").html(succ1+"&nbsp; 添加成功！"+succ2);
	}else{
		$("#lookUpContent").html(err1+"&nbsp;"+message+err2);
	}
	showMessage('lookUp','false',false,3);
}


function deleteFromCart(event,id){
	goods_id=id;
	$("#lookUpContent").html(loadText);
	lookUp('lookUp',event,100,300,3);
	showMessage('lookUp','false',false,-1);
	callAjax('deleteFromCart','',true,'100','false','','&p_id='+id,deleteFromCallBack,event)
}
function deleteFromCallBack(message,event){
	if (message.indexOf('[OK]') >= 0){
		$("#goods_num").html(parseInt($("#goods_num").html())-1);
		$("#lookUpContent").html(succ1+"&nbsp; 删除成功！3秒后自动关闭"+succ2);
		iClose("cart_"+message.replace('[OK]', ''));
	}else{
		$("#lookUpContent").html(err1+"&nbsp; 抱歉，删除失败！3秒后自动关闭"+err2);
	}
	showMessage('lookUp','false',false,3);
}

function deleteAllFromCart(event){
	$("#lookUpContent").html(loadText);
	lookUp('lookUp',event,100,300,3);
	showMessage('lookUp','false',false,-1);
	callAjax('deleteAllFromCart','',true,'100','false','','',deleteAllFromCartCallBack,event)
}
function deleteAllFromCartCallBack(message,event){
	if (message.indexOf('[OK]') >= 0){
		$("#goods_num").html("0");
		$("#lookUpContent").html(succ1+"&nbsp; 删除成功！3秒后自动关闭"+succ2);
		iClose("cart_table");
	}else{
		$("#lookUpContent").html(err1+"&nbsp; 抱歉，删除失败！3秒后自动关闭"+err2);
	}
	showMessage('lookUp','false',false,3);
}
/***查看物流回调****/
function showLogisticCallBack(message,event){
	try{
	 var content="<table class='table table-condensed table-bordered mb0 table-hover f12'><tr style='background:#000;color:#FFF'><td>时间</td><td>地点和跟踪进度</td></tr>";
	 var json=$.parseJSON(message);
	 var listData=json.data;
	 for(var i=listData.length-1;i>=0;i--){
		 content += "<tr><td>"+listData[i].time+"</td><td>"+listData[i].context+"</td></tr>";
	 }
	 content +="</table>"
	 $(".modal-title").html("物流详情");
	 $(".modal-body").html(content);
	 $("#myModal").modal("show");
	 showMessage('lookUp','false',false,0);
	}catch(ex){
		$("#lookUpContent").html(err1+"抱歉！出错了，3秒后自动关闭"+err2);
		showMessage('lookUp','false',false,3);
	}
}
//订单详情回调
function orderDetailCallBack(message,event){
	if(message.indexOf("[ERROR]")<0){
		 $(".modal-title").html("订单详情");
		 $(".modal-body").html(message);
		 $("#myModal").modal("show");
		 showMessage('lookUp','false',false,0);
	}else{
		 $("#lookUpContent").html(err1+"抱歉！出错了，3秒后自动关闭"+err1);
		 showMessage('lookUp','false',false,3);
	}
}
/********商品添加收藏************/
function collectProduct(event,id){
	callAjax('collectProduct','',true,'100','','','&p_id='+id,addFavorite,event);
}
function addFavorite(message,event){
	if(message.indexOf('[NO]')>=0){
		lookUp('lookUp',event,100,350,0);
		$("#lookUpContent").html(err1+"&nbsp; 您未登陆！请登录后再收藏该产品"+err2);
		showMessage('lookUp','false',false,3);
	}else if(message.indexOf('[COLLECTED]')>=0){
		lookUp('lookUp',event,100,350,0);
		$("#lookUpContent").html(err1+"&nbsp; 您已收藏该商品，请到个人中心查看我的收藏"+err2);
		showMessage('lookUp','false',false,3);
	}else{
		$("#favorite").html(parseInt($("#favorite").html())+1);
		$("#collProduct").html("已收藏");
		//禁用a标签
		$("#collectLink").removeAttr("href");
		$("#collectLink").removeAttr("onclick");
		$("#collectLink").css("color",'#999');
		lookUp('lookUp',event,100,350,0);
		$("#lookUpContent").html(succ1+"&nbsp; 收藏成功"+succ2);
		showMessage('lookUp','false',false,2);
	}
}
/***********添加浏览记录********/
var timerecod=0;
var interval=function(){
	timerecod=timerecod+1;
	if(timerecod>=15){
		var url=window.location.search;
		var pId=url.substring(url.lastIndexOf('=')+1,url.length);
		clearInterval(clearIntervalFun);
		$.post('recordProduct',{p_id:pId});
	}			
}
/***评论回调****/
function addCommentCallBack(message){
	try{
		 $(".modal-title").html("评论商品");
		 $(".modal-body").html(message);
		 $("#myModal").modal("show");
		 showMessage('lookUp','false',false,0);
	}catch(ex){
		alert(ex)
		 $("#lookUpContent").html(err1+"抱歉！出错了，3秒后自动关闭"+err1);
		 showMessage('lookUp','false',false,3);
	}
}

