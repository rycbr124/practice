<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//getParameter() 메서드를 이용해 입력 정보를 가져옵니다.
	String user_id=request.getParameter("user_id");
	String user_pw=request.getParameter("user_pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과출력창</title>
</head>
<body>
	<%
		if(user_id==null ||user_id.length()==0){//id가 정상적으로 입력되었는지 체크합니다.
	%>
		<%-- ID를 입력하지 않았을 경우 다시 로그인창으로 이동합니다. --%>
		아이디를 입력하세요.<br>
		<a href="/pro11/login.html">로그인하기</a>
		
		<%
		}else{
		%>
		<h1>환영합니다. <%=user_id %>님!!!</h1><%-- id를 정상적으로 입력했을 경우 메시지를 표시합니다. --%>
						<%-- id를 표현식으로 출력합니다. --%>
		<%
		}
	%>
</body>
</html>