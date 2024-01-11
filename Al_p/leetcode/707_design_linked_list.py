class MyLinkedList:
    class Node:
        def __init__(self, val):
            self.val = val
            self.next = None
            self.prev = None

    def __init__(self):
        self.head = MyLinkedList.Node(0)
        self.tail = MyLinkedList.Node(0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, index: int) -> int:
        cur = self.head.next
        while index > 0 and cur:
            cur = cur.next
            index -= 1
        if index == 0 and cur and cur != self.tail:
            return cur.val
        return -1

    def addAtHead(self, val: int) -> None:
        node, next, prev = MyLinkedList.Node(val), self.head.next, self.head
        node.next, node.prev = next, prev
        next.prev, prev.next = node, node

    def addAtTail(self, val: int) -> None:
        node, next, prev = MyLinkedList.Node(val), self.tail, self.tail.prev
        node.next, node.prev = next, prev
        next.prev, prev.next = node, node

    def addAtIndex(self, index: int, val: int) -> None:
        cur = self.head.next
        while cur and index > 0:
            cur = cur.next
            index -= 1
        if cur and index == 0:
            node, next, prev = MyLinkedList.Node(val), cur, cur.prev
            node.next, node.prev = next, prev
            next.prev, prev.next = node, node

    def deleteAtIndex(self, index: int) -> None:
        cur = self.head.next
        while cur and index > 0:
            cur = cur.next
            index -= 1
        if cur and cur != self.tail and index == 0:
            next, prev = cur.next, cur.prev
            next.prev = prev
            prev.next = next
