package week2.day4;

interface Eatable{}

class Fruits implements Eatable{
	public String toString() {
		return "Fruit";
	}
}

class Apple2 extends Fruits {
	public String toString() {
		return "Apple";
	}
}

class Grape2 extends Fruits {
	public String toString() {
		return "Grape";
	}
}

class Toy2 {
	public String toString() {
		return "Toy";
	}
}


class FruitBoxes<T extends Fruits & Eatable> extends Box<T> {}

public class FruitBoxEx2 {

	public static void main(String[] args) {
		FruitBoxes<Fruits> fruitBox = new FruitBoxes<Fruits>();
		FruitBoxes<Apple2> appleBox = new FruitBoxes<Apple2>();
		FruitBoxes<Grape2> grapeBox = new FruitBoxes<Grape2>();
		//FruitBoxes<Grape2> grapeBoxes = new FruitBoxes<Apple2>();
		//FruitBoxes<Toy2> toyBox = new FruitBoxes<Toy2>();

		fruitBox.add(new Fruits());
		fruitBox.add(new Apple2());
		fruitBox.add(new Grape2());
		fruitBox.add(new Apple2());
		//appleBox.add(new Grape2());//에러
		grapeBox.add(new Grape2());
		
		System.out.println("fruitBox-"+fruitBox);
		System.out.println("appleBox-"+appleBox);
		System.out.println("grapeBox-"+grapeBox);
	}

}
