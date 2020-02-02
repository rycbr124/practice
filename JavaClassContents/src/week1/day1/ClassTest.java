package week1.day1;

public class ClassTest  extends Object{
	private int[] sub;//Field
	private float avg;//Field
	
	public ClassTest() {//Construct
		sub=new int[4];
		avg=0.0f;
	}
	
	public void calc() {//메서드
		int tot=0;
		for(int a=0;a<sub.length;a++) {
			tot+=sub[a];
		}
		avg=tot/sub.length;
		
	}
	
	public static void main(String[] args) {
//		ClassTest_Inner in = new ClassTest_Inner();
//		ClassTest.ClassTest_Inner in = new ClassTest.ClassTest_Inner();
//		System.out.println(in.getSubname(2));
	}
	

	public static class ClassTest_Inner{//Nested class
		private String[] subname= {"국어","영어","수학"};//Field
		public String getSubname(int x) {//메서드
			return subname[x];
		}
	}
}

//내부클래스 참조

