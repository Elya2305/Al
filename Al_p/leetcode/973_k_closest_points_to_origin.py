import heapq
from math import sqrt
from typing import List


class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        class PointDistanceToOrigin:
            def __init__(self, point):
                self.point = point
                self.distance = sqrt(pow(point[0], 2) + pow(point[1], 2))

            def __lt__(self, other):
                return self.distance < other.distance

        minHeap = [PointDistanceToOrigin(point) for point in points]
        heapq.heapify(minHeap)
        result = [heapq.heappop(minHeap).point for _ in range(k)]
        return result


point = [1, 3]
print([pow(point[0], 2) + pow(point[1], 2)] + point)
