package pr190903;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/cust0903")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustDAO dao = new CustDAO();

	//조회메소드
	private void search(JSONObject totaObject,String p_cust_id) {
		///////////////////////states,countries list
		JSONArray states = new JSONArray();
		JSONArray countries = new JSONArray();
		dao.listStates(states);
		dao.listCountries(countries);
		totaObject.put("states", states);
		totaObject.put("countries", countries);
		/////////////////////////////
		
		//////////////////////////customer 정보
		JSONObject memberInfo = new JSONObject();	
		CustVO vo=dao.listCust(p_cust_id);
		memberInfo.put("cust_id", p_cust_id);
		memberInfo.put("cust_name", vo.getCust_name());
		memberInfo.put("cust_address", vo.getCust_address());
		memberInfo.put("cust_city", vo.getCust_city());
		memberInfo.put("cust_state", vo.getCust_state());
		memberInfo.put("cust_zip", vo.getCust_zip());
		memberInfo.put("cust_country", vo.getCust_country());
		memberInfo.put("cust_contact", vo.getCust_contact());
		memberInfo.put("cust_email", vo.getCust_email());
		
		totaObject.put("member", memberInfo);
	}
	
	private String before(String p_cust_id) {
		CustVO vo = dao.listCust(p_cust_id);
		return vo.getBefore_value();
	}
	
	private String after(String p_cust_id) {
		CustVO vo = dao.listCust(p_cust_id);
		return vo.getAfter_value();
	}
	
	//업데이트 메소드
	private boolean update(CustVO vo) {
		return dao.chgCust(vo);
	}
	
	//추가 메소드
	private boolean add(CustVO vo) {
		return dao.addCust(vo);

	}
	
	//삭제 메소드
	private boolean del(String cust_id) {
		return dao.delCust(cust_id);
	}
	
	private void errorPut(JSONArray errorsArray,JSONObject error,String message) {
		error.put("error_message", message);
		errorsArray.add(error);
	}
	
	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();

		JSONObject totaObject = new JSONObject();
		JSONArray errorsArray = new JSONArray();
		JSONObject error = new JSONObject();
		
		String p_cust_id = request.getParameter("p_cust_id");
		String command = request.getParameter("command");
		boolean overlappedID = dao.overlappedID(p_cust_id);//true면 존재하는 id

		if(command.equals("search")) {
			if(overlappedID) {
				search(totaObject,p_cust_id);
			}else {
				String message= "고객이 존재하지 않습니다.";
				errorPut(errorsArray,error,message);
			}
		}else if(command.equals("save")) {
			
			///////////input값 넣어주기
			CustVO vo = new CustVO();
			vo.setCust_id(p_cust_id);
			vo.setCust_name(request.getParameter("cust_name"));
			vo.setCust_address(request.getParameter("cust_address"));
			vo.setCust_state(request.getParameter("cust_state"));
			vo.setCust_zip(request.getParameter("cust_zip"));
			vo.setCust_country(request.getParameter("cust_country"));
			vo.setCust_contact(request.getParameter("cust_contact"));
			vo.setCust_email(request.getParameter("cust_email"));
			
			if(overlappedID) {//존재하는 id면 update 실행
				if( ! update(vo) ) {
					error=new JSONObject();
					String message= "업데이트에 실패했습니다.";
					errorPut(errorsArray,error,message);
				}
			}else {//없는 id면 insert 실행
				if( ! add(vo) ) {
					error=new JSONObject();
					String message= "추가에 실패했습니다.";
					errorPut(errorsArray,error,message);
				}
			}
			
		}else if(command.equals("del")) {
			if(! del(p_cust_id)) {
				error=new JSONObject();
				String message= "삭제에 실패했습니다.";
				errorPut(errorsArray,error,message);
			}
		}else if(command.equals("before") ){
			String c_cust_id=request.getParameter("cust_id");
			search(totaObject,before(c_cust_id));
		}else if(command.equals("after") ){
			String c_cust_id=request.getParameter("cust_id");	
			search(totaObject,after(c_cust_id));
		}
		
		System.out.println("넘어온 커맨드"+command);////////////////
		
		totaObject.put("errors", errorsArray);
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
