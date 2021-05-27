package com.company.data_structure.linked_list;


import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesLinkedList<T> extends CustomLinkedList<T> {
    public static void main(String[] args) {
        RemoveDuplicatesLinkedList<Integer> list = new RemoveDuplicatesLinkedList<>(1);
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(3);
        list.addAtTail(4);
        list.removeDuplicates2();
        System.out.println(list);
    }

    public RemoveDuplicatesLinkedList(T value) {
        super(value);
    }

    /**
     * space - O(n)
     * time - O(n)
     */
    public void removeDuplicates() {
        Set<T> buffer = new HashSet<>();
        Node<T> start = head;
        Node<T> previous = null;
        while (start != null) {
            if (buffer.contains(start.value)) {
                previous.next = start.next;
            }
            buffer.add(start.value);
            previous = start;
            start = start.next;
        }
    }

    /**
     * space - O(1)
     * time - O(n^2)
     */
    public void removeDuplicates2() {
        Node<T> start = head;
        Node<T> previous = null;
        while (start != null) {
            boolean duplicate = checkValExists(start.next, start.value);
            if (duplicate) {
                if (previous != null) {
                    previous.next = start.next;
                } else {
                    head = head.next;
                }
            }
            previous = start;
            start = start.next;
        }
    }

    private boolean checkValExists(Node<T> node, T val) {
        while (node != null) {
            if (node.value == val) return true;
            node = node.next;
        }
        return false;
    }
}
