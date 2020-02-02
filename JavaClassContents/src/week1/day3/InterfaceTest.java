package week1.day3;

interface interA1{
	int w=10;//무조건 public static final이다
	static int x =20;
	final int y=30;
	public static final int z=40;
}
public class InterfaceTest {
	public static void main(String[] args) {
//		interA1 ap = new interA1();
//		interA1.w = 100; //선언부에서는 생략되었지만 final이라 재정의 되지 않는다.
		System.out.println("w= "+interA1.w);//10
		System.out.println("x= "+interA1.x);//20
		System.out.println("y= "+interA1.y);//30
		System.out.println("z= "+interA1.z);//40

	}

}
