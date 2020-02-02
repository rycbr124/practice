<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="pr190813.CustomersVO" scope="request"		/><%-- 유즈빈 액션 태그를 이용해 유즈빈을 만듭니다. --%>
								<!-- 페이지에서 유효한 객체,dispatch하려면 request, session은 session-->  

<%-- 전송된 매개변수 이름과 빈 속성을 비교한 후 동일한 빈에 값을 자동으로 설정합니다. --%>
<jsp:setProperty name="m"	property="*"		/>
<%
	RequestDispatcher dispatch=request.getRequestDispatcher("/customers");
	dispatch.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>