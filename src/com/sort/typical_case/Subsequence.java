package com.sort.typical_case;

/**
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度,给定一个int数组A和数组的大小n，
 * 请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 * 
 * 要求时间复杂度为O(n)，空间复杂度为O(1)
 * 
 * 从左往右找出已遍历关键字中的最大值应该置于何处位子 p，再从右往左找出已遍历关键字中的最小值应该置于何处位子 q;
 * 最后 p-q+1 即为需要排序的最短子数组的长度
 * @author Yancy
 * 2016 2016年7月27日 下午4:29:23
 */
public class Subsequence {

	public int shortestSubsequence(int[] A, int n){
		int p = 0; // 从左往右遍历时，用来记录需要移动的关键字中最右的一个关键字位子
		int q = 0; // 从右往左遍历时，用来记录需要移动的关键字中最左的一个关键字位子
		int max = A[0];
		int min = A[n-1];
		
		for (int i = 1; i < n; i++) {
			max = Math.max(max, A[i]);
			// 若果当前值小于已遍历中最大值，则表示当前值在排序时是需要移动的关键字
			if (A[i] < max) {
				p = i;
			}
		}
		
		for (int i = n-1; i >= 0; i--) {
			min = Math.min(min, A[i]);
			// 若果当前值大于已遍历中最小值，则表示当前值在排序时是需要移动的关键字
			if (A[i] > min) {
				q = i;
			}
		}
		if (p == 0 && q==n-1) {
			return 0;
		}
		return p - q + 1;
	}
}
