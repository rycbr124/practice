package week3.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;


class Vender{
	private String name;//회사명
	private int id;//기업 id
	private int stock;//제품 재고
	private HashSet<Product> products  = new HashSet<Product>(); //회사 제품 카탈로그//제품중복입력 방지
	
	//생성자,getter setter
	
	private void inputProduct(Product product){
		/*
		 * products에 새 제품 추가
		 * 중복방지를 위해 set배열로 input
		 */
	}
	
	private void stockControll() {
		/*
		 * stock값을 관리하는 메소드
		 * vender가 재고를 관리하기 떄문에
		 */
	}
	
}

class Product{
	private String name;//제품명
	private String color;//제품색
	private String size;//제품사이즈
	private int price;//제품 가격

	//생성자,getter setter
	
	public int hashCode() {
//		해시코드 오버라이딩 ;
		return 0;
	}
	
	public boolean equals(Product obj) {

//		equals 오버라이딩;
		return false;
	}
	
}



class Customer{
	String id;
	String name;
	String address;
	
	//생성자,getter setter
	
}

class Order{
	private int orderNum; //주문번호
	private Customer orderCustomer; //주문고객정보
	private Product product;//주문제품정보
	private int stockNum;//주문수량
	
	Order(int orderNum, Customer orderCustomer, Product product, int stockNum) {
		this.orderNum = orderNum;
		this.orderCustomer = orderCustomer;
		this.product = product;
		this.stockNum = stockNum;
	}
	
}

public class ShoppingMall {

	private HashMap<String,Customer> customers=new HashMap<String,Customer>();//id를 key값으로 받는 고객정보
	private HashMap<String,Vender> venders=new HashMap<String,Vender>(); //id를 key값으로 받는 기업정보
	private HashMap<Product,Vender> products=new HashMap<Product,Vender>();//쇼핑몰 판매 제품,공급업체
	private HashMap<Integer,Order> orders = new HashMap<Integer,Order>();
	
	
	private void showMenu() {
		/*
		 *쇼핑몰 메뉴 출력,입력에 따른 메소드 출력
		 */
	}
	
	void signIn(String id,String name,String address) {
		/*
		 * 고객정보 추가
		 * id를 입력받아 key값으로 설정
		 */
	}
	
	void inputOrder(int stockNum,String name) {
		/*
		 * 주문수량,product name을 받음
		 * 주문번호=날짜+id
		 * orders에 put
		 */
	}
	
	private void inputProduct(Product product,Vender vender) {
		/*
		 * 메소드에서 입력받은 값 참조하여
		 * products에 새로운 제품추가
		 */
	}
	
	private void inputVender(Vender vender){
		/*
		 * 메소드에서 입력받은 값 참조하여
		 * venders에 업체 추가 및 변경
		 */
	}

}
