package sec02.ex01;

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
@WebServlet("/second_redirect")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//redirect 되기 전과 다른 request
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String address=(String) request.getAttribute("address");

		String name=request.getParameter("name");
		String age=request.getParameter("age");
		System.out.println(name+age+address);
		
		out.println("<html><body>");
		out.println("secondRedirect를 이용한 redirect 실습입니다.");//브라우저로 출력합니다.
		out.println("</body></html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

}
