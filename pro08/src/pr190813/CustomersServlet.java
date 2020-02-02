package pr190813;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CustomersServlet
 */
@WebServlet("/customers")
public class CustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String command=request.getParameter("command");
		PrintWriter out = response.getWriter();
		CustomersDAO dao= new CustomersDAO();
		
		CustomersVO vo=new CustomersVO();
		vo=(CustomersVO) request.getAttribute("m");
//		String cust_id=request.getParameter("cust_id");
//		String cust_name=request.getParameter("cust_name");
//		String cust_address=request.getParameter("cust_address");
//		String cust_state=request.getParameter("cust_state");
//		String cust_zip=request.getParameter("cust_zip");
//		String cust_country=request.getParameter("cust_country");
//		String cust_contact=request.getParameter("cust_contact");
//		String cust_email=request.getParameter("cust_email");
//		
//		vo.setCust_id(cust_id);
//		vo.setCust_name(cust_name);
//		vo.setCust_address(cust_address);
//		vo.setCust_state(cust_state);
//		vo.setCust_zip(cust_zip);
//		vo.setCust_country(cust_country);
//		vo.setCust_contact(cust_contact);
//		vo.setCust_email(cust_email);
//		
		if(command!=null && command.equals("showCust")) {
			String p_cust_id=request.getParameter("p_cust_id");
			if(p_cust_id==null) 
				p_cust_id="";
			showCust(dao,p_cust_id,request,response);
		}else if(command!=null && command.equals("addCust")){
			dao.addCust(vo);
			showCust(dao,"",request,response);
		}else if(command!=null && command.equals("chgCust")) {
			String chg_id=request.getParameter("chg_id");				
			dao.chgCust(chg_id, vo);
			showCust(dao,"",request,response);
		}else {
			out.print("<h1>잘못된 접근입니다.</h1>");
			String p_cust_id=request.getParameter("p_cust_id");
			response.addHeader("Refresh", "1;url=/pro08/customers?command=showCust&p_cust_id="+p_cust_id);
		}
		
	}
	
	private void showCust(CustomersDAO dao,String p_cust_id,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CustomersVO> list = dao.listCust(p_cust_id);//listCust()메서드로 회원 정보를 조회합니다.	
		request.setAttribute("list", list);
		request.setAttribute("command", "showCust");
		RequestDispatcher dispatch=request.getRequestDispatcher("customers.jsp");
		dispatch.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
