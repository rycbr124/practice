package week1.day5;
//Math 내 모든 메서드는 static(Math.메소드() 소환)
//2개의 상수(static final)가 존재 E=2.17...; PI=3.1415..;

public class MathTest {

	public static void main(String[] args) {
		//static double abs(double a)
		//오버로딩 파라미터값: float,int,long
		//절대값 반환
		{
		int l = Math.abs(-10);//10
		double d = Math.abs(-10.0);//10.0
		System.out.println("1.Abs 메소드: "+l+" , "+d);
		}
		//static double ceil(double a)
		//주어진 값을 올림하여 반환한다.
		{
		double d = Math.ceil(10.1);//11.0
		double d2 = Math.ceil(-10.1);//-10.0
		double d3 = Math.ceil(10.000015);//11.0
		System.out.println("2.Ceil 메소드: "+d+","+d2+","+d3);
		}
		//static double floor(double a)
		//주어진 값을 버림하여 반환한다.
		{
		double d = Math.floor(10.8);//10.0
		double d2 = Math.floor(-10.8);//-11.0
		System.out.println("3.floor 메소드: "+d+","+d2);	
		}
		//static double max(double a, double b)
		//오버로딩 파라미터값: float,int,long
		//주어진 두 값을 비교하여 큰 쪽을 반환
		{
		double d = Math.max(9.5, 9.50001);//9.50001
		int i = Math.max(0, -1);//0
		System.out.println("4.max 메소드: "+d+","+i);
		}
		//static double min(double a, double b)
		//오버로딩 파라미터값: float,int,long
		//주어진 두 값을 비교하여 작은 쪽을 반환
		{
		double d = Math.min(9.5, 9.50001);//9.5
		int i = Math.min(0, -1);//-1
		System.out.println("5.min 메소드: "+d+","+i);
		}
		//static double random() //자주쓰임
		//0.0~1.0 범위의 임의의 double 반환
		{
		double d = Math.random();			//0.0<=d<1.0 값 출력
		int i = (int) (Math.random()*10)+1;//1<=j<11 출력
		System.out.printf("6.random 메소드: %.2f,%d\n",d,i);
		}
		System.out.println("===\t 1p \t===");
		//static double rint(double a) //많이는 안 쓰임
		//주어진 double 값과 가장 가까운 정수값을 double 형으로 반환한다
		{
		double d = Math.rint(5.5);//6.0
		double d2 = Math.rint(5.1);//5.0
		double d3 = Math.rint(-5.5);//-6.0
		double d4 = Math.rint(-5.1);//-5.0
		System.out.println("7.rint 메소드: "+d+","+d2+","+d3+","+d4);
		}
		//static long round(double a) //많이 쓰임
		//오버로딩 파라미터값:float
		//소수점 첫째자리에서 반올림한 long 값을 반환
		{
		long l = Math.round(5.5);//6
		long l2 = Math.round(5.11);//5
		long l3 = Math.round(-5.5);//-5
		long l4 = Math.round(-5.1);//-5
		double d = 90.7552;
		double d2 = Math.round(d*100)/100.0;//90.76
		//소수점 n째자리 까지 반올림하기
		//d*100=9075.52//소수점 둘째자리까지 보존. 이후 round실행
		//(9075.52/100.0)=90.75 //보존한 소수점 되돌리기.
		System.out.println("8.round 메소드: "+l+","+l2+","+l3+","+l4+","+d2);
		}

	}

}
