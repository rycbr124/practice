

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pr190704 {

	public static void main(String[] args) {
//	//2-1]
//	{
//		int num=1;
//		int[][]exam = new int[5][5];
//				
//		for(int i=0;i<5;i++)
//		{
//			for(int j=i;j<5;j++)
//			{
//				exam[i][j]=num*num;
//				num++;
//				
//			}
//		}
//		
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(exam[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.printf("%5s","");
//				else
//					System.out.printf("%5d",exam[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	//2-2]
//	{
//		int sw=-1,n=1;
//		int[][]exam = new int[5][5];
//				
//		for(int i=0;i<5;i++)
//		{
//			for(int j=i;j<5;j++)
//			{
//				exam[i][j]=n;
//				n*=sw;//1,-1,1,-1,1...
//			}
//		}
//		
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(exam[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.printf("%5s","");
//				else
//					System.out.printf("%5d",exam[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	//2-3]
//	{
//		int x=0,y=0,count1=1,count2=0,count3=1;
//		int[][] h3= new int[5][5];
//		
//		for(int i=y;i<h3.length;i++)
//		{
//			h3[x][i]=count1;
//			count1++;
//			y=i;
//		}
//		x++;//x1 y4
//		int sw2=-1;
//		int sw1=1;
//		while(true)
//		{
//			if(sw1==1)
//			{
//				for(int i=x;i<h3.length-count2;i++)
//				{
//					h3[i][y]=count1;
//					count1++;
//					x=i;
//				}
//				y--;
//				for(int j=y;j>=count2;j--)
//				{
//					h3[x][j]=count1;
//					count1++;
//					y=j;
//				}
//				x--;
//				count2++;
//				sw1*=sw2;
//			}else if(sw1==-1)
//			{
//				for(int i=x;i>=count2;i--)
//				{
//					h3[i][y]=count1;
//					count1++;
//					x=i;
//				}
//				y++;
//				for(int j=y;j<h3.length-count2;j++)
//				{
//					h3[x][j]=count1;
//					count1++;
//					y=j;
//				}
//				x++;
//				sw1*=sw2;
//			}
//			count3++;
//			if(count3>h3.length)
//				break;
//		}
//		
//		for(int i=0;i<h3.length;i++)//출력부분
//		{
//			for(int j=0;j<h3.length;j++)
//					System.out.printf("%3d",h3[i][j]);
//			System.out.println();
//		}
//	}
	{
		
	}
//	//2-4]
//	{
//		int count1=1;
//		int[][] h4 = new int[5][5];
//		int middle=(h4[h4.length-1].length)/2;
//		for(int i=0;i<h4.length;i++)
//		{
//			if(i<h4.length/2)
//			{
//				for(int j=middle-i;j<=middle+i;j++)
//				{
//					h4[i][j]=count1;
//					count1+=2;
//				}
//			}else
//			{
//				for(int j=i-middle;j<=(3*middle)-i;j++)
//				{
//					h4[i][j]=count1;
//					count1+=2;
//				}
//			}
//		}
//		
//		
//		for(int i=0;i<h4.length;i++)//출력부분
//		{
//			for(int j=0;j<h4[h4.length-1].length;j++)
//			{
//				if(h4[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.printf("%5s","");
//				else
//					System.out.printf("%5d",h4[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	//2-5]
//	{
//		int[][] h5 = new int[5][5];
//		int count1=1;
//		
//		for(int i=0;i<h5.length;i++)
//		{
//			if(i%2==0)
//			{
//				for(int j=0;j<5;j++)
//				{
//					h5[i][j]=count1;
//					count1++;
//				}
//			}else
//			{
//				for(int j=4;j>=0;j--)
//				{
//					h5[i][j]=count1;
//					count1++;
//				}
//			}
//		}
//		
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(h5[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.printf("%5s","");
//				else
//					System.out.printf("%5d",h5[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	
//	//2-6]
//	{
//		int count3=1;
//		int[][] h6=new int [5][5];
//		for(int i=0;i<5;i++)
//		{
//			for(int j=0;j<=i;j++)
//			{
//				h6[i][j]=count3;
//				count3++;
//			}
//		}
//		
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(h6[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.printf("%3s","");
//				else
//					System.out.printf("%3d",h6[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	//2-7]
//	{
//		System.out.println("정수\t제곱\t세제곱");
//		System.out.println("=====================");
//		int[][] h7=new int [10][3];
//		for(int i=0;i<10;i++)
//		{
//			int a=i+1;
//			for(int j=0;j<3;j++)
//			{
//				h7[i][j]=a;
//				a*=(i+1);
//			}
//		}
//
//		for(int i=0;i<10;i++)//출력부분
//		{
//			for(int j=0;j<3;j++)
//			{
//				System.out.printf("%4d\t",h7[i][j]);
//			}
//			System.out.println();
//		}
//	}		
//	//2-8]
//	{
//		System.out.println("내림차순 정렬(배열 사용)");
//		System.out.println("====================");
//		Scanner sc = new Scanner(System.in);
//		int h8[]=new int[3];
//		
//		System.out.print("첫 번째 수는 : ");//100 입력
//		h8[0]=sc.nextInt();
//		sc.nextLine();
//		
//		System.out.print("두 번째 수는 : ");// 50 입력
//		h8[1]=sc.nextInt();
//		sc.nextLine();
//
//		System.out.print("세 번째 수는 : ");// 500 입력
//		h8[2]=sc.nextInt();
//		sc.nextLine();
//		
//		Arrays.sort(h8);
//		int h8_2[] = new int[3]; 
//		int j=2;
//		for(int i=0;i<3;i++)
//		{
//			h8_2[i]=h8[j];
//			j--;
//
//		}
//		System.out.println("입력받은 수들을 큰 순서대로 나열해보면");
//		for(int e : h8_2)
//			System.out.println(e);
//	}
//	//ex2-1(2-9)]
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
//	//ex2-2(2-10) : 2-5와 같은 문제
//	//ex2-3(2-11)
//	{
//		int sum=0,countm5=0;
//		int[] h111 = new int[10];
//		Scanner sc = new Scanner(System.in);
//		System.out.println("숫자 10개를 입력하세요:");
//		for(int i=0;i<10;i++)
//		{
//			h111[i]=sc.nextInt();
//			sc.nextLine();
//		}
//		for(int e : h111)
//		{
//			if(e%5==0)
//			{
//				countm5++;
//				sum+=e;
//			}
//		}
//		System.out.println("1)5의 배수의 갯수:"+countm5+",합:"+sum);
//		
//		int[] h112 = {200,120,150,100,180};
//		Arrays.sort(h112);
//		System.out.println("2)최대값:"+h112[4]+",중간값:"+h112[h112.length/2]+",최소값:"+h112[0]);
//	
//		int h113[]=new int[] {10,20,30,40,50,60,70,80,90,100};
//		int h1131[] =new int[h113.length];
//		for(int i=0;i<h113.length;i++)
//			h1131[i]=h113[i];
//	
//		for(int i=0;i<h113.length;i++)
//		{
//			if(i%2==0)
//			{
//				h113[i]=h1131[i+1];
//			}else if(i%2==1)
//			{
//				h113[i]=h1131[i-1];
//			}
//		}
//		System.out.print("3)");
//		for(int i : h113)
//			System.out.print(i+" ");
//		System.out.println();
//	}
//	//ex2-4(2-12)
//	{
//		int count=0;
//		String[][] h12 = new String[5][5];
//		String[] a= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
//		for(int j=4;j>=0;j--)
//		{
//			for(int i=0;i<5;i++)
//			{
//				h12[i][j]=a[count];
//				count++;
//			}
//		}
//		
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//					System.out.printf("%3s",h12[i][j]);
//			System.out.println();
//		}
//	}
//	//ex2-5(2-13)
//	{
//		int count=1;
//		int[][] h13=new int [5][5];
//		for(int i=0;i<5;i++)//세로
//		{
//			for(int j=i;j>=0;j--)//가로
//			{
//				h13[i][j]=count;
//				count++;
//			}
//		}
//		
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(h13[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.print("   ");
//				else
//					System.out.printf("%3d ",h13[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	//ex2-6(2-14)
//	{
//		int count=1;
//		int[][] h14=new int [5][5];
//		for(int i=4;i>=0;i--)//행
//		{
//			for(int j=0;j<5;j++)//열
//			{
//				h14[i][j]=count;
//				count++;
//			}
//		}
//	
//		for(int i=0;i<5;i++)//출력부분
//		{
//			for(int j=0;j<5;j++)
//			{
//				if(h14[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.print("   ");
//				else
//					System.out.printf("%3d ",h14[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	//ex2-7(2-15)
//	{
//		int sum1=0;
//		int[] h151 = new int[100];
//		for(int i=0;i<100;i++)
//		{
//			h151[i]=(int) (Math.random()*1200)+1;//랜덤 번호 설정
//			sum1+=h151[i];
//		}
//		Arrays.sort(h151);
//		System.out.println("1)최대값:"+h151[99]+",최소값:"+h151[0]+",평균:"+sum1/100);
//
//		int sum2=0;
//		int[] h152 = new int[100];
//		for(int i=0;i<100;i++)
//		{
//			h152[i]=(int) (Math.random()*201)+1001;//랜덤 번호 설정
//			sum2+=h152[i];
//		}
//		Arrays.sort(h152);
//		System.out.println("2)최대값:"+h152[99]+",최소값:"+h152[0]+",평균:"+sum2/100);
//		
//		int[] h153=new int[100];
//		System.out.print("3)");
//		for(int i=0;i<100;i++)
//		{
//			h153[i]=(int) (Math.random()*100)+101;
//			System.out.println((i+1)+"번:"+h153[i]);
//		}
//
//		Random r = new Random();
//		boolean[] h154 = new boolean[100];
//		System.out.print("4)");
//		for(int i=0;i<100;i++)
//		{
//			h154[i]=r.nextBoolean();
//			System.out.println((i+1)+"번:"+h154[i]);
//		}
//
//		Random r2 = new Random();
//		double[] h155 = new double[100];
//		System.out.print("5)");
//		for(int i=0;i<100;i++)
//		{
//			h155[i]=r2.nextDouble();
//			System.out.printf("%d번:%.2f\n",(i+1),h155[i]);
//		}
//		
//		Random r3 = new Random();
//		int[] h156 = new int[100];
//		System.out.print("6)");
//		for(int i=0;i<100;i++)
//		{
//			h156[i]=r3.nextInt(100)+100;
//			System.out.printf("%d번:%d\n",(i+1),h156[i]);
//		}
//	}
//	//ex2-8(2-16)
//	{
//		int count1=10;
//		int[] test = new int[5];
//		for(int i=0;i<5;i++)
//		{
//			test[i]=count1;
//			count1+=10;
//		}
//		
//		System.out.printf("2)%d\n",test[2]);
//		
//		System.out.println("3)");
//		for(int e : test)
//			System.out.println(e);
//		
//		test[3]=100;
//		System.out.printf("4)%d\n",test[3]);
//
//		test[4]=200;
//		System.out.printf("5)%d\n",test[4]);
//		
//		System.out.println("6)");
//		for(int e : test)
//		{
//			e=0;
//			System.out.println(e);
//		}
//	}
//	//ex2-11(2-19)
//	{
//		int count1=1;
//		Scanner sc = new Scanner(System.in);
//		System.out.print("n입력 : ");
//		int max=sc.nextInt();
//		int[][] h19 = new int[max][max];
//		for(int j=0;j<max;j++)
//		{
//			if(j<=max/2)
//			{
//				for(int i=j;i<max-j;i++)
//				{
//					h19[i][j]=count1;
//					count1++;
//				}
//			}else
//			{
//				if(max%2==1)
//				{
//					for(int i=max-j-1;i<=j;i++)
//					{
//						h19[i][j]=count1;
//						count1++;
//					}
//				}
//				else
//				{
//					for(int i=max-j;i<j;i++)
//					{
//						h19[i][j]=count1;
//						count1++;
//					}
//				}
//			}
//		}
//		
//		for(int i=0;i<max;i++)//출력부분
//		{
//			for(int j=0;j<max;j++)
//			{
//				if(h19[i][j]==0)//비어있는 부분은 공백 출력
//					System.out.printf("%6s"," ");
//				else
//					System.out.printf("%02d ",h19[i][j]);
//			}
//			System.out.println();
//		}
//	}

	
	
	
	
	
	
	}

	
	
}
