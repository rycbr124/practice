<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import='java.util.*' 
    import='pr190813.CustomersVO' %>
<jsp:useBean id="m" class="pr190813.CustomersVO" scope="page"		/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객내역</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	String p_cust_id=(String) request.getParameter("p_cust_id");//html에서 넘어온 input값
	String command=(String) request.getAttribute("command");
	List list = (List) request.getAttribute("list");
	
	if(command!=null && command.equals("showCust")) {
	%>	
		<%
		if(list.isEmpty()){
		%>
			<h1>고객정보가 존재하지 않습니다.</h1>
		<% 
		}else{
		%>
			<table border=1><tr align='center' bgcolor='DodgerBlue'>
				<td>고객번호</td>
				<td>고객이름</td>
				<td>고객주소</td>
				<td>고객주</td>
				<td>고객우편번호</td>
				<td>고객국가</td>
				<td>고객담당자</td>
				<td>고객메일주소</td>
				<td>수정</td>
				
			<%
				for(int i=0; i<list.size();i++){
					CustomersVO vo = (CustomersVO) list.get(i);
					String cust_id=vo.getCust_id();
					String cust_name=vo.getCust_name();
					String cust_address=vo.getCust_address();
					String cust_state=vo.getCust_state();
					String cust_zip=vo.getCust_zip();
					String cust_country=vo.getCust_country();
					String cust_contact=vo.getCust_contact();
					String cust_email=vo.getCust_email();
					%>
					<tr>
						<td><%=cust_id %></td>
						<td><%=cust_name %></td>
						<td><%=cust_address%></td>
						<td><%=cust_state%></td>
						<td><%=cust_zip%></td>
						<td><%=cust_country %></td>
						<td><%=cust_contact %></td>
						<td><%=cust_email %></td>
						<td><a href='/pro13/practice/chgCustomers.jsp
						?command=chgCust
						&chg_id=<%=cust_id %>'>수정</a></td>
					</tr>
				<% 
				}
			%>
			</table>		
		<% 
		}
		%>
	<%
	}else {
		out.print("<h1>잘못된 접근입니다.</h1>");
		response.addHeader("Refresh", "1;url=/pro13/customers?command=showCust&p_cust_id="+p_cust_id);
	}
	
%>
	<a href='/pro13/practice/customer.html'>다시 조회하기</a>
</body>
</html>