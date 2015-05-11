/*
Insert Node in Binary Search Tree
*/
public class InsertNodeInBSTSol {
	public static TreeNode insertNode1(TreeNode root, TreeNode node) {
		if (root == null) {
			root = node;
			return root;
		}
		
		TreeNode tmp = root;
		TreeNode last = null;
		while (tmp != null) {
			last = tmp;
			if (tmp.val > node.val) {
				tmp = tmp.left;
			} else {
				tmp = tmp.right;
			}
		}
		if (last != null) {
			if (last.val > node.val) {
				last.left = node;
			} else {
				last.right = node;
			}
		}
		return root;
	}
	// recursive
	public static TreeNode insertNode2(TreeNode root, TreeNode node) {
		if (root == null) {
			return node;
		}
		
		if (root.val > node.val) {
			root.left = insertNode2(root.left, node);
		} else {
			root.right = insertNode2(root.right, node);
		}
		return root;
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
		TreeNode t1 = new TreeNode(6);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(9);
		TreeNode t4 = new TreeNode(7);
		TreeNode t5 = new TreeNode(8);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		print(t1);
		System.out.print("\n");
		insertNode1(t1, t5);
		print(t1);
		System.out.print("\n");
		t4.right = null;
		print(t1);
		System.out.print("\n");
		insertNode2(t1, t5);
		print(t1);
	}
	
	public static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.val + " ");
		print(root.left);
		print(root.right);
	}
}
