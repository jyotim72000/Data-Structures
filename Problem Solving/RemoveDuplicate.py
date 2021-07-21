def remove(arr):

    # arr1 = []
    # arr.sort()
    # for i in range(len(arr)-1):
    #     if arr[i] == arr[i+1]:
    #         continue
    #     else:
    #         arr1.append(arr[i])
    # arr1.append(arr[len(arr)-1])
    # arr
    # arr = arr1
    # return len(arr1)



    # arr1 = [arr[0]]
    # for i in range(1,len(arr)):
    #     var = False
    #     for j in reversed(arr1):
    #         if arr[i] == j:
    #             var = True
    #             break
    #     if var == False:
    #         arr1.append(arr[i])
    # return arr1

    for i in range(len(arr)-1):
        if arr[i] == arr[i+1]:
            arr.pop(i+1)
            i -= 1
    return arr


   

if __name__ == "__main__":
    arr = [int(list) for list in input("Enter array: ").split(" ")]
    output = remove(arr)
    print(output)

