import re

with open("6_wait_for_it.txt") as f:
    lines = f.readlines()
    time, distance = [int(re.sub("\s", "", lines[i].split(":")[1])) for i in range(2)]
    win = len(list(filter(lambda x: (x * (time - x) > distance), [x for x in range(1, time + 1)])))

print(win)
