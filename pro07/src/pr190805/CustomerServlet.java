package pr190805;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		CustomerDAO dao = new CustomerDAO();//SQL문으로 조회할 customerDAO객체를 생성합니다.
		String user_id = request.getParameter("user_id");

		List<CustomerVO> list = dao.listCustomers(user_id);//listCustomer()메서드로 회원 정보를 조회합니다.
		
		out.print("<html><body>");
		
		if(list.isEmpty()) {
			out.print("고객정보가 존재하지 않습니다.");
		}else {
			out.print("<table border=1><tr align='center' bgcolor='DodgerBlue'>");
			out.print("<td>고객번호</td><td>고객명</td><td>주문번호</td><td>주문상품번호</td><td>주문상품명</td></tr>");
			for(int i=0; i<list.size();i++) {//조회한 회원 정보를 for문과 <tr>태그를 이용해 리스트로 출력합니다.
				CustomerVO customerVO = list.get(i);
				String cust_id=customerVO.getCust_id();
				String cust_name=customerVO.getCust_name();
				String order_num=customerVO.getOrder_num();
				String prod_id=customerVO.getProd_id();
				String prod_name=customerVO.getProd_name();
	
				out.print("<tr><td>"+cust_id+"</td><td>"+cust_name+"</td><td>"+order_num+"</td><td>"+prod_id+"</td><td>"+prod_name+"</td></tr>");
			}
			out.print("</table></body></html>");
		}
		
	}
	
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

}
