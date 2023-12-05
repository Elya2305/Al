f = open("1_trebuchet.txt", "r")
# f = ['seventwonineseven27jbrqpxfx8']
# f = ['seventwonineseven']

nums = []

wordsToNums = {"one": "1", "two": "2", "three": "3", "four": "4", "five": "5", "six": "6", "seven": "7", "eight": "8",
               "nine": "9"}
counter = 1

for line in f:
    digits = []

    value = line.strip()
    i, j = 0, 0
    l_digit = ""

    while True:
        if l_digit in wordsToNums:  # if we found a word
            digits.append(wordsToNums[l_digit])
            l_digit = ""
            i = j = j - 1
        if j >= len(value):
            break
        elif value[j].isdigit():  # if it's a digit
            digits.append(value[j])
            i += 1
            j += 1
        else:  # if we're searching
            match = False
            for w in wordsToNums.keys():
                if j - i < len(w) and w[j - i] == value[j]:
                    match = True
                    break
            if match:
                l_digit += value[j]
                j += 1
            else:
                i = j = i + 1
                l_digit = ""

    print(counter, digits, digits[0] + digits[-1])
    nums.append(int(digits[0] + digits[-1]))
    counter += 1

print(sum(nums))  # 55358
