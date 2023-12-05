f = open("1_trebuchet.txt", "r")

nums = []

for line in f:
    value = line.strip()
    start, end = 0, len(value) - 1
    f_digit, l_digit = None, None

    while not f_digit or not l_digit:
        if not f_digit:
            candidate = value[start]
            if candidate.isdigit():
                f_digit = candidate
            else:
                start += 1
        if not l_digit:
            candidate = value[end]
            if candidate.isdigit():
                l_digit = candidate
            else:
                end -= 1

    nums.append(int(f_digit + l_digit))

print(sum(nums))  # 55607
