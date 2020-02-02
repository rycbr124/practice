package sec03.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	

	public MemberDAO() {
		try {
			//JNDI에 접근하기 위해 기본경로 (java:/comp/env)를 지정합니다.
			Context ctx = new InitialContext();
			Context envContext=(Context) ctx.lookup("java:/comp/env");
			
			this.dataFactory=(DataSource) envContext.lookup("jdbc/oracle");
			//톰캣 context.xml에 설정한 name값인 jdbc/oracle을 이용해 톰캣이 미리 연결한 DataSource를 받아 옵니다.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<>();
		try {
//			connDB();//네 가지 정보로 데이터베이스를 연결합니다.
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query = "select * from t_member ";
			System.out.println("prepareStatement: "+query);//prepared
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {//조회한 레코드의 각 컬럼 값을 받아 옵니다.
				String id=rs.getString("id");
				String pwd=rs.getString("pwd");
				String name=rs.getString("name");
				String email=rs.getString("email");
				Date joinDate=rs.getDate("joinDate");
				//각 컬럼 값을 다시 MemberVO객체의 속성에 설정합니다.
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				//설정된 MemberVO객체를 다시 ArrayList에 저장합니다.
				list.add(vo);
			}
			rs.close();
			this.pstmt.close();//prepared
			this.con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;//조회한 레코드의 개수만큼 MemberVO객체를 저장한 ArrayList를 반환합니다.
	}

	public void addMember(MemberVO memberVO){
		try {
			//datasource를 이용해 데이터베이스와 연결합니다.
			Connection con = this.dataFactory.getConnection();
			
			//테이블에 저장할 회원 정보를 받아 옵니다.
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			//insert문을 문자열로 만듭니다.
			String query="INSERT INTO t_member";
			query+=" (id,pwd,name,email)";
			query+=" VALUES(?,?,?,?)";//sql파싱을 재사용,파싱하는값은 바뀌면 안됨,?로 고정
			
			System.out.println("prepareStatement: "+query);
			this.pstmt=con.prepareStatement(query);//순서대로 값을 바꿔줘야함
			
			//insert문의 각 ?에 순서대로 회원 정보를 세팅합니다.
			this.pstmt.setString(1, id);
			this.pstmt.setString(2, pwd);
			this.pstmt.setString(3, name);
			this.pstmt.setString(4, email);
			this.pstmt.executeUpdate();//회원 정보를 테이블에 추가합니다.
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void delMember(String id) {
		try {
			Connection con = this.dataFactory.getConnection();
			//delete문을 문자열로 만듭니다.
			String query = "DELETE FROM t_member"
					+" WHERE id=?";
			System.out.println("prepareStatement:"+query);
			this.pstmt=con.prepareStatement(query);
			this.pstmt.setString(1, id);//첫 번째 ?에 전달된 ID를 인자로 넣습니다.
			this.pstmt.executeUpdate();//delete문을 실행해 테이블에서 해당 ID의 회원 정보를 삭제합니다.
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean isExisted(MemberVO memberVO) {
		boolean result=false;
		String id=memberVO.getId();
		String pwd=memberVO.getPwd();
		try {
			con=dataFactory.getConnection();
			
			//오라클의 decode()함수를 이용해 조회하여 ID와 비밀번호가 테이블에 존재하면 true를, 존재하지 않으면 false를 조회합니다.
			String query ="SELECT DECODE(COUNT(*),1,'true','false') AS result FROM t_member";
			query+=" WHERE id=? AND pwd=?";
			
			//메서드로 전달된 ID와 비밀번호를 이용해 SQL문을 작성한 후 데이터베이스에 조회합니다.
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();//커서를 첫 번째 레코드로 위치시킵니다.
			result=Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result="+result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	
}
