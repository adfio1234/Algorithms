def searchPalindrome(length,arr):
    total=0
    for i in arr:
        for j in range(len(i)-length+1):
            tmp=i[0+j:length+j]
            if tmp==tmp[::-1]:
                total+=1
    return total
for t in range(10):
    length=int(input())
    arr=[]
    ans=0
    for _ in range(8):
        tmp=input()
        arr.append(tmp)
    transpose=list(map(list,zip(*arr)))
    ans += searchPalindrome(length, arr)
    ans+=searchPalindrome(length,transpose)
    print(f"#{t+1} {ans}")