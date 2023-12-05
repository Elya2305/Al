from collections import deque
from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        s = deque()
        operators = {"+": add, "-": sub, "*": mul, "/": div}

        for c in tokens:
            if c in operators:
                b = s.pop()
                a = s.pop()
                res = operators[c](int(a), int(b))
                s.append(res)
            else:
                s.append(c)

        return int(s.pop())


def add(a, b):
    return a + b


def sub(a, b):
    return a - b


def mul(a, b):
    return a * b


def div(a, b):
    return int(a / b)


print(Solution().evalRPN(["4","13","5","/","+"]))