package com.structure.stack_queue;
import java.util.Stack;
/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop、push操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 * 
 * 解题思路： 先声明一个递归函数 get() 来获取栈底元素
 * 		     主函数里递归获取堆底元素，再从新压入栈，这样的结果就是逆序
 * @author Yancy
 * 2016年8月1日 下午2:24:47
 */
public class StackReverse {
	
	// 声明一个栈，用于将给的数组转为栈来操作
	private Stack<Integer> s = new Stack<Integer>();
	public int[] reverseStack(int[] A, int n) {
		// 将给定的数组元素存入栈
		for (int i = 0; i < A.length; i++) {
			s.push(A[i]);
		}
		reverse(s); // 栈逆序操作
		// 将栈逐个弹出并赋值给元数组
		for (int i = A.length - 1; i >= 0; i--) {
			A[i] = s.pop();
		}
		return A;
    }
	
	public void reverse(Stack<Integer> stack){
		if (stack.isEmpty()) {
			return;
		}
		// 递归获取堆底元素
		int bottom = get(stack); 
		reverse(stack); //递归调用 reverse()
		stack.push(bottom);
	}
	// 弹出堆底元素
	public int get(Stack<Integer> stack){
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		}else {
			int last = get(stack); // 递归调用get()
			stack.push(result);
			return last;
		}
	}
}
