from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        visited = set()

        def area(i, j):
            if (not (0 <= i < len(grid) and 0 <= j < len(grid[0]))) or (i, j) in visited or grid[i][j] == 0:
                return 0

            visited.add((i, j))

            return 1 + area(i, j + 1) + area(i, j - 1) + area(i + 1, j) + area(i - 1, j)

        maxIsland = 0

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                maxIsland = max(maxIsland, area(i, j))

        return maxIsland
