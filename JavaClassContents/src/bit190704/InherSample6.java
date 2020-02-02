package bit190704;

import java.util.Scanner;

/* Car 클래스가 있는데, 이름과, 속도가 정의되어 있습니다.
 * 여기에, 또 다른 클래스를 이용하여 이름과 속도를 입력한 후 사용해 보세요.
 * Car : 버스, 트럭,
 * 
 */

class Car{
	String name;
	int speed;
}

//class Controller1 extends Car{
//	void speedCon(int speed){
//		super.speed=speed;
//	}
//	
//	void cName(String name) {
//		super.name=name;
//	}
//}

class Truck extends Car{
	String color;
	
	public int speed() {
		speed+=100;
		return speed;
	}
}

public class InherSample6 {

	public static void main(String[] args) {
//		Controller1 ct1 = new Controller1();
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("이름을 입력하세요:");
//		ct1.cName(sc.nextLine());
//		System.out.println("속도를 입력하세요:");
//		ct1.speedCon(sc.nextInt());
//		
//		
//		System.out.println("차종:"+ct1.name);
//		System.out.println("현재 속도는:"+ct1.speed);
		Truck tcar = new Truck();
		tcar.name = "현대자동차";
		tcar.speed = 350;
		tcar.color = "red";
		System.out.println(tcar.speed());
		
		System.out.println(tcar.name);
		System.out.println(tcar.speed);
		System.out.println(tcar.color);
		
		
		
	}

}
