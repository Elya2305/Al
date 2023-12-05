from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        memo = {}

        def dfs(i, cur):
            if (i, cur) in memo:
                return memo[(i, cur)]
            if cur == 0:
                return 1
            if cur < 0:
                return 0
            res = 0
            for j in range(i, len(coins)):
                res += dfs(j, cur - coins[j])
            memo[(i, cur)] = res
            return res

        return dfs(0, amount)


s = Solution()
print(s.change(5, [1, 2, 5]))
