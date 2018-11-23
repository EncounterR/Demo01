<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category">
	<h2>商品分类</h2>

	<c:forEach items="${list}" var="item">
		<dl>
			<dt>
				<a
					href="HwuaProductCategoryServlrt?org=list1&hpcId1=${item.hpc_id}">${item.hpc_name}</a>
			</dt>
			<c:forEach items="${item.category}" var="temp">
				<dd>
					<a
						href="HwuaProductCategoryServlrt?org=list2&hpcId2=${temp.hpc_id}">${temp.hpc_name }</a>
				</dd>
			</c:forEach>
		</dl>
	</c:forEach>

</div>

