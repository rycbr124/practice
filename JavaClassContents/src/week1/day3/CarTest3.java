package week1.day3;

class Car {
	String color;//색상
	String gearType;//변속기 종류 - auto(자동),manual(수동)
	int door;//문의 개수

//	String[] allMember(){
//		String[] st = {color,gearType,Integer.toString(door)};
//		return st;
//	}
//	
//	boolean judge(Object obj) {
//		boolean result=false;
//		for(int i=0;i<allMember().length;i++)
//		{
//			if(allMember()[i].equals(((Car)obj).allMember()[i])) 
//				result=true;
//			else
//				result=false;
//		}
//		return result;
//	}
	
	Car(){
		this("white","auto",4);//다른 생성자를 호출,this로만 사용해야함
	}
	
	Car(Car c){ //인스턴스의 복사를 위한 생성자
		this(c.color, c.gearType, c.door);//아래와 동일한 코드.다른 생성자를 불러 와서 초기화했다.
//		color = c.color;
//		gearType = c.gearType;
//		door = c.door;
	}

	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;	
	}
	
	//equals를 door값을 비교해주도록 overriding
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Car) {
			return door==((Car)obj).door
					&& color==((Car)obj).color
					&& gearType==((Car)obj).gearType;//세가지 값을 비교해주려면
		}else {
			return false;
		}
		
	}
}


class CarTest3{
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(c1);//c1의 복사본 c2를 생성한다.
		System.out.println(c1.door);
		System.out.println(c2.door);
		System.out.println(c1.equals(c2));

	}
}
