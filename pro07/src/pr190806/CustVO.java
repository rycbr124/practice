package pr190806;

public class CustVO {
	private String cust_id;
	private String cust_name;
	private String cust_address;
	
	private String order_num;
	private String order_item;
	private String prod_name;
	private String quantity;
	private String item_price;
	
	String getCust_id() {
		return cust_id;
	}
	void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	String getCust_name() {
		return cust_name;
	}
	void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	String getCust_address() {
		return cust_address;
	}
	void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	String getOrder_num() {
		return order_num;
	}
	void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	String getProd_name() {
		return prod_name;
	}
	void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	String getQuantity() {
		return quantity;
	}
	void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	String getItem_price() {
		return item_price;
	}
	void setItem_price(String item_price) {
		this.item_price = item_price;
	}
	String getOrder_item() {
		return order_item;
	}
	void setOrder_item(String order_item) {
		this.order_item = order_item;
	}
	
	
	
}
