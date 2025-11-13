def selectPocket(N,K,pocket):
    pocket.sort()
    minDiff=float('inf')
    for i in range(len(pocket)-K+1):
        minDiff=min(minDiff,pocket[K+i-1]-pocket[i])
    return minDiff
T=int(input())
for t in range(T):
    N,K=map(int,input().split())
    pocket=list(map(int,input().split()))
    print(f"#{t+1} {selectPocket(N,K,pocket)}")
