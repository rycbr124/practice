package bit190704;
//오버라이딩 문
//책방에서 부모님은 3000원을 할인받고
//자식들은 3500원을 할인받습니다.
//이를 상속과 오버라이딩을 이용하여 처리하시오)
class BookPar{
	int bookPay;
	int disCo;
	
	public void price() {
		System.out.println("아버지가방에들어가신다.");
	}	
	void price(String name, int x) {
		System.out.println("당신은 " + name + "이므로 " + x + "원 입니다.");
	}
	
}

class Chd extends BookPar{
	void price(int x) {
		System.out.println("당신은 자식이므로" + x + "원 입니다.");//800
	}
	

}
public class InherSample12 {

	public static void main(String[] args) {
		Chd ch = new Chd();
		ch.price(3500);
//		ch.price();
//		ch.price("부모님", 3000);
		

	}

}
