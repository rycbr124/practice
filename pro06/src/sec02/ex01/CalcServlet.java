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
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static float USD_RATE = 1124.70F;
	 private static float JPY_RATE = 10.113F;
	 private static float CNY_RATE = 163.30F;
	 private static float GBP_RATE = 1444.35F;
	 private static float EUR_RATE = 1295.97F;

       

//	/**
//	 * @see Servlet#init(ServletConfig)
//	 */
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Servlet#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");//수행할 요청을 받아옵니다.
		String won = request.getParameter("won");//변환할 원화를 받아 옵니다.
		String operator = request.getParameter("operator");//변환할 외화 종류를 받아 옵니다.
		
		if(command !=null && command.equals("calculate")) {
			//최초 요청시 command가 null이면 계산기 화면을 출력하고, command값이 calculate면 계산결과를 출력합니다.
			String result=calculate(Float.parseFloat(won),operator);
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<html><font size=10>"+result+"</font><br>");
			pw.print("<a href='/pro06/calc.html'>환율계산기</a>");
			return;
		}
	}
	
	//원화를 선택한 외화로 환산합니다.
	private static String calculate(float won,String operator) {
		
		String result=null;
		if(operator.equals("dollar")) {
			result=String.format("%.6f", won/USD_RATE);
		}else if(operator.equals("en")) {
			result=String.format("%.6f", won/JPY_RATE);
		}else if(operator.equals("wian")) {
			result=String.format("%.6f", won/CNY_RATE);
		}else if(operator.equals("pound")) {
			result=String.format("%.6f", won/GBP_RATE);
		}else if(operator.equals("euro")) {
			result=String.format("%.6f", won/EUR_RATE);
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
