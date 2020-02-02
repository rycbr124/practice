package bit190701;
//문제] AddSum(100); 이것을 이용하여 클래스 내부에서 구현하고, 또 클래스 외부에서 구현하여 
	//출력 하도록 합니다.  
	// MethodSample7 class (내부 구현), 객체: ms7
	// CalAddSum class(외부 구현), 객체: cas
		
		
public class MethodSample7 {
	//Field Area
	
	private static int AddSum(int i) { //100, 99, 98, 97
		if(i == 1) {
		return 1;
	}else {
		return i + AddSum(i-1);//100+99=199+98=?+97=?+96=?+95.....3+2+1
	}
}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MethodSample7 ms7 = new MethodSample7();
		System.out.println("1.내부 : 1~100 합계는 = " + ms7.AddSum(100));//5050
		
		//System.out.println("1.내부 : 1~100 합계는 = " + AddSum(100));
		
		CalAddSum cas = new CalAddSum();
		System.out.println("2.외부: 1~100 합계는 = " + cas.AddSum(100));
	}

}
