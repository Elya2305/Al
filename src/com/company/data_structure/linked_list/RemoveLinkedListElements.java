package com.company.data_structure.linked_list;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);

        node1.next = node2;
        node2.next = node4;
//        node3.next = node4;
        node4.next = node5;

        System.out.println(removeElements2(node1, 1));

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return head.val == val ? head.next : head;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
