<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
.file-drop {
   width : 50;
   height : 50px;
   border : 1px solid grey;
}
</style>
</head>
<body>
	<h1><a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa/">MUSINSA</a></h1>
	<h3>상품 등록</h3>
	<form action="register" method="POST" enctype="multipart/form-data">
		
			상품명 : <input type="text" name="productName" placeholder="상품명" required="required">
			<br>
			상품 가격 : <input type="number" name="productPrice" placeholder="가격" required="required"> 
			<p>상품 정보 :</p> 
			<textarea rows="20" cols="80" name="productInformation" placeholder="상품 정보" required="required"></textarea>
			<br>
			사이즈 : 
				S<input type="checkbox" name="size" value="S">
			 	M<input type="checkbox" name="size" value="M">	
			 	L<input type="checkbox" name="size" value="L">	
			 	XL<input type="checkbox" name="size" value="XL">
			<br>
			<font color = "red">파일은 역순으로 선택</font>
			<br>
		  	<input type="file" id="gdsImg" name="files" multiple="multiple" /> 
			<br>
			카테고리 : 상의<input type="radio" name="productCategory" value="상의"> 하의<input type="radio" name="productCategory" value="하의">
			신발<input type="radio" name="productCategory" value="신발"> 모자<input type="radio" name="productCategory" value="모자">
			<br><br>
			<input type="submit" value="상품 등록">
	</form>
	
</body>
</html>