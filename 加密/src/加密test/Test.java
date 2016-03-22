package 加密test;

import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		System.out.println("输入字符，显示加密结果，输入0退出！");
		while(true)
		{
			Scanner scanner=new Scanner(System.in);
			String line=scanner.next();
			char c=line.charAt(0);
			if (c>='A'&&c<='Z') {
				c=(char) (155-c);
			}
			if (c>='a'&&c<='z') {
				c=(char) (219-c);
			}
			else {
				System.err.println("输入错误！！！程序退出！！！");
			}
			System.out.println(line+"加密后为："+c);
		}
	}
}
