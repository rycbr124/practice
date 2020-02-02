package week1.day3;

class ConstructorTest {
	int a,b,c,d,e,f,g;
	ConstructorTest (){
		a=1; b=2; c=3; d=4; e=5; f=6; g=7;
	}
	ConstructorTest(int x){
		this();//생성자에서 다른 생성자 호출
		d=x;
		//this(); //=>error, 생성자 안에서 다른 생성자를 호출하려면 첫번째 라인에서 호출해야 한다.
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
	}
	ConstructorTest(int x,int y){
		this(x);
		e=y;//출력을 해주는 println이 위에서 호출한 생성자 안에 있다.
	}
	
	public static void main(String[] args) {
		ConstructorTest rEx = new ConstructorTest();
		ConstructorTest rEx2 = new ConstructorTest(5);
		ConstructorTest rEx3 = new ConstructorTest(5,2);
		
	}

}
