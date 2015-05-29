/*
Subsets
Given a set of distinct integers, nums, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
/*
Basically our algorithm can't be faster than O(2^n) since we need to go through all possible combinations.
SOL 1 Recurstion
SOL 3 The idea is that all the numbers from 0 to 2^n are represented by unique bit strings of n bit width that can be translated into a subset.
e.g.
Nr Bits Combination
0  000  {}
1  001  {1}
2  010  {2}
3  011  {1, 2}
4  100  {3}
5  101  {1, 3}
6  110  {2, 3}
7  111  {1, 2, 3]
int numberOfTrailingZeros(int i) 给定一个int类型数据, 返回这个数据的二进制串中从最右边算起连续的“0”的总数量, 因为int类型的数据长度为32所以高位不足的地方会以“0”填充.
1的二进制表示为: 1最右边开始数起连续的0的个数为: 0  
2的二进制表示为: 10最右边开始数起连续的0的个数为: 1
*/
