<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<%//login.jsp로 전달할 오류 메세지를 선언합니다.
	String msg="아이디를 입력하지 않았습니다. 아이디를 입력해 주세요. ";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userID=request.getParameter("userID");//로그인 시 입력한 이름을 가져옵니다.
		if(userID.length()==0){
		//이름을 입력하지 않았을 경우 <jsp:param 액션 태그를 이용해> 오류 메세지를 login2.jsp로 전송합니다.
			/*RequestDispatcher를 사용해 포워딩 하지 않아도 됩니다.
				RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
				dispatch.forward(request, response);
			*/
		%>
		<jsp:forward page="login2.jsp"		/>
		<!-- ID를 입력하지 않았으면 다시 <jsp:forward>태그를 사용해 로그인 창으로 포워딩합니다. -->
		<% 
		}
	%>
		<h1>환영합니다 <%=userID %>님!!! </h1>
</body>
</html>