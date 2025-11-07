T=int(input())
for _ in range(T):
    floor=0
    N,P=map(int,input().split())
    for i in range(1,N+1):
        floor+=i
        if floor==P:
            floor-=1
    print(floor)