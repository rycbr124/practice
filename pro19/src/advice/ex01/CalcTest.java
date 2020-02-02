package advice.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class CalcTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");//루트(src안에 넣어야한다.)
		//BeanFactory context = new XmlBeanFactory(new FileSystemResource("AOPTest.xml"));
		Calculator cal = (Calculator) context.getBean("proxyCal");
		cal.add(100, 20);
		System.out.println();
		cal.subtract(100, 20);
		System.out.println();
		cal.multiply(100, 20);
		System.out.println();
		cal.divide(100, 20);
	}

}
