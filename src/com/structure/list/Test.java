package com.structure.list;

public class Test {
	public static void main(String[] args) {
		OneWayList list = new OneWayList();
		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println(list.getFirst());
		System.out.println(list.get(1));
	}
}
