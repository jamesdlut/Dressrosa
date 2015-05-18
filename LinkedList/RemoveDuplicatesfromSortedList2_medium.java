/*
Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
public class deleteDuplicates2Sol {
	public static ListNode deleteDuplicates1(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		boolean del = false;
		while (cur != null) {
			if (cur.next != null 
					&& cur.next.next != null 
					&& cur.next.val == cur.next.next.val) {
				cur.next = cur.next.next;
				del = true;
			} else {
				if (del) {
					cur.next = cur.next.next;
					del = false;
				} else {
					cur = cur.next;
				}
			}
		}
		return dummy.next;
	}
	
	public static ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		
		while (cur != null) {
			if (cur.next != null 
					&& cur.next.next != null
					&& cur.next.val == cur.next.next.val) {
				int val = cur.next.val;
				while (cur.next != null && cur.next.val == val) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
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
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode tmp = new ListNode(0);
		tmp = n1;
		while (tmp != null) {
			System.out.print(tmp.val);
			tmp = tmp.next;
		}
		
		System.out.print("\n");
		
		ListNode rst1 = new ListNode(0);
		rst1 = n1;
		rst1 = deleteDuplicates1(rst1);
		while (rst1 != null) {
			System.out.print(rst1.val);
			rst1 = rst1.next;
		}
		
		System.out.print("\n");
		
		ListNode rst2 = new ListNode(0);
		rst2 = n1;
		rst2 = deleteDuplicates2(rst2);
		while (rst2 != null) {
			System.out.print(rst2.val);
			rst2 = rst2.next;
		}
	}
}
/*
 *outputs:
 *11123
 *23
 *23
 */
