package week1.day4;
//자주 쓰이는 패턴
//heap 메모리에 해당 클래스의 인스턴스가 단 하나만 존재하게 하는 것

public class Singleton {
	private Singleton() {}//인스턴스 생성 제한
	private static Singleton instance = null;
	public static synchronized Singleton getlnstance() {
		//동기화 블록,여러개의 쓰레드가 들어오지 못한다.단 하나의 쓰레드만 들어올 수 있다.
		if(instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
}
