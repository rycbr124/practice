package pr190724;
/*
1. ParkingLotAdm (주차장관리) 
- 속성: private Date startDt, private Date endDt, private final int maxCarsu
           private (?) cars, private (?) outCars, private (?) waitCars
- 생성자:
  ParkingLotAdm (Date statDt, Date endDt, int maxCarsu)
- 메소드
  public void addCar(Car car): 주차하는 차를 추가한다
  public int outCar(Car car): 나가는 차를 제거하면 outCars에 추가하고 주차비용을 리턴한다
                            주차비용은 30분당 500원 이다
                            주차대기중인 차가 있으면 주차시킨다(주차대기중인 차는 대기순서에 따라 주차)
  public void carSort(Comparator c): 파라미터로 전달한 정렬기준에 따라 주차차량을 Sort한다
  public Collection selectCheck(int hour): hour시간 이상 주차중인 차를 리턴한다
  public int getTotalFee(): 총 주차수수료 합을 리턴한다

2. Car
- 속성: private String carNo, private Date inDt(입차시간), private Date outDt(출차시간), private int fee
          private Date waitStrDt(대기시작시간)
 * */
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Pr190724 {
	
	public static void main(String[] args) {
		Car c1 = new Car("가1234",Utils.getDate(2019, 7, 25, 5, 10, 20),Utils.getDate(2019, 7, 25, 17, 19, 20),Utils.getDate(2019, 7, 25, 8, 11, 20));//x
		Car c2 = new Car("나1234",Utils.getDate(2019, 7, 25, 13, 10, 20),Utils.getDate(2019, 7, 25, 15, 55, 20),Utils.getDate(2019, 7, 25, 8, 11, 20));
		Car c3 = new Car("나1234",Utils.getDate(2019, 7, 25, 13, 10, 20),Utils.getDate(2019, 7, 25, 18, 19, 20),Utils.getDate(2019, 7, 25, 8, 11, 20));//x
		Car c4 = new Car("다1234",Utils.getDate(2019, 7, 25, 11, 11, 25),Utils.getDate(2019, 7, 25, 18, 11, 20),Utils.getDate(2019, 7, 25, 8, 11, 20));
		Car c5 = new Car("라1234",Utils.getDate(2019, 7, 25, 11, 12, 25),Utils.getDate(2019, 7, 25, 21, 11, 20),Utils.getDate(2019, 7, 25, 8, 11, 20));
		Car c6 = new Car("마1234",Utils.getDate(2019, 7, 25, 11, 10, 25),Utils.getDate(2019, 7, 25, 21, 11, 20),Utils.getDate(2019, 7, 25, 8, 11, 20));//x
		
		ParkingLotAdm park1 = new ParkingLotAdm(Utils.getDate(2019, 7, 25, 7, 00, 00),Utils.getDate(2019, 7, 25, 20, 00, 00),3);
		
		park1.addCar(c1);//오픈시간 이전(입고안됨)
		park1.addCar(c2);
		park1.addCar(c3);//c2와 동일차량(입고안됨)
		park1.addCar(c4);
		park1.addCar(c5);
		park1.addCar(c6);//주차장 만석(입고안됨)
		System.out.println(park1.getCars());
		System.out.println("=========================");
		System.out.println(park1.selectCheck(5));
		System.out.println("=========================");
		park1.carSort(new Compare1());
		System.out.println(park1.getCars());
		System.out.println("=========================");
		System.out.println("총 주차 금액 : "+park1.getTotalFee()+"원");
		System.out.println("=========================");
		int fee1=park1.outCar(c1);//입고되지 않은 차,0원 리턴
		int fee2=park1.outCar(c2);
		int fee3=park1.outCar(c4);
		int fee4=park1.outCar(c5);//주차장 폐점시간 지남,출차되지 않음.
		System.out.println(c1.getCarNo()+" : "+fee1+"\n"+c2.getCarNo()+" : "+fee2+"\n"+c4.getCarNo()+" : "+fee3+"\n"+c5.getCarNo()+" : "+fee4);
		System.out.println("=========================");
		System.out.println(park1.getCars());
		System.out.println("출차:"+park1.getOutCars());
		System.out.println("=========================");
		System.out.println("입차중인 차들의 총 요금 "+park1.getTotalFee()+"원");

	}
	
}

class ParkingLotAdm{
	private Date startDt;
	private Date endDt;
	private final int maxCarsu;
    private ArrayList<Car> cars=new ArrayList<>();
    private ArrayList<Car> outCars=new ArrayList<>();
    private Queue<Car> waitCars=new LinkedList<>(); //queue 활용
    
    
	ParkingLotAdm(Date startDt, Date endDt, int maxCarsu) {
		this.startDt = startDt;
		this.endDt = endDt;
		this.maxCarsu = maxCarsu;
	}
	
	public ArrayList<Car> getCars(){
		return this.cars;
	}
	
	public ArrayList<Car> getOutCars(){
		return this.outCars;
	}
	
	public void addCar(Car car){
		
		if(this.cars.size()>=this.maxCarsu) {
			System.out.println("주차장이 꽉 찼습니다. 대기차량으로 입고됩니다.");
			if(this.waitCars.contains(car)) {
				System.out.println("이미 대기차량목록에 존재합니다.");
			}else {
				this.waitCars.offer(car);
			}
		}else {
			if(this.cars.contains(car)) {
				System.out.println("이미 입고된 차량입니다.");
			}else {
				if(this.startDt.getTime()>car.getInDt().getTime()) {
					System.out.println("주차장 오픈시간이 아닙니다.");
				}else {
					this.cars.add(car);
				}
			}
		}
		
	}

	public int outCar(Car car){
//		: 나가는 차를 제거하면 outCars에 추가하고 주차비용을 리턴한다
//		주차비용은 30분당 500원 이다
//		주차대기중인 차가 있으면 주차시킨다(주차대기중인 차는 대기순서에 따라 주차)
		if(!(this.cars.contains(car))) {
			System.out.println("입고된 기록이 없는 차량입니다.");
			return 0;
		}
		
		if(this.endDt.getTime()<car.getOutDt().getTime()) {
			System.out.println("주차장 오픈 시간이 아닙니다.");
			return 0;
		}
		
		if(this.cars.remove(car)) {
			this.outCars.add(car);
			
			if( !(this.waitCars.isEmpty()) && this.cars.size()<this.maxCarsu ) {
				System.out.println("대기차량이 존재합니다. 자동으로 입고됩니다.");
				this.cars.add(this.waitCars.poll());
			}
			
			return car.setParkFee();
		}else {
			System.out.println("출차에 실패했습니다.");
			return 0;
		}
		
	}
	

	  public ArrayList<Car> selectCheck(int hour) {
//		  : hour시간 이상 주차중인 차를 리턴한다
		  ArrayList<Car> hourPark = new ArrayList<>();
		  
		  if(!(this.cars.isEmpty())) {
			  for(Car e : this.cars) {
				  long hourDiff=( e.getOutDt().getTime()-e.getInDt().getTime() )/(1000*60*60);
				  if( (int)hourDiff >= hour) {
					  hourPark.add(e);
				  }
			  }
		  }
		  
		  return hourPark;
	  }

	  public void carSort(Comparator c) {
//		  : 파라미터로 전달한 정렬기준에 따라 주차차량을 Sort한다
		  Collections.sort(this.cars,c);
	  }

	  
	  public int getTotalFee() {
//		  : 총 주차수수료 합을 리턴한다
		  if(this.cars.isEmpty()) {
			  return 0;
		  }else {
			  int totalFee=0;
			  for(Car e : this.cars) {
				  totalFee+=e.setParkFee();
			  }
			  return totalFee;
		  }
	  }
	
}

class Compare1 implements Comparator{
	
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Car && o2 instanceof Car) {
			Car c1 = (Car) o1;
			Car c2 = (Car) o2;
			return c1.compareTo(c2);
		}
		return -1;
	}

}

class Car implements Comparable<Car>{
	private String carNo;
	private Date inDt;
	private Date outDt;
	private int fee;
    private Date waitStrDt;
    
	Car(String carNo, Date inDt, Date outDt,Date waitStrDt) {
		this.carNo = carNo;
		this.inDt = inDt;
		this.outDt = outDt;
		this.waitStrDt = waitStrDt;
		this.fee=0;
	}
	
	int setParkFee() {
		Date d1 = this.inDt;
		Date d2 = this.outDt;
		long diff = d2.getTime()-d1.getTime();
		long min =diff/(1000*60);
		int fee=(( (int)min )/30)*500;
		this.fee=fee;
		return fee;
	}

	public int hashCode() {
		return Objects.hash(this.carNo);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			Car tmp = (Car)obj;
			return this.carNo.equals(tmp.carNo);
		}
		return false;

	}
	
	@Override
	public int compareTo(Car o) {
		return this.inDt.getTime()<o.getInDt().getTime() ? -1 : (this.inDt.getTime()==o.getInDt().getTime() ? 0 : 1);
	}
	
	String getCarNo() {
		return carNo;
	}

	void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	Date getInDt() {
		return inDt;
	}

	void setInDt(Date inDt) {
		this.inDt = inDt;
	}

	Date getOutDt() {
		return outDt;
	}

	void setOutDt(Date outDt) {
		this.outDt = outDt;
	}

	int getFee() {
		return fee;
	}

	void setFee(int fee) {
		this.fee = fee;
	}

	Date getWaitStrDt() {
		return waitStrDt;
	}

	void setWaitStrDt(Date waitStrDt) {
		this.waitStrDt = waitStrDt;
	}
    
	public String toString() {
		return this.getCarNo();
	}
	
}

class Utils{
	 public static Date getDate(int year, int month, int date, int hour, int minute, int second) {
	  Calendar cal = Calendar.getInstance();
	  cal.set(year, month-1, date, hour, minute, second);
	  cal.set(Calendar.MILLISECOND, 0);
	  
	  java.util.Date u = cal.getTime();
	  java.sql.Date s = new java.sql.Date(u.getTime());
//	  return cal.getTime();
	  return s;
	 } 
	 
	 public static String getDate(Date date) {
	  SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	  return format1.format(date);
	 }
	 
}
