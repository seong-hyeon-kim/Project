<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta charset="UTF-8">
<title>Musinsa Main</title>
<style>
ul {
	list-style-type: none;
	float: left;
	margin-left: auto;
	margin-right: auto;
}


</style>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
	<h1>
		<a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa/">MUSINSA</a>
	</h1>
	<a href="../musinsa/product/list"><input type="button" value="상품 등록창"></a>
		<a href="http://localhost:8080/musinsa/payment"><input type="button" value="결제내역"></a>
		<a href="http://localhost:8080/musinsa/cart"><input type="button" value="장바구니"></a>
		<a href="http://localhost:8080/musinsa/like"><input type="button" value="좋아요"></a>
	<hr>
	<c:forEach var="vo" items="${list}">
	
	<div class="productList">
		<ul>
			<li  style="margin-left:0px; margin-right:0px; border: 1px solid grey; width: 150px; height: 280px; text-align: center;    display: table-cell; vertical-align: middle;" >
				<a href="detail?productNumber=${vo.productNumber }"> <!-- 누르면 상세페이지 이동 -->
					<div class="photo">
						<img alt="" src="product/display?fileName=/${vo.productImg}" style="width: 125px; height: 150px;">
					</div>
					<div class="information">
						<a>${vo.productName }</a> <br>
						<a>${vo.productPrice }원</a> <br>
						<a>${vo.productSize }</a> <br>
						<a>평점 : ${vo.productGrade }</a><br>
						<a><i class="fas fa-heart"></i> ${vo.productGood }</a> 
					</div>
					
				</a>
			</li>
		</ul>
	</div>
	
	</c:forEach>
	
	

</body>
</html>