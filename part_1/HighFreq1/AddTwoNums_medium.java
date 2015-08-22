/*
Add Two Numbers
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
public class AddTwoSol {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;
		while (l1 != null || l2 != null || carry == 1) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			ListNode cur = new ListNode(sum % 10);
			tail.next = cur;
			tail = tail.next;
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
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		ListNode rst = addTwoNumbers(n1, n4);
		while (rst != null) {
			System.out.print(rst.val);
			rst = rst.next;
		}
	}
}
