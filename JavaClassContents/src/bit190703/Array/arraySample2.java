package bit190703.Array;

import java.util.Random;
import java.util.Scanner;

public class arraySample2 {

	public static void main(String[] args) {
//		int[] arr1= new int[5];//1차원 표현,행과 열이 같다.
//		
//		//2차원은 대괄호가 2개 들어간다.[행][열]
//		int[][] arr2 = new int[2][5];//2차원 표현,행과 열로 구분한다.※자바는 행 중심 언어.
//		
//		System.out.println(arr1.length);//5출력 5x4 =20byte
//		System.out.println(arr2.length);//2출력 ∵행중심 언어라서	(0행,1행)
//		System.out.println(arr2[0].length);//5 0행의 길이=열의 길이
//		System.out.println(arr2[1].length);//5 1행의 길이
//		
//	//구구단을 2차원 배열로 저장하고 출력하세요.
//	{
//		int[][] gu=new int[9][9];
//		
//		for(int i=0;i<9;i++)//행
//		{
//			System.out.println("===\t"+(i+1)+"단"+"\t===");
//			for(int j=0;j<9;j++)//열
//			{
//				gu[i][j]=(i+1)*(j+1);//구구단 입력
//				System.out.println((i+1)+"*"+(j+1)+"="+gu[i][j]);
//			}
//		}
//		
//		for(int j=0;j<9;j++)//7단 출력
//			System.out.print(gu[6][j]+" ");
//		
//		//다음과 같은 점수가 존재합니다.
//		//4행 3열 데이터
//		//{70,80,90,60,70,80,50,60,70,40,50,60}
//		//타이틀 : 번호,자바,C#,프로그램 총점
//			int[][] score = new int[][] {
//				{70,80,90},
//				{60,70,80},
//				{50,60,70},
//				{40,50,60}
//			};
//			System.out.println();
//			System.out.println("===================================");
//			System.out.println("번호\t자바\tC#\t프로그램\t총점");
//			System.out.println("===================================");
//			
//			for(int i=0;i<score.length;i++)//행
//			{
//				int total=0;
//				System.out.print(" "+(i+1)+"\t");//번호
//				for(int j=0;j<score[i].length;j++)//열, i번째의 길이만큼
//				{
//					System.out.print(score[i][j]+"\t");//과목 출력
//					total+=score[i][j];//총점 구하기
//				}
//					System.out.println(total);
//			}
//	//배열에서 원하는 데이터 찾기
//	//임의의 수를 10개 입력하고, 찾고자 하는 데이터의 위치가 어디인지를 찾아서 인덱스를 출력하세요.
//	{
//		int num[] = new int[10];
//		int result[] = null,count=0;
//		Scanner sc= new Scanner(System.in);
//		
//		System.out.println("10개의 정수형 데이터를 입력해 주세요:");
//		for(int i=0; i<num.length;i++)
//			num[i] =sc.nextInt();
//		System.out.println();
//		
//		System.out.println("찾을 데이터를 입력하세요.");
//		int su = sc.nextInt();
//		
////		for(int i=0; i<num.length;i++) {
////			if(num[i]==su)
////				result[count]=i;
////			else
////				System.out.println("원하는 숫자를 찾지 못했습니다.");
//		}
//		for(int i=0; i<num.length;i++) {
//			if(num[i]==su)
//				break;
//			if(i!=num.length)
//				System.out.println("숫자가 위치한 곳의 배열의 점자는="+i);
//			else
//				System.out.println("숫자를 찾지 못했습니다.");
//		}
//	}
//	//문제]30명의 학생에게 주변 음식점에 대한 만족도를 조사했습니다.
//	//조사한 결과를 출력하세요.
//	//기준:5(매우만족)4(만족)3(보통)2(불만족)1(매우불만족)
//	//결과 : 5:10명, 4:5명 ...
//	{
//		int c1=0,c2=0,c3=0,c4=0,c5=0;
//		int sur[] = new int[30]; 
//		Random r =new Random();//랜덤으로 받을 경우
////		Scanner sc = new Scanner(System.in); //입력받을 경우
//		for(int i=0;i<sur.length;i++)
//		{
//			sur[i]=r.nextInt(5)+1;//랜덤으로 받을 경우
////			System.out.println("평점을 입력해주세요("+(i+1)+"명 째)");
////			int a=sc.nextInt();
////			sc.nextLine();
////			sur[i]=a;
////			while(sur[i]>5||sur[i]<1)
////			{
////				System.out.println("잘못 입력하셨습니다. 1~5점 이내의 정수로 입력해주세요:");
////				sur[i]=sc.nextInt();
////				sc.nextLine();
////			}
//		}
//		
//		for(int i=0;i<sur.length;i++)
//		{
//			if(sur[i]==1)
//				c1++;
//			else if(sur[i]==2)
//				c2++;
//			else if(sur[i]==3)
//				c3++;
//			else if(sur[i]==4)
//				c4++;
//			else if(sur[i]==5)
//				c5++;
//		}
//		System.out.println("5:"+c5+"명, "+"4:"+c4+"명, "+"3:"+c3+"명, "+"2:"+c2+"명, "+"1:"+c1+"명");
//	}
//	//배열이름을 이용한 주소 복사
//	//자바에는 포인터가 없다.
//	{
//		int[] num1= {10,20,30,40,50};
//		int[] num2;
//		
////		int *Pnum2;//포인터 선언 c언어는 가능하나 자바는 불가(에러뜸)
//		
//		num2 = num1;//num1의 배열의 시작 주소 복사 10
//		
//		for(int i=0; i<num2.length; i++)
//			num2[i]+=100;//주소를 이동시켰다
//		
//		for(int j=0;j<num2.length;j++)
//			System.out.println("num["+j+"]"+num1[j]);
//		//부작용(side effect):하나의 메모리를 공유할 때 예상하지 못한 일이 발생하는 현상.
//		//num2의 값만 옮겼지만 주소를 공유하는 특성 때문에 num1의 값이 같이 변경되었다.
//	}
//	//다음과 같은 출력을 하는 프로그램을 작성 합니다.
//	//1 -1  1 -1  1
//	//0 -1  1 -1  1
//	//0  0 -1  1 -1
//	//0  0  0  1 -1
//	//0  0  0  0  1
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
//					System.out.printf("%3s","");
//				else
//					System.out.printf("%3d",exam[i][j]);
//			}
//			System.out.println();
//		}
//	}
//		
//	//다음과 같은 출력을 하는 프로그램을 작성 합니다.
//	//1   4    9  16  25
//	//0  36   49  64  81
//	//0   0  100 121 144
//	//0   0    0 169 196
//	//0   0    0   0 225
//	{
//		{
////			int sw=1,n=1;
//			int num=1;
//			int[][]exam = new int[5][5];
//					
//			for(int i=0;i<5;i++)
//			{
//				for(int j=i;j<5;j++)
//				{
////					exam[i][j]=sw*n;
////					sw++;
////					n++;
//					exam[i][j]=num*num;
//					num++;
//					
//				}
//			}
//			
//			for(int i=0;i<5;i++)//출력부분
//			{
//				for(int j=0;j<5;j++)
//				{
//					if(exam[i][j]==0)//비어있는 부분은 공백 출력
//						System.out.printf("%5s","");
//					else
//						System.out.printf("%5d",exam[i][j]);
//				}
//				System.out.println();
//			}
//		}
//	}
//	//문제] bitcamp Hotel을 증축하여 5층이고, 각 층의 호실은 7개씩 있습니다.
//	//투숙객은 다음과 같이 있다면, 전체 인원수와 각 층의 평균 인원수는 얼마인가요?
//	//[data]
//	//임의로,아래는 예시
//	//1층: 10,90,70,60,80,65,55
//	//2층:
//	{
//		int fSum,aSum=0,max=90;//각 층의 전체인원수,호텔의 모든 인원수,방 하나당 제한 인원수
//		int[][] hotel = new int[5][7];
//		Random r = new Random();//랜덤 입력 시
////		Scanner sc = new Scanner(System.in);//scanner 입력 시
//		for(int i=0;i<5;i++)
//		{
//			for(int j=0;j<7;j++)
//			{
//				hotel[i][j]=r.nextInt(max+1);//랜덤 입력 시, 아래는 직접 입력 시 
////				System.out.println((i+1)+"층 "+(j+1)+"호실의 인원수를 입력하세요:");
////				hotel[i][j]=sc.nextInt();
////				sc.nextLine();
//				
////				System.out.println(i+","+j+":"+hotel[i][j]);//정상 입력 확인하기 위한 부분
//			}
//		}
//		
//		for(int i=0;i<5;i++)
//		{
//			fSum=0;
//			for(int j=i;j<7;j++)
//				fSum+=hotel[i][j];
//			double avg = fSum/7;
////			System.out.println((i+1)+"층의 평균 투숙객은 "+fSum/7+"명 입니다.");
//			System.out.printf("%d층의 평균 투숙객은 %.2f명 입니다.\n",i+1,avg);
//			aSum+=fSum;
//		}
//		System.out.println("호텔의 전체 투숙객은 "+aSum+"명 입니다.");
//	}
//	//1차원과 2차원의 혼합방식
//	//다음과 같은 성적이 있습니다. 이름은 1차원 배열로 하고, 데이터는 2차원 배열로 합니다.
//	//총점과 평균을 구하여 출력하세요
//	//[data]
//	//기섭, 은지, 홍수
//	//90,	90	90
//	//80	85	75
//	//70	60	90
//	{
////		String[] name= {"기섭","은지","흥수"};
////		int[][] score = {{90,90,90},{80,85,75},{70,60,90}};
//		int sum,aSum=0,people=3,sub=3;
//		String[] subject= {"국어","영어","수학"};
//		String[] name= new String[people];
//		int[][] score = new int[sub][people];
//		
//		Scanner sc= new Scanner(System.in);
//		for(int i=0;i<score.length;i++)
//		{
//			System.out.println("학생의 이름을 입력해 주세요:");
//			name[i]=sc.nextLine();
//			System.out.println(name[i]+"의 점수를 입력받습니다.");
//			for(int j=0;j<score[i].length;j++)
//			{
//				System.out.println(subject[j]+"과목의 점수를 입력해주세요:");
//				score[i][j]=sc.nextInt();
//				sc.nextLine();
//			}
//			System.out.println(name[i]+"의 점수입력이 완료되었습니다.");
//		}
////		for(int i=0;i<score.length;i++)
////		{
////			sum=0;
////			for(int j=0;j<score[i].length;j++)
////			{
////				sum+=score[i][j];
////			}
////			System.out.println((i+1)+"과목의 평균:"+sum/sub);
////			aSum+=sum;
////		}
////		System.out.println("총 평균:"+aSum/(sub*people));
//		
//		System.out.println("=====================================");
//		System.out.println("이름\t국어\t영어\t수학\t총합\t평균");
//		System.out.println("====================================");
//
//		for(int i=0;i<score.length;i++)
//		{
//			sum=0;
//			int jj=0;
//			for(int j=0;j<score[i].length;j++)
//			{
//				sum+=score[i][j];
//			}
//			aSum+=sum;
//			System.out.printf("%4s\t %3s\t %3s\t %3s\t %3d\t %3d\t",name[i],score[i][jj],score[i][jj+1],score[i][jj+2],sum,sum/people);
//			System.out.println();
//		}
//	}
	//3차원 배열 : 면 중심, 면, 행, 열 ex)주사위(6면,각 행과 열이 존재),대단위 아파트 단지
	{
	//2차원 배열이 3개가 존재합니다.
	//int [][][] sam= new int[3][2][4];
		
		int[][][] sam = {{{1,2,3,4},{3,4,5,6}},
						{{10,20,30,40},{5,7,9,11}},
						{{11,21,31,41},{51,71,91,11}}};
		
		for(int i=0;i<sam.length;i++) 
		{
			for(int j=0;j<sam[i].length;j++)
			{
				for(int k=0;k<sam[i][j].length;k++)
				{
					System.out.print("sam["+i+"]["+j+"]["+k+"]="+sam[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
		
		
	
	
	
	
			

			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
