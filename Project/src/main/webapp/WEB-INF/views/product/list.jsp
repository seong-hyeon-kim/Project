<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
table, th, td {
	border-style: solid;
	border-width: 1px;
	text-align: center;
}
a {text-decoration-line: none; color: black;}

ul {
	list-style-type: none;
	text-align: right;
}

li {
	display: inline-block;
}

</style>
<meta charset="UTF-8">
<title>등록된 상품</title>
</head>
<body>
	<h1><a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa">MUSINSA</a></h1>
	<h2>등록 상품 리스트</h2>
	<br>
	<a href="register"><input type="button" value="상품 등록"></a>
	<a href="../"><input type="button" value="main"> </a>
	<hr>
	
		<ul>
		<c:if test="${pageMaker.isHasPrev()}">
			<li><a href="list?page=${pageMaker.getStartPageNo() - 1}">이전</a></li>
		</c:if>
		
		<c:forEach var="i" begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }">
			<li><a href="list?page=${i}">${i }</a></li>
		</c:forEach>
		
		<c:if test="${pageMaker.isHasNext()}">
			<li><a href="list?page=${pageMaker.getEndPageNo() + 1}">다음</a></li>
		</c:if>
	</ul>
	
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>정보</th>
				<th>사이즈</th>
				<th>이미지</th>
				<th>좋아요</th>
				<th>평점</th>
				<th>등록일</th>
				<th>카테고리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.productNumber}</td>
					<td><a href="detail?productNumber=${vo.productNumber }&page=${pageMaker.criteria.page}">${vo.productName }</a> </td>
					<td>${vo.productPrice} </td>
					<td>${vo.productInformation}</td>
					<td>${vo.productSize}</td>
					<td><a href="detail?productNumber=${vo.productNumber }&page=${pageMaker.criteria.page}"><img src="display?fileName=/${vo.productImg}" style="width: 125px; height: 150px;"></a></td>
					<td>${vo.productGood}</td>
					<td>${vo.productGrade}</td>
					<fmt:formatDate value="${vo.productDateRegister}"
					pattern="yyyy-MM-dd HH:mm:ss" var="productDateRegister"/>
					<td>${productDateRegister}</td>
					<td>${vo.productCategory}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 
	

	
	
</body>
</html>