from typing import List


class Solution:
    def minCostClimbingStairs(self, costs: List[int]) -> int:
        minCost = 1000000

        def step(i, cost):
            nonlocal minCost
            if i >= len(costs):
                minCost = min(minCost, cost)
                return
            cost = costs[i] + cost
            step(i + 1, cost)
            step(i + 2, cost)

        step(0, 0)
        step(1, 0)
        return minCost


s = Solution()
print(s.minCostClimbingStairs([10, 15, 20]))
