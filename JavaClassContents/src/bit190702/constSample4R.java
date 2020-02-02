package bit190702;

class Account{

	int money;//1000=>3000=>6000=>5500
	
	public Account(int money) {//초기계좌개설
		this.money = money; //1000
	}

	public void deposit(int amount) {//저축입금 2000,3000
		if(amount>0)
		money+=amount; //6000
		
	}

	public void withdraw(int amount) {//출금 500
		if(amount >0 && money-amount>=0)
			money-=amount;//6000-500=5500
	}

	public double getMoney() {
		return money;//잔액반환
	}
	
}


public class constSample4R {

	public static void main(String[] args) {
	Account ac = new Account(1000);
	ac.deposit(2000);//입금
	ac.deposit(3000);
	ac.withdraw(500);//출금
	System.out.println(ac.money);//잔액 5500
	System.out.println(ac.getMoney());//잔액 5500(메소드 이용)
	}

}
