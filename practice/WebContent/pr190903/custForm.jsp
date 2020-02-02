<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
	table{
		border-collapse: collapse;
		border: 1px solid #f2f2f2; 
	}
	
	th, td {
  		padding: 8px;
  		
	}
	
	tr:nth-child(even){background-color: #f2f2f2}

	th {
	  background-color: #99ccff;
	  text-align: center;
	  color: white;
	  
	}
	
	.btn{
		border: 5px solid #99ccff; 
	  	background-color: white; 
	 	border-radius: 15px; 
	  	zoom: 1; 
	}
	
	.btn:hover { 
		  border: 5px solid #99ccff; 
		  background-color: #99ccff; 
		  zoom: 1; 
	} 
	
	#btn_before, #btn_after{
	    border: none;
	}
	#btn_before{
		background: url( "../image/before.jpg" ) no-repeat;
		background-size:contain;
	}
	#btn_after{
		background: url( "../image/after.jpg" ) no-repeat;
		background-size:contain;		
	}
</style>
<meta charset="UTF-8">
	<title>고객정보조회</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		function fn_reset(){
			$('#cust_id').val("");     
			$('#cust_name').val("");     
			$('#cust_address').val("");     
			$('#cust_zip').val("");
			$('#cust_contact').val("");     
			$('#cust_email').val("");
			$("#states_cust").html("");
			$("#countries_cust").html("");
		}
		
		function fn_process(p_command){
			// command 설정
		    $("#command").val(p_command);  	
			
			//validation check값
			var p_cust_id=$("#p_cust_id").val();
			var c_cust_id=$("#cust_id").val();
			var p_cust_name=$("#cust_name").val();

			// 추가 시 값 초기화 후 종료
		    if(p_command == 'add'){
		    	$('#frm')[0].reset();
		    	return;
		    }	    
		    
		    // 조회 시 validation
		    if(p_command == 'search' && p_cust_id == ''){
		    	alert("조회할 고객번호를 입력하세요");
		    	return;
		    }
		    
		    //삭제 시 validation
		    if(p_command == 'del' && (p_cust_id == '' )){
		       alert("삭제할 고객번호를 입력하세요.");
		       return;
		    }else if(p_command=='del' && (p_cust_id!=c_cust_id)){
		    	alert("조회 결과와 동일한 고객번호를 입력했을 시 삭제됩니다.");
		    	return;
		    }
		    
		    // 저장 시 validation
		    if(p_command == 'save' && (p_cust_id == '' || p_cust_name=='' )){
		       alert("저장시 아이디와 이름은 필수값입니다.");
		       return;
		    }

			var params = $("#frm").serialize();
			$.ajax({
				type : "post", 
				async : false,
				url : "${contextPath}/cust0903",
			    data: params,
			    dataType:'json',
				success : function (data,textStatus){
					var jsonInfo = data;									

					if(jsonInfo.errors==''){//에러가 없으면
						fn_reset();
						if(p_command =='search' || p_command=='before' || p_command=='after' ){
							$('#cust_id').val(jsonInfo.member.cust_id);     
							$('#cust_name').val(jsonInfo.member.cust_name);     
							$('#cust_address').val(jsonInfo.member.cust_address);  
							$('#cust_state').val(jsonInfo.member.cust_state);						
							$('#cust_zip').val(jsonInfo.member.cust_zip);
							$('#cust_country').val(jsonInfo.member.cust_country);
							$('#cust_contact').val(jsonInfo.member.cust_contact);     
							$('#cust_email').val(jsonInfo.member.cust_email);
							
							for(var i in jsonInfo.states){
								$("#states_cust").append("<option value='"+jsonInfo.states[i]+"'>"+jsonInfo.states[i]+"</option>");
							}
							
							for(var i in jsonInfo.countries){
								$("#countries_cust").append("<option value='"+jsonInfo.countries[i]+"'>"+jsonInfo.countries[i]+"</option>");
							}
							
						}else if(p_command =='save'){
							alert("저장되었습니다.");
						}else if(p_command =='del'){
							alert("삭제되었습니다.");
							$('#frm')[0].reset();
						}
					}else{//에러가 있으면
						for(var i in jsonInfo.errors){
							var message = jsonInfo.errors[i].error_message
							alert(message);
						}
						$('#frm')[0].reset();
					}//end if	
					
				},//end success
				error : function (data,textStatus){
					alert("에러가 발생했습니다.");
				}
			}); //end ajax
		}
	</script>
</head>
<body>
	<form name="frm" id="frm">
		<input type="text" id="p_cust_id" name="p_cust_id"/>
		<input type="hidden" name="command" id="command" />
		<input type="button" class="btn" id="btn_search" value="조회" onClick="fn_process('search')" />
		<input type="button" class="btn" id="btn_add" value="추가" onClick="fn_process('add')" />
		<input type="button" class="btn" id="btn_save" value="저장" onClick="fn_process('save')" />
		<input type="button" class="btn" id="btn_del" value="삭제" onClick="fn_process('del')" />
		<br>
		<br>
		<table>
			<tr>
				<th>
				<input type="button" id="btn_before" onClick="fn_process('before')" />
					고객번호
				<input type="button" id="btn_after" onClick="fn_process('after')" />
				</th>
				<td><input type="text"  name="cust_id"  id="cust_id"  readonly /></td>
			</tr>
			<tr>
				<th>고객이름</th>
				<td><input type="text"  name="cust_name" id="cust_name" maxlength="50" /></td>
			</tr>
			<tr>
				<th>고객주소</th>
				<td><input type="text"  name="cust_address" id="cust_address" maxlength="50" /></td>
			</tr>
			<tr>
				<th>고객주</th>
				<td>
					<input type="text" list="states_cust" name="cust_state" id="cust_state" maxlength="5">
					<datalist id="states_cust">
					</datalist>
				</td>
			</tr>
			<tr>
				<th>고객우편번호</th>
				<td><input type="text"  name="cust_zip" id="cust_zip" maxlength="10" /></td>
			</tr>
			<tr>
				<th>고객국가</th>
				<td>
					<input type="text" list="countries_cust" name="cust_country" id="cust_country">
					<datalist id="countries_cust">
					</datalist>
				</td>
			</tr>
			<tr>
				<th>고객담당자</th>
				<td><input type="text"  name="cust_contact" id="cust_contact" maxlength="50" /></td>
			</tr>
			<tr>
				<th>고객메일주소</th>
				<td><input type="text"  name="cust_email" id="cust_email" maxlength="255" /></td>			 
			</tr>
		</table>
	</form>
</body>
</html>