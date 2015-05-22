/*
Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
/*
4 STEP:
1. find the mid.
2. cut the list to two list.
3. REVERSE the right side. (模板)
4. MERGE the two list.
*/
public class reorderListSol {
	public static void reorderList(ListNode head) {
		if (head == null) {
			return;
		} else if (head.next == null) {
			return;
		}
		
		ListNode pre = findMidPre(head);
		ListNode right = pre.next;
		pre.next = null;
		
		right = reverse(right);
		merge(head, right);
	}
	
	public static ListNode findMidPre(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		while (head != null) {
			ListNode tmp = head.next;
			head.next = dummy.next;
			dummy.next = head;
			head = tmp;
		}
		return dummy.next;
	}
	
	public static void merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (head1 != null && head2 != null) {
			cur.next = head1;
			cur = cur.next;
			head1 = head1.next;
			cur.next = head2;
			cur = cur.next;
			head2 = head2.next;
		}
		if (head1 != null) {
			cur.next = head1;
		} else {
			cur.next = head2;
		}
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		reorderList(n1);
		while (n1 != null) {
			System.out.print(n1.val);
			n1 = n1.next;
		}
	}
}
