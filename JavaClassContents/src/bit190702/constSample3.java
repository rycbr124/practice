package bit190702;

import java.util.Scanner;

//문제] 책제목,저자,출판사,가격을 입력받아서 생성자로 전달하고 디스플레이에서 나타내라.
public class constSample3 {
	private String bName,wName,cName;
	private int price;
	
	private constSample3(String book, String name, String com, int money) {
		this.bName=book;
		this.wName=name;
		this.cName=com;
		this.price=money;
	}

	String Display() {//class variable(클래스변수)
		return "책 제목:"+bName+"\n저자:"+wName+"\n출판사:"+cName+"\n가격:"+price;
	}
	
	private void operation(int x) {
		int sum = price*x;
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		String book,name,com; int money,bookP;
		Scanner sc=new Scanner(System.in);
		System.out.println("책 제목,저자,출판사,가격을 입력하세요.");
		book=sc.next();
		name=sc.next();
		com=sc.next();
		money=sc.nextInt();
		System.out.println(book+","+name+","+com+","+money+"가 입력되었습니다.");
		constSample3 cs3 = new constSample3(book,name,com,money);
		System.out.println(cs3.Display());
		System.out.println("책값을 입력하세요:");
		bookP=sc.nextInt();
		cs3.operation(bookP);

	}

}
