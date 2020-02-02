package week2.day2;
//Vector v = new Vector(); 
//Class.forName("java.util.Vector").newInstance(); ->동일하다

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
	public String str;
	
	public ReflectTest(String str) {
		this.str=str;
		System.out.println("REFLECT 생성자 호출:"+str);
	}
	
	public void test01(String paramStr) {
		System.out.println("test01 메소드호출:"+paramStr);
	}
	
	public void test02() {
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, 
	NoSuchMethodException, IllegalArgumentException, InstantiationException, 
	IllegalAccessException, InvocationTargetException{
		
			Class c = Class.forName("week2.day2.ReflectTest");
			System.out.println(c);//Class명 출력
			Constructor[] ctor = c.getConstructors();// 생성자를 얻는다.
			for(int i=0;i<ctor.length;i++) {
				System.out.println("생성자:"+ctor[i].toString());
			}
			
			Method m[] = c.getMethods();//메소드를 얻는다.
			for(int i=0; i<m.length;i++) {
				System.out.println("메소드:"+m[i].toString());
			}
			//메소드 호출하기
			Class c2=Class.forName("week2.day2.ReflectTest");
			//String 하나를 매개변수로 가지는 파라미터 형식을 만든다.
			Class[] parameterTypes = new Class[] {String.class};
			//String을 인자로 받는 생성자에 접근하는 정보를 얻는다.
			Constructor constuctor = c2.getConstructor(parameterTypes);
			//객체 생성
			Object obj = constuctor.newInstance(new Object[] {"REFLECT"});
			
			//String 하나를 매개변수로 가지는 파라미터 형식을 만든다.
			Class[] parameterTypes2 = new Class[] {String.class};
			//String을 인자로 받는 메소드에 접근하는 정보를 얻는다.
			//method명,파라미터(오버로딩)
			Method method = c2.getMethod("test01", parameterTypes2);
			Object[] parameters = new Object[] {"메소드호출"};
			//메소드를 호출한다.
			Object oResult = method.invoke(obj, parameters);
			
	}

}
