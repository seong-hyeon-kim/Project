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
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
	<h1>
		<a href="http://localhost:8080/musinsa">Musinsa</a>
	</h1>
	<a href="../musinsa/product/list"><input type="button" value="상품 등록창"></a>
	
	<hr>
	<c:forEach var="vo" items="${list}">
	<div class="productList">
		<ul>
			<li>
				<a href="goods/detail?productNumber=${vo.productNumber }"> <!-- 누르면 상세페이지 이동 -->
					<div class="photo">
						<img alt="" src="product/display?fileName=/${vo.productImg}">
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

</html>