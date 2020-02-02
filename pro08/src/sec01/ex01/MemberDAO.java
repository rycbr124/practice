package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver= "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user ="scott";
	private static final String pwd = "tiger";
	private Connection con;
//	private Statement stmt;
	private PreparedStatement pstmt;

	
	public List listMembers(){
		List list = new ArrayList();
		try {
			connDB();//네 가지 정보로 데이터베이스를 연결합니다.
//			con=dataFactory.getConnection();//필요없는 구문,적지말자
			String query = "select * from t_member ";
			System.out.println("prepareStatement: "+query);//prepared
//			System.out.println(query);
//			ResultSet rs = stmt.executeQuery(query);//SQL문으로 회원 정보를 조회합니다.
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
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
//			stmt.close();
			pstmt.close();//prepared
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;//조회한 레코드의 개수만큼 MemberVO객체를 저장한 ArrayList를 반환합니다.
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection 생성 성공");
//			stmt = con.createStatement();
//			System.out.println("Statement 생성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
