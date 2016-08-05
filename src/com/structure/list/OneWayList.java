package com.structure.list;

public class OneWayList {
	int index;
	int size;
	Node head; //头结点
	Node first; //当前结点

	/**
	 * 结点内部类
	 * @author Yancy
	 */
	class Node{
		int index;
		int value; //结点值
		Node next; //当前结点的下一个结点
		
		public Node(int value) {
			this.index = 0;
			this.value = value;
		}
	}
	
	public OneWayList() {
		this.size = 0;
		this.first = this.head = null;
	}
	
	/**
	 * 向链表添加元素
	 * @param value 待添加的元素
	 */
	public void add(int value) {
		if (this.head == null) {
			this.head = new Node(value);
			this.first = this.head;
			
		}else{
			first.next = new Node(value);
			first = first.next;
			first.index = ++this.index;
		}
		this.size++;
	}
	/**
	 * 获取第一个结点元素
	 * @return 返回第一个结点元素值
	 */
	public int getFirst() {
		if (head == null) {
			return 0;
		}else {
			Node node = first;
			first = first.next;
			this.size--;
			return node.value;
		}
	}
	
	/**
	 * 返回指定索引的结点
	 * @param index
	 * @return
	 */
	private Node getIndex(int index){
		if (index < 0 ||index>size) {
			throw new IndexOutOfBoundsException( "Index: "+index+
                    ", Size: "+size );
		}
		Node node = head; //取出头结点
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	/**
	 * 获取指定索引的值
	 * @param index 指定索引
	 * @return 指定索引的值
	 */
	public int get(int index){
		return getIndex(index).value;
	}
}
