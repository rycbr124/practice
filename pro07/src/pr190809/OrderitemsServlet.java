package pr190809;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/orderitems")
public class OrderitemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String p_order_num=request.getParameter("p_order_num");
		String command=request.getParameter("command");
		OrderitemsDAO dao= new OrderitemsDAO();
		
		if(command!=null && command.equals("showOrder")) {
			if(p_order_num==null) 
				p_order_num="";
		}else if(command!=null && command.equals("delOrder")){
			String del_num=request.getParameter("del_num");//삭제할 주문번호 받아오기
			String del_item=request.getParameter("del_item");//삭제할 항목번호 받아오기
			dao.delOrderitems(del_num,del_item);
		}
		
		List<OrderitemsVO> list = dao.listOrderitems(p_order_num);//listCust()메서드로 회원 정보를 조회합니다.	
		request.setAttribute("voList", list);
		request.setAttribute("command", "showOrder");
		RequestDispatcher dispatch=request.getRequestDispatcher("orderitems.jsp");
		dispatch.forward(request, response);
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
