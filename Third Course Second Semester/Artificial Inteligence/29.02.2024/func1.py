def match_ends(arr):
    count = 0
    for i in arr:
        if(len(i) >= 2 and i.endswith(i[0])):
            count += 1
    print(count)

match_ends(['aba', 'xyz', 'aa', 'x', 'bbb'])
match_ends(['', 'x', 'xy', 'xyx', 'xx'])
match_ends(['aaa', 'be', 'abc', 'hello'])