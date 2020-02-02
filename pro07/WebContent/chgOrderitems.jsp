<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function fn_validate(){	
		var frmChg = document.frmChg;
		var order_num=frmChg.order_num.value;
		var order_item=frmChg.order_item.value;
		var prod_id=frmChg.prod_id.value;
		var quantity=frmChg.quantity.value;
		var item_price=frmChg.item_price.value;
		
		if (order_num.length==0||order_num=="") {
			alert("주문번호를 입력해주세요.")
		}else if (order_item.length==0||order_item=="") {
			alert("주문항목번호를 입력해주세요.")
		}else if (prod_id.length==0||prod_id=="") {
			alert("제품ID를 입력해주세요.")
		}else if (quantity.length==0||quantity=="") {
			alert("항목수량을 입력해주세요.")
		}else if (item_price.length==0||item_price=="") {
			alert("항목가격을 입력해주세요.")
		}else{
			frmChg.method="post";//<form> 태그의 전송 방식을 post로 설정합니다.
			frmChg.action="/pro07/chg_orderitems";//action 속성을 서블릿 매핑 이름인 cust로 설정합니다.
			frmChg.submit();//자바스크립트에서 서블릿으로 전송합니다.
		}
	}
</script>
<title>주문 정보 수정</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String command=request.getParameter("command");//정상적인 접근일 경우 chgOrder 
	String p_order_num=request.getParameter("p_order_num");//넘어온 검색 조건

	if(command!=null && command.equals("chgOrder")) {
		String chg_num=request.getParameter("chg_num");//넘어온 변경값 조건
		String chg_item=request.getParameter("chg_item");//넘어온 변경값 조건
		
		String trim_num=chg_num.trim();
		String trim_item=chg_item.trim();
	%>
		<form name='frmChg' method='post' action='/pro07/chg_orderitems' encType='UTF-8'>
		주문번호 :<input type='number' name='order_num' value='<%=trim_num %>'  readOnly><br>
		주문항목번호 :<input type='number' name='order_item' value='<%=trim_item %>'  readOnly><br>
		제품ID :<input type='text' name='prod_id'><br>
		항목수량 :<input type='number' name='quantity'><br>
		항목가격 :<input type='number' name='item_price'><br>
		<input type='hidden' name='command' value='chgResult'>
		<input type='hidden' name='p_order_num' value='<%=p_order_num %>'>
		<input type='hidden' name='chg_num' value='<%=chg_num %>'>
		<input type='hidden' name='chg_item' value='<%=chg_item %>'>
		<input type='button' onClick='fn_validate()' value='수정'	/>
		</form>
	<%		
	}else {
		out.print("<h1>잘못된 접근입니다.</h1>");
		response.addHeader("Refresh", "1;url=/pro07/orderitems?command=showOrder&p_order_num="+p_order_num);
	}
	
%>
</body>
</html>