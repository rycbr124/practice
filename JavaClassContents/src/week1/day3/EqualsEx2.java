package week1.day3;
//toString은 재정의

class Person2{
	long id;
	//Object의 equals를 Overriding
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Person2) {
			return id == ((Person2)obj).id;
			//obj가 Object타입이므로 id값을 참조하기 위해서는 Person타입으로 형변환이 필요하다.
		}else {
			return false;//타입이 Person2이 아니면 값을 비교할 필요도 없다.
		}
	}
	
	Person2(long id){
		this.id=id;
	}
}

public class EqualsEx2 {
	public static void main(String[] args) {
		Person2 p1 = new Person2(8011081111222L);
		Person2 p2 = new Person2(8011081111222L);

		if(p1==p2)//다르다
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
		
		if(p1.equals(p2))
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");

	}
}
