package com.huawei.justsoso;

import java.util.Scanner;

/**
 * 字符串分割
 * 
 * 题目描述:
	•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
	•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

       输入描述:
	连续输入字符串(输入2次,每个字符串长度小于100)
	
       输出描述:
	输出到长度为8的新字符串数组
	
       输入例子:
	abc
	123456789

       输出例子:
	abc00000
	12345678
	90000000	
 * 
 * @author Yancy
 * 2016 2016年8月12日 上午9:37:47
 */
public class SplitString8 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			String str = sc.next();
			char[] cs = str.toCharArray();
			int n = cs.length % 8 == 0 ? cs.length / 8 : cs.length / 8 + 1; 
			int k = 0;
			String[] strings = new String[n];
			for (int i = 0; i < n; i++) {
				strings[i] = "";
				for (int j = 0; j < 8; j++) {
					if (k >= cs.length) {
						strings[i] += '0';
					}else {
						strings[i] += cs[k++]; 
					}
				}
			}
			for (int i = 0; i < strings.length; i++) {
				System.out.println(strings[i]);
			}
		}
	}
}
