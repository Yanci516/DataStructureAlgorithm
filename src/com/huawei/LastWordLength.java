package com.huawei;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述： 一行字符串，非空，长度小于5000。
 * 输出描述：整数N，最后一个单词的长度。
 * 
 * 
 * @author Yancy
 * 2016 2016年8月11日 下午9:29:01
 */
public class LastWordLength {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int res = getWordLength(str);
		System.out.println(res);
	}
	
	public static int getWordLength(String str){
		
		char[] cs = str.toCharArray();
		
		int res = 0;
		for(int i = cs.length - 1; i >= 0; i--){
			if (cs[i] == ' ') {
				return res;
			}
			res++;
		}
		return 1;
	}
}
