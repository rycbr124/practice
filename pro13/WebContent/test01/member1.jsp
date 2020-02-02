<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");//한글 인코딩을 설정합니다.
	//전송된 회원 정보를 가져옵니다.
	String   id=request.getParameter("id");
	String  pwd = request.getParameter("pwd");
	String  name = request.getParameter("name");
	String  email = request.getParameter("email");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1"	align="center" >
		<tr align="center" bgcolor="#99ccff">
			<td width="20%">아이디</td>
			<td width="20%">비밀번호</td>
			<td width="20%">이름</td>
			<td width="20%">이메일</td>
		</tr>
		<tr align="center">
		<%-- getParameter로 가져온 회원 정보를 표현식으로 출력합니다. --%>
			<td><%=id%></td>
			<td><%=pwd%></td>
			<td><%=name %></td>
			<td><%=email %></td>
		</tr>
		<tr align="center">
		<%-- param 객체를 이용해 getParameter()메서드를 이용하지 않고 바로 회원 정보를 출력합니다. --%>
			<td>${param.id}</td>
			<td>${param.pwd }</td>
			<td>${param.name }</td>
			<td>${param.email}</td>
		</tr>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>