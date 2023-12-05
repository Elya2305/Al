from collections import defaultdict

arr = [list(l.strip()) for l in open("3_gear_ratios.txt", 'r')]
ROWS, COLS = len(arr), len(arr[0])
sum, n, n_start, n_end = 0, None, None, None

starToNums = defaultdict(list)


def check_star(i, j):
    is_within_bounds = 0 <= i < ROWS and 0 <= j < COLS
    is_star = is_within_bounds and arr[i][j] == "*"
    if is_star:
        starToNums[f'{i},{j}'].append(int(n))


def check_adjacent_to_star(num_start, num_end):
    for i in (num_start[0] - 1, num_start[0] + 1):
        for j in range(num_start[1] - 1, num_end[1] + 2):
            check_star(i, j)

    for j in (num_start[1] - 1, num_end[1] + 1):
        i = num_start[0]
        check_star(i, j)


for i in range(len(arr)):
    for j in range(len(arr[i])):
        if not arr[i][j].isnumeric() and n:
            check_adjacent_to_star(n_start, n_end)
            n, n_start, n_end = None, None, None
        if arr[i][j].isnumeric():
            n = arr[i][j] if n is None else n + arr[i][j]
            n_start = (i, j) if not n_start else n_start
            n_end = (i, j)

res = 0
for star, num_list in starToNums.items():
    if len(num_list) == 2:
       res += num_list[0] * num_list[1]

print(res)
