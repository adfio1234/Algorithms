T=int(input())
for t in range(T):
    N=int(input())
    total=N
    tf=[False]*10
    while False in tf:
        
        tmp=list(str(total))
        for i in tmp:
            num=int(i)
            tf[num]=True
        total += N
    print(f"#{t+1} {total-N}")
