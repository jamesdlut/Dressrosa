/*
Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Follow up:
Can you solve it without using extra space?
*/
/*
现在有两个指针, 第一个指针, 每走一次走一步, 第二个指针每走一次走两步, 如果他们走了t次之后相遇在K点
指针一 走的路是 t = X + nY + K
指针二 走的路是 2t = X + mY + K 
把等式一代入到等式二中, 有
X + K = (m - 2n)Y
X和K的关系是基于Y互补的。等于说, 两个指针相遇以后, 再往下走X步就回到Cycle的起点了。这就可以有O(n)的实现了。
*/
public class detectCycleSol {
	public static ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode s = head;
		ListNode f = head;
		ListNode cross = null;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
			if (s == f) {
				cross = s;
				break;
			}
		}
		
		if (cross == null) {
			return null;
		}
		
		s = head;
		while (true) {
			if (s == f) {
				return s;
			}
			s = s.next;
			f = f.next;	
		}
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
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
		n4.next = n2;
		System.out.print(detectCycle(n1).val);
	}
}
