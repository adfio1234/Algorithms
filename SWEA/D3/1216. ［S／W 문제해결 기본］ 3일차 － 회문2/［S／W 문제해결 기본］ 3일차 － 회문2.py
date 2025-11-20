def findPalindrome(string):
    for i in range(len(string),-1,-1):
        for j in range(len(string)-i+1):
            tmp=string[j:i+j]
            if tmp==tmp[::-1]:
                #print(tmp,i)
                return i
    return 1
for _ in range(10):
    T = int(input())
    arr=[]
    maxLength=0
    for i in range(100):
        tmp=list(input())
        arr.append(tmp)
        maxLength=max(maxLength,findPalindrome("".join(tmp)))
    transpose=list(map(list,zip(*arr)))

    for i in transpose:
        maxLength=max(maxLength,findPalindrome("".join(i)))
    print(f"#{T} {maxLength}")
