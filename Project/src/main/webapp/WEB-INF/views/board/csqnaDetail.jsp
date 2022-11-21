<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>${vo.boardTitle }</title>
</head>
<body>

	<h2>1:1문의 내역</h2>
	<br><br>
	
	<div> 번호  : ${vo.boardNumber }</div>
	
	<div> 작성자 : ${vo.userId } </div>
	
	<div> 제목 : ${vo.boardTitle }</div>
	
	<div> 작성일 : ${vo.boardDateCreated }</div>
	
	<div>
    <textarea rows="20" cols="120" readonly>${vo.boardContent }</textarea>
   	</div>
   	
   <a href="csqnaList?page=${page }">
   <input type="button" value= "글 목록"></a>
   
  <a href="csqnaUpdate?boardNumber=${vo.boardNumber }&page=${page }">
  <input type="button" value="글 수정"></a>
   	
   <form action="csqnaDelete" method="POST">
    <input type="hidden" name="boardNumber" value="${vo.boardNumber }">
   <input type="submit" value="글 삭제">
   </form>
   	
   
</body>
</html>