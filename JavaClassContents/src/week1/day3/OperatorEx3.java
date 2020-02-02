package week1.day3;

public class OperatorEx3 {

	public static void main(String[] args) {
		int x = 15;
		System.out.println(10>x&&x++<20);//앞에가 false면 뒤는 실행안하고 false 출력
		System.out.println("x="+x);
		System.out.println(10<x||x++<20);
		System.out.println("x="+x);
		
		//Java에서는 비트 연산자를 논리 연산자로 사용이 가능합니다.
		System.out.println(10>x&x++<20);
		System.out.println("x="+x);
		System.out.println(10<x|x++<20);
		System.out.println("x="+x);
		
		//조건연산자 : 조건식? 식1 : 식2
		int y,z;
		int absX,absY,absZ;
		char signX,signY,signZ;
		x=10;
		y=-5;
		z=0;
		absX=x>=0?x:-x;
		absX=x>=0? y:-y;
		absX=x>=0? z:-z; 

	}

}
