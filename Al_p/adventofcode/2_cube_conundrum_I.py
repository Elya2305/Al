import re

RED = 12
GREEN = 13
BLUE = 14

RED_REGEXP = r"(\d+)\sred"
GREEN_REGEXP = r"(\d+)\sgreen"
BLUE_REGEXP = r"(\d+)\sblue"

colors = [[RED, RED_REGEXP], [GREEN, GREEN_REGEXP], [BLUE, BLUE_REGEXP]]
res = 0
for game in open("2_cube_conundrum.txt", "r"):
    possible = True
    for game_set in game.split(";"):
        if not possible:
            break
        for c in colors:
            limit, regexp = c
            match = re.search(regexp, game_set)
            if match and int(match.group(1)) > limit:
                possible = False
                break
    if possible:
        game_n = re.search("Game (\d+)", game).group(1)
        res += int(game_n)

print(res)
# time complexity -- O(N * M * K), where K is the length of the longest set string in a game ?
