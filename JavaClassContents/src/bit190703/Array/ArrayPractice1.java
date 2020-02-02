package bit190703.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ArrayPractice1 {

	public static void main(String[] args) {
//	//문제]학생수를 입력받고 점수를 입력받아서, 점수 리스트를 출력하고
//	//데이터 분석을 하는데, 최고 점수와 평균점수를 출력합니다.
//	//계속 하시려면 y를 아니면 n을 입력하세요.
//		boolean sw2=true;
//		while(sw2) 
//		{
//			int stuNum,stuScore[],avg,sum = 0;//학생수,점수입력배열,점수 평균,점수 총합
//			Scanner sc = new Scanner(System.in);
//			System.out.println("학생 수를 입력하세요:");
//			stuNum=sc.nextInt();
//			stuScore = new int[stuNum];//학급인원을 점수배열의 길이로 설정
//			for(int i=0;i<stuScore.length;i++)
//			{
//				System.out.println((i+1)+"번 점수를 입력하세요:");
//				int input=sc.nextInt();
//				while(input>100||input<0)//점수 입력 판별
//				{
//					System.out.println("잘못 입력하셨습니다.다시 입력해주세요:");
//					input=sc.nextInt();
//				}
//				stuScore[i]=input;//정상 입력시 배열에 추가 
//				sum+=input;//점수 총합 추가
//			}	
//			Arrays.sort(stuScore);//오름차순 정리
//			avg=sum/stuNum;//평균값 정의
//			System.out.println("최고 점수:"+stuScore[stuNum-1]);
//			System.out.println("평균 점수:"+avg);
//			
//			sc.nextLine();//점수 입력 시 생겼던 엔터값 제거
//			boolean sw=true;//yes 입력 시 초기화면으로 돌아가기 위한 변수.
//			while(sw)
//			{
//				System.out.println("계속하시려면 \"y\",아니면 \"n\"을 입력해주세요.");
//				String choice=sc.nextLine();
//				if(choice.equals("y"))
//				{
//					System.out.println("처음으로 돌아갑니다.");
//					sw=false;
//				}else if(choice.equals("n"))
//				{
//					System.out.println("시스템을 종료합니다.");
//					sw2=false;//System.exit(0);는 프로그램 자체를 종료시킨다->다음코드 전부 실행x
//					sw1=false;//입력 안하면 종료 반복문이 계속된다.
//				}else
//				{
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//				}
//			}
//		}
//	//문제] 쉬어가는 페이지
//	//임의의 숫자를 입력하여 배열에 저장하고, 내용중에서 짝수에 해당하는 데이터만 출력하세요.
//	//그래고, 5의 배수만 출력해보세요.
//	{
//		int num[],even[],multiF[],count;//숫자 배열,입력된 숫자의 총합
//		Scanner sc = new Scanner(System.in);
//		System.out.println("입력할 숫자의 총 개수를 입력하세요:");
//		count=sc.nextInt();
//		num=new int[count];
//		even=new int[count];
//		multiF=new int[count];
//		
//		for(int i=0;i<count;i++) 
//		{
//			System.out.println((i+1)+"번 숫자를 입력하세요:");
//			int input=sc.nextInt();
//			num[i]=input;
//		}
//		System.out.println("모든 숫자가 입력되었습니다.");
//		
//		int evenCount=0,multiFCount=0;
//		for(int i=0;i<count;i++)
//		{
//			if(num[i]%2==0)
//			{
//				even[evenCount]=num[i];
//				evenCount++;
//			}
//			if(num[i]%5==0)
//			{
//				multiF[multiFCount]=num[i];
//				multiFCount++;
//			}
//		}
//		
//		ArrayPractice1 ap1 = new ArrayPractice1();
//		System.out.println("짝수:");
//		ap1.printA(evenCount, even);
//		System.out.println("5의배수:");
//		ap1.printA(multiFCount, multiF);
//	}
		
	//구구단 중에서 5단을 출력하세요.
//	{
//		int a[] = new int[9];
//		int b;
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("출력할 단을 입력하세요:");
//		b=sc.nextInt();
//		
//		for(int i=0;i<9;i++)
//		{
//			a[i]=b*(i+1);//구구단을 배열로 저장
//			System.out.println(b+"*"+(i+1)+"="+a[i]);
//		}
//			
//	}
//	//임의의 수를 입력하여 수의 등수를 매깁니다.
//	//값이 클수록 순위가 적어집니다.(석차 구하기 알고리즘)
//	{
//		ArrayList<Integer> numbers = new ArrayList<>();
//		Scanner sc = new Scanner(System.in);
//		boolean sw1=true;
//		while(sw1)
//		{
//			System.out.println("숫자를 입력하세요.");
//			numbers.add(sc.nextInt());
//			
//			sc.nextLine();
//			System.out.println("그만 입력하시려면 \"n\"을 입력해주세요.");
//			System.out.println("계속 진행하시려면 \"n\"을 제외한 아무 문자나 입력하시면 됩니다:");
//			String swt=sc.nextLine();
//			if(swt.equals("n"))
//				sw1=false;
//		}
//		Collections.sort(numbers);
//		int grade1=1;
//		for(int i : numbers)
//		{
//			System.out.println(grade1+"등:"+i);
//			grade1++;
//		}
//	}
	//아래와 같은 데이터가 존재합니다.
	//이중에서 가장 큰 값과 가장 작은 값을 판별하여 출력하세요.
//	{
//		int[] numList = {123,146,451,51,15,547,2692};
//		int max=numList[0],min=numList[0];
//		for(int i=0;i<numList.length;i++)
//		{
//			if(max<numList[i])
//				max=numList[i];
//			if(min>numList[i])
//				min=numList[i];
//		}
//		System.out.println("큰 값:"+max);
//		System.out.println("작은 값:"+min);
//	}
	
	//3개의 숫자를 입력받아서 가장 큰 값을 구하는 프로그램을 작성.
//	{
//		int a[] = new int[3];
//		Scanner sc = new Scanner(System.in);
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println("숫자를 입력하세요:");
//			a[i]=sc.nextInt();
//		}
//		Arrays.sort(a);
//		System.out.println("Max:"+a[a.length-1]);
//	//------위풀이---------아래해답------------------
//	}
//	{
//		int su[] = new int[3];
//		Scanner sc = new Scanner(System.in);
//		System.out.println("배열에 데이터를 입력하세요.");
//		su[0] = sc.nextInt();
//		su[1] = sc.nextInt();
//		su[2] = sc.nextInt();
//
//		int max = su[0];
//		for(int i=1;i<=2;i++)
//			max=max>su[i]?max:su[i];
//		System.out.println(max);
//	}
//	//컴퓨터와 가위,바위,보 게임을 합니다.
//	//1차원 배열을 이용,이김,비김,짐 표현을 하고, 계속하려면 y, 아니면 n을 입력해주세요.
//	{
//		String a[]= {"가위","바위","보"};
//		Random r= new Random();
//		boolean sw2=true;
//		while(sw2)
//		{
//			int result = r.nextInt(3);
//			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("가위면 \"1\",바위면\"2\",보면\"3\" 을 입력하세요.");
//			int go = sc.nextInt();
//			sc.nextLine();
//			if(go==1)
//			{
//				if(result==0)
//					System.out.println(a[0]+"! 당신은 비겼습니다.");
//				if(result==1)
//					System.out.println(a[1]+"! 당신은 졌습니다.");
//				if(result==2)
//					System.out.println(a[2]+"! 당신은 이겼습니다.");
//			}else if(go==2)
//			{
//				if(result==0)
//					System.out.println(a[0]+"! 당신은 이겼습니다.");
//				if(result==1)
//					System.out.println(a[1]+"! 당신은 비겼습니다.");
//				if(result==2)
//					System.out.println(a[2]+"! 당신은 졌습니다.");
//			}else if(go==3)
//			{
//				if(result==0)
//					System.out.println(a[0]+"! 당신은 졌습니다.");
//				if(result==1)
//					System.out.println(a[1]+"! 당신은 이겼습니다.");
//				if(result==2)
//					System.out.println(a[2]+"! 당신은 비겼습니다.");
//			}else
//				System.out.println("잘못 입력하셨습니다.");
//			boolean sw1=true;
//			while(sw1)
//			{
//				System.out.println("계속하시려면 \"y\",아니면 \"n\"을 입력해주세요.");
//				String choice=sc.nextLine();
//				if(choice.equals("y"))
//				{
//					System.out.println("처음으로 돌아갑니다.");
//					sw1=false;
//				}else if(choice.equals("n"))
//				{
//					System.out.println("시스템을 종료합니다.");
//					sw2=false;//System.exit(0);는 프로그램 자체를 종료시킨다->다음코드 전부 실행x
//					sw1=false;
//				}else
//				{
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//				}
//			}
//		}
//	}
	//토요일 저녁 8시 KBS 로또 복권 추첨
	//로또 복권을 발행하여 숫자를 출력하세요.
	{
//		Scanner sc = new Scanner(System.in);
		ArrayPractice1 ap1 = new ArrayPractice1();
		int[] weekLotto=ap1.lottoR();//로또 번호 랜덤 생성
		for(int e : weekLotto)
			System.out.println(e);

		
//틀린 구문(로또번호는 중복이 되지 않아야함.추후 수정)
//		System.out.println("로또 번호를 입력해주세요.");
//		int[] inputLotto=new int[6];
//		for(int i=0;i<6;i++)//사용자 로또 번호 입력
//		{
//			inputLotto[i]=sc.nextInt();
//			System.out.println((i+1)+"번째 번호가 입력되었습니다.");
//		}
//		int count=0;//번호 맞춘 횟수
//		for(int i=0;i<6;i++)//번호를 맞춘 만큼 횟수 카운트
//		{
//			if(inputLotto[i]==weekLotto[i])
//				count++;
//		}
	}
	
	
	
	
	}
	

	private int[] lottoR() {
//		System.out.println("로또랜덤번호:");
		int lotto[] = new int[6];
		Random l= new Random();
		for(int i=0;i<6;i++)
		{
			lotto[i]=l.nextInt(45)+1;
			for(int j=0;j<i;j++)//j<=i 로 해주면 무한루프에 빠진다∵2행 밑
			{
				while(lotto[i]==lotto[j])//여기서 lotto[i]==lotto[i]까지 검사하므로
					lotto[i]=l.nextInt(45)+1;
			}
		}
//		for(int e : lotto)
//			System.out.print(e+" ");		
		return lotto;
	}

	void printA(int x,int y[]) {
		for(int i=0;i<x;i++)
		{
			System.out.print(y[i]);
			if(i<x-1)
				System.out.print(",");
		}
		System.out.println();
	}

}
