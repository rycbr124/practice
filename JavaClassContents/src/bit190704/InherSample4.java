package bit190704;


class Super{
	String name;
	String secNum;
	int num;
	
	String ret(){
		String a=secNum.substring(0, 6);
		String b=secNum.substring(6,8);
		return a+"-"+b+"*****";
	}
	
	
	Super(String name, String secNum, int num) {
		this.name=name;
		this.secNum=secNum;
		this.num=num;
	}
	
	
	
	
	
}

class Student extends Super{
	int sum;
	
	Student(String name, String secNum, int num) {
		super(name,secNum,num);
		
	}
	
	int bak(){
		for(int i=1;i<=100;i++)
			sum+=i;
		return sum;
	}
}

//번호,이름,주민번호 입력하여 출력. 상속이용.
public class InherSample4 {
	public static void main(String[] args) {
		Student std = new Student("홍길동","1234561234567",1);
		System.out.println("이름 = "+std.name);
		System.out.println("주민 = "+std.ret());
		System.out.println("번호 = "+std.num);
		
		System.out.println("1~100 hap = "+std.bak());
		
		
		
	}

}
