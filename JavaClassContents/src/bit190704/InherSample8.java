package bit190704;

import java.util.Scanner;

/* 한국은행에 계좌를 개설하고 저축을 합니다.
 * 현재 입금된 금액은 0원입니다.
 * 저축을 하면서 상속을 이용하여 누적 금액을 알아보고, 입금 횟수를 카운트하여 출력해 보세요.
 * 단, 키보드로부터 입력을 받습니다.
 */
class CustomerInfo{
	int acNum,acMoney=0,count=0;
}

class HanBankSys extends CustomerInfo{
	
	void input(int money) {
		if(money<=0)
		{
			System.out.println("잘못된 금액을 입력하셨습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		else
		{
			acMoney+=money;
			count++;
			System.out.println(money+"원이 입금되었습니다.");
			System.out.println("누적금액은 "+super.acMoney+"원이고 입금 횟수는 "+count+"번 입니다.");
		}
	}

	public static void title() {
			System.out.println("---------------------------");
			System.out.println("1.계좌생성");
			System.out.println("2.예금");
			System.out.println("3.종료(Exit)");
			System.out.println("---------------------------");
			System.out.print("번호를 입력해주세요:");
			
		}

	public void newAcc(int count) {
		acNum=count;
		System.out.println(this.acNum+"이 개설되었습니다.");
	}
		
}
	


public class InherSample8 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	HanBankSys hs = new HanBankSys();
		while(true)
		{
			HanBankSys.title();
			int choice = sc.nextInt();
			sc.nextLine();
			
			if(choice==1)
			{
				System.out.println("생성할 계좌를 입력해주세요:");
				int count=sc.nextInt();
				sc.nextLine();
				hs.newAcc(count);
			}else if(choice==2)
			{
				System.out.print("예금할 금액을 입력해 주세요:");
				int money=sc.nextInt();
				sc.nextLine();
				hs.input(money);
			}else if(choice==3)
			{
//					System.out.println(AccountPlay.accNum);//계좌번호 정상 출력되는지 확인해보려고
				System.out.println("시스템을 종료합니다.");
				break;
			}else
			{
				System.out.println("잘못된 번호입니다. 다시 입력해 주세요.");
			}
		}
	
	
	
	
	
	
	}

}
