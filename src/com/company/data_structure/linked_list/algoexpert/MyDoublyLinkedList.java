package com.company.data_structure.linked_list.algoexpert;

import java.util.ArrayList;
import java.util.List;

class Program {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head == node) return;

            // if list is empty
            if (head == null) {
                head = node;
                tail = node;
                return;
            }

            // if element is the last
            if (tail == node) {
                node.prev.next = null;
                node.prev = null;

                node.next = head;
                head.prev = node;

                head = node;
                return;
            }

            // if element is not present in the list
            if (node.next == null && node.prev == null) {
                node.next = head;
                head.prev = node;
                head = node;
                return;
            }

            // if element is in the center
            Node pastNext = node.next;
            Node pastHead = this.head;
            Node pastPrev = node.prev;

            node.next = pastHead;
            pastHead.prev = node;

            node.prev = null;

            pastPrev.next = pastNext;
            pastNext.prev = pastPrev;

            head = node;
        }

        public void setTail(Node node) {
            if (node == tail) return;

            // if list empty
            if (this.tail == null) {
                this.tail = node;
                this.head = node;
                return;
            }

            // if element is not present in the list
            if (node.next == null && node.prev == null) {
                tail.next = node;
                node.prev = tail;
                tail = node;
                return;
            }

            // if element is the first
            if (node == head) {
                tail.next = node;
                node.prev = tail;
                tail = node;
                head = head.next;
                head.prev = null;
                tail.next = null;
                return;

            }

            // if element is in the center
            Node pastNext = node.next;
            Node pastTail = this.tail;
            Node pastPrev = node.prev;

            node.prev = pastTail;
            pastTail.next = node;

            node.next = null;

            pastPrev.next = pastNext;
            pastNext.prev = pastPrev;

            tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            Node curr = head;
            while (curr != node && curr != null) {
                curr = curr.next;
            }
            if (curr == null) return;

            if (curr == head) {
                setHead(nodeToInsert);
                return;
            }
            insertAfterNode(curr.prev, nodeToInsert);
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            Node curr = head;
            while (curr != node && curr != null) {
                curr = curr.next;
            }
            if (curr == null) return;

            if (curr == tail) {
                setTail(nodeToInsert);
                return;
            }
            insertAfterNode(curr, nodeToInsert);
        }

        private void insertAfterNode(Node curr, Node nodeToInsert) {
//            if (nodeToInsert.next == null && nodeToInsert.prev == null) {
                Node temp = curr.next;
                curr.next = nodeToInsert;
                nodeToInsert.prev = curr;
                nodeToInsert.next = temp;
                temp.prev = nodeToInsert;
//            }


        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            int index = 1;
            Node curr = head;
            while (curr != null && index != position) {
                curr = curr.next;
                index++;
            }
            if (curr == null) {
                setTail(nodeToInsert);
                return;
            }
            if (index == 1) {
                setHead(nodeToInsert);
                return;
            }
            insertAfterNode(curr.prev, nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            if (head == null) {
                return;
            }
            Node curr = head;
            while (curr != null) {
                if (curr.value == value) {
                    removeNode(curr);
                }
                curr = curr.next;
            }
        }

        public void remove(Node node) {
            if (head == null) {
                return;
            }
            Node curr = head;
            while (curr != node && curr != null) {
                curr = curr.next;
            }
            if (curr == null) return;
            removeNode(curr);
        }

        private void removeNode(Node node) {
            if (node == head) {
                head = head.next;
                head.prev = null;
                return;
            }
            if (node == tail) {
                tail = node.prev;
                tail.next = null;
                return;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public boolean containsNodeWithValue(int value) {
            if (head == null) return false;
            Node curr = head;
            while (curr != null && curr.value != value) {
                curr = curr.next;
            }
            return curr != null;
        }

        private void bindNodes(Program.Node nodeOne, Program.Node nodeTwo) {
            if (nodeOne == null || nodeTwo == null) return;
            nodeOne.next = nodeTwo;
            nodeTwo.prev = nodeOne;
        }

        @Override
        public String toString() {
            StringBuilder string = new StringBuilder("[");
            Node temp = this.head;
            while (temp != null) {
                string.append(" ").append(temp.value).append(",");
                temp = temp.next;
            }
            string.append(" ]");
            return string.toString();
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

public class MyDoublyLinkedList {
    public static void main(String[] args) {

        ProgramTest test = new ProgramTest();
        test.TestCase1();
//        Program.DoublyLinkedList list = new Program.DoublyLinkedList();
//        Program.Node two = new Program.Node(2);
//
//        list.setHead(new Program.Node(1));
//        list.setHead(two);
//        list.setHead(new Program.Node(3));
//
//        System.out.println(list);
//
//        list.setHead(two);
//        System.out.println(list);
    }
}

class ProgramTest {
    private List<Integer> getNodeValuesHeadToTail(Program.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        Program.Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(Program.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        Program.Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void bindNodes(Program.Node nodeOne, Program.Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public void TestCase1() {
        Program.DoublyLinkedList linkedList = new Program.DoublyLinkedList();
        Program.Node one = new Program.Node(1);
        Program.Node two = new Program.Node(2);
        Program.Node three = new Program.Node(3);
        Program.Node three2 = new Program.Node(3);
        Program.Node three3 = new Program.Node(3);
        Program.Node four = new Program.Node(4);
        Program.Node five = new Program.Node(5);
        Program.Node six = new Program.Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;

        System.out.println(linkedList);
        linkedList.insertAfter(two, one);
        System.out.println(linkedList);
//        linkedList.insertBefore();

//        linkedList.setTail(three);
//        System.out.println(linkedList);

//        linkedList.setHead(four);
//        Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 3, 5}));
//        Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{5, 3, 2, 1, 4}));
//
//        linkedList.setTail(six);
//        Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 3, 5, 6}));
//        Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 5, 3, 2, 1, 4}));
//
//        linkedList.insertBefore(six, three);
//        Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 5, 3, 6}));
//        Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 3, 5, 2, 1, 4}));
//
//        linkedList.insertAfter(six, three2);
//        Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 5, 3, 6, 3}));
//        Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 6, 3, 5, 2, 1, 4}));
//
//        linkedList.insertAtPosition(1, three3);
//        Utils.assertTrue(
//                compare(getNodeValuesHeadToTail(linkedList), new int[]{3, 4, 1, 2, 5, 3, 6, 3}));
//        Utils.assertTrue(
//                compare(getNodeValuesTailToHead(linkedList), new int[]{3, 6, 3, 5, 2, 1, 4, 3}));
//
//        linkedList.removeNodesWithValue(3);
//        Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 5, 6}));
//        Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 5, 2, 1, 4}));
//
//        linkedList.remove(two);
//        Utils.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 5, 6}));
//        Utils.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 5, 1, 4}));
//
//        Utils.assertTrue(linkedList.containsNodeWithValue(5));
    }
}


class Utils {
    public static void assertTrue(boolean bool) {
        if (!bool) {
            throw new RuntimeException("AAAAAAA");
        }
    }
}