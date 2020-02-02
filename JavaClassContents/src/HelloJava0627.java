import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//import java.util.Scanner;

//반복문: 조건문이 처리하고자 하는 내용을 반복.
//종류:for,wile,do~while
//for의 형식
//for(초기값;조건식;증감식){
//.....;
//}

//while(조건식) {  //먼저 조건을 탐색한다.	거짓이면 한 번도 실행x
// ......;
//}

//do{	//적어도 한번은 실행합니다.			거짓이면 한 번은 실행o
// ....;
// while(조건식);

public class HelloJava0627 {
//프로젝트 할 때는 여기에다 변수 적기.
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
	//1~100 사이의 합계를 구하세요.
//		int sum= 0;
//		int i=0;
//		for(i=1;i<=100;i++)
//		{
//			sum+=i;
//		}
//		System.out.println("총 합은:"+sum);
	//-----↑풀이------↓해답-------------------	
//		int sum = 0, i;//보통 프로젝트 때는 변수선언을 밖으로 빼준다.
//		//(초기값;조건식;증감식)
//		for(i=0; i<=100; i++) //i++ = i+=1 = i=i+1 
//		sum+=i;
//		
//		System.out.println("for = 1~100 : "+sum);//5050
//	//while문으로
//		//int i3=0 , sum3=0;
//		//변수를 재설정 하지 않았을 경우(i,sum 그대로 사용)
//		//아래 while 구문은 실행이 되지 않는다
//		//∴위에 for문의 sum값이 그대로 출력이 된다.
//		while(i3<=100)
//		{
//			sum3+=i3;
//			i3++;
//		}
//		System.out.println("while = 1~100 : "+sum3);
//		
//	//3.do~while
//		int i2=0 , sum2=0;
//		do {
//			sum2+=i2;
//			i2++;
//		}while(i2<=100);
//		System.out.println("do ~ while = 1~100 : "+sum2);
//		
//	//문제]1~100 사이의 수 중에서 홀수의 합을 구하여 출력하세요.
//	//단, for,while,do~while을 사용합니다.
//		//for
//		int i, inputNum1=100, sumNum=0,Rem= i%2;
//		for(i=1;i<=inputNum1;i++)
//		{
//			if(Rem==1)
//				sumNum+=i;
//		}
//		System.out.println("1:"+sumNum);
//		//while
//		int i2, sumNum2=0,Rem2= i%2;
//		while(inputNum1<=100)
//		{
//			if(Rem2==1)
//				sumNum2+=i2;
//			i2++;
//		}
//		System.out.println("2:"+sumNum2);
		//------↑풀이-------↓해답------------------
		//for문
//		int i=0 , sum=0 ;
//		
//		for(i=1;i<=100;i++)
//		{
//			if(i%2==0)
//				continue;//분기문:건너 뛰어라,skip
//			sum+=i;
//		}
//		System.out.println("1.홀수의 합은 = "+sum);//2500
//		//while문
//		int i2=0, sum2=0;
//		while(i2<=100)
//		{
//			if(i2%2==1)
//			sum2+=i2;
//			i2++;//해당 구문이 없으면 무한루프에 빠진다. ∵i2가 늘어나지 않아서
//		}
//		System.out.println("2.while 홀수의 합은 = "+sum2);
//		//do while
//		int i3=0, sum4=0;
//		do {
//			if(i3%2==1) 
//			{
//				sum4+=i3;
//			}
//			i3++;//해당 구문이 if문 안에 있으면 무한루프에 빠진다.  
//				//∵if문 조건이 false가 되는 순간부터 if문이 false가 됨->i3가 늘어나지 않음
//		}while(i3<=100);
//		System.out.println("4.do ~ while 홀수의 합은 = "+sum4);
//	//문제]위 문제 짝수로	
//			if(i%2==1)
//				continue;//분기문:건너 뛰어라,skip
//			if(i2%2==0)
//		//부분만 바꿔주면 된다.

//		//감소하기 : 카운트다운
//		for(int i=10;i>0;i--)
//			System.out.println(i);
//		
//		int i2 =10;//초기화
//		for(      ;   ;    )//초기화,증감식을 for문 바깥에 뺄 수도 있다.
//		{
//			if(i2>0) //조건식도 바깥에 뺄 수 있다. but 빠져나가는 구문 없으면 무한루프?
//			{
//			System.out.println(i2);
//			i2--;//증감식
//			}
//		}
//		int count=0;
//		for(int i3=100; i3>=0; i3-=10)
//		{
//			System.out.println(i3);
//			count+=1;
//		}
//		System.out.println("갯수는 = "+count);//0 포함 11개
	//1~100 사이의 5의 배수의 합을 구하여 출력하세요.
//		int cnt1=0;
//		for(int i=1;i<=100;i++)
//		{
//			int j=i%5;
//			if(j==0)
//				cnt1+=i;
//		}
//		System.out.println("(for)총 합은="+cnt1);
//		//while
//		int cnt2 = 0, i2=1;
//		while(i2<=100)
//		{
//			int j=i2%5;
//			if(j==0)
//				cnt2+=i2;
//			i2++;
//		}
//		System.out.println("(while)총 합은="+cnt2);
//		//do while
//		int cnt3 = 0, i3=1;
//		do{
//			int j=i3%5;
//			if(j==0)
//				cnt3+=i3;
//			i3++;
//		}while(i3<=100);
//		System.out.println("(do while)총 합은="+cnt3);
		//-----↑풀이-----↓해설--------------
//		//1.for
//		int sum1=0;
//		for(int i=1; i<=100; i++)
//			if(i%5==0)
//			{
//				sum1+=i;
//			}
//		System.out.println("1.5의 배수는 = "+sum1);
//		//위의 for문 대신 아래로 바꿀 수도 있다.
//		int sum2=0;
//		for(int i=5; i<=100; i+=5)
//			sum2+=i;
//		System.out.println("2.5의 배수는 = "+sum2);
//		//2.while
//		int sum3=0, i2=5;
//		while(i2<=100) 
//		{
//			sum3+=i2;
//			i2+=5;
//		}
//		System.out.println("3.5의 배수는 = "+sum3);
//		//3.do~while
//		int sum4=0, i3=0;
//		do {
//			sum4+=i3;
//			i3+=5;
//		}while(i3<=100);
//		System.out.println("4.5의 배수는 = "+sum4);
	
	//문제] 1부터 1씩 증가하여 최초로 합이 3000이 넘는 정수의 값은 얼마인가?
//		int sum=0, i;
//		for(i=1;true;i++)
//		{
//			sum+=i;
//			if(sum>=3000)
//			{
//				System.out.println(sum);
//				System.out.println(i);
//				break;
//			}
//		}
		//while
//		int sum2=0, i2=0;
//		while(sum2<=3000)
//		{
//			sum2+=i2;
//			if(sum2>=3000)
//			{
//				System.out.println(i2);
//				System.out.println(sum2);
//				break;
//			}
//			i2++;
//		}
//		//※
//		int x=1, y=2;
//		System.out.println(x+=(y++));
//		System.out.println(x+=y++);//==(x+=y)++
//	//문제] 구구단을 출력합니다. 2~19단
//		//다중 for문
//		System.out.println("@@@@@@@@@for문의 19단@@@@@@@@@@");
//		for(int i=2;i<=19;i++)//단수 설정하는 코드
//		{
//			System.out.println("===\t"+i+"단"+"\t===");
//			for(int j=1;j<=19;j++)//곱해주는 수 설정하는 코드
//			{
//				int k=i*j;//결과값
//				System.out.println(i+"*"+j+"="+k);
//			}
//		}
		//다중 while문
//		{//i를 지역변수로 설정해줄때
//			System.out.println("@@@@@@@@@while문의 19단@@@@@@@@@@");
//			int i=2;//단수
//			while(i<=19)
//			{
//				System.out.println("===\t"+i+"단"+"\t===");
//				int j=1;//곱해주는 수
//				while(j<=19)
//				{
//					int k=i*j;//결과값
//					System.out.println(i+"*"+j+"="+k);
//					j++;
//				}
//				i++;
//			}
//		}
//		
//	//과제1>구구단을 출력하되, 단이 곱하는 수보다 커지면 중지합니다.
//	//1
//	//2 4
//	//3 6 9
//	//4 8 12 16
//	//5 10 15 20 25
//		for(int i=1;i<=9;i++)
//		{
//			System.out.println("===\t"+i+"단"+"\t===");
//			for(int j=1;i>=j;j++) //(;i>=j&&j<=9;)면 최대 9단까지만 입력된다.
//			{
//				int k=i*j;
//				System.out.println(i+"*"+j+"="+k);
//			}
//		}
//
	//문제] 출력을 원하는 단을 출력하도록 프로그래밍 하세요.
//		{
//			Scanner sc =new Scanner(System.in);
//			System.out.print("출력할 단을 입력하세요: ");
//			int dan=sc.nextInt();
//			for(int i=1;i<=dan;i++)
//			{
//				System.out.println("===\t"+i+"단"+"\t===");
//				for(int j=1;j<=9;j++)
//				{
//					int k=i*j;
//					System.out.println(i+"*"+j+"="+k);
//				}
//			}
//			sc.close();
//		}
		//-------↑풀이---↓해설------------------
//		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			System.out.println("원하는 단을 입력해 주세요.");
//			int gugu = Integer.parseInt((br.readLine()));
//			
//			System.out.println("*** "+gugu+"단 ***");
//			for(int j=1; j<=9; j++)
//			{
//				System.out.println(gugu + "*" +j+"="+(gugu*j));
//			}
//		}
//	//문제] 구구단중에서 홀수단을 출력하되, 단의 수만큼만 출력되도록 합니다.
//		{
//			Scanner sc =new Scanner(System.in);
//			System.out.print("출력할 단을 입력하세요: ");
//			int dan=sc.nextInt();
//				for(int i=1;i<=dan;i++)
//				{
//					if(i%2==1)
//					{
//						System.out.println("===\t"+i+"단"+"\t===");
//						for(int j=1;i>=j;j++)
//						{
//							int k=i*j;
//							System.out.println(i+"*"+j+"="+k);
//						}
//					}
//				}
//		}
//		//------↑풀이-------↓해설----------------
//		//int(동일;동일;i+=2)
//	
//	//문제]#을 10개씩 3줄에 출력하세요.
//		for(int i=0;i<3;i++)//세로
//		{
//			for(int j=0;j<10;j++)//가로
//			{
//				System.out.print("#");
//			}
//			System.out.println();
//		}		
//	//문제]#을 5행으로 3개씩 출력하세요.
//		for(int i=0;i<5;i++)//세로
//		{
//			for(int j=0;j<3;j++)//가로
//			{
//				System.out.print("#");
//			}
//			System.out.println();
//		}
//	//문제]다음과 같이 출력 되도록 합니다.
//	//	28	27	26
//	//	25	24	23
//	//	22	21	20
//		{
//			int k=28;
//			for(int i=0;i<3;i++)
//			{
//				for(int j=0;j<3;j++)
//				{
//					System.out.print(k);
//					k--;
//					if(j<2)
//					{
//					System.out.print("\t");
//					}
//				}
//				System.out.println();
//			}
//		}
//	//문제]다음과 같이 출력 되도록 합니다.
//	//	1	2	3	4	5
//	//	6	7	8	9	10
//	//	11	12	13	14	15
//		{	
//			int k=1;
//			for(int i=0;i<3;i++)
//			{
//				for(int j=0;j<5;j++)
//				{
//					System.out.print(k);
//					k++;
//					if(j<4)
//					{
//					System.out.print("\t");
//					}
//				}
//				System.out.println();
//			}
//		}
//	//문제] 다음과 같이 출력 되도록 합니다.
//	//12345
//	//12345
//	//12345
//	//12345
//	//12345
//		for(int i=0;i<5;i++)//세로
//		{
//			for(int j=1;j<=5;j++)//가로
//			{
//				System.out.print(j);
//			}
//			System.out.println();
//		}
//	//문제] 다음과 같이 출력 되도록 합니다.
//	*
//	**
//	***
//	****
//	*****
//		for(int i=0;i<5;i++)//세로
//		{
//			for(int j=0;j<=i;j++)//가로
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	//문제] 다음과 같이 출력 되도록 합니다.
//	//1
//	//12
//	//123
//	//1234
//	//12345
//		for(int i=0;i<5;i++)//세로
//		{
//			for(int j=1;j<=i+1;j++)//가로
//			{
//				System.out.print(j);
//			}
//			System.out.println();
//		}
//	//문제] 다음과 같이 출력 되도록 합니다.
//	// *****
//	// ****
//	// ***
//	// **
//	// *
//		for(int i=0;i<5;i++)//세로
//		{	
//			System.out.print(" ");
//			for(int j=5;j>i;j--)//가로
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	//문제] 다음과 같이 출력 되도록 합니다.
//	// *****
//	//  ****
//	//   ***
//	//    **
//	//     *
//		for(int i=0;i<5;i++)//세로
//		{	
//			System.out.print(" ");
//			for(int k=0;k<i;k++)
//			{
//				System.out.print(" ");
//			}
//			for(int j=5;j>i;j--)//가로
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	//	//문제] 다음과 같이 출력 되도록 합니다.
//	//      5
//	//     54
//	//    543
//	//   5432
//	//  54321
//			for(int i=5;i>0;i--)//세로
//			{	
//				for(int k=0;k<i;k++)
//				{
//					System.out.print(" ");
//				}
//				for(int j=5;j>=i;j--)//가로
//				{
//					System.out.print(j);
//				}
//				System.out.println();
//			}		
//	//문제]다음과 같이 출력 되도록 합시다.
//	//      1 
//	//     1 2 
//	//    1 2 3 
//	//   1 2 3 4 
//	//  1 2 3 4 5 
//		for(int i=0;i<5;i++)
//		{
//			for(int k=5;k>i;k--)
//			{
//				System.out.print(" ");
//			}
//			for(int j=1;j<=i+1;j++)//가로
//			{
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
//	//문제]다음과 같이 출력 되도록 합시다.
//		1 2 3 4 5 
//		 1 2 3 4 
//		  1 2 3 
//		   1 2 
//		    1 
//		for(int i=5;i>=1;i--)//발상의 전환:i를 역순으로 세보자.
//		{
//			for(int k=1;k<=5-i;k++)
//			{
//				System.out.print(" ");
//			}
//			for(int j=1;j<=i;j++)//가로
//			{
//
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
//	//과제2]다음과 같이 출력하세요.
//		for(int i=0;i<5;i++)//세로
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
//	//문제] 다음과 같은 처리를 하도록 프로그램을 작성하세요.
//	//---------------------------
//	//1.예금 
//	//2.출금 
//	//3.잔액조회 
//	//4.종료(Exit)
//	//---------------------------
//		//1.bufferedReader
//		{
//			int inMyPocket=0;
//			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//			while(true)
//			{
//				System.out.println("---------------------------");
//				System.out.println("1.예금");
//				System.out.println("2.출금 ");
//				System.out.println("3.잔액조회 ");
//				System.out.println("4.종료(Exit)");
//				System.out.println("---------------------------");
//				System.out.print("번호를 입력해주세요:");
//				String choiceS = bf.readLine();// int choice =br.read();입력 시 아스키코드값 출력.
//				int choice=Integer.parseInt(choiceS);
//				System.out.println(choice);
//				if(choice==1)
//				{
//					System.out.print("예금할 금액을 입력해 주세요:");
//					String inMoneyS=bf.readLine();
//					int inMoney=Integer.parseInt(inMoneyS);
//					inMyPocket+=inMoney;
//				}
//				else if(choice==2)
//				{
//					System.out.print("출금할 금액을 입력해 주세요:");
//					String outMoneyS=bf.readLine();
//					int outMoney=Integer.parseInt(outMoneyS);
//					if(inMyPocket<outMoney)
//					{
//						System.out.println("잔액이 부족합니다.");
//					}
//					else
//					{
//						inMyPocket-=outMoney;
//					}
//				}
//				else if(choice==3)
//				{
//					System.out.println("현재 잔액은"+inMyPocket+"원 입니다.");
//				}
//				else if(choice==4)
//				{
//					System.out.println("시스템을 종료합니다.");
//					System.exit(0);
//				}
//				else
//				{
//					System.out.println("잘못된 번호입니다. 다시 입력해 주세요.");
//				}
//			}
//		}
//		//2.Scanner
//		{
//			int inMyPocket=0;
//			Scanner sc = new Scanner(System.in);
//			while(true)
//			{
//				System.out.println("---------------------------");
//				System.out.println("1.예금");
//				System.out.println("2.출금 ");
//				System.out.println("3.잔액조회 ");
//				System.out.println("4.종료(Exit)");
//				System.out.println("---------------------------");
//				System.out.print("번호를 입력해주세요:");
//				int choice = sc.nextInt();
//				sc.nextLine();
//				if(choice==1)
//				{
//					System.out.print("예금할 금액을 입력해 주세요:");
//					inMyPocket+=sc.nextInt();
//					sc.nextLine();
//				}
//				else if(choice==2)
//				{
//					System.out.print("출금할 금액을 입력해 주세요:");
//					int outMoney=sc.nextInt();
//					sc.nextLine();
//					if(inMyPocket<outMoney)
//					{
//						System.out.println("잔액이 부족합니다.");
//					}
//					else
//					{
//						inMyPocket-=outMoney;
//					}
//				}
//				else if(choice==3)
//				{
//					System.out.println("현재 잔액은"+inMyPocket+"원 입니다.");
//				}
//				else if(choice==4)
//				{
//					System.out.println("시스템을 종료합니다.");
//					System.exit(0);
//				}
//				else
//				{
//					System.out.println("잘못된 번호입니다. 다시 입력해 주세요.");
//				}
//			}
//		}
//		//----------↑풀이----------↓해설--------------------------
//		{	
//			String str;
//			String balance = null;
//			int total = 0;
//			boolean run = true;
//				
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//				
//			while(run) {
//			System.out.println("----------------------------");
//			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료 ");
//			System.out.println("----------------------------");
//			System.out.println("선택>> ");
//			str = br.readLine();
//			
//			switch(str) {
//				
//			case "1": 
//				System.out.println("예금액>>");
//				balance = br.readLine();
//				total += Integer.parseInt(balance);
//					break;
//			case "2":
//				System.out.println("출금액>>");
//				balance = br.readLine();
//				total -= Integer.parseInt(balance);
//					break;
//			case "3":
//				System.out.println("잔고>>");
//				System.out.println(total);
//				break;
//					
//			case "4":
//				run = false;
//				System.out.println("프로그램을 종료합니다.");
//				break;
//			}
//			System.out.println();
//			}	
//		}
		
		
		
	}

}
