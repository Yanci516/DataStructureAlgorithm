package com.sort.typical_case;

import com.sort.HeapSort;

/**
 * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 * 
 * 空间复杂度为0(1)，且高效的算法只有非递归的堆排序
 * @author Yancy
 * 2016年7月26日 下午3:17:22
 */
public class CheckDuplicate {
	
	public boolean checkDuplicate(int[] A, int n){
		HeapSort sort = new HeapSort();
		sort.heapSort(A, n);
		for (int i = 0; i < n-1; i++) {
			if (A[i] == A[i+1]) {
				return true;
			}
		}
		return false;
	}
}
