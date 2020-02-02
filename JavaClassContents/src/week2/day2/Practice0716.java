//package week2.day2;
//
//import java.util.Calendar;
//import java.util.Scanner;
//
//abstract class Project{
//	private String name;
//	private Calendar startDt;
//	private Calendar endDt;
//	private String location;
//	private Developer[] dev;//여기서 초기화를 많이한다
//	 //실무에서는 대부분 필드에 초기화를 해준다(생성자에서 해도 됨)
//
//	
//	Project(){}
//	
//	Project(String name, Calendar starDt, Calendar endDt, String location){
//		this.name=name;
//		this.startDt=starDt;
//		this.endDt=endDt;
//		this.location=location;
//	}
//	
//	Project(String name, Calendar starDt, Calendar endDt, String location,Developer[] dev){
//		this.name=name;
//		this.startDt=starDt;
//		this.endDt=endDt;
//		this.location=location;
//		this.dev=dev;
//	}
//	
//	public void process() {
//		plan();
//		design();
//		develop();
//	}
//	
//	  public void plan(){
//		  System.out.println("Project 준비");
//	  }
//	  
//	  public void join(Developer d)  throws Exception{
//			int count=0;
//			
//			for(int i=0;i<dev.length;i++) {
//				if(dev[i]==null)
//				{
//					count++;
//				}
//			}
//			
//			if(count==0) {
//				throw new Exception("모든 개발자가 참여중입니다.");
//			}
//			
//			for(int i=0;i<dev.length;i++)
//			{
//				if(dev[i]==null)
//				{
//					dev[i]=d;
//					break;
//				}
//			}
//	  }
//	  
//	  public void join(int dNum) {
//		  Scanner sc = new Scanner(System.in);
//			if(dNum==1){
//				System.out.print("\n일반 개발자의 이름을 입력해주세요 : ");
//				String name=sc.nextLine();
//				System.out.print("일반 개발자의 개발기간을 입력해주세요 : ");
//				int period=sc.nextInt(); sc.nextLine();
//				Developer d = new Developer(name,period);
//				try {
//					this.join(d);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}else if(dNum==2) {
//				System.out.print("\n특수개발자의 이름을 입력해주세요 : ");
//				String name=sc.nextLine();
//				System.out.print("특수개발자의 개발기간을 입력해주세요 : ");
//				int period=sc.nextInt(); sc.nextLine();
//				System.out.print("특수개발자의 특기를 입력해주세요 : ");
//				String special=sc.nextLine();
//				Developer d = new HighDeveloper(name,period,special);
//				try {
//					this.join(d);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}
//	  }
//	  
//	  public abstract void design();//  “설계작업수행” 출력
//
//	  public abstract void develop();//  “개발작업수행” 출력
//	  
//	  public void design(int i) {
//		  System.out.println("설계작업수행");
//	  }
//
//	  public int getMMByDeveloper() {
//		  int allPeriod=0;
//		  
//		  for(int i=0;i<dev.length;i++) {
//			  if(dev[i]!=null) {
//				  allPeriod+=dev[i].getPeriod();
//			  }
//		  }
//		  return  allPeriod;
//	  }
//
//	  public void printDeveloper() {//instanceof 활용
//		  for(int i=0;i<dev.length;i++) {
//			  if(dev[i] instanceof HighDeveloper){
//				  HighDeveloper x = (HighDeveloper) dev[i];
//				  System.out.println("고급개발자 "+x.getName()+"/특기 "+x.getSpecialSkill());
//				  //((HighDeveloper)dev[i]).getSpecialSkill()도 가능
//			  }else{
//				  System.out.println("일반개발자 "+dev[i].getName());
//			  }
//		  }
//	  }
//	  
//		void removeHistory(int a) {
//			this.dev[a-1]=null;
//			System.out.println(a+"번 개발자 정보가 삭제되었습니다.");
//		}
//
//
//
//}
//
//class HrProject extends Project{
//
//	HrProject(String name, Calendar starDt, Calendar endDt, String location,Developer[]dev){
//		super(name,starDt,endDt,location,dev);
//	}
//	
//
//	public void design() {
//		  System.out.println("HR 설계작업수행");
//	  }
//	  public void develop() {
//		  System.out.println("HR 개발작업수행");
//	  }
//}
//
//class Developer{
//	private String name;
//	private int period;
//	
//	Developer(String name, int period){
//		this.name=name;
//		this.period=period;
//	}
//	
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public int getPeriod() {
//		return period;
//	}
//
//
//	public void setPeriod(int period) {
//		this.period = period;
//	}
//
//
//
//}
//
//class HighDeveloper extends Developer{
//	private String specialSkill;
//
//	HighDeveloper(String name, int period,String specialSkill){
//		super(name,period);
//		this.specialSkill=specialSkill;
//	}
//	
//	public String getSpecialSkill() {
//		return specialSkill;
//	}
//
//	public void setSpecialSkill(String specialSkill) {
//		this.specialSkill = specialSkill;
//	}
//
//	
//}
//
//public class Practice0716 {
//
//	public static void main(String[] args) {
////		Developer d1 = new Developer("홍길동",36);
////		Developer d2 = new Developer("김길동",24);
////		Developer d3 = new HighDeveloper("김고급",60,"java");
////		Developer[] dArray = {d1,d2,d3};
////		
////		Project pj = new HrProject("인사시스템 개발","190520","200319","여의도",dArray);
////		
////		pj.process();
////		System.out.println("\n총 월간 개월수 : "+pj.getMMByDeveloper()+"일");
////		System.out.println("\n개발 참여자 : ");
////		pj.printDeveloper();
////		
////		Developer dx = new HighDeveloper("김추가",50,"java");
////		try {
////			pj.join(dx);
////		}catch(Exception e) {
////			System.out.println("\n"+e.getMessage());
////		}
//		
//		//dev배열길이 설정
//		Scanner sc = new Scanner(System.in);
//		System.out.print("개발에 참여할 인원수를 입력해주세요 : ");
//		int num= sc.nextInt(); sc.nextLine();
//		Developer[] dArray = new Developer[num];
//		
//		//생성자에 넣어줄 프로젝트명 입력
//		System.out.print("프로젝트명을 입력해주세요 : ");
//		String dName = sc.nextLine();
//		//생성자에 넣어줄 시작일,종료일 입력
//		System.out.print("개발 시작일과 종료일을 입력해주세요(형식 20191105) : ");
//		String sDay = sc.next();
//		String eDay = sc.next();
//		
//		
//		
//		Calendar cal = Calendar.getInstance();
//		
//		
//		//생성자에 넣어줄 location값 입력
//		System.out.print("개발을 진행하는 회사명을 입력해주세요 : ");
//		String location = sc.nextLine();
//		
//		Project pj = new HrProject(dName,,location,dArray);
//		
//		//dev배열에 인스턴스를 넣는 과정
//		for(int i=0; i<num;i++) {
//			System.out.print("\n일반 개발자는 \"1\",특수개발자는 \"2\"를 입력해주세요 : ");
//			int dNum=sc.nextInt(); sc.nextLine();
//			
//			//입력값 확인
//			while(!(dNum==1 || dNum==2)){
//				System.out.print("잘못 입력하셨습니다."
//						+ " 일반 개발자는 \"1\",특수개발자는 \"2\"를 입력해주세요 : ");
//				dNum=sc.nextInt();sc.nextLine();
//			}
//			//(오버로딩)join 메소드 실행
//			pj.join(dNum);
//			
//		}//for문의 끝
//		
//		System.out.println("\n결과값 출력 : ");
//		pj.process();
//		System.out.println();
//		pj.printDeveloper();
//	
//	
//	}
//	
//	int dayTo(int date,int num) {
//		if
//	}
//
//}
