<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 
<script type="text/javascript">
	//개발자 소스 보기에 그대로 비밀번호 표시된다.
	function fn_validate(){	
		var frmChg = document.frmChg;//<form> 태그의 name 속성으로 <form> 태그 객체를 받아 옵니다.
		//<form> 태그 내 <input> 태그의 name 속성으로 입력한 값을 받아 옵니다.
		var old_pwd = frmChg.old_pwd.value;
		var pwd=${vo.pwd}
		
		if (old_pwd!=pwd) {
			alert("잘못된 암호입니다.")
		}else{
			frmChg.method="post";//<form> 태그의 전송 방식을 post로 설정합니다.
			frmChg.action="/pro07/chgMember";//action 속성을 서블릿 매핑 이름인 customer로 설정합니다.
			frmChg.submit();//자바스크립트에서 서블릿으로 전송합니다.
		}
	}
</script>
 -->
<title>비밀번호 변경</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty param.command && (param.command=='chg') }">
			<form name='frmChg' method='post' action='/pro07/chgMember' encType='UTF-8'>
			현재암호 :<input type='password' name='old_pwd'><br>
			새암호 :<input type='password' name='new_pwd'><br>
			<input type='hidden' name='command' value='chg'   />		
			<input type="submit"  value="암호변경">
			<!-- 
			<input type="button"  onClick='fn_validate()' value="암호변경">
			 -->
			</form>
		</c:when>
		<c:otherwise>
			<h1>잘못된 접근입니다.</h1>
			<a href='login.jsp	'>초기 화면으로 돌아가기</a> 
		</c:otherwise>
	</c:choose>
</body>
</html>