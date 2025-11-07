def squarePalindrome(A,B):
    rangeAnswer=[1,4,9,121,484]
    result=0
    for i in rangeAnswer:
        if i>=A and i<=B:
            result+=1
    return result

T=int(input())
for t in range(T):
    A,B=map(int,input().split())
    print(f"#{t+1} {squarePalindrome(A,B)}")