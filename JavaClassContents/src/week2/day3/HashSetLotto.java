package week2.day3;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetLotto {

	public static void main(String[] args) {
		Set set = new HashSet();
		
		//중복되는 값 안들어가게 set이 처리해준다
		for(int i=0; set.size()<6;i++) {
			int num=(int)(Math.random()*45)+1;
			set.add(new Integer(num));
		}
		
		List list = new LinkedList(set);
		Collections.sort(list);//Arrays와 거의 동일한 메소드 제공
		System.out.println(list);
	}

}
