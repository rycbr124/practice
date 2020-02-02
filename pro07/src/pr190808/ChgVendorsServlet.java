package pr190808;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChgVendors
 */
@WebServlet("/chg_vendors")
public class ChgVendorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String p_vend_id=request.getParameter("p_vend_id");//넘어온 조회 조건
		String chg_vend=request.getParameter("chg_vend");//넘어온 변경값 조건
		String command=request.getParameter("command");
		VendorsDAO dao = new VendorsDAO();
		
		if(command!=null && command.equals("chgVend")) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset=\"UTF-8\">");
			out.println("<script type=\"text/javascript\">");
			out.println("	function fn_validate(){	");
			out.println("		var frmChg = document.frmChg;//<form> 태그의 name 속성으로 <form> 태그 객체를 받아 옵니다.");
			out.println("		var vend_id=frmChg.vend_id.value;");
			out.println("		var vend_name=frmChg.vend_name.value;");
			out.println("		if (vend_id.length==0||vend_id==\"\") {");
			out.println("			alert(\"공급업체번호를 입력해주세요.\")");
			out.println("		}else if (vend_name.length==0||vend_name==\"\") {");
			out.println("			alert(\"공급업체이름을 입력해주세요.\")");
			out.println("		}else{");
			out.println("			frmChg.method=\"post\";");
			out.println("			frmChg.action=\"chg_vendors\";");
			out.println("			frmChg.submit();");
			out.println("		}");
			out.println("	}");
			out.println("</script>");
			out.println("<title>공급업체수정</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("	<form name='frmChg' method='post' action='chg_vendors' encType='UTF-8'>");
			out.println("	공급업체번호 :<input type='text' name='vend_id'><br>");
			out.println("	공급업체이름 :<input type='text' name='vend_name'><br>");
			out.println("	공급업체주소 :<input type='text' name='vend_address'><br>");
			out.println("	공급업체시 :<input type='text' name='vend_city'><br>");
			out.println("	공급업체주 :<input type='text' name='vend_state'><br>");
			out.println("	공급업체우편번호 :<input type='text' name='vend_zip'><br>");
			out.println("	공급업체국가 :<input type='text' name='vend_country'><br>");
			out.println("	<input type='hidden' name='command' value='chgResult'>");
			out.println("	<input type='hidden' name='p_vend_id' value='"+p_vend_id+"'>");
			out.println("	<input type='hidden' name='chg_vend' value='"+chg_vend+"'>");
			out.println("	<input type='button' onClick='fn_validate()' value='수정'	/>");
			out.println("</form></body></html>");
		}else if(command!=null&&command.equals("chgResult")) {
			String vend_id=request.getParameter("vend_id");
			String vend_name=request.getParameter("vend_name");
			String vend_address=request.getParameter("vend_address");
			String vend_city=request.getParameter("vend_city");
			String vend_state=request.getParameter("vend_state");
			String vend_zip=request.getParameter("vend_zip");
			String vend_country=request.getParameter("vend_country");
			
			VendorsVO vo = new VendorsVO();
			
			vo.setVend_id(vend_id);
			vo.setVend_name(vend_name);
			vo.setVend_address(vend_address);
			vo.setVend_city(vend_city);
			vo.setVend_state(vend_state);
			vo.setVend_zip(vend_zip);
			vo.setVend_country(vend_country);
			
			dao.chgVend(chg_vend, vo);
			
			request.setAttribute("p_vend_id", "");
			request.setAttribute("command", "showVend");
			
			response.sendRedirect("vendors?p_vend_id=");
		}
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
