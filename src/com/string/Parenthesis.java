package com.string;

/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 要求时间复杂度为O(N)
 * 
 * 解题思路：声明一个 num 变量，再遍历括号字符数组，若匹配 '(' 则 num++， 若匹配 ')'则 num--
 * @author Yancy
 * 2016 2016年7月30日 下午7:46:55
 */
public class Parenthesis {

	public boolean chkParenthesis(String A, int n) {
		char[] cs = A.toCharArray();
		int num = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '(') {
				num++;
			}else if (cs[i] == ')') {
				num--;
			}else {
				return false;
			}
			// 若遍历过程中，num小于零则表示左括号数小于又括号数
			if (num < 0) {
				return false;
			}
		}
		if (num != 0) {
			return false;
		}
		return true;
	}
}
