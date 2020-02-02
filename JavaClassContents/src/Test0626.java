import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Test0626 {

	public static void main(String[] args) throws IOException {
//		int su = 12345;
//		
//		System.out.printf("\n%8d\n",su);
//		System.out.printf("\n%-8d\n",su);
//		System.out.printf("\n% 08d \n",su);
		
		//한 글자 입력 연습
//		int ken=0;
//		System.out.print("키보드로부터 문자 입력 요망: ");
//			char art = (char)System.in.read();
//				System.in.read();
//				System.in.read();
//				System.out.println("입력한 문자 : "+art);
//				
//			System.out.print("키보드로부터 입력 요망: ");
//			ken = System.in.read();
//			System.out.print("입력한 문자의 10진수는:"+ken);
//			
//			//0~9사이의 숫자 3개를 이용하여 합계를 구하는 프로그램을 작성하세요.
//			int a,b,c;
//				System.out.print("첫 번째 숫자를 입력하세요: ");
//				a = System.in.read()-48; //1.0의 아스키 코드값을 빼준다.
//				System.in.read();//엔터값 제거
//				System.in.read();//엔터가 2byte 값이라 2줄
//				
//				System.out.print("두 번째 숫자를 입력하세요: ");
//				b = System.in.read()-'0'; //2.0을 아스키 코드로 입력되게 해서 빼준다.
//				System.in.read();
//				System.in.read();
//				
//				System.out.print("세 번째 숫자를 입력하세요: ");
//				c = System.in.read()-48;
//				System.in.read();
//				System.in.read();
//				
//				int sum= a+b+c;
//				System.out.println("합계는 ="+sum);
//		System.out.println("새 줄(new line)\t\\n\t"+ '\n');
//		System.out.println("탭(tab)\t\\t\t"+ '\t');
//		System.out.println("백스페이스(Backspace)\t\\b\t"+'\b');
//		System.out.println("단일 인용부호(Single Quote)\t\\'\t"+'\'');
//		System.out.println("이중 인용부호(Double Quote)\t\\\"\t"+'\"');
//		System.out.println("백슬래시(Backslash)\t\\\\\t"+'\\');
//		System.out.println("널 문자(null)\t\\0\t" + '\0');
//		{
//			int d=10;
//			{
//				int c=20;
//				{
//					int b=30;
//					{
//						int a = 40;
//						
//						a=200;
//						b=1000;
//						c=2000;
//						d=50;
//						System.out.println("1: "+a+" "+b+" "+c+" "+d);
//					}//end a,바깥 블록에서 a 호출 시 오류.
//					System.out.println("2: "+b+" "+c+" "+d);
//				}//end b,바깥 블록에서 a,b 호출 시 오류.
//				System.out.println("3: "+c+" "+d);
//			}//end c,바깥 블록에서 a,b,c 호출 시 오류.
//			System.out.println("4: "+d);
//		}//end d,바깥 블록에서 a,b,c,d 호출 시 오류.
//		
//		int x = 300, y = 500, sum = x+y;
//		System.out.println(sum);
//		/* int : 정수형 데이터
//		 * sum = x 			+		 y
//		 *     operand	operator	operand
//		 *     (연산의 대상)	연산자	(연산의 대상)
//		 */
//		
//		//+ :덧셈, 연결연산자("nn" + "입니다.)
//		//- :뺄셈, 부호변환(-- : +, ...)
//		System.out.println("y^3 =" + (y*y*y)); //y의 3승표현
//		char c1 = 'A' + 1;
//		char c2 = 'A';
//		//char c3 = c2 + 1;    //컴파일 에러. 문자형과 숫자를 더할 수 없다.
//		int c3 =c2+1; //char : -128~127
//		System.out.println("c1: " + c1); 
//		System.out.println("c2: " + c2); 
//		System.out.println("c3: " + c3); //66
//		
//		//String userInput = "NaN"; 
//		String userInput = "12345";//문자열 숫자는 숫자로 변환해서 연산할 수 있다
//		double val = Double.valueOf( userInput );
//		double currentBalance = 10000.0;
//		currentBalance += val;
//		System.out.println(currentBalance); //22345.0
//		
//		String userInput = "NaN";
//		double val = Double.valueOf(userInput);
//		double currentBalance = 10000.0;
//		
//		if(Double.isNaN(val)) {
//		System.out.println("NaN이 입력되어 처리할 수 없음");
//		val = 0.0;
//		}//예외처리
//		
//		currentBalance += val;
//		System.out.println(currentBalance);
//		
//		//if문
//		int score = 93;
//		if(score>=90) {
//		System.out.println("점수가 90보다 큽니다.");
//		System.out.println("등급은 A 입니다.");
//		}
//		
//		if(score>=90) 
//			System.out.println("점수가 90보다 큽니다.");//1줄이면 중괄호 생략 가능
//				
//		if(score< 90)
//		{
//		System.out.println("점수가 90보다 작습니다.");
//		System.out.println("등급은 B 입니다.");
//		}
//		
//		//문제] 영어 점수를 입력하여 학점을 부여하는 프로그램을 작성하세요. 
//		Scanner scan =new Scanner(System.in);
//		System.out.print("영어 점수를 입력하세요 :");
//		int eng = scan.nextInt();
//		scan.nextLine();
//		while(eng<0||eng>100) 
//		{
//			System.out.println("잘못 입력하셨습니다.");
//			System.out.print("영어 접수를 입력하세요 :");
//			eng = scan.nextInt();
//			scan.nextLine();
//		}
//		if(eng>=90)//(eng<=100 && eng>=90)
//		{
//			System.out.println("점수가 90보다 큽니다.");
//			System.out.println("등급은 A입니다.");	
//		}if(eng>=80)//(eng<90 && eng>=80)
//		{
//			System.out.println("점수가 80보다 큽니다.");
//			System.out.println("등급은 B입니다.");
//		}else if(eng>=70)//(eng<80 && eng>=70)
//		{
//			System.out.println("점수가 70보다 큽니다.");
//			System.out.println("등급은 C입니다.");
//		}else if(eng>=60)//(eng<70 && eng>=60)
//		{
//			System.out.println("점수가 60보다 큽니다.");
//			System.out.println("등급은 D입니다.");
//		}else
//		{
//			System.out.println("점수가 60보다 작습니다.");
//			System.out.println("등급은 F입니다.");
//		}
//		scan.close();
//	//문제] 올해년도를 입력하여 짝수해인지,홀수해인지 판별하여 출력하세요.
//		Scanner scan2=new Scanner(System.in);
//		System.out.print("년도를 입력하세요:");
//		int year = scan2.nextInt();
//		scan2.nextLine();
//		if(year%2==0)
//			System.out.println(year+"년은 짝수해 입니다.");
//		if(year%2==1)
//			System.out.println(year+"년은 홀수해 입니다.");
//		scan2.close();
//	//문제] 홍길동의 수학 성적이 85점 입니다. 70점 이상이면 합격으로 하고, 아니면 불합격으로 처리하는 프로그램을 작성하세요.
//		//String name="홍길동";
//		//int mat = 85;
//		Scanner scan3=new Scanner(System.in);
//		System.out.print("이름을 입력하세요:");
//		String name=scan3.nextLine();
//		System.out.print("수학 점수를 입력하세요:");
//		int mat=scan3.nextInt();
//		scan3.nextLine();
//		//조건식 : 수학점수가 70점보다 크거나 같으면
//		if(mat>=70)
//			System.out.println(name+"님은 "+mat+"점으로 합격입니다.");
//		else//아니면
//			System.out.println(name+"님은 "+mat+"점으로 불합입니다.");
//		scan3.close();
//	//문제] 어떤 숫자를 입력받아서, 음수인지, 양수인지, 0인지를 판별하여 출력하세요.
//		Scanner scanF=new Scanner(System.in);
//		System.out.print("숫자를 입력하세요:");
//		double num=scanF.nextDouble();//
//		
//		if(num>0) System.out.println("양수입니다.");
//		else if(num<0) System.out.println("음수입니다.");
//		else if(num==0) System.out.println("0입니다.");
//		scanF.close();

		//조건 연산자 : (조건식) ? 참:거짓; 목적:if문의 간소화
//		String name = "홍길동";
//		int math = 85;
//		
//		String pass = (math >=70) ? "합격" : "불합격";
//		System.out.println(pass);
//
//		Scanner scanF=new Scanner(System.in);
//		System.out.print("숫자를 입력하세요:");
//		double num=scanF.nextDouble();//
//				
//		String num2 = (num>0) ? "양수입니다." : (num<0) ? "음수입니다." : "0입니다." ;
//		System.out.println(num2);
//
//		Scanner scan =new Scanner(System.in);
//		System.out.print("영어 점수를 입력하세요 :");
//		int eng = scan.nextInt();
//		scan.nextLine();
//
//		String grade = (eng>=90) ? "등급은 A입니다." : (eng>=80) ? "등급은 B입니다." : 
//			(eng>=70) ? "등급은 C입니다." : (eng>=60) ? "등급은 D입니다." : "등급은 F입니다." ;
//		//char grade = (eng>=90)? 'A' : (eng>=80) ? 'B' : (eng>=70) ? 'C' : (eng>=60) ? 'D' : 'F';
//		System.out.println(grade);
//		
//		scan.close();
//		
//		//난수 발생 클래스 : Random(), Math()
	//1~6 사이의 난수를 발생하여 출력해 보세요. : 로또 복권, 게임
//		int num = (int) (Math.random()*6+1);//1~6
//		//int num = (int) (Math.random()*6);//0~5
//		
//		Random rand = new Random();
//		int su = rand.nextInt();
//		System.out.println(su);
//		
//		System.out.println(num);
//		
//		if (num==1)
//			System.out.println("꽝");
//		else if (num==2)
//			System.out.println("꽝");	
//		else if (num==3)
//			System.out.println("1000원을 받습니다.");
//		else if (num==4)
//			System.out.println("5000원을 받습니다.");
//		else if (num==5)
//			System.out.println("2등");
//		else if (num==6)
//			System.out.println("1등");
	//문제] 은행에 저축을 합니다. 금액은 입력에 따릅니다.
	//저축한 금액이 100만원이면, 하이마트에 가서 노트북을 삽니다.
	//저축액이 80만원 이상이면,멋진 양복을 삽니다.
	//저축액이 60만원 이상이면, 아이스크림을 삽니다.
	//저축액이 40만원 이상이면, 영화관람을 합니다.
	//저축액이 20만원 이상이면, 한턱 쏩니다.
	//저축액이 10만원 이상이면 게임을 삽니다.
	//5만원 이상이면, 라면을 삽니다.
	//3만원 이상이면, 부페를 가서 저녁을 먹습니다.
	//집에서 열공을 합니다.
	//그리고, STOP을 입력하면 프로그램이 중지합니다.
//		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("금액을 입력하세요: ");
//		String mo = br.readLine();
//		while(mo!="STOP")
//		{
//		int mon1 = (int) Float.parseFloat(mo);
//		if (mon1==1000000)
//		System.out.println("노트북");
//		else if (mon1>=800000)
//		System.out.println("양복");	
//		else if (mon1>=600000)
//		System.out.println("아이스크림");
//		else if (mon1>=400000)
//		System.out.println("영화관람");
//		else if (mon1>=200000)
//		System.out.println("한턱");
//		else if (mon1>=100000)
//		System.out.println("게임");
//		else if (mon1>=50000)
//			System.out.println("라면");
//		else if (mon1>=30000)
//			System.out.println("부페");
//		else if (mon1<=20000)
//			System.out.println("열공");
//				}*/
		
		
//	//		누적금액 		매번저축금액
//		int sbanking=0, banking=0, money2=0;
//		String stop = " ";//중지변수
//		String money = " ";//입력금액 문자데이터
//		
//		Scanner sc = new Scanner(System.in);
//		
//		while(true)
//		{
//			while(true)
//			{
//				System.out.println("은행에 저축할 금액을 입력하세요: ");
//				money = sc.next();
//				
//				if(money.equals("STOP"))
//				{
//					System.out.println("프로그램을 종료합니다.");
//					System.exit(0);
//				}
//				money2 = Integer.parseInt(money);
//				if(money2>0)
//				{
//					banking=money2;
//					sbanking+=banking;//누적부분.
//					System.out.println("은행에 저축한 금액은 = " + money2);//	1200
//					System.out.println("누적 금액은 = " + sbanking);//1200 + 2300 + ?
//				}
//				else if(money2<0)
//				{
//					if(sbanking<-money2)
//					{
//						System.out.println("금액을 다시 입력해 주세요.");
//						continue;
//					}
//					else
//					{
//					banking=money2;
//					sbanking+=banking;
//					System.out.println("은행에서 출금한 금액은 = " + money2);
//					System.out.println("누적 금액은 = " + sbanking);
//					}
//				}
//				else
//				{
//					System.out.println("금액을 다시 입력해 주세요.");
//					continue;
//				}
//				
//				if(sbanking > 1000000) {
//					System.out.println("하이마트으로 이동");
//					System.out.println("노트북을 구매");
//					break;
//				}else if(sbanking >= 800000) {
//					System.out.println("양복점으로 이동");
//					System.out.println("양복을 구매");
//					break;
//				}else if(sbanking >= 600000) {
//					System.out.println("편의점으로 이동");
//					System.out.println("아이스크림을 구입");
//					break;
//				}else if(sbanking >= 400000) {
//					System.out.println("영화관으로 이동");
//					System.out.println("영화관람/팝콘 구매");
//				}else if(sbanking >= 200000) {
//					System.out.println("소주방으로 이동");
//					System.out.println("친구들에게 한 ~ 턱 냅니다.");
//					break;
//				}else if(sbanking >= 100000) {
//						System.out.println("게임판매대로 이동");
//						System.out.println("배틀넷 게임을 구매.");
//						break;
//				}else if(sbanking >= 50000) {
//					System.out.println("편의점으로 이동");
//					System.out.println("라면 1박스를 구매.");
//					break;
//				}else if(sbanking >= 30000) {
//					System.out.println("강남부페로 이동");
//					System.out.println("저녁식사를 맛있게 합니다.");
//					break;
//				}else {
//					System.out.println("집에서 열공합니다.!!!");
//					break;
//				}
//			}
//		}
//			
//		//배수 구하기
//		//임의의 수를 입력 받아서, 그 수가 3,5,7,9의 배수인지를 판별하여 출력합니다.
//		Scanner sc2 = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요: ");
//		int x = sc2.nextInt();
//		
//		if(x%3==0)
//			System.out.println(x + "는 3의 배수입니다.");
//		if(x%5==0)
//			System.out.println(x + "는 5의 배수입니다.");
//		if(x%7==0)
//			System.out.println(x + "는 7의 배수입니다.");
//		if(x%9==0)
//			System.out.println(x + "는 9의 배수입니다.");
//		if(!(x%3==0 || x%5==0 || x%7==0 || x%9==0)) //그냥 else로만 작성하면 가장 직전의 if문(x%9==0)에만 걸린다
//			System.out.println("3,5,7,9의 배수가 아닙니다.");
//		
		//위의 소스를 줄여서 작성해보세요.
//		if(x%3==0|| x%5==0 || x%7==0|| x%9==0)
//		{
//			System.out.println("3,5,7,9의 배수중에 하나 입니다.");
//		}else
//		{
//			System.out.println("3,5,7,9의 배수가 아닙니다.");
//		}
		//임의의 수를 입력 받아서, 그 수가 기준수 보다 큰 수인지, 작은 수인지, 같은 수인지를 판별하여 출력하세요.
		//hint>555
//		int y = 555;
//		Scanner sc3 = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요:");
//		int x = sc3.nextInt();
//		
//		if(x>y)
//			System.out.println(x+"가 큰 수입니다.");
//		else if(x<y)
//			System.out.println(x+"가 작은 수 입니다.");
//		else
//			System.out.println(x+"가 같은 수 입니다.");
			
//		//임의의 수를 입력받아서, 1~100 사이의 숫자인지 판별하고, 그 수가 7의 배수인지 확인하여 출력하세요.
//		Scanner sc3 = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요:");
//		int n = sc3.nextInt();
//		if(n<=1 && n>=100 && n%7 ==0)
//			System.out.println(n+"은 1와 100 사이의 수이며, 7의 배수입니다.");
//		else
//			System.out.println(n+"은 1와 100 사이의 수가 아니거나, 7의 배수가 아닙니다.");
//		sc3.close();
//		
//		//숫자 두 개를 입력받아서, max,min을 판별하여 출력하세요. if문
//		int max, min;
//		Scanner scF = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요: ");
//		int val1 =scF.nextInt();
//		int val2 =scF.nextInt();
//		
//		if(val1>val2)
//		{
//			max = val1;
//			min = val2;
//		}
//		else
//		{
//			max = val2;
//			min = val1;
//		}
//		System.out.println("max = "+max+"\n"+"min = "+min);
//		scF.close();
		
		
		//switch~case
		//다음과 같이 주민등록번호가 존재합니다. 123456~1234567
		//이 주민번호를 가지고 남성인지 여성인지 판별하여 출력합시다.
//		//1,3:남성; 2,4:여성; 1900년대: 1,2 2000년대:3,4
//		
//		String secureNum; int numLength=13;
//		Scanner sc1 = new Scanner(System.in);
//		
//		System.out.println("-를 제외한 주민번호를 입력해주세요.");
//		secureNum=sc1.next();
//		if(secureNum.length()==numLength)
//		{
//			char stNum=secureNum.charAt(6);
//			if(stNum == '1'||stNum == '3')
//				System.out.println("남성입니다.");
//			else if(stNum == '2'||stNum == '4')
//				System.out.println("여성입니다.");
//			else
//				System.out.println("성별 번호를 확인할 수 없습니다.");
//		}else
//			System.out.println("잘못 입력하셨습니다.");
//		
//		
//		
//		if()
		//-↑풀어봄---↓해석----------
//		
//		String juminbunho = "123456-2234567";
//		char gubun=juminbunho.charAt(7);
//		
//		if(gubun == '1'||gubun == '3')
//			System.out.println("남성입니다.");
//		else if(gubun =='2'||gubun=='4')
//			System.out.println("여성입니다.");
//		else
//			System.out.println("잘못된 형식입니다.");
//		//위의 소스를 switch ~case 버전으로 바꾸어보자.
//		
//		switch(gubun)
//		{
//		case '1'://''없이 숫자만 입력하면 int값으로 인식한다=>default 실행
//		case '3':
//			System.out.println("남성입니다.");
//			break;//break 입력 안 하면 아래 구문 전부 실행된다.
//		case '2':
//		case '4':
//			System.out.println("여성입니다.");
//			break;
//		default:
//			System.out.println("잘못된 형식입니다.");
//			break;
//		}
		
	//문제] 임의의 수 100이 주어집니다.(입력받아도 됨)
	//다음과 같은 조건을 만족하는 값을 출력하세요.
	//1.7로 나눌 때, 나머지가 1인 수
	//1.7로 나눌 때, 나머지가 2 또는 3인 수
	//1.7로 나눌 때, 나머지가 4 또는 5인 수
	//1.7로 나눌 때, 나머지가 6인 수
	//1.7로 나누어 지는 수
//		
//		Scanner sc2 = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요:");
//		int inputNum=sc2.nextInt();
//		
//		for(int i=0;i<=inputNum;i++)
//		{
//			int num=i%7;
//			switch(num)
//			{
//			case 1:
//				System.out.println(i+"은 나머지가 1인 수");
//				break;
//			case 2:
//			case 3:
//				System.out.println(i+"은 나머지가 2 또는 3인 수");
//				break;
//			case 4:
//			case 5:
//				System.out.println(i+"은 나머지가 4 또는 5인 수");
//				break;
//			case 6:
//				System.out.println(i+"은 나머지가 6인 수");
//				break;
//			default:
//				System.out.println(i+"은 7로 나누어 지는 수");
//				break;
//			}
//		}
//		sc2.close();
//		//-----↑풀이----↓해답-------------------
//		int x = 555;
//		if(x%7 ==1)
//			System.out.println("x["+x+"]는 나눌 때,나머지가 1인 수");
//		else if(x%7==2 || x%7==3) 
//			System.out.println("x["+x+"]는 나눌 때,나머지가 2 또는 3인 수");
//		else if(x%7==4 || x%7==5)
//			System.out.println("x["+x+"]는 나눌 때,나머지가 4 또는 5인 수");
//		else if(x%7==6)
//			System.out.println("x["+x+"]는 나눌 때,나머지가 6인 수");
//		else if(x%7==0)
//			System.out.println("x["+x+"]는 나눌 때,7로 나누어지는 수");
		//switch문으로
//		switch(x%7)
//		{
//		case 1:
//			System.out.println("x[\"+x+\"]는 나눌 때,나머지가 1인 수");
//			break;
//		case 2:
//		case 3:
//			System.out.println("x["+x+"]는 나눌 때,나머지가 2 또는 3인 수");
//			break;
//		case 4:
//		case 5:
//			System.out.println("x["+x+"]는 나눌 때,나머지가 4 또는 5인 수");
//			break;
//		case 6:
//			System.out.println("x["+x+"]는 나눌 때,나머지가 6인 수");
//			break;
//		default:
//			System.out.println("x["+x+"]는 나눌 때,7로 나누어지는 수");
//			break;
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
