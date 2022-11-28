<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품 문의</h2>
		<!-- 문의 할 상품 정보 가져오기 -->
		<!--  -->
		<input type="hidden" name="productNumber" value="${vo.productNumber }">
		아이디 : <input type="text" name="userId" value="${Qvo.userId }" readonly><br><br>
		문의 유형 : <div id="result" style="display: inline;"></div><br>
				<input type="radio" name="productQuestionType" value="사이즈" onclick="getSelect(event)" required="required">사이즈
				<input type="radio" name="productQuestionType" value="배송" onclick="getSelect(event)">배송
				<input type="radio" name="productQuestionType" value="재입고" onclick="getSelect(event)">재입고
				<input type="radio" name="productQuestionType" value="상품상세문의" onclick="getSelect(event)">상품상세문의<br>
		제목 : <input type="text" name="productQuestionTitle" value="${Qvo.productQuestionTitle }" placeholder="15자 이내 입력"  required="required"><br><br>
		내용  <br><textarea rows="30" cols="50" name="productQuestionContent" required="required">${Qvo.productQuestionContent }</textarea><br>
		<hr>
		<h4>상품문의 안내</h4>
		<p>- 상품문의는 재입고, 사이즈, 배송 등 상품에 대하여 브랜드 담당자에게 문의하는 게시판입니다.</p>
		<strong>- 욕설, 비방, 거래 글, 분쟁 유발, 명예훼손, 허위사실 유포, 타 쇼핑몰 언급, 광고성 등
				      의 부적절한 게시글은 금지합니다. 더불어 상품 문의 시 비밀글만 작성되도록 제한됩니다.</strong>
		<strong>- 주문번호, 연락처, 계좌번호 등의 개인 정보 관련 내용은 공개되지 않도록 비밀글로 문의해 주시기 바랍니다.</strong>
		공개된 글은 비밀글로 전환될 수 있으며, 개인 정보 노출로 인한 피해는 무신사 스토어가 책임지지 않습니다.
		<input type="hidden" value="${page }">
		<br><br><br>
		<input type="submit" value="문의글 수정" id="updateBtn"
			style="background-color: black; color: white; width: 100px; height: 50px; margin-left: 70%; border: none;">
		<input type="hidden" name="productQuestionNumber" value="${Qvo.productQuestionNumber }">
		
	<!-- 스크립트 단 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#updateBtn').click(function() {
				console.log(this);
				var productNumber = $('input[name=productNumber]').val();
				var productQuestionNumber = $('input[name=productQuestionNumber]').val();
				var productQuestionType = $('input[name=productQuestionType]:checked').val();
			 	var productQuestionTitle = $('input[name=productQuestionTitle]').val();
			 	var productQuestionContent = $('textarea[name=productQuestionContent]').val();
			 	console.log("상품 번호 : " + productNumber + "문의 번호 : " + productQuestionNumber + ", 선택된 문의 유형 : " + productQuestionType + ", 문의 제목 : " + productQuestionTitle +
					 	 ", 문의 내용 : " + productQuestionContent);
			 
			 $.ajax({
				 type : 'PUT',
				 url : '/musinsa/qa/' + productQuestionNumber,
				 headers : {
					'Content-Type' : 'application/json',
					'X-HTTP-Method-Override' : 'PUT'
				 },
				 data : JSON.stringify({
					 'productQuestionType' : productQuestionType,
					 'productQuestionContent' : productQuestionContent,
					 'productQuestionTitle' : productQuestionTitle
				 }),
				 success : function(result) {
					 console.log(result);
					 if(result == 1) {
						 alert('정상적으로 수정 되었습니다.')
						 window.opener.location.href='/musinsa/detail?productNumber=' + productNumber;
						 window.close();
					 }
				 }
			 }); // end ajax()
				
			}); // end updateBtn.click()
			
		}); // end document()
		
		function getSelect(event) {
			document.getElementById('result').innerText = event.target.value;	
		} // end getSelect()
	</script>
</body>
</html>