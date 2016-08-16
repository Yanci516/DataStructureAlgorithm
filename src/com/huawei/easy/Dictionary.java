package com.huawei.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
题目描述
	给定n个字符串，请对n个字符串按照字典序排列。 
	
输入描述:
	输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。

输出描述:
	数据输出n行，输出结果为按照字典序排列的字符串。
 * 
 * @author Yancy
 * 2016年8月14日 下午2:59:38
 */
public class Dictionary implements Comparator<String>{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			//int n = Integer.parseInt(sc.nextLine());
			int n = sc.nextInt();
			System.out.println(n);
			String[] str = new String[n];
			for (int i = 0; i < n; i++) {
				str[i] = sc.nextLine();
				System.out.println(str[i]);
			}
			Arrays.sort(str,new Dictionary());
			for (int i = 0; i < n; i++) {
				System.out.println(str[i]);
			}
		}
	}

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}
