from collections import deque


class Solution:
    def isValid(self, s: str) -> bool:
        m = {
            "}": "{",
            ")": "(",
            "]": "["
        }
        open = set(m.values())
        closed = set(m.keys())
        s = deque()

        for c in s:
            if c in open:
                s.append(c)
            elif c in closed and len(s) == 0:
                return False
            else:
                lastC = s.pop()
                if m[c] != lastC:
                    return False

        return len(s) == 0


s = Solution()
print(s.isValid("(]"))
