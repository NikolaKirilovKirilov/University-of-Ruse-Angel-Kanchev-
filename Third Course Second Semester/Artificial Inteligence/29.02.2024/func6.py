def both_ends(string):
    if(len(string) > 2):
        return string[:2] + string[-2:]
    else:
        return ""

print(both_ends("spring"))
print(both_ends("Hello"))
print(both_ends("a"))
print(both_ends("xyz"))