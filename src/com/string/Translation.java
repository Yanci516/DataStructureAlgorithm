package com.string;

/**
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 * 要求：时间复杂度O(n),空间复杂度O(1)
 * 
 * 先将字符串 0~len-1 位置逆序，再将 剩下的字符串逆序，最后再将整个字符串再逆序即可
 * @author Yancy
 * 2016 2016年7月30日 下午3:57:02
 */
public class Translation {

	public String stringTranslation(String A, int n, int len) {
		char[] chars = A.toCharArray();
		reverse(chars, 0, len-1);
		reverse(chars, len, n-1);
		reverse(chars, 0, n-1);
		return String.valueOf(chars);
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
