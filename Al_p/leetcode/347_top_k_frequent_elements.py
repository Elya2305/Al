from typing import List


def topKFrequent(nums: List[int], k: int) -> List[int]:
    count = {}
    res = []

    for num in nums:
        if count.get(num):
            count[num] = count[num] + 1
        else:
            count[num] = 1
    swaped_count = {}
    for key, val in count.items():
        if swaped_count.get(val):
            swaped_count[val].append(key)
        else:
            swaped_count[val] = [key]

    lst = sorted(swaped_count.items())

    for i in reversed(lst):
        for j in i[1]:
            res.append(j)
            k = k - 1
        if k == 0:
            break

    return res


nums = [1, 2]
k2 = 2

# print(topKFrequent(nums, k2))

# count_arr = [[]] * 3
# count_arr[0].append(1)
# print(count_arr)

arr = [0 for _ in range(3)]
print(arr)
