from typing import List


class BadSolution:

    # O(n * 2^n + 2^n * n) = O(n * 2^n)
    def lengthOfLIS(self, nums: List[int]) -> int:
        subs = self.generateSubsequence(nums)  # O(n * 2^n)
        res = 0
        for s in subs:  # O(2^n)
            if self.isIncreasing(s):  # O(n)
                res = max(res, len(s))
        return res

    def isIncreasing(self, nums):
        for i in range(1, len(nums)):
            if nums[i] <= nums[i - 1]:
                return False
        return True

    def generateSubsequence(self, nums):
        res, cur = [], []

        def dfs(i):
            if i == len(nums):
                res.append(cur.copy())
                return
            cur.append(nums[i])
            dfs(i + 1)
            cur.pop()
            dfs(i + 1)

        dfs(0)
        return res


s = BadSolution()
print(s.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]))


class BetterSolution:

    def lengthOfLIS(self, nums: List[int]) -> int:
        res, cur = [], []

        def dfs(i):
            if i == len(nums):
                res.append(cur.copy())
                return

            for j in range(i, len(nums)):
                if len(cur) == 0 or cur[-1] < nums[j]:
                    cur.append(nums[j])
                    dfs(i + 1)
                    cur.pop()
                    dfs(i + 1)

        for i in range(len(nums)):
            dfs(i)
        print(res)
        return -1


s = BetterSolution()
s.lengthOfLIS([1, 2, 4, 3])
