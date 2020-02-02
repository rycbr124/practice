package week2.day2;

import java.sql.Date;
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

public class FormatPractice01 {

	public static void main(String[] args) {
		//DecimalFormat : 숫자 형식화
		System.out.println("DecimalFormat:");
		DecimalFormat df2 = new DecimalFormat("#,###.##");
		System.out.println(df2.format(123456789.98));
		DecimalFormat df3 = new DecimalFormat("#,###");
		System.out.println(df3.format(123456789));
		//SimpleDateFormat : 날짜 형식화
		System.out.println("\nSimpleDateFormat:");
		Date today = new Date(0);
		System.out.println(today);
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		System.out.println(sdf4.format(today));
		//ChoiceFormat : 특정범위를 문자열로 변환
		System.out.println("\nChoiceFormat:");
		//#은 경계값 포함(작거나 같다.), <은 경계값 미포함
		String pattern = "60#D|70#C|80<B|90#A"; //90은 A,80은 B
		int[ ] scores = {91,90,80,88,70,52,60};
		ChoiceFormat form = new ChoiceFormat(pattern);
		for(int i =0;i<scores.length;i++){
			System.out.println(scores[i]+":"+form.format(scores[i]));
		}
		//MessageFormat
		System.out.println("\nMessageFormat:");
		String msg = "Name: {0} \nTel: {1} \nAge:{2} \nBirthday:{3}";
		System.out.println(msg+"\n");
		
		Object[] arguments = new Object[0];
		
		String result = MessageFormat.format(msg, arguments);
		//static String	format(String pattern, Object... arguments)
		//Creates a MessageFormat with the given pattern and uses it to format the given arguments.
		System.out.println(result);
		
		
	}

}
