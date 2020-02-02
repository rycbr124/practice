package bit190701;

public class SummerSample_0628 {

	public static int sum1;//변수만 공유 가능하게 빼내줄 수도 있다.
//(애매한 설명이니 다시 확인할 것)
	public static int sum2;
	
	public static void Summer5()//4번
	{
		int sum1=0;
		for(int i=1;i<=100;i++)
		{
			sum1+=i;
		}
		System.out.println("Summer5 총 합:"+sum1);
	}

	public static void Subtract() {
		int x = 500, y=300, sum2=0;
		sum2 = x-y;
		System.out.println("Summer5 총 합:"+sum2);
	}
}
