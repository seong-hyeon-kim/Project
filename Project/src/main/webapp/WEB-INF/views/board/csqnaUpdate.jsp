<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 게시판 게시물 수정</title>
</head>
<body>

	<h2>게시물 수정</h2>
	<form action ="csqnaUpdate" method="POST">
	<input type="hidden" name="page" value="${page }">
	
	<div>글 번호 : ${vo.boardNumber }</div>
	<input type="hidden" name="boardNumber" value="${vo.boardNumber }">
	
	<div>작성자 : ${vo.userId }</div>
	<input type="hidden" name="userId" value="${vo.userId}">

	<div>제목</div>
	<input type="text" name="boardTitle"  value="${vo.boardTitle }" required>

	<div>문의내용</div>
	<textarea rows="20" cols="120" name="boardContent" required>${vo.boardContent }</textarea>

	<div><input type="submit" value="수정하기"></div>

	</form>
	
</body>
</html>