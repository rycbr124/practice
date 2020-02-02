package pr190716;
/*

•실습1: Project에 대한 클래스
-속성: private (String)name, private (String)startDt, private (String)endDt, private (String)locaiton, private (Developer[]) dev
- 생성자
  Project(String name, String startDt, String endDt, String location)
  Project(String name, String startDt, String endDt, String location, Developer[] dev)
- 메소드:
  public void process():  모든 Project는다음의 4가지 과정을 거치게 된다
                           plan(), design(), develop()
  public void plan(): “Project 준비” 출력
  public void join(Developer d); Proejct에개발자 Add
  public void design():  “설계작업수행” 출력
  public void develop();  “개발작업수행” 출력
  public int getPeriod(): Project 기간 리턴
  public int getMMByDeveloper(); Project에참여한 개발자의 총 월간 개월수
  public printDeveloper():
             일반개발자 홍길동
             일반개발자 김길동
             고급개발자 김고급/특기 java

• HrPoejct 클래스 extends Project
- 메소드
  public void design():  “HR 설계작업수행” 출력
  public void develop();  “HR 개발작업수행” 출력

•Developer 클래스
- 속성:private (String)name, private (int)period
- 생성자
  Developer(String name, int period)
- 메소드:
  각 속성의 get/set Method

• HighDeveloper 클래스  extends Developer
- 속성:private (String)specialSkill
- 생성자
  HighDeveloper(String name, int period, String specialSkill)
- 메소드
  각 속성의 get/set Method
 * */
import java.util.Calendar;
import java.util.Scanner;

abstract class Project{
	private String name;
	private String startDt;
	private String endDt;
	private String location;
	private Developer[] dev;
	
	Project(){}
	
	Project(String name, String starDt, String endDt, String location){
		this.name=name;
		this.startDt=starDt;
		this.endDt=endDt;
		this.location=location;
	}
	
	Project(String name, String starDt, String endDt, String location,Developer[] dev){
		this.name=name;
		this.startDt=starDt;
		this.endDt=endDt;
		this.location=location;
		this.dev=dev;
	}
	
	public void process() {
		plan();
		design();
		develop();
	}
	
	  public void plan(){
		  System.out.println("Project 준비");
	  }
	  
	  public void join(Developer d)  throws Exception{
			int count=0;
			
			for(int i=0;i<dev.length;i++) {
				if(dev[i]==null)
				{
					count++;
				}
			}
			
			if(count==0) {
				throw new Exception("모든 개발자가 참여중입니다.");
			}
			
			for(int i=0;i<dev.length;i++)
			{
				if(dev[i]==null)
				{
					dev[i]=d;
					break;
				}
			}
	  }
	  
	  public abstract void design();//  “설계작업수행” 출력

	  public abstract void develop();//  “개발작업수행” 출력

	  public int getMMByDeveloper() {
		  int allPeriod=0;
		  
		  for(int i=0;i<dev.length;i++) {
			  if(dev[i]!=null) {
				  allPeriod+=dev[i].getPeriod();
			  }
		  }
		  return  allPeriod;
	  }

	  public void printDeveloper() {//instanceof 활용
		  for(int i=0;i<dev.length;i++) {
			  if(dev[i] instanceof HighDeveloper)
			  {
				  HighDeveloper x = (HighDeveloper) dev[i];
				  System.out.println("고급개발자 "+x.getName()+"/특기 "+x.getSpecialSkill());
			  }else
			  {
				  System.out.println("일반개발자 "+dev[i].getName());
			  }
		  }
	  }



}

class HrProject extends Project{

	HrProject(String name, String starDt, String endDt, String location,Developer[]dev){
		super(name,starDt,endDt,location,dev);
	}
	

	public void design() {
		  System.out.println("HR 설계작업수행");
	  }
	  public void develop() {
		  System.out.println("HR 개발작업수행");
	  }
}

class Developer{
	private String name;
	private int period;
	
	Developer(String name, int period){
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

class HighDeveloper extends Developer{
	private String specialSkill;

	HighDeveloper(String name, int period,String specialSkill){
		super(name,period);
		this.specialSkill=specialSkill;
	}
	
	public String getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}

	
}

public class Practice0716 {

	public static void main(String[] args) {
	Developer d1 = new Developer("홍길동",36);
	Developer d2 = new Developer("김길동",24);
	Developer d3 = new HighDeveloper("김고급",60,"java");
	Developer[] dArray = {d1,d2,d3};
	
	Project pj = new HrProject("인사시스템 개발","190520","200319","여의도",dArray);
	
	pj.process();
	System.out.println("\n총 월간 개월수 : "+pj.getMMByDeveloper()+"일");
	System.out.println("\n개발 참여자 : ");
	pj.printDeveloper();
	
	Developer dx = new HighDeveloper("김추가",50,"java");
	try {
		pj.join(dx);
	}catch(Exception e) {
		System.out.println("\n"+e.getMessage());
	}
	
		
	}

}
