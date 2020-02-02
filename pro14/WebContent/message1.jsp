<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%-- <fmt>태그를 이용하기 전에 반드시 설정해야 합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 다국어 기능</title>
</head>
<body>
 
<%-- <fmt:setLocale value="en_US" /> --%><%-- locale을 영어로 지정합니다. --%>
<fmt:setLocale value="ko_KR" /><%-- locale을 한글로 지정합니다. --%>

<h1>
 회원정보<br><br>
 <fmt:bundle basename="resource.member" > <%-- resource 패키지 아래 member프로퍼티 파일을 읽어옵니다. --%>
  이름:<fmt:message key="mem.name" /><br><%-- <fmt:message>태그의 key속성에 프로퍼티 파일의 key를 지정하여 값(value)을 출력합니다. --%>
  주소:<fmt:message key="mem.address" /><br>
  직업:<fmt:message key="mem.job" />
</fmt:bundle>
</h1>
</body>
</html>