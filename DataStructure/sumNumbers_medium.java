/*
Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.
*/
public class SumNumsSol {
	public static int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}
	
	public static int dfs(TreeNode root, int pre) {
		if (root == null) {
			return 0;
		}
		
		int cur = pre * 10 + root.val;
		if (root.left == null && root.right == null) {
			return cur;
		}
		return dfs(root.left, cur) + dfs(root.right, cur);
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		System.out.print(sumNumbers(t1));
	}
}
