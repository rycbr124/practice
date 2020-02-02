package week1.day3;

class InnerEx1 {
	int m=0;
	class InstanceInner{
		int i=m;//Outer의 멤버변수 접근가능
		int iv=100;
		//static int cv = 100; //에러! static 변수를 선언할 수 없다.
		final static int CONST = 100;//final static은 상수이므로 허용한다.
	}
	
	static class StaticInner{
		int iv=200;
		//int i=m; //error 발생
		static int cv=200; //static클래스만 static 멤버를 정의할 수 있다.
	}
	
	void myMethod() {
		class Locallnner{
			int iv=300;
			int t =m;//Outer의 멤버변수 접근가능.
			//static int cv=300;//에러! static 변수를 선언할 수 없다.
			final static int CONST = 300;//final static은 상수이므로 허용
		}
	}
	
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}

}
//내부클래스는 외부 클래스를 제외하고는 다른 클래스에서 잘 사용하지 않는 것이어야 한다.
