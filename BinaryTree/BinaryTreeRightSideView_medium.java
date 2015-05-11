/*
Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/
public class BTRightSideViewSol {
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> rst = new ArrayList<Integer>();
		if (root == null) {
			return rst;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				if (i == 0) {
					rst.add(head.val);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
				if (head.left != null) {
					queue.offer(head.left);
				}
			}
		}
		return rst;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode myTree() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.right = t5;
		t3.right = t4;
		return t1;
	}
	
	public static void main(String[] args) {
		System.out.print(rightSideView(myTree()));
	}
}
