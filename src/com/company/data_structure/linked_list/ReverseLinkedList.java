package com.company.data_structure.linked_list;

// not solved
public class ReverseLinkedList {
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

        System.out.println(reverseList(node1));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        // the reverse of tail node is tail node, reverse of empty node is empty node
        if (head == null || head.next == null) return head;
        // call reverseList() on the next node to "magically" get back the reversed list from next node onwards
        ListNode p = reverseList2(head.next);
        // Here onwards we try to define the "magic"
        // In the last step of recursion, p = last node e.g. 4->null for input(1->2->3->4->null). head = 3->4-> null
        // This also mean head.next is now pointing last node of the reversed list p. (head: 3->4->null, p: 4->null)
        // head.next is actually pointing to the last node of the reversed list p.
        //
        // This is convenient because the recursion can just return p so that we can get the head of the reversed list
        // as we bubble up the recursion stack. We don't need to return a pointer to the last node of the reversed list, p
        // to continue building the list. It is accessible by head.next

        // We then proceed to point the last of p to head. Remember that head.next is the last of p. p is now 4->3
        head.next.next = head; // p is now 4->3

        // But we are not done because head.next still points to 4, the last of p. This is the cycle that is mentioned in the solution
        // We point it to null. Why null? Because head is now the last node of the reversed list p and the last node should point
        // its next to null
        head.next = null;  //

        // As mentioned early, we can pass the head of the reversed list to the previous node in the original list.
        // In our example, the previous node will be head = 2->3. p is now 4->3->null
        return p;
    }
}
