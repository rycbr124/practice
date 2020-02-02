package pr190805;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
	private static final String driver= "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user ="scott";
	private static final String pwd = "tiger";
	private Connection con;
	private PreparedStatement pstmt;
	
	
	public List<CustomerVO> listCustomers(String number) {
		List<CustomerVO> list = new ArrayList<>();
		try {
			connDB();//네 가지 정보로 데이터베이스를 연결합니다.
			String query="SELECT c1.cust_id,cust_name,o1.order_num,oi1.prod_id,prod_name" + 
					" FROM customers c1,orders o1,orderitems oi1,products p1" + 
					" WHERE c1.cust_id=o1.cust_id(+)" + 
					" AND o1.order_num=oi1.order_num(+)" + 
					" AND oi1.prod_id=p1.prod_id(+)" +
					" AND c1.cust_id='"+number+"' ";
			//한 칸씩 띄워줘야 한다.(명령어 앞에 한 칸씩),세미콜론 찍으면안됨
			pstmt=con.prepareStatement(query);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {//조회한 레코드의 각 컬럼 값을 받아 옵니다.
				String cust_id=rs.getString("cust_id");
				String cust_name=rs.getString("cust_name");
				String order_num=rs.getString("order_num");
				String prod_id=rs.getString("prod_id");
				String prod_name=rs.getString("prod_name");
				//각 컬럼 값을 다시 VO객체의 속성에 설정합니다.
				//순수한 컬럼명만 들어가야 한다.
				CustomerVO vo = new CustomerVO();

				vo.setCust_id(cust_id);
				vo.setCust_name(cust_name);
				vo.setOrder_num(order_num);
				vo.setProd_id(prod_id);
				vo.setProd_name(prod_name);
				
				//설정된 CustomerVO객체를 다시 ArrayList에 저장합니다.
				list.add(vo);
			}
			rs.close();
			pstmt.close();//prepared
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection 생성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}	}

}
