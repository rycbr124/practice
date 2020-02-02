package pr190806;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




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
	
	List<CustVO> listCust(String number){
		List<CustVO> list = new ArrayList<>();
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query="SELECT cust_id,cust_name,cust_address" + 
					" FROM customers"
					+" WHERE cust_id LIKE '%"+number+"%'";
			System.out.println("prepareStatement: "+query);//prepared
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String cust_id=rs.getString("cust_id");
				String cust_name=rs.getString("cust_name");
				String cust_address=rs.getString("cust_address");
				//각 컬럼 값을 다시 VO객체의 속성에 설정합니다.
				//순수한 컬럼명만 들어가야 한다.
				CustVO vo = new CustVO();

				vo.setCust_id(cust_id);
				vo.setCust_name(cust_name);
				vo.setCust_address(cust_address);
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
	
	void delCust(String cust_id) {
		//orderitems 삭제
		List<CustVO> list = listOrder(cust_id);
		for(int i=0;i<list.size();i++) {
			CustVO custVO = list.get(i);
			String order_num=""+custVO.getOrder_num();
			String order_item=""+custVO.getOrder_item();
			if(!(order_num.equals("null"))) {
				delOrder(order_num,order_item);
			}
		}
		//orders 삭제
		List<CustVO> list2 = listOrder(cust_id);
		if(list2.get(0).getOrder_num()!=null) {
			delOrder(list2.get(0).getOrder_num(),list2.get(0).getOrder_item());
		}
		
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query="DELETE FROM customers"
					+" WHERE cust_id='"+cust_id+"'";
			System.out.println("prepareStatement:"+query);
			this.pstmt=con.prepareStatement(query);
			this.pstmt.executeUpdate();//delete문을 실행해 테이블에서 해당 ID의 회원 정보를 삭제합니다.
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	void delOrder(String order_num,String order_item) {
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			if(!(order_num.equals("null")) && !(order_item.equals("null")) ) {//order_num과 order_item 둘 다 null이 아니면
				String query1="DELETE FROM orderitems oi1" + 
						" WHERE EXISTS(" + 
						"  SELECT 'X'" + 
						"  FROM orders o1" + 
						"  WHERE o1.order_num=oi1.order_num" + 
						"  AND o1.order_num='"+order_num+"'" +
						"  AND order_item='"+order_item+"')";
				this.pstmt=con.prepareStatement(query1);
				this.pstmt.executeUpdate();
			}else if(!(order_num.equals("null")) && order_item.equals("null")) {//order_num은 있고 order_item이 null이면
				String query2="DELETE FROM orders o1" + 
						" WHERE o1.order_num='"+order_num+"'";
				this.pstmt=con.prepareStatement(query2);
				this.pstmt.executeUpdate();
			}
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	List<CustVO> listOrder(String user_id) {
		List<CustVO> list = new ArrayList<>();
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query="SELECT o1.order_num,order_item,prod_name,quantity,item_price" + 
					" FROM customers c1,orders o1,orderitems oi1,products p1" + 
					" WHERE c1.cust_id=o1.cust_id(+)" + 
					" AND o1.order_num=oi1.order_num(+)" + 
					" AND oi1.prod_id=p1.prod_id(+)" + 
					" AND c1.cust_id='"+user_id+"'";
			System.out.println("prepareStatement: "+query);//prepared
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String order_num=rs.getString("order_num");
				String prod_name=rs.getString("prod_name");
				String quantity=rs.getString("quantity");
				String item_price=rs.getString("item_price");
				String order_item=rs.getString("order_item");
				//순수한 컬럼명만 들어가야 한다.
				
				//각 컬럼 값을 다시 VO객체의 속성에 설정합니다.
				CustVO vo = new CustVO();

				vo.setOrder_num(order_num);
				vo.setProd_name(prod_name);
				vo.setQuantity(quantity);
				vo.setItem_price(item_price);
				vo.setOrder_item(order_item);
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
