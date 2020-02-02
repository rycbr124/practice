package sec02;
//p313~

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		//<hidden> 태그로 전송된 값을 getParameter() 메서드를 이용해 가져옵니다.
		String user_address=request.getParameter("user_address");
		String user_email=request.getParameter("user_email");
		String user_hp=request.getParameter("user_hp");
		
		String data="안녕하세요!<br>로그인하셨습니다.<br><br>";
		data += "<html><body>";
		data += "아이디 : "+user_id;
		data += "<br>";
		data += "패스워드 : "+user_pw;
		data += "<br>";
		data += "주소 : "+user_address;
		data += "<br>";
		data += "email : "+user_email;
		data += "<br>";
		data += "휴대전화 : "+user_hp;
		data += "<br>";
		out.print(data);
		
		user_address=URLEncoder.encode(user_address,"utf-8");//get방식으로 한글을 전송하기 위해 인코딩합니다.
		out.print("<a href='/pro08/second?user_id="+user_id+"&user_pw="+user_pw+"&user_address="+user_address+"'>두 번째 서블릿으로 보내기</a>");
					//<a>태그를 이용해 링크 클릭 시 서블릿 /second로 다시 로그인 정보를 전송합니다.
		out.print("</body></html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
