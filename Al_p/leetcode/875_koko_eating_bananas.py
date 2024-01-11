import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def check_candidate(k):
            curH = 0
            for p in piles:
                curH += math.ceil(p / k)
                if curH > h:
                    return False
            return True

        mx = max(piles)
        L, R = 1, mx
        res = mx
        while L <= R:
            k = (L + R) // 2
            if check_candidate(k):
                res = min(res, k)
                R = k - 1
            else:
                L = k + 1
        return res


print(Solution().minEatingSpeed(piles=[3, 6, 7, 11], h=8))
