package week1.day2;

import java.util.Scanner;

//실습2 배열원소 이동
//-입력 : 1~10
//-출력:{2,3,4,5,6,7,1}


public class ArrayMove {
	int a;
	int arrayR[];
	
	ArrayMove(int a,int[] b){
		this.a=a;
		this.arrayR=b;
	}
	
	int[] Moving() {
		
		int[] c = new int[arrayR.length];
		int count=0;
		
		//c배열에 b배열을 복제
		for(int i=0;i<arrayR.length;i++) {
			c[i]=arrayR[i];
		}
		
		//7이상의 값 입력시 정상 출력을 위한 a값 변경
		a=a%arrayR.length;
		
		for(int i=0;i<arrayR.length;i++)
		{
			if(i+a<arrayR.length)
			{
				int temp=arrayR[i];
				arrayR[i]=arrayR[i+a];
				arrayR[i+a]=temp;
			}else
			{
				int temp=c[count];
				arrayR[i]=temp;
				count++;
			}
		}
		return arrayR;
	}
		
	
	public String toString(){
		String a = "";
		int[] b = Moving();
		
		for(int i=0;i<b.length;i++)
		{
			a+=b[i];
			if(i!=b.length-1)
				a+=","; 
		}
		return "{"+a+"}";
		
	}
	public static void main(String[] args) {
		int move;//옮길 칸 수
		int[] irr = {1,2,3,4,5,6,7};
					//3,4,5,6,7,2,1
		
		Scanner sc = new Scanner(System.in);
		System.out.print("옮길 칸 수를 입력해주세요:");
		move=sc.nextInt();
		
		ArrayMove am = new ArrayMove(move,irr);
		System.out.println(am);
		sc.close();
	}

}
