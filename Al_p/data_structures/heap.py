"""
Binary Heap - Complete Binary Tree
(Complete BT: every level is completely filled except maybe the last one;
heap property: node <= children -- MinHeap or node >= children -- MaxHeap)

Node: i,
Parent: (i - 1)/2
Left child: 2i + 1
Right child: 2i + 2
"""


class MinHeap:
    def __init__(self):
        self.heap = []

    def insert(self, val):
        self.heap.append(val)
        self._sift_up(len(self.heap) - 1)

    def _sift_up(self, i):
        parent_i = (i - 1) // 2
        while 0 <= parent_i < len(self.heap) and self.heap[parent_i] > self.heap[i]:
            self.heap[parent_i], self.heap[i] = self.heap[i], self.heap[parent_i]
            i = parent_i
            parent_i = (i - 1) // 2

    def _sift_down(self, i):
        left = 2 * i + 1
        right = 2 * i + 2

        while (left < len(self.heap) and self.heap[left] < self.heap[i]) or (
                right < len(self.heap) and self.heap[right] < self.heap[i]):
            smallest_i = left if (right >= len(self.heap)) or self.heap[left] < self.heap[right] else right
            self.heap[i], self.heap[smallest_i] = self.heap[smallest_i], self.heap[i]
            i = smallest_i
            left = 2 * i + 1
            right = 2 * i + 2

    def get_min(self):
        return self.heap[0] if len(self.heap) > 0 else None

    def pop_min(self):
        if len(self.heap) == 0:
            return
        self.heap[0], self.heap[-1] = self.heap[-1], self.heap[0]
        min = self.heap.pop()
        self._sift_down(0)
        return min

    def update_by_index(self, i, new):
        old = self.heap[i]
        self.heap[i] = new
        if old < new:
            self._sift_up(i)
        if old > new:
            self._sift_down(i)


heap = MinHeap()
heap.insert(3)
heap.insert(4)
heap.insert(5)
heap.insert(2)
heap.insert(1)

print(heap.heap)

"""
    1
    /\
    2 5
    /\
   4  3
"""


class MaxHeap:
    def __init__(self):
        self.heap = []

    def insert(self, val):
        # self.heap.append(val)
        # self._sift_down(len(self.heap) - 1)
        pass

    def _sift_down(self, i):
        left_i = 2 * i + 1
        right_i = 2 * i + 2

        while left_i < len(self.heap) and right_i < len(self.heap) and (
                self.heap[left_i] > self.heap[i] or self.heap[right_i] > self.heap[i]):
            higher_i = left_i if self.heap[left_i] > self.heap[i] else right_i
            self.heap[i], self.heap[higher_i] = self.heap[higher_i], self.heap[i]
            i = higher_i
            left_i = 2 * i + 1
            right_i = 2 * i + 2

    def get_min(self):
        pass

    def pop_min(self):
        pass

    def update(self):
        pass


heap = MaxHeap()
heap.insert(3)
heap.insert(4)
heap.insert(5)
heap.insert(2)
heap.insert(1)

print(heap.heap)

"""
    1
    /\
    2 5
    /\
   4  3
"""
