/*
Rotate List
Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
/*
重点就是, 要先变成循环链表, end.next = head, 再执行ListNode headNew = pre.next, 否则, 当k = 0的时候, 会返回一个null指针, 因为pre是在最后的,
Rotate的精髓是旋转, 也就是说当n=0的时候, 应该什么也不做, 那么pre的下一个应该是头节点. 所以我们应该把end.next = head,
另外的做法, 就是把n = 0单独拿出来, 当n = 0直接returen head. 这样子就不用考虑这种特殊情况了. pre.next就一定不会是null.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = getLen(head);
        k = k % len;
        
        ListNode end = head;
        while (k > 0) {
            end = end.next;
            k--;
        }
        ListNode pre = head;
        while (end.next != null) {
            pre = pre.next;
            end = end.next;
        }
        end.next = head;
        ListNode headNew = pre.next;
        pre.next = null;
        return headNew;
    }
    
    public int getLen(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }
}
