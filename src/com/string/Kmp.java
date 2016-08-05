package com.string;

/**
 * Kmp算法  用于检验字符串A中是否包含字符串B，时间复杂度为O(n)
 * 1、需要首先求出 next数组：
 * 		而next数组表示的是字符串A当前字符之前的字符串中有多大长度的相同前缀和后缀，
 * 			例如如果next [j] = k，代表j 之前的字符串中有最大长度为k 的相同前缀后缀。
 * 		 next[0] = -1
 * 2、Kmp算法步奏
 * 		先进行判断：
 * 			若 A[i] == B[j]  	i++、j++，
 * 			若 next[j] == -1 	i++，
 * 			否则 j = next[j]
 * 		再返回值 
 * 			若 j = B.length ，则返回 i-j，表示字符串A在 i-j位置开始包含字符串B
 * @author Yancy
 * 2016 2016年7月28日 下午2:14:40
 */
public class Kmp {
	
	int kmpSearch(String A, String B){
		if (A == null || B == null || B.length() < 1 || A.length() < B.length()) {
			return -1;
		}
		// 将A、B字符串转化为字符数组
		char[] AChar = A.toCharArray();
		char[] BChar = B.toCharArray();
		int[] next = getNext(BChar);
		int i = 0; // 字符数组AChar的索引
		int j = 0; // 字符串BChar的索引
		while(i < AChar.length && j < BChar.length){
			if ( j == -1 || AChar[i] == BChar[j]) {
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		// 若 j = B.length ，则返回 i-j，表示字符串A在 i-j位置开始包含字符串B，否则返回-1
		return j == BChar.length ? i - j : -1; 
	}
	
	// 获取 next 数组
	public int[] getNext(char[] B){
		int[] next = new int[B.length];
		next[0] = -1;
		int j = 0; // 定义 B[j] 表示后缀
		int k = -1; // 定义 B[k] 表示前缀
		while(j < B.length - 1){
			if ( k == -1 || B[j] == B[k]) {
				j++;
				k++;
				if (B[j] != B[k]) 
					next[j] = k;
				else 
					next[j] = next[k];
			}else {
				k = next[k];
			}
		}
		return next;
	}
}
