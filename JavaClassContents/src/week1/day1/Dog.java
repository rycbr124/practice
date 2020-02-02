package week1.day1;

public class Dog {
	String name;//String의 초기값은 null이다.
	
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.bark();
		dog1.name="Bart";
		
		//Dog 배열을 만듭니다.
		Dog[] myDogs = new Dog[3];
		//개를 몇 마리 집어 넣습니다.
		myDogs[0]=new Dog();
		myDogs[1]=new Dog();
		myDogs[2]=dog1;
		
		//배열 레퍼런스를 써서 Dog객체에 접근합니다.
		myDogs[0].name="Fred";
		myDogs[1].name="Marge";
		
		
		System.out.println("마지막 개의 이름:");
		System.out.println(myDogs[2].name);
		
		int x=0;
		while(x<myDogs.length) {
			myDogs[x].bark();
			x=x+1;
		}
	}

	public void bark() {
//		this.name="";//name을 초기화해주고 있다.풀리면 공백 출력
		System.out.println(name+"이 왈! 하고 짖습니다.");
	}
	
	public void eat() {}

	public void chaseCat(){}
}
