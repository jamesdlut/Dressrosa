/*
Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
/*
Very very trick. we should use EQUALS here instead of "=="
push
6 
1 
7 1
4 4 
pop 6 1 1 7 4 4
notice here pop method has no return value, void.
pop section: 概念上, 用了两个stack去实现minStack, 实际宏观功能上, 还是视为一个stack
*/
public class MaxStackSol {
	public static class MaxStack {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		public void push(int x) {
			stack1.push(x);
			if (stack2.isEmpty() || x <= stack2.peek()) {
				stack2.push(x);
			}
		}
		
		public void pop() {
			if (stack1.peek().equals(stack2.peek())) {
				stack2.pop();
			}
			stack1.pop();
		}
		
		public int top() {
			return stack1.peek();
		}
		
		public int getMin() {
			return stack2.peek();
		}
	}
	
	public static void main(String[] args) {
		MaxStack s = new MaxStack();
		s.push(4);
		s.push(7);
		s.push(1);
		s.push(6);
		System.out.print(s.getMin());
	}
}
