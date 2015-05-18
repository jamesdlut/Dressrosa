/*
Reverse Linked List
Reverse a singly linked list.
Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
/*
变的是结点之间的相互关系
指针A ＝ 指针B指向的结点，效果是拿指针A代替指针B指向指针B指向的结点
head.next指针所指的结点暂时被tmp指针指向
pre指针所指的结点，被head.next指针代替指向, (1st round: 1 -> null, 2nd round: 2 -> 1)
head指针所指的结点，被pre指针代替指向, (1st: 1结点从head变成了pre, null顺带变成pre.next, 2nd: 2结点从head变成了pre）
暂时被tmp指针指向的结点被head指针指向, (1st: 2从head.next变成head, 2nd: 3从head.next变成head)
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
