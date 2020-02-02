<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar 클래스 사용</title>
</head>
<body>
<%
java.util.Calendar cal = java.util.Calendar.getInstance();
Date now=new Date();
%>
오늘은
<%=cal.get(java.util.Calendar.YEAR) %>년
<%=cal.get(java.util.Calendar.MONTH)+1 %>월
<%=cal.get(java.util.Calendar.DATE) %>일
입니다.<br>
현재시각:
<%=now %>

<!-- 브라우저 소스보기에서는 Directive Tag영역이 비어보임,공백을 비워주는 태그 -->
<%@ page trimDirectiveWhitespaces="true"%>
</body>
</html>