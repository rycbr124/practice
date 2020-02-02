package week2.day2;

import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;

//util.Date 잘 안씀
//sql.Date 많이 쓰인다.(sql과 연동)
//sql Date 사용 시 형식을 지켜야 한다.
//format은 db로 저장을 하지 않는다.->20191201
//data타입을 다 없애고 string8자리로 받는 회사도 많다.(리소스를 많이 잡아먹음,정렬이 어려움)
//java.sql.Date=> 패키지명,import하면 적어주지 않아도 된다.

//실무에서는 이렇게 복잡하게 변경하지는 않는다. 예시를 위한 코드
public class DateTest {
	
	//날짜가 yymmdd 형식으로 입력되었을 경우 Date로 변경하는 메소드
	public java.sql.Date transformDate(String date) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
		
		//Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date tempDate = null;
		
		try {
			//현재 yyyymmdd로된 날짜 형식으로 java.util.Date객체를 만든다.
			tempDate =beforeFormat.parse(date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		//java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
		String transDate  = afterFormat.format(tempDate);
		
		//반환된 String 값을 Date로 변경한다.
		Date d = Date.valueOf(transDate);
		
		return d;
	}
	
	public static void main(String[] args) {
		DateTest dt = new DateTest();
		System.out.println(dt.transformDate("20190716"));
	}

}
