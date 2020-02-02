package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest5
 */
@WebServlet("/login3")
public class SessionTest5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//로그인에서 전송된 ID와 비밀번호를 가져옵니다.
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		if(session.isNew()) {
			//최초 요청시 수행합니다.
			//로그인창에서 서블릿으로 요청했다면 ID가 null이 아니므로 세션에 ID를 바인딩합니다.
			if(user_id!=null) {
				session.setAttribute("user_id", user_id);
				String url=response.encodeURL("login3");//변수 url에 encodeURL()을 이용해 응답 시 미리 jsessionID를 저장합니다.
				out.println("<a href="+url+">로그인 상태 확인</a>");//로그인 상태 확인 클릭 시 jsessionID를 서블릿으로 다시 전송합니다.
			}else {
				out.print("<a href='login3.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}else {
			//재요청시 세션에서 ID를 가져와 이전에 로그인했는지 여부를 확인합니다.
			user_id=(String) session.getAttribute("user_id");
				if(user_id!=null && user_id.length()!=0) {
					out.print("안녕하세요 "+user_id+"님!!!");
			}else {
				out.print("<a href='login3.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
	}
	
	//http://localhost:8090/pro08/login3;jsessionid=1097EDFC6F6A81A34E755C36ED55C96F
	//->세션id가 주소에 붙여서 온다.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
