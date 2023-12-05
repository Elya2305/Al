from collections import defaultdict
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(set)
        rGraph = defaultdict(set)
        for p1, p2 in prerequisites:
            graph[p1].add(p2)
            rGraph[p2].add(p1)

        visited = set()
        res = []

        def dfs(c):
            if c in visited:
                return False
            visited.add(c)

            while graph[c]:
                nei = graph[c].pop()
                rGraph[nei].remove(c)
                if not dfs(nei):
                    return False

            res.append(c)
            for node in rGraph[c]:
                graph[node].remove(c)
            return True

        for c in range(numCourses):
            if c not in visited and not dfs(c):
                return []

        for c in range(numCourses):
            if c not in visited:
                res.append(c)

        return res


print(Solution().findOrder(3, [[0, 1], [0, 2], [1, 2]]))
