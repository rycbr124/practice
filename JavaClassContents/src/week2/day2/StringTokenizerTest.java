package week2.day2;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("This \t is a \n String");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("==========================");
		//인자로 주어진 문자열을 :을 구분자로서 구분한다.
		String str = "80::95::70";
		StringTokenizer st2 = new StringTokenizer(str,":",false);
		int i = 0;
		while(st2.hasMoreTokens()) {
			System.out.println(i+":"+st2.nextToken());
			i++;
		}
		System.out.println("==========================");
		//StringTokenizer는 구분자끼리 붙어 있는 경우 위와 같이 구분을 하지 못하는 문제가 있다.
		String[] result = str.split(":");
		for(int x =0; x<result.length;x++) {
			System.out.println(x+":"+result[x]);
		}
		System.out.println("==========================");
		//하지만 split도 마지막에 구분자가 있을 땐 이를 처리하지 못함=>2개의 인자를 받는 split 사용
		String str2 = "81-2-010-1234-5678-";
//		String[] arr2 = str2.split("-",5);//마지막원소:5678-
		String[] arr2 = str2.split("-",6);
		for(int x = 0; x<arr2.length;x++) {
			System.out.println(x+":"+arr2[x]);
		}
	}

}
