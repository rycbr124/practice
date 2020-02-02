package week1.diagram;
interface Race{
	public String getRace();
}

public class Person implements Race{
	public String name ;int age;
	public Animal[] animal;
	
	
	public void Speak() {
	}
	
	public String getRace() {
		return null;
	}
	
}

class Animal{
	public String name,type;
}

class KoreanPerson extends Person{
	public void Speak() {
		
	}
}
class JapanPerson extends Person{
	public void Speak() {
		
	}
}
