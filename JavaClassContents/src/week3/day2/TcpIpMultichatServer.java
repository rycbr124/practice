package week3.day2;

import java.net.*;
import java.io.*;
import java.util.*;

public class TcpIpMultichatServer {
	HashMap clients;//모든 client를 HashMap에 담고 있다.
	
	TcpIpMultichatServer(){
		clients = new HashMap();
		Collections.synchronizedMap(clients);
	}
	
	public static void main(String args[]) {
		new TcpIpMultichatServer().start();
	}
		
	public void start(){
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			
			while(true) {
			//Server가 Client의 접속을 계속 기다린다.
				socket=serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+
				"에서 접속하였습니다.");
				//접속할 Client와 통신할 Thread를 Client와 통신할 Socket을 가지고 만들어 띄워준다.
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//start()
	
	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
	
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)clients.get(it.next());
				out.writeUTF(msg);
			}catch(IOException e) {	}
		}//while
	}//sendToAll
	
	class ServerReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver(Socket socket){
			this.socket=socket;
			try {
				in=new DataInputStream(socket.getInputStream());
				out=new DataOutputStream(socket.getOutputStream());
			}catch(IOException e) {}
		}
		
		public void run() {
			String name="";
			try {
				name=in.readUTF();//문자열 Read
				sendToAll("#"+name+"님이 들어오셨습니다.");
				
				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 "+clients.size()+"입니다.");
				
				while(in!=null) {
					sendToAll(in.readUTF()); //Read한 내용을 모든 Client에서 전달한다.
				}
			}catch(IOException e) {
			//ignore
			}finally {
				sendToAll("#"+name+"님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+
				"에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 "+clients.size()+"입니다.");
			}//try
		}//run
		
	}//ReceiverThread
	
}//class
