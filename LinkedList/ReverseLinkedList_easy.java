/*
Reverse Linked List
Reverse a singly linked list.
Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
/*
变的是结点之间的相互关系
注意"指代某结点"和"next指针指向某结点"之间的区别,
ListNode A ＝ ListNode B, 效果是用ListNode A指代ListNode B代表的结点, 方便指针滑动, ListNode B不动, 滑动ListNode A进行具体操作,
ListNode tmp = head.next, 用ListNode tmp指代ListNode head的next指针指向的结点,
head.next = pre, 用ListNode head的next指针指向pre代表的结点, 
pre = head, 用ListNode pre指代ListNode head代表的结点, 
head = tmp, 用ListNode head指代ListNode tmp代表的结点,
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
