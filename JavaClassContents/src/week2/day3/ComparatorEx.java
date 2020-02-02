package week2.day3;

import java.util.Arrays;
import java.util.Comparator;
//Comparable:기본 정렬기준이 되는 메소드
//Comparator:기본 정렬기준 외에 다른 기준
class Descending implements Comparator{
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2)*-1;
		}
		return -1;
	}

}

public class ComparatorEx {

	public static void main(String[] args) {
		String[] strArr = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(strArr);
		System.out.println("strArr="+Arrays.toString(strArr));
		Arrays.sort(strArr,String.CASE_INSENSITIVE_ORDER);
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());//역순 정렬
		System.out.println("strArr="+Arrays.toString(strArr));
	}
	

}
