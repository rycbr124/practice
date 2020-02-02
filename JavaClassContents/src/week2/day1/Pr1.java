package week2.day1;

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

//scanner 입력 후 생성자로 넣어주고 리턴해주는 메소드??
class Programmer{
	private int age;
	private Project now;
	private Project[] history=new Project[5];//경력,5개 제한
	//배열의 길이를 생성해주지 않으면 메소드에서 바로 접근을 못 한다.
	
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
		int count=0;
		
		for(int i=0;i<history.length;i++) {
			if(history[i]==null)
			{
				count++;
			}
		}
		
		if(count==0) {
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
		int count=0;
		
		for(int i=0;i<history.length;i++) {
			if(history[i]!=null)
			{
				System.out.println((i+1)+"번 프로젝트");
				System.out.println("프로젝트 명 : "+history[i].getName());
				System.out.println("회사 명 : "+history[i].getCompany());
				System.out.println("진행 기간 : "+history[i].getMonth()+"개월\n");
				count++;
			}
		}
		
		if(count==0)
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
	
	void removeHistory(int a) {
		this.history[a-1]=null;
		System.out.println(a+"번 프로젝트 기록이 삭제되었습니다.");
	}
	
}

public class Pr1 {

	public static void main(String[] args) {
		Programmer pr = new Programmer();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int choice;
			
			System.out.println("\n===\t 프로젝트 입력기\t===");
			System.out.println("1.현재 프로젝트 입력");
			System.out.println("2.기존 프로젝트 이력 출력");
			System.out.println("3.프로젝트 경력 추가");
			System.out.println("4.총 경력 기간 확인");
			System.out.println("5.입력된 경력 삭제");
			System.out.println("6.종료");
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
				System.out.print("삭제할 프로젝트 번호를 입력해주세요 : ");
				pr.removeHistory(sc.nextInt()); sc.nextLine();
			}else if(choice==6) {
				System.out.println("시스템을 종료합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 초기 화면으로 돌아갑니다.");
				continue;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
