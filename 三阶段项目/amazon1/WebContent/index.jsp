
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊-首页</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
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
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="middle">
		<div class="p_left">
			<!--商品分类-->
			<%@ include file="index_product_sort.jsp"%>
			<!--商品分类结束-->

			<div class="pre_look">
				<h3>最近浏览</h3>
				<dl>
					<c:forEach items="${viewedProduct }" var="p" end="3">
						<dt>
							<img style="width: 54px; height: 54px;" src="${p.hp_file_name }" />
						</dt>
						<dd>
							<a href="HwuaProductServlrt?org=det&pid=${p.hp_id }">${p.hp_name }</a>
						</dd>
					</c:forEach>
				</dl>
			</div>
		</div>

		<div class="p_center">
			<div id="wrapper">
				<div id="focus">
					<ul>
						<li><a href="#"><img src="images/T1.jpg" /></a></li>
						<li><a href="#"><img src="images/T2.jpg" /></a></li>
						<li><a href="#"><img src="images/T3.jpg" /></a></li>
						<li><a href="#"><img src="images/T4.jpg" /></a></li>
						<li><a href="#"><img src="images/T5.jpg" /></a></li>
					</ul>
				</div>
			</div>
			<div class="p_list">
				<div class="p_info">
					<img src="images/icon_sale.png" />商品列表
				</div>
			</div>

			<ul class="product2">
				<c:if test="${empty products}">
					<h4>找不到您搜索的商品！</h4>
				</c:if>

					<c:forEach items="${products}" var="item">
						<li>
							<dl>
								<dt>
									<a href="HwuaProductServlrt?org=det&pid=${item.hp_id }"
										target="_self"><img src="${item.hp_file_name }" /></a>
								</dt>
								<dd class="title">
									<a href="HwuaProductServlrt?org=det&pid=${item.hp_id }"
										target="_self">${item.hp_name}</a>
								</dd>
								<dd class="price">￥${item.hp_price}</dd>
							</dl>
						</li>
					</c:forEach>
			</ul>

			<!--分页-->
			
			<div class="pager">

				<ul>
					<ul>

						<c:if test="${page.pageType==1}">
							<c:if test="${page.current>1}">
								<li><a href="HwuaProductServlrt?org=list&current=1">首页</a></li>
								<li><a
									href="HwuaProductServlrt?org=list&current=${page.current-1}">上一页</a></li>
							</c:if>
							<li>${page.current}</li>
							<c:if test="${page.current!=page.totalPageSize}">
								<li><a
									href="HwuaProductServlrt?org=list&current=${page.current+1}">下一页</a></li>
								<li><a
									href="HwuaProductServlrt?org=list&current=${page.current=page.totalPageSize}">尾页</a></li>
							</c:if>
						</c:if>

						<c:if test="${page.pageType==2}">
							<c:if test="${page.current>1}">
								<li><a
									href="HwuaProductCategoryServlrt?org=list1&hpcId1=${hid}&current=1">首页</a></li>
								<li><a
									href="HwuaProductCategoryServlrt?org=list1&hpcId1=${hid}&current=${page.current-1}">上一页</a></li>
							</c:if>
							<li>${page.current}</li>
							<c:if test="${page.current!=page.totalPageSize}">
								<li><a
									href="HwuaProductCategoryServlrt?org=list1&hpcId1=${hid}&current=${page.current+1}">下一页</a></li>
								<li><a
									href="HwuaProductCategoryServlrt?org=list1&hpcId1=${hid}&current=${page.current=page.totalPageSize}">尾页</a></li>
							</c:if>
						</c:if>

						<c:if test="${page.pageType==3}">
							<c:if test="${page.current>1}">
								<li><a
									href="HwuaProductCategoryServlrt?org=list2&hpcId2=${hid}&current=1">首页</a></li>
								<li><a
									href="HwuaProductCategoryServlrt?org=list2&hpcId2=${hid}&current=${page.current-1}">上一页</a></li>
							</c:if>
							<li>${page.current}</li>
							<c:if test="${page.current!=page.totalPageSize}">
								<li><a
									href="HwuaProductCategoryServlrt?org=list2&hpcId2=${hid}&current=${page.current+1}">下一页</a></li>
								<li><a
									href="HwuaProductCategoryServlrt?org=list2&hpcId2=${hid}&current=${page.current=page.totalPageSize}">尾页</a></li>
							</c:if>
						</c:if>
						<c:if test="${page.pageType==4}">
							<c:if test="${page.current>1}">
								<li><a
									href="HwuaProductCategoryServlrt?org=query&qname=${qname}&current=1">首页</a></li>
								<li><a
									href="HwuaProductCategoryServlrt?org=query&qname=${qname}&current=${page.current-1}">上一页</a></li>
							</c:if>
							<li>${page.current}</li>
							<c:if test="${page.current!=page.totalPageSize}">
								<li><a
									href="HwuaProductCategoryServlrt?org=query&qname=${qname}&current=${page.current+1}">下一页</a></li>
								<li><a
									href="HwuaProductCategoryServlrt?org=query&qname=${qname}&current=${page.current=page.totalPageSize}">尾页</a></li>
							</c:if>
						</c:if>
					</ul>
				</ul>
			</div>
		</div>

		<div id="p_right">
			<%@ include file="index_news.jsp"%>
			<%@ include file="hotproduct.jsp"%>
		</div>
	</div>

	<div id="foot">Copyright © 2016 上海海文 All Rights Reserved.</div>
</body>
</html>

