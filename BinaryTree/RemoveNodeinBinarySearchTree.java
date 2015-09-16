/*
Remove Node in Binary Search Tree
Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
Example
Given binary search tree:
          5

       /    \

    3          6

 /    \

2       4
Remove 3, you can either return:
          5

       /    \

    2          6

      \

         4
or :
          5

       /    \

    4          6

 /   

2
*/
public class RemoveNodeBSTSol {
	public static TreeNode removeNode(TreeNode root, int value) {
		TreeNode dummy = new TreeNode(0);
		dummy.left = root;
		TreeNode parent = findNode(dummy, root, value);
		TreeNode node;
		if (parent.left != null && parent.left.val == value) {
			node = parent.left;
		} else if (parent.right != null && parent.right.val == value) {
			node = parent.right;
		} else {
			return dummy.left;
		}
		deleteNode(parent, node);
		return dummy.left;
	}
	
	private static TreeNode findNode(TreeNode parent, TreeNode node, int value) {
		if (node == null) {
			return parent;
		}
		if (node.val == value) {
			return parent;
		}
		if (value < node.val) {
			return findNode(node, node.left, value);
		} else {
			return findNode(node, node.right, value);
		}
	}
	
	private static void deleteNode(TreeNode parent, TreeNode node) {
		if (node.right == null) {
			if (parent.left == node) {
				parent.left = node.left;
			} else {
				parent.right = node.left;
			}
		} else {
			TreeNode tmp = node.right;
			TreeNode father = node;
			while (tmp.left != null) {
				father = tmp;
				tmp = tmp.left;
			}
			if (father.left == tmp) {
				father.left = tmp.right;
			} else {
				father.right = tmp.right;
			}
			if (parent.left == node) {
				parent.left = tmp;
			} else {
				parent.right = tmp;
			}
			tmp.left = node.left;
			tmp.right = node.right;
		}
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
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		print(t1);
		System.out.print("\n");
		removeNode(t1, 3);
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
/*
 *outputs:
 *5 3 2 4 6 
 *5 4 2 6
 */
