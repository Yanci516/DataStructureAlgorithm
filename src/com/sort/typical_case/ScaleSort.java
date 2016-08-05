package com.sort.typical_case;

import java.util.Arrays;

/**
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
 * 并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 * 
 * 选用优化的堆排序 第一次选用（0，k-1）元素建立堆且调整,接着将堆顶元素取出，再加入第k+1个数数放入堆顶，继续重复以上步奏
 * 
 * @author Yancy 2016 2016年7月26日 下午1:49:19
 */
public class ScaleSort {

	public int[] sortElement(int[] A, int n, int k) {
		// 由于整个过程是（0，k-1）的区间做堆调整，所以将数组A的(0,k-1)这区间的数组复制到 heap 中
		int[] heap = Arrays.copyOf(A, k);
		// 建立初始堆
		for (int i = k / 2 - 1; i >= 0; i--) {
			heapAdjust(heap, i, k);
		}
		// 对于原数组A 第k项之后的关键字都未排序，此时弹出heap中的堆顶元素放入数组A[0]中，
		// 且将第k项数据放入堆顶继续调整，再重复以上步奏
		for (int i = k; i < n; i++) {
			A[i - k] = heap[0];
			heap[0] = A[i];
			heapAdjust(heap, 0, k);
		}
		// 最后的k个关键字，用常规的堆排序操作依次输出最小值
		for (int i = n - k; i < n; i++) {
			A[i] = heap[0];
			swap(heap, 0, k - 1);
			heapAdjust(heap, 0, --k);
		}
		return A;
	}
	// 非递归的调整
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
