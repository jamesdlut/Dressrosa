/*
by yiming
Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
/*
SOL 1
使用改进的Quicksort partition, O(n) time, O(1) space
note: quickselect worst case O(n^2) best/average case O(n)
Choose the last one as the pivot
left: the first one which is bigger than pivot. Change pivot.
*/
