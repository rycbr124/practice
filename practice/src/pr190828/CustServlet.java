package pr190828;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * Servlet implementation class CustServlet
 */
@WebServlet("/cust")
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String id = request.getParameter("p_cust_id");
		CustDAO dao = new CustDAO();
		boolean overlappedID = dao.overlappedID(id);
		
		JSONObject totaObject = new JSONObject();
		JSONObject memberInfo = new JSONObject();
		JSONArray states = new JSONArray();
		JSONArray countries = new JSONArray();
		
		dao.listStates(states);
		dao.listCountries(countries);
		totaObject.put("states", states);
		totaObject.put("countries", countries);
		
		memberInfo.put("check", String.valueOf(overlappedID) );
		if(overlappedID) {
			CustVO vo = new CustVO();
			vo=dao.listCust(id);
			memberInfo.put("cust_id", id);
			memberInfo.put("cust_name", vo.getCust_name());
			memberInfo.put("cust_address", vo.getCust_address());
			memberInfo.put("cust_city", vo.getCust_city());
			memberInfo.put("cust_state", vo.getCust_state());
			memberInfo.put("cust_zip", vo.getCust_zip());
			memberInfo.put("cust_country", vo.getCust_country());
			memberInfo.put("cust_contact", vo.getCust_contact());
			memberInfo.put("cust_email", vo.getCust_email());
		}
		
		totaObject.put("member", memberInfo);
		
		String jsonInfo = totaObject.toJSONString();
		writer.print(jsonInfo);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
