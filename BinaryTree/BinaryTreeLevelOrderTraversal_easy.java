/*
Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
public class BTLevelOrderTSol {
	public static List<List<Integer>> levelOrder1(TreeNode root) {
		List rst = new ArrayList();
		
		if (root == null) {
			return rst;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
			rst.add(level);
		}
		return rst;
	}
	
	public static List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		levelVisit(root, 0, rst);
		return rst;
	}
	
	public static void levelVisit(TreeNode root, int level, List<List<Integer>> rst) {
		if (root == null) {
			return;
		}
		
		if (level >= rst.size()) {
			rst.add(new ArrayList<Integer>());
		}
		
		rst.get(level).add(root.val);
		levelVisit(root.left, level + 1, rst);
		levelVisit(root.right, level + 1, rst);
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String arg[]) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		System.out.print(levelOrder1(t1));
		System.out.print("\n");
		System.out.print(levelOrder2(t1));
	}
}
/*
 * output: [[3], [9, 20], [15, 7]]
 */
