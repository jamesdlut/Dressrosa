/*
Validate Binary Search Tree 
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
/*
notice ReturnType (int min, int max, boolean isBST)
dfs(5)
left = dfs(3)
 left = dfs(2)
  left = dfs(1)
   left(null): return ret = new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
   right(null): return ret = new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
   from the return, we can know:
   left.isBST = true, right.isBST = true;
   left.min = Integer.MAX_VALUE, right.min = Integer.MAX_VALUE;
   left.max = Integer.MIN_VALUE, right.max = Integer.MIN_VALUE;
  continue 
  return new ReturnType(Math.min(1, Integer.MAX_VALUE), Math.max(1, Integer.MIN_VALUE), true);
 continue
 left(1): return new ReturnType(Math.min(1, Integer.MAX_VALUE), Math.max(1, Integer.MIN_VALUE), true);
 right(null): return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
 left.min = 1, right.min = Integer.MAX_VALUE
 left.max = 1 < 2, right.max = Integer.MIN_VALUE 
 root.right == null
 return new ReturnType(Math.min(2, 1), Math.max(2, Integer.MIN_VALUE), true);
...
right = dfs(8)
*/
public class ValidateBSTSol {
	// inorder traversal
	public static boolean isValidBST1(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (true) {
			while (cur != null) {
				s.push(cur);
				cur = cur.left;
			}
			if (s.isEmpty()) {
				break;
			}
			cur = s.pop();
			if (pre != null && pre.val >= cur.val) {
				return false;
			}
			pre = cur;
			cur = cur.right;
		}
		return true;
	}
	// low-up bounds
	public static boolean isValidBST2(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public static boolean dfs(TreeNode root, long low, long up) {
		if (root == null) {
			return true;
		}
		if (root.val >= up || root.val <= low) {
			return false;
		}
		return dfs(root.left, low, root.val) && dfs(root.right, root.val, up);
	}
	// recursive
	public static boolean isValidBST3(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return dfs(root).isBST;
	}
	
	public static class ReturnType {
		int min;
		int max;
		boolean isBST;
		public ReturnType (int min, int max, boolean isBST) {
			this.min = min;
			this.max = max;
			this.isBST = isBST;
		}
	}
	
	public static ReturnType dfs(TreeNode root) {
		ReturnType ret = new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		if (root == null) {
			return ret;
		}
		
		ReturnType left = dfs(root.left);
		ReturnType right = dfs(root.right);
		if (!left.isBST || !right.isBST) {
			ret.isBST = false;
			return ret;
		}
		if (root.left != null && root.val <= left.max) {
			ret.isBST = false;
			return ret;
		}
		if (root.right != null && root.val >= right.min) {
			ret.isBST = false;
			return ret;
		}
		return new ReturnType(Math.min(root.val, left.min), Math.max(root.val, right.max), true);
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
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(1);
		TreeNode t6 = new TreeNode(8);
		TreeNode t7 = new TreeNode(6);
		TreeNode t8 = new TreeNode(9);
		TreeNode t9 = new TreeNode(7);
		t1.left = t2;
		t1.right = t6;
		t2.left = t3;
		t2.right = t4;
		t3.left = t5;
		t6.left = t7;
		t6.right = t8;
		t7.right = t9;
		System.out.print(isValidBST1(t1));
		System.out.print("\n");
		System.out.print(isValidBST2(t1));
		System.out.print("\n");
		System.out.print(isValidBST3(t1));
	}
}
