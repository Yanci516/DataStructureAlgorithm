package com.live.extend;

/**
 * 给定一个无序矩阵，其中有正，有负，有0，求子矩阵的最大和。
 * 其暴力解法为时间复杂度为O(N^6),但是可以变为O(N^3)
 * 
 * 解题思路：其算法原型即 返回原数组中所有的子数组的最大累加和
 * 		     既然是矩阵，相邻行必须得是挨着的，将矩阵压缩为一行，变成在数组中求子数组的最大累加和
 * @author Yancy
 * 2016年8月4日 下午4:30:57
 */
public class MatrixMaxSum {
	
	public int maxSum(int[][] arr){
		int max = Integer.MIN_VALUE;
		int cur = 0;
		int[] temp = null;
		// 从某行开始得矩阵
		for (int i = 0; i < arr.length; i++) {
			temp = new int[arr[0].length];
			// 到某行结束的矩阵
			for (int j = i; j < arr.length; j++) {
				cur = 0;
				for (int k = 0; k < temp.length; k++) {
					// 压缩矩阵
					temp[k] += arr[j][k];
					cur += temp[k];
					max = Math.max(max, cur);
					cur = cur < 0 ? 0 : cur; 
				}
			}
		}
		return max;
	}
}
