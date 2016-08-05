package com.sort;

/**
 * 堆排序   先理解堆调整，即将数组形成一个堆或者堆顶元素与堆底元素互换时，都需调整堆
 * 
 * @author Yancy 2016年7月25日 上午10:36:00
 */
public class HeapSort {

	public int[] heapSort(int[] A, int n) {
		// 首先建立最小堆，父节点若大于等于0，则调整堆
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapAdjust(A, i, n);
		}
		for (int i = 1; i < n; i++) {
			// 调换第一个数和最后一个数
			swap(A, 0, n - i);
			// 调整堆
			heapAdjust(A, 0, n - i);
		}
		return A;
	}

	// 从节点i开始调整，n为节点总数 从0开始计算 i的子节点为 2*i+1 和 2*i+2,父节点为(i-1)/2
	void heapAdjust(int[] data, int i, int n) {
		int temp = data[i];
		int childLeft = 2 * i + 1;
		int childRight = 2 * i + 2;
		while (childLeft < n) {
			// 先从两个子节点中选择最小的	
			if (childRight < n && data[childRight] < data[childLeft])
				childLeft++;

			// 如果子节点大于父节点，则退出
			if (data[childLeft] >= temp)
				break;
			// 如果子节点小于父节点，则交换
			else {
				data[i] = data[childLeft];
				i = childLeft;
				childLeft = 2 * i + 1;
				childRight = 2 * i + 2;
			}
		}
		data[i] = temp;
	}

	void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
