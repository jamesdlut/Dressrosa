/*
Sort List
Sort a linked list in O(n log n) time using constant space complexity.
*/
/*
our question is to sort whole list, different with binary search, which is to find a target in O(log n) time, 
T(n)
T(n / 2) T(n / 2)
T(n / 2^2) T(n / 2^2) T(n / 2^2) T(n / 2^2)
...
T(n / 2^logn) T(n / 2^logn) ... T(n / 2^logn)
thus, T(n) = T(n / 2) + O(1) = n * T(n / 2^logn) + O(1), that is, O(n log n)
为什么不用QuickSort? 因为对于链表随机访问太耗时，而heap sort不可行
*/
