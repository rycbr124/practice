package week1.day1;

import java.util.Scanner;

public class GradeCalcTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 = ");
		int kor = Integer.parseInt(scanner.nextLine());
		System.out.print("영어 = ");
		int eng = Integer.parseInt(scanner.nextLine());
		System.out.print("수학 = ");
		int math = Integer.parseInt(scanner.nextLine());
		
		int tot=kor+eng+math;
		double avg=tot/3;
		
		System.out.println();
		System.out.printf("총점:%d점%n",tot);
		System.out.printf("평균:%.2f점%n",avg);

	
	}

}
//%n will always output the correct line break depending on the platform while \n won't.