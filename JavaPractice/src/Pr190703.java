

import java.util.Random;

public class Pr190703 {

	public static void main(String[] args) {
//	//과제1]
//	//	1  2  3  4  5
//	//	   6  7  8  
//	//	      9  
//	//	  10 11 12 
//	//	13 14 15 16 17
//	{
//		int count=1,count2=0;
//		int[][] h1=new int[5][5];
//		for(int i=0;i<5;i++)
//		{
//			if(i<2)
//			{
//				for(int j=i;j<5-i;j++)
//				{
//					h1[i][j]=count;
//					count++;
//				}
//			}else 
//			{
//				for(int j=2-count2;j<=i;j++)
//				{
//					h1[i][j]=count;
//					count++;
//				}
//				count2++;
//			}
//		}
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(h1[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.print("   ");
//				else
//					System.out.printf("%3d ",h1[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	//과제2> 배열 num(10)에는 10개의 숫자가 저장되어 있습니다.
//	//	<변경전>
//	//	10 20 30 40 50 60 70 80 90 100
//	//	<변경후>
//	//	20 10 40 30 60 50 80 70 100 90
//	{
//		int h2[]=new int[] {10,20,30,40,50,60,70,80,90,100};
//		int h3[] =new int[h2.length];
//		for(int i=0;i<h2.length;i++)
//			h3[i]=h2[i];
//	
//		for(int i=0;i<h2.length;i++)
//		{
//			if(i%2==0)
//			{
//				h2[i]=h3[i+1];
//			}else if(i%2==1)
//			{
//				h2[i]=h3[i-1];
//			}
//		}
//		for(int i : h2)
//			System.out.print(i+" ");
//		
//		System.out.println();
//	}
//	//과제3]
//	//1
//	//3 2
//	//6 5 4
//	//10 9 8 7
//	//15 14 13 12 11
//	{
//		int count3=1;
//		int[][] h3=new int [5][5];
//		for(int i=0;i<5;i++)//세로
//		{
//			for(int j=i;j>=0;j--)//가로
//			{
//				h3[i][j]=count3;
//				count3++;
//			}
//		}
//		
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(h3[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.print(" ");
//				else
//					System.out.print(h3[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
//	//과제4]
//	//21 22 23 24 25
//	//16 17 18 19 20
//	//11 12 13 14 15
//	//6  7  8  9  10
//	//1  2  3  4  5
//	{
//		int count4=1;
//		int[][] h4=new int [5][5];
//		for(int i=4;i>=0;i--)//행
//		{
//			for(int j=0;j<5;j++)//열
//			{
//				h4[i][j]=count4;
//				count4++;
//			}
//		}
//		
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(h4[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.print(" ");
//				else
//					System.out.print(h4[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
//	//과제5] boolean형 난수를 100개 생성하여 출력하세요.
//	{
//		Random r = new Random();
//		boolean[] hw5 = new boolean[100];
//		for(int i=0;i<100;i++)
//		{
//			int s= r.nextInt(2);
//			if(s==0)
//				hw5[i]=false;
//			else if(s==1)
//				hw5[i]=true;
//		}
//		for(int i=0;i<100;i++)
//			System.out.println((i+1)+"번째 난수="+hw5[i]);
//	}
//	//과제6] 100점대 난수를 100개 발생하여 출력하세요.
//	{
//		Random r =new Random();
//		for(int i=0;i<100;i++)
//		{
//			int a=r.nextInt(100)+100;//0~99->100~199
//			System.out.println((i+1)+"번 째 숫자="+a);
//		}
//	}
//	//과제7] 10~50을 초기값으로 갖는 1차원 배열을 text라는 이름으로 선언합니다.
//	//4번째 원소의 값을 100으로 변경하고, 출력합니다.
//	//모든 원소의 값을 0으로 초기화 하고 출력합니다.
//	//각 단계별 출력을 모두 실행이 되도록 합니다.
//	{
//		int[] text = new int[41];//10~50까지의 길이
//		for(int i=0;i<text.length;i++)
//			text[i]=i+10;
//		
//		text[3]=100;
//		System.out.println("4번째 원소의 값="+text[3]);
//		System.out.println();
//		
//		for(int i=0;i<text.length;i++)
//			text[i]=0;
//		for(int i=0;i<text.length;i++)
//			System.out.println((i+1)+"번째 원소의 값="+text[i]);
//	}
	

	}

}
