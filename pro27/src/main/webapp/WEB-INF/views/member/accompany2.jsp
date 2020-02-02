<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동행 신청</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/css/accompany2.css" rel="stylesheet">
</head>
<body>
	<!-- Page Content -->
	<div class="container">
		<!-- Head row -->
		<div class="row align-items-center my-5">
			<h1 class="font-weight-light">경복궁 야간개장</h1>
			<div class="img-fluid rounded mb-4 mb-lg-0">
				<img class="img-selectAccompany" src="../resources/image/sakura.jpg" alt="gyungbok" align="left">
			</div>
			<!-- /col-lg-8 -->
			<div class="col-lg-5">
				<h1 class="font-weight-light" id="selectText">상세 정보</h1>
				<p>Day1 : 경복궁 야간개장 및 저녁</p>
				<p>인원 : 1명</p>
				<p>나이 : 27세</p>
				<p>장소 : 서울 경복궁</p>
				<p>성별 : 남자</p>
				<p>태그 : #고궁투어 #경복궁 #야경</p>
			</div>
			<div class="img-fluid rounded mb-4 mb-lg-0">
			<img class="img-map" src="../resources/image/map.jpg" alt="map" align="right">
			</div>
		</div>
		<!-- form -->
		<div>
			<h3>신청 정보 입력</h3>
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label for="age" class="col-sm-2 control-label">나이</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="age" placeholder="나이">
					</div>
				</div>
				<div class="form-group">
					<label for="gender" class="col-sm-2 control-label">성별</label>
					<div class="col-lg-4">
						<select class="form-control" id="gender">
							<option value="male">남자</option>
							<option value="female">여자</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="count" class="col-sm-2 control-label">인원</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="count" placeholder="인원">
					</div>
				</div>
				<div class="form-group">
					<label for="tag" class="col-sm-2 control-label">태그</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="tag1" placeholder="#태그1">
					</div>
				</div>
				<div class="form-group">
					<label for="tag" class="col-sm-2 control-label"></label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="tag2" placeholder="#태그2">
					</div>
				</div>
				<div class="form-group">
					<label for="tag" class="col-sm-2 control-label"></label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="tag3" placeholder="#태그3">
					</div>
				</div>
				<div class="form-group">
					<label for="tag" class="col-sm-2 control-label"></label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="tag4" placeholder="#태그4">
					</div>
				</div>
				<div class="form-group">
					<label for="tag" class="col-sm-2 control-label"></label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="tag5" placeholder="#태그5">
					</div>
				</div>
				<br><br>
				<div class="form-group">
					<div class="col-sm-offset-2 col-lg-3">
						<button type="submit" class="btn btn-default">매칭 신청</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="../resources/jquery/jquery.min.js"></script>
	<script src="../resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>