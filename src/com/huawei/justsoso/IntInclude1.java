package com.huawei.justsoso;

import java.util.Scanner;

/**
 *求int型数据在内存中存储时1的个数
 *
题目描述
	输入一个int型数据，计算出该int型数据在内存中存储时1的个数。

输入描述:
	输入一个整数（int类型）

输出描述:
	这个数转换成2进制后，输出1的个数
 * 
 * @author Yancy
 * 2016 2016年8月14日 下午4:04:32
 */
public class IntInclude1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			int i = scanner.nextInt();
			int res = 0;
			while (i > 0){
				if ((i & 1) > 0) {
					res++;
				}
				i = i >> 1;
			}
			System.out.println(res);
		}
	}

}
