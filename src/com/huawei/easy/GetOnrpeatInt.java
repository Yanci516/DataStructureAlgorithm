package com.huawei.easy;

import java.util.*;

/**
 * 提取不重复的整数
题目描述
	输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * @author Yancy
 * 2016 2016年8月13日 下午9:29:47
 */
public class GetOnrpeatInt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			Set<Integer> set = new LinkedHashSet<Integer>();
			int i = sc.nextInt();
			String str = String.valueOf(i);
			for (int j = str.length() - 1; j >= 0; j--){
				set.add(Integer.parseInt(str.substring(j,j+1)));
			}
			for (Integer integer : set) {
				System.out.print(integer);
		}
	}
}
