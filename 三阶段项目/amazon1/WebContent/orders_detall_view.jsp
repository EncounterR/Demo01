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
<title>亚马逊 - 订单页</title>
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
<style type="text/css">
#oderview {
	font-size: 14px
}
</style>
</head>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; 所有订单记录
	</div>
	<div class="wrap">
		<div id="shopping">
			<table id="oderview">
				<!-- 根据用户所有购买记录生成列表 -->
				<c:forEach items="${orders}" var="order">
					<c:forEach items="${order.details}" var="detail">
						<tr id="product_id_${detail.hod_id}">
							<td class="thumb"><img style="width: 100px; height: 100px;"
								src="${detail.product.hp_file_name }" /><a
								href="HwuaProductServlrt?org=det&pid=${detail.product.hp_id }">${detail.product.hp_name }</a></td>
							<td class="price">￥<span>单价：${detail.product.hp_price }</span>
							</td>
							<td class="number"><span>X${detail.hod_quantity }</span></td>
							<c:if test="${order.ho_status==1}">
								<td class="delete">正在发货</td>
							</c:if>
							<c:if test="${order.ho_status==2}">
								<td class="delete">已收货</td>
								<td class="delete"><a
									href="HwuaProductServlrt?org=toComment&pid=${detail.product.hp_id }">去评价</a></td>
								<td class="delete"><input type="button" value="删除"
									onclick="deleteDetail(${detail.hod_id})"></td>
							</c:if>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2016 上海海文 All Rights Reserved.
	</div>
</body>
</html>

