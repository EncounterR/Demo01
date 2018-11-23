<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊- 购物车</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/shopping.js"></script>
</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; 购物车
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="doBuy" method="post">
				<table id="myTableProduct">
					<tr>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>购买数量</th>
						<th>操作</th>
					</tr>


					<!-- 根据用户购物车生成列表 -->
					<c:forEach items="${carts}" var="item">
						<tr id="product_id_${item.id }">
							<td class="thumb"><img style="width: 100px; height: 100px;"
								src="${item.hp_file_name }" /><a
								href="HwuaProductServlrt?org=det&pid=${item.pid }">${item.pname }</a></td>
							<td class="price" id="price_id_1">￥<span id="span_1">${item.price }</span>
								<input type="hidden" id="subPrice"
								value="${item.price*item.quantity }" name="sumPrice" /> <input
								type="hidden" value="${item.pid }" name="pId" /> <input
								type="hidden" value="${item.hp_stock }" name="hpStock"
								id="hpStock${item.id }" />
							</td>
							<td class="number"><c:set var="hcid" value="${item.id }"></c:set>
								<input type="button" id="minus" value=" - " width="3px"
								onclick=" reduce(${hcid})" name="minusButton"> 
								<input id="hpStock_${hcid }" type="text" name="number" class="quantity"
								value="${item.quantity }" maxlength="5" size="1"
								style="text-align: center; vertical-align: middle"
								onblur="checkStock(${hcid})" />
								<input type="button" id="add"
								value=" + " width="2px" onclick=" increase(${hcid })"
								name="addButton"></td>
							<td class="delete"><input type="button" value="删除"
								onclick="deleteCart(${item.id })"></td>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${!empty carts}">
					<div class="button">
						<input type="submit" value="" />
					</div>
				</c:if>
			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2016 上海海文 All Rights Reserved.
	</div>
</body>
</html>

