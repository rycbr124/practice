/*
1. 실습1: Driver에 대한 클래스 
속성: private (String)name, private (int) licenceNo
          , private (HashMap)cars
          , private (Accident[]) history = new Accident[3]
- 생성자
   Driver(String name, int licenceNo)
- 메소드: 
   public void addCar(String carNo, String type, int volume): 소유자동차를 추가한다
              - carNo(차량번호), type(차종), volume(배기량)
              - carNo를 key로 HashMap에 추가한다
              - 동일한 자동차를 추가할 수 없다
              - HashMap에는 Key는 String, Value에는 Car class만 추가가능하다
   public void printCars(): 소유하고 있는 Car를 출력한다
              - carNo/type/volume를 출력한다
   public void addAccident(Accident): 사고이력을 추가한다
              - 사고이력 추가 시 Array size를 넘어설 경우 Array size를 2배로 늘려서 추가한다
              - 사고이력 추가 시 Car는 Driver가 소유하고 있는 Car만 추가가능 하다
   public void printAccident(): 사고이력을 출력한다
 Accident(사고이력) 클래스 
 속성: private (String) location(위치), private (String) date(사고일자)
           , private (Car) car(사고차량)
 생성자:
   Accident(Sting location, String date, Car car)
 메소드:
   get/set Method
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Objects;
import java.util.Set;



public class Pr190722 {
	
	public static void main(String[] args) {
		Driver d1 = new Driver("운전자1",123123);
		Car c2 = new Car("나3456", "람보르기니", 2000);
		Car c3 = new Car("나2222", "모닝", 2000);

		d1.addCar("가1234", "롤스로이스", 2000);
		d1.addCar("나3456", "람보르기니", 2000);
		d1.addCar("다6789", "페라리", 2000);
		d1.printCars();
		System.out.println("==================");
		d1.addAccident(new Accident("로터리","191110",c2));
		d1.addAccident(new Accident("로터리","191110",c3));
		System.out.println("===================");
		d1.printAccident();
		
	}
	
}

class Driver{
	private String name;
	private int licenseNo;
	private HashMap<String,Car> cars=new HashMap<String, Car>();
	private Accident[] history = new Accident[3];
	
	Driver(String name,int licenseNo) {
		this.name=name;
		this.licenseNo=licenseNo;
	}
	
	public void addCar(String carNo, String type, int volume) {
//		 : 소유자동차를 추가한다
//		 - carNo(차량번호), type(차종), volume(배기량)
//		 - carNo를 key로 HashMap에 추가한다
//		 - 동일한 자동차를 추가할 수 없다
//		 - HashMap에는 Key는 String, Value에는 Car class만 추가가능하다
		this.cars.put(carNo,new Car(carNo,type,volume));
	}
	
	public void printCars() {
//		: 소유하고 있는 Car를 출력한다
//		- carNo/type/volume를 출력한다
		Set<Entry<String, Car>> set = this.cars.entrySet();
		Iterator<Entry<String, Car>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String,Car> e = (Map.Entry<String, Car>)it.next();
			System.out.println(e.getValue());
		}
	}
	
	public void addAccident(Accident a) {
//		: 사고이력을 추가한다
//		- 사고이력 추가 시 Array size를 넘어설 경우 Array size를 2배로 늘려서 추가한다
//		- 사고이력 추가 시 Car는 Driver가 소유하고 있는 Car만 추가가능 하다
		  Car c = a.getCar();
		
		if(cars.containsValue(c)) {
//		if(this.cars.containsKey(a.getCar().getCarNo())) {
			ArrayList<Accident> ar = new ArrayList<Accident>(this.history.length);
			for(int i=0;i<this.history.length;i++) {
				if(this.history[i]!=null) {
					ar.add(this.history[i]);
				}
			}
			ar.add(a);
			Object[] temp = ar.toArray();
			this.history=new Accident[temp.length];
			for(int i=0;i<temp.length;i++) {
				this.history[i]=(Accident) temp[i];
			}
		}else {
			  System.out.println(c.getCarNo()+"는 차고에 없습니다.");
		}	
		
	}
	
	public void printAccident() {
		for(Accident a : this.history) {
			if(a==null) {
				continue;
			}else {
				System.out.println(a.getLocation()+"/"+a.getDate()+"/"+a.getCar().getCarNo());
			}
		}
	}
	
}


class Car{
	private String carNo;
	private String type;
	private int volume;
	
	Car(String carNo, String type, int volume) {
		this.carNo = carNo;
		this.type = type;
		this.volume = volume;
	}

	String getCarNo() {
		return carNo;
	}

	void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

	int getVolume() {
		return volume;
	}

	void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int hashCode() {
		return Objects.hash(this.carNo,this.type,this.volume);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			Car tmp = (Car)obj;
			return this.carNo.equals(tmp.carNo)
					&&this.type.equals(tmp.type)&&
					this.volume==tmp.volume;
		}
		return false;

	}
	
	public String toString() {
		return this.carNo+"/"+this.type+"/ "+this.volume;
	}
	
}

class Accident{
	private String location;
	private String date;
	private Car car;
	
	Accident(String location, String date, Car car) {
		this.location = location;
		this.date = date;
		this.car = car;
	}

	String getLocation() {
		return location;
	}

	void setLocation(String location) {
		this.location = location;
	}

	String getDate() {
		return date;
	}

	void setDate(String date) {
		this.date = date;
	}

	Car getCar() {
		return car;
	}

	void setCar(Car car) {
		this.car = car;
	}
	
	
	
}





