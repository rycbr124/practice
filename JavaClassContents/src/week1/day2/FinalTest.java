package week1.day2;

final class Human{
	public void pro() {
		System.out.println("pro");
	}
}
//에러,final 상속 안 됨
//class Student extends Human{
//	public void info() {
//		System.out.println("info");
//	}
//}

class Student{
	public void info() {
		System.out.println("info");
	}
}

public class FinalTest {

	public static void main(String[] args) {
		Student s = new Student();
		s.info();
		//s.pro();
	}

}
