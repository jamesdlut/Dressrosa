/*
Partition List 
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
public class partitionListSol {
	public static ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		
		ListNode dummyLeft = new ListNode(0);
		ListNode dummyRight = new ListNode(0);
		ListNode left = dummyLeft;
		ListNode right = dummyRight;
		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = head;
			} else {
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		right.next = null;
		left.next = dummyRight.next;
		return dummyLeft.next;	
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
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		ListNode rst = partition(n1, 3);
		while (rst != null) {
			System.out.print(rst.val);
			rst = rst.next;
		}	
	}
}
