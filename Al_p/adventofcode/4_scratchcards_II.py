# start_time = time.time()
#
# res = 0
# cards = dict()  # {<card number> -> [<matches_n>,<card_n>]}
# processed_cards = dict()
#
# for card in open("4_scratchcards.txt", "r"):
#     card_no = re.search('Card\s+(\d+)', card).group(1)
#     card = card.split(":")[1].strip()
#     winning_nums, your_nums = [set(n.split()) for n in card.split("|")]
#     intersection_len = len(winning_nums & your_nums)
#     cards[int(card_no)] = [intersection_len, 1]
#
# card_no = 1
# while cards:
#     matches_n, card_n = cards[card_no]
#     for copy in range(card_no + 1, card_no + matches_n + 1):
#         if copy in cards:
#             copy_matches_n, copy_card_n = cards[copy]
#             cards[copy] = [copy_matches_n, copy_card_n + 1]
#
#     cards[card_no] = [matches_n, card_n - 1]
#     processed_cards[card_no] = processed_cards.get(card_no, 0) + 1
#     if cards[card_no][1] == 0:
#         cards.pop(card_no)
#         card_no += 1
#
# print(f'Sum: {sum(processed_cards.values())}')  # 18846301
# print(f"Time: {time.time() - start_time}")  # ~10 sec
# How to make it run not for 10 sec?

res = {}

for i, card in enumerate(open("4_scratchcards.txt", "r")):  # (O(n))
    if i not in res:
        res[i] = 1
    card = card.split(":")[1].strip()  # O(m), where m - max len of card
    winning_nums, your_nums = [set(n.split()) for n in card.split("|")]
    intersection_len = len(winning_nums & your_nums)  # O(min(len(winning_nums), len(your_nums)) = O(m')

    for n in range(i + 1, i + intersection_len + 1):  # O(m''), m'' - max numbers of copies
        res[n] = res.get(n, 1) + res[i]

print(sum(res.values()))

# O(n * (m + m' + m''))
