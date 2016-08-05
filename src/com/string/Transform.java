package com.string;

/**
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，
 * 请设计一个高效算法，检查两给定串是否互为变形词。
 * 
 * 利用哈希表原理来求解      每个字符对应ASCII码，建立一个ASCII码范围的哈希表用来存放字符串A，
 * 				       再遍历字符串B，对应的哈希表位置是否有值
 * @author Yancy
 * 2016 2016年7月28日 下午4:11:36
 */
public class Transform {
	public boolean chkTransform(String A, int lena, String B, int lenb) {
		if (lena != lenb || A == null || B == null) {
			return false;
		}

		// 先将两个字符串变为字符数组
		char[] strA = A.toCharArray();
		char[] strB = B.toCharArray();
		// 创建一个数组来替代哈希表，长度为256刚好代表每个字符的ASCII嘛值
		int[] hash = new int[256];
		// 先处理 数组 strA,对应的hash数组加1
		for (int i = 0; i < strA.length; i++) {
			hash[strA[i]]++;
		}
		// 处理 数组 strA
		for (int i = 0; i < strB.length; i++) {
			if (hash[strB[i]]-- == 0) {
				return false;
			}
		}
		return true;
	}
}
