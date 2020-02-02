

import java.util.Scanner;

class StarDot{
	int lineNum;
	
	public StarDot(int a) {
		this.lineNum=a;
	}
	
	void insideDot(int i) {
		for(int j=lineNum;j>i;j--)//공백
			System.out.print(" ");
		for(int k=1;k<(i*2);k++)//별
			System.out.print("*");
		System.out.println();
	}
	
	void printDot() {
		for(int i=1;i<=lineNum-1;i++)//상단부분출력
			insideDot(i);
		for(int i=lineNum;i>=1;i--)//하단부분출력
			insideDot(i);
	}
	
}

class Outside {
	int gstDiv2(int x,int y)
	{	
//		int result = 0;
//		for(int i=1;i<=x && i<=y;i++)
//		{
//			if(x%i==0 && y%i==0)
//				result=i;
//		}
//		return result;
		
		while(y!=0)
		{
			if(x<y)
			{	
				int c=x;
				x=y;
				y=c;
			}else
			{
				int c = x;
				x=y;
				y=c%y;
			}
		}
		return x;
	}
}

public class Pr190701 {
	
	int factorial(int x)//팩토리얼 x값 출력
	{
		if(x==1)
			return 1;
		else
			return x*factorial(x-1);
	}
//		int i=1,fac=1,x=0;
//		for(i=1;i<=x;i++)
//		{
//			fac=fac*i;
//			sum+=fac;
//			System.out.println(sum);
//		}
//		return sum;
	
	
	static int absValue(int x,int y)
	{	
//		if(x>=0)
//			return x;
//		else
//			return -x;
		if(x>y) return x-y;
		else return y-x;
	}
	
	static int gstDiv(int x,int y)
	{	int result = 0;
		for(int i=1;i<=x && i<=y;i++)
		{
			if(x%i==0 && y%i==0)
				result=i;
		}
		return result;
	}
	
	

	public static void main(String[] args) {
//	//과제1] 10!(팩토리얼)을 구하여 합계를 출력하세요. 단, 메소드 이용하여.
//	{
//		int x=10,sum=0;//최대 팩토리얼값,합계
//		Hw5 hw5= new Hw5();	
//		
//		for(int i=1;i<=x;i++)
//		{
//			sum+=hw5.factorial(i);
//		}
//		System.out.println("1!~"+x+"!의 합="+sum);
//	}
//		
//	//과제2] 두 수를 입력하여 절대값을 구하는 프로그램 작성. 단, 메소드 이용하여.
//	{
//		int a,b;
//		Scanner sc=new Scanner(System.in);
//		System.out.println("첫 번째 숫자를  입력해주세요:");
//		a=sc.nextInt();
//		System.out.println("두 번째 숫자를 입력해주세요:");
//		b=sc.nextInt();
//		
//		//System.out.println(a+"의 절대값은 "+absValue(a)+"이고,\n"+b+"의 절대값은 "+absValue(b)+"입니다.");
//		System.out.println(a+"와 "+b+"의 절대값은 "+absValue(a,b)+"입니다.");
//	}
//※C언어(C++)
//#include<studio.h> 전 처리기에 정의->자바로 따지면 클래스
//#include<st.dlibh>
//int void(main){int a=100,b=200; int sum=a+b; printf("합계는=%d \n",sum);}
//	
//	//과제3] 클래스와 객체와 메소드의 관계를 설명하세요.
//class : 객체를 생성하여 만들기 위한 기준(틀).
//object : 클래스에 생성한 인스턴스(= 참조변수,객체,reference)
//method : 기능, 동작, 행위
	/* 1.접근 제어자:해당 메소드에 접근할 수 있는 범위를 명시합니다.
	 *	종류:public,protected,default(생략),private
	 *	public:공개적인,누구나 접근이 가능하다. =>정보의 은닉성을 해칩니다.
	 *	protected:상속관계에 있는 객체는 접근이 가능하다.
	 *	default:같은 패키지로 된 프로그램에서 사용할 때 접근이 가능
	 * 	private:가장 좁은 범위의 접근을 허용한다.
	 * 	메인 메소드는 무조건 private로 시작한다.
	 * 2.반환 타입(return type):메소드가 모든 작업을 마치고 반환하는 데이터의 타입을 명시합니다.
	 * String, int, void, floa,double,Genefric ,<T>...
	 * 3.메소드 이름:메소드를 호출하기 위한 이름을 명시(행위)합니다.
	 * 4.매개변수 목록(parameters) : 메소드 호출 시에 전달되는 인수의 값을 저장할 변수들을 명시합니다.
	 * 5.구현부(Impl):메소드의 고유 기능을 수행하는 명령문의 집합입니다.
		다형성:같은 객체도 상태에 따라서 행동이 다르다.->ex)상속의 오버라이딩...
	 */
	//과제4] 두 수의 최대공약수를 구하여 출력하세요.(내부처리와 외부처리)
//	{	
//		Scanner sc=new Scanner(System.in);
//		System.out.println("첫 번째 숫자를  입력해주세요:");
//		int x=sc.nextInt();
//		System.out.println("두 번째 숫자를 입력해주세요:");
//		int y=sc.nextInt();
//		
//		System.out.println("1.내부처리:"+gstDiv(x,y));
//		Outside os= new Outside();
//		System.out.println("2.외부처리:"+os.gstDiv2(x, y));
//	}
//	
	//과제5] 메소드를 이용하여 다이아몬드 테이블을 만들어 출력하세요.
	//    *
	//   ***
	//  *****
	// *******
	//*********
	// *******
	//  *****
	//   ***
	//    *
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("출력할 줄 수를  입력해주세요:");
		int x=sc.nextInt();
		StarDot sd = new StarDot(x);
		sd.printDot();
	}
	
	
	}
}
