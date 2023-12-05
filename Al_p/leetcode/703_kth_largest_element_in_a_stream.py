from typing import List


class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.heap = MinHeap()
        self._init_heap(k, nums)
        self.k = k

    def _init_heap(self, k: int, nums: List[int]):
        for num in nums:
            self.heap.insert(num)
        while self.heap.size() > k:
            self.heap.pop_min()

    def add(self, val: int) -> int:
        if self.heap.size() == self.k and val < self.heap.get_min():
            return self.heap.get_min()
        self.heap.insert(val)
        if self.heap.size() > self.k:
            self.heap.pop_min()
        return self.heap.get_min()


class MinHeap:
    def __init__(self):
        self.heap = []

    def size(self):
        return len(self.heap)

    def insert(self, val):
        self.heap.append(val)
        self._sift_up(len(self.heap) - 1)

    def _sift_up(self, i):
        parent = (i - 1) // 2
        while 0 <= parent < len(self.heap) and self.heap[parent] > self.heap[i]:
            self.heap[parent], self.heap[i] = self.heap[i], self.heap[parent]
            i = parent
            parent = (i - 1) // 2

    def _sift_down(self, i):
        left = 2 * i + 1
        right = 2 * i + 2

        while (left < len(self.heap) and self.heap[left] < self.heap[i]) or (
                right < len(self.heap) and self.heap[right] < self.heap[i]):
            smallest = left if (right >= len(self.heap)) or self.heap[left] < self.heap[right] else right
            self.heap[i], self.heap[smallest] = self.heap[smallest], self.heap[i]
            i = smallest
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


s = KthLargest(2, [0])
print(s.add(-1))
print(s.add(1))
print(s.add(-2))
print(s.add(-4))
print(s.add(3))
