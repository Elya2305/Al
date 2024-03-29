package com.company.data_structure.linked_list;


/**
 * An example of incorrect linked list. You can't reassign 'this'
 * <p>
 * https://stackoverflow.com/questions/23021377/reassign-this-in-java-class
 */
class BadLinkedList {
    private BadLinkedList next;
    private final int val;

    /**
     * Initialize your data structure here.
     */
    public BadLinkedList(int val) {
        this.val = val;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) return -1;
        BadLinkedList curr = this;
        int start = 0;
        while (start < index && curr != null) {
            curr = curr.next;
            start++;
        }
        if (start == index && curr != null) {
            return curr.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) { //?
        BadLinkedList newVal = new BadLinkedList(val);
        BadLinkedList curr = this;

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        BadLinkedList newVal = new BadLinkedList(val);
        BadLinkedList nextVal = this;
        while (nextVal.next != null) {
            nextVal = nextVal.next;
        }
        nextVal.next = newVal;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        }
        if (index < 0) return;
        BadLinkedList newVal = new BadLinkedList(val);
        BadLinkedList curr = this;
        int start = 1;
        while (start < index && curr != null) {
            curr = curr.next;
            start++;
        }
        if (start != index || curr == null) return;
        BadLinkedList temp = curr.next;
        curr.next = newVal;
        newVal.next = temp;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0) return;
        int start = 0;

        BadLinkedList toDelete = this;
        BadLinkedList prev = null;
        while (start < index && toDelete != null) {
            prev = toDelete;
            toDelete = toDelete.next;
            start++;
        }
        if (prev == null) {
//            deleteFirst();
            return;
        }

        prev.next = toDelete.next;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[" + val);
        BadLinkedList next = this.next;
        while (next != null) {
            res.append(", ").append(next.val);
            next = next.next;
        }
        res.append("]");
        return res.toString();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
