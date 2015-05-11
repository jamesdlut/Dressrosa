/*
Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.
For example,
Given
         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
*/
/*
only init the root tree, can connect the left tree or the right tree
*/
public class FlattenBTToLLSol {
	public static void flatten(TreeNode root) {
		dfs(root);
	}
	
	public static TreeNode dfs(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;
		root.right = null;
		TreeNode tail = root;
		if (left != null) {
			tail.right = left;
			tail = dfs(left);
		}
		if (right != null) {
			tail.right = right;
			tail = dfs(right);
		}
		return tail;
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
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t5;
		t2.left = t3;
		t2.right = t4;
		t5.right = t6;
		TreeNode rst = new TreeNode(0);
		flatten(t1);
		print(t1);
	}
	
	public static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.val + " ");
		print(root.right);
	}
}
