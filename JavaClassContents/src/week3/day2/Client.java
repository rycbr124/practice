package week3.day2;

import java.io.*;
import java.net.*;

//Socket통신 커넥션의 기본
public class Client {
	public static void main(String[] args) {
		try {
			String serverIp = "192.168.0.24";
			
			System.out.println("[Client]"+"서버에 연결중입니다. 서버 IP :"+serverIp);
			//소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp,7777);
			
			//소켓의 입력스트림을 받는다.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			//소켓으로부터 받은 데이터를 출력한다.
			System.out.println("[Client]"+"서버로부터 받은 메시지 :"+dis.readUTF());
			//String으로 read write함
			System.out.println("[Client]"+"연결을 종료합니다.");
			
			//스트림과 소켓을 닫는다.
			dis.close();
			socket.close();
			System.out.println("[Client]"+"연결이 종료되었습니다.");
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
