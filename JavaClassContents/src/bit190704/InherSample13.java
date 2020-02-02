package bit190704;

import java.util.Scanner;

class MultiN{
	void printA(int x,int y[]) {
		for(int i=0;i<x;i++)
		{
			System.out.print(y[i]);
			if(i<x-1)
				System.out.print(",");
		}
		System.out.println();
	}
	
	
}


public class InherSample13 {

	public static void main(String[] args) {
		{
			int num[],even[],multiF[],count;//숫자 배열,입력된 숫자의 총합
			Scanner sc = new Scanner(System.in);
			System.out.println("입력할 숫자의 총 개수를 입력하세요:");
			count=sc.nextInt();
			num=new int[count];
			even=new int[count];
			multiF=new int[count];
			
			for(int i=0;i<count;i++) 
			{
				System.out.println((i+1)+"번 숫자를 입력하세요:");
				int input=sc.nextInt();
				num[i]=input;
			}
			System.out.println("모든 숫자가 입력되었습니다.");
			
			int evenCount=0,multiFCount=0;
			for(int i=0;i<count;i++)
			{
				if(num[i]%2==0)
				{
					even[evenCount]=num[i];
					evenCount++;
				}
				if(num[i]%5==0)
				{
					multiF[multiFCount]=num[i];
					multiFCount++;
				}
			}
			
			MultiN ap1 = new MultiN();
			System.out.println("짝수:");
			ap1.printA(evenCount, even);
			System.out.println("5의배수:");
			ap1.printA(multiFCount, multiF);
		}
	}

}
