package com.binary_search;

/**
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * 
 * 解题思路：如题，给的是已经排序的数组。再进行二分搜索之前，声明一个变量res=-1，用来作为最后返回的变量；
 * 		    若在整个搜索过程中，都未出现num，则res值不变，直接返回res;
 * 		   若  arr[mid] > num ,则right = mid-1;  
 * 		   若  arr[mid] < num ,则left = mid+1;
 * 		   若  arr[mid] = num ,则res = num,right = mid+1
 * 		 
 * @author Yancy
 * 2016年8月9日 下午5:10:05
 */
public class LeftMostAppear {
	public int findPos(int[] arr, int n, int num) {
		int res = -1;
		int left = 0;
		int right = n - 1;
		int mid = 0;
		while(left <= right){
			mid = left + (right - left)/2;
			if (arr[mid] < num) {
				left = mid + 1;
			}
			if (arr[mid] > num) {
				right = mid - 1;
			}
			if (arr[mid] == num) {
				res = mid;
				right = mid - 1;
			}
		}
		return res;
    }
}
