<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하세요 쇼핑몰 중심 JSP 시작입니다!!
	<br>
	<!-- param 액션 태그를 이용해 duke_image.jsp로 이름과 파일 이름을 전달합니다. -->
	<jsp:include page="duke_image.jsp" flush="true">
		<jsp:param name="name"	value="듀크2"	/>
		<jsp:param name="imgName"	value="duke2.png"	/>
	</jsp:include>
</body>
</html>