package pr190801;
/*
* 실습: 도서관리
우리 도서관은 많은 책을 보유하고 있으며, 책을 대여하는 시스템을개발 중이다. 
우리는 많은 회원을 관리하고 있어, 회원을 관리한다.  회원은 이름, 연락처, 주소를 관리한다.  
대여한 책을 3일 이상 기한내에 반납하지 않은 회원은 불량회원으로 등록하여, 
1년동안 책을 대여해 주지 않는 패널티 조항이 있다. 따라서 회원의 불량 여부를관리하며, 
불량회원일 경우 최종 불량회원 등록일자를 관리한다.

우리는 많은 책을 보유하고 있다. 도서명, 출판사, 출판일자, 우리도서관납품일자를 관리한다. 
회원은 도서를 대여할 수 있으며, 한번에 여러 권을 대여할 수있으며, 도서별로 반납예정일자가 다를 수 있다.  
또한 회원의 실제 반납은 반납 예정일과 다를 수 있어 별도로 반납일자를관리해야 한다. 

우리는 도서관 운영비용을 회원의 회비와 도서대여료, 도서반납 연체료로운영을 한다.  
회원의 회비는 년간 1회 비용을 납입하며, 도서대여비는 대여할 때 일시불로 받는다.  그리고 도서반납연체료는 도서를
반납하는시점에 받는다. 

우리는 입금내역을 관리해야 한다.  입금번호, 입금일자, 금액을 관리한다.
입금내역은 어느 회원의 연회비인지 또는 어떤 대여비용인지,  어떤 도서의 연체료인지를 관리해야 한다.
 * */
import java.util.*;

public class Pr190801_2 {
	
	public static void main(String[] args) {
		
	}
	
}

class BudgetHistory{
	private Member member;//입금한사람
	private int inputNum;//입금번호
	private int fee;//입금액
	private String reason;//입금사유
	
	//생성자,getter,setter
}

class Library{
	private List<Member> members = new ArrayList<>();//회원목록
	private Map<Member,Date> badMembers = new TreeMap<>();//불량회원목록
	//key:멤버객체,value:최종 불량회원 등록일자
	private List<Book> books=new ArrayList<>();//소장중인 책 목록
	//key:도서관리번호,value 책정보
	private Map<Book,Date> rentBooks=new TreeMap<>();//대여중인 책 목록
	//key:도서관리번호,value 대여일
	private int budget;//도서관 운영비용
	private List<BudgetHistory> budgetHistory=new ArrayList<>();//입금내역 히스토리
	
	public static void init() {
		Library library = new Library();
		library.showMenu();
	}
	
//메뉴관련 메소드	
	private void showMenu() {
		/* 메뉴출력 메소드
		 * 메뉴를 입력받아 peopleManage(),bookManage() 호출
		 */
	}
	
	private void peopleManage() {
		/* 회원관련 메뉴 출력
		 * 메뉴를 입력받아 member관련 메소드 호출
		 */
	}
	
	private void bookManage() {
		/* 회원관련 메뉴 출력
		 * 메뉴를 입력받아 book관련 메소드 호출
		 */
	}
	
//member관련 메소드
	private void signUp(){
		//회원가입 메소드
	}

	private void Leave(){
		//회원탈퇴 메소드
	}

	private void rentBook() {
		/* 책 대여 메소드
		 * 대여하려는 member객체의 checkBad여부 확인
		 * checkBad시 불량회원 등록일자 확인
		 * 현재기준 1년경과시 불량회원 등록해제
		 * 대여하려는 책의 대출여부 확인후 안내
		 * 대여시 예산에 대여금액 추가,입금내역추가
		 */
	}
	
	private void retBook() {
		/*책 반납 메소드
		 * 대여일 확인 후 현재시간 기준 3일초과시 불량회원 등록
		 * 연체료 확인 후 예산에 추가,입금내역 추가
		 */
	}
	
	private void extendRent() {
		/* 대여일 연장 메소드
		 */
	}
	
	private void sendDuesMessage() {
		/* 회비안내 메세지 전송 메소드
		 * 모든 members의 연락처로 회비를 납부하라는 메세지를 전송
		 */
	}
	
//book관련 메소드	
	private void printBook() {
		/* 도서관에서 소장중인 책 목록을 출력
		 */
	}
	
	private void inputBook() {
		/* 도서관 소장 도서에 추가
		 * 
		 */
	}
	
	private void outBook() {
		/* 도서관 소장 도서에서 삭제
		 * 
		 */
	}
	
	private void changeBook(){
		/* 소장중인 책 정보 변경
		 * 
		 */
	}
	
	
}

class MemberRentHistory{
	private List<Book> books=new ArrayList<>();//대여했던 책정보
	private Date sDate;//대여일
	private Date eDate;//반납일,객체 생성기준 날짜입력
	
	//생성자,getter,setter

}

class Member{
	private String name;//성함
	private String address;//주소
	private int phoneNum;//연락처
	private boolean checkBad;//불량회원여부
	private Map<Book,Date> rentBooks = new TreeMap<>();//대여한 책 목록
	//key:책 객체,value:대여일
	private List<MemberRentHistory> history= new ArrayList<>();//대여이력
	
	//생성자,getter,setter

}

class Book{
	private String name;//도서명
	private String publisher;//출판사
	private Date pubDate;//출판일자
	private String number;//도서관리번호
	private Date inputDate;//우리도서관 납품일자
	
	//getter,setter
}


