<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta charset="UTF-8">
<title>Musinsa Main</title>
<style>
ul {
	list-style-type: none;
	float: left;
	margin-left: auto;
	margin-right: auto;
}


</style>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<% 

	String loginChk = (String) session.getAttribute("loginChk");
	String userId= (String) session.getAttribute("userId");
	if(loginChk != null && loginChk.equals("Chk")){
		session.setAttribute("loginChk", "");
%>
<script type="text/javascript">
	alert('로그인 성공');
</script>

<% 		
	}
%>
<style>
*{
	margin: 0;
	padding:0;
}
/* 화면 전체 렙 */
.wrapper{
	width: auto;
}
/* content 랩 */
.wrap{
	width : 1095px;
	margin: auto;
}
/* 홈페이지 기능 네비 */ 
.top_gnb_area{
	width: auto;
    height: 50px;
    background-color: white;
}
/* 로고, 검색, 로그인 */
.top_area{
	width: auto;
    height: 150px;
    /* background-color: #f7f0b9; */
}
/* 로고 영역 */
.logo_area{
	width: 100%;
	height: 100%;
	background-color: black;
	float:left;
}
/* /* 검색 박스 영역 */ */
/* .search_area{ */
/* 	width: 50%; */
/* 	height: 100%; */
/* 	background-color: yellow; */
/* 	float:left;	 */
/* } */
/* 로그인 버튼 영역 */
 .login_area{
	width: 25%;
	height: 100%;
	display: inline-block;	
	text-align: center;	
}
/* .login_button{
	height: 50%;
    background-color: #D4DFE6;
    margin-top: 30px;
    line-height: 77px;
    font-size: 40px;
    font-weight: 900;
    border-radius: 10px;
    cursor: pointer;	 */
}
.login_area>span{
	margin-top: 10px;
    font-weight: 900;
    display: inline-block;
}
.login_button{
	height : 50%;
	background-color: white;
	margin-top:30px;
}

/* 제품 목록 네비 */
.navi_bar_area{
	width: 100%;
    height: 70px;
    background-color: white;
}

/* 홈페이지 메인 제품 목록  */
.content_area{
	width: 100%;
    background-color: white;
    height: 380px;
}

/* float 속성 해제 */
.clearfix{
	clear: both;
}
</style>

</head>
<body>


<div class="wrapper" style="margin: auto;">

	<div class="wrap">
		<div class="top_gnb_area">
			<div class="logo_area">
				<h1><a style="text-decoration: none; color: white;" href="http://localhost:8080/musinsa/">MUSINSA</a></h1>
			</div>
		</div>
		
		<div class="top_area">
			
			<div class="login_area" >
			<c:if test="${not empty sessionScope.userId}">
			어서오세요 <%=userId%>님
			</c:if>
				
				<div id="login" class="login_button"><a href="/musinsa/user/login">로그인</a></div>
				<div id="join" class="join_button"><a href="/musinsa/user/join">회원가입</a></div>
				<c:if test="${not empty sessionScope.userId}">
					<div id ="userResult" class="mypage_button"><a href="/musinsa/user/userResult?userId='<%=userId%>'">마이페이지</a></div>				
				</c:if>
				<div id="logout" style="display: none"><a href="/musinsa/user/logout">로그아웃</a></div>
				<c:if test="${userId eq 'admin'}">
					<div id="verify" class="verify_button"><a href="/musinsa/user/verify">관리자</a></div>
					<a href="../musinsa/product/list"><input type="button" value="상품 등록창"></a>
				</c:if>
				<a href="http://localhost:8080/musinsa/payment"><input type="button" value="결제내역"></a>
				<a href="http://localhost:8080/musinsa/cart"><input type="button" value="장바구니"></a>
				<a href="http://localhost:8080/musinsa/like"><input type="button" value="좋아요"></a>
				<input type="button" id="show" value="비회원 결제내역"><br>
			</div>
			
			
		<div class="search_by_name">
			<input type="text" id="nameSearch" placeholder="검색어">
		</div>
				
					
		</div>
		
		<div class="navi_bar_area">
			<!-- <h5>3</h5> --> 
				<!-- 슬릭 시작 -->
	<div class="slide_div_wrap">
				<div class="slide_div">
					<div>
						<a>
							<img src="https://image.msscdn.net/images/img/2022111016554100000094448.jpg" width="800" height="400" style="margin: auto;">
						</a>
					</div>
					<div>
						<a>
							<img src="https://image.msscdn.net/images/img/2022110909043700000045327.jpg" width="800" height="400" style="margin: auto;">
						</a>
					</div>
					<div>
						<a>
							<img src="https://cdn.apnews.kr/news/photo/202010/20201025_1_bodyimg_1301291.JPG" width="800" height="400" style="margin: auto;">
						</a>
					</div>	
					<div>
						<a>
							<img src="https://www.kocca.kr/n_content/vol24/img/new/special_people2/people2_7.jpg" width="800" height="400" style="margin: auto;">
						</a>
					</div>	
				</div>	
			</div>
	<!-- 슬릭  끝 -->
		</div>
		
		<div class="content_area">
			<!-- <h5>4</h5> --> 
			
		</div>
		
		<!-- test -->
		<hr>
		<div class="search_by_category">
			<select>
				<option>상의</option>
				<option>하의</option>
			</select>
		</div>	
		<c:forEach var="vo" items="${list}">
	
	<div class="productList" style="margin: auto;">
		<ul>
			<li  style="margin:auto; border: 1px solid grey; width: 150px; height: 280px; text-align: center;    display: table-cell; vertical-align: middle;" >
				<a href="detail?productNumber=${vo.productNumber }"> <!-- 누르면 상세페이지 이동 -->
					<div class="photo">
						<img alt="" src="product/display?fileName=/${vo.productImg}" style="width: 125px; height: 150px;">
					</div>
					<div class="information">
						<a>${vo.productName }</a> <br>
						<a>${vo.productPrice }원</a> <br>
						<a>${vo.productSize }</a> <br>
						<a>평점 : ${vo.productGrade }</a><br>
						<a><i class="fas fa-heart"></i> ${vo.productGood }</a> 
					</div>
					
				</a>
			</li>
		</ul>
	</div>
	
	</c:forEach>
		
		
	</div>
</div>
<input type="hidden" id="insertAlert" value="${insert_result}">

<!-- 로그인되면 로그인버튼이 로그아웃 되기ㅇ,로그인 되면 회원가입 버튼 없애기, user님 으로 뜨게하기, 버튼만들기(마이페이지,장바구니,고객센터,게시판(공지) ) -->




	

	
	
	<script type="text/javascript">
		$(document).ready(function() {
			$(".slide_div").slick(
			{
					dots: true,
					autoplay : true,
					autoplaySpeed: 3000
			}		
			);
		});
		
		$('#show').click(function() {
			// 창 크기
			var width = 700;
			var height = 550;
			
			// pop 화면 기준 가운데 정렬
			var left = (window.screen.width / 2) - (width/2); // 에러는 아니지만 인식문제로 에러표시
			var top = (window.screen.height / 4);
			
			// 윈도우 속성 지정
			var windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes';
			
			// 연결을 원하는 url
			const url = "user/nonUserPayment";
			
			// 등록된 url 및  window 속성 기준으로 팝업창을 연다.
			
			window.open(url, "hello", windowStatus);
		})
			
			
		
	</script>
	
	
	
	

</body>

<% 
	if(userId != null){
		
%>
<script type="text/javascript">
 	$('#login').hide();
	$('#logout').show();	
	$('#join').hide();
	
</script>

<% 		
	}
%>

</html>