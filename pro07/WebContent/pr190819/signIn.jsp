<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function fn_validate(){	
		var frmSign = document.frmSign;//<form> 태그의 name 속성으로 <form> 태그 객체를 받아 옵니다.
		//<form> 태그 내 <input> 태그의 name 속성으로 입력한 값을 받아 옵니다.
		var id = frmSign.id.value;
		
		if (id.length==0||id=="") {
			alert("ID를 입력해주세요.")
		}else{
			frmSign.method="post";//<form> 태그의 전송 방식을 post로 설정합니다.
			frmSign.action="signInResult.jsp";//action 속성을 서블릿 매핑 이름인 customer로 설정합니다.
			frmSign.submit();//자바스크립트에서 서블릿으로 전송합니다.
		}
	}
</script>
<title>로그인</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty vo}">
			<form name='frmSign' method='post' action='login' encType='UTF-8'>
			Id :<input type='text' name='id'><br>
			암호 :<input type='password' name='pwd'><br>
			<input type="button"  onClick='fn_validate()' value="로그인">
			<input type='hidden' name='command' value='in'   />	
			</form>
		</c:when>
	<c:otherwise>
		<c:redirect url="signInResult.jsp"	/>
	</c:otherwise>
	</c:choose>
</body>
</html>