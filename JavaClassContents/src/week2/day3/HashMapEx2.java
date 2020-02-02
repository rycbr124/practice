package week2.day3;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx2 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", new Integer(90));
		map.put("김자바", new Integer(100));
		map.put("이자바", new Integer(100));
		map.put("강자바", new Integer(80));
		map.put("안자바", new Integer(90));

		Set set = map.entrySet();
		//map entry타입의 collection들을 set형태로 리턴
		//유일한 map entry 타입을 리턴?
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : "+e.getKey()+", 점수 : "+e.getValue());
			//하나의 entry=key+Value //Map=entry의 집합
		}
		set = map.keySet();//key만 묶어서 리턴
		System.out.println("참가자 명단 : "+set);
		
		Collection values = map.values();//value만 묶어서 리턴,중복가능
		it = values.iterator();
		
		int total=0;
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			total+=i.intValue();
		}
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+(float)total/set.size());
		System.out.println("최고점수 : "+Collections.max(values));
		System.out.println("최저점수 : "+Collections.min(values));
	}

}
