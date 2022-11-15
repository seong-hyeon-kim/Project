<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정 페이지</title>
</head>
<body>
<h1><a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa/">MUSINSA</a></h1>
	<h3>상품 정보 수정</h3>
	<form action="update" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="page" value="${page}">
			<input type="hidden" name="productNumber" value="${vo.productNumber}">
			상품명 : <input type="text" name="productName" value="${vo.productName }" required="required">
			<br>
			상품 가격 : <input type="number" name="productPrice" value="${vo.productPrice }" required="required"> 
			<p>상품 정보 :</p> 
			<textarea rows="20" cols="80" name="productInformation" required="required">${vo.productInformation}</textarea>
			<br>
			사이즈 : 
				S<input type="checkbox" name="size" value="S">
			 	M<input type="checkbox" name="size" value="M">	
			 	L<input type="checkbox" name="size" value="L">	
			 	XL<input type="checkbox" name="size" value="XL">
			<br>
			현재 사진 :
			<br>
			<img src="display?fileName=/${vo.productImg}"> 
			<br>
		  	<input type="file" id="gdsImg" name="files" multiple="multiple" />
			<br>
			카테고리 : 
			<c:if test="${vo.productCategory eq '상의'}">
				상의<input type="radio" name="productCategory" value="상의" checked="checked"> 하의<input type="radio" name="productCategory" value="하의">
			</c:if>
			
			<c:if test="${vo.productCategory eq '하의'}">
				상의<input type="radio" name="productCategory" value="상의"> 하의<input type="radio" name="productCategory" value="하의" checked="checked">
			</c:if>
			
			<br><br>
			
			
			<input type="submit" value="상품 정보 수정">
			
	</form>
	
	
	
	
</body>
</html>