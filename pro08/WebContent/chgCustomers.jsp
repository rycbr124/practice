<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function fn_validate(form){
		var frmChg = document.frmChg;
		var cust_id=frmChg.cust_id.value;
		var cust_name=frmChg.cust_name.value;

		if (cust_id.length==0||cust_id=="") {
			alert("고객 번호를 입력해주세요.")
		}else if (cust_name.length==0||cust_name=="") {
			alert("고객이름을 입력해주세요.")
		}else{
			frmChg.method="post";//<form> 태그의 전송 방식을 post로 설정합니다.
			frmChg.action="chgCustomers2.jsp";//action 속성을 서블릿 매핑 이름인 cust로 설정합니다.
			frmChg.submit();//자바스크립트에서 서블릿으로 전송합니다.
		}
	}
</script>
<title>고객 정보 수정</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String command=request.getParameter("command");//정상적인 접근일 경우 chgOrder 
	
	%>
		<form name='frmChg' method='post' action='chgCustomers2.jsp' encType='UTF-8'>
	<%
	if(command!=null && command.equals("chgCust")) {
		String chg_id=request.getParameter("chg_id");//넘어온 변경값 조건
	%>	
		고객번호 :<input type='text' name='cust_id' value='<%=chg_id.trim() %>' ><br>
	<%
	}else if(command!=null && command.equals("addCust")) {		
	%>	
		고객번호 :<input type='text' name='cust_id' ><br>
	<% 
	}	
	%>
		고객이름 :<input type='text' name='cust_name'><br>
		고객주소 :<input type='text' name='cust_address'><br>
		고객주 :<input type='text' name='cust_state'><br>
		고객우편번호 :<input type='text' name='cust_zip'><br>
		고객국가 :<input type='text' name='cust_country'><br>
		고객담당자 :<input type='text' name='cust_contact'><br>
		고객메일주소 :<input type='text' name='cust_email'><br>
	<%
	if(command!=null && command.equals("chgCust")) {
		String chg_id=request.getParameter("chg_id");//넘어온 변경값 조건
	%>
		<input type='hidden' name='command' value='chgCust'>
		<input type='hidden' name='chg_id' value='<%=chg_id %>'>
		<input type='button' onClick='fn_validate()' value='수정'	/>
	<%
	}else if(command!=null && command.equals("addCust")) {		
	%>
		<input type='hidden' name='command' value='addCust'>
		<input type='button' onClick='fn_validate()' value='추가'	/>
	<% 
	}	
%>
		</form>
</body>
</html>