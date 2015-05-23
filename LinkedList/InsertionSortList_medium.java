/*
Insertion Sort List
Sort a linked list using insertion sort.
*/
/*
1. 从第一个元素开始, 该元素可以认为已经被排序
2. 取出下一个元素, 在已经排序的元素序列中从后向前扫描
3. 如果该元素(已排序)大于新元素, 将该元素移到下一位置
4. 重复步骤3, 直到找到已排序的元素小于或者等于新元素的位置
5. 将新元素插入到该位置后
6. 重复步骤2~5
time O(N^2), space O(1)
*/
/*
dummy -> null, 1 -> 2 -> 6 -> 5
pre            head
                    tmp
        pre -> 1 -> null ___________
                    head |          |
                    ...  v          |
        pre -> 1 -> 2 -> 6 -> null, 5 -> null
                                    head tmp
                    pre             ^
                    |_______________|    head
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val <= head.val) {
                pre = pre.next;
            }
            ListNode tmp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}
