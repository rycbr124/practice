package week3.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx4 {

	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address ="http://192.168.0.16:8090/pro07/memberForm.html";
		String line="";
		
		try {
			url=new URL(address);
			
			input = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			//inputStream을 reader로 바꿔줌
			while((line=input.readLine())!=null) {
				System.out.println(line);
			}
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

/*
 * <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<script type="text/javascript">
function fn_sendMember(){
   var frmMember=document.frmMember;
   var id=frmMember.id.value;
   var pwd=frmMember.pwd.value;
   var name=frmMember.name.value;
   var email=frmMember.email.value;
   if(id.length==0 ||id==""){
      alert("아이디는 필수입니다.");
   }else if(pwd.length==0 ||pwd==""){
      alert("비밀번호는 필수입니다.");
   }
   else if(name.length==0 ||name==""){
      alert("이름은 필수입니다.");
   }else if(email.length==0 ||email==""){
      alert("이메일은 필수입니다.");
   }else{
      frmMember.method="post";
      frmMember.action="member3";
      frmMember.submit();
   } 
}
</script>
</head>
<body>
  <form name="frmMember">
  <table>
	   <th>회원 가입창</th>
	  <tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
	  </tr>
	  <tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd"></td>
	  </tr>
	  <tr>
		<td>이름</td>
		<td><input type="text" name="name"></td>
	  </tr>
	    <tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
	  </tr>
  </table>
   <input type="button" value="가입하기" onclick="fn_sendMember()">
   <input type="reset" value="다시입력">
   <input  type="hidden" name="command" value="addMember" />	
  </form>
 </body>
</html>
*/
