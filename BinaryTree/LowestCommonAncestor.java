/*
Lowest Common Ancestor
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Example
        4
    /     \
  3         7
          /     \
        5         6
For 3 and 5, the LCA is 4.
For 5 and 6, the LCA is 7.
For 6 and 7, the LCA is 7.
*/
public class LCASol {
	public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode A, TreeNode B) {
		ArrayList<TreeNode> list1 = getPath2Root(A);
		ArrayList<TreeNode> list2 = getPath2Root(B);
		int i, j;
		for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (list1.get(i) != list2.get(j)) {
				return list1.get(i).parent;
			}
		}
		return list1.get(i + 1);
	}
	
	private static ArrayList<TreeNode> getPath2Root(TreeNode node) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		while (node != null) {
			list.add(node);
			node = node.parent;
		}
		return list;
	}
	// Divide & Conquer
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || root == A || root == B) {
			return root;
		}
		TreeNode left = lowestCommonAncestor2(root.left, A, B);
		TreeNode right = lowestCommonAncestor2(root.right, A, B);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String arg[]) {
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(7);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		t5.parent = t3;
		t4.parent = t3;
		t3.parent = t1;
		t2.parent = t1;
		t1.parent = null;
		TreeNode rst1 = lowestCommonAncestor1(t1, t2, t4);
		System.out.print(rst1.val);
		System.out.print("\n");
		TreeNode rst2 = lowestCommonAncestor1(t1, t4, t5);
		System.out.print(rst2.val);
		System.out.print("\n");
		TreeNode rst3 = lowestCommonAncestor1(t1, t5, t3);
		System.out.print(rst3.val);
		System.out.print("\n");
		TreeNode rst4 = lowestCommonAncestor2(t1, t2, t4);
		System.out.print(rst4.val);
		System.out.print("\n");
		TreeNode rst5 = lowestCommonAncestor2(t1, t4, t5);
		System.out.print(rst5.val);
		System.out.print("\n");
		TreeNode rst6 = lowestCommonAncestor2(t1, t5, t3);
		System.out.print(rst6.val);
 	}
}
