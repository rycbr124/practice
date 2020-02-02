package bit190704;
//상속과 오버라이딩

//옛날 옛적에 스노우 타이어와 일반 타이어가 살았습니다.
//부모님은 스노우 타이어를 좋아하셨고,
//자식은 일반 타이어를 선호했습니다.

//추상메소드는 추상 클래스에서만 만들 수 있다.
//추상 클래스 안에는 추상 메소드와 fianl 변수가 있다.
//추상메소드는 body가 존재하지 않는다.
//	public abstract는 생략가능

class Par{
	String tire;

	
	public void Hi(String n) {
		System.out.println(n);
	}
	
	void run() {
		this.tire="스노우 타이어";
		System.out.println(tire);
	}
	void run2() {
	}
}

class I extends Par{
	//메소드 오버라이딩
	public void Hi() {
		System.out.println("EEEEE");
	}
	
	void run() {
		tire="일반 타이어";
		System.out.println(tire);	
	}
	//추상 메소드 오버라이딩
	public void run2() {
		int sum = 100+200;
		System.out.println(sum);//300
	}
	
	public void Hi(String name,int kor) {
		System.out.println();
	}
	
}


public class InherSample11 {

	public static void main(String[] args, Object k) {
//		Par p = new Par();
//		p.run();
		I i = new I();
		i.run();
		
//		c.Hi();
//		c.Hi("방가");
//		c.Hi(i,j,k);
		
	}

}
