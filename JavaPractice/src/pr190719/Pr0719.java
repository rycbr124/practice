package pr190719;
/*

실습1: Car에 대한 클래스 
속성: private (String)model, private (int)efficiency,  private (int)distance
          , private (HashMap)fixHis (수리이력), private String nowOwner
          , private (HashSet)accidentHis (사고이력)
- 생성자
   Car(String name, int efficiency, int distance, String nowOwner)
- 메소드: 
   public void addAccidentHis(String info): 사고이력을 추가한다
              - info: location(장소), date(20190102), time(12:50)이 / 를 구분자로 add
                         로타리사거리/20190501/14:00
              - 같은 사고이력을 추가할 수 없다
              - 잘못된 날자와 시간이 추가되면 안된다
   public void printAccidentHis: 사고이력을 출력한다
                              형식: ‘{0} - {1} ? {2}’, {0}: 장소, {1}: 날자, {2}: 시간
                              날자는 xxxx.xx.xx Format으로 출력한다
   public void addFixHis(String date, String item, String fixcmt): 수리이력을 추가한다
               - date별 item(수리부품)의 fixcmt(수리이력)을 추가한다
               - date별 item(수리부품)은 중복될 수 없다
   public void printFixHis(): 수리이력을 출력한다
               - 날자 - 부분 - 수리Cmt를 출력한다

 * */
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;



class Accident{
	private String location;
	private String date;
	private String time;
	
	String getLocation() {
		return location;
	}

	void setLocation(String location) {
		this.location = location;
	}

	String getDate() {
		return date;
	}

	void setDate(String date) {
		this.date = date;
	}

	String getTime() {
		return time;
	}

	void setTime(String time) {
		this.time = time;
	}

	Accident(String location, String date, String time) {
		this.location = location;
		this.date = date;
		this.time = time;
	}

	Date getDateFormat() {
    	int dateY=Integer.parseInt(this.date.substring(0, 4));
    	int dateM=Integer.parseInt(this.date.substring(4, 6));
    	int dateD=Integer.parseInt(this.date.substring(6));
    	
    	String dateFormat=dateY+"-"+dateM+"-"+dateD;
    			
		Date d = Date.valueOf(dateFormat);
		
		return d;
	}
	
	public int hashCode() {
		return Objects.hash(this.location,this.date,this.time);
	}
	
	public boolean equals(Accident obj) {
		if(obj instanceof Accident) {
			Accident tmp = (Accident)obj;
			return this.location.equals(tmp.location)&&
					this.date.equals(tmp.date)&&
					this.time.equals(tmp.time);
		}
		return false;
	}
	
	
}

class Car{
	private String model;
	private int efficiency;
	private int distance;
    private HashMap fixHis=new HashMap(); //(수리이력);
    private String nowOwner;
    private HashSet accidentHis=new HashSet(); //(사고이력)
    
    Car(String name, int efficiency, int distance, String nowOwner){
    	this.model=name;
    	this.efficiency=efficiency;
    	this.distance=distance;
    	this.nowOwner=nowOwner;
    }
    
    //데이터포맷으로 변환해서 에러가나는지 체크하는게 훨씬 간단하다.
    //데이터 체크시 보통 util을 만들어서 static메소드로 활용한다
    boolean checkDateValue(String date) throws Exception{
    	int dateY=Integer.parseInt(date.substring(0, 4));
    	int dateM=Integer.parseInt(date.substring(4, 6));
    	int dateD=Integer.parseInt(date.substring(6));

    	int nowYear=Calendar.getInstance().get(Calendar.YEAR);
    	if(dateY>nowYear) {
    		return false;
    	}
    	
    	if(dateM<1 || dateM>12 ) {
    		return false;
    	}
    	
    	switch(dateM) {
    	case 1:
    	case 3:
    	case 5:
    	case 7:
    	case 8:
    	case 10:
    	case 12:
    		if(dateD<1 || dateD>31) {
    			return false;
    		}
    		break;
    	case 2:
    	case 4:
    	case 6:
    	case 9:
    	case 11:
    		if(dateD<1 || dateD>30) {
    			return false;
    		}
    		break;
    	}
    	
    	return true;
    }
    
    boolean checkTimeValue(String time) {
    	String[] timeN = time.split(":",2);
    	int hour=Integer.parseInt(timeN[0]);
    	int minute=Integer.parseInt(timeN[1]);
    	
    	if(hour<0||hour>24) {
    		return false;
    	}
    	
    	if(minute<0||minute>=60) {
    		return false;
    	}
    	
    	return true;
    }
    
    public void addAccidentHis(String info) throws Exception {
//    	: 사고이력을 추가한다
//    	- info: location(장소), date(20190102), time(12:50)이 / 를 구분자로 add
//    	로타리사거리/20190501/14:00
//    	- 같은 사고이력을 추가할 수 없다
//    	- 잘못된 날짜와 시간이 추가되면 안된다
    	String[] keyValue=info.split("/",3);
    	String location=keyValue[0];
    	String date=keyValue[1];
    	String time=keyValue[2];
    	
    	
    	if(checkDateValue(date)&&checkTimeValue(time))
    		this.accidentHis.add(new Accident(location,date,time));
    	else{
    		throw new RuntimeException("잘못된 날짜/시간 형식입니다.");
    	}
    	
    }
    
    public void printAccidentHis(){
//    	: 사고이력을 출력한다
//    	형식: ‘{0} - {1} ? {2}’, {0}: 장소, {1}: 날자, {2}: 시간
//    			날자는 xxxx.xx.xx Format으로 출력한다
    	Iterator it = this.accidentHis.iterator();
    	while(it.hasNext()) {
    		Accident a = (Accident)it.next();
    		SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");	
    		System.out.println(a.getLocation()+" - "+sf.format(a.getDateFormat())+" ? "+a.getTime());
    	}
    	
    }
    
	public void addFixHis(String date, String item, String fixcmt) {
//		: 수리이력을 추가한다
//		- date별 item(수리부품)의 fixcmt(수리이력)을 추가한다
//		- date별 item(수리부품)은 중복될 수 없다
		if(!this.fixHis.containsKey(date)) {
			this.fixHis.put(date, new HashMap());
		}
		HashMap group = (HashMap) this.fixHis.get(date);
		group.put(item, fixcmt);
	}
	
	public void addFixHisTwo(String date, String item, String fixcmt) {
		HashMap group = new HashMap();
		String a = date+"/"+item+"/"+fixcmt;
		
	}
	
	public void printFixHis() {
//		: 수리이력을 출력한다
//		- 날자 - 부분 - 수리Cmt를 출력한다
		Set set = this.fixHis.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e =(Map.Entry)it.next();
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				
				String items=(String)subE.getKey();
				String fix = (String)subE.getValue();
				System.out.println(e.getKey()+" - "+items+" - "+fix);
			}
			System.out.println();
		}
		
	}
    
    
}

public class Pr0719 {

	public static void main(String[] args) {
		Car c = new Car("롤스로이스",2000,20000,"김김");
		try {
			c.addAccidentHis("로타리사거리/20190501/14:00");
			c.addAccidentHis("로타리사거리/20190501/14:00");//중복,입력되지 않음
			c.addAccidentHis("로타리삼거리/20190708/17:00");
			c.addAccidentHis("로타리/20191313/17:00");//날짜,예외출력
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			c.addAccidentHis("로타리2/20190501/25:00");//시간,예외출력
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("====================");
		c.printAccidentHis();
		System.out.println("====================");
		c.addFixHis("20190101", "엔진" , "삭제");
		c.addFixHis("20190101", "핸들" , "교체");
		c.addFixHis("20190101", "핸들" , "청소");//동일 날짜에 핸들 중복, 입력되지 않음
		c.addFixHis("20190102", "핸들" , "청소");
		c.addFixHis("20190102", "엔진" , "삭제");
		
		c.printFixHis();
		

	}

}
