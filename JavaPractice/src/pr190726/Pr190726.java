package pr190726;
/*
* AutoFood에 대한 클래스
 - 속성: private int orderFoodNo, private Date orderDt
          , private LinkedList foods (주문음식), private ArrayList serviceFoods (제공된음식) 
- 생성자
   AutoFood(int orderFoodNo, Date orderDt)
- 메소드: 
   public void orderFood(Food f): 음식을 주문한다
                          주문 시 조리시간을 기준으로 정렬한다(조리시간이 짧은음식을 상위로)
                          주문된 음식유형(클래스)별로 총 주문 수량을 Count한다 
   public void printOrderFood(): 주문된 음식을 출력한다
   public void serviceFood(Food f): 주문음식에서 삭제하고 제공된 음식으로 이동시킨다
   public void printTotalCount(): 음식유형(클래스)별로 총 주문 수량을 출력한다

* Food(음식) 추상클래스 
 - 속성: private int foodNo(음식번호), private String foodNm(음식이름)
           private int time(조리시간)
- 생성자
   Food(int foodNo, String foodNm)
 - 메소드
   get/set Method

* Noodle(국수) 클래스  extends Food
* FriedRice(볶음밥) 클래스 extends Food
 * */
import java.sql.Date;
import java.util.*;



public class Pr190726 {
	
	public static void main(String[] args) {
		AutoFood food1 = new AutoFood(112233,Date.valueOf("2019-11-11"));
		Food f1 = new Noodle(1,"김치말이국수",20);
		Food f2 = new FriedRice(2,"계란볶음밥",10);
		Food f3 = new FriedRice(3,"멸치볶음밥",8);
		Food f4 = new Noodle(4,"우동",8);
		Food f5 = new Noodle(5,"쌀국수",8);
		Food f6 = new FriedRice(2,"계란볶음밥",10);

		
		food1.orderFood(f1);
		food1.orderFood(f2);
		food1.orderFood(f6);//중복,입력x
		food1.orderFood(f3);
		food1.orderFood(f4);
		food1.orderFood(f5);
		System.out.println("======================");
		food1.serviceFood(f5);
		food1.serviceFood(f3);
		System.out.println("======================");
		food1.printOrderFood();//우동(8분),계란볶음밥(10분),김치말이국수(20분) 순으로 출력
		System.out.println("==========================");
		food1.printTotalCount();
		}
		
}
	

class AutoFood{
	private int shopNo;
	private Date setupDt;
    private LinkedList<Food> foods=new LinkedList<>(); //(주문음식), 
    private ArrayList<Food> serviceFoods=new ArrayList<>(); //(제공된음식)
    private static int noodleCount,riceCount;
    
	AutoFood(int shopNo, Date setupDt) {
		this.shopNo = shopNo;
		this.setupDt = setupDt;
	}
	
	
	 public void orderFood(Food f) {
//		 : 음식을 주문한다
//		 주문 시 조리시간을 기준으로 정렬한다(조리시간이 짧은음식을 상위로)
//		 주문된 음식유형(클래스)별로 총 주문 수량을 Count한다
		if(this.foods.contains(f)) {
			System.out.println("이미 해당 주문이 입력되어 있습니다.");
		}else {
		 	if(this.foods.add(f)) {
				System.out.println("음식 주문이 완료되었습니다.");
				//정렬
				Collections.sort(this.foods);
				//주문수량 count
				countFood(f);
			}else {
				System.out.println("음식 주문에 실패했습니다.");
			}
		}
	 }
	
	public void serviceFood(Food f) {
//		: 주문음식에서 삭제하고 제공된 음식으로 이동시킨다
		if(this.foods.remove(f)) {
			System.out.println("주문된 음식이 제공됩니다.");
			delCountFood(f);
			this.serviceFoods.add(f);
		}else {
			System.out.println("음식 제공에 실패했습니다.");
		}
	}
	
	public void printOrderFood() {
//		: 주문된 음식을 출력한다
		Iterator<Food> it = this.foods.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void printTotalCount() {
//		: 음식유형(클래스)별로 총 주문 수량을 출력한다
		System.out.println("국수 "+noodleCount+"그릇");
		System.out.println("볶음밥 "+riceCount+"그릇");
		
//		Iterator<Food> it = this.foods.iterator();
//		int noodleCount=0,riceCount=0;
//		while(it.hasNext()) {
//			if(it.next() instanceof Noodle) {
//				noodleCount++;
//			}else if(it.next() instanceof FriedRice) {
//				riceCount++;
//			}
//		}
	}
	
	public void countFood(Food f) {
		if(f instanceof Noodle) {
			noodleCount++;
		}else if(f instanceof FriedRice) {
			riceCount++;
		}
	}
	
	public void delCountFood(Food f) {
		if(f instanceof Noodle) {
			noodleCount--;
		}else if(f instanceof FriedRice) {
			riceCount--;
		}
	}
	
}

abstract class Food implements Comparable<Food>{
	private int foodNo;//(음식번호), 
	private String foodNm;//(음식이름)
    private int time;//(조리시간)
    
    Food(int foodNo, String foodNm){
    	this.foodNo=foodNo;
    	this.foodNm=foodNm;
    }

	int getFoodNo() {
		return foodNo;
	}

	void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	String getFoodNm() {
		return foodNm;
	}

	void setFoodNm(String foodNm) {
		this.foodNm = foodNm;
	}

	int getTime() {
		return time;
	}

	void setTime(int time) {
		this.time = time;
	}
	
	public int hashCode() {
	return Objects.hash(this.foodNo,this.foodNm);
	}

	public boolean equals(Object obj) {
		if(obj instanceof Food) {
			Food tmp = (Food)obj;
			return this.foodNo==tmp.foodNo
					&&this.foodNm.equals(tmp.foodNm);
		}
		return false;
	}
	
	public String toString() {
		return "주문번호 "+String.valueOf(this.foodNo)+"번 : "+this.foodNm;
	}
	
	public abstract int compareTo(Food o);
	
}

class Noodle extends Food{

	Noodle(int foodNo, String foodNm,int time) {
		super(foodNo, foodNm);
		super.setTime(time);
	}

	@Override
	public int compareTo(Food o) {
		return super.getTime()<o.getTime() ? -1 : super.getTime()==o.getTime() ? 0 :1;
	}

	
}

class FriedRice extends Food{

	FriedRice(int foodNo, String foodNm,int time) {
		super(foodNo, foodNm);
		super.setTime(time);
	}

	@Override
	public int compareTo(Food o) {
		return super.getTime()<o.getTime() ? -1 : super.getTime()==o.getTime() ? 0 :1;
	}
	
}

