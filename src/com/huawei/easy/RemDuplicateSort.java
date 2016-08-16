package com.huawei.easy;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 明明的随机数
 * 
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
	Input Param 
	     n               输入随机数的个数     
	 inputArray      n个随机整数组成的数组 
	     
	Return Value
	     OutputArray    输出处理后的随机整数
	     
	注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组
	     
 * @author Yancy
 * 2016 2016年8月11日 下午10:20:12
 */
public class RemDuplicateSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组
		// 因此需要一直判断是否还有输入
		while (sc.hasNext()){
            TreeSet<Integer> set = new TreeSet<Integer>();
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				set.add(sc.nextInt());
			}
            for (Integer integer : set) {
				System.out.println(integer);
			}
		}
		
    }
}
