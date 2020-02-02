package week3.day2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpIpMultichatClient {
	public static void main(String[] args) {
		String chatName = "ㅇㅇㅇ";
		//소켓을 생성하여 연결을 요청한다.
		try {
			String serverIp = "192.168.0.24";
			Socket socket = new Socket(serverIp,7777);
			System.out.println("서버에 연결되었습니다.");
			Thread sender = new Thread(new ClientSender(socket,chatName));//서버로 chat문장 write
			Thread receiver = new Thread(new ClientReceiver(socket));//서버에서 chat문장 read
			
			sender.start();
			receiver.start();
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(Exception e) {
		}
	}
	
	//서버에 chat문장을 전달하는 thread
	static class ClientSender extends Thread{
		Socket socket;
		DataOutputStream out;
		String name;
		
		ClientSender(Socket socket, String name){
			this.socket=socket;
			try {
				out=new DataOutputStream(socket.getOutputStream());
				this.name=name;
			}catch(Exception e) {}
		}
		
		public void run() {
			Scanner scanner = new Scanner(System.in);
			try {
				if(out!=null) {
					out.writeUTF(name);//chat 이름을 서버에 전달
				}
				
				while(out!=null) {
					out.writeUTF("["+name+"]"+scanner.nextLine());//채팅문장 서버에 전달
				}
			}catch(IOException e) {}
		}
		
	}
	
	static class ClientReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		
		ClientReceiver(Socket socket){
			this.socket=socket;
			try {
				in=new DataInputStream(socket.getInputStream());
			}catch(IOException e) {}
		}
		
		public void run() {
			while(in!=null) {
				try {
					System.out.println(in.readUTF());
				}catch(IOException e) {}
			}
		}
		
	}
	
}
