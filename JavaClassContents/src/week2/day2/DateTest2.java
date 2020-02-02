package week2.day2;
//java.util.Date = 오라클 날짜 타입과 연동불가
//java.sql.Date = 오라클 날짜 타입과 연동가능
import java.text.ParseException;

public class DateTest2 {

	public static void main(String[] args) throws ParseException {
		System.out.println("=======String to sql.date========");
		String day = "2016-11-22";//형식을 지켜야 함
		java.sql.Date d = java.sql.Date.valueOf(day);
		System.out.println(d);
		System.out.println("\n=======String to sql.timestamp========");
		String day2 = "2016-11-22 11:22:30.0";//형식을 지켜야 함
		java.sql.Timestamp t = java.sql.Timestamp.valueOf(day2);
		System.out.println(t);
		System.out.println("\n=======String to util.date========");
		String day3 = "20161122";//SimpleDateFormat 생성자에 전달되는 형식과 일치해야 함.
		java.util.Date d3 = new java.text.SimpleDateFormat("yyyyMMdd").parse(day);
		System.out.println(d3);
		System.out.println("\n=======util.date to sql.date========");
		java.util.Date u = new java.util.Date();
		java.sql.Date s = new java.sql.Date(u.getTime());
		System.out.println(s);

	}

}
