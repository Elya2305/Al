import collections
from typing import List


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        c = collections.Counter(nums)
        res = 0
        for a in c.values():
            if a % 3 == 0:
                res += a / 3
            else:
                div = (a // 3) * 3
                while div > 0:
                    if (a - div) % 2 == 0:
                        break
                    else:
                        div -= 3
                if div > 0:
                    res += (div / 3) + (a - div) / 2
                else:
                    if a % 2 == 0:
                        res += a / 2
                    else:
                        return -1
        return int(res)

    def minOperationsDP(self, nums: List[int]) -> int:
        c = collections.Counter(nums)
        o = [0.0] * (max(c.values()) + 1)
        o[1], o[2], o[3] = float("inf"), 1, 1

        for i in range(4, len(o)):
            o[i] = 1 + min(o[i - 2], o[i - 3])

        res = 0
        for i in c.values():
            if o[i] == float("inf"):
                return -1
            res += o[i]
        return int(res)


s = Solution()
# print(s.minOperations([7, 7, 7, 7, 7, 7, 7, 16, 7, 7, 7, 16, 7, 16, 7, 16, 16, 16, 16, 7]))  # 7 -> 13, 16 -> 7
print(s.minOperationsDP([2, 3, 3, 2, 2, 4, 2, 3, 4]))
