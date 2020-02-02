package bit190702;

import java.util.Scanner;

//생성자 오버로딩
//인자형과 갯수에 따라서 구분합니다.

//문제]국어,영어,수학 점수,학점을 입력받아서, 처리하는데 오버로딩 방식으로 구현해 보세요.

class OverLoad{

	static int kor;//private:클래스 변수의 접근에 대한 해제.
	static double eng;
	static int math;
	static String hakjum;

	public OverLoad() {//default constructor
		
	}
	
	public OverLoad(int kor) {
		this.kor=kor;
	}
	
	public OverLoad( double eng) {
		this.eng=eng;

	}
	
	public OverLoad(int kor, double eng) {
		this.kor=kor;
		this.eng=eng;

	}
	
	public OverLoad(int kor,int math) {
		this.kor=kor;
		this.math=math;
	}
	
	public OverLoad(int kor, double eng, int math) {
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	public OverLoad(int kor, double eng, int math, String hakjum) {
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		this.hakjum=hakjum;
	}
	
}

class OverLoad2{
	int age; String name,address;
	public OverLoad2(String name, int age, String address) {
		this.name=name;
		this.age=age;
		this.address=address;
	}
	
	
}


public class constSample5 {

	public static void main(String[] args) {
	{
		Scanner sungjuk=new Scanner(System.in);
		int kor=sungjuk.nextInt();
		double eng=sungjuk.nextDouble();
		int math=sungjuk.nextInt();
		String hakjum=sungjuk.next();
		System.out.println(kor+","+eng+","+math+","+hakjum);
		
		OverLoad over1=new OverLoad();//sub class
		OverLoad over2=new OverLoad(kor); 
		OverLoad over3=new OverLoad(eng); 
		OverLoad over4=new OverLoad(kor,eng);
		OverLoad over5=new OverLoad(kor,math); 
		OverLoad over6=new OverLoad(kor,eng,math); 
		OverLoad over7=new OverLoad(kor,eng,math,hakjum); 
		
		System.out.println("=== 생성자 오버로딩 출력 ===");
		System.out.println("1.오브젝트를 이용한 출력"); //보편적으로 사용
		System.out.println("Over7에 대한 출력: ");
		System.out.println(over7.kor+"\n"+over7.eng+"\n"+over7.math+"\n"+over7.hakjum);
		System.out.println("2.클래스이름을 이용한 출력");
		System.out.println(OverLoad.kor);
		System.out.println(OverLoad.eng);
		System.out.println(OverLoad.math);
		System.out.println(OverLoad.hakjum);
	}
	//문제] 이름과 나이와 주소를 입력받아서, 생성자로 저장하고, 출력해 보세요.
	{
		String name,address;int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		name=sc.nextLine();
		System.out.println("나이를 입력하세요:");
		age=sc.nextInt();
		sc.nextLine();
		System.out.println("주소를 입력하세요:");
		address=sc.nextLine();
		
		OverLoad2 over=new OverLoad2(name,age,address);
		System.out.println("이름:"+over.name+"\n나이:"+over.age+"\n주소:"+address);
//		System.out.println(name+","+age+","+address);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
