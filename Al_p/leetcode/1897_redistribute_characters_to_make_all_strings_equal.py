from collections import defaultdict, Counter
from typing import List


class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        letters = defaultdict(int)
        for w in words:
            for l in w:
                letters[l] += 1
        nums = list(letters.values())
        for l in nums:
            if l % len(words) != 0:
                return False
        return True


# print(Solution().makeEqual(
#     ["caaaaa", "aaaaaaaaa", "a", "bbb", "bbbbbbbbb", "bbb", "cc", "cccccccccccc", "ccccccc", "ccccccc", "cc", "cccc",
#      "c", "cccccccc", "c"]))

# words = ["abc", "aabc", "bc"]
# print(Counter("abc"))
#
a = Counter("abc")
b = Counter("abc")
print(a + b)
c = [a, b]
print(sum(c, Counter()))
print(Counter(["abc", "abc"]))
