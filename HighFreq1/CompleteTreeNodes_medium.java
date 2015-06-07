/*
Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
*/
/*
满二叉树(Full Binary Tree):
除最后一层无任何子节点外, 每一层上的所有结点都有两个子结点(最后一层上的无子结点的结点为叶子结点)
若深度为h,
第h层的结点数 = 2^(h - 1)
总结点数 = 2^h - 1 
完全二叉树(Complete Binary Tree):
若设二叉树的深度为h, 除第 h 层外, 其它各层(1 ~ h - 1) 的结点数都达到最大个数, 第 h 层所有的结点都连续集中在最左边
总结点数 [2^(h - 1), 2^h - 1)
e.g. 一棵完全二叉树有770个结点, 则它的叶子结点是259个
*/
/*
SOL 1
找到最底层, 然后二分搜索, 找到第一个空节点, 效率是O(logn * logn), 其中n是节点总数
(1 << (dep - 1)) - 1 + start means 倒数第二层以上的满二叉树总结点数 + 末层的叶子结点数
SOL 2
判断左子树最右结点的深度和右子树最右结点的深度,
如果相等, 右子树必为满二叉树, 直接公式算出右子树节点数, 递归左子树
如果不等, 左子树必为满二叉树, 直接公式算出左子树节点数, 递归右子树
time O(h^2)
*/
public class CompleteTreeSol {
	public static int countNodes1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		TreeNode pos = root;
		int dep = 0;
		while (pos != null) {
			pos = pos.left;
			dep++;
		}
		
		int start = 1;
		int end = (1 << (dep - 1));
		if (isFull(root, dep, end)) {
			return (1 << dep) - 1;
		}
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (isFull(root, dep, mid)) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return (1 << (dep - 1)) - 1 + start;
	}
	
    private static boolean isFull(TreeNode root, int dep, int start) {
    	TreeNode p = root;
    	int d = 0;
    	int half = 1 << (dep - 2);
    	while (p != null) {
    		if (start > half) {
    			p = p.right;
    			start = start - half;
    		} else {
    			p = p.left;
    		}
    		half = half >> 1;
    	    d++;
    	}
    	return d == dep;
    }
	
	public static int countNodes2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		TreeNode leftNode = root.left;
		int leftHeight = 0;
		while (leftNode != null) {
			leftHeight++;
			leftNode = leftNode.right;
		}
		
		TreeNode rightNode = root.right;
		int rightHeight = 0;
		while (rightNode != null) {
			rightHeight++;
			rightNode = rightNode.right;
		}
		
		if (leftHeight == rightHeight) {
			return 1 + countNodes2(root.left) + ((int)Math.pow(2, rightHeight) - 1);
		} else {
			return 1 + countNodes2(root.right) + ((int)Math.pow(2, leftHeight) - 1);
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
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;
		n5.left = n10;
		System.out.print(countNodes2(n1));
	}
}
