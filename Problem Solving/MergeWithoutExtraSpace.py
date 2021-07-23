def merge(arr1, arr2, n, m):
    a = arr1 + arr2
    a.sort()
    arr1[:] = a[:n]
    arr2[:] = a[n:]


if __name__=="__main__":
    # n,m = map(int, input().strip().split())
    arr1 = [int(list) for list in input().split(" ")]
    arr2 = [int(list) for list in input().split(" ")]
    n= len(arr1)
    m= len(arr2)
    merge(arr1, arr2, n, m)
    print(*arr1,end=" ")
    print(*arr2)