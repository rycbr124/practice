package week3.day2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterStreamTest {

	public static void main(String[] args) {
		int c=0;
		try {
			InputStream in=new LowerCaseInputStream(
					new BufferedInputStream(
							new FileInputStream("C:/Temp/filterStream.txt")));
			//보조스트림의 인스턴스를 만드는 과정
			
			while((c=in.read())>=0) {
				System.out.print((char)c);
			}
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

class LowerCaseInputStream extends FilterInputStream{

	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	public int read() throws IOException{
		int c=super.read();
		return (c==-1 ? c : Character.toLowerCase((char)c));
	}
	
	//배열에 넣어서 리턴해주고 있다.
	public int read(byte[] b,int offset, int len) throws IOException{
		int result=super.read(b,offset,len);
		for(int i=offset;i<offset+result;i++) {
			b[i]=(byte)Character.toLowerCase((char)b[i]);
		}
		return result;
		
	}
}
