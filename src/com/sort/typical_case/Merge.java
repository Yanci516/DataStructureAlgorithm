package com.sort.typical_case;

/**
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 *
 * @author Yancy 2016 2016年7月26日 下午3:26:05
 */
public class Merge {

	public int[] mergeAB(int[] A, int[] B, int n, int m) {
		while (true) {
			// 从右开始分别判断该两个数组的大小，并将较大则赋值到A中
			if (A[n-1] >= B[m-1]) {
				A[n+m-1] = A[n-1];
				n--;
			}else {
				A[n+m-1] = B[m-1];
				m--;
			}
			// 若n=0且m!=0 ,表示数组A已将所有关键字按序赋值到数组A的后面缓存空间，只需要处理B即可
			if (n == 0 && m != 0) {
				for(int i = m-1; i >= 0; i--){
					A[i] = B[i];
                    m--;
				}
			}
			//若 m=0,表示数组B已将所有关键字按序赋值到数组A中，现在直接跳出即可
			if (m == 0) {
				break;
			}
		}
		return A;
	}
}
