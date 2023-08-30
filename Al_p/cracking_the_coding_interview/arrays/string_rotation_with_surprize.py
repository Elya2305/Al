# String Rotation:Assumeyou have a method isSubstringwhich checks if oneword is a substring
# of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
# call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").

def rotate_string_mind_blowing(s: str, goal: str) -> bool:
    return goal in s + s and len(s) == len(goal)


print(rotate_string_mind_blowing("waterbottle", "erbottlewat"))
