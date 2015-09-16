/*
 * Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
   return [1,2,3].
   Note: Recursive solution is trivial, could you do it iteratively?
 */
/*
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   6
 *  
 */
package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderSol {
	/*
	 * test
	 */
	public static void BinaryTreePreorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + "");
		BinaryTreePreorderTraversal(root.left);
		BinaryTreePreorderTraversal(root.right);
	}
	/*
	 * Non-Recursion 
	 */
	public static List<Integer> preorderTraversal0(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> rst = new ArrayList<Integer>();
		if (root == null) {
			return rst;
		}
		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			rst.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return rst;
	}
	/*
	 * Traverse
	 */
	public static List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> rst = new ArrayList<Integer>();
		traverse(root, rst);
		return rst;
	}
	
	private static void traverse(TreeNode root, List<Integer> rst) {
		if (root == null) {
			return;
		}
		rst.add(root.val);
		traverse(root.left, rst);
		traverse(root.right, rst);
	}
	/*
	 * Divide & Conquer
	 */
	public static List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> rst = new ArrayList<Integer>();
		if (root == null) {
			return rst;
		}
		// Divide
		List<Integer> left = preorderTraversal2(root.left);
		List<Integer> right = preorderTraversal2(root.right);
		// Conquer
		rst.add(root.val);
		rst.addAll(left);
		rst.addAll(right);
		return rst;
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	public static void main(String arg[]) {
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.right = r6;
		
		System.out.print("test: ");
		BinaryTreePreorderTraversal(r1);
		
		List<Integer> preorder0 = new ArrayList<Integer>();
		preorder0 = preorderTraversal0(r1);
		System.out.print("\n" + "preorder0: ");
		for (int i = 0; i < preorder0.size(); i++) {
			System.out.print(preorder0.get(i) + "");
		}
		
		List<Integer> preorder1 = new ArrayList<Integer>();
		preorder1 = preorderTraversal1(r1);
		System.out.print("\n" + "preorder1: ");
		for (int i = 0; i < preorder1.size(); i++) {
			System.out.print(preorder1.get(i) + "");
		}	
		
		List<Integer> preorder2 = new ArrayList<Integer>();
		preorder2 = preorderTraversal1(r1);
		System.out.print("\n" + "preorder2: ");
		for (int i = 0; i < preorder2.size(); i++) {
			System.out.print(preorder2.get(i) + "");
		}
	}
}
/*
 * outputs:
 * test: 124536
 * preorder0: 124536
 * preorder1: 124536
 * preorder2: 124536
 */
