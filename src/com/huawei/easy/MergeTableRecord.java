package com.huawei.easy;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 合并表记录
 题目描述
	数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

输入描述:
	先输入键值对的个数
	然后输入成对的index和value值，以空格隔开

输出描述:
	输出合并后的键值对（多行）

输入例子:
	4
	0 1
	0 2
	1 2
	3 4

输出例子:
	0 3
	1 2
	3 4
 * 对于Java，这题直接采用TreeMap。 也可以使用桶排序算法
 * @author Yancy
 * 2016年8月13日 下午9:06:02
 */
public class MergeTableRecord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int key = sc.nextInt();
				int value = sc.nextInt();
				if (map.containsKey(key)) {
					map.put(key, value + map.get(key));
				} else {
					map.put(key, value);
				}
			}
			for (Integer k : map.keySet()) {
				System.out.println(k + " "+ map.get(k));
			}
		}
	}
}
