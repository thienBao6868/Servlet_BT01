<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="css/custom.css">
</head>
<%
request.getAttribute("products");
%>

<body>
	<div class="cover-title">
		<h1 >QUẢN LÝ SẢN PHẨM</h1>
	</div>

	<div class="cover-form">
		<form action="product" method="post">
			<h4 class="title">Tên Sản Phẩm</h4>
			<input type="text" name="name" />
			<h4 class="title">Số Lượng</h4>
			<input type="number" name="quantity" />
			<h4 class="title">Giá bán</h4>
			<input type="number" name="price" /> <br /> <br />
			<div class="cover-button">
			<button>Lưu Lại</button>
			</div>
			
		</form>
	</div>
	<div class="cover-table">
		<table border="1">
			<thead>
				<tr>
					<th>STT</th>
					<th>Tên Sản Phẩm</th>
					<th>Số Lượng</th>
					<th>Giá Bán</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${products}" var="product" varStatus="loop">

					<tr>
						<td>${loop.index + 1}</td>
						<td>${product.name}</td>
						<td>${product.quantity}</td>
						<td>${product.price}</td>
					</tr>
				</c:forEach>

			</tbody>


		</table>

	</div>
</body>
</html>