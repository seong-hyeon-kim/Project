<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
				<th>주문 상황</th>
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
					<td id="paymentNumber">${vo.paymentNumber}</td>
					<td>${vo.paymentAmount}</td>
					<td>${vo.paymentProductSize}</td>
					<td>${vo.paymentPrice}</td>	
					<fmt:formatDate value="${vo.paymentDateCreated}"
					pattern="yyyy-MM-dd HH:mm:ss" var="paymentDateCreated"/>
					<td>${paymentDateCreated}</td>
					<td>${vo.paymentState}</td>
					<td id="refund"><button id="btn_refund">결제 취소</button></td>

				</tr>
				
			</c:forEach>
			
		</tbody>
		
	</table>
	
	<script type="text/javascript">
	$(document).ready(function() {
		
		$('#table #refund #btn_refund').click(function() {
			var currentRow = $(this).closest('tr');
			var paymentState = '결제 취소';
			var paymentNumber = currentRow.find('td:eq(2)').text();
			var obj = {
					'paymentNumber' : paymentNumber,
					'paymentState' : paymentState
			};
			console.log(obj);
			$.ajax({
				type : 'PUT',
				url : 'payment/' + paymentNumber,
				headers : {
					'content-type' : 'application/json',
	                'x-HTTP-Method-Override' : 'POST'
				},
				data : JSON.stringify(obj),
				success : function (result, status) {
					if(status == 'success') {
						location.href = 'payment';
					}
				}
				
			}) // end ajax
			
			
			
		}); // end btn_refund
		
		
	}); // end document
	
	
	</script>
	

</body>
</html>























