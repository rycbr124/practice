package week2.day4;

import java.util.HashSet;

public class SetTest {
	public static void main(String[] args) {
		HashSet set1 = new HashSet();
		set1.add("apple");
		set1.add("banana");
		System.out.println(set1.add("apple"));
		System.out.println("set1: "+set1);
		System.out.println("contains: "+set1.contains("apple"));
		//추가,삭제
		HashSet set2 = (HashSet) set1.clone();
		set2.add("melon");
		set2.remove("apple");
		System.out.println("set2: "+set2);
		//합집합,collection add 중복도지 않게 set2의 내용을 result에 add시킨다.
		HashSet result = (HashSet) set1.clone();
		result.addAll(set2);
		System.out.println("addAll: "+result);
		 //교집합
		result = (HashSet) set1.clone();
		System.out.println("result: "+result);
		result.retainAll(set2);
		System.out.println("retainsAll: "+result);
		//차집합, result값들 중 set2에 있는 값을 제거한다.
		result = (HashSet)set1.clone();
		result.removeAll(set2);
		System.out.println("removeAll:"+result);
		
	}
}
