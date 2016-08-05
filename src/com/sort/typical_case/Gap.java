package com.sort.typical_case;

/**
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 * 
 * 利用桶排序思想 ： 先找出数组中的最大值max、最小值min； 若数组长度为n,则将最值差分为分为 n 个区间（桶），每个区间范围相同；
 * 再将每个关键字放入相应的区间（桶）中，并且将最大值放入第n+1桶中； 现在一共有n+1个桶、n个数据，必然会存在空桶；
 * 空桶相邻桶中关键字之间的差值绝对大于同一个桶中关键字的差值
 * 
 * @author Yancy 2016 2016年7月27日 下午4:54:42
 */
public class Gap {

	public int maxGap(int[] A, int n) {
		int min = A[0];
		int max = A[0];
		// 获取最大值与最小值
		for (int i = 1; i < n; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		if (min == max) {
			return 0;
		}
		// 布尔数组用来判断某个桶里是否有关键字
		boolean[] hasNum = new boolean[n + 1];
		// 存放每个桶中的最值
		int[] maxs = new int[n + 1];
		int[] mins = new int[n + 1];
		int index = 0;
		for (int i = 0; i < n; i++) {
			index = bucket(A[i], n, min, max); // 先算出桶号
			// 计算出每个桶中的最值
			mins[index] = hasNum[index] ? Math.min(mins[index], A[i]) : A[i];
			maxs[index] = hasNum[index] ? Math.max(maxs[index], A[i]) : A[i];
			hasNum[index] = true; //设置当前桶有关键字
		}
		int res = 0; //存放最终返回结果
		int lastMax = 0; //上一个存有关键字的桶的最大值
		int i = 0;
		while (i <= n) {
			// 找到第一个不为空的桶
			if (hasNum[i++]) {
				lastMax = maxs[i - 1];
				break;
			}
		}
		for (; i <= n; i++) {
			// 若当前桶存有关键字，则减去上一个存有关键字桶的最大值即得到差值
			if (hasNum[i]) {
				// 每循环一次都取最大的差值
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i]; //重新赋值lastMax
			}
		}
		return res;
	}

	// 计算出当前值处于哪个桶，使用long类型，防止相除时溢出
	public int bucket(long num, long n, long min, long max) {
		return (int) ((num - min) * n / (max - min));
	}
}
