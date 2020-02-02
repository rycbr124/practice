package bit190704;

import java.util.Scanner;


/* 문제] 저축은행 상속
 * 
 */

class information{
	int accNum,accMoney;
}



class AccountPlay extends information{
	
	void newAcc(int a) {
		this.accNum=a;
		System.out.println(accNum+"이 개설되었습니다.");
	}
	
	void inMoney(int money) {
		if(money<=0)
		{
			System.out.println("잘못된 금액을 입력하셨습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		else
		{
			this.accMoney+=money;
			System.out.println(money+"원이 입금되었습니다.");
		}
	}
	
	void outMoney(int money) {
		if(this.accMoney<money || money<0)
		{
			System.out.println("잔액이 부족하거나 잘못된 금액입니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		else
		{
			this.accMoney-=money;
			System.out.println(money+"원이 출금되었습니다.");
		}
	}
	
	void showMoney() {
		System.out.println("현재 남은 잔액은"+this.accMoney+"원 입니다.");
	}
	
	static void title() {
		System.out.println("---------------------------");
		System.out.println("1.계좌생성");
		System.out.println("2.예금");
		System.out.println("3.출금 ");
		System.out.println("4.잔액조회 ");
		System.out.println("5.종료(Exit)");
		System.out.println("---------------------------");
		System.out.print("번호를 입력해주세요:");
		
	}
	
}
public class InherSample7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AccountPlay ap = new AccountPlay();//while문 안에 있으면 계속 인스턴스가 초기화된다
		while(true)
		{
			AccountPlay.title();
			int choice = sc.nextInt();
			sc.nextLine();
			
			if(choice==1)
			{
				System.out.println("생성할 계좌를 입력해주세요:");
				int count=sc.nextInt();
				sc.nextLine();
				ap.newAcc(count);
			}else if(choice==2)
			{
				System.out.print("예금할 금액을 입력해 주세요:");
				int money=sc.nextInt();
				sc.nextLine();
				ap.inMoney(money);
			}else if(choice==3)
			{
				System.out.print("출금할 금액을 입력해 주세요:");
				int money=sc.nextInt();
				sc.nextLine();
				ap.outMoney(money);
			}else if(choice==4)
			{
				ap.showMoney();
			}else if(choice==5)
			{
//				System.out.println(AccountPlay.accNum);//계좌번호 정상 출력되는지 확인해보려고
				System.out.println("시스템을 종료합니다.");
				break;
			}else
			{
				System.out.println("잘못된 번호입니다. 다시 입력해 주세요.");
			}
			
		}
		
		
		
	}

}
