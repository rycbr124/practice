package bit190702;

//중요메소드!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class MethodSample11 {

	public static String toStr() {
		return "하하하하하하하하하하......";
	}
	
	public static void main(String[] args) {
	//1.startWith
	//문자열이 지정한 문자로 시작하는지 판단하여 같으면 true를 반환
	{
		System.out.println("===");
		String str="apple";
		boolean startWith = str.startsWith("a");
		System.out.println(startWith);
	}
	//2.endWith
	//문자열 마지막에 지정한 문자가 있는지 판단하여 같으면 true를 반환
	{
		System.out.println("===");
		String str2 = "test";
		boolean endw = str2.endsWith("t");
		System.out.println(endw);
	}
	//3.indexOf()
	//지정한 문자가 문자열에 몇 번째에 있는지를 반환합니다.
	{
		System.out.println("===");
		String str3 = "abcdefg";
		int indexOf = str3.indexOf('f');
		System.out.println(indexOf);
	}
	//4.equals()
	//두 개의 문자열의 내용(값)을 비교하여 같으면 true를 반환.
	{
		System.out.println("===");
		String str4="java";
		String str5="javascript";
		String str6="javaScript";
		String str7 = new String("javaScript");
		boolean eq1 = str5.equals(str6);
		System.out.println(eq1);
		
		str4=str6;
		boolean eq2 = str4.equals(str6);
		System.out.println(eq2);
		boolean eq3 = str4==str7;
		System.out.println(eq3);
		System.out.println(str4.equals(str7));
	}
	//5.lastIndexOf()
	//지정한 문자열이 마지막으로 몇번째에 존재하는가?
	//6.length();
	//문자열의 길이
	{
		System.out.println("===");
		String str3 = "abfcdefg";
		int lastIndexOf = str3.lastIndexOf('f');
		int length = str3.length();
		System.out.println(lastIndexOf);//마지막에 있는 f의 index 출력
		System.out.println(length);
	}
	//7.replace()
	//문자열에 지정한 문자가 있으면, 새로운 문자로 대체하라
	//8.replaceAll()
	//지정한 문자로 변경합니다.
	{
		System.out.println("===");
		String str="j av as c r ip t";
		String change=str.replace(" ","");
		System.out.println(change);
		String str2="ja va";
		String change2=str2.replaceAll("\\p{Space}","*");//정규화표현식,보안에 좋다
		System.out.println(change2);
	}
	//9.split
	//문자 구분
	{
		System.out.println("===");
		String str="A:B:C:D:abcd";// A B C D abcd
		String[] sp = str.split(":");
		System.out.println(sp[3]);
	}
	//10.substring()
	//문자열에 지정한 범위에 속하는 문자열을 반환합니다.
	//시작범위는 포함하지만, 끝 범위는 포함하지 않습니다.
	{
		System.out.println("===");
		String str="abcdefg";
		String sub = str.substring(0, 3);
		System.out.println(sub);//a,b,c
	}
	//11.toLowerCase()
	//대문자를 소문자로 변경
	//12.toUpperCase()
	//소문자를 대문자로 변경
	//13.trim()
	//양 사이드의 문자열의 공백을 제거합니다.가운데 공백은 제거하지 않습니다.
	{
		System.out.println("===");
		String str = "  java    java	java	";
		String v = str.trim();
		System.out.println(v);
	}
	//14.toString()
	//문자열을 있는 그대로 출력합니다.
	System.out.println("===");
	System.out.println(MethodSample11.toStr().toString());
	//15.contains()
	//두 개의 문자열을 비교하여 비교대상인 문자열을 포함하고 있으면 true
	{
		System.out.println("===");
		String str1="abcdefg";
		String str2="c";
		boolean cont=str1.contains(str2);
		System.out.println(cont);
	}	
	//16.charAt()
	//지정한 index에 해당하는 문자 한 글자를 반환.
	//17.concat()
	//문자와 문자를 결합합니다.
	{
		System.out.println("===");
		String str = "Hello";
		String str2 = "Java";
		String conn = str.concat(str2);
		System.out.println(conn);
	}
	//18.format()
	{
		System.out.println("===");
		int i = 1234567890;
		String str = String.format("%,d", i);
		System.out.println(str);
	}
	//19.replaceFirst():문자열에 지정한 문자"   "가 있으면, 첫 번째만 새로 지정한 문자"   "로 변경한다.
	{
		System.out.println("===");
		String str="BmanB";
		String st = str.replaceFirst("B", "super");
		System.out.println(st);//supermanB
	}
	
	
	}
	
}
