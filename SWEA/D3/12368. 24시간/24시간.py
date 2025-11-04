T=int(input())
for t in range(T):
    x,y=map(int,input().split())
    print(f"#{t+1} {(x+y)%24}")