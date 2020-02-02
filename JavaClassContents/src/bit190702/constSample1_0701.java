package bit190702;

import java.util.Scanner;

/* 생성자 메소드
 * 의미:클래스에서 데이터를 주입시에 주로 사용합니다.
 * 생성자는 상속이 되지 않습니다.
 * 클래스명과 이름이 반드시 동일해야 합니다.
 * 반환 타입이 없습니다. return문을 사용하지 않습니다.
 * 접근 제한자는 public 이거나 생략 가능합니다.
 * 그리고, 프로그래머가 생성자를 사용하지 않으면 JVM이 자동(기본생성자)으로 만들어 사용합니다.
 * 개발자가 작성한 생성자가 하나라도 존재하면, JVM은 기본 생성자를 만들지 않습니다.
 * 클래스에 전달되는 값을 클래스 변수에 초기화 할 목적으로 사용합니다.
 */

//문제] 두 개의 숫자를 입력받아서 생성자 메소드에 전달하고, 그 결과를 리턴받아 출력하는 프로그램을 작성합니다.

public class constSample1_0701 {
	static int sum;//클래스 변수는 자동으로 초기화된다. = 0; 300
	static int i;//100
	static int j;//200

	public constSample1_0701() {
		//default constructor
	}
	
	public static void printDisplay()
	{
		System.out.println("3.생성자를 이용한 초기화 연산값"+sum);
	}
		
	public constSample1_0701(int i, int j) {// 매개변수(오른쪽에 있는 i와 j)
		this.i=i;
		this.j=j;
		sum=i + j;//100+200=300이 클래스변수로 들어간다.
		//데이터값을 선언하면 costSample1의 지역변수가 된다.
		//초기화
	}
	

//	public static int Addsum() {
//		int sum=i+j;
//		return sum;//300
//	}

	public static void Addsum() {
		sum=i+j;
}
	
	public static void main(String[] args) {
	{
		System.out.println("두 숫자를 입력하세요.");
		Scanner sc=new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		constSample1_0701 cs1 = new constSample1_0701(x,y);
		
		
		Addsum();//연산
		System.out.println("2.생성자를 이용한 합의 결과는 = "+constSample1_0701.sum);
		printDisplay();
		
//		System.out.println("3.메소드이용 합계는 = "+Addsum());

//		System.out.println("두 숫자를 입력하세요.");
//		Scanner sc=new Scanner(System.in);
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		
//		int result = Addsum(x,y);
//		System.out.println("1.Method => "+result);
	}
		
	}


}
