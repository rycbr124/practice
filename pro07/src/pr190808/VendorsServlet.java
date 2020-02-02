package pr190808;

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
 * Servlet implementation class VendorsServlet
 */
@WebServlet("/vendors")
public class VendorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String p_vend_id=request.getParameter("p_vend_id");
		String command=request.getParameter("command");
		VendorsDAO dao = new VendorsDAO();
		
		if(command!=null && command.equals("showVend")){
			if(p_vend_id==null) 
				p_vend_id="";
		}else if(command!=null && command.equals("delVend")){
			String del_vend=request.getParameter("del_vend");
			dao.delVend(del_vend);
		}else if(command!=null && command.equals("chgVend")) {
//			RequestDispatcher dispatch=request.getRequestDispatcher("chg_vendors");
//			dispatch.forward(request,response);
			
//			request.setAttribute("chg_vend", request.getParameter("chg_vend"));
			RequestDispatcher dispatch=request.getRequestDispatcher("chgVendors.jsp");
			dispatch.forward(request, response);
		}

		
		out.print("<html><body>");
		List<VendorsVO> list = dao.listVend(p_vend_id);//listCust()메서드로 회원 정보를 조회합니다.	
		if(list.isEmpty()) {
			out.print("고객정보가 존재하지 않습니다.");
		}else {
			out.print("<table border=1><tr align='center' bgcolor='DodgerBlue'>");
			out.print("<td>공급업체번호</td><td>공급업체이름</td><td>공급업체주소</td>"
					+ "<td>공급업체시</td><td>공급업체주</td><td>공급업체우편번호</td>"
					+ "<td>공급업체국가</td><td>수정</td><td>삭제</td></tr>");
			for(int i=0; i<list.size();i++) {//조회한 회원 정보를 for문과 <tr>태그를 이용해 리스트로 출력합니다.
				VendorsVO vo = list.get(i);
				String vend_id=vo.getVend_id();
				String vend_name=vo.getVend_name();
				String vend_address=vo.getVend_address();
				String vend_city=vo.getVend_city();
				String vend_state=vo.getVend_state();
				String vend_zip=vo.getVend_zip();
				String vend_country=vo.getVend_country();
	
				out.print("<tr><td>"+vend_id+"</td><td>"+vend_name+"</td><td>"+vend_address
						+"</td><td>"+vend_city+"</td><td>"+vend_state+"</td><td>"+vend_zip+"</td><td>"+vend_country+"</td>"
						+"<td><a href='/pro07/vendors?command=chgVend&chg_vend="+vend_id+"&p_vend_id="+p_vend_id+"'>수정</a></td>"
						+"<td><a href='/pro07/vendors?command=delVend&del_vend="+vend_id+"&p_vend_id="+p_vend_id+"'>삭제</a></td></tr>");
			}
			out.print("</table>");
		}
		out.print("</body></html>");
		out.print("<a href='/pro07/vendors.html'>다시 조회하기</a>");
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
