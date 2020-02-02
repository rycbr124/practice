/*
1. Customer (고객)
- 속성: private String name, private int age, private int point
           , private ArrayList orders
- 생성자:
   Customer (Sting location, int age, int point)
2. SpecialCustomer extends Customer
- 속성: private int bonus
3. Order
- 속성: private int orderNo, private String product, private String orderDt
- 생성자:
   Order(int orderNo, String product, Date orderDt)
4. SpecialOrder extends Order
- 속성: private String gift(사은품)
---------------------------------------------
// Order 자식만 사용가능
Customer<Order> c1 = new Customer<>("홍길동", 30, 100);
Order o = new Order(1234, "정보보호론", "2019-07-01");
c1.addOrders(o);
// SpecialOrder만 선택가능
SpecialCustomer<SpecialOrder> c2 = new SpecialCustomer<>("김길동", 31, 150, 50);
SpecialOrder so = new SpecialOrder(1234, "정보보호론", "2019-07-01", "각티슈");
c2.addOrders(so);
ArrayList al = new ArrayList();
al.add(c1);
al.add(c2);
// Point로 Custoer 정렬, SpecialCustomer는 bonus를 더해준다
Collections.sort(al);
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Customer<T extends Order> implements Comparable<Customer>{
	
	private String name;
	private int age;
	private int point;
	private ArrayList<T> orders=new ArrayList<T>();
	
	Customer(String name, int age, int point) {
		this.name=name;
		this.age=age;
		this.point=point;
	}

	void addOrders(T o) {
		this.orders.add(o);
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	int getPoint() {
		return point;
	}

	void setPoint(int point) {
		this.point = point;
	}

	ArrayList<T> getOrders() {
		return orders;
	}

	void setOrders(ArrayList<T> orders) {
		this.orders = orders;
	}

	@Override
	public int compareTo(Customer o) {
		int thisPoint=this.point;
		int anotherPoint=o.point;
		
		if(o instanceof SpecialCustomer) {
			anotherPoint+=((SpecialCustomer) o).getBonus();
		}
		
		return thisPoint<anotherPoint ? -1 : (thisPoint==anotherPoint ? 0 :1);
	}
	
	public String toString() {
		return this.getName()+"의 포인트="+String.valueOf(this.getPoint());
	}
	
}

class SpecialCustomer<T extends SpecialOrder> extends Customer<T>{
	private int bonus;
	
	SpecialCustomer(String name, int age, int point,int bonus) {
		super(name, age, point);
		this.bonus=bonus;
	}

	int getBonus() {
		return bonus;
	}

	void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public int compareTo(Customer o) {
		int thisPoint=super.getPoint()+this.bonus;
		int anotherPoint=o.getPoint();
		
		if(o instanceof SpecialCustomer) {
			anotherPoint+=((SpecialCustomer) o).getBonus();
		}
		
		return thisPoint<anotherPoint ? -1 : (thisPoint==anotherPoint ? 0 :1);
	}
	
	public String toString() {
		return "스페셜 "+this.getName()+"의 포인트="+String.valueOf(super.getPoint()+this.getBonus());
	}
	
}

class Order{
	private int orderNo;
	private String product;
	private String orderDt;
	
	Order(int orderNo, String product, String orderDt) {
		this.orderNo = orderNo;
		this.product = product;
		this.orderDt = orderDt;
	}
	
	
}

class SpecialOrder extends Order{
	private String gift;

	SpecialOrder(int orderNo, String product, String orderDt,String gift) {
		super(orderNo, product, orderDt);
		this.gift=gift;
	}

	String getGift() {
		return gift;
	}

	void setGift(String gift) {
		this.gift = gift;
	}
	
}




public class Pr190723{

	public static void main(String[] args) {
		Customer<Order> c1 = new Customer<Order>("홍길동", 30, 100);
		Order o = new Order(1234, "정보보호론", "2019-07-01");
		c1.addOrders(o);
		
		SpecialCustomer<SpecialOrder> c2 = new SpecialCustomer<>("김길동", 31, 150, 50);
		SpecialOrder so = new SpecialOrder(1234, "정보보호론", "2019-07-01", "각티슈");
		c2.addOrders(so);
		
		SpecialCustomer<SpecialOrder> c3 = new SpecialCustomer<>("박길동", 31, 10, 50);
		SpecialOrder so2 = new SpecialOrder(1234, "정보보호론", "2019-07-01", "각티슈");
		c2.addOrders(so2);
		
		SpecialCustomer<SpecialOrder> c4 = new SpecialCustomer<>("심길동", 31, 170, 50);
		SpecialOrder so3 = new SpecialOrder(1234, "정보보호론", "2019-07-01", "각티슈");
		c2.addOrders(so3);
		
		Customer<Order> c5 = new Customer<>("백길동", 31, 120);
		SpecialOrder o2 = new SpecialOrder(1234, "정보보호론", "2019-07-01", "각티슈");
		c2.addOrders(o2);
		
		ArrayList al = new ArrayList();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		al.add(c4);
		al.add(c5);

		// Point로 Customer 정렬, SpecialCustomer는 bonus를 더해준다

		Collections.sort(al);
		
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		
	}

}
