package com.sort;

/**
 * 归并排序    先将数组分成包含一个元素的数组，再将相邻两个数组排序后合并为二个元素的数组；
 *        相邻两个二元数组再进行合并且排序......
 * @author Yancy
 * 2016 2016年7月24日 下午7:40:50
 */
public class MergeSort {
	public int[] mergeSort(int[] A, int n) {
		// write code here
		sort(A, 0, n - 1);
		return A;
	}

	// 划分序列
	public void sort(int[] data, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			sort(data, left, middle);
			sort(data, middle + 1, right);

			merge(data, middle, left, right);
		}
	}

	// 合并相邻两个数组
	public void merge(int[] data, int middle, int left, int right) {
		int leftIndex = left; // 定义左边数组的第一个下标
		int rightIndex = middle + 1; // 定义右边数组的第一个下标
		int[] tempArray = new int[right - left + 1]; // 定义一个暂时存储的数组
		int tempIndex = 0; // 定义暂存数组的下标
		while (leftIndex <= middle && rightIndex <= right) {
			if (data[leftIndex] <= data[rightIndex]) {
				tempArray[tempIndex++] = data[leftIndex++];
			} else {
				tempArray[tempIndex++] = data[rightIndex++];
			}
		}
		// 剩下的直接放入
		while (leftIndex <= middle) {
			tempArray[tempIndex++] = data[leftIndex++];
		}
		while (rightIndex <= right) {
			tempArray[tempIndex++] = data[rightIndex++];
		}
		// 返回数组给data
		int temp = 0;
		while ((left + temp) <= right) {
			data[left + temp] = tempArray[temp];
			temp++;
		}
	}
}