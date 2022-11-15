<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>상품 문의</title>
</head>
<body>
	<h2>상품 문의</h2>
	<!-- 상품 정보 가져오기 -->
		아이디 : <input type="text" name="userId" placeholder="아이디 입력" required="required"><br><br>
		문의 유형 : <input type="radio" name="productQuestionType" value="사이즈" required="required">사이즈
				<input type="radio" name="productQuestionType" value="배송">배송
				<input type="radio" name="productQuestionType" value="재입고">재입고
				<input type="radio" name="productQuestionType" value="상품상세문의">상품상세문의
		<br><br>
		제목 : <input type="text" name="productQuestionTitle" placeholder="15자 이내 입력" style="width: 50%;" required="required">
		<br><br>
		내용  <br><textarea rows="30" cols="50" name="productQuestionContent" placeholder="내용 입력" required="required"></textarea>
		<hr>
		<strong>상품 문의 안내</strong><br>
		- 상품 문의는 재입고, 사이즈, 배송 등 상품에 대하여 브랜드 담당자에게 문의하는 게시판 입니다.<br>
		<strong>- 욕설, 비방, 거래 글, 분쟁 유발, 명예 훼손, 허위사실 유포, 타 쇼핑몰 언급, 광고성 등의
		적절한 게시글은 금지합니다. 더불어 상품 문의 시 비밀글만 작성 되도록 제한 됩니다.</strong><br>
		<strong>- 주문번호, 연락처, 계좌번호 등의 개인 정보 관련 내용은 공개되지 않도록 비밀글로 문의해 주시기 바랍니다.</strong>
		공개된 글은 비밀글로 전환될 수 있으며, 개인 정보 노출로 인한 피해는 무신사 스토어가 책임지지 않습니다.
		<br><br><br>
		<input type="submit" value="문의글 작성" id="sendPost"
		style="background-color: black; color: white; width: 100px; height: 50px; margin-left: 70%; border: none;">
		
	<!-- 문의글 작성 클릭시 팝업창 닫고 Q&A.jsp로 데이터 전송 후 이동 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#sendPost').click(function() {
				var userId = $('input[name=userId]').val();
				var productQuestionType = $('input[name=productQuestionType]:checked').val();
				var productQuestionTitle = $('input[name=productQuestionTitle]').val();
				var productQuestionContent = $('textarea[name=productQuestionContent]').val();
	
				// ㅅㅂ 이거 넣으니까 안된다
				
  				if(userId == '') {
					alert('[오류] 아이디는 필수 입력 사항입니다.')
					return;
				} else if(productQuestionType == null) {
					alert('[오류] 문의 유형은 필수 선택 사항입니다.')
					return;
				} else if(productQuestionTitle == '') {
					alert('[오류] 제목은 필수 입력 사항입니다.')
					return;
				} else if(productQuestionContent == '') {
					alert('[오류] 문의 내용은 필수 입력 사항입니다.')
					return;
				} 
				var obj = {
						'userId' : userId,
						'productQuestionType' : productQuestionType,
						'productQuestionTitle' : productQuestionTitle,
						'productQuestionContent' : productQuestionContent
				};
				console.log(obj);
				
				// $.ajax로 송수신
				$.ajax({
					type : 'POST',
					url : '/musinsa/qa/qaREST',
					async : false,
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'POST'
					},
					data : JSON.stringify(obj),
					success : function(result, status) {
						console.log(result);
						console.log(status);
						if(result == 1) {
							alert('정상적으로 등록 되었습니다.');
							window.opener.location.href="/musinsa/detail?productNumber=75"
							window.close();
						} 
					}
				});
				
			}); // end sendPost.click()
		}); // end document()
	</script>
</body>
</html>