package week1.day3.pattern;
//Template 패턴
//템플릿으로 메소드를 정의해놓고 상속받아서 쓰는것

public abstract class CaffeineReferage {

	//템플릿
	final void prepareRecipe() {
		this.boilWater();
		this.brew();
		this.pourlnCup();
		this.addcndiments();
	}
	
	//재정의 해야 하는 것들
	abstract void brew();
	abstract void addcndiments();
	//반드시 재정의 할 필요가 없는 것들(해도 되고 안해도 되고)
	void boilWater() {
		System.out.println("물 끓이는 중");
	}
	void pourlnCup() {
		System.out.println("컵에 따르는 중");
	}
	
	public static void main(String[] args) {
		CaffeineReferage coffee = new Coffee();
		coffee.prepareRecipe();
		System.out.println();
		CaffeineReferage tea = new Tea();
		tea.prepareRecipe();
	}
	
}
class Coffee extends CaffeineReferage{

	@Override
	void brew() {
		System.out.println("필터를 통해 커피를 우려내는 중");
	}

	@Override
	void addcndiments() {
		System.out.println("설탕과 우유를 추가하는 중");
	}
}

class Tea extends CaffeineReferage{

	@Override
	void brew() {
		System.out.println("차를 우려내는 중");
	}

	@Override
	void addcndiments() {
		System.out.println("레몬을 추가하는 중");
	}
	
}