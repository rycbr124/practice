package week1.inherit;

class A{
	private int x = 100;
	private int y = 200;
}

class B extends A{
	private int r = 300;
}

public class InheritTest {

	public static void main(String[] args) {
		B bp = new B();
		//아무런 멤버에 접근할 수 없다.
	}

}
