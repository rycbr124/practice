package pr190808;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class VendorsDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public VendorsDAO() {
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

	
	void chgVend(String chg_id,VendorsVO vo) {
		try {
			//datasource를 이용해 데이터베이스와 연결합니다.
			Connection con = this.dataFactory.getConnection();
			
			//테이블에 저장할 회원 정보를 받아 옵니다.
			String vend_id=vo.getVend_id();
			String vend_name=vo.getVend_name();
			String vend_address=vo.getVend_address();
			String vend_city=vo.getVend_city();
			String vend_state=vo.getVend_state();
			String vend_zip=vo.getVend_zip();
			String vend_country=vo.getVend_country();
			
			String query=" UPDATE vendors";
			query+=" SET vend_id ='"+vend_id+"'"
					+ " , vend_name='"+vend_name+"'"
					+ " , vend_address='"+vend_address+"'"
					+ " , vend_city='"+vend_city+"'"
					+ " , vend_state='"+vend_state+"'"
					+ " , vend_zip='"+vend_zip+"'"
					+ " , vend_country='"+vend_country+"'";
			query+=" WHERE vend_id='"+chg_id+"' ";
			
			System.out.println(query);
			this.pstmt=con.prepareStatement(query);
			this.pstmt.executeUpdate();//회원 정보를 테이블에 추가합니다.
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void delVend(String del_vend) {
		try {
			Connection con = this.dataFactory.getConnection();//
			String query = "DELETE FROM vendors"
					+" WHERE vend_id='"+del_vend+"'";
			System.out.println("prepareStatement:"+query);
			this.pstmt=con.prepareStatement(query);
			this.pstmt.executeUpdate();//delete문을 실행해 테이블에서 해당 ID의 회원 정보를 삭제합니다.
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	List<VendorsVO> listVend(String input_vend) {
		List<VendorsVO> list = new ArrayList<>();
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query="SELECT vend_id,vend_name,vend_address,vend_city,vend_state,vend_zip,vend_country"+ 
					" FROM vendors" + 
					" WHERE vend_id LIKE '%"+input_vend+"%'";
			System.out.println("prepareStatement: "+query);//prepared
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String vend_id=rs.getString("vend_id");
				String vend_name=rs.getString("vend_name");
				String vend_address=rs.getString("vend_address");
				String vend_city=rs.getString("vend_city");
				String vend_state=rs.getString("vend_state");
				String vend_zip=rs.getString("vend_zip");
				String vend_country=rs.getString("vend_country");
				
				//각 컬럼 값을 다시 VO객체의 속성에 설정합니다.
				//순수한 컬럼명만 들어가야 한다.
				VendorsVO vo = new VendorsVO();

				vo.setVend_id(vend_id);
				vo.setVend_name(vend_name);
				vo.setVend_address(vend_address);
				vo.setVend_city(vend_city);
				vo.setVend_state(vend_state);
				vo.setVend_zip(vend_zip);
				vo.setVend_country(vend_country);
				//설정된 객체를 다시 ArrayList에 저장합니다.
				list.add(vo);
			}
			rs.close();
			this.pstmt.close();//prepared
			this.con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
