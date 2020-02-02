package pr190806;
//http://localhost:8090/pro07/cust.html
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CustServlet
 */
@WebServlet("/cust")
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		String user_id = request.getParameter("user_id");//like
		String command=request.getParameter("command");
		String preCust=request.getParameter("preCust");
		CustDAO dao = new CustDAO();//SQL문으로 조회할 customerDAO객체를 생성합니다.
		
//		System.out.println(command);//확인용
		out.print("<html><body>");		
		
		if(command!=null && command.equals("delCust")) {
			System.out.println(user_id);
			dao.delCust(user_id);
			if(preCust!=null) {
				user_id=preCust;
			}
		}

		List<CustVO> list = dao.listCust(user_id);//listCust()메서드로 회원 정보를 조회합니다.	
		if(list.isEmpty()) {
			out.print("고객정보가 존재하지 않습니다.");
		}else {
			out.print("<table border=1><tr align='center' bgcolor='DodgerBlue'>");
			out.print("<td>고객번호</td><td>고객명</td><td>주문번호</td><td>주문조회</td><td>삭제</td></tr>");
			for(int i=0; i<list.size();i++) {//조회한 회원 정보를 for문과 <tr>태그를 이용해 리스트로 출력합니다.
				CustVO customerVO = list.get(i);
				String cust_id=customerVO.getCust_id();
				String cust_name=customerVO.getCust_name();
				String cust_address=customerVO.getCust_address();
	
				out.print("<tr><td>"+cust_id+"</td><td>"+cust_name+"</td><td>"+cust_address+"</td>"
						+ "<td><a href='/pro07/cust2?command=showOrder&user_id="+cust_id+"'>주문조회</a></td>"
						+"<td><a href='/pro07/cust?command=delCust&user_id="+cust_id+"&preCust="+user_id+"'>삭제</a></td></tr>");
			}
			out.print("</table>");
		}
		
		out.print("</body></html>");
		out.print("<a href='/pro07/cust.html'>다시 조회하기</a>");
		
		
	}
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

}
