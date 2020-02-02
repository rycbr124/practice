package pr190712;
/*
•실습1: Mother에 대한 클래스
- 속성:(String)name, (int)age, (String)job, private(Child[])childs
- 생성자
  Mother(String name, int age)
  Mother(String name, int age, String job, Child[] childs)
- 메소드:
  void goToSchool(): ‘아이들과 학교가다’ 출력
  void callChild(): 아이들 수만큼 출력 =>‘아이이름’이지금 갑니다
  void setChild(Child[] c): 아이를 설정
Mother의 goToSchool, setChild후 callChild 를 호출해 보기

• Child에 대한 클래스
- 속성:(String)name, (int)age, String hobby
- 생성자
  Child(String name, int age)
  Child(String name, int age, String hobby)
- 메소드:
  void goToSchool(): ‘학교가다’ 출력
  void fight(Child c): ‘아이이름’과 싸웠습니다 출력
 * */
import java.util.Scanner;

class Mother{
	String name,job;
	int age;
	private Child[] childs;
	
	Mother(String name, int age){
		this.name=name;
		this.age=age;
	}
	Mother(String name,int age,String job,Child[] childs){
		this.name=name;
		this.age=age;
		this.job=job;
		this.childs=childs;
	}
	
	void goToSchool() {
		System.out.println(this.name+"이(가) 아이들과 학교에 갑니다.");
	}
	void callChild() {
		for(int i=0;i<childs.length;i++) {
			System.out.println(childs[i].name+"이(가) 지금 갑니다.");
		}
	}
	
	void setChild(Child[] c) {
		this.childs=c;
	}
	
}

class Child{
	String name,hobby;
	int age;
	
	Child(String name, int age){
		this.name=name;
		this.age=age;
	}
	Child(String name,int age,String hobby){
		this.name=name;
		this.age=age;
		this.hobby=hobby;
	}
	
	void goToSchool() {
		System.out.println(this.name+"이(가) 학교에 갑니다.");
	}
	
	void fight(Child c) {
		System.out.println(this.name+"과 싸웠습니다.");
	}
	
}
public class Pr1 {

	public static void main(String[] args) {
		String mName; int mAge;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("어머니의 이름을 입력해주세요:");
		mName = sc.nextLine();
		System.out.print("어머니의 나이를 입력해주세요:");
		mAge = sc.nextInt();
		sc.nextLine();
		Mother mother = new Mother(mName,mAge);
		
		System.out.print("아이의 총 명수를 입력해주세요:");
		Child[] cArray=new Child[sc.nextInt()];
		sc.nextLine();
		
		for(int i=0;i<cArray.length;i++) {
			System.out.print("자식의 이름을 입력해주세요:");
			String cName = sc.nextLine();
			System.out.print("자식의 나이를 입력해주세요:");
			int cAge = sc.nextInt();
			sc.nextLine();
			
			cArray[i]=new Child(cName,cAge);
			mother.setChild(cArray);				
		}
		
		System.out.println("\n===\t출력결과\t===");
		mother.goToSchool();
		mother.callChild();
	}

}
