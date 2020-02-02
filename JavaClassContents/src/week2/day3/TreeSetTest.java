package week2.day3;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

class Book implements Comparable{
	private String title;
	
	public Book(String t) {
		title=t;
	}
	

	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return title;
	}

	public int compareTo(Object obj) {
		Book book = (Book) obj;
		return title.compareTo(book.getTitle());
	}
	
}

class BookTwo{
	private String title;
	
	public BookTwo(String t) {
		title=t;
	}

	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return title;
	}
}

class BookCompare implements Comparator{
	public int compare(Object arg0,Object arg1) {
		return ((BookTwo)arg0).getTitle().compareTo(((BookTwo)arg1).getTitle());
	}
}

public class TreeSetTest {
	
	public void go() {
		//Comparable 이용
		Book b1 = new Book("How cats Work");
		Book b2 = new Book("Remix your Body");
		Book b3 = new Book("Finding Emo");
		
		TreeSet tree = new TreeSet();
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		//정렬되어 조회된다.
		System.out.println("1 :"+tree);
		
		BookTwo t1 = new BookTwo("How cats Work");
		BookTwo t2 = new BookTwo("Remix your Body");
		BookTwo t3 = new BookTwo("Finding Emo");
		
		TreeSet tree2= new TreeSet(new BookCompare());
		tree2.add(t1);
		tree2.add(t2);
		tree2.add(t3);
		//정렬되어 조회된다.
		System.out.println("2 :"+tree2);
		//첫번째값 조회
		System.out.println("3 :"+tree2.first());
		//마지막값 조회
		System.out.println("4 :"+tree2.last());
		//삭제
		System.out.println("5 :"+tree2.remove(new BookTwo("Finding Emo")));
		System.out.println("6 :"+tree2);
		tree2.add(t3);
		
		//인자보다 값이 작은 항목들의 집합
		SortedSet ss = tree2.headSet(new BookTwo("Remix your Body"));
		System.out.println("7 :"+ss);
		SortedSet ss2 = tree2.tailSet(new BookTwo("Finding Emo"));
		System.out.println("8 :"+ss2);
		//a이상~b미만 집합
		SortedSet ss3 = tree2.subSet(new BookTwo("Finding Emo"),new BookTwo("Remix your Body"));
		System.out.println("9 :"+ss3);
		TreeSet tree3 = (TreeSet) tree2.clone();
		System.out.println("10 :"+tree3);
	}
	
	public static void main(String[] args) {
		new TreeSetTest().go();
	}

}
