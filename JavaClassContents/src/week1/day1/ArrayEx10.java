package week1.day1;

//내림차순 정렬하기
//	System.out.println(numArr[k]); //정렬된 결과를 출력한다.
public class ArrayEx10 {

	public static void main(String[] args) {
		int[] score= {79,88,91,33,100,55,95};
	
		for(int i=0;i<score.length;i++)
		{
			for(int j=i;j<score.length;j++)
			{
				if(score[i]<score[j])
				{
					int temp=score[j];//j값을 넣어둠
					score[j]=score[i];//i값을 j로 이동
					score[i]=temp;//i에 j값을 넣어줌(score[i]가 최대값이어야함)
				}
			}
		}
		for(int e : score)
			System.out.println("방법1:"+e);
		
//		int[] score2= new int[score.length];
//		Arrays.sort(score);
//		
//		for(int i=0;i<score.length;i++) {
//			score2[i]=score[i];
//		}
//		
//		int j=0;
//		for(int i =score.length-1;i>=0;i--)
//		{
//			score2[j]=score[i];
//			j++;
//		}
//		
//		for(int e : score)
//			System.out.println("방법2 : "+e);

	}

}
