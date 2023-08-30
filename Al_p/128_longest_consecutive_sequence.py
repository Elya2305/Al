from typing import List


# O(nlogn)
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 1

        nums.sort()

        lg = 1
        lg_cur = 1
        prev = nums[0]

        for i in range(2, len(nums)):
            if nums[i] - prev == 1:
                lg_cur += 1
            else:
                lg_cur = 1
            lg = max(lg, lg_cur)
            prev = nums[i]

        return lg


nums = [100, 4, 200, 1, 3, 2]

s = Solution()
s.longestConsecutive(nums)
