def distance(arr,idx):
    dist=0
    arr=arr[:idx]+arr[idx+1:]
    for i in range(len(arr)-1):
        dist+=abs(arr[i]-arr[i+1])

    return dist

def leastMove(arr):
    min=float('inf')
    for i in range(1,len(arr)-1):
        min=min if min<distance(arr,i) else distance(arr,i)
    return min

T=int(input())
for t in range(T):
    N=int(input())
    checkPoint=list(map(int,input().split()))
    print(f"{leastMove(checkPoint)}")