package pr190801;

//- 공연은 하루에 한 번 있다.
//- 좌석은 S석, A석,B석으로나뉘며,각각 10개의 좌석이 있다.
//- 예약 시스템의 메뉴는 "예약", "조회", "취소", "끝내기"가 있다.
//- 예약은 한 자리만 가능하고, 좌석 타입, 예약자 이름, 좌석 번호를 순서대로 입력받아 예약한다.
//- 조회는 모든 좌석을 출력한다.
//- 취소는 예약자의 이름을 입력받아 취소한다.
//- 없는 이름, 없는 번호, 없는 메뉴, 잘못된 취소 등에 대해서 오류 메시지를 출력하고 사용자가 다시시도하도록 한다.

import java.sql.Date;
import java.util.*;




public class Pr190801 {

	public static void main(String[] args) {
		ConcertControl c = new ConcertControl();
		c.showMenu();
	}

}

class ConcertControl{
	private ArrayList<Booker> bookers=new ArrayList<>();//모든 예약자 정보
	private int maxBooker=30;//좌석수
	private int maxGrade=10;//등급별 최대 좌석수
	private String[] seatGrade= {"S","A","B"};//좌석등급
	
	//존재하는 좌석등급이면 true, 아니면 false 리턴
	boolean isGrade(String s) {
		for(String e : this.seatGrade) {
			if(s.equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	//등급별 제한수 체크 메소드
	//해당 등급의 좌석이 다 찼으면 true, 아니면 false를 리턴
	boolean isGradeMax(String s) {
		int countCheck=0;
		for(Booker b : this.bookers) {
			if(b.getsGrade().equals(s)) {
				countCheck++;
			}
		}
		
		if(countCheck>=this.maxGrade) {
			return true;
		}else {
			return false;
		}
	}
	
	//예매된 좌석이면 true,아니면 false 리턴
	boolean isDupSeat(int s) {
		for(Booker b : this.bookers) {
			if(b.getsNum()==s) {
				return true;
			}
		}
		return false;
	}
	
	//입력값 재확인 메소드
	boolean checkValue(String grade,String name,int gradeNum,Scanner scan) {
		while(true) {
			System.out.println("이름 : "+name+
					"\n좌석등급 : "+grade+
					"\n좌석번호 : "+gradeNum);
			System.out.print("맞으면 1번,틀리면 2번을 입력해주세요 : ");
			try {
				int c = scan.nextInt(); scan.nextLine();				
				if(c==1) {return true;}
				else if(c==2) {return false;}
				else {System.out.println("잘못된 입력값입니다.");}
			}catch(Exception e) {
				System.out.println("잘못된 입력값입니다.");
				scan.nextLine();
				continue;
			}
		}
	} 
	
	void showMenu() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("====================");
			System.out.println("   명품콘서트홀 예약시스템    ");
			System.out.println("====================");
			System.out.print("1. 예약 2. 조회 3. 취소 4.끝내기 : ");
			
			int choice;
			try {
				choice = scan.nextInt(); scan.nextLine();
			}catch(Exception e) {
				System.out.println("잘못된 번호입니다.");
				if(e instanceof InputMismatchException) {
					scan.nextLine();
				}
				continue;
			}
			
			if (choice == 4) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			} else if (choice == 1) {
				if(makeReservation(scan)) 
					System.out.println("예약에 성공했습니다.");
				else
					System.out.println("예약에 실패했습니다.");
			} else if(choice == 2) {
				showReservation();
			}else if(choice == 3) {
				if(cancelReservation(scan)) 
					System.out.println("취소에 성공했습니다.");
				else
					System.out.println("취소에 실패했습니다.");
			}else{
				System.out.println("잘못된 번호입니다.");
			}
		}
		scan.close();
	}
	
	void showReservation() {
		if(this.bookers.isEmpty()) {
			System.out.println("예매내역이 없습니다.");
		}else {
			for(Booker e : this.bookers) {
				System.out.println(e);
				System.out.println();
			}
		}
	}
	
	boolean makeReservation(Scanner scan) {
		if(this.bookers.size()>=this.maxBooker) {
			System.out.println("모든 좌석이 다 찼습니다.");
			return false;
		}
		
		String grade,name; int gradeNum;
		while(true) {
			System.out.print("좌석의 등급을 입력해주세요 : ");
			grade=scan.nextLine();
			if(isGrade(grade) ) {
				if(isGradeMax(grade)) {
					System.out.println("해당 등급의 좌석이 다 찼습니다.");
				}else {
					break;
				}
			}
			else
				System.out.println("잘못된 입력값입니다.");
		}
		
		while(true) {
			System.out.print("예악자의 이름을 입력해주세요 : ");
			name=scan.nextLine();
			break;
		}
		
		while(true) {
			try {
				System.out.print("좌석번호를 입력해주세요 : ");
				gradeNum=scan.nextInt(); scan.nextLine();
				if(isDupSeat(gradeNum)) {
					System.out.println("이미 예매된 좌석입니다.");
					}
				else {break;}
			}catch(Exception e) {
				System.out.println("잘못된 입력값입니다.");
				scan.nextLine();
				continue;
			}
		}
		
		if(checkValue(grade,name,gradeNum,scan)) {
				Booker booker = new Booker(grade,name,gradeNum);
				return this.bookers.add(booker);
		}else {
			makeReservation(scan);
		}
		return true;
	}
	
	boolean cancelReservation(Scanner scan) {
		if(this.bookers.isEmpty()) {
			System.out.println("예매내역이 없습니다.");
			return false;
		}
		
		String name; ArrayList<Booker> result=new ArrayList<>();
		while(true) {
			System.out.print("취소하려는 예매내역의 예약자 성함을 입력해주세요 : ");
			name=scan.nextLine();
			
			for(Booker e : this.bookers) {
				if(e.getName().equals(name))
					result.add(e);
			}
			
			if(result.isEmpty()) {
				System.out.print("입력하신 성함 \""+name+"\"과 일치하는 예매내역이 없습니다.\n"
						+ "다시 입력하시려면 1번,메뉴로 돌아가려면 2번을 입력해주세요 : ");	
				try {
					int c=scan.nextInt(); scan.nextLine();
					if(c==1) continue;
					if(c==2) return false;
				}catch(Exception e) {
					System.out.println("잘못된 입력값입니다.");
					scan.nextLine();
					return false;
				}			
			}else{
				break;
			}
		}
		
		int resultIndex;
		if(result.size()==1) {
			resultIndex=0;
		}else {
			System.out.println("입력하신 성함과 일치하는 예매정보입니다.");
			for(int i=0;i<result.size();i++) {
				System.out.println((i+1)+"번");
				System.out.println(result.get(i));
			}
			while(true) {
				System.out.print("1~"+result.size()+"번 중에 취소하실 예매번호를 입력해주세요 : ");
				try {
					resultIndex=(scan.nextInt())-1; scan.nextLine();
					if(resultIndex<result.size())
						break;
					else 
						System.out.println("잘못된 입력값입니다.");
				}catch(Exception e) {
					System.out.println("잘못된 입력값입니다.");
					scan.nextLine();
					continue;
				}
			}
		}
		System.out.println("아래의 예매 내역이 취소됩니다.");
		Boolean checkCancel=checkValue(result.get(resultIndex).getsGrade()
														,result.get(resultIndex).getName()
														,result.get(resultIndex).getsNum(),scan);
		if(checkCancel) {
			return this.bookers.remove(result.get(resultIndex));
		}else {
			return false;
		}
	}
	
}

class Booker{
	private String sGrade;//좌석등급
	private String name;//예약자성함
	private int sNum;//좌석번호
	private Date c;//예약날짜
	
	Booker(String sGrade, String name, int sNum) {
		this.sGrade = sGrade;
		this.name = name;
		this.sNum = sNum;
		this.c = new Date(System.currentTimeMillis());
	}

	String getsGrade() {
		return sGrade;
	}

	void setsGrade(String sGrade) {
		this.sGrade = sGrade;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getsNum() {
		return sNum;
	}

	void setsNum(int sNum) {
		this.sNum = sNum;
	}
	
	public String toString() {
		return "예약자 이름 : "+this.getName()+"\n좌석등급 : "+this.getsGrade()+"\n좌석번호 : "+this.getsNum();
	}
	
	
	
	
	
}