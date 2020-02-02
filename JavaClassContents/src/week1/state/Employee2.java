package week1.state;

interface EmployeeType{
	public int getAmount();
}

class Engineer implements EmployeeType{
	public int getAmount() {
		return 100;
	}
}

class Manager implements EmployeeType{
	public int getAmount() {
		return 200;
	}
}

class Salesman implements EmployeeType{
	public int getAmount() {
		return 300;
	}
}

public class Employee2 {
	private EmployeeType type;
	
	public Employee2(EmployeeType type) {
		setType(type);
	}
	
	
	public int getAmount() {
		return type.getAmount();
	}


	public void setType(EmployeeType type) {
		this.type=type;
	}
	
	public static void main(String[] args) {
		EmployeeType e = new Manager();
		Employee2 f =new Employee2(e);
		System.out.println(f.getAmount());
		
	}

}
