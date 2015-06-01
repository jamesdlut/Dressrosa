/*
Implement Queue by Two Stacks
As the title described, you should only use two stacks to implement a queue's actions.
The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
Both pop and top methods should return the value of first element.
Example
For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2
Challenge
implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.
*/
/*
每个数进出Stack1和Stack2各1次, 所以两个操作的均摊复杂度均为O(1)
*/
public class Solution {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}
