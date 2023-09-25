def lis(arr):
    n = len(arr)

    # Declare the list (array) for LIS and
    # initialize LIS values for all indexes
    lis = [1] * n

    # Compute optimized LIS values in bottom up manner
    for i in range(1, n):
        for j in range(0, i):
            if arr[i] > arr[j]:
                lis[i] = max(lis[i], lis[j] + 1)

    # Pick maximum of all LIS values
    return max(lis)


def lisDFS(arr):
    res = 0
    sub = []

    def dfs(i):
        nonlocal res

        if i >= len(arr) or (len(sub) > 0 and arr[i] < sub[-1]):
            res = max(res, len(sub))
            return

        sub.append(arr[i])
        dfs(i + 1)
        # sub.pop()

    dfs(0)
    return res


arr = [10, 22, 9, 33, 21, 50, 41, 60, 80]
print(lis(arr))
print(lisDFS(arr))
