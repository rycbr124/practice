package week1.day5.exception;

public class ExceptionEx7 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);//실행되지 않는다
			//catch를 여러개 놓을 수 있다.
		}catch(ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				System.out.println("true");
			System.out.println("ArithmeticException");
			}
		}catch(Exception e) {
			//가장 넓은 범위의 예외
			System.out.println("Exception");
		} //try-catch의 끝
		System.out.println(6);
	}

}
