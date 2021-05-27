package com.company.data_structure.linked_list;

public class CustomLinkedList<T> {
    protected Node<T> head;
    protected int size;

    static class Node<T> {
        protected Node<T> next;
        protected final T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public CustomLinkedList(T value) {
        this.head = new Node<>(value);
        this.size = 1;
    }

    public void addAtTail(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }

    public void addAtHead(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        this.head = newNode;
        size++;
    }

    public void insert(T value, int index) {
        checkIndexForInsert(index);

        if (index == 0) {
            addAtHead(value);
            return;
        }
        if (index == size) {
            addAtTail(value);
            return;
        }

        Node<T> newVal = new Node<>(value);
        Node<T> currVal = head;
        int start = 0;

        while (start + 1 < index) {
            currVal = currVal.next;
            start++;
        }
        newVal.next = currVal.next;
        currVal.next = newVal;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        int start = 0;
        Node<T> curr = head;
        while (start < index && curr.next != null) {
            curr = curr.next;
            start++;
        }
        return curr.value;
    }

    public void deleteAtIndex(int index) {
        checkIndex(index);
        int start = 0;
        Node<T> currVal = head;
        Node<T> prev = null;

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

    private void checkIndexForInsert(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds of length " + size);
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds of length " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> temp = head;
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
