<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>로그인</title>
<style>



</style>

</head>
<body>
	<h1>로그인</h1>
	<form action="login" method="POST">
		<input type="text" name="userId" placeholder="아이디 입력" required="required" autofocus="autofocus"><br>
		<input type="password" name="userPassword" placeholder="비밀번호 입력"required="required" autofocus="autofocus" ><br><br>
		<input type="submit" value="로그인" class="login_button">
	</form>
<script>
 

</script>

	<!-- 아이디찾기 / 비밀번호 찾기 , 카카오로그인API?, -->
	
</body>


</html>