import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HelloJava0625 {
	@SuppressWarnings("deprecation") //경고 deprecated : 앞으로 쓰지 말라는 뜻.
	public static void main(String[] args) throws IOException {
//		System.out.println("안녕하세요?"); //화면에 내용(안녕하세요?)을 출력합니다. 한 줄짜리 주석
//		System.out.println("HelloJava");
//		System.out.println("반갑습니다.");
		/*
		 * System : 클래스
		 * out : 객체
		 * println : 메소드
		 * ("안녕하세요?"): 매개변수 값
		 * ; : 문장의 끝
		 */
	
//		int x = 100; //정수형 데이터 100을 변수 x에 저장하시오.
//		int y = 300; //int x=100, y=300 z; z=x+y; 와 동일
//		int z = x+y; // 덧셈
//		System.out.println(z); //400
		/*
		 * int : 정수형 4바이트 메모라
		 * x : 변수
		 * = : 대입 연산자 (오른쪽의 연산의 결과를 왼쪽으로 저장하시오.)
		 * 100 : 실제적인 데이터
		 * ; : 문장의 끝
		 */
		
		/* 1.데이터 : 자료 => 정수형(소수점이 없는 수), 실수형(소수점이 있는 수), 문자(char(character) = 알파벳 한 문자(대문자/소문자)), 
		 * 문자열(String =>여러개의 문자로 구성), 특수기호(^,%,$,#,@,!,~,*,&,(,)) ,(파이썬의 경우 복소수형도 있음)
		 * 숫자와 문자
		 * 2.변수: x,y,z.....
		 * 3.자료형: byte(1),short(2),int(4),long(4),float(4),double(8),boolean(1bit)... 단위:byte
		 * 4.메모리: RAM(8GB) = 주소값(address) = 포인터
		 * 5.algorithm(알고리즘): 문제해결방법=>조건문, 반복문, 배열, 객체지향내용...\
		 * 6.사고력(국어) + 논리력(수학) = 문제해결능력
		 */
		
		 /*문제 풀이 방법(프로그래밍 5단계)
		  * 1.요구사항 파악 : 문제가 목적,의도하는 바를 알아내는 것.
		  * 2.요구사항 분석 : 인재,비용,메모리,데이터베이스 사양,서버 사양,주변상황... 
		  * 3.요구사항 설계 : 데이터,변수,자료형,형변화,객체지향 접근(클래스,인터페이스, ...)
		  * 구현 이전에 설계가 끝나야 한다!!(오버라이딩 등)
		  * 4.구현 : coding
		  * 5.테스트 : 정상적으로 동작하는지 확인!!! 	: SI(1~5)
		  * 6.배포 및 유지보수 : 60~70%가 수입원(회사) : SM
		  */
	//문제1]1000+5000=6000이 나오도록 프로그램을 작성하세요.
		//1.직접 데이터 입력 방법
//		int x = 1000, y = 5000;
//		int z = x+y;
//		System.out.println(z); //6000
//		
//		//2.키보드로부터 데이터 입력 방법
//		Scanner sc = new Scanner(System.in);
									//입력이니까 in. 출력은 out(ex System.out)
//		System.out.println("첫번째 숫자를 입력하세요.");
//		int x2 =sc.nextInt();
//		System.out.println("두번째 숫자를 입력하세요.");
//		int y2 =sc.nextInt();
//		
//		int z2 = x2+y2;
//		System.out.println("두 수의 합은 = "+z2);
//		sc.close();
		//자바는 데이터가 입력될 때, 대부분 문자로 인식됩니다.
		
		//3.키보드로부터 데이터 입력 방법2
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("첫 번째 숫자 입력 : ");
//		String x = br.readLine(); //"3000"
//		float xx = Float.parseFloat(x); //3000.0
//		System.out.println("두 번째 숫자 입력 : ");
//		String y = br.readLine(); //"6000"
//		float yy = Float.parseFloat(y); //6000.0
//		float zz = xx+yy;
//		System.out.println("연산의 결과는 = " + zz); //9000.0
		
	//문제2] first=250, second=450, third=550.0f, 합계를 구하여 출력해 봅니다.
//		int first=250; int second=450;
//		float third=550.000f; //f안하면 더블형
//		int sum =(int) ((first+second) +third);//정수형+실수형=>정수형
//				 //casting(강제적 형변환)
//		float sum2 = (first+second) + third;//정수형+실수형=>실수형
//		//묵시적형변환(자동형변환)
//		System.out.printf("%d \n",sum);
//		System.out.printf("%5.3f \n",sum2);
//		
		/*BufferedReader : 클래스.버퍼에 데이터를 모은다.(4~8kbyte),많은 데이터를 처리할 때 쓰면 유용함.	7(처리순서)
		 * br : object(객체)															6
		 * = : 대입연산자																5
		 * new : 메모리 할당 연산자														4
		 * BufferedReader : 클래스.객체의 생성(br),new를 이용해서								3
		 * (new InputStreamRearder : 1byte씩 입력받아라									2
		 * (Ststem.in)) : 키보드로부터 데이터를 입력합니다.										1차 스트림 클래스
		 * ;
		 * 
		 * BufferedReader클래스의 목적 : 성능의 향상을 위해서
		 */
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("첫 번째 숫자 입력 : ");
//		String w = br.readLine();  //readLine : 한 라인 전체를  읽어들여라,대량의 데이터를 받아들일 수 있다.
//		//객체명.메소드명 or 클래스명.클래스메소드명 공식,여기서는 1번
//		int ww = (int) Float.parseFloat(w);
//		float ww = Integer.parseInt(br.readLine()); //한 줄로 요약가능
//		
//		
//		System.out.println("두 번째 숫자 입력 : ");
//		String x = br.readLine(); 
//		int xx = (int) Float.parseFloat(x); 
//		
//		System.out.println("세 번째 숫자 입력 : ");
//		String y = br.readLine(); 
//		float yy = Integer.parseInt(y); 
//		
//		float zz = ww+xx+yy;
//		System.out.printf("연산의 결과는 = %.1ff %n", zz); //9000.0
//		//System.out.println("연산의 결과는 = " + zz); //같음
//		
//		
//		//출력하는 방법
//		//1.println:출력 후 줄바꿈 2.print:출력(줄 안바뀜)3.printf:c언어와 동일
//	//문제3] 키가 172.56cm입니다. 이 때, 키가 몇 피트 몇 인치인지 알아보세요.
//	//1inch = 2.54cm, 1feet=30.48cm=12inch
//		double heightCm = 172.56;
//		int feet = (int) (heightCm / 30.48);
//		System.out.println(feet);
//		int inch = (int) ((heightCm-(feet*30.48))/2.54) ;
//		System.out.println(inch);
//		System.out.println(feet+"피트 "+inch+"인치");
//		
//		double cm, inch, feet, feetsum, inchsum;
//		
//		cm=172.56;
//		inch=2.54;
//		
//		System.out.println(11.11%5.5);
//		
//		
//		feet=inch*12;
//		feetsum = cm/feet;
//		inchsum = (cm%feet)/inch;
//		System.out.println(feetsum + "몇 피트, " + inchsum + "인치 입니다.");
//		System.out.printf("cm는 %3.2f 피트이고, %3.2f 인치입니다.\n", feetsum,inchsum);
////==================================================================================
//	//문자데이터:char(문자),string(문자열)
////=========================================
//		
//		char name = 'h';
//		char x = 'y';
//		char y = 'e';
//		char z = 's';
//		
//		String sign = "yes";//call by reference(참조형)
//		
//		System.out.println(name + ","+sign);
//		System.out.printf("name = %c, sign = %s \n",name,sign);
//		
//		//한글 변수 사용 가능.
//		String 이름1="홍길동";
//		String 이름2="임꺽정";
//		String 이름3;
//		이름3 = 이름1+이름2; //연결연산자 기능 . + : 1.연결자 기능 2.덧셈 기능
//		System.out.println(이름3);
//		
//		//문자와 숫자와의 합산
//		String value = "홍길동";
//		String value2 = value+300;
//		System.out.println(value2);//홍길동300, 문자 +숫자=>문자.
//		
//		//대문자와 소문자로 변환
//		String str = "Java Programming";
//		String ss = str.toUpperCase(); //대문자로 변환
//		System.out.println(ss);//JAVA PROGRAMMING
//		
//		String sss = ss.toLowerCase(); //소문자로 변환
//		System.out.println(sss);//java programming
//		
	//문제] "It is not the time but the will that is wanting"이라는 문자열이 존재합니다.
	//내용 중에서 w라는 문자의 위치를 찾아서 출력하고, 문자열의 전체 길이가 얼마인지를 확인하세요.
	//hint> charAt();
	
	//index :     0123456789... 인덱스를 매겨준다.
//	String msg = "It is not the time but the will that is wanting"; //참조변수
//	int len = msg.length();//문자열의 길이
//	System.out.println(len);//47(0~46)
//	
//	for(int idx =0; idx < len; idx+=1) //반복문,+=:복합대입연산자,다른 부호도 가능 idx=idx+1
//	{
//		char ch = msg.charAt(idx);
//		
//	
//		if(ch=='t')
//		{
//			System.out.println("찾는 인덱스 위치는 = " + idx);//
//		}
//	}
//
	//indexOf():문자의 위치 찾기
//	String msg2 = "J a v a Program is Create Many Objects";
//	//index : 	   0123456789..........
//			
//	int idx1 = msg2.indexOf('a');//
//	System.out.println(idx1);//2
//	
//	int idx2 = msg2.indexOf('M');//
//	System.out.println(idx2);//26
//	
//	int idx3 = msg2.indexOf('a',15);//15번째 이후로 찾아라.
//	System.out.println(idx3);//22
//	
//	int idx4 = msg2.indexOf("is");
//	System.out.println(idx4);//16
//	
//	//substring(부분문자열 출력)
//	String msg3 = "J a v a Program is Create Many Objects";
//	//index : 	   0123456789.........
//
//	String str2 = msg3.substring(8,20); //8부터, 20이전(20 포함x)
//	System.out.println(str2);//Program is C
//	
//	String str3=msg3.substring(12); //12이후
//	System.out.println(str3);//ram is Create Many Objects
//	
//	//String 클래스: reference type, 무한대infinity 저장 가능.(메모리가 허락하는 한)
//	/*String
//	 * str4 : 오브젝트(=객체)
//	 * = : 대입연산자
//	 * new : 메모리 할당 연산자
//	 * String : 클래스
//	 * ("홍길동") : 매개변수데이터 값
//	 * ; : 문장의 끝
//	 */
//	
//	//equals() : 내용이 동일하면, 같은 주소번지를 부여합니다. (내용 비교)
//	//다른 객체여도 데이터 값이 같으면 true  데이터 값이 같다=번지값이 같다?=>메모리 절약갸능?
//	String str4 = new String("홍길동");
//	System.out.println(str4);
//	
//	String str5 = "홍길동"; //str4와 같은 뜻이다.
//	System.out.println(str5);
//
//	String str6 = "김길동"; //str4와 같은 뜻이다.
//	System.out.println(str6);
//	
//	String str7 = "홍길동"; //str4와 같은 뜻이다.
//	System.out.println(str7);
//	
//	System.out.println(str4.equals(str5));//true
//	System.out.println(str4.equals(str6));//false
//	System.out.println(str5.equals(str7));//true
//	
//	//== : 주소 비교
//	System.out.println(str5 == str7);//주소가 같은가? true
//	System.out.println(str5 == str6);//주소가 같은가?false
//	
//	//문제] str = "홍길동", str2 = "홍길동", str3="홍마차" 이렇게 존재합니다.
//	String strE = "홍길동"; 
//	String strE2 = "홍길동"; 
//	String strE3 = "홍마차";
//	
//	System.out.println(strE.equals(strE2));//true
//	System.out.println(strE2.equals(strE3));//false
//	
//	 strE = strE3;//strE="홍마차"
//
//	System.out.println(strE.equals(strE3)); //true
//	System.out.println(strE == strE3); //true
//
//		//Data class
//	
//		//1.Date class
//		Date currentDate = new Date(); //오브젝트는 new랑 붙어다닌다.
//	//class object		=		class
//		
//		System.out.println("현재 날짜는 = "+currentDate + "입니다.");//아메리칸 스타일 출력
//		
//		//보통 컴퓨터는 1970년 1월 1일이 기본 설정되어 있습니다.
//		System.out.println("년도: " + currentDate.getYear()); //deprecated : 앞으로 쓰지 말라는 뜻
//		System.out.println("월: " + currentDate.getMonth());
//		System.out.println("일: " + currentDate.getDay());
//		System.out.println("날짜: "+currentDate.getDate());//오늘 일자
//		
//		System.out.println(currentDate.toLocaleString());
//		
//		//2.Calendar class 요즘 방식
//		Calendar cal = Calendar.getInstance();
//		System.out.println(cal.get(Calendar.YEAR) + "년"); //2019년
//		System.out.println(cal.get(Calendar.MONTH)+1+"월");//6월, 음력때문에 +1
//		System.out.println(cal.get(Calendar.DATE)+"일");//24일
//	
//		System.out.println(cal.get(Calendar.HOUR)+"시");
//		System.out.println(cal.get(Calendar.MINUTE)+"분");
//		System.out.println(cal.get(Calendar.SECOND)+"초");
//		
//		//3.Unicode : 한국어,중국어,일본어...
//		//http://www.unicode.org/charts
//		//Hangul Syllables표 참조
//		
//		String str5="\uAC00";
//		String str6="\uB098";
//		System.out.println(str5 + str6);//가나
//		System.out.println(str6);//나
//		
//		//4.StringTokenizer class : 문자열을 구분자(delimiter)를 이용하여 구분합니다.
//		StringTokenizer st = new StringTokenizer("개구리, 소년, 왕눈이, 아로미, 투투" , "," );
//		//구분자가 없으면 ,까지 같이 출력된다.
//		System.out.println("문자열의 갯수는 = " + st.countTokens() + "개" );//5개
//		
//		while(st.hasMoreTokens()) //hasmoretokens=추출할 단어가 존재하면	
//		{
//			String data = st.nextToken();//순서대로 읽어오세요.
//			System.out.println(data);
//		}
//		
//		//문제]
//		StringTokenizer st2 = new StringTokenizer("개구리=소년; 왕눈이=아로미; 투투=가재", "= ;" );
//		while(st2.hasMoreTokens()) //hasmoretokens=추출할 단어가 존재하면
//		{
//			String data = st2.nextToken();
//			System.out.println(data);
//		}
//		

	
	}

}
//ctrl + F11:실행