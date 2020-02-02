package pr190813;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CustomersDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public CustomersDAO() {
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
	
	boolean chgCust(String chg_id, CustomersVO vo) {
		boolean check=false;
		try {
			Connection con = this.dataFactory.getConnection();
			
			String cust_id=vo.getCust_id();
			String cust_name=vo.getCust_name();
			String cust_address=vo.getCust_address();
			String cust_state=vo.getCust_state();
			String cust_zip=vo.getCust_zip();
			String cust_country=vo.getCust_country();
			String cust_contact=vo.getCust_contact();
			String cust_email=vo.getCust_email();

			String query=" UPDATE customers";
			query+=" SET cust_id ='"+cust_id+"'"
					+ " , cust_name='"+cust_name+"'"
					+ " , cust_address='"+cust_address+"'"
					+ " , cust_state='"+cust_state+"'"
					+ " , cust_zip='"+cust_zip+"'"
					+ " , cust_country='"+cust_country+"'"
					+ " , cust_contact='"+cust_contact+"'"
					+ " , cust_email='"+cust_email+"'";
			query+=" WHERE cust_id="+chg_id;
			
			System.out.println(query);
			this.pstmt=con.prepareStatement(query);
			this.pstmt.executeUpdate();//회원 정보를 테이블에 추가합니다.
			check=true;
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	boolean addCust(CustomersVO vo) {
		boolean check=false;
		try {
			//datasource를 이용해 데이터베이스와 연결합니다.
			Connection con = this.dataFactory.getConnection();
			
			//테이블에 저장할 회원 정보를 받아 옵니다.
			
			String cust_id=vo.getCust_id();
			String cust_name=vo.getCust_name();
			String cust_address=vo.getCust_address();
			String cust_state=vo.getCust_state();
			String cust_zip=vo.getCust_zip();
			String cust_country=vo.getCust_country();
			String cust_contact=vo.getCust_contact();
			String cust_email=vo.getCust_email();
			
			
			String query="INSERT INTO customers"
					+ "(cust_id, cust_name, cust_address, cust_state, cust_zip, cust_country, cust_contact, cust_email)";
			query+=" VALUES(";
			query+="'"+cust_id+"'";
			query+=","+"'"+cust_name+"'";
			query+=","+"'"+cust_address+"'";
			query+=","+"'"+cust_state+"'";
			query+=","+"'"+cust_zip+"'";
			query+=","+"'"+cust_country+"'";
			query+=","+"'"+cust_contact+"'";
			query+=","+"'"+cust_email+"'";
			query+= ") ";
			
			System.out.println("prepareStatement: "+query);
			this.pstmt=con.prepareStatement(query);
			this.pstmt.executeUpdate();//회원 정보를 테이블에 추가합니다.
			check=true;
			this.pstmt.close();
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}	
		return check;
	}
	
	List<CustomersVO> listCust(String p_cust_id){
		List<CustomersVO> list = new ArrayList<>();
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query="SELECT cust_id,cust_name,cust_address,cust_state,cust_zip,cust_country,cust_contact,cust_email " + 
					" FROM customers"
					+" WHERE cust_id LIKE '%"+p_cust_id+"%'";
			System.out.println("prepareStatement: "+query);//prepared
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String cust_id=rs.getString("cust_id");
				String cust_name=rs.getString("cust_name");
				String cust_address=rs.getString("cust_address");
				String cust_state=rs.getString("cust_state");
				String cust_zip=rs.getString("cust_zip");
				String cust_country=rs.getString("cust_country");
				String cust_contact=rs.getString("cust_contact");
				String cust_email=rs.getString("cust_email");
				//각 컬럼 값을 다시 VO객체의 속성에 설정합니다.
				//순수한 컬럼명만 들어가야 한다.
				CustomersVO vo = new CustomersVO();

				vo.setCust_id(cust_id);
				vo.setCust_name(cust_name);
				vo.setCust_address(cust_address);
				vo.setCust_state(cust_state);
				vo.setCust_zip(cust_zip);
				vo.setCust_country(cust_country);
				vo.setCust_contact(cust_contact);
				vo.setCust_email(cust_email);
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
