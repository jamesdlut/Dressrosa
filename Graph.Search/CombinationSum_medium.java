/*
Combination Sum
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
/*
经典递归模板.
i的起始值是跟排列的最主要区别. 因为与顺序无关, 所以我们必须只能是升序, 也就是说下一个取值只能是i本身或是i的下一个.
但是排列的话, 可以再取前同的. 1, 2 与2 1是不同的排列, 但是同一个组合.
*/
