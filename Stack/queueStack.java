import java.util.Queue;
import java.util.LinkedList;

class QueueStack {
    // Declare queue as instance variable (class level)
    Queue<Integer> q;
   
    public QueueStack() {
        // Initialize the queue in constructor
        q = new LinkedList<>();
    }
    
    // Method to push element in the stack - O(n)
    public void push(int x) {
        int s = q.size();
        q.add(x);
        
        // Rotate the queue to bring new element to front
        for(int i = 0; i < s; i++){
            q.add(q.poll());
        }
    }

    // Remove and return top element - O(1)
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q.poll();
    }

    // Return top element without removing - O(1)
    public int top() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }
}
