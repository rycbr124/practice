<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"     isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frmLogin" method="post" action="${contextPath}/test/login.do">
		<table border="0" width="80%" align="center">
			<tr align="center">
				<td><input type="text" name="userID" value="" size="20"></td>
				<td><input type="password" name="passwd" value="" size="20"></td>				
			</tr>
		</table>
		<input type="submit" value="로그인">
	</form>
</body>
</html>