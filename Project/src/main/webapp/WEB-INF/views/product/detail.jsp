<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="UTF-8">
<title>${vo.productName }</title>
</head>
<body>
	<h1><a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa/">MUSINSA</a></h1>
	<h3>등록상품 상세보기</h3>
	<div>
		<p>상품 번호 : ${vo.productNumber }</p>
		<p>상품 이름 : ${vo.productName }</p>
		<p>상품 가격 : ${vo.productPrice }</p>
		<p>상품 카테고리 : ${vo.productCategory }</p>
		<p>상품 사이즈 : ${vo.productSize }</p>
		<p>상품 정보 : ${vo.productInformation }</p>
		<p>상품 좋아요 : ${vo.productGood }</p>
		<p>상품 평점 : ${vo.productGrade }</p>
		<p>상품 사진 : </p> <img src="http://localhost:8080/musinsa/product/display?fileName=/${vo.productImg}" width="200px" height="180px">
		<fmt:formatDate value="${vo.productDateRegister}"
					pattern="yyyy-MM-dd HH:mm:ss" var="productDateRegister"/>
		<p>상품 등록일 : ${productDateRegister }</p>
	</div>
	
	
	<a href="list?page=${page}"><input type="button" value="상품 목록"></a>
	<a href="update?productNumber=${vo.productNumber}&page=${page}"><input type="button" value="상품 정보 수정"></a>
	<br><br>
	
	<form action="delete" method="POST">
		<input type="hidden" name="productNumber" value="${vo.productNumber}">
		<input type="submit" value="상품 삭제">
	</form>
</body>
</html>