package com.test1;

import java.util.Scanner;
public class GPA {
	int []result=new int[5];
	int []credit=new int [5];
	double gpa;
	public GPA(int res[]) {
		int sumR=0;
		int sumC=0;
		for(int i=0;i<res.length;i++)
		{
			result[i]=res[i];
			if (res[i]>=85) {
				credit[i]=4;
			}
			else if (res[i]>=75) {
				credit[i]=3;
			}
			else if(res[i]>=60) {
				credit[i]=2;
			}
			else if (res[i]>45){
				credit[i]=1;
			}
			else {
				credit[i]=0;
			}
			sumR+=res[i]*credit[i];
			sumC+=credit[i];
		}
		gpa=sumR/sumC;
	}
	void show()
	{
		for (int i = 0; i < credit.length; i++) {
			System.out.println("科目"+i+1+"\t学分："+credit[i]+"\t成绩："+result[i]);
		}
		System.out.println("GPA为："+gpa);
	}
	public static void main(String[] args) {
		System.out.println("请输入5科成绩，用空格隔开：");
		String[]arr=new Scanner(System.in).nextLine().split(" ");
		int []res=new int[5];
		for(int i=0;i<arr.length;i++)
		{
			res[i]=Integer.parseInt(arr[i]);
		}
		new GPA(res).show();
	}
}
