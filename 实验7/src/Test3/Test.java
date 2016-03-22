package Test3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Test {
public static void main(String[] args) {
	File file1=new File("text.txt");
	File file=new File("src/Test3/Test.java");
	try {
		FileInputStream fileInputStream=new FileInputStream(file);
		InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"UTF-8");
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		FileOutputStream fileOutputStream=new FileOutputStream(file1);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"UTF-8");
		BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
		String string=null;
		while ((string=bufferedReader.readLine())!=null) {
		bufferedWriter.write(string+"\n");
		}
		bufferedReader.close();
		inputStreamReader.close();
		fileInputStream.close();
		bufferedWriter.close();
		outputStreamWriter.close();
		fileOutputStream.close();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	}
}
