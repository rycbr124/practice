package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/login5")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//로그인창에서 전송된 ID와 비밀번호를 가져옵니다.
		String user_id=request.getParameter("user_id");
		String user_pwd=request.getParameter("user_pw");
		
		//memberVO객체를 생성하고 속성에 ID와 비밀번호를 설정합니다.
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);

		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.isExisted(memberVO);
		//사용자 존재 여부 check
		//memberDAO의 isExisted() 메서드를 호출하면서 memberVO를 전달합니다.
		
		if(result) {
			//사용자 존재하므로 세션에 사용자 정보 설정
			HttpSession session = request.getSession();
			//로그인 성공여부 설정
			session.setAttribute("isLogon", true);//로그인이 성공했다는 정보를 명시적으로 적어줌
			//조회한 결과가 true이면 isLogOn 속성을 true로 세션에 저장합니다.
			
			//조회한 결과가 true이면 ID와 비밀번호를 세션에 저장합니다. 
			session.setAttribute("login5.id", user_id);
			session.setAttribute("login5.pwd", user_pwd);
			
			out.print("<html><body>");
			out.print("안녕하세요 "+user_id+"님!!!<br>");
			out.print("<a href='show'>회원정보 보기</a>");
			out.print("</body></html>");
		}else {
			out.print("<html><body><center>회원 아이디가 틀립니다.");
			out.print("<a href='login5.html'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
