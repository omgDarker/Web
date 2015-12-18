function cartCalculateTotal(){
	var total = 0;
	var total_num = 0;
	$("input[name='p_id']").each(function(){
		if($(this).prop("checked")==true){
			total_num += 1;
			var id = $(this).val();
			var num = $("#num_"+id).val();
			var price = $("#price_"+id).html();
			total += parseFloat(num)*parseFloat(price);
		}
	});
	$("#total_num").html(total_num);
	$("#p_total").html(total.toFixed(2));
}
function cartCalculate(id){
	var num = $("#num_"+id).val();
	var price = $("#price_"+id).html();
	$("#total_"+id).html((parseFloat(num)*parseFloat(price)).toFixed(2));
	cartCalculateTotal();
}
function cartAddNum(id,max){
	add("num_"+id,max);
	cartCalculate(id);
}
function cartMinNum(id){
	min("num_"+id);
	cartCalculate(id);
}
function carCheckNumber(id,max){
	checkNumber("num_"+id,max);
	cartCalculate(id);
}
function cartSelectAll(id,name){
	selectAll(id,name);
	cartCalculateTotal();
}
function selectLogistics(code,value){
	if(parseFloat(value)<=0)
		value = "0.0";
	selectRadio('logistics',code,'c_'+code);
	selectRadio('logistics',code,'f_'+code);
	$("#freight").html(value);
	$("#finallyPay").html(parseFloat($("#freight").html())+parseFloat($("#total").html()));
}
function submitConfirmOrder(){
	var num = $("#total_num").html();
	if(parseInt(num)<1){
		alert("请至少选择一件商品!");
		return false;
	}
	else
		return true;
}
