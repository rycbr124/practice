package week2.day3;

import java.util.HashSet;
import java.util.Objects;

//equals와 hashCode를 하나라도 재정의하지 않으면 중복저장됨


class Person2{
	String name;
	int age;
	
	Person2(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name)&&age==tmp.age;
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(name,age);//같은 "객체" 내에서 유일한 hash값 리턴?
	}
	
	public String toString() {
		return name+";"+age;
	}
}

public class HashSetEx4 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10));
		set.add(new Person2("David",20));
		
		System.out.println(set);
	}

}
