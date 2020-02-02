package week1.day2;

class Employee{
	
//	Employee(){ //생략시 자동으로 기본형이 생성된다. 
//		System.out.println("나는 부모 constructor");
//	}
	
	Employee(int a){//생략 시 자동으로 기본형이 생성된다.
		System.out.println("나는 부모 constructor");
	}
}

class Manager extends Employee{
	Manager(){
		super(1);//생략시 자동으로 생성된다.
		//super();
		System.out.println("나는 자식 constructor");
	}
}

public class TestSuper {

	public static void main(String[] args) {
		Manager m = new Manager(); // constructor 라인 호출
	}

}
