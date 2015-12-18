/******************************监听器方法*****************************/
/**订单备注***/
$("#message").blur(function (){textareaHeight("message",1)});
$("#message").focus(function (){textareaHeight("message",3)});
/********热门搜索******/
var showSearchList=0;
$("#p_keyWord").focus(
	function (){
		var p = $("#p_keyWord");
		if($("#hot_serach_list").html().trim().length==0){
			callAjax('searchHotword','',true,'3','加载中...','hot_serach_list');
		}
		$("#hot_serach_list").css({left:p.offset().left+"px",top:(p.offset().top+p.outerHeight(true))+"px",width:(p.outerWidth(true)+1)+"px",display:"block"});
});
$("#p_keyWord").blur(function (){
	if(showSearchList==0)
		$("#hot_serach_list").css({display:"none"});
});
$("#hot_serach_list").mouseout(function (){
	showSearchList=0;
})
$("#hot_serach_list").mouseover(function (){
	showSearchList=1;
});
$("#go_top").click(function (){
	$("html, body").animate({ scrollTop: 0 }, 400);
});
/*****************手机菜单导航****************************/
$(".phone-menu").click(function(){
	var span = $(this).find("span");
	if(span.hasClass("phone-open")){
		span.removeClass("phone-open").addClass("phone-close");
		$(".btn-phone").removeClass("phone-open").addClass("phone-close");
	}else{
		span.removeClass("phone-close").addClass("phone-open");
		$(".btn-phone").removeClass("phone-close").addClass("phone-open");
	}
});
