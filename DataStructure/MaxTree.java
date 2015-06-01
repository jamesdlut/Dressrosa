/*
Max Tree
Given an integer array with no duplicates. A max tree building on this array is defined as follow:
The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
Example
Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:
    6
   / \
  5   3
 /   / \
2   0   1
Challenge
O(n) time and memory.
*/
public class MaxTreeSol {
	public static TreeNode maxTree(int[] A) {
		int len = A.length;
		TreeNode[] rst = new TreeNode[len];
		for (int i = 0; i < len; i++) {
			rst[i] = new TreeNode(0);
		}
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			TreeNode tmp = new TreeNode(A[i]);
			while (cnt > 0 && A[i] > rst[cnt - 1].val) {
				tmp.left = rst[cnt - 1];
				cnt--;
			}
			if (cnt > 0) {
				rst[cnt - 1].right = tmp;
			}
			rst[cnt] = tmp;
			cnt++;
		}
		return rst[0];
	}
	
	public static class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {2, 5, 6, 0, 3, 1};
		TreeNode rst = maxTree(A);
		System.out.print(LOrder(rst));
	}
	
	public static List<List<Integer>> LOrder(TreeNode root) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (root == null) {
			return rst;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = q.poll();
				list.add(tmp.val);
				if (tmp.left != null) {
					q.offer(tmp.left);
				}
				if (tmp.right != null) {
					q.offer(tmp.right);
				}
			}
			rst.add(list);
		}
		return rst;
	}
}
