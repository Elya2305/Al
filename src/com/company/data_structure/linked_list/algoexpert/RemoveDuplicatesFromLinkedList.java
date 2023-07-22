package com.company.data_structure.linked_list.algoexpert;

public class RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {

        LinkedList test = new LinkedList(1);
        test.next = new LinkedList(1);
        test.next.next = new LinkedList(1);
        test.next.next.next = new LinkedList(4);
        test.next.next.next.next = new LinkedList(4);

        LinkedList newTest = removeDuplicatesFromLinkedList(test);
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        if (linkedList == null || linkedList.next == null) {
            return linkedList;
        }

        LinkedList current = linkedList;
        while (current != null) {
            if (current.next != null && current.next.value == current.value) {
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }

        return linkedList;
    }
}
