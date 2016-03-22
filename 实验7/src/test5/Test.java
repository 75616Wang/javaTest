package test5;

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
		File file=new File("d:/prime.dat");
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(file);
			OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"UTF-8");
			BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
			for(int i=1;i<=200;i++)
			{
				if(isPrme(i))
				{
					bufferedWriter.write(i+"\n");
					System.err.println(i);
				}
			}
			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file2=new File("d:/prime.dat");
		try {
			FileInputStream fileInputStream=new FileInputStream(file2);
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"UTF-8");
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			String string;
			while ((string=bufferedReader.readLine())!=null) {
				System.out.println(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static boolean isPrme(int a)				//ÅÐ¶ÏaÊÇ·ñÎªËØÊý
	{
		if(a==1||a==2)return true;
		for(int i=2;i<a;i++)
		{
			if(a%i==0)
			{
				return false;
			}
		}
		return true;
	}
}
