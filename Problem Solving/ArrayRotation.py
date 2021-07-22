import array
def rotation(arr, d):
    for _ in range(d):
        temp = arr[0]
        arr.pop(0)
        arr.append(temp)
    print_array(arr)

def rotate(arr, d):
    arr.extend(arr[:d])
    del(arr[:d])
    print_array(arr)


def print_array(arr):
    for i in arr:
        print(i, end=" ")

if __name__ == "__main__":
    arr = array.array('i', [1, 2, 3, 4, 5, 6, 7])
    d = int(input("How many rotations: "))
    rotation(arr, d)
    rotate(arr, d)