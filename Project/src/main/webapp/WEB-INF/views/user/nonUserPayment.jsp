<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>비회원 결제 내역</title>
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
	
	
	<div id="all">
	<h3>비회원 구매 내역</h3>
	임시 아이디 : <input type="text" id="userId"><br>
	<button id="btn_nonUserPayment">구매 내역 조회</button>
	</div>
	
	<script type="text/javascript">
		$('#btn_nonUserPayment').click(function() {
			var userId = document.getElementById('userId').value;
			
			var obj = {
					'userId' : userId,
			};
			console.log(obj);
			var url = '../nonUserPayment/' + userId;
			$.getJSON(
					url,
					function(data) {
						console.log("data : " + data);
						var list = '';
						$(data).each(function() {
							console.log(this);
							
							list += '<div class = "a">' 
								+ '<h1>비회원 주문내역</h1>'
								+ '임시 아이디 : ' + this.userId
								+ '<table id="table">'
								+ '<thead>'
								+ '<tr>'
								+ '<th></th>'
								+ '<th>상품 정보</th>'
								+ '<th>주문 정보</th>'
								+ '<th>주문 수량</th>'
								+ '<th>주문 옵션</th>'
								+ '<th>주문 금액</th>'
								+ '<th>주문 일자</th>'
								+ '<th>주문 상황</th>'
								+ '<th></th>'
								+ '</tr>'
								+ '</thead>'
								+ '<tbody id="tbody">'
								+ '<tr>'
								+ '<td><img src="http://localhost:8080/musinsa/product/display?fileName=/' + this.productVO.productImg +'" width="125px" height="150px"></td>'
								+ '<td>' + this.productVO.productName + '</td>'
								+ '<td>' + this.paymentNumber + '</td>'
								+ '<td>' + this.paymentAmount + '</td>'
								+ '<td>' + this.paymentProductSize + '</td>'
								+ '<td>' + this.paymentPrice + '</td>'
								+ '<td>' + this.paymentDateCreated + '</td>'
								+ '<td id="state">' + this.paymentState + '</td>'
								+ '<td id="refund"><button id="btn_refund">결제 취소</button></td>'
								+ '</div>';
							
							
						}) // end each
						$('#all').html(list);
					} // end function(data)
					
			
			) // end getJSON
			
			
			
		}) // end nonUserPayment.click
		
		$(document).on('click', '#table #refund #btn_refund', function() {
			console.log('gkdl');
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
				url : '../payment/' + paymentNumber,
				headers : {
					'content-type' : 'application/json',
	                'x-HTTP-Method-Override' : 'PUT'
				},
				data : JSON.stringify(obj),
				success : function (result, status) {
					if(status == 'success') {
						$('#state').html(paymentState);
					}
				}
				
			}) // end ajax
		}) // end document.on
		
	</script>
	


</body>
</html>























