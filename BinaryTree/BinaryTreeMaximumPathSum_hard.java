/*
Binary Tree Maximum Path Sum
Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1
      / \
     2   3
Return 6.
*/
/*
计算树的最长path有2种情况：
1. 通过根的path.
  (1)如果左子树从左树根到任何一个Node的path大于零，可以链到root上
  (2)如果右子树从右树根到任何一个Node的path大于零，可以链到root上
2. 不通过根的path. 这个可以取左子树及右子树的path的最大值。
所以创建一个inner class:
记录2个值：
1. 本树的最大path。
2. 本树从根节点出发到任何一个节点的最大path.
注意，当root == null,以上2个值都要置为Integer_MIN_VALUE; 因为没有节点可取的时候，是不存在solution的。以免干扰递归的计算
if any of the path of left and right is below 0, don't add it.
注意，这里不可以把Math.max(left.maxSingle, right.maxSingle) 与root.val加起来，会有可能越界
may left.maxSingle and right.maxSingle are below 0
*/
public class BTMaxPathSumSol {
	public static int maxPathSum(TreeNode root) {
		return dfs(root).max;
	}
	
	public static class ReturnType {
		int maxSingle;
		int max;
		ReturnType(int maxSingle, int max) {
			this.max = max;
			this.maxSingle = maxSingle;
		}
	}
	
	public static ReturnType dfs(TreeNode root) {
		ReturnType ret = new ReturnType(Integer.MIN_VALUE, Integer.MIN_VALUE);
		if (root == null) {
			return ret;
		}
		
		ReturnType leftR = dfs(root.left);
		ReturnType rightR = dfs(root.right);
		// case1
		int cross = root.val;
		cross += Math.max(0, leftR.maxSingle);
		cross += Math.max(0, rightR.maxSingle);
		// case2
		int maxSingle = Math.max(leftR.maxSingle, rightR.maxSingle);
		maxSingle = Math.max(maxSingle, 0);
		maxSingle += root.val;
		ret.maxSingle = maxSingle;
		ret.max = Math.max(leftR.max, rightR.max);
		
		ret.max = Math.max(ret.max, cross);
		return ret;
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
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		int rst = maxPathSum(t1);
		System.out.print(rst);
	}
}
