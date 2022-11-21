<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@page import="project.shopping.musinsa.domain.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>회원정보 수정 페이지</title>
</head>
	

<body>

	<%
	String userId = (String) session.getAttribute("userId");
	UserVO vo  = (UserVO) request.getAttribute("vo");
	if (userId == null) {
	%>
		out.print("<script>alert("로그인 해주세요."); location.href='/musinsa/user/login'</script>")
	<%
	} else {
	%>
	

	<!-- 회원 정보 가져오기  -->
	<h2><%=userId %>님, 정보 수정 페이지</h2>
 	<form id="update" action="update" method="POST">
	<div>아이디</div>
	 <input type="text" id="userId" name="userId" value=<%=userId %> readonly> <!-- 아이디는 수정 못함 -->
	
	 <div>비밀번호</div>
	<input type="password" name="userPassword" id="userPasswordChk1" value="${vo.userPassword}" placeholder="비밀번호 입력" required="required"><br>
	비밀번호 재입력<br><input type="password" id="userPasswordChk2" value="${vo.userPassword}" placeholder="비밀번호 확인" required="required"><br>
	
	<div>이름</div>
	<input type="text" name="userName" id="userName" value="${vo.userName}" placeholder="이름 입력" required="required"><br><br>

	<div>성별</div>
	 남자<input type="radio" name="userGender" id="userGender" value="man"  checked=<c:if test="${userGender == 'man'}">checked</c:if>>
	 여자<input type="radio" name="userGender" id="userGender" value="woman" checked=<c:if test="${userGender == 'woman'}">checked</c:if>><br><br>

	<div>키</div>
	<input type="text" name="userHeight" id="userHeight" placeholder="키 입력" value="${vo.userHeight}" required="required">cm<br>
	
	<div>몸무게</div>
	<input type="text" name="userWeight" id="userWeight" placeholder="몸무게 입력" value="${vo.userWeight}" required="required">kg<br>
	
	<div>나이</div>
	<input type="number" name="userAge" id="userAge" placeholder="나이 입력" value="${vo.userAge}" required="required"><br>
	
	<div>이메일</div>
	<input type="email" name="userEmail" id="userEmail" placeholder="이메일 입력" value="${vo.userEmail}" required="required"><br>
	
	<div>연락처</div>
	 <input type="text" name="userPhone"  id="userPhone" placeholder="연락처 입력" value="${vo.userPhone}" required="required"><br>
	
	<div>주소</div>
		<input type="text" name="userAddress01" id="sample6_postcode"  value=${vo.userAddress01 } placeholder="우편번호">
		<input type="button" name="userAddress" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" name="userAddress02" id="sample6_address" value="${vo.userAddress02}" placeholder="주소"/><br>
		<input type="text" name="userAddress03" id="sample6_detailAddress" value="${vo.userAddress03}" placeholder="상세주소"/>
	  	<input type="text" name="userAddress04" id="sample6_extraAddress" value="${vo.userAddress04}" placeholder="참고항목"/>	
	  	<br><br>
		<input type="submit" value="수정하기" class="update_button">
    
 
	
<!-- 
	<div id="delete" class="delete_button"><a href="/musinsa/user/delete">회원탈퇴</a></div>
	<input type="button" value="회원탈퇴" onclick="location.href='/musinsa/user/delete?userId=<%=userId%>'">
 -->
<!--  
-->	
     
	<%
	}
	%>
</form>
    	<button id="deleteId">회원탈퇴</button> <!-- form안에 있으면 update 같이되서 밖에 빼줘야함! -->


</body>

<script type="text/javascript">  
	$(document).ready(function(){		
		$("#deleteId").on("click", function(){
			if(!confirm('회원탈퇴 하시겠습니까?')){
				return;
			} else {
				location.href="deleteId?userId=" + $("#userId").val();
			}
		});
	});
 </script>
   
</html>