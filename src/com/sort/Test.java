package com.sort;

import com.sort.typical_case.Subsequence;

public class Test {
	public static void main(String[] args) {
		int[] A = new int[]{1,5,4,3,2,6,7};
		Subsequence sort = new Subsequence();
		int  b = sort.shortestSubsequence(A, A.length);
		System.out.println(b);
		
	}
}
