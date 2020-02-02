package week1.day2;

//실습2:급여 계산하기
//-입력:기본급,직책(사원/대리/과장/부장)
//-출력:실수령액 = xxx원
//
//*계산식은 다음과 같다
//실수령액 = 기본급+직책수당-세금
//세금=기본급의 10%
//*직책 수당표
//-과장:200,000
//-부장:500,000

import java.util.Scanner;

public class Pr2 {

	public static void main(String[] args) {
		int nom,pMoney;//기본급,직책수당
		double tax,res;//세금,실수령액
		String pos;//직책
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("기본급을 입력해주세요 : ");
		nom=sc.nextInt();
		sc.nextLine();
		tax=nom*0.1;
		
		while(true)
		{
			System.out.print("직책을 입력해주세요(사원/대리/과장/부장):");
			pos=sc.nextLine();
			
			if(pos.equals("사원")){
				pMoney=0;
				break;
			}else if(pos.equals("대리")){
				pMoney=0;
				break;
			}else if(pos.equals("과장")){
				pMoney=200000;
				break;
			}else if(pos.equals("부장")){
				pMoney=500000;
				break;
			}else
				System.out.println("잘못 입력하셨습니다.");
		}
		res=nom+pMoney-tax;
		System.out.printf("실수령액 = %.0f원",res);
	}

}
