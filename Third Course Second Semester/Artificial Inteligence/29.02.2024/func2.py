def front_x(arr):
    arr2 = [word for word in arr if word.startswith("x")]
    arr3 = [word for word in arr if word.startswith("x") == False]
    arr2.sort()
    arr3.sort()
    arr = arr2 + arr3
    print(arr)

front_x(['bbb', 'ccc', 'axx', 'xzz', 'xaa'])
front_x(['ccc', 'bbb', 'aaa', 'xcc', 'xaa'])
front_x(['mix', 'xyz', 'apple', 'xanadu', 'aardvark'])