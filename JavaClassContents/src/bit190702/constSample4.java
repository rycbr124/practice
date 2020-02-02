package bit190702;

import java.util.Scanner;

//문제]저축은행이 있습니다. 이 은행에 계좌를 계설하고, 저금을 합니다.
//1.계좌생성
//2.저축:1000+2000+3000 저축하기
//3.출금:500 출금하기
//4.잔액:5500
//5.입금액에 대한 체크,출금액도 체크.
//생성자 이용해서 코딩
class AccountPlay{
	
	static int accNum,accMoney;
	int money;
	
//	public constSample4() {
//		
//	}
	
	AccountPlay(){
		
	}
	
	public AccountPlay(int x,int y) {
		this.accNum=x;
		this.money=y;
	}
	
	void newAcc() {
		System.out.println(accNum+"이 개설되었습니다.");
	}
	
	void inMoney() {
		if(money<=0)
		{
			System.out.println("잘못된 금액을 입력하셨습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		else
		{
			accMoney+=money;
			System.out.println(money+"원이 입금되었습니다.");
		}
	}
	
	void outMoney() {
		if(accMoney<money || money<0)
		{
			System.out.println("잔액이 부족하거나 잘못된 금액입니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		else
		{
			accMoney-=money;
			System.out.println(money+"원이 출금되었습니다.");
		}
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
public class constSample4 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			AccountPlay.title();
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice==1)
			{
				System.out.println("생성할 계좌를 입력해주세요:");
				int count=sc.nextInt();
				AccountPlay cs4=new AccountPlay(count,0);
				System.out.println(cs4.accNum+"이 개설되었습니다.");
			}else if(choice==2)
			{
				System.out.print("예금할 금액을 입력해 주세요:");
				int money=sc.nextInt();
				AccountPlay cs4=new AccountPlay(AccountPlay.accNum,money);
				cs4.inMoney();
			}else if(choice==3)
			{
				System.out.print("출금할 금액을 입력해 주세요:");
				int money=sc.nextInt();
				AccountPlay cs4=new AccountPlay(AccountPlay.accNum,money);
				cs4.outMoney();
			}else if(choice==4)
			{
				System.out.println("현재 남은 잔액은"+AccountPlay.accMoney+"원 입니다.");
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
