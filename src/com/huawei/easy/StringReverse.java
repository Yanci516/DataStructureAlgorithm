package com.huawei.easy;

import java.util.Scanner;

/**
 * 字符串反转
 * 
 题目描述
	写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：abcd  dcba
 * 
 * @author Yancy
 * 2016年8月13日 下午10:02:18
 */
public class StringReverse {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		for (int i = string.length() - 1; i >= 0; i--){
			System.out.print(string.charAt(i));
		}
	}
}
