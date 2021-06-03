package com.company.data_structure.linked_list;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);

        l1.next = node1;
        node1.next = node2;
        l2.next = node3;
        node3.next = node4;

        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        if (l1.val > l2.val) {
            return mergeTwoLists(l2, l1);
        }
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            if (p2.val >= p1.val && (p1.next == null || p2.val <= p1.next.val)) {
                ListNode nextP2 = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p2 = nextP2;
            }
            p1 = p1.next;
        }
        return l1;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
