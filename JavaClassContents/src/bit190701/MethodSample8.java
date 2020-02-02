package bit190701;
/*
 * 문제]100과 200의 약수들의 합계,최대공약수를 구하여 출력하세요.
 * 단, 내부처리와 외부처리(Measure class)로 구분하여 합니다.
 * 약수:어떤 수로 나누어 떨어지는 정수.
	6>1,2,3,6=>12
 */

import java.util.Scanner;



public class MethodSample8 {

	
	public static int measure(int x){
		int sum=0;
		for(int i=1;i<=x;i++) {
			if(x%i==0)//100%1... 200%1...
			{
				System.out.println(i+"번째 약수="+i);
				sum+=i;
			}
		}
		return sum;
		
	}
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();//100
		int y = sc.nextInt();//200
//		
//		Measure ms = new Measure();
//		System.out.println(x+"의 약수들의 합은="+ms.measure(x));
//		System.out.println(y+"의 약수들의 합은="+ms.measure(y));
		int sum=measure(x);
		System.out.println(x +"약수들의 합은 = "+sum);
		int sum2=measure(y);
		System.out.println(y +"약수들의 합은 = "+sum2);
		
			
		
		
		
	}

}
