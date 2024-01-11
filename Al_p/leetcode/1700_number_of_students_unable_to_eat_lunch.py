import collections
from collections import deque
from typing import List


class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        i = 0
        students, sandwiches = deque(students), deque(sandwiches)

        while students and i < len(students):
            s = students.popleft()
            if s != sandwiches[0]:
                students.append(s)
                i += 1
            else:
                sandwiches.popleft()
                i = 0

        return len(students)


class MoreSmartAndEfficientSolution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        st_count = collections.Counter(students)
        n, k = len(students), 0
        while k < n and st_count[sandwiches[k]]:
            st_count[sandwiches[k]] -= 1
            k += 1
        return n - k


# we don't care that students are moving, we only care whether this sandwich will be taken by someone or not. If not -> everyone is stuck

print(MoreSmartAndEfficientSolution().countStudents(students=[1, 1, 1, 0, 0, 1], sandwiches=[1, 0, 0, 0, 1, 1]))
