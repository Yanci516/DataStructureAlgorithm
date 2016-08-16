package com.huawei.justsoso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 题目描述:
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩. 
 * 
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候,
 * 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * 
 * 输出描述:
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * 输入例子:
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * 
 * 输出例子:
 * 5
 * 6
 * 5
 * 9
 * 
 * 本题易错点是输的多组测试数据
 * @author Yancy
 * 2016年8月9日 下午10:20:13
 */
public class HighestScore {

	public static void main(String args[]) throws IOException {
		// 获取外部输入（注意多组输入）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringTokenizer st;
		while((line = br.readLine()) != null){
			// 按照每一行对字符串进行分割
			st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			//N个学生的成绩,学生ID是做1开始，所以为N+1
			int[] score = new int[N + 1];
			if ((line = br.readLine()) != null) {
				st = new StringTokenizer(line);
				for (int i = 1; i < score.length; i++){ 
					score[i] = Integer.parseInt(st.nextToken());
				}
			}
			
			//对 M行的Q U 解析
			for(int i = 0; i != M; i++){
				if ((line = br.readLine()) != null) {
					st = new StringTokenizer(line);
					// 获取 字符  Q 或者 U
					String C = st.nextToken(); 
					// 获取两个正整数A B
					int A = Integer.parseInt(st.nextToken());
					int B = Integer.parseInt(st.nextToken());
					if (C.equals("Q")) {
						System.out.println(getMax(score, A, B));
					}
					if (C.equals("U")) {
						score[A] = B;
					}
				}
			}
		}
	}
	
	/**
	 * 获取数组最大数
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getMax(int[] arr, int start, int end){
		if (start > end) {
			int temp = end;
			end = start;
			start = temp;
		}
		int max = Integer.MIN_VALUE;
		for (int i = start; i<= end; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}
}
