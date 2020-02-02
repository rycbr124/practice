package week2.day4;

import java.util.ArrayList;

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();

	void add(T item) {
		list.add(item);
	}

	T get(int i) {
		return list.get(i);
	}

	int size() {
		return list.size();
	}

	public String toString() {
		return list.toString();
	}
	
}

class Fruit {
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}

public class FruitBoxEx1 {

	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
		Box<Toy> toyBox2 = new Box<>(); //생성자 타입 생략가능(jdk1.7)
		//Box<Grape>grapeBox = new Box<Apple>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());// Apple은 Fruit의 자식
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		//appleBox.add(new Toy());  //에러
		
		toyBox.add(new Toy());
		//toyBox.add(new Apple());//에러

		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
		
		
		

	}

}
