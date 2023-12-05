from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        coins.sort()  # nlogn

        curCoins = []
        res = float("inf")

        def collect(i, currAmount):
            nonlocal res
            curCoins.append(coins[i])

            if currAmount > amount:
                curCoins.pop()
                return
            if currAmount == amount:
                res = min(res, len(curCoins))
                curCoins.pop()
                return

            for j in range(i, len(coins)):
                collect(j, currAmount + coins[j])
            curCoins.pop()

        for i in range(len(coins)):
            collect(i, coins[i])
        return -1 if res == float("inf") else res

    def coinChangeWithMemo(self, coins: List[int], amount: int) -> int:
        memo = {}

        def collect(currAmount):
            if currAmount in memo:
                return memo[currAmount]
            if currAmount > amount:
                return -1
            if currAmount == amount:
                return 1

            minRes = float("inf")
            for j in range(len(coins)):
                res = collect(currAmount + coins[j])
                if res > 0:
                    minRes = min(res, minRes)
            res = -1 if minRes == float('inf') else minRes + 1
            memo[currAmount] = res
            return res

        r = float("inf")
        for i in range(len(coins)):
            minR = collect(coins[i])
            r = r if minR < 0 else min(r, minR)
        return -1 if r == float("inf") else r


# O(m*n)
def coinChangeTab(coins: List[int], amount: int) -> int:
    res = [amount + 1] * (amount + 1)
    res[0] = 0

    for i in range(2, amount + 1):
        for c in coins:
            if i - c >= 0:
                res[i] = min(res[i], 1 + res[i - c])

    return res[amount] if res[amount] != amount + 1 else -1


# print(Solution().coinChangeWithMemo([1, 2147483647], 3))
print(coinChangeTab([3], 8))
