/*
Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
/*
2. tmp 表示当前计算的一套完整的括号集的长度. 完整的指的是消耗掉栈中所有的'('.
3. sum 表示数个完整的括号集的总长.
例子:
有一套完整的括号集，可以加到前面的一整套括号集上
() (()())
 1    2  第二套括号集可以加过来
4. 不完整的括号集:
这种情况也是需要计算的. 也可能是一个未完成的括号集, 比如:
() (()() 在这里 ()() 是一个未完成的括号集, 可以独立出来计算, 作为阶段性的结果
5. 栈为空时, 栈中没有'(',出现')', 则必须重置计算
*/
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    sum = 0;
                } else {
                    int tmp = i - stack.pop() + 1;
                    if (stack.isEmpty()) {
                        sum += tmp;
                        max = Math.max(max, sum);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
