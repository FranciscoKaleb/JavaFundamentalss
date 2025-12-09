
import random

# Create a list of 100,000 integers
arr_length = 50000
arr = [random.randint(0, 1000000) for _ in range(arr_length)]
print('done generating random numbers')

def bubble_sort(arr):
    n = len(arr)
    # Traverse through all array elements
    for i in range(n - 1):
        # Last i elements are already in place, so we don't need to check them
        # This optimization reduces the inner loop's range in subsequent passes
        for j in range(n - i - 1):
            # Traverse the array from 0 to n-i-1
            # Swap if the element found is greater than the next element
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


import time

start_time1 = time.time()
bubble_sort(arr)
end_time1 = time.time()

elapsed_time1 = end_time1 - start_time1

print(elapsed_time1)