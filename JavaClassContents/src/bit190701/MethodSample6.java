package bit190701;

import java.util.Scanner;

/* Method OverLoading(메소드 오버로딩)
 * 의미 : 같은 이름의 메소드명으로 서로 다른 기능을 구현하고자 할 때 사용합니다.
 * 조건 > 
 * 1.이름은 반드시 같아야 합니다.
 * 2.자료형의 개수가 서로 다르거나 인자의 개수가 서로 달라야 합니다.
 */

	
class CalAddSum{
	int AddSum(int i) {
		if(i==1) 
			return 1;
		else
			return i + AddSum(i-1);
	}
}

public class MethodSample6 {
	//field area
	
	int AddSum(int i)
	{
//			int sum=0;
//			for(int i=1;i<=x;i++)
//				sum+=i;
//			System.out.println("1.1~"+x+"="+sum);
		if(i==1) 
			return 1;
		else
			return i + AddSum(i-1);
	}
	
	//1
	private static void Hello() {
		System.out.println("Hello");
	}
	//3
	static void Hello(int x){
		int i=1;
		System.out.println("=====\t인자가 1개\t=====");
		System.out.println(x+"단");
		for(;i<=9;i++)
		{
			System.out.println(x+"*"+i+"="+x*i);
		}
	}
	//4
	static void Hello(int x,int y){
		System.out.println("=====\t인자가 2개\t=====");
		for(int i=x;i<=y;i++)
		{
			System.out.println(i+"단");
			for(int j=1;j<=9;j++)
				System.out.println(i+"*"+j+"="+i*j);
		}
	}
	//5
	static void HAP(int x)
	{
		int sum=0;
		for(int i=1;i<=x;i++)
			sum+=i;
		System.out.println("6.1~"+x+"="+sum);
	}
	//6
	static int SUM(int x,int y)
	{
		int sum=0;
		for(int i=x;i<=y;i++)
			sum+=i;
		return sum;
	}
	
	private static void ReHi(int n) {	//n=5 n=4 n=3 n=2 n=1 n=0
		if(n==0) 						//n==5,n==4,n==3,n==2,n==1,n==0
			return;													//return
		System.out.println("HI"); 		//HI,HI,HI,HI,HI
		ReHi(n-1); 						//5-1,4-1,3-1,2-1,1-1

	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
	
	//문제1] "Hello"라는 문자열을 Hello()라는 메소드를 이용하여 출력해 보세요.
//		Hello();
//	//문제2] "Hello"라는 문자열을 HelloClass()라는 클래스의 Hello()메소드를 구현하여 출력해 보세요.
//		HelloClass hc = new HelloClass();
//		//메소드 오버로딩의 예
//		System.out.println("전달인자가 0개");
//		hc.Hello();//전달 인자가 0개
//		System.out.println("전달인자가 1개");
//		hc.Hello(5.0f);//전달 인자가 1개
//		System.out.println("전달인자가 2개");
//		hc.Hello(5,2);//전달 인자가 2개
//	//문제3] 3단을 가인수로 넘겨서 Hello메소드로 3단을 출력해 보세요.
//		Hello(3);
//	//문제4] 시작단과 끝단을 가인수로 넘겨서 Hello 메소드로 구구단을 출럭해 보세요.	
//		Hello(3,7);
//	//문제5] HAP(x)이라는 메소드를 이용하여 최대값을 입력받아 1~100 까지의 합계를 구하여 출력하세요.
//		Scanner sc= new Scanner(System.in);
//		System.out.println("덧셈을 할 숫자를 입력하세요:");
//		int x=sc.nextInt();
//		HAP(x);//1~x까지의 합계
//	//문제6] SUM()이라는 메소드를이용하여 시작값(1)과 끝값(100)이 주어지면 합계를 구하여 출력하세요.
//		int x=1;
//		int y=100;
//		System.out.println("7."+x+"~"+y+"="+SUM(x,y));
//		
//	//재귀호출(되부름)
//	//재귀메소드:메소드가 자신을 다시 호출하여 작업을 반복 수행하는 방식을 말합니다.
//	{	
//		System.out.println("숫자를 입력하세요:");
//		Scanner sc=new Scanner(System.in);
//		int x=sc.nextInt();
//		
//		System.out.println("재귀호출1.");
//		ReHi(x);
//		
//		HelloClass hc2 = new HelloClass();
//		System.out.println("재귀호출2.");
//		hc2.ReHi2(x);
//		sc.close();
//	}	
//	
	
	}
}



class HelloClass{
	void Hello() {
		System.out.println("first = Hello");
	}
	
	void Hello(float x) {
		for(int i=0;i<x;i++)
			System.out.println("second = "+i+"=> Hello");
	}
	
	void Hello(float x,float y) {
		float sum=0;
		sum=x + y;
		System.out.println("합계는 = "+(int) sum);
	}
	
	void ReHi2(int n) {	//n=5 n=4 n=3 n=2 n=1 n=0
		if(n==0) 						//n==5,n==4,n==3,n==2,n==1,n==0
			return;													//return
		System.out.println("HI"); 		//HI,HI,HI,HI,HI
		ReHi2(n-1); 						//5-1,4-1,3-1,2-1,1-1

	}
	
}
