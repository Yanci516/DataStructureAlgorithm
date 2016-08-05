package com.string;

/**
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 * 要求时间复杂度 O(N),空间复杂度为O(N)
 * 
 * 解题思路：求出每个字符结尾的情况下，最长无重复字符串长度，并在其中寻找最大值；
 * 		 1、 假设以第 i 个字符s[i]结尾，现在需要两个辅助变量：
 * 				哈希表 map-> 其中统计了每种字符之前出现的位置
 * 				整形变量pre-> 代表以s[i-1]结尾情况下，上次出现s[i-1]字符的位置
 * 		 2、首先根据哈希表取出当前字符上次出现的位置，与pre作比较去较大值（即靠右的位置）；
 * 		 3、cur = i - pre 即为当前字符的无重复字符串长度；
 * 		 4、再在所有 cur 中选出最大值并返回
 * @author Yancy
 * 2016年7月30日 下午7:56:36
 */
public class DistinctSubstring {
	public int longestSubstring(String A, int n) {
		if (A == null || n == 0) {
			return 0;
		}
		char[] cs = A.toCharArray();
		int[] map = new int[256]; //创建一个256个字符的哈希表来存放某个字符上次出现的位置
		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		int pre = -1;// 当前字符左侧第一个字符上次出现的位置
		int cur = 0; // 当前字符的无重复字符长度
		int len = 0; // 最大无无重复子串长度
		
		for (int i = 0; i < cs.length; i++) {
			pre = Math.max(pre, map[cs[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[cs[i]] = i;
		}
		return len;
    }
}
