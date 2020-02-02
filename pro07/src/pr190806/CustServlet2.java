package pr190806;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustServlet2
 */
@WebServlet("/cust2")
public class CustServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		String user_id = request.getParameter("user_id");//like
		String command=request.getParameter("command");
		CustDAO dao = new CustDAO();//SQL문으로 조회할 customerDAO객체를 생성합니다.
		
		System.out.println(command);//확인용
		out.print("<html><body>");		

		if(command!=null && command.equals("delOrder")) {
			String order_num=request.getParameter("orderNum");
			String order_item=request.getParameter("order_item");
			dao.delOrder(order_num,order_item);
		}
		
		List<CustVO> list = dao.listOrder(user_id);//listCust()메서드로 회원 정보를 조회합니다.	
		if(list.isEmpty()) {
			out.print("고객정보가 존재하지 않습니다.");
		}else {
			out.print("<table border=1><tr align='center' bgcolor='DodgerBlue'>");
			out.print("<td>주문번호</td><td>제품명</td><td>항목수량</td><td>항목가격</td><td>삭제</td></tr>");
			for(int i=0; i<list.size();i++) {//조회한 회원 정보를 for문과 <tr>태그를 이용해 리스트로 출력합니다.
				CustVO customerVO = list.get(i);
				String order_num=customerVO.getOrder_num();
				String order_item=customerVO.getOrder_item();
				String prod_name=customerVO.getProd_name();
				String quantity=customerVO.getQuantity();
				String item_price=customerVO.getItem_price();
				
				out.print("<tr><td>"+order_num+"</td><td>"+prod_name+"</td><td>"+quantity+"</td><td>"+item_price+"</td>");
				if(order_num!=null) {
					out.print("<td><a href='/pro07/cust2?command=delOrder&user_id="+user_id+"&orderNum="+order_num+"&order_item="+order_item+"'>삭제</a></td>");
				}else {
					out.print("<td>주문내역없음</td>");
				}
				out.print("</tr>");
			}
			out.print("</table>");
		}
		
		out.print("</body></html>");
		out.print("<a href='/pro07/cust.html'>다시 조회하기</a>");
	}
	
	
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
