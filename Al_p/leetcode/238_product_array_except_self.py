from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1] * (len(nums) + 1)
        postfix = [1] * (len(nums) + 1)

        for i in range(1, len(nums) + 1):
            prefix[i] = prefix[i - 1] * nums[i - 1]

        for i in range(len(nums) - 1, -1, -1):
            postfix[i] = postfix[i + 1] * nums[i]

        # index = 1
        for i in range(len(nums)):
            nums[i] = prefix[i] * postfix[i + 1]

        return nums

s = Solution()
nums = [1, 2, 3, 4]
print(s.productExceptSelf(nums))

#     [1, 2, 3, 4]
#  [1, 1, 2, 6, 24]
#     [24, 24, 12, 4, 1]
