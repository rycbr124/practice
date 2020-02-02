package bit190701;
import java.util.Scanner;

/*
 * 문제] 두 수를 입력 받아서 덧셈, 뺄셈, 곱셈, 나눗셈(몫),나눗셈(나머지)를 구현하는 프로그램을 작성해보자.
 	1.요구사항 파악: 덧셈, 뺄셈, 곱셈, 나눗셈(몫),나눗셈(나머지)
 	2.요구사항 분석: (생략)
 	3.요구사항 설계: (데이터 형식 정하기)int, int 입력 데이터, 변수명 정하기(first,second)
 	(메소드명):덧셈(Adder),뺄셈(Suber),곱셈(Multier),나눗셈 몫(DivierMok),나눗셈 나머지(DivierReer)
 	(클래스명): CalAdder,CalSuber,CalMultier,CalDivierMok,CalDivierReer,main:현 클래스명
 	(object):	add,		sub,	mul,		mok,			reer,		total
 	
 	//클래스명에 따라서 오브젝트명도 따라감
 */

class CalAdder {//public 붙이면 에러

	public int Adder(int first, int second) { //메소드의 parameter(매개변수),실인수
	//넘겨준 값이 int라서 출력값도 int로
		int sum=0 ;
		sum = first+second;
		return sum;
	}

}

class CalSuber {

	public void Suber(int first,int second) {
		int sum=0 ;
		sum = first-second;
		System.out.println("2.뺄셈의 결과는 = "+sum);
	}

}

class CalMultier {

	public int Multier() {
		int first,second, sum=0 ;
		Scanner sc = new Scanner(System.in);
		System.out.println("곱셈:");
		first=sc.nextInt();
		second=sc.nextInt();
		sum = first*second;
		return sum;
	}

}

class CalDivierMok {

	public void DivierMok() {
		int first,second, sum=0 ;
		Scanner sc = new Scanner(System.in);
		System.out.println("나눗셈(몫):");
		first=sc.nextInt();
		second=sc.nextInt();
		sum = first/second;
		System.out.println("4.나눗셈의 몫의 결과는 = "+sum);
		
	}

}

class CalDivierReer {

	public void DivierReer() {
		int first,second, sum=0 ;
		Scanner sc = new Scanner(System.in);
		System.out.println("나눗셈(나머지):");
		first=sc.nextInt();
		second=sc.nextInt();
		sum = first%second;
		System.out.println("5.나눗셈의 나머지의 결과는 = "+sum);
		
	}

}


public class MethodSample5_0628 {
	
	public static void main(String[] args) {
		int x,y;
		Scanner sc = new Scanner(System.in);
		//Import 단축키:ctrl+space bar
		System.out.println("덧셈:");
		x=sc.nextInt();//500
		y=sc.nextInt();//200
		
	//Adder(x,y)라는 값을 전달할 때,add라는 오브젝트는 CalAdder()라는 클래스에서 만들어진 객체이므로
	//CalAdder() 클래스에 접근하여 Adder(x,y)라는 메소드명을 찾아서 값을 전달해 줍니다.
		CalAdder add= new CalAdder();//전달인자(arguments),가인수
		float result1=add.Adder(x,y);//객체명.메소드명
		System.out.println("1.덧셈의 결과는 = "+result1);
	//값을 찾는 순서:1.메인 메소드 아래에서 2.public 클래스 아래에서,3.같은 객체 안에서?,4.패키지 안에서?
		
		System.out.println("뺄셈:");
		x=sc.nextInt();
		y=sc.nextInt();
		CalSuber sub= new CalSuber();
		sub.Suber(x,y);
		
		CalMultier mul= new CalMultier();
		int result3=mul.Multier();
		System.out.println("3.곱셈의 결과는 = "+result3);
		
		CalDivierMok mok= new CalDivierMok();
		mok.DivierMok();
		
		CalDivierReer reer= new CalDivierReer();
		reer.DivierReer();
		
		sc.close();
		
	/* 덧셈은 전달인자가 두 개 있고 리턴값은 있습니다. ------요구사항 파악------------- 
	 * 뺄셈은 전달인자가 두 개 있고 리턴값은 없습니다.
	 * 곱셈은 전달인자는 없고 리턴값은 있습니다.
	 * 나눗셈은 전달 인자가 없고,리턴값이 없습니다.
	 */
	}

}
