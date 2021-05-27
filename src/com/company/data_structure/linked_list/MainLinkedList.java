package com.company.data_structure.linked_list;

public class MainLinkedList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>(10);
        linkedList.addAtTail(11);
        linkedList.addAtTail(12);
        linkedList.addAtHead(13);
        linkedList.deleteAtIndex(4);

        System.out.println(linkedList);
    }
}
