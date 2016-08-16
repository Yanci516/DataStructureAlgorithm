package com.huawei.justsoso;

import java.util.Scanner;

/**
 * 句子逆序
 * 
 题目描述
	将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
	所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * @author Yancy
 * 2016年8月13日 下午10:06:51
 */
public class SentenceReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String res = reverse(sentence);
		System.out.println(res);
	}
	public static String reverse(String sentence){
		
		char[] cs = sentence.toCharArray();
		// 首先将整个句子逆序
		reverse(cs, 0, cs.length - 1);
		int l = -1;
		int r = -1;
		
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] != ' ') {
				l = i == 0 || cs[i-1] == ' ' ? i : l;
				r = i == cs.length - 1 || cs[i+1] == ' ' ? i : r;
			}
			if (r != -1 && l != -1) {
				reverse(cs, l, r);
				l = -1;
				r = -1;
			}
		}
		return String.valueOf(cs);
	}
	
	/**
	 * 将字符数组逆序
	 * @param cs 字符数组
	 * @param start 
	 * @param end
	 */
	public static void  reverse(char[] cs, int start, int end){
		
		while (start < end){
			char temp = cs[start];
			cs[start++] = cs[end];
			cs[end--] = temp;
		}
	}
}
