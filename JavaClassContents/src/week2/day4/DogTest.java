package week2.day4;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class DogTest{

}

class Inoculate implements Comparable{
	String name;
	Date date;
	
	public Inoculate(String name, Date date) {
		this.name=name;
		this.date=date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

class Dog2{
	private String name;
	private int age;
	private String kind;
    private ArrayList inoculate=new ArrayList();
    private HashSet Handler=new HashSet();
    private HashMap family;
    
    Dog2(String name,int age,String kind){
    	this.name=name;
    	this.age=age;
    	this.kind=kind;
    }
    
    public void shotInoculate(String vName, Date date) throws Exception {
    	Inoculate in = new Inoculate(name,date);
    	
    	if(inoculate.contains(in)) {
    		throw new Exception("중복된 예방접종입니다.");
    	}
    	
    	Collections.sort(inoculate);
    	Inoculate max = (Inoculate) inoculate.get(inoculate.size()-1);
    	
    	long day=0;
    	if("셰퍼드".equals(this.kind)) {
//    		day=diffOfDate(max.getDate().toString(),date.toString());
    		
    	}
    	
    }
}