T=int(input())
for t in range(T):
    N,M,L=map(int,input().split())
    arr=list(map(int,input().split()))

    for _ in range(M):
        idx,num=map(int,input().split())
        front=arr[:idx]
        back=arr[idx:]

        arr=front+[num]+back
    print(f"#{t+1} {int(arr[L])}")