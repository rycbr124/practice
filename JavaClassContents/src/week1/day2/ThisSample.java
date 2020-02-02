package week1.day2;

public class ThisSample {
	private int x;
	private static int y;
	
	//public void aaa(ThisSample this){
	public void aaa() {
		this.x=10;
		ThisSample.y=20;
	}

	//public void bbb(ThisSample this, int x, int y){
	public void bbb(int x,int y) {
		this.x=x;//멤버변수에 파라미터 변수 정보를 대입
		ThisSample.y=y;
	}
	
	//public static void ccc(){
	public static void ccc() {//static에는 this가 없다.
		//this.x //Error
		ThisSample.y=10;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
