/*
Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
/*
这道题目在分布式系统中非常常见, 来自不同client的sorted list要在central server上面merge起来
SOL 1 Divide Conquer
先把k个list分成两半, 然后继续划分, 直到剩下两个list就合并起来, 合并时会用到Merge Two Sorted Lists这道题,
假设总共有k个list, 每个list的最大长度是n, 
T(k) = 2T(k / 2) + O(nk)
     = 2(2T(k / 2^2) + O(nk / 2)) + O(nk) = 4T(k / 4) + 2O(nk)
     = 4(2T(k / 2^3) + O(nk / 2^2)) + 2O(nk) = 8T(k / 2^3) + 3O(nk)
     ...
     = O(nklogk)
空间复杂度的话是递归栈的大小O(logk).
SOL 2, SOL 3,
维护一个大小为k的堆, 每次取堆顶的最小元素放到结果中, 然后读取该元素的下一个元素放入堆中, 重新维护好。因为每个链表是有序的, 每次又是去当前k个元素中最小的, 所以当所有链表都读完时结束, 这个时候所有元素按从小到大放在结果链表中。这个算法每个元素要读取一次, 即是k*n次, 然后每次读取元素要把新元素插入堆中要logk的复杂度, 所以总时间复杂度是O(nklogk)。空间复杂度是堆的大小, 即为O(k).
*/
