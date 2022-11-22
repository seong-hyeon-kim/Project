<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<head>
<% 
	String userId= (String) session.getAttribute("userId");
%>
<style type="text/css">
table, th, td {
	border-style: none;
	border-width: 1px;
	text-align: center;
	border-bottom: 1px solid #444444;
	border-collapse: collapse;
}

a {
	text-decoration-line: none;
	color: black;
}

ul {
	list-style-type: none;
	text-align: right;
}

li {
	display: inline-block;
}
</style>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<meta charset="UTF-8">
<title>CART</title>
</head>
<body>
	<h1>
		<a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa/">MUSINSA</a>
	</h1>
	<h3>장바구니</h3>
		<a href="http://localhost:8080/musinsa/payment"><input type="button" value="결제내역"></a>
		<a href="http://localhost:8080/musinsa/like"><input type="button" value="좋아요"></a>

	<hr>
	<table id="table">
		<thead>
			<tr>
				<th></th>
				<th>상품명</th>
				<th>가격</th>
				<th>옵션</th>
				<th>수량</th>
				<th></th>
			
				<th>주문 금액</th>

			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach var="vo" items="${list}">
				<tr id = 'parent'>
					
					<td><img
						src="http://localhost:8080/musinsa/product/display?fileName=/${vo.productVO.productImg}"
						width="125px" height="150px"></td>
					<td>${vo.productVO.productName}</td>
					<td id="productPrice">${vo.productVO.productPrice}</td>
					<td>${vo.cartSize}</td>
					<td id="amount">${vo.cartAmount}</td>
					<td id = cartAmount><button id="btn_plus">+</button>  <button id="btn_minus">-</button> <button id="btn_delete">X</button>  </td>
    				<td hidden="" id="productNumber">${vo.productVO.productNumber}</td>	
    				<td hidden="" id="cartNumber">${vo.cartNumber}</td>	
					<td></td>
				</tr>
				
				
			</c:forEach>

		</tbody>
		
	</table>
	
	합계 : <a id="totalPrice"></a><br><br>
	<button id="btn_buy">구매</button>
	
	<script type="text/javascript">
	$(document).ready(function(){
		getPrice();
		getTotalPrice();
// 가격 
		function getPrice() {
			var table = document.getElementById("table");
			var rows = table.rows.length*=1;
			var rowsTable = rows - 1;
			
			for (var i = 1; i < rows; i++) {
				var amount = table.rows[i].cells[2].innerHTML;
				console.log(amount);
				var productPrice = table.rows[i].cells[4].innerHTML;
				console.log(productPrice);
				var price = amount * productPrice;
				console.log(price);
				table.rows[i].cells[8].innerHTML += price;
			} 
		}
// 가격 합계 
		function getTotalPrice() {
			var table = document.getElementById("table");
			var rows = table.rows.length*=1;
			var rowsTable = rows - 1;
			var sum = 0;
			for (var i = 1; i < rows; i++) {
				sum += parseInt(table.rows[i].cells[8].innerHTML);
				console.log(sum);
				$("#totalPrice").text(sum);
			} 
			
		}
		
// 장바구니 구매 버튼
		$('#btn_buy').click(function(){
			var IMP = window.IMP;
			var totalPrice = document.getElementById('totalPrice').innerText;
			var table = document.getElementById("table");
			var productName = table.rows[1].cells[1].innerHTML;
			var rows = table.rows.length*=1;
			var rowsTable = rows - 1;
			
			IMP.init('imp80165535');
			IMP.request_pay({
			    pg : 'html5_inicis',
			    pay_method : 'card',
			    merchant_uid: "payment_" + new Date().getTime(), // 상점에서 관리하는 주문 번호를 전달
			    name : productName + ' 포함 ' + rowsTable + '개',
			    amount : totalPrice,
			    buyer_name : '<%=userId%>',
			}, function(rsp) { // callback 로직
				console.log(rsp);
				if(rsp.success) {
					var msg = '결제가 완료되었습니다.';
					for(var i = 1; i < rows; i++){
						var userId = '<%=userId%>';
						var productNumber =  table.rows[i].cells[6].innerHTML;
						console.log(productNumber);
						var paymentPrice = table.rows[i].cells[2].innerHTML;
						console.log(paymentPrice);
						var paymentAmount = table.rows[i].cells[4].innerHTML;
						console.log(paymentAmount);
						var paymentProductSize = table.rows[i].cells[3].innerHTML;
						console.log(paymentProductSize);
						var obj = {
								'userId' : userId,
								'productNumber' : productNumber,
								'paymentPrice' : paymentPrice,
								'paymentAmount' : paymentAmount,
								'paymentProductSize' : paymentProductSize
						};
						$.ajax({
							type : 'POST',
							url : 'payment/register',
							headers : {
								'content-type' : 'application/json',
				                'x-HTTP-Method-Override' : 'POST'
							},
							data : JSON.stringify(obj),
							success : function (result, status) {
								if(status == 'success') {
									  // location.href = 'payment';
								}
							}
						}) // end ajax
						
						var cartNumber = table.rows[i].cells[7].innerHTML;
						cartNumber *= 1;
						var obj = {
								'cartNumber' : cartNumber
						};
						console.log(obj);
						
						$.ajax({
							type : 'DELETE',
							url : 'cart/' + cartNumber,
							headers : {
								'content-type' : 'application/json',
								'x-HTTP-Method-Override' : 'DELETE'
							},
							data : JSON.stringify(obj),
							success : function (result, status) {
								console.log(result);
								console.log(status);
								
								if(result == 1) {
									console.log('OK');
									location.href = 'payment';
								}
							}
							
							
						}) // end delete ajax();
						
					} // end for문
				} else {
					var msg = '결제에 실패했습니다.';
				} 
				alert(msg);
			});
		});
		

		
// 장바구니 수정
		$('#table #cartAmount #btn_plus').click(function(){
			var userId = '<%=userId%>';
			var currentRow = $(this).closest('tr');
			var cartAmount = currentRow.find('td:eq(4)').text();
			console.log(cartAmount); // 2
			cartAmount *= 1; // int
			cartAmount = cartAmount + 1; // 5
			console.log(cartAmount);
			var productNumber = currentRow.find('td:eq(6)').text();
			var cartNumber = currentRow.find('td:eq(7)').text();
			var cartSize = currentRow.find('td:eq(3)').text();
			var productPrice = currentRow.find('td:eq(2)').text();
			productPrice *= 1;
			var price = cartAmount * productPrice;
			console.log(price);
			var obj = {
					'userId' : userId,
					'productNumber' : productNumber,
					'cartAmount' : cartAmount,
					'cartSize' : cartSize,
					'cartNumber' : cartNumber
			};
			console.log(obj);
			
			$.ajax({
				type : 'PUT',
				url : 'cart/' + cartNumber,
				headers : {
					'content-type' : 'application/json',
					'x-HTTP-Method-Override' : 'PUT'
				},
				data : JSON.stringify(obj),
				success : function (result, status) {
					console.log(result);
					console.log(status);
					
					if(status == 'success') {
						console.log('OK');
						location.reload();
					}
				}
				
				
			}) // end ajax();
			
			
		}); // end btn_+
		
// 장바구니 수량
		$('#table #cartAmount #btn_minus').click(function(){
			var userId = '<%=userId%>';
			var currentRow = $(this).closest('tr');
			var cartAmount = currentRow.find('td:eq(4)').text();
			console.log(cartAmount);
			cartAmount *= 1;
			cartAmount = cartAmount - 1; 
			console.log(cartAmount);
			if(cartAmount < 0){
				alert('0보다 작게가 되겠어?');
				return;
			}
			var productNumber = currentRow.find('td:eq(6)').text();
			var cartNumber = currentRow.find('td:eq(7)').text();
			var cartSize = currentRow.find('td:eq(3)').text();
			var obj = {
					'userId' : userId,
					'productNumber' : productNumber,
					'cartAmount' : cartAmount,
					'cartSize' : cartSize,
					'cartNumber' : cartNumber
			};
			console.log(obj);
			
			$.ajax({
				type : 'PUT',
				url : 'cart/' + cartNumber,
				headers : {
					'content-type' : 'application/json',
					'x-HTTP-Method-Override' : 'PUT'
				},
				data : JSON.stringify(obj),
				success : function (result, status) {
					console.log(result);
					console.log(status);
					
					if(status == 'success') {
						console.log('OK');
						location.reload();
					}
				}
				
				
			}) // end ajax();
			
			
		}); // end btn_-
		
// 장바구니 삭제
		$('#table #cartAmount #btn_delete').click(function(){
			if(confirm('장바구니에서 삭제하시겠습니까?')) {
				var currentRow = $(this).closest('tr');
				var cartNumber = currentRow.find('td:eq(7)').text();
				cartNumber *= 1;
				var obj = {
						'cartNumber' : cartNumber
				};
				console.log(obj);
				
				$.ajax({
					type : 'DELETE',
					url : 'cart/' + cartNumber,
					headers : {
						'content-type' : 'application/json',
						'x-HTTP-Method-Override' : 'DELETE'
					},
					data : JSON.stringify(obj),
					success : function (result, status) {
						console.log(result);
						console.log(status);
						
						if(result == 1) {
							console.log('OK');
							location.reload();
						}
					}
				}) // end ajax();
			} // end if
			
		}); // end btn_X
		
		
	}); // end document
	
	</script>


</body>
</html>