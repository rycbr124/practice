package bit190705;

/* 현대 자동차가 있습니다.
 * 자동차에 대하여 상태를 표시하는 메소드를 구현하여 보세요
 * 1.자동차가 출발합니다.
 * 2.자동차가 운행중입니다.
 * 3.자동차가 좌회전을 합니다.
 * 4.자동차가 우회전을 합니다.
 * 5.자동차가 정지중입니다.
 * 6.자동차가 정지합니다.
 */

abstract class Hyundae{
	public abstract void start();
	public abstract void running();
	public abstract void left();
	public abstract void right();
	public abstract void stopping();
	public abstract void stop();
}

class Car extends Hyundae {

	@Override
	public void start() {
		System.out.println("1.자동차가 운행중입니다.");
		
	}

	@Override
	public void running() {
		System.out.println("2.자동차가 운행중입니다.");
		
	}

	@Override
	public void left() {
		System.out.println("3.자동차가 좌회전을 합니다.");
		
	}

	@Override
	public void right() {
		System.out.println("4.자동차가 우회전을 합니다.");
		
	}

	@Override
	public void stopping() {
		System.out.println("5.자동차가 정지중입니다.");
	}

	@Override
	public void stop() {
		System.out.println("6.자동차가 정지합니다.");
	}
	
}

public class AbstractSample2 {

	public static void main(String[] args) {
		Car car = new Car();
		car.start();
		car.running();
		car.left();
		car.right();
		car.stopping();
		car.stop();


	}

}
