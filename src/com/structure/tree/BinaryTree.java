package com.structure.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 该实现完全二叉树的构建，以及前序、中序、后序遍历
 * @author Yancy
 * 2016 2016年8月4日 下午5:53:11
 */
public class BinaryTree {
	private static List<Node> list;
	
	// 定义静态内部类节点
	static class Node{
		int value; //值
		private Node leftChild; // 左孩子
		private Node rightChild; // 右孩子
		public Node(int value) {
			this.value = value;
			this.setLeftChild(null);
			this.setRightChild(null);
		}
		public Node getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}
		public Node getRightChild() {
			return rightChild;
		}
		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}
	} 
	
	/**
	 * 根据数组构建二叉树
	 * @param arr 需要建立二叉树的数组
	 */
	public static void createBinaryTree(int[] arr){
		list = new LinkedList<Node>();
		// 先将数组中全部关键字转化为节点，并加入List集合
		for (int i = 0; i < arr.length; i++) {
			list.add(new Node(arr[i]));
		}
		// 二叉树的总的父节点(带孩子的节点)为 (总节点数/2 -1)
		for(int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++){
			//分别添加左孩子和右孩子
			list.get(parentIndex).leftChild = list.get(parentIndex*2 + 1);
			list.get(parentIndex).rightChild = list.get(parentIndex*2 + 2);
		}
		// 最后一个节点可能没有右孩子，需要单独处理
		int lastParentIndex = arr.length / 2 - 1;
		list.get(lastParentIndex).leftChild = list.get(lastParentIndex*2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (arr.length % 2 != 0) {
			list.get(lastParentIndex).rightChild = list.get(lastParentIndex*2 + 2);
		}
	}
	
	/**
	 * 递归先序遍历 
	 * @param node 根节点
	 */
	public static void preOrder(Node node){
		if (node == null) {
			return;
		}
		System.out.print(node.value+" ");
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}
	
	/**
	 * 递归中序遍历 
	 * @param node 根节点
	 */
	public static void inOrder(Node node){
		if (node == null) {
			return;
		}
		inOrder(node.leftChild);
		System.out.print(node.value+" ");
		inOrder(node.rightChild);
	}
	
	/**
	 * 递归后序遍历 
	 * @param node 根节点
	 */
	public static void backOrder(Node node){
		if (node == null) {
			return;
		}
		backOrder(node.leftChild);
		backOrder(node.rightChild);
		System.out.print(node.value+" ");
	}
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
		createBinaryTree(arr);
		System.out.println("先序遍历：");
		preOrder(list.get(0));
		System.out.println();
		System.out.println("中序遍历：");
		inOrder(list.get(0));
		System.out.println();
		System.out.println("后续遍历：");
		backOrder(list.get(0));
	}
}
