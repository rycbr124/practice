package week1.president;

import week1.prince.Hyunchul;

public class Daujung {
	private int a = 70;
	int b = 70;
	protected int c = 70;
	public int d = 70;
	
	public static void main(String[] args) {
		Daujung dj = new Daujung();
		System.out.println(dj.a); System.out.println(dj.b); System.out.println(dj.c); System.out.println(dj.d);
		dj.test();
		dj.test2();
		
		Youngsam ys = new Youngsam();//같은 패키지에 있는 클래스
		System.out.println(ys.b);System.out.println(ys.c);System.out.println(ys.d);
		
		Hyunchul h =new Hyunchul();
		System.out.println(h.c); System.out.println(h.d); System.out.println(h.dd);
	}

	private static void test() {}
	private void test2() {}
}
