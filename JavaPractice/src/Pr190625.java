
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr190625 {

	public static void main(String[] args) throws IOException {
		//과제1
		System.out.println("===================과제1========================");
		int aa=100, bb=200, cc=10, dd=20, xx, yy, sumsum, hap;
		aa++;
		System.out.println("=========aa++==========");
		System.out.println("100"+",다음 대입 부터는 aa=101");
		System.out.println(aa);
		
		--cc;
		System.out.println("==========--cc==========");
		System.out.println("9"+",다음 대입 부터도 cc=9");
		System.out.println(cc);
		
		xx=(aa++)+cc;
		System.out.println("=====xx=(aa++)+cc=======");
		System.out.println("110"+",다음 대입 부터는 aa=102");
		System.out.println(xx);
		
		dd++;
		System.out.println("===========dd++=========");
		System.out.println("20"+",다음 대입 부터는 dd=21");
		System.out.println(dd);
		
		sumsum = cc + aa++;
		System.out.println("=========cc + aa++======");
		System.out.println("111"+",다음 대입 부터는 aa=103");
		System.out.println(sumsum);
		
		hap = bb++ - aa + cc;
		System.out.println("=====bb++ - aa + cc=====");
		System.out.println("106"+",다음 대입 부터는 bb=201");
		System.out.println(hap);
		
		yy = sumsum + hap; 
		System.out.println("======sumsum + hap======");
		System.out.println("217");
		System.out.println(yy);
		
		//과제2
		System.out.println("=============과제2==============");
		System.out.println("1==2");
		System.out.println(1==2);
		System.out.println("1!=2");
		System.out.println(1!=2);
		System.out.println("1>2");
		System.out.println(1>2);
		System.out.println("1<2");
		System.out.println(1<2);
		System.out.println("1>=2");
		System.out.println(1>=2);
		System.out.println("1<=2");
		System.out.println(1<=2);
		
		
		//과제3
		System.out.println("===============과제3=============");
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("첫 번째 숫자를 입력하세요.");
		float num1 = Integer.parseInt(scan.readLine());
		System.out.println("두 번째 숫자를 입력하세요.");
		String numb2 = scan.readLine();
		int num2 = (int) Float.parseFloat(numb2);
		System.out.println(num1);
		System.out.println(num2);
		
		
		boolean and = num1==num2;
		boolean not = num1!=num2;
		boolean cp1 = num1>num2;
		boolean cp2 = num1<num2;
		boolean cp3 = num1>=num2;
		boolean cp4 = num1<=num2;
		
		System.out.println("==연산자는:" + and);
		System.out.println("!=연산자는:" + not);
		System.out.println(">연산자는:" + cp1);
		System.out.println("<연산자는:" + cp2);
		System.out.println(">=연산자는:" + cp3);
		System.out.println("<=연산자는:" + cp4);
	}

}
