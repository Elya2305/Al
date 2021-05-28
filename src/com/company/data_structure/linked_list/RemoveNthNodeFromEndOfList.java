package com.company.data_structure.linked_list;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(removeNthFromEnd(node1, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        int indexToRemove = size - n;

        ListNode curr = head;
        ListNode prev = null;
        while (indexToRemove > 0) {
            prev = curr;
            curr = curr.next;
            indexToRemove--;
        }
        curr.next = curr.next.next;
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = curr.next;
        }
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    private static int getSize(ListNode headA) {
        int size = 0;
        while (headA != null) {
            headA = headA.next;
            size++;
        }
        return size;
    }
}
