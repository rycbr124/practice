package bit190704;

import java.util.Scanner;

class RandomInfo{
	private int ansNum;

	int getAnsNum() {
		return ansNum;
	}

	void randNum(int maxNum) {
		this.ansNum=(int) (Math.random()*maxNum)+1;
	}
	
	void Question(int inNum, int maxNum, int minNum) {
		int count=1;//정답 횟수 초기화
		Scanner sc = new Scanner(System.in);
		while(inNum!=ansNum)//정답을 맞히기 전까지 반복실행
		{
			if(inNum>maxNum || inNum<minNum)//입력값이 최대값이나 최소값을 벗어난 경우
			{
				System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
				inNum=sc.nextInt();
				sc.nextLine();
			}else
			{
				System.out.println("틀렸습니다.다시 입력해주세요:");
				count++;
				inNum=sc.nextInt();
				sc.nextLine();
			}
		}
		System.out.println("정답입니다!\n정답을 맞추는데 소요된 횟수는 총 "+count+"번입니다.");
		
	}


}

class RandomCon extends RandomInfo{
	void machine() {
		int inNum,maxNum=10,minNum=1;//입력 번호,랜덤값,랜덤 최대값,랜덤 최소값
		Scanner sc = new Scanner(System.in);
		while(true)//반복실행구문
		{
			System.out.println("숫자 맞추기 게임입니다.\n1부터 "+maxNum+"까지의 숫자를 입력해주세요:");
			inNum=sc.nextInt();
			sc.nextLine();
			randNum(maxNum);//랜덤 번호 설정
			Question(inNum,maxNum,minNum);
			System.out.println("계속하려면 yes, 종료하려면 no를 입력해주세요:");
			boolean sw=true;//yes 입력 시 초기화면으로 돌아가기 위한 변수.
			while(sw)
			{
				String choice=sc.nextLine();
				if(choice.equals("yes"))
				{
					System.out.println("처음으로 돌아갑니다.");
					sw=false;
				}else if(choice.equals("no"))
				{
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}else
				{
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
		}	
	}


	
	
}

public class InherSample9 {

	public static void main(String[] args) {
		RandomCon rc = new RandomCon();
		rc.machine();

		

	}

}
