package week1.day2;

public class StaticTest {
	private static int x;
	
	static {
		System.out.println("Static...");
		x=0;
	}
	
	public static void Test() {
		System.out.println("Test...");
	}
	
	public StaticTest(String arg) {
		System.out.println("생성자"+arg);
	}
	
	public static void main(String[] args) {
		System.out.println("Main..");
		StaticTest st = new StaticTest("1");
		StaticTest st2 = new StaticTest("2");
		StaticTest st3 = new StaticTest("3");
	}

}
