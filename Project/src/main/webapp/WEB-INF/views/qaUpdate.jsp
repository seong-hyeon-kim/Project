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
		아이디 : <input type="text" name="userId" value="${vo.userId }" readonly><br><br>
		문의 유형 : <div id="result" style="display: inline;"></div><br>
				<input type="radio" name="productQuestionType" value="사이즈" onclick="getSelect(event)">사이즈
				<input type="radio" name="productQuestionType" value="배송" onclick="getSelect(event)">배송
				<input type="radio" name="productQuestionType" value="재입고" onclick="getSelect(event)">재입고
				<input type="radio" name="productQuestionType" value="상품상세문의" onclick="getSelect(event)">상품상세문의<br>
		제목 : <input type="text" name="productQuestionTitle" value="${vo.productQuestionTitle }" placeholder="15자 이내 입력"><br><br>
		내용  <br><textarea rows="30" cols="50" name="productQuestionContent">${vo.productQuestionContent }</textarea><br>
		<input type="hidden" value="${page }">
		<input type="submit" value="문의글 수정" id="updateBtn">
		<input type="hidden" name="productQuestionNumber" value="${vo.productQuestionNumber }">
		
	<!-- 스크립트 단 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#updateBtn').click(function() {
				console.log(this);
				var productQuestionNumber = $('input[name=productQuestionNumber]').val();
				var productQuestionType = $('input[name=productQuestionType]:checked').val();
			 	var productQuestionTitle = $('input[name=productQuestionTitle]').val();
			 	var productQuestionContent = $('textarea[name=productQuestionContent]').val();
			 	console.log("문의 번호 : " + productQuestionNumber + ", 선택된 문의 유형 : " + productQuestionType + ", 문의 제목 : " + productQuestionTitle +
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
						 window.opener.location.href='/musinsa/productQna/Q&A';
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