package pr190809;

public class OrderitemsVO {
	private String order_num;
	private String order_item;
	private String prod_id;
	private String prod_name;
	private String quantity;
	private String item_price;
	
	void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	void setOrder_item(String order_item) {
		this.order_item = order_item;
	}
	void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	void setItem_price(String item_price) {
		this.item_price = item_price;
	}
	
	public String getOrder_num() {
		return order_num;
	}
	public String getOrder_item() {
		return order_item;
	}
	public String getProd_id() {
		return prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getItem_price() {
		return item_price;
	}
	

	
	
}
