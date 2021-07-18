def find_substrings(s):
    for i in range(len(s)+1):
        for j in range(i+1,len(s)+1):
            subs = s[i:j]
            print(subs)

if __name__ == "__main__":
    s = input("Enter the string: ")
    find_substrings(s)