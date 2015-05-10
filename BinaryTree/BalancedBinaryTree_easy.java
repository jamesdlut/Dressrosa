/*
 * Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
package BinaryTree;

public class BalanceBTSol {
	public static boolean isBalanced(TreeNode root) {
		return Helper(root) != -1;
	}
	
	private static int Helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = Helper(root.left);
		int right = Helper(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t4.right = t5;
		boolean rst = isBalanced(t1);
		System.out.print(rst);
	}
}
/*
 * output: false
 */
