package test;

import java.util.Scanner;

public class ScannerInt {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		String []s=string.split(" ");
		int []arr=new int [10];
		for(int i=0;i<10;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
			System.out.println(arr[i]);
		}
	}
}
