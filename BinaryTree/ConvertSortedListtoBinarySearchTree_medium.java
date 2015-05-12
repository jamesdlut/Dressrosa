/*
Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/*
method 1
每次遍历当前list, 找到中间的节点, 建立root, 分别使用递归建立左树以及右树, 并将左右树挂在root之下,
建立root次数为N, 每次遍历最多N次, so the worst case is N^2
*/
public class sortedListToBSTSol {
	// method 1
	public static TreeNode sortedListToBST1(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = head;
		if (head == null) {
			return null;
		}
		TreeNode root = null;
		if (head.next == null) {
			root = new TreeNode(head.val);
			root.left = null;
			root.right = null;
			return root;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		pre.next = null;
		TreeNode left = sortedListToBST1(head);
		TreeNode right = sortedListToBST1(slow.next);
		root = new TreeNode(slow.val);
		root.left = left;
		root.right = right;
		return root;
	}
	// Bottom-up
	public static TreeNode sortedListToBST2(ListNode head) {
		int size;
		cur = head;
		size = getListLength(head);
		return helper2(size);
	}
	
	private static ListNode cur;
	
	private static int getListLength(ListNode head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
		return size;
	}
	
	public static TreeNode helper2(int size) {
		if (size <= 0) {
			return null;
		}
		
		TreeNode left = helper2(size / 2);
		TreeNode root = new TreeNode(cur.val);
		cur = cur.next;
		TreeNode right = helper2(size - 1 - size / 2);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
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
	
	public static ListNode myList() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		return n1;
	}
	
	public static void main(String[] args) {
		print(sortedListToBST1(myList()));
		System.out.print("\n");
		print(sortedListToBST2(myList()));
	}
	
	public static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		
		print(root.left);
		System.out.print(root.val + " ");
		print(root.right);
	}
}
