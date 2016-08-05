package com.sort.typical_case;

/**
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * 给定一个int矩阵mat，同时给定矩阵大小 n x m 及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。
 * 所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 * 
 * 要求时间复杂度0(n),空间复杂度0(1)
 * 
 * 从矩阵的右上角元素着手:若大于x, 则最右列关键字都大于x，列数--继续循环;
 * 				        若小于x, 则最上行关键字都小于x，行数++继续执行;
 *                 若等于x, 则返回 true
 *                 当行数大于 n 或者列数小于 0 时，则返回false
 * @author Yancy
 * 2016 2016年7月27日 下午3:56:14
 */
public class Finder {
	
	public boolean findX(int[][] mat, int n, int m, int x){
		int i = 0; // 定义 i 初始为第 0行
		int j = m-1; // 定义 j 初始为定 m列
		while(i < n  && j >= 0){
			
			if (mat[i][j] > x) {
				j--;
			}else if (mat[i][j] < x) {
				i++;
			}else if (mat[i][j] == x) {
				return true;
			}
		}
		return false;
	}
}
