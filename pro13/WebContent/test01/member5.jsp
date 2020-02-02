<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, sec01.*"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<jsp:useBean id="m1" class="sec01.MemberBean"	/>
<jsp:setProperty name="m1" property="*"  />
<jsp:useBean  id="membersList" class="java.util.ArrayList" />
<%-- MemberBean 객체를 저장할 ArrayList 객체를 생성합니다. --%>
<jsp:useBean  id="membersMap" class="java.util.HashMap" />
<%-- 회원 정보를 저장할 HashMap 객체를 <useBean> 액션 태그를 이용해 생성합니다.--%>
<%	
	//HashMap에 key/value 쌍으로 회원 정보를 저장합니다.
   membersMap.put("id", "park2");
   membersMap.put("pwd", "4321");
   membersMap.put("name","박지성");
   membersMap.put("email","park2@test.com");
   
   MemberBean m2 = new MemberBean("son", "1234", "손흥민", "son@test.com");
   //회원 정보를 저장하는 MemberBean 객체를 생성합니다.
   
   //전송된 회원 정보와 자바 코드로 생성한 회원 정보를 ArrayList에 저장합니다.
   membersList.add(m1);
   membersList.add(m2); 
   
   membersMap.put("membersList",  membersList);  
   //회원 정보가 저장된 membersList를 membersList라는 key로 HashMap에 저장합니다.
%>
<html>
<head>
<meta charset=”UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border=1  align="center" >
    <tr align=center bgcolor="#99ccff">
      <td width="20%"><b>아이디</b></td>
      <td width="20%"><b>비밀번호</b></td>
      <td width="20%" ><b>이름</b></td>
      <td width="20%"><b>이메일</b></td>
</tr>	
<tr align=center>
    <%-- HashMap 이름 뒤에 마침표 연산자로 저장 시 사용한 key를  사용하여 value를 가져옵니다.--%>
      <td>${membersMap.id}</td>
      <td>${membersMap.pwd}</td>
      <td>${membersMap.name}</td>
      <td>${membersMap.email }</td> 
</tr>
    <tr align=center>
    <%-- HashMap에 저장된 ArrayList에 마침표로 접근한 후 
    다시 각각의 속성에 마침표를 이용해 접근하여 첫 번째 회원 정보를 출력합니다. --%>
      <td>${membersMap.membersList[0].id}</td>
      <td>${membersMap.membersList[0].pwd}</td>
      <td>${membersMap.membersList[0].name}</td>
      <td>${membersMap.membersList[0].email}</td>
   </tr>
   <tr align=center>
   <%--ArrayList에 저장된 두 번째 회원 정보를 출력합니다. --%>
      <td>${membersMap.membersList[1].id}</td>
      <td>${membersMap.membersList[1].pwd}</td>
      <td>${membersMap.membersList[1].name}</td>
      <td>${membersMap.membersList[1].email}</td>
</tr>
</table>
</body>