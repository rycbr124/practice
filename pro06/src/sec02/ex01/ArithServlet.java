package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArithServlet
 */
@WebServlet("/arith")
public class ArithServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");//수행할 요청을 받아옵니다.
		String first = request.getParameter("first");
		String second = request.getParameter("second");
		String operator = request.getParameter("operator");
		
		if(command !=null && command.equals("calculate")) {
			//최초 요청시 command가 null이면 계산기 화면을 출력하고, command값이 calculate면 계산결과를 출력합니다.
			try {
				String result=calculate(Long.parseLong(first),Long.parseLong(second),operator);
				pw.print("<html><font size=10>계산결과</font><br>");
				pw.print("<html><font size=10>"+result+"</font><br>");
			}catch(Exception e) {
				pw.print("<p>잘못된 입력값입니다.</p>");
			}finally {
				pw.print("<a href='/pro06/arith.html'>사칙연산 계산기</a>");
			}
			return;
		}
		
	}

	private String calculate(long first, long second, String operator) {
		String result=null;
		if(operator.equals("plus")) {
			result=String.format("%d", first+second);
		}else if(operator.equals("minus")) {
			result=String.format("%d", first-second);
		}else if(operator.equals("multiple")) {
			result=String.format("%d", first*second);
		}else if(operator.equals("division")) {
			result=String.format("%d", first/second);
		}
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
