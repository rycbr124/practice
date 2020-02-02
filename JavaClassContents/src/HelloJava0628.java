import java.util.Scanner;

public class HelloJava0628 {
	//검수를 제대로 하자
	public static void main(String[] args) {
//	//5의 factorial 구하기 //5쾅!
//		{
//			int i, sum=1;
//			Scanner sc=new Scanner(System.in);
//			System.out.print("입력:");
//			int x = sc.nextInt();
//			
//			for(i=1; i<=x; i++)
//			{
//				sum*=i;
//				System.out.println("i= "+i+"합계는 = "+sum);//
//			}
//		}
		
//	//1+2+3+4+5+6+7+8+9+10=55
//		{	int input=10, sum=0;
//			for(int i=1;i<=input;i++)
//			{
//				System.out.print(i);
//				sum+=i;
//				if(i<input)
//					System.out.print("+");
//			}
//			System.out.print("="+sum);
//		}//-------↑풀이--------------↓해설-----------------------
//		for(int i=1, sum=0; i<=10; i++)
//		{
//			sum+=i;
//			System.out.print(i);
//			if(i==10)
//			{
//				System.out.print(" = ");
//				System.out.print(sum);
//			}else
//				System.out.print(" + ");
//		}
//	//-- while(~하는 동안에, 참인 경우에 반복 실행, 조건식 이용 이나 true)
//	//문제]Hello Java라는 문자열을 5번 반복 출력하세요.
//		{
//			int i=0,input=5; String str="Hello Java";
//			while(i<input)
//			{
//				System.out.println(str);
//				i++;
//			}
//		}
//	//"I Like Java Programming~~!!!"를 5번 출력하세요.
	//위 코드에서 str만 변경.
	
	//문제] -1+3-5+7-9+11...+99=hapgye
//		{int input=99,i=1,sum=0;
//			while((2*i)-1<=input)
//			{
//				int j=(2*i)-1,divine=i%2;//while문 밖에 선언하면 i값이 초기화되어서 계속 1만 나온다.
//				
//				if(divine==1)
//				{
//					System.out.print(-j);
//					++i;
//					sum-=j;
//				}else if(divine==0)
//				{
//					System.out.print("+"+j);
//					++i;
//					sum+=j;
//				}
//			}
//			System.out.print("="+sum);
//		}
//	//------↑풀이-----↓해설(sw응용 잘 살펴보기)-------------------------
//		{
//		int i=1, sum=0, sw=1;
//		
//		while(i<=99)
//			{
//				sw=sw*-1;//부호 변환
//				if(sw==-1)//sw의 부호가 음수면
//					System.out.print("-");
//				else//양수면
//					System.out.print("+");
//				System.out.print(i);
//				sum=sum+(i*sw);
//				i+=2; // 5
//			}
//		 System.out.println("="+sum); //50
//		}
//	//문제]1~200 사이의 7의 배수의 합과 갯수를 구하여 출력합시다.
//	//while문
//		{
//			int i=1,max=200,x=7,sum=0;
//			while(i<=max)
//			{
//				int y=i%7;//while문 밖에 선언하면 i값이 초기화되어서 7만 나온다.
//				if(y==0)
//					sum+=i;
//				++i;
//			}
//			System.out.println(sum);
//		}
	//-------↑풀이-------↓해답--------------
//		{int i=7, sum=0;
//			while(i<=200)//if문을 활용하지 않아도 아래 방법으로 구할 수 있다.
//			{
//				sum+=i;//7
//				i+=7;//24
//			}
//			System.out.println(sum);
//		}
//		{int i=7, sum=0,count=1;
//			while(i<=200)
//			{
//				if(i%7==0)
//				{
//					sum+=i;
//					count++;
//					System.out.println(i+count+sum);
//				}
//				i+=7;
//			}
//		}
//	//문제]2개의 난수를 발생하여 합이 50이 되면, 프로그램을 중지하고, 아니면 계속 난수가 발생됩니다.
//		{int num1, num2,count=0;
//			while(true)
//			{
//				num1=(int) (Math.random()*50); //0~50
//				num2=(int) (Math.random()*50); //0~50
//				count++;
//				System.out.println(count+"번 = "+num1+num2);
//				if(num1+num2==50)
//					break;
//			}
//		}
//		
//	//--------do ~while:무조건 실행을 하고,조건을 나중에 체크
//	//I Like Java Programming을 5번 출력
//		{int i=0;
//			do{
//				System.out.println("I Like Java Programming");
//				i++;
//			}while(i<5);
//		}
	//7의 배수의 합과 개수를 구하여 출력합니다.
//		{int i=7,count=1,sum=0,maxsum=0,max=100,j=0;//배수값,횟수,곱셈값,총합값,제한값
//			do {
//				sum=count*i;
//				maxsum+=sum;
//				System.out.println("횟수: "+count+"합계: "+maxsum);
//				++count;	
//				}while(j<=max);
//			}
		
		
		
		
		
		
		
	//문제]두 수를 입력받아서, 큰 값과 작은 값을 구별하여 출력하세요.(do~while)
//		{	
//			Scanner sc=new Scanner(System.in);
//			do {
//				System.out.print("첫 번째 숫자를 입력해주세요:");
//				int num1=sc.nextInt();
//				sc.nextLine();
//				System.out.print("두 번째 숫자를 입력해주세요:");
//				int num2=sc.nextInt();
//				if(num1>num2)
//					System.out.println("max="+num1+",min="+num2);
//				else if(num1<num2)
//					System.out.println("max="+num2+",min="+num1);
//				else
//					System.out.println("두 수는 같은 수 입니다.");
//			}while(true);
//		}
//	//-------------↑풀이------------↓해답------------------------------
//		{int su1, su2, xValue,yValue;
//			do {
//			Scanner sc = new Scanner(System.in);
//			System.out.print("두 수를 입력해주세요:");
//			su1=sc.nextInt();
//			su2=sc.nextInt();
//			
//			xValue = (su1>su2) ? su1:su2;
//			yValue = (su1<su2) ? su1:su2;
//			
//			System.out.println("큰 값은= "+xValue+"이고 , 작은값은 = "+yValue+"입니다.");
//			}while(true);
//		}
	//문제5] 5! 팩토리얼 구하기
//		{
//		int i=1,sum=1;
//		do {
//			sum*=i;
//			i++;
//			System.out.println("i= "+i+"sum= "+sum);
//		}while(i<=5);
//		}
//	//1~100 사이에 3의 배수이면 건너뛰세요. 3의 배수가 아니면 출력합니다.
//	//hint:continue
//		{int i=1,sum=0;
//		do {
//			i++;
//			if(i%3==0)
//				System.out.print(i+" ");
//		}while(i<=100);
//		}
//	//break----------------------------------	
//	//12345라는 숫자를 5번 반복하고 탈출하세요.
//		for(int i=1;true;i++)
//		{
//			for(int j=1;j<=5;j++)
//			{
//				System.out.print(j);
//			}
//			System.out.println();
//			if(i==5)
//				break;
//		}
//	//문제]1~100 사이의 덧셈의 합 중에 합이 3000에 가까운 수를 구하여 출력합니다.
//		{
//			int sum=0;
//			for(int i=1;i<=100;i++)
//			{
//				sum+=i;
//				if(sum>3000)
//				{
//					System.out.println(--i);
//					break;
//				}
//			}
//		}
//	//--------------------------------------------------
//		{
//			int sum=0,irobot=0;
//			for(int i=0;i<=100; i++)
//			{
//				sum+=i;
//				if(sum>=3000)
//				{
//					irobot = i;
//					break;
//				}
//					
//			}
//			System.out.println(irobot+","+sum);//77
//		}
//	//문제]5의 배수와 7의 배수가 되는 첫 번째 숫자를 구하여 출력하세요
//	//1.for	
//		for(int i=1;true;i++)
//		{
//			if(i%5==0 && i%7==0)
//			{
//				System.out.println(i);
//				break;
//			}
//		}
//	//2.while,break
//	{
//		int i=1;
//		while(true)
//		{
//			if(i%5==0 && i%7==0)
//			{
//				System.out.println(i);
//				break;
//			}else
//				i++;
//		}
//	}

	}

}
