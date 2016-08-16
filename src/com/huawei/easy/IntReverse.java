package com.huawei.easy;

import java.util.Scanner;

/**
 * 数字颠倒
 * 
题目描述
	输入一个整数，将这个整数以字符串的形式逆序输出
	程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 
 * @author Yancy
 * 2016年8月13日 下午9:48:20
 */
public class IntReverse {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int i = scanner.nextInt();
			String string =String.valueOf(i);
			for (int j = string.length() - 1; j >= 0; j--) {
				System.out.print(string.charAt(j));
			}
		}
	}
}
