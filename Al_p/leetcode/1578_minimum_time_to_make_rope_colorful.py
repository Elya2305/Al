from typing import List


class FirstSolution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        res, group = 0, []

        def remove_balloons():
            time = 0
            if len(group) > 1:
                max_time_i = max([(neededTime[i], i) for i in group])[1]
                time = sum([neededTime[i] for i in group]) - neededTime[max_time_i]
            group.clear()
            return time

        for i, c in enumerate(colors):
            if len(group) > 0 and colors[group[-1]] != c:
                res += remove_balloons()
            group.append(i)

        res += remove_balloons()
        return res


class MoreNiceSolution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        l, r = 0, 1
        time = 0

        while r < len(colors):
            if colors[l] == colors[r]:
                time += min(neededTime[l], neededTime[r])
            if neededTime[l] < neededTime[r] or colors[l] != colors[r]:
                l = r
            r += 1

        return time


print(MoreNiceSolution().minCost(colors="aaabbbabbbb", neededTime=[3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1]))
