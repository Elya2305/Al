# O(n)? S(n)
def is_unique(str) -> bool:
    if len(str) > 128:  # if we assume that it's ASCII
        return False
    charset = set(str)
    return len(charset) == len(str)


# O(nlog(n)) S(n)
def is_unique_without_datastructure(str) -> bool:
    if len(str) < 1:
        return True
    sorted_str = sorted(str)
    prev = sorted_str[0]

    for i in range(1, len(sorted_str)):
        if sorted_str[i] == prev:
            return False
        prev = sorted_str[i]
    return True


print(is_unique_without_datastructure("mama"))
print(is_unique_without_datastructure("abc"))
