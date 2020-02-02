package week1.prince;

import week1.president.Daujung;
import week1.president.Youngsam;

public class Hyunchul extends Youngsam{
	private int aa=70;
	int bb=70;
	protected int cc=70;
	public int dd = 70;
	
	public static void main(String[] args) {
		Hyunchul hc = new Hyunchul();//상속받은 클래스
		System.out.println(hc.c); System.out.println(hc.d);
		
		Daujung dj = new Daujung();//관계없는 클래스
		System.out.println(dj.d);
	}
}
