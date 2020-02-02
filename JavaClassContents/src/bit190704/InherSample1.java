package bit190704;

import javax.swing.plaf.synth.SynthSplitPaneUI;

/* 클래스:객체를 생성하여 만들기 위한 기준(틀).
 * 객체: 데이터를 처리하기 위한 틀
 * 메소드: 객체가 가지고 있는 데이터를 어떤 형태로 가공처리하기 위한 틀
 * 메소드오버로딩: 서로 다른 기능을 하지만, 이름은 반드시 메소드명이 같다.
 * 생성자: 클래스 단위에서 처리하는 데이터를 저장하여 초기화하는 역할.(클래스 변수)
 * 생성자 오버로딩: 서로 다른 기능을 하지만, 이름은 반드시 클래스명이 같다.
 * 상속: 부모클래스와 자식클래스간의 관계성, extends, implements(다중상속의 효과?)
 * public class A extends B{
 * public class A extends B implements C,D,E...{//C,D,E 인터페이스를 상속받아서 쓰겠다.
 * public interface A extends B
 * 메소드 오버라이딩: 두 클래스가 상속관계일떄, 메소드를 오버라이딩하여 사용할 수 있습니다.
 * 인터페이스를 이용하여 상속도 가능합니다.
 * 인터페이스
 * 추상클래스
 * 내부클래스
 * 다형성
 */

//class Parent{
//	//부모클래스
//	//1. 20000
//	static int dad;
//
//	Parent(){
//		
//	}
//	
//	Parent(int dad){
//		this.dad = dad;
//	}
//}
//
//
//class Child extends Parent{
//	static int mom;
//	int sum;
//	
//	public Child(int dad, int mom) {
//		super(dad);//super()->부모의 생성자
//		//부모의 클래스에 기본 생성자가 없을때 자식의 클래스에서 부모의 생성자를 호출하는 것
////		this.dad=dad;
//		this.mom=mom;
//	}
//	
//	public void add() {
//		sum=dad+mom;
//	}
//	
//	public void display() {
//		System.out.println("용돈의 합계: "+sum);
//	}
//	
//}


class Mother{
	
	static int mom;
	
//	Mother(){
//		
//	}
	
	Mother(int mom) {
		this.mom = mom;
	}	
}

class Father extends Mother{

	static int dad;
	int sum;
	
//	Father(){
//		
//	}
	
	Father(int dad) {
		super(mom);
		this.dad = dad;
	}
	
	void add() {
		sum = mom+dad;
	}
	
	void output() {
		System.out.println("용돈의 합계는 "+sum);
	}
}



public class InherSample1 extends Father{
	InherSample1(){
		super(dad);
		//father의 기본 생성자가 없다->초기화 작업이 안 된다->자식 메소드에서 직접 부모의 생성자를 호출
		//Father(int dad) 생성자를 호출하는 중이다.인자는 father의 dad.
	}
	public static void main(String[] args) {
	{	
	//1]엄마와 아빠의 용돈을 합산하여 출력하세요. 단 , 상속이용.	
//		Child c = new Child(20000,50000);
//		c.add();
//		c.display();
	//2]엄마(20000원),아빠(50000원)=70000원
		InherSample1 is1 = new InherSample1();
		Mother m = new Mother(50000);
		Father f = new Father(20000);
		is1.add();
		is1.output();
	}
	/* super:상위 클래스의 객체를 가리킨다.
	 * this:자기자신의 클래스의 객체를 가리킨다.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
