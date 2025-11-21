T=int(input())
for t in range(T):
    N,M=map(int,input().split())
    ans=0
    weights=list(map(int,input().split()))
    truckWeight=list(map(int,input().split()))
    truckWeight.sort(reverse=True)
    weights.sort(reverse=True)
    idx=0
    for i in range(len(weights)):
        if idx>=len(truckWeight):
            break
        if truckWeight[idx]>=weights[i]:
            ans+=weights[i]
            idx+=1
        elif truckWeight[idx]<weights[i]:
            continue
    print(f"#{t+1} {ans}")