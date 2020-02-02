package week3.day2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest {
	final static int BUFFER_SIZE=256;
	
	public static void main(String[] args) {
		char c='A'; byte b=10; short s =10; int i=10; float f =3.141592f; double d =3.141592f;
		String str="하이~JAVA",str2;
		DataInputStream in =null;
		DataOutputStream out =null;
	try {
		FileOutputStream fout = new FileOutputStream("C:/temp/fileStreamTest6.txt");
		out = new DataOutputStream(fout);
	}catch(FileNotFoundException e) {
		System.out.println(e);
	}
	
	try {
		out.writeByte(b); out.writeShort(s); out.writeChar(c); out.writeDouble(d);
		out.writeUTF(str);
		out.close();
	}catch(IOException e) {
		System.out.println(e);
	}
	try {
		FileInputStream fin = new FileInputStream(new File("C:/temp/fileStreamTest6.txt"));
		in=new DataInputStream(fin);
	}catch(FileNotFoundException e) {
		System.out.println(e);
	}
	try {
		b=in.readByte(); s=in.readShort(); c=in.readChar(); i=in.readInt(); f=in.readFloat(); d=in.readDouble();
		}catch(IOException e) {
		System.out.println(e);
	}
	
	System.out.println(c);
	System.out.println(b);
	System.out.println(s);
	System.out.println(i);
	System.out.println(f);
	System.out.println(d);
	System.out.println(str);

	
	
	
	
	}
	

}
