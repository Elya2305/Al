def binary_search_rec(sorted_arr, a):
    def search(l, r):
        if l <= r:
            m = (l + r) // 2
            if sorted_arr[m] == a:
                return True
            elif sorted_arr[m] < a:
                return search(m + 1, r)
            else:
                return search(l, m - 1)
        return False

    return search(0, len(sorted_arr) - 1)


def binary_search(arr, a):
    l, r = 0, len(arr) - 1

    while l <= r:
        m = (l + r) // 2
        if arr[m] == a:
            return True
        elif arr[m] < a:
            l = m + 1
        else:
            r = m - 1

    return False


arr = [1, 3, 4, 6, 9]

print(binary_search(arr, 1))
print(binary_search(arr, 2))
print(binary_search(arr, 4))
print(binary_search(arr, 5))
print(binary_search(arr, 9))
