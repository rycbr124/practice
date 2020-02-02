<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
								<%-- 위 디렉토리에 정의하지 않으면 에러 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custom tag : now</title>
</head>
<body>
	오늘은 <b><tf:now	/></b>입니다.
</body>
</html>