/*
Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.
For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
/*
使用快慢指针, 快指针先行移动N步. 用慢指针指向要移除的Node的前一个Node.
*/
