package com.sort;

/**
 * 基数排序  根据数据的每一位来排序，第一遍根据关键字个位数字大小排序，分别装入0-9个桶，再取出；
 * 						   第二遍根据关键十位数字大小排序分别装入0-9个桶，再取出；
 * 						 ......
 * @author Yancy
 * 2016 2016年7月26日 上午10:59:26
 */
public class RadixSort {
	
	public int[] radixSort(int[] A, int n){
		
		int a = 1;// 除数，分离出关键字各位的数字
		int m = 1;// 指向第几位（个十百千万的顺序）
		int k = 0;// 最后的输出结果
		//创建一个二维数组，高维表示0-9个桶,低维表示每个桶内可能有n个值
		int[][] number = new int[10][n];
		// 创建 count数组，表示第i个桶中的数目
		int[] count = new int[10];
		for(; m <= 4; m++){
			for (int i = 0; i < A.length; i++) {
				int lsd = (A[i] / a) % 10; //余数即该位上的数
				number[lsd][count[lsd]] = A[i];
				count[lsd]++; //第lsd桶数目+1
			}
			//将桶内的元素按顺取出
			for(int p=0; p<10; p++){
				// 第p个桶是否有关键字，若有则遍历所有关键字且赋值给 A
				if (count[p] != 0) {
					for (int q = 0; q < count[p]; q++) {
						A[k++] = number[p][q];
					}
				}
				count[p] = 0;
			}
			k = 0;
			a *= 10;
		}
		return A;
	}
}
