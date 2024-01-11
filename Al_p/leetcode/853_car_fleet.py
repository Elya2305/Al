from operator import itemgetter
from typing import List


class Solution:
    # def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
    #     q = [[p, s, False] for p, s in zip(position, speed)]
    #     q = sorted(q, key=itemgetter(0))
    #     fleet = 0
    #     while len(q) > 1:
    #         p1, s1, merged1 = q.pop()
    #         p2, s2, merged2 = q.pop()
    #         t1 = (target - p1) / s1
    #         t2 = (target - p2) / s2
    #         if t1 < t2:
    #             q.append([p2, s2, False])
    #         else:
    #             q.append([p1, s1, True])
    #         if not merged1:
    #             fleet += 1
    #     if not q.pop()[2]:
    #         fleet += 1
    #     return fleet

    def carFleet(self, target, position, speed):
        time = [float(target - p) / s for p, s in sorted(zip(position, speed))]
        res = cur = 0
        for t in time[::-1]:
            if t > cur:
                res += 1
                cur = t
        return res


print(Solution().carFleet(target=100, position=[0, 2, 4], speed=[4, 2, 1]))
print(Solution().carFleet(target=12, position=[10, 8, 0, 5, 3], speed=[2, 4, 1, 1, 3]))
