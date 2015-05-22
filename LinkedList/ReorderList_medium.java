/*
Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
/*
4 STEP:
1. find the mid.
2. cut the list to two list.
3. REVERSE the right side. 注意模板
4. MERGE the two list.
*/
