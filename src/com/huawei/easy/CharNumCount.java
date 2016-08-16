package com.huawei.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 字符个数统计
 * 
	题目描述
编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 * @author Yancy
 * 2016年8月13日 下午9:31:13
 */
public class CharNumCount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			Set<Character> set = new HashSet<Character>();
			String string = scanner.nextLine();
			char[] cs = string.toCharArray();
			for (int i = 0; i < cs.length; i++) {
				set.add(cs[i]);
			}
			System.out.println(set.size());
		}
	}
}
