package com.string;

/**
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，
 * 并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。 
 * 给定一个string iniString 为原始的串，以及串的长度 length, 返回替换后的string。
 * 
 * 解题思路：先求得字符串中的空格数 n，计算出替换后的长度为 length+n*2;
 * 再从后先前遍历源字符数组，若遇到空格则在新数组里用 %20 替换，没遇到则将值赋值到新数组
 * @author Yancy  2016年7月30日 下午7:20:37
 */
public class Replacement {
	public String replaceSpace(String iniString, int length) {
		char[] cs1 = iniString.toCharArray();
		int n = 0; // 表示空格数
		for (int i = 0; i < length; i++) {
			if (cs1[i] == ' ') {
				n++;
			}
		}
		int j = length + n * 2; //新的字符数组长度
		char[] cs2 = new char[j];
		for (int i = length - 1; i >= 0 ; i--) {
			if (cs1[i] == ' ') {
				cs2[j- 1] = '0';
				cs2[j- 2] = '2';
				cs2[j- 3] = '%';
				j -= 3;
			}else {
				cs2[j- 1] = cs1[i];
				j--;
			}
		}
		return String.valueOf(cs2);
	}
}
