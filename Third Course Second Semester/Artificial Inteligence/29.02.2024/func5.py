def linear_merg(arr1, arr2):
    return sorted(arr1 + arr2)

print(linear_merg(['aa', 'xx', 'zz'], ['bb', 'cc']))
print(linear_merg(['aa', 'xx'], ['bb', 'cc', 'zz']))
print(linear_merg(['aa', 'aa'], ['aa', 'bb', 'bb']))