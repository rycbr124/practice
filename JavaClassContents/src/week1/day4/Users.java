package week1.day4;
//객체에 대한 복사본을 만든다

import java.util.ArrayList;
import java.util.List;

public class Users implements Cloneable{

	private List<String> userList;
	public Users() {
		userList=new ArrayList();
	}
	
	public Users(List list) {
		this.userList = list;
	}
	
	public void loadData() {
		userList.add("1");
		userList.add("2");
		userList.add("3");
		userList.add("4");

	}
	
	public void print() {
		System.out.println(userList);
	}
	
	public List<String> getUserList(){
		return userList;
	}
	
	//Object 오버라이딩,리턴타입 동일해야함
	public Object clone() throws CloneNotSupportedException{
		List<String>temp=new ArrayList();
		
		for(String s : this.getUserList()) {
			temp.add(s);
		}
		
		return new Users(temp);//복사된 카피본을 리턴
		//new가 붙었으므로 새로운 인스턴스를 생성하여 리턴한다.
	}
	
	public static void main(String[] args) throws Exception{
		Users orginUsers = new Users();
		orginUsers.loadData();//원본 데이터 호출
		Users cloneUsers =(Users)orginUsers.clone();//기존 인스턴스에 클론메소드 호출
							//오브젝트 클래스를 강제 형변환
		cloneUsers.print();
	}

}
