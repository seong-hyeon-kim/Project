
<%@page import="project.shopping.musinsa.domain.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<!-- 회원 정보 띄우기, 수정 버튼, 로그아웃버튼, 회원탈퇴버튼 -->
	<%

	String userId = (String) session.getAttribute("userId");
	UserVO vo  = (UserVO) request.getAttribute("vo");
	
	if (userId == null) {
	%>
		out.print("<script>alert("로그인 해주세요"); location.href='login.jsp'</script>")
	<%
	} else {
		
	%>
	
	<h1><%=userId %>님, 환영합니다!</h1>
	
	<input type="button" value="정보수정" onclick="location.href='/musinsa/user/update?userId=<%=userId%>'">
	<br>
	<br>
	<input type="button" value="1:1 문의" onclick="location.href='/musinsa/board/csqnaList?userId=<%=userId%>'">
	<br>
	<br>
	<input type="button" value="로그아웃" onclick="logout()">
	
<!-- 	<script type="text/javascript"> -->
 	<script type="text/javascript">
 	
 	function logout() {
 		if(!confirm('로그아웃 하시겠습니까?')) {
 			return;
 		} else {
			location.href="logout.do?userid=<%=userId%>"; 
 		}
 	} // end logout

 	</script>
 	 
	<%
	}
	%>
	
</body>
</html>