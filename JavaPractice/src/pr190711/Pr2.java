package pr190711;
/*
•실습2: 다음 클래스 설계

SpecialMember, Member
SpecialMember m = new SpecialMember(“홍길동”);
Member s = m;
s.getName(); // 홍길동
 * */

//테이블의 모델명과 관계가 있다.
class Member{
	String name;
	
//	public void getName() {
//		System.out.println(name);
//	}

	public Member(String name) {
		this.name=name;
	}

	public String getName(){
		return name;
	}
}

class SpecialMember extends Member{
//	String name;
//	
//	public SpecialMember(String name) {
//		this.name=name;
//	}
//	
//	public void getName() {
//		System.out.println(this.name);
//	}
	
	public SpecialMember(String name) {
//		super.name=name;
		super(name);
	}
	public String getName(){
		return name;
	}
}

public class Pr2 {

	public static void main(String[] args) {
		SpecialMember m = new SpecialMember("홍길동");
		Member s = m;
		s.getName(); // 홍길동
		System.out.println(s.getName());
	}

}
