def total_water_stored(arr):
    rain_trapped = 0  
    water_store = 0   

    for i in range(1, len(arr)-1):
        left_bound = arr[i]
        right_bound = arr[i]

        for l in range(0,i):
            left_bound = max(arr[l], left_bound)

        for r in range(i+1,len(arr)):
            right_bound = max(arr[r], right_bound)

        water_store = min(left_bound, right_bound) - arr[i]

        rain_trapped += water_store
    print(rain_trapped)

if __name__ == "__main__":
    arr = [int(item) for item in input("Enter the array: ").split()]
    total_water_stored(arr)
