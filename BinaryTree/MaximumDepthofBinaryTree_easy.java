/*
 * Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthofBTSol {
	public static int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth1(root.left);
		int right = maxDepth1(root.right);
		return Math.max(left, right) + 1;
	}
	
	public static int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		TreeNode dummy = new TreeNode(0);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(dummy);
		int depth = 0;
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur == dummy) {
				depth++;
				if (!q.isEmpty()) {
					q.offer(dummy);
				}
			}
			if (cur.left != null) {
				q.offer(cur.left);
			}
			if (cur.right != null) {
				q.offer(cur.right);
			}
		}
		return depth;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode (int x) {
			val = x;
		}
	}
	
	public static void main(String arg[]) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		System.out.print(maxDepth1(t1));
		System.out.print("\n");
		System.out.print(maxDepth2(t1));
	}
}
/*
outputs: 
3
3
*/
