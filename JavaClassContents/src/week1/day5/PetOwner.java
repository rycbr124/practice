package week1.day5;

class Animal{
	public void makeNoise() {}

	public void eat() {}

	public void roam() {}
	
}

class Vet{
	public void giveShot(Animal a) {
		a.makeNoise();
	}
}

class Dog extends Animal{
	
	public void makeNoise() {
		System.out.println("개가 야옹 웁니다.");
	}
	
	public void eat() {
		System.out.println("개가 밥을 먹습니다.");
	}

	public void roam() {
		System.out.println("개가 주변을 어슬렁거립니다.");
	}
	
}

class Cat extends Animal{
	
	public void makeNoise() {
		System.out.println("고양이가 멍멍 웁니다.");
	}
	
	public void eat() {
		System.out.println("고양이가 밥을 먹습니다.");
	}

	public void roam() {
		System.out.println("고양이가 주변을 어슬렁거립니다.");
	}
	
}

class Wolf extends Animal{
	
	public void makeNoise() {
		System.out.println("늑대가 워우 웁니다");
	}
	
	public void eat() {
		System.out.println("늑대가 밥을 먹습니다.");
	}

	public void roam() {
		System.out.println("늑대가 주변을 어슬렁거립니다.");
	}
	
}

public class PetOwner {

	public void start(){
		Vet v = new Vet();
		Dog d= new Dog();
		Cat c = new Cat();
		v.giveShot(d);
		v.giveShot(c);
	}
	
	public static void main(String[] args) {
		PetOwner owner = new PetOwner();
		owner.start();
		Animal[] animals = new Animal[3];
		animals[0] = new Dog(); animals[1] = new Cat(); animals[2] = new Wolf();
		for(int i=0; i<animals.length;i++) {
			animals[i].eat();
			animals[i].roam();
		}
		
	}

}
