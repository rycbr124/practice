package week2.day3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class StackQueueEx {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList(); 
		//Queue 인터페이스의 구현체인 LinkedList를 사용
		
		//넣은 순서는 같아도 나온 순서는 다르다
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("=Stack=");//collection 전에 쓰던 자료구조
		while(!st.empty()) {				//isEmpty가 아님
			System.out.println(st.pop());
		}
		
		System.out.println("=Queue=");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
