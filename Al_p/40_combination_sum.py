from typing import List


def combinationSum2(candidates: List[int], target: int) -> List[List[int]]:
    candidates.sort()

    res = []
    temp_com = []

    def combination(temp_sum, index):
        if target == temp_sum:
            res.append(temp_com.copy())
        if temp_sum >= target:
            return

        prev = -1
        for i in range(index, len(candidates)):
            if prev == candidates[i]:
                continue
            temp_com.append(candidates[i])
            combination(temp_sum + candidates[i], i + 1)
            temp_com.pop()
            prev = candidates[i]

    combination(0, 0)
    return res


candidates = [2, 5, 2, 1, 2]
target = 5

print(combinationSum2(candidates, target))  # [ [1,2,2], [5] ]

