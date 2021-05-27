package com.company.data_structure.linked_list;

public class ReturnKthToLastLinkedList<T> extends CustomLinkedList<T> {
    public static void main(String[] args) {
        ReturnKthToLastLinkedList<Integer> list = new ReturnKthToLastLinkedList<>(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.printFromKthToLast(3);
    }
    public ReturnKthToLastLinkedList(T value) {
        super(value);
    }

    public void printFromKthToLast(int k) {
        Node<T> curr = head;
        int index = 1;
        while (index++ <= k) {
            curr = curr.next;
        }
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
}
