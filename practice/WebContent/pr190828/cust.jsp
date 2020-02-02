<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>고객정보조회</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		function fn_process(){
			var _id=$("#p_cust_id").val();
			if(_id==''){
				alert("ID를 입력하세요");
				return;
			}
			$.ajax({
				type : "post", 
				async : false,
				url : "${contextPath}/cust",
		       	dataType:"text",
		       	data: {p_cust_id : _id},
				success : function (data,textStatus){
					var jsonInfo = JSON.parse(data);
					var check=jsonInfo.member.check;
					
					if(check=='true'){
						$('#cust_id').text(jsonInfo.member.cust_id);     
						$('#cust_name').text(jsonInfo.member.cust_name);     
						$('#cust_address').text(jsonInfo.member.cust_address);     
						$('#cust_zip').text(jsonInfo.member.cust_zip);
						$('#cust_contact').text(jsonInfo.member.cust_contact);     
						$('#cust_email').text(jsonInfo.member.cust_email);     
						
						$("#states_cust").html("");
						for(var i in jsonInfo.states){
							if(jsonInfo.states[i]==jsonInfo.member.cust_city){
								$("#states_cust").prepend("<option value='"+jsonInfo.member.cust_city+"' selected='selected'>"+jsonInfo.member.cust_city+"</option>");
							}else{
								$("#states_cust").append("<option value='"+jsonInfo.states[i]+"'>"+jsonInfo.states[i]+"</option>");
							}
						}
						

						$("#countries_cust").html("");
						for(var i in jsonInfo.countries){
							if(jsonInfo.countries[i]==jsonInfo.member.cust_country){
								$("#countries_cust").prepend("<option value='"+jsonInfo.member.cust_country+"' selected='selected'>"+jsonInfo.member.cust_country+"</option>");
							}else{
								$("#countries_cust").append("<option value='"+jsonInfo.countries[i]+"'>"+jsonInfo.countries[i]+"</option>");
							}
						}
						
					}else{
						alert("고객이 존재하지 않습니다.");
						$('#cust_id').text("");     
						$('#cust_name').text("");     
						$('#cust_address').text("");     
						$('#cust_zip').text("");
						$('#cust_contact').text("");     
						$('#cust_email').text("");
						$("#states_cust").html("");
						$("#countries_cust").html("");
					}
				},
				error : function (data,textStatus){
					alert("에러가 발생했습니다.");
				}
			}); //end ajax
		}
	</script>
</head>
<body>
	<input type="text" id="p_cust_id" />
	<input type="button" id="btn_duplicate" value="조회" onClick="fn_process()" />
	<br>
	<br>
		
		<table border=1>
		<tr>
			<td>고객번호</td>
			<td><div id="cust_id"></div></td>
		</tr>
		<tr>
			<td>고객이름</td>
			<td><div id="cust_name"></div></td>
		</tr>
		<tr>
			<td>고객주소</td>
			<td><div id="cust_address"></div></td>
		</tr>
		<tr>
			<td>고객주</td>
			<td>
				<select name="states_cust" id="states_cust">
				</select>
			</td>
		</tr>
		<tr>
			<td>고객우편번호</td>
			<td><div id="cust_zip"></div></td>
		</tr>
		<tr>
			<td>고객국가</td>
			<td>
				<select name="countries_cust" id="countries_cust">
				</select>
			</td>
		</tr>
		<tr>
			<td>고객담당자</td>
			<td><div id="cust_contact"></div></td>
		</tr>
		<tr>
			<td>고객메일주소</td>
			<td><div id="cust_email"></div></td>			 
		</tr>
	</table>
</body>
</html>