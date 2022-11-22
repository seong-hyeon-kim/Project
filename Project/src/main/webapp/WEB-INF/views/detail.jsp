<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% 
	String userId= (String) session.getAttribute("userId");
%>
<style type="text/css">
table, th, td {
   border-style: solid;
   border-width: 1px;
   margin-left: auto;
   margin-right: auto;
   text-align: center;
   border-collapse: collapse;
}

ul {
   list-style-type: none;
   margin-left: 56%;
}

li {
   display: inline-block;
}

.pagination {
   display: inline-block;
}

.pagination a {
   color: black;
   float: left;
   padding: 8px 16px;
   text-decoration: none;
}

.pagination a.active {
   background-color: #4CAF50;
   color: white;
   border-radius: 5px;
}

.pagination a:hover:not(.active) {
   background-color: #ddd;
   border-radius: 5px;
}

</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>


<meta charset="UTF-8">

	
<title>상품상세설명</title>
</head>
<body>
	<h1><a style="text-decoration: none; color: black;" href="http://localhost:8080/musinsa/">MUSINSA</a></h1>
	<h3>상품 정보</h3>
		<a href="http://localhost:8080/musinsa/payment"><input type="button" value="결제내역"></a>
		<a href="http://localhost:8080/musinsa/cart"><input type="button" value="장바구니"></a>
		<a href="http://localhost:8080/musinsa/like"><input type="button" value="좋아요"></a>
		<hr>
	<form action="cart/register" method="POST">
	
	<div id=detail style="margin: auto;">
		<input hidden="" style="border:none" type="number" name="productNumber" value="${vo.productNumber }" readonly="readonly">  
		<p>상품 이름 : ${vo.productName }</p>
		<p id="price">상품 가격 : ${vo.productPrice }</p>
		<p>상품 카테고리 : ${vo.productCategory }</p>
		<p>상품 사이즈 : 		
		<c:set var = "productSize" value="${vo.productSize}"/>
		<c:if test="${fn:contains(productSize, 'S')}">
			S<input type="radio" name="size" value="S" required="required">
		</c:if>
		
		<c:if test="${fn:contains(productSize, 'M')}">
			M<input type="radio" name="size" value="M" required="required">
		</c:if>
		
		<c:if test="${fn:contains(productSize, 'L')}">
			L<input type="radio" name="size" value="L" required="required">
		</c:if>
		
		<c:if test="${fn:contains(productSize, 'XL')}">
			XL<input type="radio" name="size" value="XL" required="required">
		</c:if></p>
		<p>수량 : <input id="cartAmount" type="number" name="cartAmount" value=1 required="required"></p>
		주문 금액 : <a id="payPrice">${vo.productPrice }</a>
		<p id="productGood"><i class="fas fa-heart"></i>  ${vo.productGood }</p>
		<p>상품 평점 : ${vo.productGrade }</p>
		<p>상품 정보 : ${vo.productInformation }</p>
		<img src="http://localhost:8080/musinsa/product/display?fileName=/${vo.productImg}" >
		<fmt:formatDate value="${vo.productDateRegister}"
					pattern="yyyy-MM-dd HH:mm:ss" var="productDateRegister"/>
		<p>상품 등록일 : ${productDateRegister }</p>
		<input type="submit" value="add to cart">
	
		
		
		
	</div>
	</form>
		<br><a href="/musinsa"><input type="button" value="상품 목록"></a>
		<button id="btn_good">like</button>
		<button id="btn_buy">buy</button>
		
		<br>
		<br>
		
<details>
    <summary>사진 펼치기</summary>
    <c:forEach var="img" items="${imgList}">
		<div>
			<img src="http://localhost:8080/musinsa/product/display?fileName=/${img}" >
		</div>
		</c:forEach>
</details>
	
		
		
	
	<script type="text/javascript">
	$(document).ready(function () {
		
		$('#cartAmount').blur(function(){
			var amount = document.getElementById('cartAmount').value;
			if(amount < 0){
				alert('0보다 작게가 되겠어?');
				document.getElementById('cartAmount').value = 0;
				$("#payPrice").text(0);
			} else {
				var price = '${vo.productPrice}';
				var payPrice = amount * price;
				$("#payPrice").text(payPrice);
			}
		});
		
		$('#btn_good').click(function () {
			var userId = '<%=userId%>';
			var productNumber = ${vo.productNumber};
			var obj = {
					'userId' : userId,
					'productNumber' : productNumber
			};
			console.log(obj);
			
			$.ajax({
				type : 'POST',
				url : 'detail',
				headers : {
					'content-type' : 'application/json',
	                'x-HTTP-Method-Override' : 'POST'
				},
				data : JSON.stringify(obj),
				success : function (result, status) {
					console.log(result);
					console.log(status);
					
					if(status == 'success') {
					location.reload();
					}
				}
				
			}); // end ajax()
			
		}); // end btn_good.click()
		
// 구매버튼
		$('#btn_buy').click(function(){
			var IMP = window.IMP;
			var payPrice = document.getElementById('payPrice').innerText;
			if($('input:radio[name=size]').is(':checked') == false){
				alert('사이즈를 선택해주세요 바보야');
				return;
			}
			IMP.init('imp80165535');
			IMP.request_pay({
			    pg : 'html5_inicis',
			    pay_method : 'card',
			    merchant_uid: "payment_" + new Date().getTime(), // 상점에서 관리하는 주문 번호를 전달
			    name : '${vo.productName }',
			    amount : payPrice,
			    buyer_name : '<%=userId%>',
			    
			}, function(rsp) { // callback 로직
				console.log(rsp);
				if(rsp.success) {
					var msg = '결제가 완료되었습니다.';
					var userId = '<%=userId%>';
					var productNumber = '${vo.productNumber}';
					var paymentPrice = document.getElementById('payPrice').innerText;
					var paymentAmount = document.getElementById('cartAmount').value;
					var paymentProductSize = document.querySelector('input[name="size"]:checked').value;
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
								  location.href = 'payment';
							}
						}
					}) // end ajax
					
				} else {
					var msg = '결제에 실패했습니다.';
				} 
				alert(msg);
			});
			
			
			
		}); // end btn_buy.click()
		
		$('#btn_cart').click(function () {
			var userId = <%=userId%>;
			var productNumber = ${vo.productNumber};
			var cartAmount = document.getElementById(cartAmount).innerText;
			var cartSize = document.querySelector('input[name="size"]:checked').value;
			var obj = {
					'userId' : userId,
					'productNumber' : productNumber,
					'cartAmount' : cartAmount,
					'cartSize' : cartSize,
			};
			
			$.ajax({
				type : 'POST',
				url : 'cart/register',
				headers : {
					'content-type' : 'application/json',
	                'x-HTTP-Method-Override' : 'POST'
				},
				data : JSON.stringify(obj),
				success : function (result, status) {
					
					if(status == 'success') {
					location.reload();
					}
				}
				
			}); // end ajax()
		
	}); // end btn_good.click()
	
		
		
	}); // end document
		
	
		
		
	</script>
	
	
	
<h2>Q & A</h2>
   <table id="contents">
      <colgroup>
         <col width="7%">
         <col width="8%">
         <col width="15%">
         <col width="auto">
         <col width="12%">
         <col width="13%">
         <col width="10%">
      </colgroup>
      <thead>
         <tr>
            <th scope="col">번호</th>
            <th scope="col">답변여부</th>
            <th scope="col">구분</th>
            <th scope="col">내용</th>
            <th scope="col">작성자</th>
            <th scope="col">등록일자</th>
            <th scope="col">변경</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="vo" items="${list }">
            <tr>
               <td>${vo.productQuestionNumber }</td>
               <td><strong>${vo.productQuestionWhether }</strong></td>
               <td>${vo.productQuestionType }</td>
               <td id="title">
                  <button style="border: none; background-color: white; font-size: 15px;" type="button">${vo.productQuestionTitle }▼</button>
               </td>
               <td>${vo.userId }</td>
               <fmt:formatDate value="${vo.productQuestionDateCreated }"
               pattern="yyyy-MM-dd" var="productQuestionDateCreated"/>
               <td>${productQuestionDateCreated }</td>
               <td><button onclick="window.open('qaUpdate?productQuestionNumber=${vo.productQuestionNumber }&&page=${page }', '수정', 'scrollbars=yes, resizable=no, width=600, height=1000, left=0, top=0');return false">수정</button> 
               <input type="button" class="deleteBtn" value="삭제"></td>
            </tr>
            <tr id="conts" style="display: none;">
               <td colspan="7"><p>${vo.productQuestionContent }</p>
               </td>
            </tr>
            
         </c:forEach>
      </tbody>
   </table>
   
   <!-- 페이지 처리 -->
   <ul class="pagination">
      <c:if test="${pageMaker.isHasPrev() }">
         <li><a href="Q&A?page=${pageMaker.startPageNo -1 }">Preview</a></li>
      </c:if>
      <c:forEach var="i" begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }">
         <li><a href="Q&A?page=${i }" class="active">${i }</a></li>
      </c:forEach>
      <c:if test="${pageMaker.isHasNext() }">
         <li><a href="Q&A?page=${pageMaker.endPageNo + 1 }">Next</a></li>
      </c:if>
   </ul>
   <br>
   
   <!-- 작성 버튼 함수 추가 -->
   <button onclick="btnInsert()" style="margin-left: 70%;">문의글 작성</button>
   
   <!-- Review -->
   <h2>구매후기</h2>
   <div class="review">
      <select style="margin-left: 25%;">
         <option>최신순</option>
         <option>댓글 순</option>
         <option>높은 평점 순</option>
         <option>낮은 평점 순</option>
      </select>
      <!-- Review 리스트 -->
      <div class="review-list-wrap" id="reviewlist">
         <%-- <c:forEach var="" items=""> --%>
            <div class="review-list" style="margin-left: 25%;">
               <div class="reivew-user"><br>
                  <p class="reivew-userId" style="display: inline;">호호</p> 
                  <p class="review-date-created" style="display: inline; margin-left: 50%;">2022-11-02</p>
               </div>
               <div class="review-user-profile">
                  <p class="review-user-gender" style="display: inline;">남성,</p>
                  <p class="review-user-height" style="display: inline;">183cm,</p>
                  <p class="review-user-weight" style="display: inline;">70kg</p>
               </div>
               <div class="review-grade">
                  <p class="grade">5</p>
               </div>
               <div class="review-content">
                  <p class="content">사이즈 적당하고 너무 좋아요!</p>
               </div><hr style="margin-right: 35%;">
               <span class="review-reply">댓글</span>
               <div>
                  <textarea rows="3" cols="100" placeholder="20자 이내로 입력해주세요."></textarea>
                  <button>댓글 작성</button> 
               </div>
            </div>
         <%-- </c:forEach> --%>
      </div>
   </div>
   
   <!-- 제목 클릭시 내용이 뜨게 하는 script문 -->
   <script type="text/javascript">
      $(document).ready(function() {
         $('#contents #title button').on('click' ,function() {
            var currentRow = $(this).closest('tr');
            var detail = currentRow.next('tr');
            
            if(detail.is(":visible")) {
               detail.hide();
            } else {
               detail.show();
            }
         });
      }); // end document()
      
      // btnInsert() 클릭시 팝업창 
      function btnInsert() {
         var w = window.open('qaregister', '문의글 작성', 'target=_blank, scrollbars=yes, resizable=no, width=600, height=1000, left=600px');
         $.ajax({
            url : 'qaregister',
            method : 'GET',
            dataType : 'jsp',
            success : eventSuccess
         });
         function eventSuccess(data) {
            w.location.href = 'qaregister';
         }
      } // end btnInser()
      
      $('.deleteBtn').click(function() {
         if(confirm('정말 삭제 하시겠습니까?')) {
            var str = '';
            var deleteBtn = $(this);
         
            var tr = deleteBtn.parent().parent();
            var td = tr.children();
         
            console.log("row : " + tr.text());
         
            var no = td.eq(0).text();
            console.log(no);
         
            $.ajax({
               type : 'DELETE',
               url : '/musinsa/qa/' + no,
               headers : {
                  'Content-Type' : 'application/json',
                  'X-HTTP-Method-Override' : 'DELETE'
               },
               data : JSON.stringify({
                  'productQuestionNumber' : no
               }),
               success : function(result) {
                  console.log(result);
                  alert('정상적으로 삭제 되었습니다.')
                  location.reload();
               }
               
            }); // end ajax()
         }
      }); // end deleteBtn.click()
   </script>


	
</body>
</html>





























