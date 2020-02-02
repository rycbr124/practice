package bit190703.Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* 배열(array):상당히 많은 자료들의 집합.
 * 1,2,3 차원 배열이 존재합니다.
 * 1차원[]: 점의 집합 : 소량의 데이터,행과 열이 같은 개념.
 * 2차원[][m]: 선의 집합 : 관리비, 다량의 데이터,행과 열이 별도로 존재.
 * 3차원[][][]: 면의 집합(GIS, 지리공간시스템 구축),대단위 데이터,면,행,열이 존재
 * 4차원: 시간과 공간
 * 
 * 자바는 행 중심 언어입니다.//※파이썬은 열 중심 언어
 * 
 */
public class arraySample1 {
	public static void main(String[] args) {
		//1차원 배열의 초기화
//		
//	//1.
//	{
//		String[] arr1 = new String[] {"data1","data2","data3","data4","data5"};
//		String data1 = arr1[0];//data1
//		String data2 = arr1[1];//data2
//		String data3 = arr1[2];//data3
//		String data4 = arr1[3];//data4
//		String data5 = arr1[4];//data5
//		int len1 = arr1.length;
//		System.out.println("data의 수량은="+len1);
//	}
//	//2.
//	{
//		String[] arr2 = new String[5];
//		arr2[0]="방가방가";
//		arr2[1]="20";
//		arr2[2]="30";
//		arr2[3]="40";
//		arr2[4]="50";
//		int len2 = arr2.length;
//		System.out.println("data의 수량은="+len2);
//		
//		for(int i=0;i<arr2.length;i++)
//		{
//			if(arr2[i] != null) 
//				System.out.println((i+1)+"번째 배열의 값은 ="+arr2[i]);
//		}System.out.println();
//	}
//	//3.연산
//	{
//		int num[] = new int[5];//초기화
//		int total=0;
//		
//		num[0]=100;//data input
//		num[1]=200;
//		num[2]=300;
//		num[3]=400;
//		num[4]=500;
//		
//		total = num[0]+num[1]+num[2]+num[3]+num[4];//숫자라서 계산 가능
//		System.out.println("1.num 배열의 총합은="+total);
//		
//		int[] arr3 = new int[] {10,30,25,7,4,6};
//		Arrays.sort(arr3);//오름차순
//		String one = Arrays.toString(arr3);
//		System.out.println(one);
//		
//		//int arr3= ArrayUtil.add(arr3,700);
//	}
//	//문제] 국어(100),영어(90),수학(90) 점수가 있습니다.
//	//이 점수를 입력하여 합계와 평균을 구하여 출력합니다.
//	{
//		int arr2[] = {100,90,90,100,100,95,96};
//		int sum=0;
//		
//		for(int i=0;i<arr2.length;i++)//i<=arr.length는 오류가 나온다∵배열 길이를 넘어섬
//			sum+=arr2[i];
//		System.out.println(sum);
//		System.out.println(sum/arr2.length);
//	}
//	//문제] 다음 데이터에서 짝수의 합과 평균을 구하세요.
//	{
//		System.out.println("=========");
//		int arr[] = {100,90,90,100,100,95,96};	
//		int sum=0,odd=0,oddCount = 0,even=0,evenCount=0;
//		for(int i=0;i<arr.length;i++)
//		{
////			if(arr[i]%2==0)
////			{
////				System.out.println(arr[i]);
////				sum+=arr[i];
////				count++;
////			}
//			if(arr[i]%2==0) {
//				even+=arr[i];
//				evenCount++;
//			}
//			else {
//				odd+=arr[i];
//				oddCount++;
//			}
//			
//		}
//		int avg=even/evenCount;
//		System.out.println("짝수의 합계 :"+even);
//		System.out.println("짝수의 평균 :"+avg);
//	//문제]위 데이터에서 오름차순과 내림차순을 구하여 출력합니다.
//	//오름차순:Ascending,1,2,3,4,5,6  일반적 기본은 오름차순
//	//내림차순:Decending,6,5,4,3,2,1
//	//(method)
//		arraySample1 ar1 = new arraySample1();
//		ar1.ascending(arr);
//		for(int a=0;a<arr.length;a++)
//			System.out.println("오름차:"+arr[a]);
//		
//		int b[] =
//		arraySample1.decending(arr);
//		arr=b;
//		for(int i=0;i<arr.length;i++)
//			System.out.println("내림차:"+arr[i]);
//	}
//	//문제] 50~100사이의 난수를 발생하여 100개를 만들어서 배열에 저장하고, 정렬하세요.
//	//Random(),nextInt(),Math.randon()
//	{
//		int ranArr[]=new int[100];//100개를 저장할 수 있는 배열 준비
//		Random r= new Random();
//		
//		for(int i=0;i<ranArr.length;i++)
//			ranArr[i]=r.nextInt(50)+50;//난수 생성하여 배열에 저장
//		
//		for(int i=0;i<ranArr.length;i++)
//			System.out.print(ranArr[i]+"\t");//정렬 이전에 출력
//		System.out.println();
//		
//		Arrays.sort(ranArr);
//		System.out.println("정렬 이후에");
//		for(int i=0;i<ranArr.length;i++)
//			System.out.print(ranArr[i]+"  ");//정렬 이후에 출력
//		System.out.println();
//	}
//	//문제] 1차원 배열 int[5]선언이 되어 있습니다.
//	//음악[0],미술[1],체육[2]의 데이터를 입력받고, 총점과 평균을 구하여 배열에 저장하세요.
//	//비어있는 배열? [3], [4]
//	{
//		int music,art,health,sum,avg;
//		int arr[] = new int[5];
//		Scanner sc=new Scanner(System.in);
//		System.out.println("국,영,수 점수 입력:");
//		music=sc.nextInt();
//		art=sc.nextInt();
//		health=sc.nextInt();
//		sum=music+art+health;
//		avg=sum/3;
//		
//		arr[0]=music;
//		arr[1]=art;
//		arr[2]=health;
//		arr[3]=sum;
//		arr[4]=avg;
//		
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(arr[i]);
//		}
//	}

		
		
		
		

	
	
	
	
	
	
	
	
	
	
	}

	private static int[] decending(int a[]) {

		int j=0;
		int b[] = new int[a.length];
		for(int i =a.length-1;i>=0;i--)
		{
			b[j]=a[i];
			j++;
		}
//		for(int i=0;i<b.length;i++)
//			System.out.println(b[i]+"  ");
//		a=b;
		return b;
	}
	private int[] ascending(int a[]) {
		Arrays.sort(a);
		return a;
	}
	
	
	
//	private void decending2(int a[]) {
//		for(int i=a.length-1;i>-1;i--) {
//			System.out.println(a[i]+"");
//		}
//		System.out.println("]");
//	}	
//	private void ascending2(int a[]) {
//		for(int i=0;i<a.length;i++) {
//			System.out.println(a[i]+"");
//		}
//		System.out.println("]");
//	}
	

	
	

}
