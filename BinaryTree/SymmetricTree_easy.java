/*
Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/
public class SymmetricTreeSol {
	// recursion
	public static boolean isSymmetric1(TreeNode root) {
		return isMirror1(root.left, root.right);
	}
	
	public static boolean isMirror1(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}
		return root1.val == root2.val && isMirror1(root1.left, root2.right) && isMirror1(root1.right, root2.left);
	}
	// iteration
	public static boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return isMirror2(root.left, root.right);
	}
	
	public static boolean isMirror2(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		while (!s1.isEmpty() && !s2.isEmpty()) {
			TreeNode cur1 = s1.pop();
			TreeNode cur2 = s2.pop();
			if (cur1.val != cur2.val) {
				return false;
			}
			if (cur1.left != null && cur2.right != null) {
				s1.push(cur1.left);
				s2.push(cur2.right);
			} else if (!(cur1.left == null && cur2.right == null)) {
				return false;
			}
			if (cur1.right != null && cur2.left != null) {
				s1.push(cur1.right);
				s2.push(cur2.left);
			} else if (!(cur1.right == null && cur2.left == null)) {
				return false;
			}
		}
		return true;
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
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		return t1;
	}
	
	public static void main(String[] args) {
		System.out.print(isSymmetric1(myTree()));
		System.out.print("\n");
		System.out.print(isSymmetric2(myTree()));
	}
}
