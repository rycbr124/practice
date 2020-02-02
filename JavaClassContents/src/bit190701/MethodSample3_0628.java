package bit190701;
//전체 클래스에서 메인은 한 곳에만
//메인에서는 보통 호출만 한다.
//객체지향 프로그래밍
public class MethodSample3_0628 {

	public static void main(String[] args) {
		SummerSample_0628 ms = new SummerSample_0628();
		//ms객체가 번지수를 기억
		//object ms는 해당 클래스에 접근할 수 있다.
		ms.Summer5();
		

//		(Subtract에 return값이 있는 기준의 코드임,지금은 에러 발생)		
//		int sub = ms.Subtract();
//		//Summer클래스의 subtract메소드에서 받아온 값을 sub에 int형으로 받는다.(3유형)
//		System.out.println(sub);
	}

}
