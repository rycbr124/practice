package week1.day4;
//인터페이스도 내부 클래스를 사용할 수 있다.
//내부 클래스의 인스턴스도 만들 수 있다.

interface A3{
	int x=100;
	public static class B3{
		private int y;
		public B3() {
			this.y=200;
		}
		public void disp() {
			System.out.println("x = "+x);
			System.out.println("y = "+y);
		}
	}
}

public class InterfaceTest3 {

	public static void main(String[] args) {
		A3.B3 bp = new A3.B3();
		bp.disp();
	}

}
