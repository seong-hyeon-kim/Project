<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>회원 가입</title>

<style>

/* 중복아이디 존재하지 않는경우 */
	.userId_ok{
		color : green;
		display : none;
	}
/* 중복아이디 존재하는 경우 */
	.userId_no{
		color : red;
		display : none;
	}
	
/* 비밀번호가 일치하는 경우 */
	.userpw_ok{
		color : green;
		display : none;
	}
		
/* 비밀번호가 일치하지 않는경우 */
	.userpw_no{
		color : red;
		display : none;
	}
	
</style>

</head>
<body>

<form action="join" method="POST">

	<h1>회원 가입</h1>
	<div>아이디</div>
	 <input type="text" name="userId" placeholder="아이디 입력" required="required">
		<div class="userId_ok">사용 가능한 아이디 입니다.</div>
		<div class="userId_no">사용하고 있는 아이디 입니다.</div>
	
	 <div>비밀번호</div>
	<input type="password" name="userPassword" id="userPasswordChk1" placeholder="비밀번호 입력" required="required"><br>
	비밀번호 재입력<br><input type="password"  id="userPasswordChk2" placeholder="비밀번호 확인" required="required">
	<div class="userpw_ok">비밀번호가 일치합니다.</div>
	<div class="userpw_no">비밀번호가 일치하지 않습니다.</div>
	
	<div>이름</div>
	<input type="text" name="userName" placeholder="이름 입력" required="required"><br><br>
	
	<div>성별</div>
	 남자<input type="radio" name="userGender" id="userGender" value="man" required="required" checked>
	 여자<input type="radio" name="userGender" id="userGender" value="woman" required="required"><br><br>
	
	<div>키</div>
	<input type="text" name="userHeight" id="userHeight" placeholder="키 입력" required="required">cm<br>
	
	<div>몸무게</div>
	<input type="text" name="userWeight" id="userWeight" placeholder="몸무게 입력" required="required">kg<br>
	
	<div>나이</div>
	<input type="number" name="userAge" id="userAge" placeholder="나이 입력" required="required"><br>
	
	<div>이메일</div>
	<input type="email" name="userEmail" id="userEmail" placeholder="이메일 입력" required="required"><br>
	
	<div>연락처</div>
	 <input type="text" name="userPhone"  id="userPhone" placeholder="연락처 입력" required="required"><br>
	
	<div>주소</div>
		<input type="text" id="sample6_postcode" name="userAddress01" placeholder="우편번호" required="required">
		<input type="button" name="userAddress" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" required="required"><br>
		<input type="text" name="userAddress02" id="sample6_address" placeholder="주소" required="required"><br>
		<input type="text" name="userAddress03" id="sample6_detailAddress" placeholder="상세주소"required="required">
	    <input type="text" name="userAddress04" id="sample6_extraAddress" placeholder="참고항목">	
	    <br><br>
	
	<input type="submit" id="joinChk" value="가입하기" class="join_button">
</form>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">


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

    
    
    
    // 아이디 중복검사(아이디 중복일 경우 = 1, 중복이 아닐 경우 = 0)
    $(document).ready(function(){
    	$('input[name=userId]').blur(function(){ // userId 칸을 벗어나면 userIdChk 실행
    		userIdChk(); 
    		console.log("keyup 테스트");	
    	});// end function

    	
    function userIdChk(){
    var userId = $('input[name=userId]').val(); // // .userId에 입력되는 값
    var data = {'userId' : userId} // // '컨트롤에 넘길 데이터 이름' : 데이터(.userId에 입력되는 값)
    
    //-> RESTController로 이동 // 컨트롤러->서비스->dao->xml->db조회 
    $.ajax({
    		type : "post",
    		url : "join/userIdChk", //  가야되는 컨트롤러 url 
    		headers : {
                'Content-Type' : 'application/json',
                'X-HTTP-Method-Override' : 'POST'
             },
             
    		data : JSON.stringify(data),
    		
    		success : function(result){ // db조회 성공 후 리턴값이 돌아오면 
    			
    		if(result == 1) { 
    			$('.userId_no').css("display","inline-block");
    			$('.userId_ok').css("display","none");
    		//	alert("중복된 아이디 입니다.");
    			
    		} else {
    			$('.userId_ok').css("display", "inline-block");
    			$('.userId_no').css("display", "none");
    			
    	//		alert("사용 가능한 아이디입니다."); 
    		  }
    	  }	// end success
    	}); // end ajax
    }; // end userIdChk
  
    
    
    
    // 비밀번호 확인  
 	$('#userPasswordChk2').blur(function(){ // userPassword 칸을 벗어나면 실행
 		passwordChk();
 		console.log("비밀번호체크 테스트");
 	}); // end function 
 	
   	function passwordChk(){
 	   if($('#userPasswordChk1').val() != $('#userPasswordChk2').val()){
 		  $('.userpw_no').css("display","inline-block");
 		  $('.userpw_ok').css("display", "none");
 	// 	alert("비밀번호가 일치하지 않습니다.");
 	 	
 	   } else {
 			$('.userpw_ok').css("display", "inline-block");
 			$('.userpw_no').css("display","none");
 	//	 alert("비밀번호가 일치합니다.");
 	   }
 	} // end passwordChk
  
     
 	
 	// 비밀번호 일치 후 회원가입
 	$('#joinChk').on("click", function(){
 		if($('#userPasswordChk1').val() != $('#userPasswordChk2').val()){
 			alert("비밀번호가 일치하지 않습니다.");
 			$('#userPasswordChk2').focus();
 			return false; // 비밀번호가 일치하지 않으면 그대로 
 		} else {
 	//		alert("회원가입 완료 되었습니다.");
 		}
 	});
 	

   
   // 회원가입완료 예외 체크  
    	
   }); // end document()
    
</script>

	<!--★ 필수 아이디 중복확인 ㅇ, 아이디 예외처리, 비밀번호 일치여부ㅇ, 빈칸여부ㅇ, 성공 알러트 띄우고 메인으로, 주소 API ㅇ, 본인인증 ?,.. 
	아이디 예외처리 -> 공백 사용불가, 아이디 글자수처리, 안되는 아이디로 가입버튼 누르면 다시입력창으로 돌리기, 비밀번호확인하고 일치해야 회원가입완료(어렵?) -->
	<!--칸 누르면 글씨 없애기,  -->	


 
 


</body>
</html>