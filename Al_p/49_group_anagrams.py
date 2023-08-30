from typing import List


# O(n), S(n)
def _are_anagrams(str1, str2):
    if len(str1) != len(str2):
        return False

    d1 = {}
    d2 = {}

    for i in range(len(str1)):
        if d1.get(str1[i]):
            d1[str1[i]] = d1[str1[i]] + 1
        else:
            d1[str1[i]] = 1

        if d2.get(str2[i]):
            d2[str2[i]] = d2[str2[i]] + 1
        else:
            d2[str2[i]] = 1

    return d1 == d2


# O(m * n), m - len of strs, n - max len of str
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = {}  # word -> ["ordw", ["rdwo"]]

        for str in strs:
            found_group = False

            for key in anagrams:
                if _are_anagrams(str, key):
                    found_group = True
                    anagrams[key].append(str)
                    break

            if not found_group:
                anagrams[str] = [str]

        return list(anagrams.values())


# time limit exceeded
################################################################################

class Solution2:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sorted_words = []
        anagrams = {}

        # O(n * m * log(m))
        for word in strs:
            sorted_words.append(''.join(sorted(word)))  # O(m*log(m))

        # O(n)
        for i in range(len(strs)):
            if anagrams.get(sorted_words[i]):
                anagrams[sorted_words[i]].append(strs[i])
            else:
                anagrams[sorted_words[i]] = [strs[i]]

        return list(anagrams.values())

# n - len(strs), m - len(max(strs))
# O(n*m*log(m) + n), S(n)

# Passed... but can we do better?

################################################################################
