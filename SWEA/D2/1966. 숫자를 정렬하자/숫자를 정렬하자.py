T=int(input())
for t in range(T):
    N=int(input())
    lst=list(map(int,input().split()))
    lst.sort()
    print(f"#{t+1} ",end="")
    for i in lst:
        print(f"{i} ",end="")
    print()
    