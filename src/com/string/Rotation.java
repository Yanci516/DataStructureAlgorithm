package com.string;

/**
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。
 * 比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。
 * 对于两个字符串A和B，请判断A和B是否互为旋转词。
 * 
 * 解题思路: 先合并字符串 A+A ,再用KMP算法在合并后的字符串A中去检查是否包含字符串B
 * @author Yancy
 * 2016 2016年7月29日 下午4:56:45
 */
public class Rotation {
	public boolean chkRotation(String A, int lena, String B, int lenb) {
		if (lena != lenb) {
			return false;
		}
		A = A + A;
		Kmp kmp = new Kmp();
		return kmp.kmpSearch(A, B) != -1;
    }
}
