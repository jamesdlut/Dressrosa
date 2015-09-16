/*
Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/
/*
SOL 1
1. 得到2个链条的长度.
2. 将长的链条向前移动差值(len1 - len2)
3. 两个指针一起前进, 遇到相同的即是交点, 如果没找到, 返回null.
相当直观的解法. 空间复杂度O(1), 时间复杂度O(m+n)
*/
public class getIntersectionNodeSol {
	// SOL 1
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		int len1 = getLen(headA);
		int len2 = getLen(headB);
		int cnt = Math.abs(len1 - len2);
		
		if (len1 > len2) {
			while (cnt > 0) {
				headA = headA.next;
				cnt--;
			}
		} else {
			while (cnt > 0) {
				headB = headB.next;
				cnt--;
			}
		}
		
		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
	
	public static int getLen(ListNode head) {
		int cnt = 0;
		while (head != null) {
			cnt++;
			head = head.next;
		}
		return cnt;
	}
	// SOL 2
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		ListNode pA = headA;
		ListNode pB = headB;
		ListNode tailA = null;
		ListNode tailB = null;
		while (true) {
			if (pA == null) {
				pA = headB;
			}
			if (pB == null) {
				pB = headA;
			}
			if (pA.next == null) {
				tailA = pA;
			}
			if (pB.next == null) {
				tailB = pB;
			}
			if (tailA != null && tailB != null && tailA != tailB) {
				return null;
			}
			if (pA == pB) {
				return pA;
			}
			pA = pA.next;
			pB = pB.next;
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
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n4;
		n4.next = n5;
		n5.next = null;
		n3.next = n4;
		System.out.print(getIntersectionNode2(n1, n3).val);
	}
}
