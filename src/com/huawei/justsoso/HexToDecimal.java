package com.huawei.justsoso;

import java.util.Scanner;

/**
 * 题目描述:
	写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
	
        输入描述:
	输入一个十六进制的数值字符串。
	
        输出描述:
	输出该数值的十进制字符串。
 * 
 * @author Yancy
 * 2016 2016年8月12日 下午12:36:34
 */
public class HexToDecimal {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()){
			String str = sc.next();
			int res = 0;
			for (int i = str.length() - 1 , k = 0 ; i >= 2; i--, k++){
				int j = 0;
				switch (str.charAt(i)) {
				
					case 'A': j = 10;
						break;
					case 'B': j = 11;
						break;
					case 'C': j = 12;
						break;
					case 'D': j = 13;
						break;
					case 'E': j = 14;
						break;
					case 'F': j = 15;
						break;
					default : j = Integer.parseInt(str.substring(i, i+1));
						break;
				}
				res += j * Math.pow(16, k);
			}
			System.out.println(res);
		}
	}
	
}
