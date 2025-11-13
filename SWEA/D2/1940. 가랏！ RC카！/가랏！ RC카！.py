T=int(input())
for t in range(T):
    N=int(input())
    speed=0
    distance=0
    for _ in range(N):
        arr=list(map(int,input().split()))
        if arr[0]==1:
            speed+=arr[1]
        elif arr[0]==2:
            if (speed-arr[1])>0:
                speed-=arr[1]
            else:
                speed=0
        distance+=speed
    print(f"#{t+1} {distance}")