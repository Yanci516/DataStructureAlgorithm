package com.binary_search;

/**
 * 定义局部最小的概念。 1、如果arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时；
 * 				 2、如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 				 3、如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 				 4、如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。 
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 * 
 * 解题思路：根据局部最小的概念，前三种情况；再进行第四种情况判断，此时数组的关键字的存在 V 字形的排序，中间必有局部最小值：
 * 		  1、由于任意相邻位置元素不相等，且判断了首位，
 * 				所以求：left=1,right=arr.length-2,mid=left+(right-left)/2
 * 		  2、再根据中点元素与其左右元素比较，若arr[mid] < arr[mid+1],那么数组（mid,right）呈现V字形，则取left=mid+1
 * 								      若arr[mid] < arr[mid-1],那么数组（left,mid）呈现V字形，则取right=mid-1
 * 								      若arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1] 就返回mid
 * 
 * @author Yancy
 * 2016年8月9日 下午4:41:38
 */
public class GetLocalMin {
	public int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		// 比较的顺序不能错，若长度为1则不用判断后面条件
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length-1] < arr[arr.length-2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while(left < right){
			mid = left + (right-left) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			}else if(arr[mid] > arr[mid + 1]){
				left = mid + 1;
			}else {
				return mid;
			}
		}
		return left;
    }
}
