package week1.state;

public class Employee {
	public static final int ENGINEER = 1;
	public static final int MANAGER = 2;
	public static final int SALESMAN = 3;	
	private int type;

	public void setType(int type) {
		this.type=type;
	}
	
	public Employee(int type) {
		setType(type);
	}
	
	public int getAmount(){
		switch(type) {
		case ENGINEER:
			return 100;//return은 끝내다의 의미도 있어서 break 구문 안 씀
		case MANAGER:
			return 200;
		case SALESMAN:
			return 300;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Employee em = new Employee(2);
		System.out.println(em.getAmount());
	}

}
