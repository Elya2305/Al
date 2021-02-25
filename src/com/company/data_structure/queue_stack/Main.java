package com.company.data_structure.queue_stack;

public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        myQueue.pop();
        myQueue.pop();

        System.out.println(myQueue);

    }
}
