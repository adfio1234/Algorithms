def findPattern(lst):
    for i in range(1,10+1):
        if lst[:i]==lst[i:2*i]:
            return i
T=int(input())
for t in range(T):
    lst=list(input())
    print(f"#{t+1} {findPattern(lst)}")