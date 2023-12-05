from collections import deque
from typing import List


# class Solution:
#     def generateParenthesis(self, n: int) -> List[str]:
#         result = set()
#         s = deque()
#
#         def generate(open, closed, par):
#             if open == 0 and closed == 0:
#                 result.add(''.join(s))
#                 return
#
#             if par == "(":
#                 if open == 0:
#                     return
#                 else:
#                     open -= 1
#             if par == ")":
#                 if closed == 0 or closed <= open:
#                     return
#                 else:
#                     closed -= 1
#
#             s.append(par)
#             generate(open, closed, "(")
#             generate(open, closed, ")")
#             s.pop()
#
#         generate(n, n, "(")
#         return list(result)


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        s = []
        res = []

        def backtrack(openN, closedN):
            if openN == closedN == n:
                res.append("".join(s))
                return

            if openN < n:
                s.append("(")
                backtrack(openN + 1, closedN)
                s.pop()

            if openN > closedN:
                s.append(")")
                backtrack(openN, closedN + 1)
                s.pop()

        backtrack(0, 0)
        return res



s = Solution()
print(s.generateParenthesis(3))
