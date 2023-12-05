arr = [list(l.strip()) for l in open("3_gear_ratios.txt", 'r')]
ROWS, COLS = len(arr), len(arr[0])
sum, n, n_start, n_end = 0, None, None, None


def is_symbol(i, j):
    is_within_bounds = 0 <= i < ROWS and 0 <= j < COLS
    return is_within_bounds and not arr[i][j].isnumeric() and arr[i][j] != "."


def is_adjacent(num_start, num_end):
    is_adjacent = False

    for i in (num_start[0] - 1, num_start[0] + 1):
        for j in range(num_start[1] - 1, num_end[1] + 2):
            if is_symbol(i, j):
                is_adjacent = True
                break

    for j in (num_start[1] - 1, num_end[1] + 1):
        for i in range(num_start[0] - 1, num_end[0] + 2):
            if is_symbol(i, j):
                is_adjacent = True
                break

    return is_adjacent


for i in range(len(arr)):
    for j in range(len(arr[i])):
        if not arr[i][j].isnumeric() and n:
            if is_adjacent(n_start, n_end):
                sum += int(n)
            n, n_start, n_end = None, None, None
        if arr[i][j].isnumeric():
            n = arr[i][j] if n is None else n + arr[i][j]
            n_start = (i, j) if not n_start else n_start
            n_end = (i, j)

print(sum)  # 535235
