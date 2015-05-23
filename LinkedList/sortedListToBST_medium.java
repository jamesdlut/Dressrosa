/*
Convert Sorted List to Binary Search Tree 
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/*
SOL 1
这个方法比较暴力, 每次遍历当前list, 找到中间的节点, 建立root, 分别使用递归建立左树以及右树, 并将左右树挂在root之下.
但这个算法会复杂度很高. 建立root次数为N, 每次遍历最多N次, 最坏为N平方(实际不会这么多)
SOL 2
类似SOL 3, Java不能使用指针, 所以我们自建一个自定义的类, 里面只有一个ListNode, 这样我们就能方便地修改入参了.
SOL 3
这个解法使用一个instance variable来记录当前正在操作的List Node. DFS本身的效果是, 从head直到尾部建树, 并且将currNode移动到size+1处. 这样可以在1次iterator我们的List后直接建立树.
这是一种Bottom-up的建树方法. 如果我们使用C++, 则可以将List Node直接做为入参来改变之而不需要使用实例变量.
问题是: 我们如果可以的话, 尽量不要使用实例变量, 因为它是各个Method共享的, 所以这个方法存在风险, 因为变量有可能被别的方法修改.
*/
public class sortedListToBSTSol {
	// SOL 1
	public static TreeNode sortedListToBST1(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = head;
		
		TreeNode root = null;
		if (head.next == null) {
			root = new TreeNode(head.val);
			root.left = null;
			root.right = null;
			return root;
		}
		
		while (fast != null && fast.next != null) {
			pre = slow;
			fast = fast.next.next;
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
	// SOL 2
	public static TreeNode sortedListToBST2(ListNode head) {
		if (head == null) {
			return null;
		}
		
		int size = 0;
		ListNode cur = head;
		while (cur != null) {
			size++;
			cur = cur.next;
		}
		
		CurNode curNode = new CurNode(head);
		return helper2(curNode, size);
	}
	
	public static class CurNode {
		ListNode node;
		CurNode(ListNode node) {
			this.node = node;
		}
	}
	
	public static TreeNode helper2(CurNode cur, int size) {
		if (size <= 0) {
			return null;
		}
		TreeNode left = helper2(cur, size / 2);
		TreeNode root = new TreeNode(cur.node.val);
		cur.node = cur.node.next;
		TreeNode right = helper2(cur, size - 1 - size / 2);
		root.left = left;
		root.right = right;
		return root;
	}
	// SOL 3
	public static TreeNode sortedListToBST3(ListNode head) {
		int size;
		cur = head;
		size = getListLength(head);
		return helper3(size);
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
	
	public static TreeNode helper3(int size) {
		if (size <= 0) {
			return null;
		}
		
		TreeNode left = helper3(size / 2);
		TreeNode root = new TreeNode(cur.val);
		cur = cur.next;
		TreeNode right = helper3(size - 1 - size / 2);
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
}
