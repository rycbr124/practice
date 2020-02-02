package week1.day1;
//refector:이동,이름변경
//Project->clean:class파일 
public class VarArgsEx {

	public static void main(String[] args) {
		String[] strArr = {"100","200","300"};
		
		System.out.println(concatenate("","100","200","300"));
		System.out.println(concatenate("-",strArr));
		System.out.println(concatenate(",",new String[] {"1","2","3"}));
		System.out.println("["+concatenate(",",new String[0])+"]");
		System.out.println("["+concatenate(",")+"]");

		
	}



//가변인자: 타입...변수명
//가변인자는 항상 마지막 매개변수
	static String concatenate(String delim, String...args ) {
		String result = "";
		
		for(String str : args) {
			result+=str+delim;
		}
	
		return result;
	}

}

// JDK1.5부터 매개변수의 개수를 동적으로 지정해 줄 수 있게 되었는데 이 기능을 가변인자(variable argument)라고 한다.
//가변인자가 없었던 전 버전에서는 매개변수로 컬렉션이나 배열을 사용 했었다.
//가변인자는 내부적으로 배열을 생성해서 사용한다
//ex) printf()
//가능하면 가변인자를 사용한 메소드는 오버로딩을하지 않는 것이 좋다.