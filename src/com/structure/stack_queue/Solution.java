package com.structure.stack_queue;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型Solution中实现一个能够得到栈中最小元素的min函数。可利用现成的堆
 * 时间复杂度为O(1),空间复杂度为O(N)
 * 
 * 解题思路： 创建两个栈，s1栈用于正常存取数据，s2栈用于存取最小值；
 * 		     栈为空时两个栈直接放入数据，栈不为空时s1栈正常放入值，
 * 			若待放入值小于s2栈中的顶元素则放入，若大于或等于则放入之前s2栈中的堆顶元素
 * @author Yancy 2016年8月1日 上午10:34:02
 */
public class Solution {

	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();

	public void push(int node) {
		if (s1.isEmpty()) {
			s1.push(node);
			s2.push(node);
		}else {
			s1.push(node);
			if (node < s2.peek()) {
				s2.push(node);
			}else {
				s2.push(s2.peek());
			}
		}
	}

	public void pop() {
		if (s1.isEmpty()) {
			return;
		}else {
			s1.pop();
			s2.pop();
		}
	}

	public int top() {
		if (s1.isEmpty()) {
			return -1;
		}else
			return s1.peek();
	}

	public int min() {
		if (s1.isEmpty()) {
			return -1;
		}else
			return s2.peek();
	}
}
