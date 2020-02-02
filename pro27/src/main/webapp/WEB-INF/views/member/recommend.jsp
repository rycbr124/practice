<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천</title>
<link rel="stylesheet" href="../css/contentForm.css" type="text/css">
<style>
.fadding-photo:hover{
	opacity:0.4;
}
#header{width:100%; height:150px; position:absolute; z-index:200;
-webkit-transition:background 300ms, height 200ms; 
transition: background 300ms, height 200ms;}
#header a img{width:130px;height:70px; position:absolute; left:0;top:33px;
z-index:2;-webkit-transition:top 300ms;transition:top 300ms;margin-left:40px;}
#header a img:hover{content:url(../img/logo/흰색/logo_white.png); width:130px;height:70px; position:absolute; left:0;top:33px;
z-index:2;-webkit-transition:top 300ms;transition:top 300ms;margin-left:40px;}

.menu_container {display: block;width: 100%;position: relative;font-size: 0;line-height: 1;text-align: center;z-index: 1;}
#menu {margin-top: 49px;text-align:center; -webkit-transition: all 0.3s; transition:all 300ms;}
#menu:after {content: '';display: table;clear: both;}
#menu a {display: block;line-height: 1.7;text-decoration:none}
body:not(.use_mouse) #menu a {-webkit-transition: all 0.3s;transition: all 0.3s;}

/*1depth*/
#menu > li { padding:24px 28px; display: inline-block;vertical-align: top;position: relative; cursor:pointer;}
#menu > li > a {position: relative;font-family: 'Binggrae', sans-serif;font-size: 14px;font-weight: 600;color: #222;letter-spacing:0.025em; display:block;overflow: hidden;}
#menu > li:before {  font-family: 'jt-font'; font-size: 10px; font-weight: normal;text-align: center;color: lightgray; display:block; position:absolute; left:50%; top:5px;  -webkit-transform:scale(0.9) translateX(-50%); 
-ms-transform:scale(0.9) translateX(-50%);  transform:scale(0.9) translateX(-50%); content: '\e910';  opacity:0;  -webkit-transition: all 0.25s;  transition: all 0.25s;}
html #menu > li:hover > a,#menu > li.active > a{color:white;}
#menu > li > a {display: inline-block;position:relative;transition: -webkit-transform 500ms;transition: transform 500ms;transition: transform 500ms, -webkit-transform 500ms;-webkit-transition: -webkit-transform 500ms;-moz-transition: transform 500ms;/* overflow: hidden; */}
#menu > li > a:after {width:100%;content: attr(data-hover);position: absolute;top: -30px;left:0;transform: translate3d(0,0,0);-moz-transform: translate3d(0,0,0);-webkit-transform: translate3d(0,0,0);}


.member_menu{position:absolute;right:70px;top:71px;}
.member_menu a{padding-left:27px; margin-right:41px;font-size:12px;
font-weight:600; line-height:20px; letter-spacing:0.025em; color:white;font-family:'Binggrae',sans-serif;position:relative; display:inline-block;vertical-align:middle;
-webkit-transition:all 0.25s;transition:all 0.25s;}
html .member_menu a:last-child{margin-right:0;}
.member_menu a:before{font-family:'jt-font'; font-size:20px; font-weight:narmal;text-align:center;color:lightgray;display:block; position:absolue; left:0;}
html .member_menu a:hover{color:rgb(127,127,127);}

</style>
<script>
function pageFunction(){
	location.href="detail.jsp";
}
</script>
</head>
<body>
	<div id="header">
      <a href="index.jsp" class="header_logo">
         <img src="../img/logo/흰색/logo_white_all.png" alt="BTS">
      </a>
   <div class="header_control_container">
      <ul id="menu" class="menu">
         <li class="menu_recommend">
            <a href="#">추천</a>
         </li>
         <li class="menu_reservation">
            <a href="#">예약</a>
         </li>
         <li class="menu_accompany">
            <a href="#">동행</a>
         </li>
         <li class="menu_community">
            <a href="#">커뮤니티</a>
         </li>
         <li class="menu_planner">
            <a href="#">플래너</a>
         </li>      
      </ul>
      </div>
   <div class="member_menu">
      <a href="#" class="login"><span>LOGIN</span></a>
      <a href="#" class="signup"><span>SIGN UP</span></a>
   </div><!-- member_menu -->
   </div>
	<div id="content">
	<!-- tiles에서 content부분 -->
		<div id="content_header">
		<!-- content에서 헤더이미지 삽입할 부분 -->
			<h1>Recommend</h1>
		</div>
		<div id="content_section">
			<div id="image_grid">
				    <div class="row">
				    	<br><br><br><br>
				    	<img class="fadding-photo" src="../img/train.jpg" width="280px" height="200px" hspace="35px">
				    	<img class="fadding-photo" src="../img/sample.jpg" width="280px" height="200px" hspace="35px">
				    	<img class="fadding-photo" src="../img/itaewon.jpg" width="280px" height="200px" hspace="35px">
				    	<br><br><br><br>
				    	<img class="fadding-photo" src="../img/11.jpg" width="280px" height="200px" hspace="35px" onClick="pageFunction()">
				    	<img class="fadding-photo" src="../img/healing.png" width="280px" height="200px" hspace="35px">
				    	<img class="fadding-photo" src="../img/22.jpg" width="280px" height="200px" hspace="35px">
				    </div>
				    
				    <br><br><br><br><br><br><br><br><br><br><br>
			</div>
			<div id="paging">
			</div>
		</div>
	</div>
</body>
</html>