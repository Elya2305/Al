package com.company.data_structure.linked_list;

public class MyLinkedListDesignedForLeetcode {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.get(1));
    }
}

class MyLinkedList {
    protected Node<Integer> head;
    protected int size;

    static class Node<T> {
        protected Node<T> next;
        protected final T value;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (!checkIndex(index)) return -1;

        int start = 0;
        Node<Integer> curr = head;
        while (start < index && curr.next != null) {
            curr = curr.next;
            start++;
        }
        return curr.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node<Integer> newNode = new Node<>(val);
        newNode.next = head;
        this.head = newNode;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node<Integer> newNode = new Node<>(val);
        Node<Integer> curr = head;
        if (curr == null) {
            this.head = newNode;
        } else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(!checkIndexForInsert(index)) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node<Integer> newVal = new Node<>(val);
        Node<Integer> currVal = head;
        int start = 0;

        while (start + 1 < index) {
            currVal = currVal.next;
            start++;
        }
        newVal.next = currVal.next;
        currVal.next = newVal;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (!checkIndex(index)) return;

        int start = 0;
        Node<Integer> currVal = head;
        Node<Integer> prev = null;

        while (start < index) {
            prev = currVal;
            currVal = currVal.next;
            start++;
        }
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = currVal.next;
        }
        size--;
    }

    private boolean checkIndexForInsert(int index) {
        return index <= size && index >= 0;
    }

    private boolean checkIndex(int index) {
        return index < size && index >= 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<Integer> temp = head;
        while (temp != null) {
            if (sb.length() != 1) {
                sb.append(" ");
            }
            sb.append(temp.value).append(",");
            temp = temp.next;
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
