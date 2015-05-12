/*
Unique Binary Search Trees
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
/*
/*
The case for 3 elements example
Count[3] = Count[0] * Count[2] (1 as root)
              + Count[1] * Count[1] (2 as root)
              + Count[2] * Count[0] (3 as root)
Therefore, we can get the equation:
Count[i] = ∑ Count[0...k] * [k+1...i] 0 <= k < i - 1  
*/
