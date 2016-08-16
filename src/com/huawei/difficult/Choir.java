package com.huawei.difficult;

import java.util.*;

/**
 * 合唱团
 * 
 * @author Yancy
 * 2016 2016年8月13日 下午9:44:03
 */
public class Choir {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		int[] l = new int[n];
		int[] r = new int[n];

		int max = 0;

		for (int i = 0; i < n; i++) {

			l[i] = 1;

			for (int j = 0; j < i; j++) {

				if (a[j] < a[i]) {

					l[i] = Math.max(l[i], l[j] + 1);

				}

			}

		}

		for (int i = n - 1; i >= 0; i--) {

			r[i] = 1;

			for (int j = n - 1; j > i; j--) {

				if (a[j] < a[i]) {

					r[i] = Math.max(r[i], r[j] + 1);

				}

			}

			max = Math.max(max, l[i] + r[i] - 1);

		}

		System.out.print(n - max);

	}

}