package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2_1")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
															//응답은 HttpServletResponse객체를 이용합니다.
		request.setCharacterEncoding("utf-8");//웹브라우저에서 전송된 데이터의 인코딩을 설정합니다.
		response.setContentType("text/html;charset=utf-8");//setContentType()을 이용해 응답할 데이터 종류가 HTML임을 설정합니다.
		PrintWriter out = response.getWriter();//HttpServletResponse 객체의 getWriter()를 이용해 출력스트림 PrintWriter객체를 받아 옵니다.
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		//브라우저로 출력할 데이터를 문자열로 연결해서 HTML태그로 만듭니다.
		String data = "<html>";
			data += "<body>";
			data += "아이디 : "+id;
			data += "<br>";
			data += "패스워드 : "+pw;
			data += "</html>";
			data += "</body>";
		out.print(data);//PrintWriter의 print()를 이용해 HTML 태그 문자열을 웹 브라우저로 출력합니다.
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
