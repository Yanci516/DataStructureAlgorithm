package com.live.prototype;

import com.live.extend.MatrixMaxSum;

/**
 * 测试专用
 * @author Yancy
 * 2016年8月4日 下午4:25:15
 */
public class Test {
	public static void main(String[] args) {
		int[][] arr = new int[][]{{2,-1,2},{-4,5,2},{5,-3,2}};
		MatrixMaxSum sum = new MatrixMaxSum();
		System.out.println(sum.maxSum(arr));
	}
}
