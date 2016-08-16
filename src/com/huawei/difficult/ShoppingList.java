package com.huawei.difficult;

import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt() / 10;
		int m = scan.nextInt();
		int tv[] = new int[m + 1];
		int tp[] = new int[m + 1];
		int tq[] = new int[m + 1];
		int q[] = new int[m + 1]; // 依次存放每个主件的下标
		int[][] son = new int[m + 1][3]; // 存放组件对应的附件
		int dp[][] = new int[m + 1][N + 1];
		int index = 1;
		for (int t = 1; t <= m; t++) {
			tv[t] = scan.nextInt() / 10;
			tp[t] = scan.nextInt();
			tq[t] = scan.nextInt();
			if (tq[t] == 0) {
				q[index++] = t;
			}
		}

		// 将数据格式化为 一个数组存对应 主件序号，一个二维数组存对应主件的附件，通过下标对应

		for (int j = 1; j < index; j++) {
			int k = 1;
			for (int i = 1; i <= m; i++) {
				if (tq[i] == q[j]) {
					son[j][k++] = i;
				}
			}
		}
		
		for (int i = 1; i < index; i++) {
			
			int fW = tv[q[i]] * tp[q[i]]; // 只选主件
			int sW1 = tv[son[i][1]] * tp[son[i][1]];
			int sW2 = tv[son[i][2]] * tp[son[i][2]];
			int sW12 = sW1 + sW2;
			int V1 = tv[q[i]] + tv[son[i][1]]; // 选主件和第一个附件， 当然第一个附件不一定存在
			int V2 = tv[q[i]] + tv[son[i][2]]; // 选主件和第二个附件， 当然第二个附件也不一定存在
			int V12 = tv[q[i]] + tv[son[i][1]] + tv[son[i][2]]; // 选主件和第一、二个附件，
			
			for (int j = 1; j <= N; j++) { 

				if (j >= tv[q[i]]){
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tv[q[i]]] + fW);
					
					if (tv[son[i][1]] != 0 && j >= V1){
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - V1] + fW + sW1);
						
						if (tv[son[i][2]] != 0 && j >= V12)
							dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - V12] + fW + sW12);
					}
					if (tv[son[i][2]] != 0 && j >= V2)
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - V2] + fW + sW2);
					
				}
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		// 最后要乘以10，因为除了10
		System.out.println(dp[index - 1][N] * 10);
	}
}