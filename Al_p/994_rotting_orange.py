from collections import deque
from typing import List


# 3 - rotten and visited,
# 4 - marked to be rotten and visited
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        q = deque()

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    q.append((i, j, 0))

        time = -1
        while q:
            x1, y1, t = q.popleft()
            time = t
            grid[x1][y1] = 3
            for x, y in ((x1 - 1, y1), (x1 + 1, y1), (x1, y1 - 1), (x1, y1 + 1)):
                if 0 <= x < ROWS and 0 <= y < COLS and grid[x][y] == 1:
                    grid[x][y] = 4
                    q.append((x, y, t + 1))

        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j] == 1:
                    return -1

        return 0 if time == -1 else time


s = Solution()

grid = [[2, 2],
        [1, 1],
        [0, 0],
        [2, 0]]

print(s.orangesRotting(grid))