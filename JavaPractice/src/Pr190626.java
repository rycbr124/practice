
import java.util.Scanner;

public class Pr190626 {

	public static void main(String[] args) {
		//과제1
//		int kor,eng,math,sum;
//		double avg;
//		String name;//String names = null; 로 보통은 많이 잡아둠
//		Scanner sc = new Scanner(System.in);
//		System.out.print("이름을 입력하세요:");
//		name = sc.nextLine();
//		System.out.print("국어 점수를 입력하세요:");
//		kor=sc.nextInt();
//		System.out.print("영어 점수를 입력하세요:");
//		eng=sc.nextInt();
//		System.out.print("수학 점수를 입력하세요:");
//		math=sc.nextInt();
//		
//		sum=kor+eng+math;
//		avg=sum/3;
//		
//		System.out.println(name+"의 총합은"+avg+"점 입니다.");
//		System.out.println(name+"의 평균은 "+sum+"점 입니다.");
//		
//		if(avg>=90)
//			
//			{
//				System.out.println(name+"의 평균은 90점 보다 큽니다.");
//				System.out.println("등급은 A입니다.");	
//			}else if(avg>=80)
//			{
//				System.out.println(name+"의 평균은 80점 보다 큽니다.");
//				System.out.println("등급은 B입니다.");
//			}else if(avg>=70)
//			{
//				System.out.println(name+"의 평균은 70점 보다 큽니다.");
//				System.out.println("등급은 C입니다.");
//			}else if(avg>=60)
//			{
//				System.out.println(name+"의 평균은 60점 보다 큽니다.");
//				System.out.println("등급은 D입니다.");
//			}else
//			{
//				System.out.println(name+"의 평균은 60점 보다 작습니다.");
//				System.out.println("등급은 F입니다.");
//			}
//			sc.close();
//		
//		
//		//과제2
//		Scanner sc2 = new Scanner(System.in);
//		System.out.println("아래와 같은 형식으로 입력해주세요.");
//		System.out.print("정수 정수 기호:");
//		int num1 =sc2.nextInt();
//		int num2 =sc2.nextInt();
//		String sign = sc2.next(); //String Oper = sc.next();
//
//		if(sign.equals("+")) //if(Oper.equals("name"))
//		{
//			int result=num1+num2;
//			System.out.println(result);
//		}
//		else if(sign.equals("-"))
//		{
//			int result=num1-num2;
//			System.out.println(result);
//		}
//		else if(sign.equals("*"))
//		{
//			int result=num1*num2;
//			System.out.println(result);
//		}
//		else if(sign.equals("/"))
//		{
//			int result=num1/num2;
//			System.out.println(result);
//		}
//		else if(sign.equals("%"))
//		{
//			int result=num1%num2;
//			System.out.println(result);
//		}else
//		{
//			System.out.println("잘못 입력하셨습니다.");
//		}
//		sc2.close();
//
//		
//		//과제3
//		//1.if문
//		int menu,menup = 0,count,price; //메뉴,메뉴의 가격,개수,총 금액
//		Scanner sc3 = new Scanner(System.in);
//		
//		while(true)
//		{
//			System.out.println("=============================");
//			System.out.println(" 메 뉴			가 격");
//			System.out.println("=============================");
//			System.out.println("1.피자			8,600");
//			System.out.println("2.스파게티          15,000");
//			System.out.println("3.햄버거 		100,000");
//			System.out.println("4.스프 			5,000");
//			System.out.println("5.토마토		3,500");
//			System.out.println("6.종료");
//			System.out.println("=============================");
//		System.out.print("다음 메뉴 중에서 고르세요:");
//		menu = sc3.nextInt();
//		sc3.nextLine();
//			if(menu==6)
//			{
//				System.out.println("프로그램이 종료되었습니다.");
//				break;
//			}else if(menu==1||menu==2||menu==3||menu==4||menu==5)
//			{
//				System.out.print("주문할 음식의 갯수를 입력하세요:");
//				count = sc3.nextInt();
//				sc3.nextLine();
//				
//				if(menu==1)
//					menup=8600;
//				else if(menu==2)
//					menup=15000;
//				else if(menu==3)
//					menup=100000;
//				else if(menu==4)
//					menup=5000;
//				else if(menu==5)
//					menup=3500;
//				//앞으로 가격은 변수로 따로 빼놓자
//				
//				price=menup*count;
//				System.out.println(menup+"*"+count+"="+price+"입니다.");
//				continue;
//			}else
//			{
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//			}
//		}
//		
		//2.switch문
//		int menu,menup = 0,count,price; //메뉴,메뉴의 가격,개수,총 금액
//		Scanner sc3 = new Scanner(System.in);
//		System.out.println("=============================");
//		System.out.println(" 메 뉴			가 격");
//		System.out.println("=============================");
//		System.out.println("1.피자			8,600");
//		System.out.println("2.스파게티          15,000");
//		System.out.println("3.햄버거 		100,000");
//		System.out.println("4.스프 			5,000");
//		System.out.println("5.토마토		3,500");
//		System.out.println("6.종료");
//		System.out.println("=============================");
//		
//		breakOut :
//		while(true) 
//		{
//		System.out.print("다음 메뉴 중에서 고르세요:");
//		menu = sc3.nextInt();
//		sc3.nextLine();
//			switch(menu)
//			{
//			case 6:
//				System.out.println("프로그램이 종료되었습니다.");
//				break breakOut;
//				//System.exit(0); 해도 됨
//			case 1:
//			case 2:
//			case 3:
//			case 4:
//			case 5:
//				switch(menu)
//				{
//					case 1:
//						menup=8600;
//						break;
//					case 2:
//						menup=15000;
//						break;
//					case 3:
//						menup=100000;
//						break;
//					case 4:
//						menup=5000;
//						break;
//					case 5:
//						menup=3500;
//						break;
//				}
//				System.out.print("주문할 음식의 갯수를 입력하세요:");
//				count = sc3.nextInt();
//				sc3.nextLine();
//				price=menup*count;
//				System.out.println(menup+"*"+count+"="+price+"입니다.");
//			default:
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//			}
//			
//		}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
