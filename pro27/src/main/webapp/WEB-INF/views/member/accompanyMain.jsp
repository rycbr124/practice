<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="result" value="${param.result }" />
<%
   request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>동행 메인</title>

<!-- Bootstrap core CSS -->
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../resources/css/accompanyMain.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->

	<!-- Page Content -->
	<div class="container">
		<!-- Heading Row -->
		<div class="row align-items-center my-5">
			<div class="img-fluid rounded mb-4 mb-lg-0">
				<img class="img-accompany" src="../resources/image/accompanyMain.jpg" alt="accompany" align="left">
			</div>
			<!-- /.col-lg-8 -->
			<div class="col-lg-5">
				<h1 class="font-weight-light" id="centercardText">BTS에서 함께 동행을 찾아 여행을 떠나보세요</h1>
				<p>동행 목록에서 같이 가고싶은 상대를 찾아 매칭을 신청해 보세요!!</p>
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->

		<!-- Call to Action Well -->
		<div class="card text-white bg-secondary my-5 py-4 text-center" id="centercard">
			<div class="card-body">
				<p class="text-white m-0" id="centercardText">아래 동행 목록에서 신청해보세요!</p>
			</div>
		</div>

		<!-- Content Row -->
		<div class="row">
			<div class="col-md-4 mb-5">
				<div class="card h-100" id="card1">
					<div class="card-body" id="cardbody1">
						<h2 class="card-title">경복궁 야간개장</h2>
						<img class="card-image" src="../resources/image/sakura.jpg">
						<p class="card-text">#고궁투어 #경복궁 #야경</p>
					</div>
					<div class="card-footer" id="cardbtn1">
						<a href="${contextPath }/member/accompany2.do" class="btn btn-primary btn-sm">동행 신청</a>
					</div>
				</div>
			</div>
			<!-- /.col-md-4 -->
			<div class="col-md-4 mb-5">
				<div class="card h-100" id="card2">
					<div class="card-body" id="cardbody2">
						<h2 class="card-title">서울 맛집 투어</h2>
						<img class="card-image" src="../resources/image/samchung.jpg">
						<p class="card-text">#맛집 #사진 #인스타그램</p>
					</div>
					<div class="card-footer" id="cardbtn2">
						<a href="#" class="btn btn-primary btn-sm">동행 신청</a>
					</div>
				</div>
			</div>
			<!-- /.col-md-4 -->
			<div class="col-md-4 mb-5">
				<div class="card h-100" id="card3">
					<div class="card-body" id="cardbody3">
						<h2 class="card-title">코엑스에서 하루 보내기</h2>
						<img class="card-image" src="../resources/image/coex.jpg">
						<p class="card-text">#쇼핑 #코엑스 #아쿠아리움</p>
					</div>
					<div class="card-footer" id="cardbtn3">
						<a href="#" class="btn btn-primary btn-sm">동행 신청</a>
					</div>
				</div>
			</div>
			<!-- /.col-md-4 -->
			
		</div>
		<!-- /.row -->
		<div>
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#">Prev</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">4</a></li>
					<li class="page-item"><a class="page-link" href="#">5</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</div>
	</div>
	<!-- /.container -->

	<!-- Footer -->

	<!-- Bootstrap core JavaScript -->
	<script src="../resources/jquery/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>