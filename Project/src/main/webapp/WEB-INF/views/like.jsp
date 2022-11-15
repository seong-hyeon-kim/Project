<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<head>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

<style type="text/css">
ul li {
	list-style-type: none;
	float: left;
	margin-left:20px; 
}

</style>
<meta charset="UTF-8">

<title>Like</title>
</head>
<body>
	<h1>
		<a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa/">Musinsa</a>
	</h1>
	
	<h3>좋아요<i class="fas fa-heart"></i></h3>
		<a href="http://localhost:8080/musinsa/payment"><input type="button" value="결제내역"></a>
		<a href="http://localhost:8080/musinsa/cart"><input type="button" value="장바구니"></a>
	<hr>
	
	<ul>
	<c:forEach var="vo" items="${list}">
		<li style="margin-left: 20px;" >
			<a href="http://localhost:8080/musinsa/detail?productNumber=${vo.productVO.productNumber}"><img src="http://localhost:8080/musinsa/product/display?fileName=/${vo.productVO.productImg}" width="125px" height="150px"></a>
			<ul style="float: right; margin-left: 0px; " >
				<li style="float: none;">${vo.productVO.productName}</li>
				<li style="float: none;">${vo.productVO.productPrice}원</li>
				<li style="float: none;"><i class="fas fa-heart"></i> ${vo.productVO.productGood}</li>
			</ul>
			
			
		</li>
	</c:forEach>
	</ul>

	


</body>
</html>