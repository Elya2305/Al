from typing import List


# TODO HOW TO DO THIS WITH BACKTRACKING ???
# class Solution:
#     def threeSum(self, nums: List[int]) -> List[List[int]]:
#         nums = sorted(nums)
#         res = []
#         cur = []
#
#         def threeSum(sum, idx):
#             if sum == 0 and len(cur) == 3:
#                 res.append(cur.copy())
#                 return
#             if len(cur) > 3:
#                 return
#
#             for i in range(idx, len(nums)):
#                 e = nums[i]
#                 cur.append(e)
#                 while i < len(nums) and nums[i] == e:
#                     i += 1
#                 threeSum(sum + e, i)
#                 cur.pop()
#
#         threeSum(0, 0)
#         return res


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        def twoSum(target, excludeIdx):
            l, r = 0, len(nums) - 1
            while l < r:
                sum = nums[l] + nums[r]
                if sum > target or r == excludeIdx:
                    r -= 1
                elif sum < target or l == excludeIdx:
                    l += 1
                else:
                    return [l, r]
            return []

        res = []
        for i in range(len(nums)):
            target = nums[i]
            arr = twoSum(-target, i)
            if len(arr) != 0:
                res.append([nums[i], nums[arr[0]], nums[arr[1]]])

        return res


# nums = [-1, 0, 1, 2, -1, -4]
# s = Solution()
# print(s.threeSum(nums))

test = [[0, 2], [1, 1]]
test_with_appended = [subarray + [-2] for subarray in test]
print(test_with_appended)
