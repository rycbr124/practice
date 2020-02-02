package week3.day1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileReaderWriterTest {

	public static void main(String[] args) {
		boolean append = false;
		int i,len=0;
		String strFile01 = "C:/temp/Lotto.java";
		String strFile02 = "C:/temp/fileStream테스트.txt";
		
		FileReader in =null;
		FileWriter out =null;
		try {
			in=new FileReader(new File(strFile01));
			out=new FileWriter(strFile02,append);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
		try {
			while((i=in.read())!=-1) {//1byte를 읽어서,더 이상 읽을게 없으면 -1을 리턴
				//read 최소단위,수십기가의 파일도 1byte씩 read
				System.out.println((char)i);//1byte이므로 한글은 깨짐
				out.write(i);
				len++;
			}
			in.close(); out.close();
			System.out.println(len + " chars are copied...");
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
