from collections import deque
from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        s = deque()

        for idx, temp in enumerate(temperatures):
            while s and s[-1][0] < temp:
                sT, sI = s.pop()
                res[sI] = idx - sI
            s.append([temp, idx])

        return res


print(Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))
