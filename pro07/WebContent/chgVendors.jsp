<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String command=request.getParameter("command");
	String chg_vend=(String)request.getParameter("chg_vend");
	if(command.equals("chgVend")){
		
	}else if(command.equals("chgResult")){
		
	}
%>
<title>공급업체수정</title>
</head>
<body>
	<form name='frmChg' method='post' action='vendors' encType='UTF-8'>
	공급업체번호 :<input type='text' name='vend_id'><br>
	공급업체이름 :<input type='text' name='vend_name'><br>
	공급업체주소 :<input type='text' name='vend_address'><br>
	공급업체시 :<input type='text' name='vend_city'><br>
	공급업체주 :<input type='text' name='vend_state'><br>
	공급업체우편번호 :<input type='text' name='vend_zip'><br>
	공급업체국가 :<input type='text' name='vend_country'><br>
	<input type='hidden' name='command' value='chgResult'>
	<input type='hidden' name='p_vend_id' value=''>
	<input type='hidden' name='chg_vend' value='<%=chg_vend %>'>
	<input type='button' onClick='fn_validate()' value='수정'	/>
	</form>
</body>
</html>