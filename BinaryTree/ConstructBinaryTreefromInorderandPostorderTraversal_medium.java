/*
Construct Binary Tree from Inorder and Postorder Traversal
Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
*/
/*
使用递归的思想，先找到根节点（它就是post order最后一个），然后再在inorder中找到它，以确定左子树的node个数
然后分别确定左子树右子树的左右边界，就是左右子树的划分关系
e.g.
{4, 5, 2, 7, 8, 1, 3}
inorder: 7 5 8 | 4 | 1 2 3
postorder: 7 8 5 | 1 3 2 | 4
*/
public class ConstructBT1Sol {
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		
		return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}
	
	public static TreeNode dfs(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
		if (inL > inR) {
			return null;
		}
		// create the root node
		TreeNode root = new TreeNode(postorder[postR]);
		// find the position of the root node in the inorder
		int pos = 0;
		for (; pos <= inR; pos++) {
			if (inorder[pos] == postorder[postR]) {
				break;
			}
		}
		int leftNum = pos - inL;
		
		root.left = dfs(inorder, postorder, inL, pos - 1, postL, postL + leftNum - 1);
		root.right = dfs(inorder, postorder, pos + 1, inR, postL + leftNum, postR - 1);
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
		int[] inorder = {2, 1, 3};
		int[] postorder = {2, 3, 1};
		
		print(buildTree(inorder, postorder));
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
