import heapq
from typing import List


class SimplerSolution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        max_heap = [-e for e in stones]
        heapq.heapify(max_heap)

        while len(max_heap) > 1:
            s1, s2 = -heapq.heappop(max_heap), -heapq.heappop(max_heap)
            smash = abs(s1 - s2)
            if smash != 0:
                heapq.heappush(max_heap, -smash)

        return 0 if len(max_heap) == 0 else -heapq.heappop(max_heap)


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        def insert_into_sorted_array(arr, element):
            start = 0
            end = len(arr) - 1

            while start <= end:
                middle = (start + end) // 2

                if arr[middle] == element:
                    arr.insert(middle, element)
                    return
                elif arr[middle] < element:
                    start = middle + 1
                else:
                    end = middle - 1

            # If the element is greater than all existing elements, insert it at the end.
            insert_index = start
            arr.insert(insert_index, element)

        stones = sorted(stones)

        while len(stones) > 1:
            s1 = stones.pop()
            s2 = stones.pop()
            smashed = s1 - s2
            if smashed > 0:
                insert_into_sorted_array(stones, smashed)

        return stones[0] if len(stones) else 0


s = Solution()
stones = []


# print(s.lastStoneWeight(stones))


def insert_into_sorted_array(arr, element):
    start = 0
    end = len(arr) - 1

    while start <= end:
        middle = (start + end) // 2

        if arr[middle] == element:
            arr.insert(middle, element)
            return
        elif arr[middle] < element:
            start = middle + 1
        else:
            end = middle - 1

    # If the element is greater than all existing elements, insert it at the end.
    insert_index = start
    arr.insert(insert_index, element)


# Example usage:
sorted_array = [1, 3, 5, 7, 9]
element_to_insert = 4
insert_into_sorted_array(sorted_array, element_to_insert)
print(sorted_array)  # Output: [1, 3, 4, 5, 7, 9]
