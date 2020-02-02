
import java.util.Scanner;
//검수를 제대로 하자
//검수를 제대로 하자

public class Pr190627 {

	public static void main(String[] args) {
//	//과제1>구구단을 출력하되, 단이 곱하는 수보다 커지면 중지합니다.
//		//1
//		//2 4
//		//3 6 9
//		//4 8 12 16
//		//5 10 15 20 25
//		{
//			Scanner sc =new Scanner(System.in);
//			System.out.print("출력할 단을 입력하세요: ");
//			int dan=sc.nextInt();
//				for(int i=1;i<=dan;i++)
//				{
//					for(int j=1;i>=j;j++)
//					{
//						System.out.print(i*j);
//						System.out.print(" ");
//					}
//					System.out.println();
//				}
//		}
//	//과제2]다음과 같이 출력하세요.
//		for(int i=0;i<4;i++)//세로 //5->4
//		{
//			for(int k=0;k<i;k++)//공백
//			{
//				System.out.print(" ");
//			}
//			for(int j=7;j>2*i;j--)//가로
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//	//과제3]1~100 사이의 연산의 합계를 구하세요.
//	//1-2+3-4+5-6+7-8+......100=?
//	//3가지 이상의 방법을 사용하여 풀어보세요.
//		{
//		int sum=0,max=100,left=max%2;
//		if(left==0)
//			System.out.println(-max/2);
//		if(left==1)
//			System.out.println((max+1)/2);
//		}
		//1.for if문
//		{
//			int sum=0;
//			for(int i=1;i<=100;i++)
//			{
//				if(i%2==1)
//				{
//					sum+=i;
//				}else if(i%2==0)
//				{
//					sum-=i;
//				}
//			}
//			System.out.println("1.for if문의 합계 = "+sum);
//		}
//		//2.while switch문
//		{
//			int sum=0, i=1;
//			while(i<=100)
//			{
//				int rem= i%2;
//				switch(rem)
//				{
//				case 0:
//					sum-=i;
//					break;
//				case 1:
//					sum+=i;
//					break;
//				}
//				i++;
//			}
//			System.out.println("2.while switch문의 합계 = "+sum);
//		}
//		//3.do while문 if문
//		{
//			int sum=0, i=1;
//			do {
//				int rem= i%2;
//				if(rem==1)
//				{
//					sum+=i;
//				}else if(rem==0)
//				{
//					sum-=i;
//				}
//				i++;
//			}while(i<=100);
//			System.out.println("3.do while문 if문의 합계 = "+sum);	
//		}
//		
//	//과제4] 반지름을 입력 받아서, 원의 넓이와 둘레를 구하여 출력하세요.
//	//계속하려면 yes를 입력하고, no이면 중단합니다.	
//		{
//			double pi=3.14;//원주율
//			Scanner sc=new Scanner(System.in);
//			while(true)
//			{
//				System.out.println("원의 넓이와 둘레를 구하는 시스템입니다.");
//				System.out.print("계속하려면 yes,종료하려면 no를 입력해주세요:");
//				String choice=sc.nextLine(); //next()입력시 버그 발생(yes no 입력시 에러)
//				if(choice.equals("yes"))//==(x) ∵string은 참조형이라 주소값을 비교한다.
//				{
//					int r;//반지름
//					double s,l;//넓이,둘레
//					System.out.print("반지름을 입력해주세요:");
//					r=sc.nextInt();
//					sc.nextLine();
//					
//					s=pi*r*r;
//					l=2*pi*r;
//					System.out.printf("원의 넓이는 %.2f 이고, 둘레는 %.2f 입니다.", s,l );
//					System.out.println();
//					
//				}else if(choice.equals("no"))
//				{
//					System.out.println("시스템을 종료합니다.");
//					System.exit(0);
//				}else
//					System.out.println("잘못 입력하셨습니다.");
//				
//			}	
//		}
	
	}

}
