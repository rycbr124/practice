package pr190711;
/*
 •실습1: Father에 대한 클래스

- 속성:(String)name, (int)age, (String)job
- 메소드:
  void goToWork(int time): ‘출근하다’ 출력
  void goOffWork(int time): ‘퇴근하다’ 출력

위 클래스를 사용하여 출근하다, 퇴근하다를 출력해 보기
*/
import java.util.Scanner;

class Father{
	private String name,job;
	private int age;
	
	//속성에 대한 초기화는 반드시 해준다.(생성자로)
//	Father(){} Father(String name,String job,int age){}
	
	void goToWork(int time) {
		int hour,min;
		hour=time/100;
		min=time-(hour*100);
		
		System.out.printf("%02d : %02d에 출근하다.%n",hour,min);
	}
	
	void goOffWork(int time) {
		int hour,min;
		hour=time/100;
		min=time-(hour*100);
		
		System.out.printf("%02d : %02d에 퇴근하다.%n",hour,min);
	}
}

public class Pr1 {

	public static void main(String[] args) {
		int inTime,outTime;
		
		Scanner sc = new Scanner(System.in);
		Father f = new Father();
		System.out.print("출근 시간을 입력해주세요(ex0930) : ");
		inTime=sc.nextInt();
		sc.nextLine();
		System.out.print("퇴근 시간을 입력해주세요(ex1800) : ");
		outTime=sc.nextInt();
		
		f.goToWork(inTime);
		f.goOffWork(outTime);
	}

}
