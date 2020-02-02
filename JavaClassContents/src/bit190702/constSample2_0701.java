package bit190702;

import java.util.Scanner;

/* 자동차 클래스가 있습니다.
 * 이 클래스에 색상과 가격을 입력하여 출력하세요. 단,생성자 이용하여.
 * 
 * 
 */
public class constSample2_0701 {
	//field Area:class variable,constructor,class method...
	static String carColor;//class variable
	static int carMoney;
	
	public constSample2_0701(String color, int money) {//생성자
		this.carColor=color;
		this.carMoney=money;
	}
	
	public static String Display() {//class variable(클래스변수)
		return "색상은 "+carColor + "이고, 가격은 "+carMoney+"입니다.";
	}

	public static void main(String[] args) {
		String color ;int money;
		Scanner sc=new Scanner(System.in);
		System.out.println("색상을 입력하세요:");
		color=sc.nextLine();
		System.out.println("가격을 입력하세요");
		money=sc.nextInt();
		constSample2_0701 cs2 = new constSample2_0701(color,money);
		System.out.println(cs2.Display());
		System.out.println(constSample2_0701.Display());//클래스명,클래스메소드
	}
	
}
