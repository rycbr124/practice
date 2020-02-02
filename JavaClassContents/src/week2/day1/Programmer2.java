package week2.day1;

public class Programmer2 {
	private String name;
	private int age;
	private Project2 now;
	private Project2[] history;
	private int count;

	Programmer2(String name, int age) {
		this.name = name;
		this.age = age;
		this.history = new Project2[5];
	}

	Programmer2(String name, int age, Project2 now) {
		this(name, age);
		this.now = now;
	}

	Programmer2(String name, int age, Project2 now, Project2[] history) {
		this(name, age, now);
		this.history = history;
	}

	public void joinProject(Project2 p) {
		this.now = p;
	}

	public void addProjectHistory(Project2 p) throws Exception {
		if (count > 4) {
			throw new Exception("Project History는 5개까지 추가가능합니다");
		}

		history[count] = p;
		count++;
	}

	public Project2 getNowProject() {
		return this.now;
	}

	public void printProjectHistory() {
		for (int i = 0; i < this.count; i++) {
			System.out.println(history[i].getName() + "에 참여하였습니다");
		}
	}

	public String getTotalHistory() {
		int sum = 0;
		int year = 0, month = 0;
		for (int i = 0; i < this.count; i++) {
			sum += history[i].getMonth();
		}

		year = sum / 12;
		month = sum % 12;

		return year + "년" + month + "월";
	}

	public static void main(String[] args) {
		Programmer2 pg = new Programmer2("원종평", 30);

		Project2 p1 = new Project2("삼성인사시스템개발", 24, "삼성전자");
		pg.joinProject(p1);

		Project2 p2 = new Project2("LG전자인사시스템개발", 30, "LG전자");
		Project2 p3 = new Project2("SK하이닉스 인사시스템개발", 24, "SK하이닉스");
		try {
			pg.addProjectHistory(p2);
			pg.addProjectHistory(p3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pg.printProjectHistory();
		System.out.println("총경력:" + pg.getTotalHistory());
	}
}

class Project2 {
	Project2(String name, int month, String company) {
		this.name = name;
		this.month = month;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	private String name;
	private int month;
	private String company;
}
