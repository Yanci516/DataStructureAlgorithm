package com.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。 要求时间复杂度O(N*logN)
 * 
 * 解题思路：两者相加比较，即若 str1+str2 < str2+str1 则 str1在前面
 * 
 * @author Yancy 2016 2016年7月30日 下午4:10:52
 */
public class Prior {
	public class MyComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return (o1+o2).compareTo(o2+o1);
		}
	}
	
	public String findSmallest(String[] strs, int n) {
		if (strs == null || n == 0) {
			return "";
		}
		// 根据新的比较方式排序
		Arrays.sort(strs, new MyComparator());
		String res = "";
		for (int i = 0; i < n; i++) {
			res += strs[i];
		}
		return res;
	}
}
