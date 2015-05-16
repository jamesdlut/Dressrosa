/*
Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/
public class deleteDuplicatesSol {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur != null) {
			if (cur.next != null && cur.next.next != null && cur.next.val == cur.next.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
		/*
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
		*/
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
		ListNode n3 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		ListNode tmp = new ListNode(0);
		tmp = n1;
		while (tmp != null) {
			System.out.print(tmp.val);
			tmp = tmp.next;
		}
		
		System.out.print("\n");
		
		ListNode rst = new ListNode(0);
		rst = deleteDuplicates(n1);
		while (rst != null) {
			System.out.print(rst.val);
			rst = rst.next;
		}	
	}
}
/*
 * output:
 * 112
 * 12
 */
