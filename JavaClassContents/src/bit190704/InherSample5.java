package bit190704;
/* 할아버지는 수동 기어를 사용하시고
 * 아버지는 자동 기어를 사용하는데,
 * 나는 수동과 자동을 사용한다.
 */

class GrandF{
	String gear;
	String stick() {
		this.gear="수동";
		return gear;
	}
}

class MyFather extends GrandF{
	
	
	String automatic() {
		super.gear="자동";
		return gear;
	}
}

class Me extends MyFather{
	
	String stickAuto() {
		super.gear=stick()+","+automatic();
		return gear;
	}
	
}



public class InherSample5 {

	public static void main(String[] args) {
		Me m = new Me();
		System.out.println("할아버지의 기어는 "+m.stick());
		System.out.println("아빠의 기어는 "+m.automatic());
		System.out.println("나의 기어는 "+m.stickAuto());

	}

}
