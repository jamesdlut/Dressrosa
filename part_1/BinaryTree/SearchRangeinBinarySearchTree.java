/*
Search Range in Binary Search Tree
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
Example
For example, if k1 = 10 and k2 = 22, then your function should print 12, 20 and 22.
          20

       /        \

    8           22

  /     \

4       12
*/
public class SearchRangeBSTSol {
	private static ArrayList<Integer> rst;
	
	public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        rst = new ArrayList<Integer>();
        helper(root, k1, k2);
        return rst;
    }
	
	private static void helper(TreeNode root, int k1, int k2) {
		if (root == null) {
			return;
		}
		
		if (root.val > k1) {
			helper(root.left, k1, k2);
		}
		if (root.val >= k1 && root.val <= k2) {
			rst.add(root.val);
		}
		if (root.val < k2) {
			helper(root.right, k1, k2);
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
	
	private static TreeNode myTree() {
		TreeNode t1 = new TreeNode(20);
		TreeNode t2 = new TreeNode(8);
		TreeNode t3 = new TreeNode(22);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(12);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		return t1;
	}
	
	public static void main(String[] args) {
		searchRange(myTree(), 12, 22);
		System.out.print(rst);
	}
}
