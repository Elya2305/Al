from collections import defaultdict
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        nodes = defaultdict(list)
        for c, p in prerequisites:
            nodes[c].append(p)

        visited = set()

        def canComplete(course):
            if not nodes[course]:
                return True
            if course in visited:
                return False

            visited.add(course)

            for p in nodes[course].copy():
                if not canComplete(p):
                    return False
                nodes[course].remove(p)
            return True

        for course in range(numCourses):
            if not canComplete(course):
                return False

        return True


print(Solution().canFinish(7, [[1, 0], [0, 3], [0, 2], [3, 2], [2, 5], [4, 5], [5, 6], [2, 4]]))
