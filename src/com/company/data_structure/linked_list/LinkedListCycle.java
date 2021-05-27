package com.company.data_structure.linked_list;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle2(node1));
    }

    public static boolean hasCycle(ListNode head) {
        if (isNull(head)) return false;

        Map<ListNode, Boolean> buffer = new HashMap<>();
        buffer.put(head, true);
        head = head.next;
        while (head != null) {
            if (nonNull(buffer.get(head))) {
                return true;
            }
            buffer.put(head, true);
            head = head.next;
        }
        return false;
    }

    /**
     * memory - O(1). Wow.
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null) return false;

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        if (fastPointer == null) return false;

        while (fastPointer != null && fastPointer.next != null) {
            if (slowPointer == fastPointer) return true;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return false;
    }
}
