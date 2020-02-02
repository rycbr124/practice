package pr190711;
/*
•실습3: 다음을 만족하는 클래스를 작성

Parent, Child, Hobby, Tennis, Piano

Child c = new Child(“홍길동”);
Parent p = c;
c.setAge(30);

Tennis t = new Tennis();
Hobby b = t;
c.setHobby(t);

Piano p2 = new Piano();
Hobby b2 = p2;
c.setHobby(p2);

Child c2 = new Child(“홍길동”);
System.out.println(c); // 피아노
System.out.println(c.equals(c2));// true
 * */

class Parent{
	private String name,hobby;
	private int age;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	void setAge(int age) {
		this.age=age;
	}
	
	public int getAge() {
		return age;
	}
	
}

class Child extends Parent{
	private String name,hobby;
	private int age;
	private Hobby hob;
	
	Child(String name) {
		this.name=name;
	}
	
	public Hobby getHob() {
		return hob;
	}

	public void setHob(Hobby hob) {
		this.hob = hob;
	}

	public int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age=age;
	}
	
	void setHobby(Hobby hob) {
		this.hobby=hob.getHobby();
	}
	
	public String toString() {
		return this.hobby;
	}
	
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Child) {
			return name == ((Child)obj).name;
		}else {
			return false;
		}
	}

}

interface Hobby{

	String getHobby();
	
}

class Tennis implements Hobby{
	
	public String getHobby() {
		return "테니스";
	}

	
}

class Piano implements Hobby{

	public String getHobby() {
		return "피아노";
	}
	
}

public class Pr3 {

	public static void main(String[] args) {
		Child c = new Child("홍길동");
		Parent p = c;
		c.setAge(30);
		
		Tennis t = new Tennis();
		Hobby b = t;
		c.setHobby(t);

		Piano p2 = new Piano();
		Hobby b2 = p2;
		c.setHobby(p2);

		Child c2 = new Child("홍길동");
		
		System.out.println(c); // 피아노
		System.out.println(c.equals(c2));// true
	}

}
