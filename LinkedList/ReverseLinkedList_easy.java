/*
Reverse Linked List
Reverse a singly linked list.
Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
public class reverseListSol {
	public static ListNode reverseList1(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}
	
	public static ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode rst = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return rst;
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
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		ListNode tmp = n1;
		while (tmp != null) {
			System.out.print(tmp.val);
			tmp = tmp.next;
		}
		System.out.print("\n");
		ListNode rst1 = n1;
		rst1 = reverseList1(rst1);
		while (rst1 != null) {
			System.out.print(rst1.val);
			rst1 = rst1.next;
		}
		System.out.print("\n");
		reverseList1(n3);
		ListNode rst2 = n1;
		rst2 = reverseList2(rst2);
		while (rst2 != null) {
			System.out.print(rst2.val);
			rst2 = rst2.next;
		}
	}
}
/*
 *outputs:
 *123
 *321
 *321
 */
