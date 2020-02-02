<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");//한글 인코딩을 설정합니다.
%>
<jsp:useBean id="m" class="sec01.MemberBean"	/><%-- 회원 정보를 저장할 빈을 생성합니다. --%>
<jsp:setProperty name="m" property="*"	/><%-- 전송된 회원 정보를 빈의 속성에 설정합니다. --%>


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
			<td width="20%">주소</td>
		</tr>
		<tr align="center">
		<%-- 표현식을 이용해 회원 정보를 출력합니다. --%>
			<td>${m.getId()}</td>
			<td>${m.getPwd() }</td>
			<td>${m.getName() }</td>
			<td>${m.email()}</td>
		</tr>
		<%-- 빈 id와 속성 이름으로 접근해 회원 정보를 출력합니다. --%>
		<tr align="center">
			<td>${m.id}</td>
			<td>${m.pwd}</td>
			<td>${m.name }</td>
			<td>${m.email}</td>
		</tr>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>