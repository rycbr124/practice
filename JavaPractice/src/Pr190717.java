/*
•실습1: Army에 대한 클래스
-속성: private(String)name, private (int)age, private (String)grade
          , private (String)strDt, private (String)endDt,private (Date) nextHoliday
          , private (Army[]) sub
- 생성자
  Army(String name, int age, String grade, String strDt, String endDt, DateHoliday)
- 메소드:
  public int getOverTimePayByGrade(): grade별야근수당 리턴
                              일병: 100,000, 상병: 200,000, 병장: 300,000
  public void printSubOverTimePay(): 부하별야근수당을 출력한다
                              형식: ‘{0} 의야근수당은 {1} 입니다’
                              금액은 3자리마다,를 찍어 표시한다
  public int getThisMMPeriod(): 이번달의 남은 근무기간을 리턴한다
  public int getSubTotalPeriod(): 부하들의총 근무기간을 리턴한다
  public boolean checkSub(Army[]sub): 모두 본인의 부하인지 리턴한다
                              Army간 비교는 name/age/class가 동일하면 동일인이다
  public void returnSub(Army[] sub); 부하들 목록을 리턴한다
  public void printSub(): 부하들을 출력한다
                              병장 홍길동 2019-01-01 ~ 2020-12-31
                              우수  상병 김길동 2018-01-01 ~ 2021-05-31

* SepcialArmy에 대한 클래스
- 속성:private (int)bonus         야근수당에 bonus가 추가된다
- 생성자: SpecialArmy(Stringname, int age, String grade
                                                , String strDt, String endDt, int bonus)
- 메서드: get/set Method 
 * */
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Calendar;


class Army{
	private String name;
	private  int age;
	private String grade;
	private String strDt;
	private String endDt;
	private Date nextHoliday;
    private Army[] sub;


	Army(String name, int age, String grade, String strDt, String endDt,Date nextHoliday){
    	this.name=name;
    	this.age=age;
    	this.grade=grade;
    	this.strDt=strDt;
    	this.endDt=endDt;
    	this.nextHoliday=nextHoliday;
		if(this.sub==null)
			this.sub=new Army[0];
    }

    public int getOverTimePayByClass() {
    	int night=0;
    	switch(this.grade){
    		case "일병":
    			night=100000;
    			break;
    		case "상병":
    			night=200000;
    			break;
    		case "병장":
    			night=300000;
    			break;
    	}
    	
    	if(this instanceof SpecialArmy){
			  SpecialArmy x = (SpecialArmy) this;
			  night+=x.getBonus();
    	}
    	
		return night;
    }


	public void printSubOverTimePay() {
	//	부하별야근수당을 출력한다
	//	형식: ‘{0} 의야근수당은 {1} 입니다’
	//	금액은 3자리마다,를 찍어 표시한다
		Object[] arguments = new Object[(sub.length)*2];
		int count=0;
		
		if(this.sub.length==0) {
			System.out.println("입력된 정보가 없습니다.");
		}else {
			for(int i=0;i<arguments.length;i+=2) {
				arguments[i]=sub[count].getName();
				
				int night=sub[count].getOverTimePayByClass();
				DecimalFormat df = new DecimalFormat("#,###");
				String nightFormat = df.format(night);
				
				arguments[i+1]=nightFormat;
				count++;
			}
			for(int i=0;i<arguments.length;i+=2)
			{
				String msg = "{"+(i)+"}의 야근수당은 {"+(i+1)+"} 입니다.";
				String result = MessageFormat.format(msg, arguments);
				System.out.println(result);		
			}
		}
	}



	public int getThisMMPeriod() {
//		이번달의 남은 근무기간을 리턴한다
		Calendar sDay = Calendar.getInstance();//시작일
		Calendar eDay = Calendar.getInstance();//끝일
		
		int year=sDay.get(Calendar.YEAR);
		int month=sDay.get(Calendar.MONTH)+1;
		sDay.set(year,month-1,sDay.get(Calendar.DATE));
		
		if(Integer.parseInt(this.endDt.substring(5, 7))==month) {
			eDay.set(year, month-1, Integer.parseInt( this.endDt.substring(8, 10) ));
		}else {
			eDay.set(year,month,1);
			eDay.add(Calendar.DATE, -1);
		}
		
		return eDay.get(Calendar.DATE)-sDay.get(Calendar.DATE);
	}

//	public int getSubTotalPeriod() {
//
//	}

	public boolean checkSub(Army[] sub) {
//		모두 본인의 부하인지 리턴한다
//		Army간 비교는 name/age/class가 동일하면 동일인이다
		int count=0;
		
		for(int i=0; i<sub.length;i++) {
			for(int j=0; j<this.sub.length;j++) {
				if(sub[i].getName().equals(this.sub[j].getName())&&
					sub[i].getAge()==this.sub[j].getAge()&&
					sub[i].getGrade().equals(this.sub[j].getGrade())){count++;}
			}
		}
		
		if(count==sub.length)
		{
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public void returnSub(Army[] sub) {
	
		if(!(this.checkSub(sub))) {
			Army[] tempA = new Army[(this.sub.length)+(sub.length)];
			int count=0;
			
			for(int i=0;i<tempA.length;i++) {
				if(i<this.sub.length) {
					tempA[i]=this.sub[i];
				}else {
					tempA[i]=sub[count];
					count++;
				}
			}
			this.sub=tempA;
		}else {
			System.out.println("모든값이 장병정보에 입력되어 있습니다.");
		}

	}
	
	public void printSub() {
		  for(int i=0;i<sub.length;i++) {
		  if(sub[i] instanceof SpecialArmy){
			  SpecialArmy x = (SpecialArmy) sub[i];
			  System.out.println("우수 "+x.getGrade()+" "+x.getName()+" "+x.getStrDt()+" ~ "+x.getEndDt());
		  }else{
			  System.out.println(sub[i].getGrade()+" "+sub[i].getName()+" "+sub[i].getStrDt()+" ~ "+sub[i].getEndDt());
		  }
	  }
	}
	
	//Getter/Setter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getStrDt() {
		return strDt;
	}
	
	public void setStrDt(String strDt) {
		this.strDt = strDt;
	}
	
	public String getEndDt() {
		return endDt;
	}
	
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	public Date getNextHoliday() {
		return nextHoliday;
	}
	
	public void setNextHoliday(Date nextHoliday) {
		this.nextHoliday = nextHoliday;
	}
	
	public Army[] getSub() {
		return sub;
	}
	
	public void setSub(Army[] sub) {
		this.sub = sub;
	}

}

class SpecialArmy extends Army{
	private int bonus; //야근수당에 bonus가 추가된다

	SpecialArmy(String name, int age, String grade , String strDt, String endDt, Date Holiday, int bonus) {
		super(name, age, grade, strDt, endDt,Holiday);
		this.bonus=bonus;
	}
	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	
}

public class Pr190717 {

	public static void main(String[] args) {
		//String name, int age, String grade, String strDt, String endDt
		Army a1 = new Army("김일병", 22, "일병", "2019-01-01", "2019-09-09", Date.valueOf("2019-07-07"));
		Army a2 = new Army("김상병", 22, "상병", "2019-02-01", "2019-11-09", Date.valueOf("2019-08-07"));
		Army a3 = new SpecialArmy("김병장", 22, "병장", "2018-11-02", "2019-07-25", Date.valueOf("2019-08-07"),10000);
		Army[] arA = {a1,a2,a3};
		
		a3.returnSub(arA);
		a3.printSub();
		System.out.println();
		a3.printSubOverTimePay();
		System.out.println();
		a3.returnSub(arA);
		System.out.println();
		System.out.println(a2.getName()+"의 남은 근무일:"+a2.getThisMMPeriod());
		System.out.println(a3.getName()+"의 남은 근무일:"+a3.getThisMMPeriod());
	}

}
