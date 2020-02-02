package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	//더 이상 사용되지 않으므로 주석 처리합니다.
//	private static final String driver= "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String user ="scott";
//	private static final String pwd = "tiger";
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

	//DAO에서 데이터를 직접 연결하는 기능은 주석처리
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con=DriverManager.getConnection(url,user,pwd);
//			System.out.println("Connection 생성 성공");
////			stmt = con.createStatement();
////			System.out.println("Statement 생성 성공");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
