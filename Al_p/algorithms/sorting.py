import random


# O(n) - best case, O(n^2) - worst/average case
def insertion_sort(arr):
    for i in range(len(arr)):
        j = i - 1
        while j >= 0 and arr[j + 1] < arr[j]:
            temp = arr[j + 1]
            arr[j + 1] = arr[j]
            arr[j] = temp
            j -= 1


# O(n log(n))
def merge_sort(arr):
    def merge_sort(l, r):
        if l < r:
            m = (l + r) // 2
            merge_sort(l, m)
            merge_sort(m + 1, r)
            merge(l, m, r)

    def merge(l, m, r):
        n1, n2 = (m - l + 1), (r - m)
        L = [0] * n1
        R = [0] * n2

        for i in range(n1):
            L[i] = arr[l + i]
        for j in range(n2):
            R[j] = arr[m + 1 + j]

        i, j = 0, 0
        k = l

        while i < n1 and j < n2:
            if L[i] < R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        while i < n1:
            arr[k] = L[i]
            i += 1
            k += 1

        while j < n2:
            arr[k] = R[j]
            j += 1
            k += 1

    merge_sort(0, len(arr) - 1)
    return arr


array = [1, 2, 3, 4, 5, 6]

random.shuffle(array)
insertion_sort(array)
print(array)

random.shuffle(array)
merge_sort([5, 1, 1, 2, 0, 0])
print(array)
