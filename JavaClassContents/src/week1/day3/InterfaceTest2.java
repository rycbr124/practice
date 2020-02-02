package week1.day3;

interface interA2{
	void aaa();//생략되었지만 public abstract 메서드이다.
	public abstract void bbb();
}

class interB2 implements interA2{

	@Override
	public void aaa() {//접근제한자의 범위가 상위 메소드보다 줄어들 수 없다.
		System.out.println("aaa 메서드");
	}

	@Override
	public void bbb() {
		System.out.println("bbb 메서드");
	}
	
}

public class InterfaceTest2 {

	public static void main(String[] args) {
		interB2 bp = new interB2();
		bp.aaa();
		bp.bbb();
	}

}
