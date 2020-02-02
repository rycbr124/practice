<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{margin:0;}
#header{width:100%; height:100px; position:relative; z-index:200;top:0;
-webkit-transition:background 300ms, height 200ms; 
transition: background 300ms, height 200ms; }
/*LOGO*/
.header_logo img{width:130px;height:70px; position:absolute; left:0;top:20px;
z-index:2;margin-left:40px;}
.header_logo img:hover{width:130px; height:70px;content:url(../resources/image/BTS_logo_black_all.png);}

/*MENU*/
.menu_container {width: 100%;position: relative;font-size:0;line-height: 1;text-align: center;z-index: 1;}
#menu {margin-top: 20px;text-align:center; -webkit-transition: all 0.3s; transition:all 300ms;}
#menu:after {content: '';display: table;clear: both;}
#menu a {display: block;line-height: 1.7;text-decoration:none;}

/*1depth*/
#menu > li { padding:24px 24px; display: inline-block;vertical-align: top;position: relative; cursor:pointer;}
#menu > li > a {position: relative;font-family: 'Binggrae', sans-serif;font-size: 14px;font-weight: 600;color: #222;letter-spacing:0.025em; display:block;overflow: hidden;}
#menu > li:before {  font-family: 'jt-font'; font-size: 10px; font-weight: normal;text-align: center;color: lightgray; display:block; position:absolute; left:50%; top:5px;  -webkit-transform:scale(0.9) translateX(-50%); 
-ms-transform:scale(0.9) translateX(-50%);  transform:scale(0.9) translateX(-50%); content: '\e910';  opacity:0;  -webkit-transition: all 0.25s;  transition: all 0.25s;}
html #menu > li:hover > a,#menu > li.active > a{color:white;}
#menu > li > a {display: inline-block;position:relative;transition: -webkit-transform 500ms;transition: transform 500ms;transition: transform 500ms, -webkit-transform 500ms;-webkit-transition: -webkit-transform 500ms;-moz-transition: transform 500ms;/* overflow: hidden; */}
#menu > li > a:after {width:100%;content: attr(data-hover);position: absolute;top: -30px;left:0;transform: translate3d(0,0,0);-moz-transform: translate3d(0,0,0);-webkit-transform: translate3d(0,0,0);}

/*MEMBER*/
.member_menu{position:absolute;right:70px;top:50px;}
.member_menu a{padding-left:27px; margin-right:20px;font-size:12px;
font-weight:600; line-height:20px; letter-spacing:0.025em; color:black;font-family:'Binggrae',sans-serif;position:relative; display:inline-block;vertical-align:middle;
-webkit-transition:all 0.25s;transition:all 0.25s;}
html .member_menu a:last-child{margin-right:0;}
.member_menu a:before{font-family:'jt-font'; font-size:20px; font-weight:narmal;text-align:center;color:lightgray;display:block; position:absolue; left:0;}
html .member_menu a:hover{color:rgb(127,127,127);}
</style>
<meta charset="UTF-8">
<title>상단</title>
</head>
<body>
<div id="header">
      <a href="index.jsp" class="header_logo">
         <img src="../resources/image/BTS_logo_black.png" alt="BTS">
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
      </div><!-- header_control_container -->
   <div class="member_menu">
      <a href="#" class="login"><span>LOGIN</span></a>
      <a href="#" class="signup"><span>SIGN UP</span></a>
   </div><!-- member_menu -->
   </div><!-- header -->
</body>
</html>