package week3.day2;
//시룸에 이런 소스가 많다.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class FilterReaderTest extends FilterReader{

	public FilterReaderTest(Reader in) {
		super(in);
	}
	
	public int read(char[] buf,int offset,int len) throws IOException{
		int numChars=0;
		boolean inComment=false;
		while(numChars==0) {
			numChars =in.read(buf,offset,len);
			if(numChars==-1)
				return -1;
			int last=offset;
			for(int i=offset;i<offset+numChars;i++) {
				if(inComment) {
					if((buf[i]=='*')&&(buf)[i+1]=='/') {
						//System.out.println("주석1");
						inComment=false;
						i++;
					}
				}else {
					if((buf[i]=='/')&&(buf[i+1]=='*')) {
						//System.out.println("주석2");
						inComment = true;
						i++;
					}else {
						buf[last++]=buf[i];
					}
				}
			}
			numChars=last-offset;
		}
		return (numChars);
	}
	
	public int read() throws IOException{
		char[] buf = new char[1];
		//유니코드로서 2byte씩 읽어 들인다.
		int result=read(buf,0,1);
		if(result==-1) {
			return -1;
		}else {
			return ((int)buf[0]);
		}
	}
	
	public static void main(String[] args) {
		FileReader f = null;
		BufferedReader in =null;
		String buf;
		try {
			//File Input Stream을 생성한다.,
			f= new FileReader("C:/temp/AaTxtTest.txt");
			//File Stream 인자로 하는 Filter Stream을 생성하여 이를 Buffer Stream에 연결한다.
			in = new BufferedReader(new FilterReaderTest(f));
			//한 줄씩 읽어들인다. readLine()은 내부에서 read()메소드를 이용하여 작동한다.
			while((buf=in.readLine())!=null) {
				System.out.println(buf);
			}
			in.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
