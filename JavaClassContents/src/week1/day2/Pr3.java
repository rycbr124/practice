package week1.day2;

//실습3:사칙연산
//-입력:
//A값:
//B값:
//연산자(+-*/):
//-출력: 결과=xxx
//*오류처리
//-연산자에 +-*/ 이외의 값이 입력 시 아래 메시지를 출력한다
//"잘못된 연산자를 입력하였습니다."

import java.util.Scanner;

public class Pr3 {

	public static void main(String[] args) {
		int a,b; //A,B값
		double res; //계산 결과
		String opr; //연산자
		
		Scanner sc = new Scanner(System.in);
		System.out.print("A값:");
		a=sc.nextInt();
		System.out.print("B값:");
		b=sc.nextInt();
		sc.nextLine();
		while(true){
			System.out.print("연산자(+,-,*,/):");
			opr=sc.nextLine();
			if(opr.equals("+")) {
				res=a+b;
				break;
			}else if(opr.equals("-")) {
				res=a-b;
				break;
			}else if(opr.equals("*")) {
				res=a*b;
				break;
			}else if(opr.equals("/")) {
				res=a/b;
				break;
			}else {
				System.out.println("잘못된 연산자를 입력하였습니다");
			}
		}
		System.out.printf("결과 = %.2f",res);

	}

}
