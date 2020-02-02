package pr190712;
/*
실습 2

책을 대여해주는 업체를 위한 Book이라는 클래스를 작성한다
Book는 관리자번호(number), 제목(title), 저자(author)를필드로 가진다
Book 클래스는 접근자(GetMethod)와 설정자(SetMethod)를 가진다.
Object클래스의 equals() 메소드를 재정의 해서 관리자 번호가 동일하면 동일한 책으로 간주한다.
Book으로부터 상속받은 Animation,Science 클래스를 작성한다
이들 클래스는 연체된 날짜에 따라서 연체료를 계산하는 getLateFee()메소드를 재정의한다. 
연체료는 Animation은 300원/일,Science는 200원/일 이다
클래스 Book, Animation, Science를 작성하라
 * */
import java.util.Scanner;

abstract class Book{
	private int number;
	private String title,author;
	
	Book(int number,String title,String author){
		this.number=number;
		this.title=title;
		this.author=author;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Book) {
			return this.number == ((Book)obj).number;
		}else {
			return false;
		}
	}
	
	abstract void setLateFee(int day);
	abstract int getLateFee();
	
}

class Animation extends Book{
	private int lateFee;
	
	Animation(int number,String title,String author){
		super(number,title,author);
	}
	
	void setLateFee(int day) {
		this.lateFee=300*day;
	}
	
	int getLateFee() {
		return this.lateFee;
	}

}

class Science extends Book{
	private int lateFee;
	
	Science(int number,String title,String author){
		super(number,title,author);
	}
	
	void setLateFee(int day) {
		this.lateFee=200*day;
	}
	
	int getLateFee() {
		return this.lateFee;
	}
	
}

public class Pr2 {

//	Book inputBook(int cho) {
//		Scanner sc = new Scanner(System.in);
//		int number,day; String name,author;
//		
//		System.out.print("책의 관리번호를 입력해주세요 : ");
//		number =sc.nextInt(); sc.nextLine();
//		System.out.print("책의 제목을 입력해주세요 : ");
//		name = sc.nextLine();
//		System.out.print("책의 저자를 입력해주세요 : ");
//		author = sc.nextLine();
//		System.out.print("연체 일자를 입력해주세요\n없으면 0을 입력해주세요 : ");
//		day = sc.nextInt(); sc.nextLine();
//		
//		if(cho==1) {
//			Book book = new Animation(number,name,author);
//			book.setLateFee(day);
//			return book;
//		}else {
//			Book book = new Science(number,name,author);
//			book.setLateFee(day);
//			return book;
//		}
//	}
	
	public static void main(String[] args) {
		int cho=0;//장르
		Book[] books;//책 클래스 인스턴스배열
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정보를 기입할 책의 권 수를 입력해주세요 : ");
		books = new Book[sc.nextInt()]; sc.nextLine();
		
		for(int i=0; i<books.length;i++) {
			while(true) {
				System.out.print("책의 종류를 입력해주세요.\n애니메이션=1 // 과학=2 :");
				cho = sc.nextInt(); sc.nextLine();
				
				if(cho==1 || cho==2) {
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
			
			int number,day; String name,author;
	
			System.out.print("책의 관리번호를 입력해주세요 : ");
			number=sc.nextInt(); sc.nextLine();
			System.out.print("책의 제목을 입력해주세요 : ");
			name = sc.nextLine();
			System.out.print("책의 저자를 입력해주세요 : ");
			author = sc.nextLine();
			System.out.print("연체 일자를 입력해주세요\n없으면 0을 입력해주세요 : ");
			day = sc.nextInt(); sc.nextLine();
			
			if(cho==1) {
				Book book = new Animation(number,name,author);
				book.setLateFee(day);
				books[i]=book;
			}else if(cho==2){
				Book book = new Science(number,name,author);
				book.setLateFee(day);
				books[i]=book;
			}
		}
		
		System.out.println("\n===\t출력결과\t===");
		for(int i=0;i<books.length;i++) {
			System.out.println("관리번호 \""+books[i].getNumber()+"\"책의 정보입니다.");
			System.out.println("제목 : "+books[i].getTitle()+"\n저자 : "+books[i].getAuthor()+"\n연체료 : "+books[i].getLateFee()+"원\n");
		}
		
//		for(int i=0;i<books.length;i++) {
//			for(int j=i+1;j<books.length;j++) {
//				if(books[i].equals(books[j])) {
//					System.out.println("관리번호가 중복됩니다.");
//				}
//			}
//		}
		

		
	}

}
