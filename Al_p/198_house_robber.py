from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        cache = {}

        def rob(start, end):
            if start in cache:
                return cache[start]
            if start > end:
                return 0
            if start == end:
                return nums[start]

            one = nums[start] + rob(start + 2, end)
            two = rob(start + 1, end)
            robbed = max(one, two)
            cache[start] = robbed
            return robbed

        return rob(0, len(nums) - 1)


class SolutionWithTabulation:
    def rob(self, nums: List[int]) -> int:
        r1 = 0
        r2 = 0

        for n in nums:
            rob = max(r1 + n, r2)
            r1 = r2
            r2 = rob

        return r2


s = Solution()
# print(s.rob([1, 2, 3, 1]))
# print(s.rob([2, 7, 9, 3, 1]))


s = SolutionWithTabulation()
print(s.rob([1, 2, 3, 1]))
# print(s.rob([2, 7, 9, 3, 1]))