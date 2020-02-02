<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function fn_validate(){	
		var frmSign = document.frmSign;//<form> 태그의 name 속성으로 <form> 태그 객체를 받아 옵니다.
		//<form> 태그 내 <input> 태그의 name 속성으로 입력한 값을 받아 옵니다.
		var id = frmSign.id.value;
		var pwd = frmSign.pwd.value;
		var pwd2 = frmSign.pwd2.value;
		
		if (id.length==0||id=="") {
			alert("ID를 입력해주세요.")
		}else if (pwd != pwd2 ) {
			alert("암호와 확인값이 동일하지 않습니다.")			
		}else{
			frmSign.method="post";//<form> 태그의 전송 방식을 post로 설정합니다.
			frmSign.action="/pro07/addMember";//action 속성을 서블릿 매핑 이름인 customer로 설정합니다.
			frmSign.submit();//자바스크립트에서 서블릿으로 전송합니다.
		}
	}
</script>
<title>로그인</title>
</head>
<body>
	<form name='frmSign' method='post' action='login.jsp' encType='UTF-8'>
	Id :<input type='text' name='id'><br>
	이름 :<input type='text' name='name'><br>	
	암호 :<input type='password' name='pwd'><br>
	확인 :<input type='password' name='pwd2'><br>
	<input type='hidden' name='command' value='add'   />		
	<input type='button' onClick='fn_validate()' value='가입'	/>
	</form>
</body>
</html>