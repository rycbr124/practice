<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import='java.util.*' 
    import='pr190809.OrderitemsVO' %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 정보 출력창</title>
</head>
<body>
<%	
	request.setCharacterEncoding("utf-8");
	String p_order_num=(String) request.getParameter("p_order_num");//html에서 넘어온 input값
	String command=(String) request.getAttribute("command");
	List list = (List) request.getAttribute("voList");
	
	if(list.isEmpty()){
	%>
		<h1>고객정보가 존재하지 않습니다.</h1>
	<% 
	}else{
	%>
		<table border=1><tr align='center' bgcolor='DodgerBlue'>
			<td>주문번호</td>
			<td>주문항목번호</td>
			<td>제품ID</td>
			<td>제품명</td>
			<td>항목수량</td>
			<td>항목가격</td>
			<td>수정</td>
			<td>삭제</td>
			
		<%
			for(int i=0; i<list.size();i++){
				OrderitemsVO vo = (OrderitemsVO) list.get(i);
				String order_num=vo.getOrder_num();
				String order_item=vo.getOrder_item();
				String prod_id=vo.getProd_id();
				String prod_name=vo.getProd_name();
				String quantity=vo.getQuantity();
				String item_price=vo.getItem_price();
				%>
				<tr>
					<td><%=order_num %></td>
					<td><%=order_item %></td>
					<td><%=prod_id %></td>
					<td><%=prod_name %></td>
					<td><%=quantity %></td>
					<td><%=item_price %></td>
					<td><a href='/pro07/chgOrderitems.jsp
					?command=chgOrder
					&chg_num=<%=order_num %>
					&chg_item=<%=order_item %>
					&p_order_num=<%=p_order_num%>'>수정</a></td><!-- 수정 후에는 전체 조회 -->
					<td><a href='/pro07/orderitems
					?command=delOrder
					&del_num=<%=order_num %>
					&del_item=<%=order_item %>
					&p_order_num=<%=p_order_num%>'>삭제</a></td>
				</tr>
			<% 
			}
		%>
		</table>
	<%
	}
%>
	<a href='/pro07/orderitems.html'>다시 조회하기</a>
</body>
</html>