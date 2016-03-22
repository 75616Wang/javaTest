package test4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class Test {
public static void main(String[] args) {
	File file=new File("text.txt");
	File file2=new File("newText.txt");
	try {
		FileInputStream fileInputStream = new FileInputStream(file);
		FileInputStream fileInputStream2=new FileInputStream(file2);
		InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"UTF-8");
		InputStreamReader inputStreamReader2=new InputStreamReader(fileInputStream2,"UTF-8");
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		BufferedReader bufferedReader2=new BufferedReader(inputStreamReader2);
		String string=null ,string2 = null ;
		while(true)
		{
			if ((string=bufferedReader.readLine())==null&&((string2=bufferedReader2.readLine())==null)) {
				System.out.println(true);
				break;
			}
			if(!(string.equals(string2)))
			{
				System.err.println(false);
				break;
			}
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
