package week2.day4;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student implements Comparable{
	String name;
	int score;

	public Student(String name,int score) {
		this.name=name;
		this.score=score;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int compareTo(Object s) {
		if(this.score<((Student)s).getScore()) {
			return -1;
		}else if(this.score>((Student)s).getScore()) {
			return 1;
		}
		return 0;
	}
}

class Student2{
	int rollno;
	String name,address;
	
	public Student2(int rollno,String name,String address) {
		this.rollno=rollno;
		this.name=name;
		this.address=address;
	}
	
	public String toString() {
		return this.rollno + " "+this.name + " "+this.address;
	}
}

class Sortbyroll implements Comparator <Student2>{

	@Override
	public int compare(Student2 a, Student2 b) {
		return a.rollno - b.rollno;
	}
}

public class StudentTest {
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add(new Student("a",5));
		list.add(new Student("b",10));
		list.add(new Student("c",1));
		list.add(new Student("d",52));
		list.add(new Student("e",23));
		
		Collections.sort(list);

		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(((Student)it.next()).getScore());
		}
		System.out.println("===========");
		ArrayList<Student2>ar = new ArrayList<Student2>();
		ar.add(new Student2(111,"bbbb","london"));
		ar.add(new Student2(131,"aaaa","nyc"));
		ar.add(new Student2(121,"cccc","jaipur"));
		
		System.out.println("Unsorted");
		for(int i=0; i<ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		
		Collections.sort(ar, new Sortbyroll());
		
		System.out.println("\nSorted by rollno");
		for(int i=0;i<ar.size();i++) {
			System.out.println(ar.get(i));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
