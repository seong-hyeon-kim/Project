<%@page import="project.shopping.musinsa.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 게시판 등록 </title>
</head>
<%
	String userId = (String) session.getAttribute("userId");
	BoardVO vo  = (BoardVO) request.getAttribute("vo");
%>

<body>
<!-- 1:1게시판, 작성자만 자기 페이지에 볼 수 있게  -->
<!-- 문의작성 -->
<!-- 문의유형 - 주문, 결제 , 배송 , 교환, 취소 -->
<!-- 작성자 - (불러오기) -->
<!-- 제목 - 제목을 입력해 주세요 -->
<!-- 문의 내용 - 내용을 입력해주세요 -->

<!-- 사진?.. -->
<!-- 작성하기 버튼, 취소버튼 -->

<h1>문의 작성</h1>
	
문의 유형 <select name='qna'>
	<option value="주문">주문
	<option value="결제">결제
	<option value="교환">교환
	<option value="취소">취소
	<option value="배송">배송
</select>

<form action="csqnaRegister" method="POST"> 

<div>작성자</div>
<input type="text" name="userId" value="${userId }" readonly>

<div>제목</div>
<input type="text" name="boardTitle" placeholder="제목 입력" required>

<div>문의내용</div>
<textarea rows="20" cols="120" name="boardContent" placeholder="내용 입력" required></textarea>

<div><input type="submit" value="등록"></div>

</form>

</body>
</html>