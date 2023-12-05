import re

RED_REGEXP = r"(\d+)\sred"
GREEN_REGEXP = r"(\d+)\sgreen"
BLUE_REGEXP = r"(\d+)\sblue"

color_regex = [RED_REGEXP, GREEN_REGEXP, BLUE_REGEXP]
res = 0

for game in open("2_cube_conundrum.txt", "r"):
    power = 1
    for regex in color_regex:
        max_c = max(map(int, re.findall(regex, game)))
        power *= max_c
    res += power

print(res)  # 78111

# Shorten version
# def pow_color(game):
#     return functools.reduce(lambda x, y: x * max(map(int, re.findall(y, game))), color_regex, 1)
#
# print(sum(map(pow_color, open('2_cube_conundrum.txt'))))
