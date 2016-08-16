package com.huawei.easy;

import java.util.Scanner;

/**
 * 计算字符个数
 * 
 * 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 输入描述：输入一个有字母和数字以及空格组成的字符串，和一个字符。
 * 输出描述：输出输入字符串中含有该字符的个数
 * 
 * @author Yancy
 * 2016 2016年8月11日 下午9:31:35
 */
public class CharNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char c = sc.next().charAt(0);
		int res = getCharNum(str, c);
		System.out.println(res);
	}
	
	public static int getCharNum(String str, char c){
		int res = 0;
		
		if (Character.isUpperCase(c)) {
			str = str.toUpperCase();
		}
		
		if (Character.isLowerCase(c)) {
			str = str.toLowerCase();
		}
		
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == c) {
				res++;
			}
		}
		
		return res;
	}
}
