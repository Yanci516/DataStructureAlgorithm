package com.sort;

/**
 * 插入排序   第一轮将第二个数与第一个数比较，小的放前面
 * 		   第二轮将第三个数与前两个数比较，小的放到前面
 *       第三轮将第四个数与前三个数比较，小的放到前面
 * @author Yancy
 * 2016 2016年7月24日 下午5:09:22
 */
public class InsertionSort {

	public int[] insertionSort(int[] a){
		
		for (int i = 0; i < a.length-1; i++) {
			for(int j = i+1; j>0 ; j--){
				if(a[j-1] > a[j]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		return a;
	}
}
