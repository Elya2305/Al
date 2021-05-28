package com.company.data_structure.linked_list;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(1);

        a.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        b.next = node5;
        node5.next = node6;
        node6.next = node2;

        System.out.println(getIntersectionNode(a, b));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int size1 = getSize(headA);
        int size2 = getSize(headB);

        ListNode small = headA;
        ListNode big = headB;
        if (size1 > size2) {
            big = headA;
            small = headB;
        }

        int counter = 0;
        while (big != null && small != null) {
            if (Math.abs(size1 - size2) == counter) {
                if (big == small) {
                    return big;
                }
                big = big.next;
                small = small.next;
            } else {
                big = big.next;
                counter++;
            }
        }
        return null;
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
