package com.binary_search;

public class Test {
	
	public static void main(String[] args) {
		int[] arr = new int[]{10,5,2,3,4,1,10};
		GetLocalMin test = new GetLocalMin();
		System.out.println(test.getLessIndex(arr));
	}
}
