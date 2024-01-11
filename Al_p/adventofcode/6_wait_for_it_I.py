with open("6_wait_for_it.txt") as f:
    lines = f.readlines()
    time, distance = [list(map(int, lines[i].split(":")[1].split())) for i in range(2)]
    res = 1
    for i in range(len(time)):
        win = 0
        for j in range(1, time[i] + 1):
            if j * (time[i] - j) > distance[i]:
                win += 1
        res *= win

print(res)
