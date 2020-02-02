

import java.util.Scanner;

public class Pr190628 {
	//
//	public static void Work5(String s)//메소드 정의부(선언부 포함)
//	{
//		int sNum=99, tNum=sNum/10, oNum=sNum-(10*tNum);
//		//문제에 정의된 값,10의자리=A값,1의자리=B값;
//		for(int i=0;i<=tNum;i++)//10의 자리
//		{
//			for(int j=0;j<=oNum;j++)//1의 자리
//			{
//				int x=(10*i+j)+(10*j+i);//x=AB+BA
//				if(x==sNum)//x=99면
//				{
//					if(s=="A")
//						System.out.print(i); //true시 조건을 만족하는 A값 출력
//					if(s=="B")
//						System.out.print(j); //false시 조건을 만족하는 B값 출력
//					
//					if(i!=tNum)//마지막 숫자에 ,를 빼기 위한 문단
//						System.out.print(",");
//				}
//			}
//		}
//	}
//	
	public static void main(String[] args) {
//	//과제1] 1~100 사이의 소수를 구하여 출력하세요.
//
//	{
//		int max=100; //구하려는 최대 범위
//		for(int i=1;i<=max;i++)
//		{
//			int sum=0;//sum을 j포문에 넣게되면 j값이 ++ 될 때 마다 0으로 초기화된다->버그//			for(int j=1;j<=max;j++)
//			{
//				if(i%j==0)
//					sum++;
//			}
//			if(sum==2)
//				System.out.println(i+"는 소수입니다.");
//		}
//	}
//		
//	//과제2] 국어,영어 점수를 입력받아서 처리하되, 0점 이상 100점 이하로 성적이 입력되도록 하여 합계와 평균을 구합니다.
//		
//	{
//		int kor,eng, subNum=2; double sum,avg;
//		//국어,영어점수,최대 과목 개수;합계,평균
//		Scanner sc = new Scanner(System.in);
//		while(true)
//		{
//			System.out.println("국어 점수를 입력하세요");
//			kor=sc.nextInt();
//			sc.nextLine();
//			
//			System.out.println("영어 점수를 입력하세요");
//			eng=sc.nextInt();
//			
//			if (kor<0 || kor>100 || eng<0 || eng>100)
//			{
//				System.out.println("잘못된 점수입니다. 다시 입력해주세요.");
//			}
//			else
//			{
//				sum=kor+eng;
//				avg=(kor+eng)/subNum;
//				System.out.printf("두 과목의 합계는 %.2f점, 평균은 %.2f점 입니다.",sum,avg);
//				break;
//			}
//		}
//	}
//		
//	//과제3] 컴퓨터와 숫자 맞추기 게임을 합니다.
//	//하나의 난수는 컴퓨터가 발생하여 저장하고, 그 숫자를 사람이 맞추어가는 형태로 진행합니다.
//	//카운트하여 몇 번만에 맞추었는지도 출력하고 게임을 계속 진행 하려면
//	//yes(1)을 그만두려면 no(2)를 입력합니다.
//		
//	{	
//		int inNum,ansNum,maxNum=30,minNum=1;//입력 번호,랜덤값,랜덤 최대값,랜덤 최소값
//		Scanner sc = new Scanner(System.in);
//		while(true)//반복실행구문
//		{
//			int count=1;//정답 횟수 초기화
//			System.out.println("숫자 맞추기 게임입니다.\n1부터 "+maxNum+"까지의 숫자를 입력해주세요:");
//			inNum=sc.nextInt();
//			sc.nextLine();
//			ansNum=(int) (Math.random()*maxNum)+1;//랜덤 번호 설정
//			while(inNum!=ansNum)//정답을 맞히기 전까지 반복실행
//			{
//				if(inNum>maxNum || inNum<minNum)//입력값이 최대값이나 최소값을 벗어난 경우
//				{
//					System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
//					inNum=sc.nextInt();
//					sc.nextLine();
//				}else
//				{
//					System.out.println("틀렸습니다.다시 입력해주세요:");
//					count++;
//					inNum=sc.nextInt();
//					sc.nextLine();
//				}
//			}
//			System.out.println("정답입니다!\n정답을 맞추는데 소요된 횟수는 총 "+count+"번입니다.");
//			System.out.println("계속하려면 yes, 종료하려면 no를 입력해주세요:");
//			boolean sw=true;//yes 입력 시 초기화면으로 돌아가기 위한 변수.
//			while(sw)
//			{
//				String choice=sc.nextLine();
//				if(choice.equals("yes"))
//				{
//					System.out.println("처음으로 돌아갑니다.");
//					sw=false;
//				}else if(choice.equals("no"))
//				{
//					System.out.println("시스템을 종료합니다.");
//					System.exit(0);
//				}else
//				{
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//				}
//			}
//		}
//	}
//		
//	//과제4] 피보나치 수열을 작성하고, n번째 항까지의 합을 구하여 출력하세요.
//	//1,1,2,3,5,8
//
//	{	int n,maxSum=0,x=0,y=1,z=0;//출력할 횟수,출력한 수열의 총합,수열의 이전값,현재값,다음값
//		Scanner sc = new Scanner(System.in);
//		n=sc.nextInt();
//		for(int i=1;i<=n;i++)//n번째 항 까지 출력해주는 반복문
//		{	
//			maxSum+=y;
//			System.out.print(y);
//			z=x+y;
//			x=y;
//			y=z;
//			if(i!=n)
//				System.out.print(",");
//			else
//				System.out.println("\n수열의 총합="+maxSum);
//		}
//	}
//		
//	//과제5] 다음식을 만족하는 모든 A와 B를 구하는 프로그램을 작성하세요.
//	//		AB	예>	63	72	54
//	//	  + BA		36	27	45
//	//--------------------------
//	//		99		99	99...
//		//10의자리
//		//1의자리
//		
//	{
//		System.out.print("A=");
//		Work5("A");
//		System.out.print("\nB=");
//		Work5("B");
//	}
	
	
	
	
	
	
	
	
	
	
	
	}

}
