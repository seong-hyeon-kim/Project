<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 내역</title>
<style type="text/css">
  table {
    width: 100%;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
	text-align: center;
  }
</style>
</head>
<body>
	<h1>
		<a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa/">Musinsa</a>
	</h1>
	<h3>구매내역</h3>
		<a href="http://localhost:8080/musinsa/cart"><input type="button" value="장바구니"></a>
		<a href="http://localhost:8080/musinsa/like"><input type="button" value="좋아요"></a>
<hr>


<table id="table">
		<thead>
			<tr>
				<th></th>
				<th>상품 정보</th>
				<th>주문 번호</th>
				<th>주문 수량</th>
				<th>주문 옵션</th>
				<th>주문 금액</th>
				<th>주문 일자</th>
				<th></th>

			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach var="vo" items="${list}">
				<tr id = 'parent'>
					<td><img
						src="http://localhost:8080/musinsa/product/display?fileName=/${vo.productVO.productImg}"
						width="125px" height="150px"></td>
					<td>${vo.productVO.productName}</td>
					<td>${vo.paymentNumber}</td>
					<td>${vo.paymentAmount}</td>
					<td>${vo.paymentProductSize}</td>
					<td>${vo.paymentPrice}</td>	
					<fmt:formatDate value="${vo.paymentDateCreated}"
					pattern="yyyy-MM-dd HH:mm:ss" var="paymentDateCreated"/>
					<td>${paymentDateCreated}</td>
					<td><button>결제 취소</button></td>

				</tr>
				
			</c:forEach>
			
		</tbody>
		
	</table>

</body>
</html>