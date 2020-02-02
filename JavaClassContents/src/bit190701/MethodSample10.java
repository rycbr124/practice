package bit190701;

import java.util.Scanner;

/*
 * 문제] 이름과 나이와 주소를 입력 받아서, 메소드 오버로딩을 이용하여 출력하세요.
 *
 */
public class MethodSample10 {
//field area
	private static void printInformation(String name) {
		System.out.print("이름은 "+name+"이고, ");
	}
	private static void prntInformation(int age) {
		// TODO Auto-generated method stub
		System.out.println("나이는 "+age+"살 입니다.");
	}
	private static void printInformation(String addr1,String addr2) {
		System.out.print("기본 주소는 "+addr1+", 상세주소는 "+addr2+" 입니다.");
	}
	
	public static void main(String[] args) {
		String name,address1,address2;int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("이름과 나이와 주소를 입력하세요:");
		name = sc.nextLine();
		age = sc.nextInt();
		sc.nextLine();
		
		address1=sc.nextLine();
		address2=sc.nextLine();
		
		printInformation(name);
		prntInformation(age);
		printInformation(address1,address2);
	}

}
