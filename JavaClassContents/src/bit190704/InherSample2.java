package bit190704;

import java.util.Scanner;

class Parent1{
	public void Plus(int su1, int su2) {
		int plus = su1+su2;
		System.out.println("1.더하기:"+plus);
		
	}
	
}

class Parent2 extends Parent1{
	public void Minus(int su1, int su2) {
		int minus = su1-su2;
		System.out.println("2.빼기:"+minus);
	}
	
}

class Parent3 extends Parent2{
	public void Multi(int su1, int su2) {
		int multi = su1*su2;
		System.out.println("3.곱하기:"+multi);
	}
	
}

class Parent4 extends Parent3{
	public void Div(int su1, int su2) {
		int div = su1/su2;
		System.out.println("4.나누기(몫):"+div);
	}
	
}

class Child extends Parent4{
	public void Div2(int su1, int su2) {
		int div2 = su1%su2;
		System.out.println("5.나누기(나머지):"+div2);
	}
	
}



public class InherSample2 {

	public static void main(String[] args) {
		//가감승제산을 상속을 이용하여 풀어보세요.
		//Child class, Parent1, Parent2, Parent3, Parent4
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("두 수를 입력하세요:");
			int su1 = sc.nextInt();
			int su2 = sc.nextInt();
			
			Child c = new Child();
			c.Plus(su1,su2);
			c.Minus(su1,su2);
			c.Multi(su1,su2);
			c.Div(su1,su2);
			c.Div2(su1,su2);
			
			sc.close();
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
