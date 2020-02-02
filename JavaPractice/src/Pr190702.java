

import java.util.Scanner;

class Quest1{
	int kor,eng,math;
	
	public Quest1(int kor, int eng, int math) {
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	double average(){
		double avg=sum()/3;
		return avg;
	}
	
	double sum() {
		double sum=kor+eng+math;
		return sum;
	}
}

public class Pr190702 {

	public static void main(String[] args) {
	//과제1] 기섭이라는 친구가 있습니다.
	//국어,영어,수학(과목명은 임의로 변경가능)점수가 입력이 됩니다.
	//이 세 과목의 입력 데이터를 생성자를 이용하여 입력을 받고,저장합니다.
	//그리고 총점,평균을 구합니다.
	{
		int kor,eng,math;
		Scanner sc=new Scanner(System.in); 
		while(true)
		{
			System.out.println("국어,영어,수학 점수를 입력하세요:");
			kor=sc.nextInt();
			eng=sc.nextInt();
			math=sc.nextInt();
			if (kor<0 || kor>100 || eng<0 || eng>100 || math<0 || math>100)
				System.out.println("잘못된 점수입니다. 다시 입력해주세요.");
			else
			{
				Quest1 q1= new Quest1(kor,eng,math);
				System.out.printf("합계는 %.2f 점 입니다.",q1.sum());
				System.out.printf("평균은 %.2f 점 입니다.",q1.average());
				break;
			}
		}
		System.out.println();
	}
	//int jumsu[]={100,90,80,75,60,95,56};
	//과제2] 위의 데이터에서 3의 배수의 합과 평균을 구하는 프로그램을 작성.
	{
		int arr[]={100,90,80,75,60,95,56};
		int sum=0,count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]%3==0)
			{
				sum+=arr[i];
				count++;
			}
		}
		int avg=sum/count;
		System.out.println("3의 배수의 합계 :"+sum);
		System.out.println("3의 배수의 평균 :"+avg);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
