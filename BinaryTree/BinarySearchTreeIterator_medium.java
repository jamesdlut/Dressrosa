/*
Binary Search Tree Iterator 
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/
public class BSTIteratorSol {
	// recursion
	public static class BSTIterator1 {
		ArrayList<TreeNode> list;
		int index;
		
		public BSTIterator1(TreeNode root) {
			list = new ArrayList<TreeNode>();
			dfs(root, list);
			index = 0;
		}
		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			if (index < list.size()) {
				return true;
			}
			return false;
		}
		/** @return the next smallest number */
		public int next() {
			return list.get(index++).val;
		}
		
		public void dfs(TreeNode root, ArrayList<TreeNode> ret) {
			if (root == null) {
				return;
			}
			
			dfs(root.left, ret);
			ret.add(root);
			dfs(root.right, ret);
		}
	}
	// iteration
	public static class BSTIterator2 {
		ArrayList<TreeNode> list;
		int index;
		
		public BSTIterator2(TreeNode root) {
			list = new ArrayList<TreeNode>();
			iterator(root, list);
			index = 0;
		}
		
		public boolean hasNext() {
			if (index < list.size()) {
				return true;
			}
			return false;
		}
		
		public int next() {
			return list.get(index++).val;
		}
		
		public void iterator(TreeNode root, ArrayList<TreeNode> ret) {
			if (root == null) {
				return;
			}
			
			Stack<TreeNode> s = new Stack<TreeNode>();
			TreeNode cur = root;
			while (true) {
				while (cur != null) {
					s.push(cur);
					cur = cur.left;
				}
				if (s.isEmpty()) {
					break;
				}
				cur = s.pop();
				ret.add(cur);
				cur = cur.right;
			}
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
	
	public static TreeNode myTree() {
		TreeNode t1 = new TreeNode(6);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(9);
		TreeNode t4 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		return t1;
	}
	
	public static void main(String[] args) {
		BSTIterator1 i = new BSTIterator1(myTree());
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.print("\n");
		BSTIterator2 j = new BSTIterator2(myTree());
		while (j.hasNext()) {
			System.out.print(j.next() + " ");
		}
	}
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
/*
 *outputs:
 *5 6 7 9 
 *5 6 7 9 
 */
