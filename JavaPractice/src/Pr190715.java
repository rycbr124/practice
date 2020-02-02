/*
오전실습:  소스코드로 전환
• Programmer
1.속성: private String name, private int age, private Project now, private Project[] history
2.함수
-void joinProject(Project p): 현재 진행중인 Project를설정
-void addProjectHistory(Project p): Project경력을 추가
-Project getNowProject(): 현재Project를 리턴한다
-void printProjectHistory(): Project 경력을 출력한다
-String getTotalHistory: 모든 Project의 총 경력의 합을 리턴한다(x년x월)
-void setTotalHistory(Project[] p): 총 경력을 설정한다

* 참고
- Project History는 5개까지 가능: 5개를 넘게 추가 시 Exception 발생
   “Project History는 5개까지 추가가능합니다”

• Project
- 속성:private (String)name, private (int)month, private String company
- 메소드:
  String getName(): Project명 리턴
  void setName(String name): Project명 설정
  intgetMonth(): Project 수행기간을 월로 리턴
  void setMonth(int month): Project 수행기간을 설정
 * */
import java.util.Scanner;

class Project{
	private String name,company;//프로젝트명,회사
	private int month;//수행기간
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getCompany() {
		return company;
	}
	
	void setCompany(String company) {
		this.company = company;
	}
	
	int getMonth() {
		return month;
	}
	
	void setMonth(int month) {
		this.month = month;
	}
	

}

class Programmer{
	private int age;
	private int count;
	private Project now;
	private Project[] history=new Project[5];//경력,5개 제한
	
	Programmer(){
		
	}
	
	Programmer(int age,Project now,Project[] history){
		this.age=age;
		this.now=now;
		this.history=history;
	}
	
	Programmer(int age,Project now){
		this.age=age;
		this.now=now;
	}
	
	Programmer(int age){
		this.age=age;
	}
	
	void joinProject(Project p) { //now 설정
 		Scanner sc = new Scanner(System.in);
		System.out.print("프로젝트명을 입력해주세요 : ");
		p.setName(sc.nextLine());
		System.out.print("회사 명을 입력해주세요 : ");
		p.setCompany(sc.nextLine());
		System.out.print("수행기간을 입력해주세요(단위 월) : ");
		p.setMonth(sc.nextInt()); sc.nextLine();
		
		this.now=p;
	}
	
	void addProjectHistory(Project p) throws Exception{//history 추가
		if(this.count>=history.length) {
			throw new Exception("Project History는 5개까지 추가가능합니다.");
		}
		
		for(int i=0;i<history.length;i++)
		{
			if(history[i]==null)
			{
				history[i]=p;
				count++;
				break;
			}
		}
		
	}
	
	Project getNowProject() {//return
		return this.now;
	}
	
	void printProjectHistory() {//project목록 출력
		int count=1;
		
		for(int i=0;i<history.length;i++) {
			if(history[i]!=null)
			{
				System.out.println(count+"번 프로젝트");
				System.out.println("프로젝트 명 : "+history[i].getName());
				System.out.println("회사 명 : "+history[i].getCompany());
				System.out.println("진행 기간 : "+history[i].getMonth()+"개월\n");
				count++;
			}
		}
		
		if(count==1)
			System.out.println("입력된 경력이 존재하지 않습니다.");
	}
	
	String getTotalHistory(){
		int allMonth=0;
		
		for(int i=0;i<history.length;i++) {
			if(history[i]!=null) {
				allMonth+=history[i].getMonth();
			}
		}
		return (allMonth/12)+"년"+(allMonth%12)+"월";
	}
	
	
}

public class Pr190715 {

	public static void main(String[] args) {
		Programmer pr = new Programmer();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int choice;
			
			System.out.println("\n===\t 프로젝트 입력기\t===");
			System.out.println("1.현재 프로젝트 입력");
			System.out.println("2.이전 프로젝트 이력 출력");
			System.out.println("3.이전 프로젝트 경력 추가");
			System.out.println("4.총 경력 기간 확인");
			System.out.println("5.종료");
			System.out.println("=======\t\t=======");
			System.out.print("\n선택하실 메뉴를 입력해주세요:");
			choice=sc.nextInt(); sc.nextLine();
			
			if(choice==1) {
				pr.joinProject(new Project());
			}else if(choice==2) {
				pr.printProjectHistory();
			}else if(choice==3) {
				Project pj = new Project();
				
				System.out.print("추가할 프로젝트명을 입력해주세요 : ");
				pj.setName(sc.nextLine());
				System.out.print("추가할 회사 명을 입력해주세요 : ");
				pj.setCompany(sc.nextLine());
				System.out.print("추가할 수행기간을 입력해주세요(단위 월) : ");
				pj.setMonth(sc.nextInt()); sc.nextLine();
			
				try {
					pr.addProjectHistory(pj);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			}else if(choice==4) {
				System.out.println(pr.getTotalHistory());
			}else if(choice==5) {
				System.out.println("시스템을 종료합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 초기 화면으로 돌아갑니다.");
				continue;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
