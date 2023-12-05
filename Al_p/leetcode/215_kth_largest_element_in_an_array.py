from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return self._findKthLargest(nums, k, 0, len(nums) - 1)

    def _findKthLargest(self, nums, k, start, end) -> int:
        pivot_index = self._quickSelect(nums, start, end)
        kth_largest_index = len(nums) - k
        if pivot_index == kth_largest_index:
            return nums[pivot_index]
        elif kth_largest_index > pivot_index:
            return self._findKthLargest(nums, k, pivot_index + 1, end)
        else:
            return self._findKthLargest(nums, k, start, pivot_index - 1)

    def _quickSelect(self, arr, start, end):
        pivot = arr[end]
        p = start
        for i in range(start, end):
            if arr[i] <= pivot:
                arr[i], arr[p] = arr[p], arr[i]
                p += 1
        arr[end], arr[p] = arr[p], arr[end]
        return p


s = Solution()
print(s.findKthLargest(nums=[3, 2, 1, 5, 6, 4], k=2))


class SolutionShorter:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        k = len(nums) - k

        def quickSelect(start, end):
            pivot, p = nums[end], start
            for i in range(start, end):
                if nums[i] <= pivot:
                    nums[i], nums[p] = nums[p], nums[i]
                    p += 1
            nums[p], nums[end] = nums[end], nums[p]

            if p < k:
                return quickSelect(p + 1, end)
            elif p > k:
                return quickSelect(start, p - 1)
            return pivot

        return quickSelect(0, len(nums) - 1)
