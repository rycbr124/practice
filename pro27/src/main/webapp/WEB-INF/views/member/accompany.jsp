<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    
<!DOCTYPE html>
<html>
<head>
<style>
/*h2{
    margin: 0;     
    color: #666;
    padding-top: 90px;
    font-size: 52px;
    font-family: "trebuchet ms", sans-serif;    
}

.item{
    background: white;    
    text-align: center;
    height: 300px !important;
}

.carousel{
    margin-top: 20px;
}

.bs-example{
	margin: 20px;
}

.carousel.carousel-fade.item {
  opacity:0;
  filter: alpha(opacity=0); 
}
.carousel.carousel-fade.active.item {
    opacity:1;
    filter: alpha(opacity=100); 
}*/

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/kfonts2.css">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery.min.js"></script>
<!--[if lt IE 9]-->
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
	<div id="content">
	<!-- tiles에서 content부분 -->
		<div id="content_header">
		<!-- content에서 헤더이미지 삽입할 부분 -->
		<img class="accompany-image" src="../resources/image/acoompanyMain.jpg"  style="width:100px; height:100px;"alt="accompany">
			<h1>Accompany</h1>
		</div>
    <div id="myCarousel" class="carousel slide" data-interval="6500" data-ride="carousel">
    	<!-- Carousel indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>   
       <!-- Carousel items -->
        <div class="carousel-inner" role="listbox">
            <div class="accompany-title1">
                <img src="../resources/image/sakura.jpg" height=400px; alt="gyungbokgung">
                <h2>경복궁 야간개장!!</h2>
                <div class="accompany-tag1">
                  <h3>#고궁투어  #경복궁  #야경</h3>
                </div>
            </div>
            <div class="accompany-title2">
                <img src="../resources/image/itaewon.jpg" height=400px; alt="matzip">
                <h2>서울 맛집 투어</h2>
                <div class="accompany-tag2">
                  <h3>#맛집  #사진  #인스타감성</h3>
                </div>
            </div>
            <div class="accompany-title3">
                <img src="../resources/image/coex.jpg" height=400px; alt="coex">
                <h2>코엑스에서 하루 보내기</h2>
                <div class="accompany-tag3">
                  <h3>#쇼핑  #코엑스  #아쿠아리움</h3>
                </div>
            </div>
        <!-- Carousel controls -->
        <a class="carousel-control left" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control right" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
	</div>	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>	
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
<script>
$('.carousel').carousel({
	interval: 6500
})
</script>	
</body>
</html>