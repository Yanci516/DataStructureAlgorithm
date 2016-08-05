package com.sort;

/**
 * 计数排序  先从数组中选出最大和最小值，再根据最大和最小值建立桶，再将原数组元素按一定规则放入桶中，最后导出桶中元素即可
 * @author Yancy
 * 2016 2016年7月26日 上午10:12:30
 */
public class CountingSort {
	
	public int[] countingSort(int[] A, int n){
		
		// 找出原始数组中的最大和最小值
		int min = A[0]; //默认最小为第一位 
		int max = A[0]; //默认最大也为第一位
		for (int i = 1; i < A.length; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		
		//建立桶,且装入数据
		int[] bucket = new int[max - min + 1];
		for (int i = 0; i < A.length; i++) {
			// 将对应的 bucket[A[i]-min]加1，代表这个位子存入了数据，若为2代表这个桶装了2个数据......
			bucket[A[i]-min]++;
		}
		
		//导出桶中元素
		int index = 0;
		for (int i = 0; i < bucket.length; i++) {
			while(bucket[i]-- > 0)
				// bucket[]数组对应位子下标加上  min 值即为第i个桶装入的数据
				A[index++] = i + min;
		}
		return A;
	}
}
