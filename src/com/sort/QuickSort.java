package com.sort;

/**
 * 快速排序  将数组分成两部分，小于划分点的在左边，大于中间数的在右边；再对左右两年继续划分
 * 使用“挖坑、填坑”的思想，默认选择数组第一个数为划分点即挖坑，接着先从右到左寻找比划分点小的数来填坑且形成新坑；
 *                  再从左向右寻找比划分点大的数来填坑且形成新坑； 当左右指针相遇时及划分完成，再用原始数组的
 *                  第一个数来填坑。
 *  再使用分治法（递归调用）继续重复以上步奏
 * @author Yancy
 * 2016年7月25日 上午10:33:23
 */
public class QuickSort {

	public  int[] quickSort(int[] A, int n) {
		// write code here
		sort(A, 0, n - 1);
		return A;
	}

	void sort(int[] data, int left, int right) {
		if(left < right){
			int i = left;
			int j = right;
			int x = data[i];// data[i]即 data的第一个坑
			while(i < j){
				// 先从右到左找小于 x 的数来填坑 data[i]
				while(i < j && data[j] >= x)
					j--;
				if (i < j) {
					// data[j] 填入到 坑中，且data[j]形成新坑
					data[i++] = data[j];
				}
				// 再从左到有找大于 x 的数来填坑 data[j]
				while(i < j && data[i] < x)
					i++;
				if (i < j) {
					// data[j] 填入到 坑中，且data[i]形成新坑
					data[j--] = data[i];
				}
			}
			// 当 i=j 时，退出while循环，此时将 x 填入到坑data[i]中
			data[i] = x; 
			sort(data, left, i-1);
			sort(data, i+1, right);
		}
	}
}