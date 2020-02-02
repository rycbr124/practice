package pr190716;
/*
실습2 : CompanyMan에 대한 클래스
-속성
	private String name
	private int age
	private String[] hobby
    private Company nowCompany
    private Company[] historyCompany
-생성자
	CompanyMan(String name, int age, Company nowCompany)
-메소드
	public boolean setHobby(String hobby) : 취미를 추가
	public boolean delHobby(String hobby) : 취미를 삭제
	public boolean setNotCompany(Company company) : 현재 근무 회사 등록,
	현재 근무 회사가 변경되면 historyCompany에 이력을 추가
	public int getTotalPeriod() : 총 회사근무이력의 기간 리턴
	public void printHistoryCompany() : 근무한 회사 출력
	
CompanyMan에 대한 클래스
-속성
	private String name
	private int period
-메서드
	get/set method
 * */
class CompanyMan{
	private String name;
	private int age;
	private String[] hobby;
    private Company nowCompany;
    private Company[] historyCompany;
    
	CompanyMan(String name, int age, Company nowCompany){
		this.name=name;
		this.age=age;
		this.nowCompany=nowCompany;
		this.hobby=new String[0];
		this.historyCompany=new Company[0];
	}
	
	public boolean setHobby(String hobby) {
		//현재 상태 복제
		String[] copy = new String[this.hobby.length];
		for(int i=0;i<this.hobby.length;i++) {
			String temp=this.hobby[i];
			copy[i]=temp;
		}
		try {
//			//취미 배열에 null값이 있을 경우 인자값을 넣고 리턴
//			for(int i=0;i<this.hobby.length;i++) {
//				if(this.hobby[i]==null) {
//					this.hobby[i]=hobby;
//					return true;
//				}
//			}
			//현재 hobby 배열 복제
			String[] tempA = new String[this.hobby.length+1];
			for(int i=0;i<this.hobby.length;i++) {
				String t=this.hobby[i];
				tempA[i]=t;
			}
			//복제된 배열에 새 취미 추가
			tempA[tempA.length-1]=hobby;
			//복제된 배열 hobby에 넣기
			this.hobby=new String[tempA.length];
			this.hobby=tempA;
		}catch(Exception e) {
			this.hobby=copy;
			return false;
		}
		return true;
	}
	
	public boolean delHobby(String hobby) {
		//현재 상태 복제
		String[] copy = new String[this.hobby.length];
		for(int i=0;i<copy.length;i++) {
			String temp=this.hobby[i];
			copy[i]=temp;
		}
		try {
			int check=-1;
			for(int i=0;i<this.hobby.length;i++) {
				if(this.hobby[i]==hobby){
					this.hobby[i]=null;
					check=i;
					break;
				}
			}
			
			if(check==-1) {
				System.out.println("입력한 취미가 입력되어 있지 않습니다.");
				return true;
			}
			
			String[] tempA = new String[this.hobby.length-1];
			for(int i=0;i<tempA.length;i++) {
				if(i<check) {
					String t=this.hobby[i];
					tempA[i]=t;
				}else if(i>=check){
					String t=this.hobby[i+1];
					tempA[i]=t;
				}
			}
			this.hobby=new String[tempA.length];
			this.hobby=tempA;
		}catch(Exception e) {
			this.hobby=copy;
			return false;
		}
		return true;
	}
	
	public boolean setNotCompany(Company company) {
		//현재 상태 복제
		Company temp = new Company();
		temp.setName(company.getName());
		temp.setPeriod(temp.getPeriod());
		
		Company[] copy = new Company[this.historyCompany.length];
		for(int i=0;i<copy.length;i++) {
			Company temp2=this.historyCompany[i];
			copy[i]=temp2;
		}
		try {
			//변경사항 없을 경우 리턴
			if(this.nowCompany.getName()==company.getName()) {
				System.out.println("현재 다니고 있는 회사와 동일합니다.");
				return true;
			}
			
			Company[] tempA = new Company[this.historyCompany.length+1];
			for(int i=0;i<this.historyCompany.length;i++) {
				Company t=this.historyCompany[i];
				tempA[i]=t;
			}
			//복제된 배열에 새 회사 추가
			tempA[tempA.length-1]=company;
			//복제된 배열 history에 넣기
			this.historyCompany=new Company[tempA.length];
			this.historyCompany=tempA;
		}catch(Exception e) {
			this.nowCompany=temp;
			this.historyCompany=copy;
			return false;
		}
		
		return true;
			
	}
	
	
	public int getTotalPeriod(){
		  int allPeriod=0;
		  
		  for(int i=0;i<historyCompany.length;i++) {
			  if(historyCompany[i]!=null) {
				  allPeriod+=historyCompany[i].getPeriod();
			  }
		  }
		  return  allPeriod;
	}
	
	public void printHistoryCompany() {
		int count=0;
		
		for(int i=0;i<historyCompany.length;i++) {
			if(historyCompany[i]!=null){
				System.out.println((i+1)+"번 회사");
				System.out.println("회사 명 : "+historyCompany[i].getName());
				System.out.println("기간 : "+historyCompany[i].getPeriod()+"개월\n");
				count++;
			}
		}
		
		if(count==0)
			System.out.println("입력된 이력이 존재하지 않습니다.");
	}
	
	public void showHobby() {
		int count=0;
		
		for(int i=0;i<this.hobby.length;i++) {
				System.out.println((i+1)+"번 취미 : "+this.hobby[i]);
				count++;
		}
		
		if(count==0)
			System.out.println("입력된 취미가 존재하지 않습니다.");
	}

}

class Company{
	private String name;
	private int period;
	
	Company(){
		
	}
	
	Company(String name,int period){
		this.name=name;
		this.period=period;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
}

public class Practice0716_2 {

	public static void main(String[] args) {
		Company cp1 = new Company("카카오",15);
		Company cp2 = new Company("유튜브",20);
		Company cp3 = new Company("구글",30);
		
		CompanyMan cm = new CompanyMan("영희",30,cp1);
		
		System.out.println(cm.setHobby("음악감상"));
		System.out.println(cm.setHobby("게임"));
		System.out.println(cm.setHobby("널뛰기"));
		System.out.println(cm.delHobby("널뛰기"));
		System.out.println(cm.delHobby("축구"));
		
		System.out.println("\n입력된 취미:");
		cm.showHobby();
		System.out.println();
		
		System.out.println(cm.setNotCompany(cp1));
		System.out.println("\n1.입력된 회사 정보");
		cm.printHistoryCompany();
		System.out.println(cm.setNotCompany(cp2));
		System.out.println(cm.setNotCompany(cp3));
		System.out.println("\n2.입력된 회사 정보");
		cm.printHistoryCompany();
		System.out.println(cm.getTotalPeriod()+"개월");
		
	}

}
