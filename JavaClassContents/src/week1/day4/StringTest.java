package week1.day4;

public class StringTest {
//String의 주요 생성자와 메소드
	public static void main(String[] args) {
		//String(char[] value) 생성자
		{
		char[] c= {'H','e','l','l','o'};
		String s = new String(c);
		System.out.println(s);//Hello
		}
		//String(StringBuffer buf)생성자
		{
		StringBuffer sb=new StringBuffer("Hello");
		String s = new String(sb);
		System.out.println(s);//Hello
		}
		//char charAt(int index)메소드
		{
		String s = "Hello";
		char c=s.charAt(1);//e
		System.out.println(c);
		}
		//int compareTo(String str) 메소드
		//사전순으로 비교-1/0/1 //앞/같음/뒤
		{
		int l="aaa".compareTo("aaa");//0
		System.out.println(l);
		}
		//String concat(String str) 메소드
		//문자열 덧붙임
		{
		String s = "Hello";
		String s2 = s.concat(" World");//Hello World
		System.out.println(s2);
		}
		//boolean contains(CharSequence s) 메소드
		//지정된 문자열이 포함되었는지 검사
		{
		String s = "abcdefg";
		boolean b = s.contains("bc");//true
		System.out.println(b);
		}
		System.out.println("============1=============");
		//boolean endsWith(String suffix) 메소드
		//지정된 문자열로 끝나는지 검사
		{
		String file = "Hello.txt";
		boolean b = file.endsWith("txt");//true
		System.out.println(b);
		}
		//int indexOf(int ch) 메소드 오버로딩
		//문자(ch)가 존재하는 위치(0부터 시작)
		//indexOf메소드들은 값을 찾을 수 없을 경우 -1을 출력한다. 따로 index를 의미하는 것은 아니다.
		{
		String s = "Hello";
		int idx1 = s.indexOf('o');//4
		System.out.println(idx1);
		}
		//int indexOf(int ch, int pos) 메소드 오버로딩
		//문자(ch)가 존재하는 위치를 pos부터 확인하여 index를 알려줌
		//앞에 있는 데이터는 무시하고 다음 데이터부터 찾고싶을 때
		{
		String s = "Hello";
		int idx1= s.indexOf('e',0);//1
		int idx2= s.indexOf('e',2);//-1
		System.out.println(idx1+","+idx2);
		}
		//int indexOf(String str) 메소드 오버로딩
		//문자열이 존재하는 위치
		{
		String s = "ABCDEFG";
		int idx = s.indexOf("CD");//2
		System.out.println(idx);
		}
		//int lastIndexof(int ch)
		//문자를 오른쪽 끝에서부터 찾아서 위치 리턴
		{
		String s = "java.lang.Object";
		int idx1 = s.lastIndexOf('.');//9,index 순서는 왼쪽부터
		System.out.println(idx1);
		}
		//String replace(char old, char nw)
		//old 문자를 nw로 변경
		{
		String s = "Hello";
		String s1 = s.replace('H', 'C');//Cello
		System.out.println(s1);
		}
		//String replaceAll(String regex, String nw)
		//전체변경
		{
		String sb = "AABBAABB";
		String r = sb.replaceAll("BB", "bb");//AAbbAAbb
		System.out.println(r);
		}
		//String replaceFirst(String regex, String nw)
		//일치하는 것중 첫번째 것만 변경
		{
		String sb = "AABBAABB";
		String r = sb.replaceFirst("BB", "bb");//AAbbAABB
		System.out.println(r);
		}
		//String[] split(String regex)
		//분리자로 나누어 배열을 반환
		//특수구분자 사용주의,\\ 붙이고 쓸 것
		{
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");//{dog,cat,bear}
		for(String s : arr)
			System.out.print(s+" ");
		}
		System.out.println("\n==========2==============");//%n은 안먹힘
		//String[] split(String argex,int limit) //많이 쓰인다
		//분리하되 문자열을 limit 수만큼 자른다
		{
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",",2);//arr[0]:dog, arr[1]:cat,bear
		for(String s : arr)
			System.out.print(s+" ");
		System.out.println();
		}
		//boolean startWith(String prefix)
		//주어진 문자열로 시작하는지 검사
		{
		String s = "java.lang.Object";
		boolean b = s.startsWith("java");//true
		System.out.println(b);
		}
		//String trim() //많이 쓰인다
		//문자열의 왼쪽,오른쪽 끝에 있는 공백을 없앤 결과를 반환
		{
		String s = "		Hello World	";
		String s1 = s.trim();//"Hello World"
		System.out.println(s1);
		}
		//static String valueOf(boolean b);
		//오버로딩 파라미터값:char/int/long/float/double/Object
		//지정된 값을 문자열로 반환
		{
		String b = String.valueOf(true);
		System.out.println(b);//true
		}
		//static String join(CharSequence arg(),CharSequence...arg1)	//많이 쓰임
		//구분자랑 같이 합쳐준다.한 줄로.
		{
		String[] arr = {"A","B","C"};
		String s = String.join("-", arr);//A-B-C
		System.out.println(s);
		}
		
		System.out.println("===========StringBuffer==================");
		//return값이 StringBuffer 클래스인 메소드들은
		//새로운 인스턴스를 생성하여 주소값을 옮기는 것이 아니라
		//원본값 자체가 변경이 된다.
		
		//StringBuffer(String str) 생성자
		{
		StringBuffer sb=new StringBuffer("H1");//H1
		System.out.println(sb);
		}
		//StringBuffer append(boolean b) //StringBuffer형 리턴
		//기본자료형/char[]/Object/String 문자열 뒤에 붙기 //많이 쓰임
		{
		StringBuffer sb = new StringBuffer("abc");
		sb.append("abc");//abcabc
		System.out.println(sb);
		}
		//char charAt(int index)
		{
		StringBuffer sb = new StringBuffer("abc");
		char c = sb.charAt(2);//c
		System.out.println(c);
		}
		//StringBuffer delete(int start,int end)
		//start~end 사이의 문자를 제거
		{
		StringBuffer sb = new StringBuffer("0123456");
		sb.delete(1, 6);//06
		System.out.println(sb);
		}
		//StringBuffer deleteCharAt(int index)
		//지정된 위치의 문자 제거
		{
		StringBuffer sb = new StringBuffer("0123456");
		sb.deleteCharAt(3);
		System.out.println(sb);//012456
		}
		System.out.println("=============1============");
		//StringBuffer insert(int pos, boolean b)
		//오버로딩 파라미터값(int pos,char/char[]/double/float/int/long/Object/String)
		//문자열로 변환하여 pos에 추가
		{
		StringBuffer sb = new StringBuffer("0123456");
		sb.insert(4,',');//0123,456
		System.out.println(sb);
		}
		//StringBuffer replace(int start,int end,String str) //많이 쓰임
		//지정된 범위의 문자열을 주어진 문자열로 바꾼다.
		{
		StringBuffer sb = new StringBuffer("0123456");
		sb.replace(3, 6, "AB");//012AB6
		System.out.println(sb);
		}
		//StringBuffer reverse() //많이 쓰임
		//문자열 순서를 거꾸로
		{
		StringBuffer sb = new StringBuffer("0123456");
		sb.reverse();//6543210
		System.out.println(sb);
		}
		//String substring(int start)
		//start 인덱스 부터 리턴
		//String substring(int start,int end)
		//start<= index <end 범위 리턴
		{
		StringBuffer sb = new StringBuffer("0123456");
		String str= sb.substring(3);//3456
		String str2= sb.substring(3,5);//34
		System.out.println(str+","+str2);
		}

	}

}
