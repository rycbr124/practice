 package bit190701;
import java.util.Scanner;

// Method(함수=function): "자주,반복적으로" 특정 작업을 실행하기 위한 명령어들의 집합입니다.
// 명령어 : 조건문,반복문,배열,클래스,오브젝트 등을 말합니다.
// 종류 4가지
// 분류 기준
//	전달인자값 		리턴값(결과값의 리턴)
//--------------------------
//1.	O		O
//2.	O		X
//3.	X		O
//4.	X		X
//메소드는 모두 4가지 유형 안에 들어간다.
//메소드는 원형의 정의시에 아래의 세 가지로 나뉩니다.
//메소드 선언부,메소드 정의부,메소드 호출(실행)부
//선언부와 정의부는 하나로 묶어서 쓰기도 합니다.(따로 써도 됨)


public class MethodSample1_0628 {
//field Area : 클래스 변수(전역변수),클래스 메소드,생성자,메소드...
//프로그램 전체에 영향을 준다.
//C언어의 static과 전혀 다른 의미.
//(java)static이 없으면 다른 클래스에서 해당 메소드에 접근 불가능하다.
	
/* public : 공개적인(열린),누구든지(public,protected,private, default(생략)) 접근할 수 있다.
 * static : 공유하는(클래스, 메소드, 변수)
 * int : 반환하는 값의 데이터형이 정수다.
 * Adder : 메소드명
 * (int x,int y) : 매개변수 값(=parameter)
 * { : 메소드의 시작
 *   : 코딩부분
 * } : 메소드의 끝
 */
	public static int Adder1(int x,int y)//메소드 정의부(선언부 포함)
					//선언부,정의부:public부터 중괄호 전체 부분
	{
		int sum=x+y;//ex.500+300
		return sum;//800
		//아래의 add에게 값을 전달해준다.(int 형으로)
	}
	
	public static void Adder2(int x,int y)//메소드 정의부(선언부 포함)
				//void:return값이 없다. 때에 따라 생랴가능.
	{
		int sum=x+y;
		System.out.println("2번 스타일:"+sum); //800
	}
	
	public static int Adder3()
	{
		int x,y,sum;
	
		Scanner sc= new Scanner(System.in);
		System.out.print("정수형 값으로 두 수를 입력하세요.");
		x=sc.nextInt();//ex.500
		y=sc.nextInt();//ex.300
		sum = x+y;
		sc.close();
		return sum;
	}
	
	public static void Adder4()
	{
		int x,y,sum;
	
		Scanner sc= new Scanner(System.in);
		System.out.print("정수형 값으로 두 수를 입력하세요.");
		x=sc.nextInt();//ex.500
		y=sc.nextInt();//ex.300
		sum = x+y;
		sc.close();
		
		System.out.println("4번 스타일:"+sum);
	}
	

//메인 메소드 : 프로그램의 시작과 끝
	public static void main(String[] args) {
	//두 수를 입력 받아서, 덧셈을 하여 출력합니다.
	//1번 스타일.
	{
		int x,y;//지역 변수
		Scanner sc= new Scanner(System.in);
		System.out.print("정수형 값으로 두 수를 입력하세요.");
		x=sc.nextInt();//ex.500
		y=sc.nextInt();//ex.300
						//500,300
		int result = Adder1(x,y);//메소드 호출(실행)부
		//	800		Adder1(x,y): x,y=>전달인자 (argument)
		System.out.println("1번 스타일:"+result); //800
		sc.close();
	}
	//2번 스타일.
	{
		int x,y;//지역 변수
		Scanner sc= new Scanner(System.in);
		System.out.print("정수형 값으로 두 수를 입력하세요.");
		x=sc.nextInt();//ex.500
		y=sc.nextInt();//ex.300
						//500,300
		Adder2(x,y);//메소드 호출(실행)부
		sc.close();
	}	
	//3번 스타일.
		{
		int result = Adder3();
		System.out.println("3번 스타일:"+result);
		}			
	//4번 스타일.
		Adder4();

	}
}
