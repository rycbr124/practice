//package week2.day4;
//
//import java.util.ArrayList;
//
//
//
//class Juice{
//	String name;
//	
//	Juice(String name){
//		this.name=name+"Juice";
//	}
//	
//	public String toString() {
//		return name;
//	}
//	
//}
//
//class FruitBox<T extends Fruit> extends Box3<T>{}
//
//class Juicer{
//	
//	static Juice makeJuice(FruitBox<? extends Fruit>Box) {
//		String tmp="";
//		for(Fruit f : box.getList())
//			tmp+=f+" ";
//		return new Juice(tmp);
//		}
//}
//	
//class Box3<T>{
////	class FruitBox<T extends Fruit>{
//	ArrayList<T> list = new ArrayList<T>();
//	
//	void add(T item) {
//		list.add(item);
//	}
//	
//	T get(int i) {
//		return list.get(i); 
//	}
//	
//	ArrayList<T> getList(){
//		return list;
//	}
//	
//	int size() {
//		return list.size();
//	}
//	
//	public String toString() {
//		return list.toString();
//	}
//	
//}
//
//
//public class FruitBoxEx3 {
//
//	public static void main(String[] args) {
//		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
//		FruitBox<Apple> appleBox = new FruitBox<Apple>();
//		
//		fruitBox.add(new Apple());
//		fruitBox.add(new Grape());
//		appleBox.add(new Apple());
//		appleBox.add(new Apple());
//
//		System.out.println(Juicer.makeJuice(fruitBox));
//		System.out.println(Juicer.makeJuice(appleBox));
//	}
//
//}
