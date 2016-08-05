package com.string;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树.
 * 
 * 结题思路：先将字两颗二叉树转化为字符串序列，再使用 Kmp 算法判断
 * 
 * @author Yancy
 * 2016 2016年7月28日 下午3:22:34
 */
public class IdenticalTree {
	
	public boolean chkIdentical(TreeNode A, TreeNode B) {
		String strA = serialByPre(A);
		String strB = serialByPre(B);
		
		Kmp kmp = new Kmp();
		return kmp.kmpSearch(strA, strB) != -1;
	}
	
	public String serialByPre(TreeNode head){
		if (head == null) {
			return "#!";
		}
		
		String str = head.val + "!";
		str += serialByPre(head.left);
		str += serialByPre(head.right);
		return str;
	}
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}