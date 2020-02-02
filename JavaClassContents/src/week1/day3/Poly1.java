package week1.day3;

class Parent {
		public int a = 100;
		public int getA() {
			return this.a;
		}
}

class Child extends Parent{
	public int a = 200;
	
	public int getA() {
		return this.a;
	}
}

public class Poly1{
	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.a);
		System.out.println(p.getA());
	}
}