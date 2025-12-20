import heapq
N=1
count=1
while N!=0:
    N=int(input())
    if N==0:
        break
    graph = []
    dx=[1,-1,0,0]
    dy=[0,0,1,-1]
    dist=[[float('inf')]*N for _ in range(N)]
    pq=[]
    for i in range(N):
        tmp=list(map(int,input().split()))
        graph.append(tmp)
    dist[0][0]=graph[0][0]
    heapq.heappush(pq,(graph[0][0],0,0))

    while pq:
        cost,x,y=heapq.heappop(pq)
        if cost>dist[y][x]:
            continue
        for i in range(4):
            nx,ny=x+dx[i], y+dy[i]
            if 0<=nx<N and 0<=ny<N:
                new_cost=cost+graph[ny][nx]
                if new_cost<dist[ny][nx]:
                    dist[ny][nx]=new_cost
                    heapq.heappush(pq,(new_cost,nx,ny))
    print(f"Problem {count}: {dist[N-1][N-1]}")
    count+=1

