<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import='java.util.*' 
    import='pr190813.CustomersVO' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객내역</title>
</head>
<body>
	<c:choose>
		<c:when test="${(not empty param.command) && param.command=='showCust' }">
			<c:choose>
			<c:when test="${empty list }">
				<h1>고객 정보가 존재하지 않습니다.</h1>
			</c:when>
			<c:otherwise>
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
				
				<%--foreach돌리기 --%>
				<c:forEach var="volist" items="${list}" >
					<c:url var="url"  value="practice/chgCustomers.jsp"  >
					<c:param  name="command" value="chgCust" />
					<c:param  name="chg_id" value="${volist.cust_id}" />
					</c:url>   		  
					<tr>
						<td>${volist.cust_id}</td>
						<td>${volist.cust_name}</td>
						<td>${volist.cust_address}</td>
						<td>${volist.cust_state}</td>
						<td>${volist.cust_zip}</td>
						<td>${volist.cust_country}</td>
						<td>${volist.cust_contact}</td>
						<td>${volist.cust_email}</td>
						<td><a href='${url}'>수정</a></td>
					</tr>
				</c:forEach>	
				</table>
			</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<h1>잘못된 접근입니다.</h1>
			<%-- 리다이렉트 해주기 --%>
		</c:otherwise>
	</c:choose>
	<a href='/pro13/practice/customer.html'>다시 조회하기</a> 
</body>
</html>