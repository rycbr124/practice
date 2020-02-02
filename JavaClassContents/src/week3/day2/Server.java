package week3.day2;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
	
	public static void main(String[] args) {
		ServerSocket serverSocket =null;
		try {
			//서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println("[Server]"+getTime()+" 서버가 준비되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				System.out.println("[Server]"+getTime()+"연결요청을 기다립니다.");
				//서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멍추고 계속 기다린다.
				//클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 쇼
				Socket socket = serverSocket.accept();
				System.out.println("[Server]"+getTime()+socket.getInetAddress()
				+"로부터 연결요청이 들어왔습니다.");
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] Test Message1 from Server");
				System.out.println("[Server]"+getTime()+"데이터를 전송했습니다.");
				
				dos.close();
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	
	}
}
