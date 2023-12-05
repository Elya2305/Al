res = 0

for card in open("4_scratchcards.txt", "r"):
    card = card.split(":")[1].strip()
    winning_nums, your_nums = [set(n.split()) for n in card.split("|")]
    intersection_len = len(winning_nums & your_nums)
    if intersection_len > 0:
        res += 2 ** (intersection_len - 1)

print(res)  # 24175
