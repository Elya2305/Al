from typing import List


class Solution:
    def compress(self, chars: List[str]) -> int:
        new = 0
        old = 0

        while old < len(chars):
            char = chars[old]
            count = 0
            while old < len(chars) and chars[old] == char:
                count += 1
                old += 1
            chars[new] = char
            if count != 1:
                digits = [i for i in str(count)]
                for digit in digits:
                    new += 1
                    chars[new] = digit
            new += 1

        return new + 1


s = Solution()
chars = ["a", "a", "b", "b", "c", "c", "c"]
print(s.compress(chars))
print(chars)

