$().ready(function(){
	$("#saveBtn").click(function(){
		var subarea=$("#subarea").val();
		var detailAddress=$("#detailAddress").val();
		var postcode=$("#postcode").val();
		var accepter=$("#accepter").val();
		var phone=$("#phone").val();
		var telephone=$("#telephone").val();
		if(isNull(subarea)){
			showMessage('warnMessage','所在地区不能为空',true,3);
		}else if(isNull(detailAddress)){
			showMessage('warnMessage','详细地址不能为空',true,3);
		}else if(isNull(postcode)||isNaN(postcode)){
			showMessage('warnMessage','邮政编码格式不正确',true,3);
		}else if(isNull(accepter)){
			showMessage('warnMessage','接受人不能为空',true,3);
		}else if(isNull(phone)&&isNull(telephone)){
			showMessage('warnMessage','手机号和电话必须填一项',true,3);
		}else{
			callAjax('saveOrUpdateAddr', 'address_form', true, 4, '', 'infoHtml')
		}
	});
	var defaultAddress=$("#defaultAddress").val();
	if(defaultAddress=="2"){
		$("#defaultAddress").attr("checked",true);
	}
})