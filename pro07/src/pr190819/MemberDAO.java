package pr190819;

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
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	boolean chgPwd(String chg_id, String new_pwd) {
		boolean check=false;
		try {
			Connection con = this.dataFactory.getConnection();
			String query=" UPDATE t_member";
			query+=" SET pwd ='"+new_pwd+"'";
			query+=" WHERE id='"+chg_id+"'";
			
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
	
	public List<MemberBean> listMembers() {
		List<MemberBean> list = new ArrayList<>();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc ";
			//회원 정보를 최근 가입일 순으로 조회합니다.
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberBean vo = new MemberBean();//조회한 회원 정보를 vo 객체에 저장 후 list에 저장
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberBean listMember(String input_id) {
		MemberBean vo = new MemberBean();
		try {
			con = dataFactory.getConnection();
			String query = "SELECT * from t_member ";
			query+= " WHERE id='"+input_id+"'";
			//회원 정보를 최근 가입일 순으로 조회합니다.
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public boolean checkLogIn(String input_id,String input_pwd) {
		boolean check=false;
		try {
			this.con = this.dataFactory.getConnection();
			String query=" SELECT TRIM(id),TRIM(pwd)" + 
					" FROM t_member ";
			this.pstmt=con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String id=rs.getString("TRIM(id)");
				String pwd=rs.getString("TRIM(pwd)");
				if(id.equals(input_id) && pwd.equals(input_pwd)) {
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
	
	private boolean checkID(String input_id) {
		boolean check=false;
		try {
			this.con = this.dataFactory.getConnection();
			String query=" SELECT TRIM(id)" + 
					" FROM t_member ";
			this.pstmt=con.prepareStatement(query);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()) {
				String id=rs.getString("TRIM(id)");
				if(id.equals(input_id)) {
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
	
	public void addMember(MemberBean memberBean) {
		try {
			Connection con = this.dataFactory.getConnection();
			String id = memberBean.getId();
			String pwd = memberBean.getPwd();
			String name = memberBean.getName();
			String email = memberBean.getEmail();
			
			if(!checkID(id)) {
				String query = "insert into t_member";
				query += " (id,pwd,name,email)";
				query += " values(?,?,?,?)";
				System.out.println("prepareStatememt: " + query);
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.setString(3, name);
				pstmt.setString(4, email);
				pstmt.executeUpdate();
			}else {
				System.out.println("MemberDAO:존재하는 ID");
			}
			this.pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
