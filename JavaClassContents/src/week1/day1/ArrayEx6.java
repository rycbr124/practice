package week1.day1;
//최대값/최소값 구하기
public class ArrayEx6 {

	public static void main(String[] args) {
		int[] score= {79,88,91,33,100,55,95};
		int max=score[0],min=score[0];
		for(int k=0;k<score.length;k++)
		{
			if(max<score[k])
			{
				max=score[k];
			}else if(min>score[k])
			{
				min=score[k];
			}
			
		}
		
		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min);

	}

}
