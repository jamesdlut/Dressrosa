/*
Reverse Linked List II
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
public class reverseBetweenSol {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		if (m >= n) {
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for (int i = m; i > 1; i--) {
			pre = pre.next;
		}
		ListNode reverseTail = pre.next;
		pre.next = null;
		ListNode cur = reverseTail;
		for (int j = n - m + 1; j > 0; j--) {
			if (j == 1) {
				reverseTail.next = cur.next;
			}
			ListNode tmp = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = tmp;
		}
		return dummy.next;
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
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode tmp = n1;
		while (tmp != null) {
			System.out.print(tmp.val);
			tmp = tmp.next;
		}
		System.out.print("\n");
		ListNode rst = reverseBetween(n1, 2, 4);
		while (rst != null) {
			System.out.print(rst.val);
			rst = rst.next;
		}
	}
}
/*
 * output:
 * 12345
 * 14325
 */
