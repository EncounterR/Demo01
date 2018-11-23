<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品显示</title>
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
	src="${pageContext.request.contextPath}/scripts/product_view.js"></script>


<script>
function goingToBuy(pid) {
	window.location.href="HwuaProductServlrt?org=toBuy&pid="+pid+"&count="+$("#count").val();
	}
</script>

</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		<c:set value="${requestScope.categoryForProduct}" var="s"></c:set>
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; <a
			href="category?cate=parent&hpcId=${s[0] }">${s[1] }</a> &gt; <a
			href="category?cate=child&hpcId=${s[2] }">${s[3] }</a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div id="product" class="main">
			<h1>商品名称:${prodouct.hp_name }</h1>
			<div class="infos">
				<div class="thumb">
					<img style="width: 100px; height: 100px;"
						src="${prodouct.hp_file_name }" />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥${prodouct.hp_price }</span>
					</p>
					<c:choose>
						<c:when test="${prodouct.hp_stock>0 }">
							<p>
								库 存：<span id="stock">${prodouct.hp_stock }</span>(有货)
							</p>
						</c:when>
						<c:otherwise>
							<p>库 存：无货
						</c:otherwise>
					</c:choose>
					<input type="button" id="minus" value=" - " width="3px"
						onclick="minus();"> <input type="text" id="count"
						name="count" onblur="checkStock()" value="1" maxlength="5"
						size="1" style="text-align: center; vertical-align: middle">
					<input type="button" id="add" value=" + " width="2px"
						onclick="add();">
					<c:choose>
						<c:when test="${sessionScope.user==null }">
							<div class="button">
								<input type="button" name="button" value="" onclick="remaind();"
									style="background: url(images/buyNow.png)" /> <input
									type="image" name="imageField" src="images/cartbutton.png"
									onclick="remaind()" />
							</div>

						</c:when>
						<c:otherwise>
							<div class="button">
								<input type="button" name="button" value=""
									onclick="goingToBuy(${prodouct.hp_id });"
									style="background: url(images/buyNow.png)" /> <input
									type="image" name="imageField" src="images/cartbutton.png"
									onclick="addToCart(${prodouct.hp_id });" />
							</div>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					商品名字：${prodouct.hp_name }<br /> 商品描述：${prodouct.hp_description }<br />
					商品价格：￥${prodouct.hp_price }<br /> 商品库存：${prodouct.hp_stock }<br />

				</div>
				<div class="text">
					<h1>商品评论</h1>
					<ul>
						<c:forEach items="${comments}" var="item">
							<li>
								<dl>
									<dt>内容：${item.hc_content }</dt>
									<dd class="author">
										<span>作者：${item.hc_nick_name }</span>
									</dd>
									<dd>评论时间：${item.hc_create_time }</dd>
								</dl>
								<br>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2016 上海海文 All Rights Reserved.
	</div>
</body>
</html>

