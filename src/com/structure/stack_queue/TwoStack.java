package com.structure.stack_queue;

import java.util.Stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * 
 * 解题思路： 声明两个栈，sPush栈用于push数据，sPop栈用于pop数据
 * 		  注意点：只有当sPop栈为空时，才从sPush栈传入其全部数据，注意是全部
 * @author Yancy
 * 2016年8月1日 上午11:21:50
 */
public class TwoStack {
	 	private Stack<Integer> sPush = new Stack<Integer>();
		private Stack<Integer> sPop = new Stack<Integer>();
		
		public int[] twoStack(int[] ope, int n) {
			int count = 0; //用于记录返回数组的大小
			for (int i = 0; i < ope.length; i++) {
				// 若元素为0，则不压入栈，且将count++
				if (ope[i] == 0) {
					count++;
				}else {
					push(ope[i]);
				}
			}
			int[] res = new int[count];
			for (int i = 0; i < count; i++) {
				res[i] = pop();
			}
			return res;
	    }
		// 支持插入
		void push(int item){
			sPush.push(item);
		}
		// 支持弹出
		int pop(){
	        // 只有当用于sPop栈为空时，才从sPush栈将数据全部转入sPop栈
			if (sPop.isEmpty()) {
				while(!sPush.isEmpty()){
					sPop.push(sPush.pop());
				}
			}
			return sPop.pop();
		}
}
