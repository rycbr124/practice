package week3.day1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//import java.io.*;

public class FileInputOutputStream {

	public static void main(String[] args) {
		boolean append = false;
		int i,len=0;
		String strFile01 = "C:/temp/Lotto.java";
		String strFile02 = "C:/temp/fileStreamTest.txt";
		
		InputStream in =null;
		OutputStream out =null;
		try {
			in=new FileInputStream(new File(strFile01));
			out=new FileOutputStream(strFile02,append);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		try {
			while((i=in.read())!=-1) {//1byte를 읽어서
				System.out.println(i);//1byte이므로 한글은 깨짐
				out.write(i);
				len++;
			}
			in.close(); out.close();
			System.out.println(len + " bytes are copied...");
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
