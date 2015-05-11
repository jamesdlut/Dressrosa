/*
Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
*/
/*
1. Find the root node from the preorder.(it is the first node.)
2. Try to find the position of the root in the inorder. Then we can get the number of nodes in the left tree.
3. 递归调用，构造左子树和右子树。
*/
public class ConstructBT2Sol {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		
		return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	
	public static TreeNode dfs(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
		if (preL > preR) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preL]);
		int position = 0;
		for (; position <= inR; position++) {
			if (inorder[position] == preorder[preL]) {
				break;
			}
		}
		int leftNum = position - inL;
		
		root.left = dfs(preorder, inorder, preL + 1, preL + leftNum, inL, position - 1);
		root.right = dfs(preorder, inorder, preL + leftNum + 1, preR, position + 1, inR);
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
		int[] preorder = {1, 2, 3};
		int[] inorder = {2, 1, 3};
		print(buildTree(preorder, inorder));
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
