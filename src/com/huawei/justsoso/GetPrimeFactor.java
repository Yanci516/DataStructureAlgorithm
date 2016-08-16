package com.huawei.justsoso;

import java.util.Scanner;

/**
 * 质数因子
 * 
题目描述
	功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
输入描述:
	输入一个long型整数

输出描述:
	按照从小到大的顺序输出它的所有质数的因子，以空格隔开

输入例子:
	180

输出例子:
	2 2 3 3 5
	
	解题：其实就是因式分解，不过因子全是质数（素数）
	
 * @author Yancy
 * 2016 2016年8月12日 下午2:03:55
 */
public class GetPrimeFactor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			long num = sc.nextLong();
			while (num != 1){
				for(int i = 2; i <= num; i++){
					if (num % i == 0) {
						num /= i;
						System.out.println(i + " ");
						break;
					}
				}
			}
		}
	}
}
