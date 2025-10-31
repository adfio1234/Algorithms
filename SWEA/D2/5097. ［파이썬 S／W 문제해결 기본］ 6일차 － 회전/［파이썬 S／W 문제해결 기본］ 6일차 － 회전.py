T=int(input())
for t in range(T):
    N,count=map(int,input().split())
    arr=list(map(int,input().split()))
    
    print(f"#{t+1} {arr[count%N]}")