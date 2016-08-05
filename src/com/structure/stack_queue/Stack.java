package com.structure.stack_queue;

public class Stack {
	
	int size; //栈大小
	Node first; //栈第一个节点
	Node head; //栈头结点
	/**
	 * 定义一个节点内部类 
	 * @author Yancy
	 */
	class Node{
		int value; //节点值
		Node pre; //当前节点的前一个节点
		
		Node(int value) {
			this.value = value;
		}
	}
	
	public Stack() {
		this.size = 0;
		this.first = null;
	}
	
	public Stack(Node node){
		this.size++;
		this.first = node;
	}
	
	public void push(int value) {
		if (head == null) {
			head = new Node(value);
			first = head;
			
		} else{
			Node node = new Node(value);
			node.pre = this.first;
			this.first = node;
		}
		this.size ++;
	}
	
	public Node pop(){
		if (this.first == null) {
			return null;
		}else{
			Node node = this.first;
			this.first = this.first.pre;
			this.size--;
			return node;
		}
	}
	
}
