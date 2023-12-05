# n: number of stairs,
# k: up to how many stairs you can climb at a time;
# rs: stairs that you can't step on
from typing import List


def climb_stairs_with_red_steps(n, k, rs):
    stairs = [0] * (n + 1)
    stairs[0] = 1 if 0 not in rs else 0

    for i in range(1, n + 1):
        if i in rs:
            continue
        for j in range(1, min(k, i) + 1):
            stairs[i] += stairs[i - j]

    return stairs[-1]


# print(climb_stairs_with_red_steps(7, 3, [1, 3, 4]))


def climb_stairs_with_minimum_cost(costs):
    costs.append(0)
    min_costs = [0] * (len(costs) + 1)
    min_costs[1] = costs[0]

    for i in range(2, len(min_costs)):
        min_costs[i] = costs[i - 1] + min(min_costs[i - 1], min_costs[i - 2])

    return min_costs[-1]


def climb_stairs_with_minimum_cost_rec(costs):
    costs = [0] + costs
    memo = {}

    def climb(i):
        if i in memo:
            return memo[i]
        if i >= len(costs):
            return 0

        take_steps = costs[i] + min(climb(i + 1), climb(i + 2))
        memo[i] = take_steps
        return take_steps

    return climb(0)


def climb_stairs_with_minimum_cost_improved(costs):
    costs.append(0)
    l = 0
    r = costs[0]

    for i in range(1, len(costs)):
        l, r = r, min(l, r) + costs[i]

    return r


def climb_stairs_with_minimum_cost_improved_print_path(costs):
    costs.append(0)
    l = 0
    r = costs[0]

    path = []

    for i in range(1, len(costs)):
        cst = min(l, r)
        if len(path) == 0 or path[-1] != cst:
            path.append(cst)
        l, r = r, cst + costs[i]

    print(path)
    return r


# print(climb_stairs_with_minimum_cost([1, 100, 1, 1, 1, 100, 1, 1, 100, 1]))
# print(climb_stairs_with_minimum_cost([10, 15, 20]))
# print(climb_stairs_with_minimum_cost_improved([10, 15, 20]))
# print(climb_stairs_with_minimum_cost_rec([10, 15, 20]))
# print(climb_stairs_with_minimum_cost_improved_print_path([10, 15, 20]))


# costs = [10, 15, 20]
# print([0] + costs + [0])


def uniquePaths(m: int, n: int) -> int:
    grid = [[0] * n for _ in range(m)]

    for j in range(n):
        grid[m - 1][j] = 1
    for i in range(m):
        grid[i][n - 1] = 1

    for j in range(n - 2, -1, -1):
        for i in range(m - 2, -1, -1):
            grid[i][j] = grid[i][j + 1] + grid[i + 1][j]

    return grid[0][0]


def uniquePathsRec(m: int, n: int) -> int:
    cache = {}

    def travel(i, j):
        if (i, j) in cache:
            return cache[(i, j)]
        if i == m - 1 or j == n - 1:
            return 1
        if i >= m or j >= n:
            return 0

        paths = travel(i + 1, j) + travel(i, j + 1)
        cache[(i, j)] = paths
        return paths

    return travel(0, 0)


# print(uniquePaths(3, 7))
# print(uniquePathsRec(3, 7))


def uniquePathsWithObstacles(grid: List[List[int]]) -> int:
    ROWS, COLS = len(grid), len(grid[0])

    for i in range(ROWS):
        for j in range(COLS):
            if grid[i][j] == 1:
                grid[i][j] = 0
            else:
                grid[i][j] = 1

    for i in range(ROWS):
        for j in range(COLS):
            if grid[i][j] == 0:
                continue
            if i > 0 and j > 0:
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1]
            if i > 0 and j == 0:
                grid[i][j] = grid[i - 1][j]
            if i == 0 and j > 0:
                grid[i][j] = grid[i][j - 1]

    return grid[ROWS - 1][COLS - 1]


grid = [[0, 1], [0, 0]]


# print(uniquePathsWithObstacles(grid))


# [0, 2, 2, 1]
# [3, 2, 1, 100]
# [4, 4, 2, 0]
def uniquePathMaxProfitPath(grid) -> int:
    ROWS, COLS = len(grid), len(grid[0])

    for i in range(ROWS):
        for j in range(COLS):

            if i > 0 and j > 0:
                grid[i][j] += max(grid[i - 1][j], grid[i][j - 1])
            if i > 0 and j == 0:
                grid[i][j] += grid[i - 1][j]
            if i == 0 and j > 0:
                grid[i][j] += grid[i][j - 1]

    def getPath(i, j, path):
        if i == 0 and j == 0:
            path.append((i, j))
            return path
        if i == 0 and j > 0:
            path = getPath(i, j - 1, path)
        if i > 0 and j == 0:
            path = getPath(i - 1, j, path)
        if i > 0 and j > 0:
            if grid[i - 1][j] > grid[i][j - 1]:
                path = getPath(i - 1, j, path)
            else:
                path = getPath(i, j - 1, path)
        path.append((i, j))
        return path

    p = getPath(ROWS - 1, COLS - 1, [])
    print('path', p)
    print('grid', grid)
    return max(max(grid))


grid = [[0, 2, 2, 1],
        [3, 2, 1, 100],
        [4, 4, 2, 0]]


# print(uniquePathMaxProfitPath(grid))

# [[0, 2, 4, 5],
#  [3, 5, 6, 106],
#  [7, 11, 13, 106]]

# [(0, 0), (1, 0), (1, 1), (1, 2), (1, 3), (2, 3)]

# constraint: 2 colors, can't paint more than 2 similar colors in a row
def paintFans(n):
    def paint(fans, color):
        fans.append(color)
        l = len(fans)
        if l > n:
            fans.pop()
            return 0
        if l > 1 and fans[l - 1] == fans[l - 2] == color:
            fans.pop()
            return 0
        return 1 + paint(fans, 0) + paint(fans, 1)

    return paint([], 0) + paint([], 1)


print(paintFans(1))
print(paintFans(2))
print(paintFans(3))
