<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String cookieName="id";
	Cookie cookie = new Cookie(cookieName,"hongkd");
	cookie.setMaxAge(60*2);
	cookie.setValue("kimkd");
	response.addCookie(cookie);
%><P>
<%=cookieName %> 쿠키가 생성되었습니다.<br>
<input type="button" value="쿠키의 내용 확인" onclick="javascript:window.location='useCookie.jsp'"	/>
</P>
</body>
</html>