package com.structure.tree;

import java.util.List;

/**
 * 实现二叉树的构建，以及前序、中序、后序遍历
 * @author Yancy
 * 2016 2016年8月4日 下午5:53:11
 */
public class BinaryTree {
	private List<Node> list;
	
	// 定义静态内部类节点
	static class Node{
		int value; //值
		Node leftChild; // 左孩子
		Node rightChild; // 右孩子
		
		public Node(int value) {
			this.value = value;
			leftChild = null;
			rightChild = null;
		}
	} 
	public void createBinaryTree(int[] arr){
		// 先将数组全部转化为节点
		for (int i = 0; i < arr.length; i++) {
			list.add(new Node(arr[i]));
		}
	}
}
