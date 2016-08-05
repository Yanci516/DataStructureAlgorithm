package com.sort;

/**
 * 选择排序 第一轮从（0，n） 中选出最小的数与第一个数交换 第二轮从 （1，n） 中选出最小的数与第二个数交换 ......
 * 
 * @author Yancy
 *
 */
public class SelectionSort {
	public int[] selectionSort(int[] a,int n) {

		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int num = i;
			for (int j = i + 1; j < a.length; j++) {
				if (min > a[j]) {
					min = a[j];
					num = j;
				}
			}
			if (num != i) {
				a[num] = a[i];
				a[i] = min;
			}
		}
		return a;
	}
}
