//package week2.day5;
//
//class ThreadB extends Thread{
//	int total;
//	
//	public void run() {
//		synchronized(this){
//			for(int i=0;i<5;i++) {
//				System.out.println(i+"를 더합니다.");
//				total+=i;
//				try {
//					Thread.sleep(500);
//				}catch (InterruptedException en) {
//					en.printStackTrace();
//				}
//			}
//			notify(); 
//		}
//	}
//}
//
//public class ThreadTest {
//
//	public static void main(String[] args) {
//		Thread b = new Thread();
//		int total;
//		
//		b.start();
//		synchronized(this){
//			for(int i=0;i<5;i++) {
//				System.out.println(i+"를 더합니다.");
//				total+=i;
//				try {
//					Thread.sleep(500);//0.5초
//				}catch (InterruptedException en) {
//					en.printStackTrace();
//				}
//			}
//			notify(); 
//		}
//		
//	}
//
//}
