<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memberInfo" class="sec01.MemberBean"	/>
<jsp:setProperty name="memberInfo"		property="*"	/><!-- 파라미터로 오는 모든 정보를 속성에 assign -->
<jsp:setProperty name="memberInfo"		property="pwd"	value="<%=memberInfo.getId()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입</title>
</head>
<body>
	
	<table width="400" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty name="memberInfo"		property="id"		/></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><jsp:getProperty name="memberInfo"		property="pwd"		/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><jsp:getProperty name="memberInfo"		property="name"		/></td>
			<td>이메일</td>
			<td><jsp:getProperty name="memberInfo"		property="email"		/></td>
		</tr>
	</table>
	
</body>
</html>