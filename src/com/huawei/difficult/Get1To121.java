package com.huawei.difficult;

import java.util.Scanner;

/**
 * 给定五个数字，1 3 9 27 81，使用加减法他们可以算出1到121之间的任意结合
 * 输入 13,输出 9+3+1;输出41，输出81-27-9-3-1。
 * 
 * 观测发现：
 *		区间 [1,1]    必须用到1
 *		区间 [2,4]    必须用到3
 * 		区间 [5,13]   必须用到9
 * 		区间 [14,40]  必须用到27
 * 		区间 [41,121] 必须用到81
 * 
 * @author Yancy
 * 2016年8月15日 下午5:04:11
 */
public class Get1To121 {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			Integer i = scanner.nextInt();
			System.err.println(getExpression(i));
		}
	}
	
	private static String[] common1(String res, int m, Integer i) {
		i = m - i;
		if (res.length() == 0) {
			res += m + " - ";
		} else {
			if (res.charAt(res.length() - 2) == '-')
				res += m + " + ";
			else
				res += m + " - ";
		}
		return new String[]{res,String.valueOf(i)};
	}

	private static String[] common2(String res, int m, Integer i) {
		i = i - m;
		if (res.length() == 0) {
			res += m + " + ";
		} else {
			if (res.charAt(res.length() - 2) == '-')
				res += m + " - ";
			else
				res += m + " + ";
		}
		return new String[]{res,String.valueOf(i)};
	}
	
	private static String getExpression(Integer i){
		String res = "";
		while (i > 0){
			if (i == 1) {
				res += "1";
				break;
			}
			
			if (i >= 2 && i <= 4){
				if (i < 3){
					i = Integer.parseInt(common1(res, 3, i)[1]);
					res = common1(res, 3, i)[0];
				}
				if (i == 3) {
					res += 3;
					break;
				}
				if (i >= 3) {
					i = Integer.parseInt(common2(res, 3, i)[1]);
					res = common2(res, 3, i)[0];
				}
			}
			
			if (i >= 5 && i <= 13) {
				if (i < 9) {
					i = Integer.parseInt(common1(res, 9, i)[1]);
					res = common1(res, 9, i)[0];
				}
				if (i == 9) {
					res += "9";
					break;
				}
				if (i > 9) {
					i = Integer.parseInt(common2(res, 9, i)[1]);
					res = common2(res, 9, i)[0];
				}
			}
			if (i >= 14 && i <= 40) {
				if (i < 27) {
					i = Integer.parseInt(common1(res, 27, i)[1]);
					res = common1(res, 27, i)[0];
				}
				if (i == 27) {
					res += "27";
					break;
				}
				if (i > 27) {
					i = Integer.parseInt(common2(res, 27, i)[1]);
					res = common2(res, 27, i)[0];
				}
			}
			if (i >= 41 && i <= 121) {
				if (i < 81) {
					i = 81 - i;
					res += "81 - ";
				}
				if (i == 81) {
					res += "81";
					break;
				}
				if (i > 81) {
					i = i - 81;
					res += "81 + ";
				}
			}
		}
		return res;
	}
}
