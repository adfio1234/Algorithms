T=int(input())
for t in range(T):
    ans=-1
    x,y=map(int,input().split())
    if x<10 and y<10:
        ans=x*y
    print(f"#{t+1} {ans}")