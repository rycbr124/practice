package pr190809;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ChgOrderitemsServlet
 */
@WebServlet("/chg_orderitems")
public class ChgOrderitemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String command=request.getParameter("command");//정상적인 접근일 경우 chgResult
		String p_order_num=request.getParameter("p_order_num");//넘어온 검색 조건
		PrintWriter out = response.getWriter();
		OrderitemsDAO dao= new OrderitemsDAO();
		
		if(command!=null && command.equals("chgResult")) {
			String chg_num=request.getParameter("chg_num");//넘어온 변경값 조건
			String chg_item=request.getParameter("chg_item");//넘어온 변경값 조건
			String order_num=request.getParameter("order_num");
			String order_item=request.getParameter("order_item");
			String prod_id=request.getParameter("prod_id");
			String quantity=request.getParameter("quantity");
			String item_price=request.getParameter("item_price");

			OrderitemsVO vo = new OrderitemsVO();
			
			vo.setOrder_num(order_num);
			vo.setOrder_item(order_item);
			vo.setProd_id(prod_id);
			vo.setQuantity(quantity);
			vo.setItem_price(item_price);
			
			if( dao.chgOrderitems(chg_num,chg_item,vo) ) {
				response.sendRedirect("orderitems?p_order_num=");
			}else {
				out.print("<h1>수정에 실패했습니다.</h1>");
				response.addHeader("Refresh", "1;url=/pro07/orderitems?command=showOrder&p_order_num="+p_order_num);
			}
			
		}else {
			out.print("<h1>잘못된 접근입니다.</h1>");
			response.addHeader("Refresh", "1;url=/pro07/orderitems?command=showOrder&p_order_num="+p_order_num);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
