package bit190701;
//전체 클래스에서 메인은 한 곳에만
//메인에서는 보통 호출만 한다.
public class MethodSample2_0628 {
	
	public static int Summer1(int x)//1번
	{
		int sum=0;
		for(int i=1;i<=x;i++)
		{
			sum+=i;
		}
		
		return sum;
	}
	
	public static void Summer2(int x)//2번
//static:다른 클래스에서 이 메소드를 사용할 수 있다.(참조가능)
	{
		int sum=0;
		for(int i=1;i<=x;i++)
		{
			sum+=i;
		}
		System.out.println("2.총 합:"+sum);
	}
	
	public static int Summer3()
	{
		int sum=0;
		for(int i=1;i<=100;i++)
		{
			sum+=i;
		}
		return sum;
	}
	
	public void Summer4()//4번
	{
		int sum=0;
		for(int i=1;i<=100;i++)
		{
			sum+=i;
		}
		System.out.println("3.총 합:"+sum);
	}

	public static void main(String[] args) {
	//1~100 사이의 합계를 구하는 프로그램을 작성(단, 메소드를 이용하여) 
	int result1;
		result1=Summer1(100);
		System.out.println("1.총 합:"+result1);
		
		Summer2(100);
		
		int result3 = Summer3();
		System.out.println("3.총 합:"+result3);
		
	//MethodSample2_0628라는 클래스에서 ms4라는 객체생성(클래스의 시작주소기억)
		MethodSample2_0628 ms = new MethodSample2_0628();
		ms.Summer4(); 
		//이 두 문장 없이 
		//Summer4();//로도 소환 가능하다.
		//위의 방법으로 사용 시 생성자를 활용할 수 있다.
		//아래의 방법으로 사용시 메소드가 static이 아니면 에러가 생긴다.
		//∵메모리 상의 번지(address)가 다르다,번지공유가 안 된다.
		
	}
}
