<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul li {
	list-style-type: none;
	float: left;
	margin-left:20px; 
}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="all">
	<h1>비회원 주문하기</h1>
	
	
	<div>
	<ul>
		<li style="margin-left: 20px;">
			<img id="productImg" >
			<ul style="float: right; margin-left: 0px; ">
				<li style="float: none;">상품명 : <input style="border:0 solid black" type="text" id="productName" name="productName"></li>
				<li style="float: none;">상품 가격 : <input style="border:0 solid black" type="text" id=paymentPrice name="paymentPrice"></li>
				<li style="float: none;">상품 사이즈 : <input style="border:0 solid black" type="text" id=paymentProductSize name="paymentProductSize"></li>
				<li style="float: none;">수량 : <input style="border:0 solid black" type="text" id=paymentAmount name="paymentAmount"></li>
			</ul>
		</li>
	
	</ul>
	</div>
	
	<input type="text" id="productNumber" name="productNumber" hidden="">
	
	<div><h4 style="color: red;">아이디는 자동 부여됩니다. 잊지 않도록 복사해두세요!</h4></div>
	임시 아이디 :  <p id="nonUserId" style="border: none;">${nonUserId}</p> <button onclick="copyClipboard()">복사하기</button>
	
	<div>이메일</div>
	<input type="email" name="nonUserEmail" id="nonUserEmail" placeholder="이메일 입력" required="required"><br>
	
	<div>연락처</div>
	 <input type="text" name="nonUserPhone"  id="nonUserPhone" placeholder="연락처 입력" required="required"><br>
	
	<div>주소</div>
		<input type="text" id="sample6_postcode" name="nonUserAddressNum" placeholder="우편번호" required="required">
		<input type="button" name="userAddress" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" required="required"><br>
		<input type="text" name="nonUserAddress1" id="sample6_address" placeholder="주소" required="required"><br>
		<input type="text" name="nonUserAddress2" id="sample6_detailAddress" placeholder="상세주소"required="required">
	    <input type="text" name="nonUserAddress3" id="sample6_extraAddress" placeholder="참고항목">	
	    <br><br>
	    
	 
	    
	 <button id="nonUserPayment">비회원 주문하기</button>
	 
	 </div>	   
	 
	    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	    
	    <script type="text/javascript">
	    $(document).ready(function() {
	    	var productNumber = opener.$('#productNumber').val();
	    	$('#productNumber').val(productNumber);
	    	var productName = opener.$('#productName').val();
	    	$('#productName').val(productName);
	    	var paymentPrice = opener.document.getElementById('payPrice').innerText;
	    	$('#paymentPrice').val(paymentPrice);
	    	var paymentProductSize = opener.document.querySelector('input[name="size"]:checked').value;
	    	$('#paymentProductSize').val(paymentProductSize);
	    	var paymentAmount = opener.document.getElementById('cartAmount').value;
	    	$('#paymentAmount').val(paymentAmount);
	    	var productImg = opener.document.getElementById('productImg').src;
	    	$('#productImg').attr('src', productImg);
	    	
	    });
	    
	    
	    </script>
	    
	    
	    
	    <script type="text/javascript">
	    $(document).ready(function() {
	    
	    	$('#nonUserPayment').click(function() {
	    		var nonUserId = document.getElementById('nonUserId').innerText;
	    		var nonUserEmail = document.getElementById('nonUserEmail').value;
	    		var nonUserPhone = document.getElementById('nonUserPhone').value;
	    		var nonUserAddressNum = document.getElementById('sample6_postcode').value;
	    		var nonUserAddress1 = document.getElementById('sample6_address').value;
	    		var nonUserAddress2 = document.getElementById('sample6_detailAddress').value;
	    		var nonUserAddress3 = document.getElementById('sample6_extraAddress').value;
	    		var nonUserAddress = nonUserAddress1 + nonUserAddress2 + ', ' + nonUserAddress3 + ' (' + nonUserAddressNum + ')';
	    		var productNumber = $('#productNumber').val();
	    		var paymentPrice = $('#paymentPrice').val();
	    		var paymentAmount = $('#paymentAmount').val();
	    		var paymentProductSize = $('#paymentProductSize').val();
	    		var productName = $('#productName').val();
	    		
	    		var IMP = window.IMP;
	    		IMP.init('imp80165535');
	    		
	    		IMP.request_pay({
				    pg : 'html5_inicis',
				    pay_method : 'card',
				    merchant_uid: "payment_" + new Date().getTime(), // 상점에서 관리하는 주문 번호를 전달
				    name : productName,
				    amount : paymentPrice,
				    buyer_name : nonUserId,
				    
				}, function(rsp) { // callback 로직
					console.log(rsp);
					if(rsp.success) {
						var msg = '결제가 완료되었습니다.';
						var obj = {
			    				'userId' : nonUserId,
			    				'nonUserEmail' : nonUserEmail,
			    				'nonUserPhone' : nonUserPhone,
			    				'nonUserAddress' : nonUserAddress,
			    				'productNumber' : productNumber,
			    				'paymentPrice' : paymentPrice,
			    				'paymentAmount' : paymentAmount,
			    				'paymentProductSize' : paymentProductSize,
						};
						$.ajax({
			    			type : 'POST',
			    			url : '../nonUserPayment',
			    			headers : {
			    				  'content-type' : 'application/json',
			                      'x-HTTP-Method-Override' : 'POST'
			    			},
			    			data : JSON.stringify(obj),
			    			success : function(result, paymentResult) {
			    				console.log('result : ' + result);
			    				console.log('paymentResult : ' + paymentResult);
			    				console.log(status);
			    				if(paymentResult == 'success') {
			    					alert('비회원 가입 후 구매 성공');
			    					var url = '../nonUserPayment/' + nonUserId;
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
			    									+ '<td>' + this.paymentState + '</td>'
			    									+ '</div>';
			    									
			    									
			    								}) // end each()
			    								$('#all').html(list);
			    							} // end function(data)
			    					) // end getJSON
			    				} // end if payment == success
			    			} // end success : function
			    			
			    			
			    		}) // end ajax
						
					} else {
						var msg = '결제에 실패했습니다.';
					} 
					alert(msg);
				});
	    	}); // end nonUserPayment.click
	    	
	    function getNonUserPayment() {
	    		var nonUserId = document.getElementById('nonUserId').innerText;
	    		console.log(nonUserId);
	    		
	    		console.log(url);
	    		
	    		$.getJSON(
	    				url,
	    				function(data) {
	    					console.log(data);
	    				}
	    				
	    				
	    				); // end getJSON
	    	} // end getNonUserPayment;
	    	
	    }); // end document.ready
	    
	    function copyClipboard() {
	    	  const text = document.getElementById('nonUserId').textContent;
	    	  const textarea = document.createElement('textarea');
	    	  console.log(textarea);
	    	  textarea.textContent = text;
	    	  document.body.append(textarea);
	    	  textarea.select();
	    	  document.execCommand('copy');
	    	  textarea.remove();
	    	}

	    
	    
	    // 주소 API
	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    } // end sample6_execDaumPostcode()
	    </script>
	   
	
</body>
</html>