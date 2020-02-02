package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first_redirect")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setAttribute("address", "서울시 성북구");
		
		response.sendRedirect("second_redirect?name=aaa&age=30");
		
		//get방식으로도 넘길 수 있다("second?id=aaa")
		//sendRedirect 메서드를 이용해 웹 브라우저에게 다른 서블릿인 second로 재요청합니다.
		
		//redirect 이후에도 코드가 있으면 그대로 실행된다
		//∵리다이렉트 이후는 비워줘야 한다.
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

}
