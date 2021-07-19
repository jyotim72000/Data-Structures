import random
def guess_human(actual_number, n):
    your_guess = 0
    low = 0
    high = n
    while(your_guess!= actual_number):
        your_guess = int(input("Guess the number: "))
        if low <= high:
            if your_guess > actual_number:
                high = your_guess-1
                print(f"Your guess {your_guess} is too high. Guess between ({low},{high})")
            elif your_guess < actual_number:
                low = your_guess + 1
                print(f"Your guess {your_guess} is too low. Guess between ({low},{high})")
            elif your_guess == actual_number:
                return your_guess

def guess_computer(actual, n):
    comp_guess = 0
    low = 0
    high = n
    while(comp_guess != actual):
        comp_guess = (low+high)//2
        print(f"computer guessed {comp_guess}")
        if low <= high:
            judge = input(f"If the guessed number is greater than the actual number type 'g' if smaller type 's' else type 'c': ")
            if judge == 'g':
                high= comp_guess-1
                print(f"Guessed number {comp_guess} is too high. Guessing between ({low},{high})")
            elif judge == 's':
                low = comp_guess + 1
                print(f"Guessed number {comp_guess} is too low. Guessing between ({low},{high})")
            elif judge == 'c':
                print(f"Correctly guessed the number !!! {comp_guess} is the actual number.")

if __name__ == "__main__":
    n = int(input("What would you like to be the max limit be: "))
    # actual_number = random.randint(0,n)
    # output = guess_human(actual_number, n)
    # print(f"Correct !!! {output} is the actual number.")

    actual_number = int(input(f"Enter the actual number bwtween 0,{n}: "))
    guess_computer(actual_number, n)