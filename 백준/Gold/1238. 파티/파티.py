import heapq
#N 마을의 수 M엣지수 X도착마을
N,M,X=map(int,input().split())
villageToX=[[] for _ in range(N+1)]
villageFromX=[[] for _ in range(N+1)]
for i in range(M):
    start,end,time=map(int,input().split())
    villageToX[start].append((end,time))
    villageFromX[end].append((start, time))
def dijkstra(start,graph):
    dist=[float('inf')]*(N+1)
    dist[start]=0
    hq=[(0,start)]

    while hq:
        cost,cur=heapq.heappop(hq)
        if dist[cur]<cost:
            continue
        for target,time in graph[cur]:
            if dist[target]>cost+time:
                dist[target]=cost+time
                heapq.heappush(hq,(dist[target],target))
    return dist
distToX=dijkstra(X,villageToX)
distFromX=dijkstra(X,villageFromX)
ans=0
for i in range(1,len(distToX)):
    ans=max(ans, distToX[i]+distFromX[i])
print(ans)