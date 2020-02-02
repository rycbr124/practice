package week1.day3;


abstract class Sorter{
	abstract boolean isCorrectOrder(String o,String o2);

	void doSort(String[] list) {
		for(int max=list.length-1;max>0;max--) {
			for(int i =0; i<max;i++) {
				if(!isCorrectOrder(list[i],list[i+1])) {
					String temp;
					temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
				}
			}
		}
		
	}
}

class StringSorter extends Sorter{
	boolean isCorrectOrder(String o, String o2){
		if(((String)o).compareTo((String)o2)<=0) {//o<o2
			System.out.println(o+","+o2+": TRUE,"+((String)o).compareTo((String)o2));
			return true;
		}else {
			System.out.println(o+","+o2+": FALSE,"+((String)o).compareTo((String)o2));
			return false;
		}
	}
}

public class SortTest {
	public static void main(String[] args) {
		String[] names = {"이인화","한희원","김성연","심재후"};
		Sorter s = new StringSorter();
		s.doSort(names);
		for(int i=0;i<names.length;i++) {
			System.out.println(names[i]);
		}
	}
}