package com.sort;


/**
 * 冒泡排序 第一轮从空间（0，n）    相邻两个元素比较，把最大的数移到 最右边 位置,
 * 		 第二轮从空间（0，n-1）相邻两个元素比较，把最大的数移到 最右边-1 位置
 * @author Yancy
 *
 */
public class BubbleSort {

	public int[] bubbleSort(int[] a, int n){
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n-i; j++) {
				if (a[j-1] > a[j]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		return a;
	}
}
