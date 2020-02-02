<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    
    isELIgnored="false" %>
<%-- core 태그 라이브러리를 사용하기 위해 반드시 선언해야 합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="signUp" value="signUp.jsp">
	<c:param name="command" value="sign_up"	/>
</c:url>
<c:url var="signIn" value="signIn.jsp">
	<c:param name="command" value="sign_in"	/>
</c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<form name="frmLogin" method="post" action="login.jsp" encType="UTF-8">
	<input type="button"  onClick="location.href='${signUp}'" value="회원가입하기">
	<input type="button"  onClick="location.href='${signIn}'" value="로그인하기">
	</form>
</body>
</html>