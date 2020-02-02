<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" 
	import='java.util.*'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>

 <jsp:useBean id='vo'	class='pr190819.MemberBean'	scope='session'	/>
 <jsp:setProperty	name='vo'	property='*'	/>
 <jsp:useBean id='dao'	class='pr190819.MemberDAO'	scope='page'	/>
 <%
 	Boolean check=dao.checkLogIn(vo.getId(),vo.getPwd());
 	request.setAttribute("check", check);
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<c:if test="${param.command=='sign_off' }"	>
	<c:remove var="vo"	scope="session"	/>
	<c:redirect url="login.jsp"		/>
</c:if>

<c:choose>
	<c:when test='${requestScope.check }'>
		<%
			vo=dao.listMember(vo.getId());
			session.setAttribute("vo",vo);
		%>
		<h1>안녕하세요 ${vo.name}님</h1>
		
		<c:url var="signOff" value="signInResult.jsp">
			<c:param name="command" value="sign_off"	/>
		</c:url>
		<c:url var="chgPwd" value="chgPwd.jsp">
			<c:param name="command" value="chg"	/>
		</c:url>
		
		<form>
			<input type=button onClick="location.href='${signOff}'" value="로그아웃하기"  />
			<input type=button onClick="location.href='${chgPwd}'" value="암호변경하기"  />
		</form>  
	</c:when>
	<c:otherwise>
		<h1>id 또는 비밀번호가 일치하지 않습니다.</h1>
		<c:remove var="vo"	scope="session"	/>
		<a href='signIn.jsp	'>다시 조회하기</a> 
	</c:otherwise>
</c:choose>


</body>
</html>