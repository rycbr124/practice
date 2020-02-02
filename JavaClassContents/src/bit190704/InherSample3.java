package bit190704;

import java.util.Scanner;

class Sawon {
	String name;
	String dep;
	int sal;
	int ep;

	Sawon(String name, String dep, int sal, int ep) {
		this.name=name;
		this.dep=dep;
		this.sal=sal;
		this.ep=ep;
	}
}

class Sales extends Sawon{

	private int sum=sal+ep;

	Sales(String name, String dep, int sal, int ep) {
		super(name,dep,sal,ep);
	
	}
	
	String Information() {
		return "이름:"+name+", 부서:"+dep+", 연봉:"+sal+", 수당:"+ep+", 합계:"+sum;
	}
	
	void Print() {
		System.out.println(Information());
	}
}


//이름과 부서 그리고 연봉, 수당을 입력받아서 연산하는 프로그램을 작성합니다.
public class InherSample3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		String name = sc.nextLine();
		System.out.println("부서를 입력하세요:");
		String dep = sc.nextLine();
		System.out.println("연봉을 입력하세요:");
		int sal = sc.nextInt();
		System.out.println("수당을 입력하세요:");
		int ep = sc.nextInt();
		
		Sales sales = new Sales(name,dep,sal,ep);
		sales.Print();
		
		

	}

}
