package com.company.data_structure.queue_stack;

import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> temporary;
    private final Stack<Integer> main;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        temporary = new Stack<>();
        main = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        main.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!main.empty()) {
            temporary.push(main.pop());
        }
        int result = temporary.pop();
        while (!temporary.empty()) {
            main.push(temporary.pop());
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!main.empty()) {
            temporary.push(main.pop());
        }
        int result = temporary.peek();
        while (!temporary.empty()) {
            main.push(temporary.pop());
        }
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return main.empty();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "temporary=" + temporary +
                ", main=" + main +
                '}';
    }
}
