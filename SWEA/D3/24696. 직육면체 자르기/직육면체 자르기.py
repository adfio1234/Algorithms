T=int(input())
for _ in range(T):
    ans=2
    x,y,z=map(int,input().split())
    if ((x-1)+(x*(y-1))+(x*y*(z-1)))%2:
        ans=1
    print(f"{ans}")