package com.test1;

import java.text.DecimalFormat;

public class testdouble {
	public static void main(String[] args) {
		double a=1;
		double b=3;
		double c=a/b;
		DecimalFormat dFormat=new DecimalFormat("0.0000000000000000000");
		System.out.println(dFormat.format(c));
	}
}
