def sort_fn(val):
    return val[1]

def sortTuples(tuples):
    tuples.sort(key = sort_fn)
    print(tuples)

sortTuples([(1, 3), (3, 2), (2, 1)])
sortTuples([(2, 3), (1, 2), (3, 1)])
sortTuples([(1, 7), (1, 3), (3, 4, 5), (2, 2)])