
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec01.*" pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");//한글 인코딩을 설정합니다.
%>
<jsp:useBean id="m"	class="sec01.MemberBean"	scope="page"	/>
<!-- useBean 액션 태그로 id가 m인 MemberBean객체를 만듭니다. -->
<%
	//전송된 회원 정보를 가져옵니다.
	String   id=request.getParameter("id");
	String  pwd = request.getParameter("pwd");
	String  name = request.getParameter("name");
	String  email = request.getParameter("email");
 
  
	//MemberBean  m =  new MemberBean(id, pwd, name, email);
	//자바 코드에서 MemberBean 객체를 생성하지 않습니다.(주석풀면 dup에러)
	
	//전송된 회원 정보를 useBean에 저장합니다.
	m.setId(id);
	m.setPwd(pwd);
	m.setName(name);
	m.setEmail(email);
	
	MemberDAO  memberDAO=new MemberDAO();
	
	//회원 정보를 추가한 후 목록으로 출력합니다.
	memberDAO.addMember(m);//회원 정보를 테이블에 추가합니다.
	List membersList = memberDAO.listMembers();//전체 회원 정보를 조회합니다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
		<%
	   if(membersList.size()==0){
	%>
		<tr>
			<td colspan="5">
				<p align="center">
					<b><span style="font-size: 9pt;"> 등록된 회원이 없습니다.</span></b>
				</p>
			</td>
		</tr>
		<%
	}else{
	//for 반복문을 이용해 memberList의 저장된 MemberBean객체를 한 개씩 가져온 후
	//각 속성의 회원 정보를 다시 getter를 이용해 출력합니다.
	   for( int i = 0; i < membersList.size(); i++ ) {
	      MemberBean bean = (MemberBean) membersList.get(i);
	%>
		<tr align="center">
			<td><%=bean.getId() %></td>
			<td><%=bean.getPwd() %></td>
			<td><%=bean.getName() %></td>
			<td><%=bean.getEmail() %></td>
			<td><%=bean.getJoinDate() %></td>
		</tr>
		<%
	      } // end for
	
	} // end if
	%>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>