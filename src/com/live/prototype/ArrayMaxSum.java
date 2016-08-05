package com.live.prototype;

/**
 * 算法原型：
 * 		返回源数组中各子数组最大的累加和
 * 思路：
 * 		既然是求最大的累加和，那么在得到该最大累加和子数组中就不可能出现过累加和为负数的情况；
 * 		声明变量max即返回的最大累加和，以及当前的累加和cur;
 * 		遍历数组，从第0个数开始累加，一旦累加和cur大于max，max就更新；若 cur为负数则令cur=0,从新累加
 * @author Yancy
 * 2016年8月4日 下午4:13:17
 */
public class ArrayMaxSum {
	
	public int maxSum(int[] arr){
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < arr.length; i++) {
			cur += arr[i];
			max = Math.max(max, cur);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}
}
