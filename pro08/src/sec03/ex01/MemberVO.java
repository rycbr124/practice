package sec03.ex01;

import java.sql.Date;

public class MemberVO {
	//t_member 테이블의 컬럼 이름과 동일한 자료형과 이름으로 속성들을 선언합니다.
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberVO() {
		System.out.println("MemberVO 생성자 호출");
	}

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	String getPwd() {
		return pwd;
	}

	void setPwd(String pwd) {
		this.pwd = pwd;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	Date getJoinDate() {
		return joinDate;
	}

	void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
