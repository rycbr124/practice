package sec04;
//http://localhost:8090/pro06/gugu.html
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuguTest
 */
@WebServlet("/guguTest")
public class GuguTest extends HttpServlet {
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

	private void doGugu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan"));//전송된 dan의 값을 받아 옵니다.
		out.print(" <table border=1 width=800 align=center>");
		out.print("<tr align=center bgcolor='#FFFF66'>");
		out.print("<td colspan=4>"+dan+" 단 출력 </td>");
		out.print("</tr>");
		for(int i=1;i<10;i++) {//for문을 이용해 연속해서 결과를 테이블 행으로 출력합니다.
			if(i%2==0) {//if문을 이용해 행을 나타내는 <tr>태그에 대해 교대로 다른 배경색을 적용합니다.
				out.print("<tr align=center bgcolor='#ACFA58'>");
			}else {
				out.print("<tr align=center bgcolor='#81BEF7'>");
			}
			//각 행에 라디오 박스와 체크박스를 표시합니다.
			out.print("<td width=200>");
			out.print("<input type='radio' />"+i);
			out.print("</td>");
			out.print("<td width=200>");
			out.print("<input type='checkbox' />"+i);
			out.print("</td>");
			
			out.print("<td width=400>");
			out.print(dan+" * "+i);
			out.print("</td>");
			out.print("<td width=400>");
			out.print(i*dan);
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGugu(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGugu(request,response);

	}

}
