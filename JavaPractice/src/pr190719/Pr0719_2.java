package pr190719;
/*

* Plane에 대한 클래스
1. 속성: private (String)model, private (String)airline
          , private (HashSet)fixHis (수리이력)
2. 생성자
   Plane(String model, String airline)
3. 메소드: 
   public void addFixHis(FixHis his): 수리이력을 추가한다
              - 같은 수리이력을 추가할 수 없다(airport/date/cmt)
   public void printFixtHis(): 수리이력을 출력한다
              - 수리이력을 출력: 공항-날자-사고내용

 * FixHis(수리이력) 클래스 
 1. 속성: private (String) airport(공항), private (String) date(수리일자)
           , private (String) cmt(수리내용)
 2. 생성자
   FixHis(Sting airport, String date, String cmt)
 3. 메소드
   get/set Method
   public boolean equals(Object obj) // override, 동일기준: 공항/수리일자/수리내용
   public int hashCode() // override,  동일기준: 공항/수리일자/수리내용

 * */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class Plane{
	private String model;
	private String airline;
	private HashSet fixHis=new HashSet();
	
	Plane(String model,String airline){
		this.model=model;
		this.airline=airline;
	}
	
	public void addFixHis(FixHis his) {
//		수리이력을 추가한다
//        - 같은 수리이력을 추가할 수 없다(airport/date/cmt)
		if(!(this.fixHis.add(his))) {
    		throw new RuntimeException("잘못된 날짜/시간 형식입니다.");
		}

	}
	
	public void printFixHis() {
//		수리이력을 출력한다
//        - 수리이력을 출력: 공항-날자-사고내용
		Iterator it = this.fixHis.iterator();
		while(it.hasNext()) {
			FixHis f = (FixHis)it.next();
			System.out.println(f);
		}
	}
}

class FixHis{
	private String airport;
	private String date;
	private String cmt;
	
	FixHis(String airport, String date, String cmt) {
		this.airport = airport;
		this.date = date;
		this.cmt = cmt;
	}

	String getAirport() {
		return airport;
	}

	void setAirport(String airport) {
		this.airport = airport;
	}

	String getDate() {
		return date;
	}

	void setDate(String date) {
		this.date = date;
	}

	String getCmt() {
		return cmt;
	}

	void setCmt(String cmt) {
		this.cmt = cmt;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FixHis) {
			FixHis tmp = (FixHis) obj;
			return this.airport.equals(tmp.airport)&&
					this.date.equals(tmp.date)&&
					this.cmt.equals(tmp.cmt);
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(this.airport,this.date,this.cmt);
	}
	
	public String toString() {
		return this.airport+"-"+this.date+"-"+this.cmt;
	}
	
}

public class Pr0719_2 {

	public static void main(String[] args) {
		Plane p  =new Plane("보잉","아시아나");
		FixHis f1 = new FixHis("아시아나","20190718","창문교체");
		FixHis f2 = new FixHis("아시아나","20190718","창문교체");
		FixHis f3 = new FixHis("아시아나","20190718","좌석시트교체");
		try {
			p.addFixHis(f1);
			p.addFixHis(f2);
			p.addFixHis(f3);
			p.addFixHis(f3);
			p.addFixHis(f3);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}


		p.printFixHis();

	}

}
