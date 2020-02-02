package week1.day2;

abstract class AnimalType{
	void bark() {};
}

class Dog extends AnimalType{

	public void bark() {
		System.out.println("Dog는 멍멍");
	}
}

class Cat extends AnimalType{

	public void bark() {
		System.out.println("Cat은 야옹");
	}
}

public class Animal {
	private AnimalType at;
	
	Animal(AnimalType at){
		this.at = at;
	}
	
	void bark() {
		at.bark();
	}
	
	
	public static void main(String[] args) {
		AnimalType at1 = new Dog();
		AnimalType at2 = new Cat();
		
		Animal an = new Animal(at1);
		Animal an2 = new Animal(at2);
		
		an.bark();
		an2.bark();
	}

}
