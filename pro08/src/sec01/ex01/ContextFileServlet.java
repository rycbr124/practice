package sec01.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextFileServlet
 */
@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");//해당 위치의 파일을 읽어 들입니다.
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu=null;
		String menu_member=null;
		String menu_order=null;
		String menu_goods=null;
		
		//콤마를 구분자로 하여 메뉴 항목을 분리합니다.
		while((menu=buffer.readLine())!=null) {
			StringTokenizer tokens = new StringTokenizer(menu,",");
			menu_member=tokens.nextToken();
			menu_order=tokens.nextToken();
			menu_goods=tokens.nextToken();
		}
		
		out.println("<html><body>");
		out.print(menu_member+"<br>");
		out.print(menu_order+"<br>");
		out.print(menu_goods+"<br>");
		out.print("</body></html>");
	}

}
