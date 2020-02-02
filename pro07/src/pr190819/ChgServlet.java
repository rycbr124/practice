package pr190819;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChgServlet
 */
@WebServlet("/chgMember")
public class ChgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String old_pwd=request.getParameter("old_pwd");
		String new_pwd=request.getParameter("new_pwd");
		String command=request.getParameter("command");
		MemberBean vo=(MemberBean) session.getAttribute("vo");

		if(command!=null && command.equals("chg")) {
			if(old_pwd.equals(vo.getPwd())) {
				MemberDAO dao = new MemberDAO();
				dao.chgPwd(vo.getId(),new_pwd);
				session.invalidate();
				response.sendRedirect("/pro07/pr190819/login.jsp");
			}else {
				out.println("<h1>비밀번호가 일치하지 않습니다.</h1>");
				out.println("<a href='/pro07/pr190819/chgPwd.jsp?command=chg'>돌아가기</a> ");
			}
			
		}
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
