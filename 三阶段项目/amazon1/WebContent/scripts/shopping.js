function jiesuan(){
	var sumPrice=0;
	var totalPrice=0
	$("#myTableProduct").find("tr").each(function (i,n) {
		 var price=$(n).find("#price").val();
		 var quantity=$(n).find(".quantity").val();
		 var sumPrice=parseDouble(price)*parseInt(quantity);
		 totalPrice=sumPrice+totalPrice;
	});
	$.ajax({
		url : "HwuaProductServlrt?org=doBuy",
		type : "post",
		data : "totalPrice=" + totalPrice,// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(test) {
			if(test>0){ 
				location.href="shopping-result.jsp";
			}else{
				alert("结算失败")
			}
		}
	})
}

function deleteCart(cid) {
	$.ajax({
		url : "HwuaProductServlrt?org=del",// 请求的servlet地址
		type : "post",// 请求方式
		data : "cid=" + cid,// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(test) {
			if(test>0){ 
				alert("删除成功");
				$("#product_id_"+cid).remove();
			}else{
				alert("删除失败")
			}
		}
	})
}

function deleteDetail(did) {
	$.ajax({
		url : "OrderDetallServlet?org=del",// 请求的servlet地址
		type : "post",// 请求方式
		data : "did=" + did,// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(test) {
			if(test>0){ 
				alert("删除成功");
				$("#product_id_"+did).remove();
			}else{
				alert("删除失败")
			}
		}
	})
}



function alterCount(cid) {
	
	
// window.location.href="alterQuantity?"+cid+"_"+$("#"+cid).val()
	$.ajax({
		url : "alterQuantity",// 请求的servlet地址
		type : "GET",// 请求方式
		data : ""+cid+"_"+$("#"+cid).val(),// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(total) {
			$("#cartCount").html(total);
		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {

		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}


// -按钮事件
function reduce(id){
	
	if($("#"+id).val()==1){
		$("#"+id).val(1)
	}else if($("#"+id).val()>=2){
		var old=$("#"+id).val()
		$("#"+id).val(parseInt(old)-1)
	}
	alterCount(id)
}

// +按钮事件
function increase(id){
	var stock=$("#hpStock"+id).val()// 获得库存
	var old=$("#"+id).val()// 获得原来的数量
	if(parseInt(old)<parseInt(stock)){
		$("#"+id).val(parseInt(old)+1)
		alterCount(id)
	}else{
		alert("您选择的数量超过库存!")
	}
	
}



function checkStock(id){
	var stock=$("#hpStock_"+id).val()// 获得库存
	alert(parseInt(stock))
	var old=$("#"+id).val()// 获得原来的数量
	if(parseInt(old)>parseInt(stock)){
		alert("您选择的数量超过库存!")
	}
	else if(parseInt(stock)<0){
		alert("库存数量不能为负数!")
	}else{
		alterCount(id)
	}
}




function buttonTest(id) {
	alert("测试id="+id)
}




	










