import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HelloJava0626 {

	public static void main(String[] args) throws IOException {
//		//명시적(강제적) 형변환
//		//1.묵시적 형변환(=자동 형변환)(문자+숫자=문자, 정수형+실수형=실수형, float+double=double)
//		float f = 3.14159267f;
//		System.out.println(f);
//		
//		int i =3000;
//		System.out.println(i);//3000
//		
//		float sum = f + i;
//		System.out.println(sum);//3003.1416 => 실수형
//		
//		//2.강제적 형변환(원하는 대로 임의적 변경) : 상황에 따른 형 변환이 필요합니다.
//		System.out.println((int)f);//3
//		System.out.println((float)i);//3000.0
//		
//		int sum2 = (int) f+i;
//		System.out.println(sum2);//3003
//	
//		//지수승:가장 큰 값이나 가장 작은 값을 표현, 오차 발생.
//		double e1 = 333.1415e-3;//0.3331415
//		double e2 = 15.123456e+7;//1.5123456E8  ∵결과값이 double형의 범위를 초과해서
//		double e3 = 1234567.123e-7;//0.1234567123
//		System.out.println(e1);
//		System.out.println(e2);
//		System.out.println(e3);
//		
//		//10진수,2진수,8진수,16진수
//		int x = 100;   //100진수
//		int y = 0100;  //8진수
//		int z = 0x100; //16진수
//		System.out.println(x);//100
//		System.out.println(y);//64
//		System.out.println(z);//256
//		
//		//근대 컴퓨터의 효시 : 중국 역학(주나라문왕/이분체계 0,1)=>라이프니츠 =>폰 노이만
//		//10진수: 사람 주로 사용
//		//2진수: 0,1 => 0000, 0001, 0010, 0011, 0100, 0101......(1,2,3,4,5,6...)
//		//8진수: 0,7 => 0~7,10~17,20~27,30~37...(0~7,8~15,16~23...)
//		//16진수:0~9,A,B,C,D,E,F(15),10~19,1A~1F,20~29,2A~2F...(16~25,26~31,32~41...)
//		//16진수의 형태를 주로 다룬다.
//		
//		
//		//100/2= 50/2= 25/2 = 12/2 = 6/2 =3/2 =1
//		//0		0		1		0	0		1	1
//		//1100100(2진수)
//		//1x2^6 + 1x2^5 + 1x2^2 = 64 + 32 + 4 = 100
//		
//		//8진수 = 2의 3승 (3bit)
//		//001 100 100
//		//  1   4   4 (8)
//		//16진수 = 2의4승(4bit)
//		//0110 0100
//		//	6	4	(16)
//		
//		//API 문서 보기
//		
//		//import java.lang.*; 생략이 가능하다.
//		System.gc();
//		
//		System.out.println(Byte.MIN_VALUE + "~" +Byte.MAX_VALUE); //byte 범위
//		System.out.println(Short.MIN_VALUE + "~" +Short.MAX_VALUE); //2byte -32768~32767
//		System.out.println(Integer.MIN_VALUE + "~" +Integer.MAX_VALUE); //-2147483648~2147483647
//		
//		//api 참고해서 주석달기?
//		//public class Button
//		//extends Component
//		//implements Accessible
//		//This class creates a labeled button. 
//		//The application can cause some action to happen when the button is pushed. 
//		//This image depicts three views of a "Quit" button
//		
//		//GUI 구현 (GUISample1)
		
		//데이터형(타입)
		//1.byte(1byte,2^7)
//		byte ba = 10;
//		byte bb = 20;
//		byte bc = (byte) (ba+bb); //형변환 없이 그냥 쓰면 오류남. ∵integer를 선호하기 때문에
//		int bc2 = ba+bb;
//		System.out.println(bc);
//		System.out.println("byte = "+bc2);
//		
//		//2.short(2byte,2^15)
//		short sa =10;
//		short sb =20;
//		short sc = (short) (sa+sb);//형변환 없이 그냥 쓰면 오류남. ∵integer를 선호하기 때문에
//		int sc2 =sa+sb;
//		System.out.println(sc);
//		System.out.println("short = "+sc2);
//		
//		//3.int(4byte,2^31)
//		int ia = 10;
//		int ib = 20;
//		int ic = ia+ib;
//		System.out.println("integer = "+ic);
//		
//		//4.long(4byte)
//		long la = 30L; //상수에 L 안 붙이면 int타입으로 인식한다.
//		long lb = 50l;
//		long lc = la+lb;
//		System.out.println("long = "+lc);
//		
//		//5.float(4byte)
//		float fa = 30.67f; //상수에 f 안 붙이면 double로 인식.
//		float fb = 45.12f;
//		float fc = fa+fb;
//		System.out.println("float = "+fc);
//		
//		//6.double(8byte,2^63)
//		double da = 12.0;
//		double db = 45.123;
//		double dc = da+db;
//		System.out.println("double = "+dc);
//		
	//문제] 이름과 나이를 입력받아서 출력하는 프로그램을 작성하세요.
//		//직접 입력할 때
//		String name = "홍길동";
//		int age = 123;
//		
//		//입력을 받을 때
//		Scanner scan = new Scanner(System.in);
//		System.out.println("나이를 입력하세요.");
//		int age = scan.nextInt();
//		//scan.nextLine(); //
//		System.out.println("이름을 입력하세요.");
//		String name = scan.next();
//		System.out.println("당신의 이름은 "+name+"이고, 나이는 "+age+"세 입니다.");
//		scan.close();
//		
//		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("이름을 입력하세요.");
//		String name = scan.readLine();
//		System.out.println("나이를 입력하세요.");
//		int age = Integer.parseInt(scan.readLine());
//		//int age = scan.read(); =>입력한 숫자가 아스키코드로 출력된다 
//		//∵bufferedReader는 string으로 입력받는다.
//		System.out.println("당신의 이름은 "+name+"이고, 나이는 "+age+"세 입니다.");
//		
//		//연산자:Operator
//		//1.산술 연산자(+,-,*,/(몫),%(나머지))
//		int x = 50, y = 30;
//		int z = x+y;
//		int z2 = x-y;
//		int z3 = x*y;
//		int z4 = x/y;
//		int z5 = x%y;
//		System.out.println(z);//80
//		System.out.println(z2);//20
//		System.out.println(z3);//1500
//		System.out.println(z4);//1
//		System.out.println(z5);//20
//	//문제1] 국어, 영어, 수학 점수를 입력 받아서, 합계와 평균을 구하세요.
//		//풀이
//		Scanner scan2 = new Scanner(System.in);
//		System.out.println("국어 점수를 입력하세요.");
//		int korean = scan2.nextInt();
//		System.out.println("영어 점수를 입력하세요.");
//		int english = scan2.nextInt();
//		System.out.println("수학 점수를 입력하세요.");
//		int math = scan2.nextInt();
//		
//		int sum=korean+english+math;
//		int avg=sum/3;
//		
//		System.out.println("합계는 "+sum+"점, 평균은 "+avg+"점 입니다.");
//		//해답
//		//4.args[](바로 실행x,run Configurations에서 입력값을 넣어줘야 한다.)
//		int kor, eng, mat, total;
//		double avr;
//		
//		kor = Integer.parseInt(args[0]);
//		eng = Integer.parseInt(args[1]);
//		mat = Integer.parseInt(args[2]);
//		
//		total = kor + eng + mat;
//		avr = total / 3.0;
//		System.out.println("합계는= "+ total + "평균은= " +avr);
//		
//		//2.관계 연산자 : 이항 연산,x<=y,x>y,x==y,x!=y : true/false
//		int x = 100, y=200;
//		boolean result = false;
//		
//		result = x<y && y>=x;
//		System.out.println(result); //참,참 t
//		result = x<y && y<300;
//		System.out.println(result); //참,참 t
//		result = x>y && y++>300;
//		System.out.println(result); //거짓,거짓 f 	
//		result = x<y && ++y>200;
//		System.out.println(result); //참,참 t		∵전위
//		result = x==y && y!=x;
//		System.out.println(result); //거짓,참 f
//
//		result = x<y || y>=x;
//		System.out.println(result); //t
//		result = x<y || y<300;
//		System.out.println(result); //t
//		result = x>y || y++>300;
//		System.out.println(result); //f
//		result = x<y || ++y>200;
//		System.out.println(result); //t
//		result = x==y || y!=x;
//		System.out.println(result); //t
//		
//		//3.논리 연산자
//		/*---------------------------------------
//		 * A B and or not    xor nand nor
//		 * -----------------------------------
//		 * 0 0  0	0 1->0	  0
//		 * 0 1		   0->1  1		1
//		 * 1 0				 1		1
//		 * 1 1				 0		0
//		 */
//		
//		//4.조건 연산자
//		//산술연산+대입연산=복합대입(단축연산자),실제 코딩에서는 함축적으로 한다.
//		//+=,-=,*=,/=,%=
//		int x =250;
//		int y =380;
//		int sum = x+y;
//		x+=y; //x = x+y
//		System.out.println(x);
//		System.out.println(sum);
//		x-=y; //x = x-y
//		System.out.println(x);
//		x*=y; //x = x*y
//		System.out.println(x);
//		x/=y; //x = x/y
//		System.out.println(x);
//		x=1500;
//		x%=2; //x = x%2
//		System.out.println(x);
//		
//		//5.복합대입 연산자.
//		//1증가(++), 1감소(--)
//		//유형:++x,x++,--x,x--,대입 후 연산 : x++ 연산 후 대입: --x
//		
//		int x = 0, y= 10, z=50, sum1, sum2;
//		
//		System.out.println(x++);//0
//		System.out.println(x);//1
//		System.out.println("===============");
//		System.out.println(x--);//1
//		System.out.println(x);//0
//		System.out.println("===============");
//		System.out.println(++x);//1
//		System.out.println(x);//1
//		
//		//		1+ 11  - 50(49 기억)
//		sum1 = x + ++y - z--;
//		System.out.println(sum1); //-38
//		//	-38(-37기억)-11
//		sum2 = sum1++ -y;
//		System.out.println(sum2); //-49
//		
//		z--; //49(다음번 호출부터 48)
//		System.out.println(z); //48
//
//	//문제] 
//		int a = 0, b=10, c=20, d=30, e=40, sum1=0, sum2=0;
//
//		b++;//11
//		
//		sum1 = c-- + --e - a++; 
//		System.out.println(sum1);//59
//		
//		System.out.println(a+","+b+","+c+","+d+","+e);//1,11,19,30,39
//		sum2 = sum1 - c + a;
//		System.out.println(sum2);//41
//		
//		System.out.println(a+","+b+","+c+","+d+","+e);//1,11,19,30,39
//		sum1 = c++ - a-- + b - --d;
//		System.out.println(sum1);//0
//		
//		System.out.println(a+","+b+","+c+","+d+","+e);//0,11,20,29,39
//		sum2 = --c + e++;
//		System.out.println(sum2);//58
//		
//		System.out.println(a+","+b+","+c+","+d+","+e);//0,11,19,29,40
//		sum2 = c + e;
//		System.out.println(sum2);//59
//		
//		//6.bit연산자(and,or,not,exor,nand,nor,<<,>>,>>>) 논리 연산자와 유사
//		//통신공학, 전자공학, 전기공학, 반도체 공학 등에서 임베디드 시스템으로 사용
//		int x = 20;
//		int y = 30;
//		int z = x & y;
//		System.out.println("and연산:"+z);//20
//		int z2 = x | y;
//		System.out.println("or연산:"+z2);//30
//		int z3 = x ^ y;
//		System.out.println("ExoR연산:"+z3);//10
//		int z4 = x << 3;
//		System.out.println("shift<<연산:"+z4);//160 1bit마다 x2의 값	
//		int z5 = y >> 3;
//		System.out.println("shift<<연산:"+z5);//160 1bit마다 /2	의 값
//		//x 20 => 128 64 32 16 8 4 2 1
//		//			0 0  0   1 0 1 0 0
//		//y 30 =>	0 0	 0	 1 1 1 1 0
//		//-------------------------------
//		//			0 0  0	 1 0 1 0 0 =16+4=20 and
//		//			0 0	 0	 1 1 1 1 0 =30		or
//		//			0 0  0	 0 1 0 1 0 =10		exor
//		//-----------------------------------
//		//		0	0 0  1	 0 1 0 0 0 =40 
//		//      0	0 1	 0	 1 0 0 0 0 =80
//		//		0   1 0  0	 0 0 0 0 0 =160		shift<<
//		//----------------------------------------
//		//y 30 =>	0 0	 0	 1 1 1 1 0
//		//			  0	 0	 0 1 1 1 1 1	=15
//		//				 0	 0 0 1 1 1 1 1	=7
//		//					 0 0 0 1 1 1 1	=3	shift>>
		
		//					20, 		-20 						=	 0
		//부호화 절대값:		00010100	00010100						00010100
		//1의 보수:					11101011						11101100
		//2의 보수							  +1						----------
		//							--------	1(carry는 버립니다.)	00000000 = 0
		//							11101100 (-20)
		
	}

}
