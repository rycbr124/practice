package sec02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//첫 번째 서블릿에서 전송한 로그인 정보를 가져옵니다.
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		String user_address=request.getParameter("user_address");
		
		out.println("<html><body>");
		if(user_id!=null &&user_id.length()!=0) {
			//첫 번째 서블릿의 ID정보를 이용해 로그인 상태를 유지합니다.
			out.println("이미 로그인 상태입니다!<br><br>");
			out.println("첫 번째 서블릿에서 넘겨준 아이디: "+user_id+"<br>");
			out.println("첫 번째 서블릿에서 넘겨준 비밀번호: "+user_pw+"<br>");
			out.println("첫 번째 서블릿에서 넘겨준 주소: "+user_address+"<br>");
			out.println("</body></html>");
		}else {
			//로그인 창을 거치지 않고 바로 요청한 경우에는 로그인창으로 다시 이동하도록 안내합니다.
			out.println("로그인 하지 않았습니다.<br><br>");
			out.println("다시 로그인하세요!!<br>");
			out.println("<a href='/pro08/login.html'>로그인창으로 이동하기</>");
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
