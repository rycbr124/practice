package bit190701;

import java.util.Scanner;

/* 현재까지 사용한 메소드는 사용자(개발자)정의 메소드<->내장 라이브러리(API)
 * 
 */
public class MethodSample9 {

//	void WhatNum(int x) {
//		if(x%2==0)
//			System.out.println("짝");
//		else
//			System.out.println("홀");
//	}
	//---------위풀이--아래정답---------------------
	static boolean isEven(int x)
	{
		if(x%2==0)//배수, 홀/짝수, 공약수...
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
	// 입력받은 숫자를 논리연산을 이용하여 홀수와 짝수로 구분하는 메소드를 만들어 출력하도록 합시다.
//		Scanner sc = new Scanner(System.in);
//		System.out.println("숫자를 입력해주세요:");
//		int x=sc.nextInt();
//		MethodSample9 ms9 = new MethodSample9();
//		ms9.WhatNum(x);
		//---------위풀이--아래정답-------------------
		String cha;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("홀/짝 판별기! 숫자를 입력하세요:");
		int num= sc.nextInt();
		
		if(num!=0)
		{
			if(isEven(num)==true)
				cha="짝수";
			else
				cha="홀수";
			System.out.println("입력한 숫자는 "+cha+"입니다.");
		}
	}

}
