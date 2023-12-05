from typing import List


def findDuplicate(nums: List[int]) -> int:
    slow, fast = 0, 0

    while True:
        slow = nums[slow]
        fast = fast[nums[fast]]
        if slow == fast:
            break

    slow2 = 0

    while slow != slow2:
        slow = nums[slow]
        slow2 = nums[slow2]

    return slow


nums = [1, 3, 4, 2, 2]
nums2 = [3, 1, 3, 4, 2]
print(findDuplicate(nums))
print(findDuplicate(nums2))
