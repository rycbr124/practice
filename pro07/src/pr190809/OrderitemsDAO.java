package pr190809;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderitemsDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public OrderitemsDAO() {
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
	
	List<OrderitemsVO> listOrderitems(String p_order_num) {
		List<OrderitemsVO> list = new ArrayList<>();
		try {
			this.con=dataFactory.getConnection();//DataSource를 이용해 데이터베이스에 연결합니다.
			String query="SELECT order_num,order_item,oi.prod_id,prod_name,quantity,item_price"+ 
					" FROM orderitems oi, products p" + 
					" WHERE oi.prod_id=p.prod_id"+
					" AND order_num LIKE '%"+p_order_num+"%'";
			System.out.println("prepareStatement: "+query);//prepared
			this.pstmt=this.con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String order_num=rs.getString("order_num");
				String order_item=rs.getString("order_item");
				String prod_id=rs.getString("prod_id");
				String prod_name=rs.getString("prod_name");
				String quantity=rs.getString("quantity");
				String item_price=rs.getString("item_price");
				
				//각 컬럼 값을 다시 VO객체의 속성에 설정합니다.
				//순수한 컬럼명만 들어가야 한다.
				OrderitemsVO vo = new OrderitemsVO();

				vo.setOrder_num(order_num);
				vo.setOrder_item(order_item);
				vo.setProd_id(prod_id);
				vo.setProd_name(prod_name);
				vo.setQuantity(quantity);
				vo.setItem_price(item_price);
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
	
	void delOrderitems(String del_num,String del_item) {
		try {
			Connection con = this.dataFactory.getConnection();//
			String query = "DELETE FROM orderitems"
					+" WHERE order_num='"+del_num+"'"
					+" AND order_item='"+del_item+"'";
			System.out.println("prepareStatement:"+query);
			this.pstmt=con.prepareStatement(query);
			this.pstmt.executeUpdate();//delete문을 실행해 테이블에서 해당 ID의 회원 정보를 삭제합니다.
			this.pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	private boolean isDupKey(String input_num, String input_item) {
//		boolean check=false;
//		try {
//			Connection con = this.dataFactory.getConnection();//
//			String query=" SELECT TRIM(order_num),TRIM(order_item)" + 
//					" FROM orderitems ";
//			this.pstmt=con.prepareStatement(query);
//			ResultSet rs=this.pstmt.executeQuery();
//			while(rs.next()) {
//				String p_order_num=rs.getString("TRIM(order_num)");
//				String p_order_item=rs.getString("TRIM(order_item)");
//				if(p_order_num.equals(input_num) && p_order_item.equals(input_item)) {
//					check=true;
//					break;
//				}
//			}
//			rs.close();
//			this.pstmt.close();//prepared
//			con.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return check;
//	}
	
	private boolean checkOrder(String input_num) {
		boolean check=false;
		try {
			this.con = this.dataFactory.getConnection();
			String query=" SELECT TRIM(order_num)" + 
					" FROM orders ";
			this.pstmt=con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String p_order_num=rs.getString("TRIM(order_num)");
				if(p_order_num.equals(input_num)) {
					check=true;
					break;
				}
			}
			rs.close();
			this.pstmt.close();//prepared
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	private boolean checkProd(String input_item) {
		boolean check=false;
		try {
			this.con = this.dataFactory.getConnection();
			String query=" SELECT TRIM(prod_id)" + 
					" FROM products ";
			this.pstmt=con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String p_prod_id=rs.getString("TRIM(prod_id)");
				if(p_prod_id.equals(input_item)) {
					check=true;
					break;
				}
			}
			rs.close();
			this.pstmt.close();//prepared
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	boolean chgOrderitems(String chg_num, String chg_item, OrderitemsVO vo) {
		boolean check=false;
		try {
			Connection con = this.dataFactory.getConnection();
			
			String order_num=vo.getOrder_num();
			String order_item=vo.getOrder_item();
			String prod_id=vo.getProd_id();
			String quantity=vo.getQuantity();
			String item_price=vo.getItem_price();

			if(checkOrder(order_num) && checkProd(prod_id)) {
				String query=" UPDATE orderitems";
				query+=" SET order_num ="+order_num
						+ " , order_item="+order_item
						+ " , prod_id='"+prod_id+"'"
						+ " , quantity="+quantity
						+ " , item_price="+item_price;
				query+=" WHERE order_num="+chg_num;
				query+=" AND order_item='"+chg_item+"' ";
				
				System.out.println(query);
				this.pstmt=con.prepareStatement(query);
				this.pstmt.executeUpdate();//회원 정보를 테이블에 추가합니다.
				this.pstmt.close();
				con.close();
				check=true;
			}else {
				System.out.println("존재하지 않는 외래키");
				check=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
}
