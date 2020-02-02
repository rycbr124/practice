package bit190701;

public class measure {
		
	public static int measure(int x){//100,200
		int sum=0;
		for(int i=1;i<=x;i++) {
			if(x%i==0)//100%1... 200%1...
			{
				System.out.println(i+"번째 약수="+i);
				sum+=i;
			}
		}
		return sum;
	}
}