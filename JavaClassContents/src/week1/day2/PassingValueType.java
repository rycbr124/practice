package week1.day2;

//매개변수 뿐만 아니라 반환값도 참조형이 될 수 있다(주소값이 저장되는거라 내부적으로는 정수형의 데이터일 뿐이다)

class Box{
	public int x;
}

public class PassingValueType {

	public static void main(String[] args) {
		PassingValueType test = new PassingValueType();
		int iValue =1;
		System.out.println("test01 before:"+iValue);
		test.test01(iValue);
		//call by reference로 파라미터를 넘기는 언어에서는 2로 값이 변경된다.
		System.out.println("test01 after:"+iValue);
		
		Box box = new Box();
		System.out.println("test02 before:"+box.x);
		test.test02(box);
		System.out.println("test02 after:"+box.x);

		Box box2 = new Box();
		System.out.println("test03 before:"+box2.x);
		test.test03(box2);
		System.out.println("test03 after:"+box2.x);
		
		
		
		
	}

	void test01(int param) {
		param = 2;
	}
	void test02(Box box) {
		box = new Box();
		box.x=1;
	}
	void test03(Box box)//parameter로 받음 
	{
		box.x=1;//
	}
}

//자바(Java)에서는 언제나 Call by Value 방식으로 메소드를 호출한다. 그래서 메소드 내부에서 전달받은 파라미터를 수정하거나 해도 실제 변수에는 적용되지 않는다. 


