package com.sort;

/**
 * 希尔排序 与插入排序类似，只是步长在发生变化
 * @author Yancy
 * 2016年7月25日 下午12:56:44
 */
public class ShellInsert {

	public int[] shellSort(int[] A, int n){
		
		int gap = n/2;// 初始步长
		while(gap > 0){
			// 从数组下标为 gap的元素开始排序
			for(int i = gap; i < n; i++){ 
				// 每个元素只与自己组内的元素进行直接排序，组内相邻元素比较
				for(int j = i-gap; j>=0 ; j -= gap){
					if (A[j] > A[j+gap]) {
						int temp = A[j+gap];
						A[j+gap] = A[j];
						A[j] = temp;
					}
				}
			}
			gap /= 2;
		}
		return A;
	}
}
