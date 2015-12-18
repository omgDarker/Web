// 修复ie8对trim不支持
String.prototype.trim = function () {
    return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}
function slideHeight(){
	var $this=$("#carousel-example-generic");
	if($(window).width()>800){
		$this.css({height:($(window).height()-$this.offset().top-2)+"px"});
	}else{
		$this.css({height:"auto"});
	}
} 
/******************************异步加载：百度分享、QQ等******************************/
function asynLoad(action,target,params){
	var p = $("#"+target);
	if(p.html().trim().length==0){
		callAjax(action,'',true,'3','加载中...',target,params);
	}
}
/** ************个人中心点击修改样式******* */
$(".person-info-menu").click(
	function (){
	$(".person-info-menu").removeClass("selected"); 
	$(this).addClass("selected");
});

$(".navbar-brand").mouseout(
		function (){
			/*
			 * var
			 * $subs=$(".nav-category-sub").css({display:"none",zIndex:"-1"});
			 */
			window.clearTimeout(timeoutCategory);
			timeoutCategory=window.setTimeout(
						function(){$(".nav-category-section").css({display:"none"});},200);
		}
);
/** **********购买数量*********** */
function add(id,maxNum,def){
	var idd="#"+id;
	try{
		if(isNaN(parseInt($(idd).val()))){
			if(def)
				$(idd).val(def);
			else
				$(idd).val('1');
		}
		else
			$(idd).val(parseInt($(idd).val())+1);
		if(parseInt($(idd).val())>maxNum)
			$(idd).val(maxNum);
	}catch  (ex)
	{
		if(def)
			$(idd).val(def);
		else
			$(idd).val('1');
	}
}
function checkNumber(id,maxNum,def)
{
var idd="#"+id;
if(isNaN(parseInt($(idd).val())))
{
	if(def)
		$(idd).val(def);
	else
		$(idd).val('1');
	
}
if(parseInt($(idd).val())>maxNum)
	$(idd).val(maxNum);
if(parseInt($(idd).val())<=0){
	if(def)
		$(idd).val(def);
	else
		$(idd).val('1');
}
}
function min(id,def){
	var idd="#"+id;
	try{
		if(isNaN(parseInt($(idd).val()))){
			if(def)
				$(idd).val(def);
			else
				$(idd).val('1');
		}
		else if(parseInt($(idd).val())>1)
			$(idd).val(parseInt($(idd).val())-1);
		else{
			if(def)
				$(idd).val(def);
			else
				$(idd).val('1');
		}
	}catch  (ex)
	{
		if(def)
			$(idd).val(def);
		else
			$(idd).val('1');
	}

}
/** **********购买数量*********** */
/** **********分页加载更多******* */
var itarget;
function moreTurning(actionName,target){
	itarget = target;
	$("#currentPage").val(parseInt($("#currentPage").val())+1);
	var link = $("#loadingMore").html();
	$("#loadingMore").html(loadText);
	callAjax(actionName,'pageForm',true,'100','false',target,'',moreTurningCallBack,link);
}
function moreTurningCallBack(data,link){
	if (data.indexOf('[ERROR]') < 0){
		// 若返回分页标签，则需要删除，表示分页在返回的页面中，没有则表示分页在该div之外定义
		if(data.indexOf("pageForm")>0)
			$("#pageForm").remove();
		$("#"+itarget).append(data);
	}
	else
		$("#"+itarget).append(err1+"抱歉！系统繁忙，请稍后再试"+err2);
	if(data.trim().length>0)
		$("#loadingMore").html(link);
	else{
		if($("#loadingMore").length>0)
			$("#loadingMore").html("最后一页！");
		else
			$("#"+itarget).html("<div class='tc pt10'>没有数据！</div>")
	}
}
/** **********局部刷新分页******* */
function ajaxTurning(currentPage,actionName,target){
	$("#currentPage").val(currentPage);
	callAjax(actionName,'pageForm',true,'4','PROPUP',target);
}
/** **********翻页************** */
function pageTurning(currentPage){
	$("#currentPage").val(currentPage);
	$("#pageForm").submit();
}
/** *********翻页并添加查询条件***** */
function pageSubmit(id,value){
	// 点击排序,根据奇偶决定降序、升序
	if(id=="p_order"&&$("#p_desc").length>0){
		if($("#"+id).val()==value){
			$("#p_desc").val(parseInt($("#p_desc").val())+1);
		}else{
			$("#p_desc").val(0);
		}
	}
	$("#"+id).val(value);
	$("#currentPage").val("1");
	$("#totalPage").val("0");
	$("#pageForm").submit();
}
function submitForm(id){
	$("#"+id).submit();
}
/** ************刷新验证吗*********** */
/**
 * 图片id 验证码输入框id
 */
function changeimg(imgId,inputId){
	document.getElementById(imgId).src='authImg.img?'+Math.random(); 
	try{
		document.getElementById(inputId).focus();
	}catch(ex){}
	return false;
}

/** *********************页面提示信息显示方法************************* */
/**
 * 显示的div，提示信息，是否晃动，自动隐藏时间：-1为不隐藏，其它为隐藏时间（单位秒) message
 * 为false时表示不需要提示信息，仅需要显示div即可
 */
function showMessage(id,message,ishake,time){
	if(message!=""){
		if(message!="false"&&message!=false)
			$("#"+id).html(message);
		$("#"+id).fadeIn(300);
		if(ishake){
			shake(id);
		}
		if(time!=-1){
			if(isNaN(time))
				time=2000;
			else if(time>0)
				time = time * 1000;
			setTimeout(function(){
				   $("#"+id).fadeOut(500);
				   $("#"+id).hide("fast");
			},time);
		}
	}
}
// 晃动div
function shake(o){
    var $panel = $("#"+o);
    var box_left =0;
    $panel.css({'left': box_left});
    for(var i=1; 4>=i; i++){
        $panel.animate({left:box_left-(8-2*i)},50);
        $panel.animate({left:box_left+2*(8-2*i)},50);
    }
}
/*******************************************************************************
 * 根据点击位置设置div左边
 * 
 * @param id
 * @param e
 *            为空时，局浏览器中部
 * @param lHeight
 * @param lWidth
 * @param onMouse
 *            div是否覆盖点击的点:(0).不覆盖，div居浏览器中部 (1).X轴居中 (2).Y轴居中 (3).X、Y轴均居中
 *            (4).又下方
 */
function lookUp(id, e, lHeight, lWidth ,onMouse) {
	    var lObj = self.document.getElementById(id);
	    var lTop;
	    var lLeft;
	    
	    lTop=$(window).height()/2 - (lHeight/2);
    	lLeft=$(window).width()/2 - (lWidth/2);
	    if(e.clientY&&onMouse&&onMouse!=0){
	    	lTop = e.clientY;
	    	lLeft = e.clientX;
	    	if(onMouse==1){
	    		lLeft = lLeft - (lWidth/2);	
		    }else if(onMouse==2){
		    	lTop = lTop - (lHeight/2);
		    }
		    else if(onMouse==3){
			    lTop = lTop - (lHeight/2);
			    lLeft = lLeft - (lWidth/2);
			}else if(onMouse==4){
				lTop = e.clientY;
		    	lLeft = e.clientX;
			}
	    }
	    if (lLeft < 0) lLeft = 5
	    if ((lLeft + lWidth) > $(window).width()) lLeft = $(window).width() - lWidth - 20;
	    if ((lTop + lHeight) > $(window).height()) lTop =  $(window).height() - lHeight - 70;


	    lObj.style.height = lHeight + 'px';
	    lObj.style.width = lWidth + 'px';
	    lObj.style.left = (lLeft + document.documentElement.scrollLeft) + 'px';
	    lObj.style.top =  (lTop + $(window).scrollTop()) + 'px';
}

/*******************************************************************************
 * 隐藏div
 */
function iClose(id){
	$("#"+id).fadeOut(300);
}
/**
 * 全选、全部选
 * 
 * @param id
 *            点击多选框
 * @param name
 *            需要全选的多选框名称
 */
function selectAll(id,name){
	if($("#"+id).prop("checked")==true)
		$("input[name='"+name+"']").prop("checked",true); 
	else
		$("input[name='"+name+"']").prop("checked",false); 
}
/**
 * 单选
 */
/** ********************************** */
function selectRadio(className,id,radioId){
	var objs = $("."+className)
	objs.removeClass("active");
	var obj = $("#"+id);
	var cobj = $("#"+radioId);
	if(!obj.hasClass("active")){
		obj.addClass("active"); 
		$(cobj).prop("checked",true);
	}
	
}
/**
 * 向用户邮箱发送验证吗，
 */

/**
 * 
 * 用户用邮箱修改密码时或者修改邮箱向注册时的邮箱发送验证码p_flag=NOTONLY表示后台不必验证邮箱是否已存在
 * 用户绑定邮箱时向邮箱发送验证码p_flag=ONLY表示后台得验证该邮箱时否存在
 * emailOrPhoneBtn  显示发送验证按钮的id
 * emailOrPhone     填写email或者phone的input域的id
 * warnEmailOrPhoneMessage  错误提示的div的id
 * flag   flag值为verfyEmail时表示是验证邮箱，否则表示是验证电话
 * subBtn  form表单提交按钮，当subBtn！=undefined时，表示发送验证之前的先验证邮箱或者电话是否存在(修改邮箱或者绑定邮箱时的先验证数据库中是否有该邮箱，有不发送验证码)
 *          当subBtn==undefined时，发送验证码时不需要验证
 */
var iflag=true;
function iSendEmailOrPhoneRomdon(emailOrPhoneBtn,emailOrPhone,warnEmailOrPhoneMessage,flag,subBtn,randomId) {
	var phoneType="";
	var params="";
	if(flag=="verifyEmail"){
		if($("#"+emailOrPhone).length>0){
			if(!iEmail(emailOrPhone,'')){
				showMessage(warnEmailOrPhoneMessage,"输入的邮箱格式有误",true,3);
				return false;
			}
		}
		if(subBtn!=undefined){
			params=""+emailOrPhoneBtn+"_"+warnEmailOrPhoneMessage+"_"+flag+"_"+subBtn+"";
			callAjax('sendEmailRandom','',true,'100','false','','&email='+$("#"+emailOrPhone).val()+'&p_flag=ONLY',ichangeBtnText,params);
		}else{
			params=""+emailOrPhoneBtn+"_"+warnEmailOrPhoneMessage+"_"+flag+"";
			callAjax('sendEmailRandom','',true,'100','false','','&email='+$("#"+emailOrPhone).val()+'&p_flag=NOTONLY',ichangeBtnText,params);
		}
	}else{
		if($("#"+emailOrPhone).length>=0){
			if(!iPhone(emailOrPhone,'')){
				showMessage(warnEmailOrPhoneMessage,"输入的手机号格式有误",true,3);
				return false;
			}
		}
		if(randomId!=undefined){
			//callAjax("verifyCode",'',true,'100','false','','&verifyCode='+$("#"+randomId).val(),iVerifyCodeCallBack,warnEmailOrPhoneMessage);
			$.ajax({
				url:'verifyCode',
				type:'post',
				data:'verifyCode='+$("#"+randomId).val(),
				async:false,
				success:function(data){
					if(data.indexOf('[ERROR]')>=0){
						iflag=false;
						showMessage(warnEmailOrPhoneMessage,'图形验证码输入有误',true,3);
					}else{
						iflag=true;
					}
				}
			});
		}
		if(iflag==true){
		  if(subBtn!=undefined){
			  if(emailOrPhoneBtn=="phoneBtnBySMS"){
			 	 phoneType="sms";
			  }else{
				 phoneType="voices";
			  }
			  params=""+emailOrPhoneBtn+"_"+warnEmailOrPhoneMessage+"_"+flag+"_"+subBtn+"";
			  callAjax('sendPhoneRandom','',true,'100','false','','&phone='+$("#"+emailOrPhone).val()+'&p_flag=ONLY&p_type='+phoneType,ichangeBtnText,params);
	      }else{
			 if(emailOrPhoneBtn=="phoneBtnBySMS"){
				phoneType="sms";
			 }else{
				phoneType="voices";
			 }
			 params=""+emailOrPhoneBtn+"_"+warnEmailOrPhoneMessage+"_"+flag+"";
			 callAjax('sendPhoneRandom','',true,'100','false','','&phone='+$("#"+emailOrPhone).val()+'&p_flag=NOTONLY&p_type='+phoneType,ichangeBtnText,params);
		  }
	   }
	}
}
function ichangeBtnText(message,params){
	var paramArr=params.split("_");
	if(message.indexOf('[OK]')>=0){
		if(paramArr[3]!=undefined){
			$("#"+paramArr[3]).removeAttr("disabled");
		}
		time(paramArr[0],60);
	}else{
		showMessage(paramArr[1],message.replace('[ERROR]',''),true,3);
		if(paramArr[3]!=undefined){
			$("#"+paramArr[3]).attr("disabled",true);
		}else{
			$("#"+paramArr[0]).val(message.replace('[ERROR]',''));
		}
	}
}
/**
 * 发送手机和邮箱获取验证码时的定时器
 **/
var InterValObj; //timer变量，控制时间
var curCount;//当前剩余秒数
function time(obj,timer){
    curCount=timer;
    InterValObj=setInterval(function(){setRemainTime(obj)}, 1000);
}
function setRemainTime(obj){
    if(curCount==0){
        clearInterval(InterValObj);//停止计时器
        $("#"+obj).removeAttr("disabled");//启用按钮
        if(obj.indexOf('SMS')>=0){
        	$("#"+obj).val("短信验证码");
        }else if(obj.indexOf('Voice')>=0){
        	$("#"+obj).val("语音验证码");
        }else{
        	$("#"+obj).val("发送验证码");
        }
    }else{
        curCount--;
        $("#" + obj).attr("disabled", true);
        $("#"+obj).val("重新发送(" + curCount + ")");
    }
}
/** **************文本框改变高度*********** */
function textareaHeight (id,height){
		$("#"+id).attr("rows",height); 
}
/** ***************判断可输入的字数********************** */
function remainNum(id,id2){
	var mylength=document.getElementById(id).value.length;
	document.getElementById(id2).innerHTML=200-mylength;
	
}