package week2.day5;

class User{
	private int userNo=0;
	
	//임계 영역을 지정하는 synchronized메소드
	//메소드 내 작업이 완료될 때 까지 다른 Thread가 들어올 수 없다.
	
	public synchronized void add(String name) {
		System.out.println(name+" : "+(userNo++)+"번째 사용");
	}

	//synchronized를 사용하지 않으면 잘못된 계산값이 출력된다.
//	public void add(String name) {
//		System.out.println(name+" : "+(userNo++)+"번째 사용");
//	}
}

class UserThread extends Thread{
	User user;
	
	UserThread(User user,String name){
		super(name);
		this.user=user;
	}
	
	public void run() {
		try {
			for(int i=0;i<3;i++) {
				user.add(getName());
				sleep(500);
			}
		}catch(InterruptedException e) {
			System.err.print(e.getMessage());
		}
	}
}

public class SyncThread {

	public static void main(String[] args) {
		User user = new User();
		
		//3개의 스레드 객체 생성
		UserThread p1 = new UserThread(user,"A1");
		UserThread p2 = new UserThread(user,"B2");
		UserThread p3 = new UserThread(user,"C3");
		
		//스레드 스케줄링 : 우선순위 부여
		p1.setPriority(p1.MAX_PRIORITY);
		p2.setPriority(p2.NORM_PRIORITY);
		p3.setPriority(p3.MIN_PRIORITY);
		
		System.out.println("----------------");
		System.out.println("synchronized");
		System.out.println("----------------");

		//스레드 시작
		p1.start();
		p2.start();
		p3.start();
	}

}
