/*
실습1: Dog에 대한 클래스 
속성: private (String)name, private (int)age, private (String)kind (품종)
          , private (ArrayList)inoculate (예방접종)
          , private (HashSet)Handler, private (HashMap) family
- 생성자
   Dog(String name, int age, String kind)
- 메소드: 
   public void shotInoculate(String name, Date date): 예방접종을 하다
              - inoculate 속성에 이름과 날자에 해당하는 예방접종 정보 저장
              - 동일한 예방접종을 하면 안된다 
              - 품종별 예방접종 가능 기간이 아니면 오류 발생
                 “예방접종 가능 기간이 아닙니다”
   public void printInoculateHistory(): 예방접종 이력을 날자별 정렬하여 출력한다,
                              형식: ‘{0} - {1}’, {0}: 날자, {1}:예방접종명
                              날자는 xxxx.xx.xx Format으로 출력한다
   public void addHandler(String name, String strDt, String endDt): Handler추가
               - name/strDt/endDt가 동일한 값을 추가될 수 없다
   public int getTotalHandlerPeriod(): Handler의 총 훈련기간을 리턴한다
   public void addFamily(String info): 가족을 추가한다
              - info는 type과 name으로 구성되며, /로 구분된다, 예)부견/낙동
              - type: 부견/모견/형재/자매, name: 이름
              - 이름은 중복 될 수 없다 품종: 셰퍼드, 진도견, 보더콜리
** 예방접종간격:
  - 셰퍼드: 7일 이상
  - 진도견: 10일 이상
  - 보더콜리: 15일 이상
 * */
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


class Vac implements Comparable{
	private String vacName;
	private Date vacDate;

	Vac(){}
	
	Vac(String name,Date date){
		this.vacName=name;
		this.vacDate=date;
	}
	
	public String getVacName() {
		return vacName;
	}
	
	public void setVacName(String vacName) {
		this.vacName = vacName;
	}
	
	public Date getVacDate() {
		return vacDate;
	}
	
	public void setVacDate(Date vacDate) {
		this.vacDate = vacDate;
	}
	
	public boolean compareDate(String name,String date) {
		//밀리세컨드=1s/1000;
		int yeardiff=Integer.valueOf(date.substring(0, 4))-Integer.valueOf(this.vacDate.toString().substring(0, 4));
		int monthdiff=Integer.valueOf(date.substring(5, 7))-Integer.valueOf(this.vacDate.toString().substring(5, 7));;
		int daydiff=Integer.valueOf(date.substring(8))-Integer.valueOf(this.vacDate.toString().substring(8));;
		int diff=0;
		
		if(name.equals("셰퍼드")) {
			diff=7;
		}else if(name.equals("진도견")) {
			diff=10;
		}else if(name.equals("보더콜리")) {
			diff=15;
		}
		
		if((yeardiff*365)+(monthdiff*12)+(daydiff)<diff) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public int compareTo(Object o) {
		return this.getVacDate().compareTo( ((Vac)o).getVacDate() );
	}
	
}

class Handlers{
	private String name,strDt,endDt;

	public Handlers(String name, String strDt, String endDt) {
		this.name = name;
		this.strDt = strDt;
		this.endDt = endDt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public boolean equals(Object obj) {
		if(obj instanceof Handlers) {
			Handlers tmp = (Handlers)obj;
			return this.name.equals(tmp.name)&&
					this.strDt.equals(tmp.strDt)&&
					this.endDt.equals(tmp.endDt);
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(this.name,this.strDt,this.endDt);//같은 "객체" 내에서 유일한 hash값 리턴?
	}
	
	public long DiffOfDate() {
		Date sd=Date.valueOf(this.strDt);
		Date ed=Date.valueOf(this.endDt);
		long lo = ed.getTime()-sd.getTime();
		long day=  lo/(1000*60*60*24);

		return day;
	}
	
	public String toString() {
		return "이름 : "+this.name+", 시작일 : "+strDt+", 종료일 : "+endDt;
	}
	
	
}

class Dog{
	private String name;
	private int age;
	private String kind;
    private ArrayList inoculate=new ArrayList();
    private HashSet Handler=new HashSet();
    private HashMap family=new HashMap();
    
    Dog(String name,int age,String kind){
    	this.name=name;
    	this.age=age;
    	this.kind=kind;
    }
    
    
    //family값 확인을 위한 출력메소드
    public void printFamily() {
		Set set = family.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : "+e.getKey()+", 관계 : "+e.getValue());
		}
	}

    //hander값 확인을 위한 출력메소드
    public void printHandler() {
    	Iterator it = this.Handler.iterator();
    	while(it.hasNext()) {
    		System.out.println((Handlers)it.next());
    	}
    	
    }

	public void shotInoculate(String vName, Date date) {
//    	예방접종을 하다
//        - inoculate 속성에 이름과 날자에 해당하는 예방접종 정보 저장
//        - 동일한 날짜에 같은 예방접종을 하면 안된다 
//        - 품종별 예방접종 가능 기간이 아니면 오류 발생
//           “예방접종 가능 기간이 아닙니다”

    	Iterator it = this.inoculate.iterator();
    	
		if(!(it.hasNext())) {
			this.inoculate.add(new Vac(vName,date));
		}else {
			while(it.hasNext()) {
				Vac v = (Vac)it.next();
				if(v.getVacName().equals(vName) && v.getVacDate().equals(date)) {
					throw new RuntimeException("이미 오늘 해당 예방접종을 맞았습니다.");
				}else if(v.compareDate(this.kind,date.toString()) ) {
					throw new RuntimeException("예방접종 가능 기간이 아닙니다.");
				}
			}
			this.inoculate.add(new Vac(vName,date));
		}

    }
    
    public void printInoculateHistory() {
//    	: 예방접종 이력을 날자별 정렬하여 출력한다,
//    	형식: ‘{0} - {1}’, {0}: 날자, {1}:예방접종명
//    	날자는 xxxx.xx.xx Format으로 출력한다

    	Collections.sort(this.inoculate);//Iterator 선언보다 위에 있어야 한다.
    	Iterator it = this.inoculate.iterator();
    	for(int i=0;i<this.inoculate.size();i++) {
    		SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
    		Vac v = (Vac) this.inoculate.get(i);
    		System.out.println(v.getVacName() +" - "+ sf.format(v.getVacDate()));
    	}
    	
    }
    
    public void addHandler(String name, String strDt, String endDt) {
//    	: Handler추가
//    	- name/strDt/endDt가 동일한 값을 추가될 수 없다
    	this.Handler.add(new Handlers(name,strDt,endDt));
    }
    
    public int getTotalHandlerPeriod() {
//    	: Handler의 총 훈련기간을 리턴한다
    	int allPeriod=0;
    	Iterator it = this.Handler.iterator();
    	while(it.hasNext()) {
    		Handlers h = (Handlers)it.next();
    		allPeriod+=h.DiffOfDate();
    	}
    	return allPeriod;
    	
    }
    
    public void addFamily(String info) {
//    	: 가족을 추가한다
//    	- info는 type과 name으로 구성되며, /로 구분된다, 예)부견/낙동
//- type: 부견/모견/형재/자매, name: 이름
//- 이름은 중복 될 수 없다 
    	String[] keyValue=info.split("/",2);
    	this.family.put(keyValue[1], keyValue[0]);
    }
    
}


public class Pr190718 {

	public static void main(String[] args) {
		
		Dog d1 = new Dog("바둑이",12,"진도견");
		d1.shotInoculate("1차예방접종", Date.valueOf("2019-11-15"));
		try {
			d1.shotInoculate("2차예방접종", Date.valueOf("2019-11-24"));//10일이내,에러 발생
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		d1.shotInoculate("2차예방접종", Date.valueOf("2019-11-25"));//10일이상,정상입력
		try {
			d1.shotInoculate("2차예방접종", Date.valueOf("2019-11-25"));//동일 예방접종 존재,에러 발생
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		d1.shotInoculate("3차예방접종", Date.valueOf("2020-11-15"));
		System.out.println("=============================");
		d1.printInoculateHistory();
		System.out.println("=============================");
		d1.addHandler("강형우", "2018-08-05", "2018-09-05");
		d1.addHandler("강형우", "2018-11-05", "2018-12-05");
		d1.addHandler("강형우", "2018-11-05", "2018-12-05");//중복값,입력되지않음
		d1.printHandler();
		System.out.println(d1.getTotalHandlerPeriod()+"일");
		System.out.println("=============================");
		d1.addFamily("모견/우주");
		d1.addFamily("부견/항성");
		d1.addFamily("자매/항성");//동일한 key(우주)값,이전값이 삭제되고 현재값으로 업데이트
		d1.printFamily();
		
	}

}
