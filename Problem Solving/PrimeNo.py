# Cgeck if the n. is prime
# print the prime number

def is_prime(n):
    if n > 1:
        for i in range(2, n):
            if n % i == 0:
                return False
    return True

def print_prime(n):
    for i in range(2, n+1):
        if(is_prime(i)):
            print(i)

    
if __name__ == "__main__":
    n= int(input("Enter the number: "))
    # print(is_prime(n))
    print_prime(n)