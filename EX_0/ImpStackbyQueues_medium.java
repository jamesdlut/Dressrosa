/*
225 Implement Stack using Queues
Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
*/
class MyStack1 {
    Queue<Integer> q = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while (size > 1) {
            q.offer(q.poll());
            size--;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}

class MyStack2 {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        while (!q2.isEmpty()) {
            q1.offer(q2.peek());
            q2.poll();
        }
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.peek());
            q1.poll();
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q2.poll();
    }

    // Get the top element.
    public int top() {
        return q2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q2.isEmpty();
    }
}
