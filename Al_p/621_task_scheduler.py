import heapq
from collections import deque, Counter
from typing import List


class BadSolutionThatSometimesDoesntWork:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        taskToNumber = dict()
        for taskI in tasks:
            taskToNumber[taskI] = taskToNumber.get(taskI, 0) + 1

        sortedTasks = sorted([[v, k] for k, v in taskToNumber.items()], reverse=True)
        perm = []
        taskI = 0
        lastUsedTasks = {}
        while sortedTasks:
            amount, task = sortedTasks[taskI]
            if lastUsedTasks.get(task) is not None and len(perm) <= lastUsedTasks.get(task) + n:
                perm.append("")
            else:
                perm.append(task)
                lastUsedTasks[task] = len(perm) - 1
                if amount == 1:
                    sortedTasks.pop(taskI)
                else:
                    sortedTasks[taskI] = [amount - 1, task]
                taskI = taskI + 1 if taskI + 1 < len(sortedTasks) else 0

        print(perm)
        return len(perm)


class SolutionWithMaxHeap:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        maxHeap = [-cnt for cnt in count.values()]
        heapq.heapify(maxHeap)

        q = deque()
        time = 0
        while maxHeap or q:
            time += 1

            if maxHeap:
                cnt = 1 + heapq.heappop(maxHeap)
                if cnt:
                    q.append([cnt, time + n])

            if q and q[0][1] == time:
                heapq.heappush(maxHeap, q.popleft()[0])

        return time


s = SolutionWithMaxHeap()
tasks = ["A","A","A","B","B","B"]
n = 2
print(s.leastInterval(tasks, n))
