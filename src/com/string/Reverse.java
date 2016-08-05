package com.string;

/**
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，
 * 你需要将这些部分逆序。给定一个原字符串A和他的长度，请返回逆序后的字符串。
 * 
 * 先将字符串全部逆序，再将每个单词再逆序
 * 
 * @author Yancy 2016 2016年7月30日 下午1:23:18
 */
public class Reverse {

	public String reverseSentence(String A, int n) {
		if (A == null || n == 0) {
			return A;
		}
		char[] cs = A.toCharArray();
		rotateWord(cs);
		return String.valueOf(cs);
	}

	public void rotateWord(char[] chars) {
		if (chars.length == 0 || chars == null) {
			return;
		}
		reverse(chars, 0, chars.length - 1);
		int l = -1;
		int r = -1;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {
				l = i == 0 || chars[i - 1] == ' ' ? i : l;
				r = i == chars.length-1 || chars[i+1] == ' ' ? i : r;
			}
			if (r != -1 && l != -1) {
				reverse(chars, l, r);
				l = -1;
				r = -1;
			}
		}
	}

	/**
	 * 将字符数组逆序
	 */
	public void reverse(char[] chars, int start, int end) {
		for (char temp = 0; start < end; start++, end--) {
			temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
		}
	}
}
