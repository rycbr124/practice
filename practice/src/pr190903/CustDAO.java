package pr190903;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;



public class CustDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public CustDAO() {
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
	
	public boolean overlappedID(String id){
		boolean result = false;
		try {
			con = dataFactory.getConnection();
			String query = "SELECT DECODE(count(*),1,'true','false') AS result FROM customers";
			query += " WHERE cust_id='"+id+"'";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result =Boolean.parseBoolean(rs.getString("result"));
			rs.close();
			this.pstmt.close();//prepared
			this.con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	boolean delCust(String cust_id) {
		boolean result = false;
		try {
			Connection con = this.dataFactory.getConnection();
			
			String query=" DELETE FROM customers";
			query+=" WHERE cust_id='"+cust_id+"'";
			
			System.out.println(query);
			this.pstmt=con.prepareStatement(query);
			this.pstmt.executeUpdate();//회원 정보를 테이블에 추가합니다.
			result=true;
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	boolean addCust(CustVO vo) {
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
	
	boolean chgCust(CustVO vo) {
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
			query+=" SET cust_name='"+cust_name+"'"
					+ " , cust_address='"+cust_address+"'"
					+ " , cust_state='"+cust_state+"'"
					+ " , cust_zip='"+cust_zip+"'"
					+ " , cust_country='"+cust_country+"'"
					+ " , cust_contact='"+cust_contact+"'"
					+ " , cust_email='"+cust_email+"'";
			query+=" WHERE cust_id='"+cust_id+"'";
			
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
	
	void listCountries(JSONArray countriesArray){
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query=" SELECT DISTINCT TRIM(cust_country)" 
					+" FROM customers" 
					+" WHERE cust_country IS NOT NULL"
					+" ORDER BY TRIM(cust_country) ASC";
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				countriesArray.add(rs.getString("TRIM(cust_country)"));
			}
			rs.close();
			this.pstmt.close();//prepared
			this.con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void listStates(JSONArray statesArray){
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query=" SELECT DISTINCT TRIM(cust_state)" 
					+" FROM customers" 
					+" WHERE cust_state IS NOT NULL"
					+" ORDER BY TRIM(cust_state) ASC";
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				statesArray.add(rs.getString("TRIM(cust_state)"));
			}
			rs.close();
			this.pstmt.close();//prepared
			this.con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	CustVO listCust(String cust_id){
		CustVO vo = new CustVO();
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query=" SELECT t.*"
					+" FROM("
					+" SELECT cust_id,TRIM(cust_name),TRIM(cust_address),TRIM(cust_city),TRIM(cust_state)," 
					+" TRIM(cust_zip),TRIM(cust_country),TRIM(cust_contact),TRIM(cust_email)," 
					+" LAG(cust_id, 1, cust_id) OVER (ORDER BY cust_id desc) AS before_value,"
					+" LEAD(cust_id, 1, cust_id) OVER (ORDER BY cust_id desc) AS after_value"
					+" FROM customers"
					+" ) t"
					+" WHERE cust_id='"+cust_id+"'";
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next()) {
				String cust_name=rs.getString("TRIM(cust_name)");
				String cust_address=rs.getString("TRIM(cust_address)");
				String cust_city=rs.getString("TRIM(cust_city)");
				String cust_state=rs.getString("TRIM(cust_state)");
				String cust_zip=rs.getString("TRIM(cust_zip)");
				String cust_country=rs.getString("TRIM(cust_country)");
				String cust_contact=rs.getString("TRIM(cust_contact)");
				String cust_email=rs.getString("TRIM(cust_email)");
				String before_value=rs.getString("before_value");
				String after_value=rs.getString("after_value");
				//각 컬럼 값을 다시 VO객체의 속성에 설정합니다.
				//순수한 컬럼명만 들어가야 한다.
				vo.setCust_name(cust_name);
				vo.setCust_address(cust_address);
				vo.setCust_city(cust_city);
				vo.setCust_state(cust_state);
				vo.setCust_zip(cust_zip);
				vo.setCust_country(cust_country);
				vo.setCust_contact(cust_contact);
				vo.setCust_email(cust_email);
				vo.setBefore_value(before_value);
				vo.setAfter_value(after_value);
				//설정된 객체를 다시 ArrayList에 저장합니다.
			}
			rs.close();
			this.pstmt.close();//prepared
			this.con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	
}
