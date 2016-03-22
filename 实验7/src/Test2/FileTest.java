package Test2;

import java.io.File;
public class FileTest {
	public static void main(String[] args) {
		File file=new File("text.txt");
		System.out.println(file.exists());
		System.out.println(file.canRead());
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParentFile());
		System.out.println((double)file.length()/1000+"KB");
	}
}
