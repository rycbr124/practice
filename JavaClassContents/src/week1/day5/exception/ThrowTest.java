package week1.day5.exception;

//Checked Exception
//사용자 Exception, Exception을 상속받으므로 Checked Exception
class SumDivideDiffException extends Exception
{
	public int x,y;
	SumDivideDiffException(int x, int y)
	{
		super("SumDivideDiff Exception");
		this.x = x;
		this.y = y;
	}
}

public class ThrowTest {

	public static int sumDivideDiff(int x, int y) throws SumDivideDiffException 
	{
		if(x==y)
			throw new SumDivideDiffException(x,y);//ERROR 발생 상황에서 Exception 강제 발생
		return (x+y)/(x-y);
	}

	//Unchecked Exception throw =>throws 안해줘도됨
	public static int sumDivideDiff2(int x, int y)
	{
		if(x==y)
			throw new RuntimeException();
		return (x+y)/(x-y);
	}
	
	public static void main(String[] args) 
	{
		try
		{
			int i = sumDivideDiff(8,4) + sumDivideDiff(3,3);
			System.out.println("result = "+i);
		}
		catch(SumDivideDiffException e) 
		{
			System.out.println("value of i is not calculated: "+e.getMessage()+"("+e.x+e.y+")");
		}
		System.out.println("End of main()");
	}

}
