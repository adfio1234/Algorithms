def findNode(L,arr):
    if L==0:
        return 0
    if arr[L]==0:
        left=L*2
        right=left+1

        if left>=len(arr):
            left=0
            right=0
        if right>=len(arr):
            right=0
        arr[L]=findNode(left,arr)+findNode(right,arr)
    return arr[L]
T=int(input())
for t in range(T):
    N,M,L=map(int,input().split())
    arr=[0]*(N+1)
    for _ in range(M):
        node,val=map(int,input().split())
        arr[node]=val
    print(f"#{t+1} {findNode(L,arr)}")
