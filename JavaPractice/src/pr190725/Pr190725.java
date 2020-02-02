package pr190725;
/*
실습1: Order에 대한 클래스
 속성: private int orderNo, private Date orderDt
          , private (HashMap)products (주문상품)
- 생성자
   Order(int orderNo, Date orderDt)
- 메소드: 
   public void addProduct(int ordProdNo, Product p): 주문상품을 추가한다
   public void delProduct(int ordProdNo): 주문상품을 삭제한다
   public void chgProduct(int ordProdNo, Product p): 주문상품을 변경한다
   public void printKeyBySort(): 주문상품을 키를 기준으로 정렬하여 출력한다
   public void printValueBySort(Comparator c): 주문상품을 Value를 기준으로 정렬하여 출력한다                                        Value는 제품번호를 기준으로 정렬한다

 Product(상품) 클래스 
 속성: private int productNo(제품번호), private String productNm(제품이름)
- 생성자
   Product(int productNo, String productNm)
 메소드
   get/set Method
 * */
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;


class Order{
	private int orderNo;
	private Date orderDt;
    private Map<Integer,Product> products=new HashMap<Integer,Product>();
    
    Order(int orderNo, Date orderDt){
    	this.orderNo=orderNo;
    	this.orderDt=orderDt;
    }
    
    Map<Integer, Product> getProducts() {
		return products;
	}

	public void addProduct(int ordProdNo, Product p) {
//    	: 주문상품을 추가한다
    	this.products.put(ordProdNo, p);
    }
    
    public void delProduct(int ordProdNo) {
//    	: 주문상품을 삭제한다
    	this.products.remove(ordProdNo);
    }
    
    public void chgProduct(int ordProdNo, Product p) {
//    	: 주문상품을 변경한다
//    	if(this.products.replace(ordProdNo, this.products.get(ordProdNo), p)) {
    	if(this.products.containsKey(ordProdNo)) {
    		this.products.replace(ordProdNo, p);
    	}else {
    		System.out.println("해당 상품은 존재하지 않습니다.");
    	}
    }
    
    public void printKeyBySort() {
//    	: 주문상품을 키를 기준으로 정렬하여 출력한다
    	TreeMap<Integer,Product> t = new TreeMap<Integer,Product>(this.products);
    	Iterator<Integer> it = t.keySet().iterator();
    	
    	while(it.hasNext()) {
    		int key = it.next();
    		System.out.println("주문제품번호 : "+key+"\n주문상품정보\n"+t.get(key));
    	}
    	
    }
    
    public void printValueBySort(Comparator<Product> c) {
//    	: 주문상품을 Value를 기준으로 정렬하여 출력한다                                        
//    	Value는 제품번호를 기준으로 정렬한다
//    	Collections.sort(this.products,c);
    	List<Product> l = new ArrayList<>();
    	l.addAll(this.products.values());
    	Collections.sort(l,c);
    	for(Product p : l) {
    		System.out.println(p);
    	}

    	}
}

class Compare1 implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getProductNo()<o2.getProductNo() ? -1 : o1.getProductNo()==o2.getProductNo() ? 0 : 1;
	}

}

class Product{
	private int productNo;
	private String productNm;
	
	Product(int productNo, String productNm) {
		this.productNo = productNo;
		this.productNm = productNm;
	}

	int getProductNo() {
		return productNo;
	}

	void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	String getProductNm() {
		return productNm;
	}

	void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	
//	public int hashCode() {
//		return Objects.hash(this.productNo,this.productNm);
//	}
//	
//	public boolean equals(Object obj) {
//		if(obj instanceof Product) {
//			Product tmp = (Product)obj;
//			return this.productNo==tmp.productNo
//					&&this.productNm.equals(tmp.productNm);
//		}
//		return false;
//	}
	
	public String toString() {
		return "제품번호 : "+this.getProductNo()+"\n제품이름 : "+this.getProductNm()+"\n";
	}
}

public class Pr190725 {
	public static void main (String[] args) {
		Compare1 c = new Compare1();
		Product p1 = new Product(12251,"사과");
		Product p2 = new Product(32351,"수박");
		Product p3 = new Product(22451,"배");
		Product p4 = new Product(72251,"복숭아");
		Product p5 = new Product(52251,"참외");
		Product p7 = new Product(52251,"귤");


		Order or1 = new Order(111,Date.valueOf("2019-01-12"));
		
		or1.addProduct(123, p1);
		or1.addProduct(3232, p2);
		or1.addProduct(223, p3);
		or1.addProduct(42, p4);
		or1.addProduct(511, p5);
		
		System.out.println(or1.getProducts());
		System.out.println("=================");
		or1.printKeyBySort();
		System.out.println("=================");
		or1.printValueBySort(c);
		
		System.out.println("=================");
		or1.delProduct(511);
		or1.chgProduct(511, p7);//없는 상품정보,메세지 출력
		or1.chgProduct(42, p7);
		System.out.println("=================");
		or1.printKeyBySort();

		
	}
}
