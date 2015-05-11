/*
Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/
public class MinDepthOfBTSol {
	// recursion
	public static int minDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return dfs(root);
	}
	
	public static int dfs(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		return Math.min(dfs(root.left), dfs(root.right)) + 1;
	}
	// level traversal
	public static int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int level = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			level++;
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (cur.left == null && cur.right == null) {
					return level;
				}
				if (cur.left != null) {
					q.offer(cur.left);
				}
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}
		}
		return 0;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode (int x) {
			val = x;
		}
	}
	
	public static TreeNode myTree() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		return t1;
	}
	
	public static void main(String arg[]) {
		System.out.print(minDepth1(myTree()));
		System.out.print("\n");
		System.out.print(minDepth2(myTree()));
	}
}
/*
 * outputs:
 * 2
 * 2
 */
