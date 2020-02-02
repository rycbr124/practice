package bit190705;
//추상 클래스(인터페이스와 역할이 비슷하다):abstract class A{}
//하나 이상의 추상 메소드가 있으면, 그 클래스는 추상 클래스이어야 합니다.
//추상메소드와 추상변수로 이루어진다.
//다른점: 객체를 절대로 생성할 수 없다.
//interface : implements

abstract class Shape{
	abstract void draw(); //설계만하고, 내용이 없습니다.있으면 오류.
}

class Rectangle extends Shape{//추상 클래스를 상속받은 곳에서 구현해야함.

	@Override//:추상 메소드 오버라이딩
	void draw() {
		System.out.println("1.사각형을 아주 멋지게 만듭니다.");
	}
	
}

class Circle extends Shape{

	@Override
	void draw() {
		System.out.println("2.원형을 아주 멋지게 만듭니다.");
		
	}
	
}

class Triangle extends Shape{

	@Override
	void draw() {
		System.out.println("3.삼각형을 아주 멋지게 만듭니다.");
		
	}

}

public class AbstractSample1 {

	public static void main(String[] args) {
//		Rectangle rt = new Rectangle();
//		Circle cc = new Circle();
//		Triangle tg = new Triangle();
//		rt.draw();
//		cc.draw();
//		tg.draw();
		
		Shape tt = new Triangle();
		tt.draw();
		
	}

}
