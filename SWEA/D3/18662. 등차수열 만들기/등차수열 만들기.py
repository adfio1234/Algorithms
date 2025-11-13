T=int(input())
for t in range(T):
    x,y,z=map(int,input().split())

    print(f"#{t+1} {abs(y-((x+z)/2))}")