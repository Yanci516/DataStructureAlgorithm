package com.sort.typical_case;

/**
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 * 
 * 要求时间复杂度0(n),空间复杂度0(1)
 * 
 * 典型的荷兰国旗问题。 使用三个指针 start、end、current 分别指向数组首部。尾部以及当前。
 * 遍历数组，若为0则表示要放在数组前面，即与start处值交换，且start++、current++
 *        若为1则表示放在数组中间，即不需要动，current++
 *        若为2则表示要放在数组后面，即与end处值交换，且end--、current不变（因为交换过来的额关键字有可能为0，还需判断）
 * @author Yancy
 * 2016 2016年7月27日 下午3:39:21
 */
public class ThreeSort {
	
	public int[] sortThreeColor(int[] A, int n){
		int current = 0; //移动的指针，表示当前的位子
		int start = 0; //指向数组的首部
		int end = n-1; //指向数组的尾部
		
		for (int i = 0; i < n; i++) {
			if (A[current] == 0) {
				swap(A, start++, current++);
			}else if (A[current] == 1) {
				current++;
			}else if (A[current] == 2) {
				swap(A, current, end--);
			}
		}
		
		return A;
	}
	
	void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
 }
