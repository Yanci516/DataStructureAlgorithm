package com.structure.stack_queue;

import java.util.ArrayList;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 
 * 解题思路：利用辅助的help栈来辅助比较   若当前栈顶元素大于等于help栈顶元素，则将当前栈顶元素弹出并压入help栈，
 * 		                                                            若当前栈顶元素小于help栈顶元素，则先当前栈顶元素弹出，再将help元素弹出放入当前栈
 * 													  最后将当前当前栈弹出的元素再压入help栈，再继续重复
 * @author Yancy
 * 2016年8月1日 下午3:32:55
 */
public class TwoStacks {
	
	
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] help = new int[numbers.length];
		int n = numbers.length - 1;
		int i = n; // 表示help数组元素的下标
		int j = 0; // 表示help数组元素的下标
		while(true){
			int key = numbers[j++];
			if (i == n) {
				help[i] = key;
			}
			if (help[i] <= key) {
				help[i--] = key;
			}else {
				while(key < help[i]){
					numbers[--j] = help[i++];
					if (i == n+1) {
						break;
					}
				}
				help[--i] = key;
			}
			if (i < 0) {
				break;
			}
		}
		for (int p = 0; p < help.length; p++) {
			list.add(help[p]);
		}
		return list;
	}
}
